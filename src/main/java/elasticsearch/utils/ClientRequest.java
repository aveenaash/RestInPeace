package elasticsearch.utils;

import org.elasticsearch.common.xcontent.XContentBuilder;

public class ClientRequest {

    public long time;
    public int requestSize;
    public boolean filterByValue;
    public String keyField;
    public double value;
    public SearchRequest request;
    public XContentBuilder contentBuilder;
    // public Map<String, AbstractAnalyticsActionListener.ResponseRecord> recordsMap;
    // public Map<String, AbstractAnalyticsActionListener.ResponseRecord> oldRecordsMap;
    public String[] types; // recordTypes (eg "Customer", "Transaction")

}
