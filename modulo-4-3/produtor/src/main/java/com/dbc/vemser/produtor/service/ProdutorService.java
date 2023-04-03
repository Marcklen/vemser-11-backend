package com.dbc.vemser.produtor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {

    @Value(value = "${kafka.topic}")
    private String topic; //meu-primeiro-topico
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagemParaOTopico(String mensagem) {
        MessageBuilder<String> messageBuilder = MessageBuilder
                .withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());

        // maneira mais simples de enviar msg para o topico
//        kafkaTemplate.send(messageBuilder.build());
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(messageBuilder.build());
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Mensagem enviada com sucesso para o topico: " + mensagem);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Erro ao enviar mensagem para o topico: " + mensagem, ex);
            }
        });
    }
}
