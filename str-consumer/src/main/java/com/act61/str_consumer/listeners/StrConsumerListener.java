package com.act61.str_consumer.listeners;

import com.act61.str_consumer.model.KafkaMessage;
import com.act61.str_consumer.repository.KafkaMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor // inyecto el repositorio por constructor con lombok
public class StrConsumerListener {

    // repositorio para guardar los mensajes en la base de datos
    private final KafkaMessageRepository kafkaMessageRepository;

    @KafkaListener(groupId = "group-1",
            topicPartitions = @TopicPartition(topic = "str-topic", partitions = {"0"}),
            containerFactory = "validMessageContainerFactory")
    public void listener1(String message){
        log.info("LISTENER1 ::: Recibiendo un mensaje: {}", message);
        // guardo el mensaje indicando que lo procesó el listener1
        kafkaMessageRepository.save(new KafkaMessage(message, "listener1"));
        log.info("LISTENER1 ::: Mensaje guardado en base de datos.");
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = @TopicPartition(topic = "str-topic", partitions = {"1"}),
            containerFactory = "validMessageContainerFactory")
    public void listener2(String message){
        log.info("LISTENER2 ::: Recibiendo un mensaje: {}", message);
        // guardo el mensaje indicando que lo procesó el listener2
        kafkaMessageRepository.save(new KafkaMessage(message, "listener2"));
        log.info("LISTENER2 ::: Mensaje guardado en base de datos.");
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void listener3(String message){
        log.info("LISTENER3 ::: Recibiendo un mensaje: {}", message);
        // guardo el mensaje indicando que lo procesó el listener3
        kafkaMessageRepository.save(new KafkaMessage(message, "listener3"));
        log.info("LISTENER3 ::: Mensaje guardado en base de datos.");
    }
}