package trendyol.bootcamp.playlist.config;


import com.couchbase.client.java.Cluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchbaseIndexConfiguration {

    private final Cluster cluster;

    public CouchbaseIndexConfiguration(Cluster cluster) {
        this.cluster = cluster;
    }

    // please add proper exception class
    @Bean
    public void createIndexes() {
        try {
            cluster.query("create index  playlistId ON `Playlist`(Playlist.id);");
        }
        catch (Exception e){
            System.out.println("Database index creation exception");
        }
    }
}
