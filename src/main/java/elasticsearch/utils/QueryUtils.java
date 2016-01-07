package elasticsearch.utils;

import org.apache.lucene.queryparser.xml.FilterBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;

import com.sun.jersey.api.client.ClientRequest;

public class QueryUtils {

    public static String INDEX_NAME = "weatherinfo";// "meroelasticserach";

    public static SearchRequestBuilder buildSearchRequest(Client client, final SearchRequest request, String paramFrom,
            String paramTo, ClientRequest state, FilterBuilder filter, String... esTypes) {
        String index = INDEX_NAME;
        SearchRequestBuilder requestBuilder = client.prepareSearch(index);
        requestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);
        return requestBuilder;
    }
}
