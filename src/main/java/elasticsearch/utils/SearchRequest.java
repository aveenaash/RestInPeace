package elasticsearch.utils;

import java.util.HashMap;

public class SearchRequest {

    public HashMap<String, String> requestParams;

    public SearchRequest() {
        requestParams = new HashMap<String, String>();
    }

    public boolean hasParameter(String _param) {
        return requestParams.containsKey(_param) && !requestParams.get(_param).isEmpty();
    }

    public String get(String _param) {
        return requestParams.get(_param);
    }
}
