package rip.hippo.poll.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

/**
 * @author Hippo
 * @version 1.0.0, 1/20/21
 * @since 1.0.0
 */
@Configuration
@PropertySource(value= {"classpath:application.properties"})
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}
