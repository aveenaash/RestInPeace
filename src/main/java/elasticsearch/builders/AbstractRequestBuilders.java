package elasticsearch.builders;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractRequestBuilders {

    static Map<String, AbstractRequestBuilder> requestBuilders;

    static {
        requestBuilders = new ConcurrentHashMap<String, AbstractRequestBuilder>();
        requestBuilders.put("filterByName", new CustomerNameFilterBuilder());
    }

    public static Map<String, AbstractRequestBuilder> getRequestBuilders() {
        return requestBuilders;
    }

    public static void setRequestBuilders(Map<String, AbstractRequestBuilder> requestBuilders) {
        AbstractRequestBuilders.requestBuilders = requestBuilders;
    }

}
