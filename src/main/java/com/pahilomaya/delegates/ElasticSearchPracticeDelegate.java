package com.pahilomaya.delegates;

import java.net.UnknownHostException;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.MultiSearchResponse;

import elasticsearch.builders.AbstractRequestBuilders;
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
}
