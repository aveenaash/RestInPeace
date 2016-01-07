package elasticsearch.listeners;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.search.aggregations.Aggregation;

public class AbstractActionListener implements ActionListener<MultiSearchResponse> {
    
    private boolean processCompleted;
    protected XContentBuilder xcontent;

    AbstractActionListener()
    {

    }

    public XContentBuilder getXcontent() {
        return xcontent;
    }

    public void setXcontent(XContentBuilder xcontent) {
        this.xcontent = xcontent;
    }

    public boolean isProcessCompleted() {
        return processCompleted;
    }

    public void setProcessCompleted(boolean processCompleted) {
        this.processCompleted = processCompleted;
    }

    public void render() {
        
    }

    @Override
    public void onResponse(MultiSearchResponse response) {
        try {
            processSearchResponse(response);
        } catch (Exception e) {
            onFailure(e);
        }
    }

    public void processSearchResponse(MultiSearchResponse multiSearchResponse) {
            MultiSearchResponse.Item[] responseItems = multiSearchResponse.getResponses();
            MultiSearchResponse.Item item1 = responseItems[0];
            SearchResponse countResponse = item1.getResponse();
            processCounts(countResponse);
    }

    public XContentBuilder processCounts(SearchResponse aggsResponse) {
        XContentBuilder xcontent = null;
        try {
            xcontent = jsonBuilder();
            List<Aggregation> aggList = aggsResponse.getAggregations().asList();
            for (Aggregation a : aggList)
                System.out.println("Agg ==> " + a.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xcontent;
    }

    @Override
    public void onFailure(Throwable e) {
        // TODO Auto-generated method stub

    }
}
