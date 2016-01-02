package elasticsearch.builders;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.client.Client;

import elasticsearch.utils.SearchRequest;

public interface AbstractRequestBuilder {

    MultiSearchRequestBuilder query(Client client, SearchRequest request);
}
