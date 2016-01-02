package com.pahilomaya.restService;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.elasticsearch.action.search.MultiSearchResponse;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.pahilomaya.delegates.ElasticSearchPracticeDelegate;

import elasticsearch.utils.SearchRequest;

@Path("/elasticsearch")
public class ElasticSearchPractice {

    private final String INDEX = "meroelastisearch";
    private final String DOCUMENT = "Customer";
    private final String KEYFIELD = "firstName";
    private final Provider<ElasticSearchPracticeDelegate> elasticSearchPracticeDelegate;

    @Inject
    public ElasticSearchPractice(Provider<ElasticSearchPracticeDelegate> elasticSearchPracticeDelegate) {
        this.elasticSearchPracticeDelegate = elasticSearchPracticeDelegate;
    }

    @Path("/filterByName")
    @POST
    public MultiSearchResponse.Item[] filterBuilderByName(@Context HttpServletRequest httpRequest) throws UnknownHostException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.requestParams.put("index", INDEX);
        searchRequest.requestParams.put("keyField", KEYFIELD);
        return elasticSearchPracticeDelegate.get().getSearchByCustomerNameresponse(searchRequest);

    }
}
