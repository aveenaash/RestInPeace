package elasticsearch.builders;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.search.MultiSearchResponse;

public interface AbstractActionListener extends ActionListener<MultiSearchResponse> {

}
