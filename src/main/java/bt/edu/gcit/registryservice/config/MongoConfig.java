package bt.edu.gcit.registryservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // This EXPLICITLY defines the connection. It cannot fall back to localhost.
        return MongoClients.create("mongodb+srv://12230028gcit_db_user:iIaMZbTcupB5kBOw@cluster0.eclmltd.mongodb.net/NSPS_DB?retryWrites=true&w=majority");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "NSPS_Auth_DB");
    }
}