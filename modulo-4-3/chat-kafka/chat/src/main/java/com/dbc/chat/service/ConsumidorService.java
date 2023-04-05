package com.dbc.chat.service;

import com.dbc.chat.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConsumidorService {

    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${spring.kafka.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})},
            containerFactory = "listenerContainerFactory1"
    )
    public void consumeChatGeral(@Payload String mensagem, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) throws JsonProcessingException {
        try {
            MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
            log.info("'{}' '[{}]': '{}'" + mensagemDTO.getDataCriacao(), mensagemDTO.getUsuario(), mensagemDTO.getMensagem());
        } catch (Exception e) {
            log.error("Erro ao consumir mensagem do kafka: {}", mensagem, e);
        }
    }

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${spring.kafka.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"7"})},
            containerFactory = "listenerContainerFactory2"
    )
    public void consumeChatMarcklen(@Payload String mensagem, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) throws JsonProcessingException {
        try {
            MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
            log.info("'{}' '[{}]'(privada): '{}'" + mensagemDTO.getDataCriacao(), mensagemDTO.getUsuario(), mensagemDTO.getMensagem());
        } catch (Exception e) {
            log.error("Erro ao consumir mensagem do kafka: {}", mensagem, e);
        }
    }
}
