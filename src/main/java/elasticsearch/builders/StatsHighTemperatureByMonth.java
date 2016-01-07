package elasticsearch.builders;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.aggregations.AggregationBuilders;

import elasticsearch.utils.SearchRequest;

public class StatsHighTemperatureByMonth implements AbstractRequestBuilder {

    @Override
    public MultiSearchRequestBuilder query(Client client, SearchRequest request) {
        MultiSearchRequestBuilder multiSearchRequestBuilder = client.prepareMultiSearch();

        SearchRequestBuilder bldr = client.prepareSearch();
        bldr.addAggregation(AggregationBuilders.range("rangeAggs").field("TemperatureHighF")
                .addUnboundedTo(40)
                .addRange(40, 60)
                .addUnboundedFrom(60)
                .subAggregation(AggregationBuilders.stats("statsAggs").field("HumidityAvg")));
        multiSearchRequestBuilder.add(bldr);
        System.out.println("SearchRequestBuilder  ===>" + bldr.toString());
        return multiSearchRequestBuilder;
    }

}
