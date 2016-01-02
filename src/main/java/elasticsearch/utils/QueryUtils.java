package elasticsearch.utils;

import org.apache.lucene.queryparser.xml.FilterBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;

import com.sun.jersey.api.client.ClientRequest;

public class QueryUtils {

    public static SearchRequestBuilder buildSearchRequest(Client client, final SearchRequest request, String paramFrom,
            String paramTo, ClientRequest state, FilterBuilder filter, String... esTypes) {
        String index = "meroelasticserach";
        // request.hasParameter("clientId") ? request.get("clientId") : "gccount";
        SearchRequestBuilder requestBuilder = client.prepareSearch(index);
        requestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

        // requestBuilder.setQuery(QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(), andFilter));
        // requestBuilder.setTypes(esTypes);

        // final String typeField = request.hasParameter("keyField") ? request.get("keyField") : CUSTOMER_FIELD;
        // final String valueField = request.hasParameter("valueField") ? request.get("valueField") : BALANCE_FIELD;
        // TermsStatsFacetBuilder termsStatsFacet;

        // if (RequestUtils.isArrayRequest(valueField)) {
        // String[] valueFields = RequestUtils.getArrayRequest(valueField);
        // for (String valueField_ : valueFields) {
        // termsStatsFacet = FilterUtils.getTermsStatsFacet(valueField_ + "_stats", typeField, valueField_, SIZE);
        // requestBuilder.addFacet(termsStatsFacet);
        // }
        // } else {
        //
        // /**
        // *
        // * "amount_stats" : { "terms_stats" : { "key_field" : "customerId", "value_field" : "paidAmount", "order" : "total",
        // * "size" : 0 } }
        // */
        // requestBuilder.addFacet(getTermsStatsFacet(request, null, filter));
        // requestBuilder.addField("total"); // "fields" : [ "total"],
        // }

        // requestBuilder.addField(typeField); // "fields" : ["customerId" ],
        return requestBuilder;
    }
}
