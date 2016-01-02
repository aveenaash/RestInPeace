package elasticsearch.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ESConnector {

    static Client client;

    public static Client getClient() throws UnknownHostException {
        Client client = TransportClient.builder().build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("http://api.exiletools.com/"), 9200))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("http://api.exiletools.com/"), 9300));
        return client;

    }
}
