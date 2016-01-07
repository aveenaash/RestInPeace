package elasticsearch.listeners;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.io.IOException;

import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.search.aggregations.bucket.range.Range;
import org.elasticsearch.search.aggregations.metrics.stats.Stats;

public class StatsTemperatureHighAggListener extends AbstractActionListener {

    @Override
    public void onResponse(MultiSearchResponse response) {
        super.onResponse(response);
    }

    @Override
    public void onFailure(Throwable e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        // TODO Auto-generated method stub

    }

    @Override
    public void processSearchResponse(MultiSearchResponse multiSearchResponse) {
        MultiSearchResponse.Item[] responseItems = multiSearchResponse.getResponses();
        MultiSearchResponse.Item item1 = responseItems[0];
        SearchResponse countResponse = item1.getResponse();
        processCounts(countResponse);
    }

    @Override
    public XContentBuilder processCounts(SearchResponse aggsResponse) {
        try {
            xcontent = jsonBuilder();
            xcontent.startObject();
            Range rangeAgg = aggsResponse.getAggregations().get("rangeAggs");
            System.out.println("I am here ===>" + rangeAgg.getBuckets().size());
            for (Range.Bucket entry : rangeAgg.getBuckets()) {
                String key = entry.getKeyAsString(); // Range as key
                xcontent.startObject(key);
                Stats stats = entry.getAggregations().get("statsAggs");
                xcontent.field("Max", stats.getMax());
                xcontent.field("Avg", stats.getAvg());
                xcontent.endObject();
            }
            xcontent.endObject();
            System.out.println(xcontent.bytes().toUtf8());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xcontent;
    }

}
