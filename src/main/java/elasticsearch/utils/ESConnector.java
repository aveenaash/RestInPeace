package elasticsearch.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ESConnector {

    static Client client;

    public static Client getClient() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder().put("cluster.name", "myelasticsearch").build();
        Client client = TransportClient.builder().settings(settings).build()
                // .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("http://api.exiletools.com/"), 9200))
                // .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("http://api.exiletools.com/"), 9300));
                // .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        return client;

    }
}
