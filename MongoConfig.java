import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = "com.xiu.mongo.operations.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        ServerAddress serverAddress = new ServerAddress("192.168.1.20",27017);
        MongoCredential mongoCredential = MongoCredential.createCredential("root", "admin", "203204".toCharArray());

        MongoClientOptions options = MongoClientOptions.builder()
                .connectTimeout(10000)
                .maxConnectionIdleTime(1000)
                .maxWaitTime(10000)
                .socketTimeout(10000)
                .maxConnectionLifeTime(10000)
                .build();
//                .heartbeatConnectTimeout(10000);  //集群心跳检测

        MongoClient mongoClient = new MongoClient(serverAddress,mongoCredential,options);

        return mongoClient;
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }
}

