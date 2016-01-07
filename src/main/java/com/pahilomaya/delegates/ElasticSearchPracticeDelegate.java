package com.pahilomaya.delegates;

import java.net.UnknownHostException;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;

import elasticsearch.builders.AbstractRequestBuilders;
import elasticsearch.service.StatsTemperatureHighAggregationService;
import elasticsearch.utils.ESConnector;
import elasticsearch.utils.SearchRequest;

public class ElasticSearchPracticeDelegate {

    public ElasticSearchPracticeDelegate() {

    }

    public MultiSearchResponse.Item[] getSearchByCustomerNameresponse(SearchRequest searchRequest) throws UnknownHostException {
        MultiSearchRequestBuilder builder = AbstractRequestBuilders.getRequestBuilders().get("filterByName")
                .query(ESConnector.getClient(), searchRequest);

        MultiSearchResponse sr = builder.execute().actionGet();
        MultiSearchResponse.Item[] items = sr.getResponses();
        for (MultiSearchResponse.Item item : items) {
            System.out.println("" + item.getResponse().toString());
        }
        return items;

    }

    public MultiSearchResponse.Item[] getFilteredQuery(SearchRequest searchRequest) throws UnknownHostException {
        MultiSearchRequestBuilder builder = AbstractRequestBuilders.getRequestBuilders().get("rangeByTemperatureHighF")
                .query(ESConnector.getClient(), searchRequest);

        MultiSearchResponse sr = builder.execute().actionGet();
        MultiSearchResponse.Item[] items = sr.getResponses();
        System.out.println("Items ====> ");
        for (MultiSearchResponse.Item item : items) {
            System.out.println("" + item.getResponse().toString());
        }
        return items;
    }

    public XContentBuilder statsHighTemperatureByMonth(SearchRequest searchRequest) throws Exception {
        StatsTemperatureHighAggregationService serv = new StatsTemperatureHighAggregationService(searchRequest);
        serv.getSearchResponse();
        return serv.getActionListener().getXcontent();
    }

}
