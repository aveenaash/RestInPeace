package elasticsearch.builders;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;

import elasticsearch.utils.SearchRequest;

public class CustomerNameFilterBuilder implements AbstractRequestBuilder {

    @Override
    public MultiSearchRequestBuilder query(Client client, SearchRequest request) {
        MultiSearchRequestBuilder multiSearchRequestBuilder = client.prepareMultiSearch();
        SearchRequestBuilder srb1 = client.prepareSearch();
        srb1.setQuery(QueryBuilders.queryStringQuery("fictional"));
        // .setSize(1);
        multiSearchRequestBuilder.add(srb1);
        return multiSearchRequestBuilder;
    }
}
