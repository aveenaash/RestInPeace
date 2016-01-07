package elasticsearch.service;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;

import elasticsearch.builders.AbstractRequestBuilder;
import elasticsearch.builders.AbstractRequestBuilders;
import elasticsearch.listeners.AbstractActionListener;
import elasticsearch.listeners.AbstractActionListeners;
import elasticsearch.utils.ESConnector;
import elasticsearch.utils.SearchRequest;

public class StatsTemperatureHighAggregationService {

    private SearchRequest searchRequest;
    private AbstractActionListener actionListener;
    private AbstractRequestBuilder requestBuilder;

    public StatsTemperatureHighAggregationService(SearchRequest searchRequest)
    {
        this.searchRequest = searchRequest;
        this.actionListener = AbstractActionListeners.getActionListeners().get("statsTemperatureHighAggregation");
        this.requestBuilder = AbstractRequestBuilders.getRequestBuilders().get("statsTemperatureHighAggregation");
    }

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    public AbstractActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(AbstractActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public AbstractRequestBuilder getRequestBuilder() {
        return requestBuilder;
    }

    public void setRequestBuilder(AbstractRequestBuilder requestBuilder) {
        this.requestBuilder = requestBuilder;
    }

    public String getSearchResponse() throws Exception
    {
        MultiSearchRequestBuilder builder = requestBuilder.query(ESConnector.getClient(), searchRequest);
        try {
            Thread thread = new Thread(new RequestBuilderExecutor(builder, actionListener));
            thread.start();

            while (!actionListener.isProcessCompleted()) {
                Thread.currentThread().sleep(100);
            }
        } catch (Exception e) {
            actionListener.setProcessCompleted(true);
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    static class RequestBuilderExecutor implements Runnable {
        MultiSearchRequestBuilder builder;
        AbstractActionListener actionListener;

        public RequestBuilderExecutor(MultiSearchRequestBuilder builder, AbstractActionListener listener) {
            this.builder = builder;
            this.actionListener = listener;
        }

        @Override
        public void run() {
            try {
                builder.execute(actionListener);
                actionListener.setProcessCompleted(true);
            } catch (Exception e) {
                actionListener.setProcessCompleted(true);
                e.printStackTrace();
            }
        }
    }
}
