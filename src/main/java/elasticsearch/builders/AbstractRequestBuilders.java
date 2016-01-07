package elasticsearch.builders;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractRequestBuilders {

    static Map<String, AbstractRequestBuilder> requestBuilders;

    static {
        requestBuilders = new ConcurrentHashMap<String, AbstractRequestBuilder>();
        requestBuilders.put("filterByName", new CustomerNameFilterBuilder());
        requestBuilders.put("rangeByTemperatureHighF", new RangeQueryBuilder());
        requestBuilders.put("statsTemperatureHighAggregation", new StatsHighTemperatureByMonth());
    }

    public static Map<String, AbstractRequestBuilder> getRequestBuilders() {
        return requestBuilders;
    }

    public static void setRequestBuilders(Map<String, AbstractRequestBuilder> requestBuilders) {
        AbstractRequestBuilders.requestBuilders = requestBuilders;
    }

}
