package com.dbc.chat.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    private static final String EARLIEST = "earliest";
    private static final String LATEST = "latest";

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Value(value = "${spring.kafka.properties.sasl.mechanism}")
    private String scram;

    @Value(value = "${spring.kafka.properties.security.protocol}")
    private String sasl;

    @Value(value = "${spring.kafka.properties.enable.idempotence}")
    private String idempotence;

    @Value(value = "${spring.kafka.properties.sasl.jaas.config}")
    private String jaasConfig;

    @Value(value = "${spring.kafka.client-id}")
    private String clientId;


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory1() {
        return getProps();
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory2() {
        return getProps();
    }

    private ConcurrentKafkaListenerContainerFactory<String, String> getProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EARLIEST);
        props.put("sasl.mechanism", scram);
        props.put("sasl.jaas.config", jaasConfig);
        props.put("security.protocol", sasl);
        props.put("enable.idempotence", idempotence);

        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory
                = new DefaultKafkaConsumerFactory<>(props);

        ConcurrentKafkaListenerContainerFactory<String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory);
        return factory;
    }
}