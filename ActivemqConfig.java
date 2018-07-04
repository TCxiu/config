import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

@Configuration
public class ActivemqConfig {
private static final String BROKER_URL="failover:(tcp://47.94.197.249:61616,tcp://39.106.97.37:61616,tcp://39.106.97.176:61616)";
	
    @Bean(name="activeMQConnectionFactory")
    public ActiveMQConnectionFactory connectionFactory() {
    	ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
    	activeMQConnectionFactory.setObjectMessageSerializationDefered(true);
    	activeMQConnectionFactory.setTrustAllPackages(true);
        return activeMQConnectionFactory;
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(@Qualifier("activeMQConnectionFactory")ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(@Qualifier("activeMQConnectionFactory")ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
    @Bean(name="jmsMessagingTemplate")
    public JmsMessagingTemplate jmsMessagingTemplate(@Qualifier("activeMQConnectionFactory")ActiveMQConnectionFactory connectionFactory){
    	JmsMessagingTemplate jmsMessagingTemplate = new JmsMessagingTemplate(connectionFactory);
    	return jmsMessagingTemplate;
    }
}