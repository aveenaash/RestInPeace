package elasticsearch.listeners;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractActionListeners {

    static Map<String, AbstractActionListener> actionListeners;
    static {
        actionListeners = new ConcurrentHashMap<String, AbstractActionListener>();
        // requestBuilders.put("filterByName", new CustomerNameFilterBuilder());
        // requestBuilders.put("rangeByTemperatureHighF", new RangeQueryBuilder());
        actionListeners.put("statsTemperatureHighAggregation", new StatsTemperatureHighAggListener());
    }

    public static Map<String, AbstractActionListener> getActionListeners() {
        return actionListeners;
    }

    public static void setActionListeners(Map<String, AbstractActionListener> actionListeners) {
        AbstractActionListeners.actionListeners = actionListeners;
    }

}
