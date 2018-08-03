
import io.lettuce.core.ClientOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.time.Duration;

/**
 * Created by lorne on 2017/7/5.
 */

@Configuration
public class RedisConfig {

    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);



    @Bean
    public RedisConnectionFactory redisConnectionFactory(){

        ClientOptions.Builder clientBuilder = ClientOptions.builder();

        clientBuilder.pingBeforeActivateConnection(true);

        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName("192.168.0.188");
        standaloneConfiguration.setPort(6379);
//        standaloneConfiguration.setPassword(RedisPassword.of("redis"));
        standaloneConfiguration.setDatabase(6);
        LettuceClientConfiguration.LettuceClientConfigurationBuilder builder = LettuceClientConfiguration.builder();
        builder.commandTimeout(Duration.ofMinutes(6));
        builder.shutdownTimeout(Duration.ofMinutes(6));
        builder.clientOptions(clientBuilder.build());

        LettuceConnectionFactory factory = new LettuceConnectionFactory(standaloneConfiguration,builder.build());
        return factory;

    }


    @Bean
    public RedisTemplate<String,Object> getRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        ObjectMapper map = new ObjectMapper();

        map.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(map);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.setConnectionFactory(redisConnectionFactory());
        
        return redisTemplate;
    }
}
