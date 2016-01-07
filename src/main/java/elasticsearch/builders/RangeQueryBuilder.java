package elasticsearch.builders;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import elasticsearch.utils.SearchRequest;

public class RangeQueryBuilder implements AbstractRequestBuilder {

    @Override
    public MultiSearchRequestBuilder query(Client client, SearchRequest request) {
        MultiSearchRequestBuilder multiSearchRequestBuilder = client.prepareMultiSearch();
        SearchRequestBuilder bldr1 = client.prepareSearch();
        QueryBuilder filteredBuilder = QueryBuilders.rangeQuery("TemperatureHighF").from(70).to(80);
        bldr1.setQuery(QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(), filteredBuilder))
                .setSize(20);
        multiSearchRequestBuilder.add(bldr1);
        System.out.println(bldr1.toString());
        return multiSearchRequestBuilder;
    }

}
