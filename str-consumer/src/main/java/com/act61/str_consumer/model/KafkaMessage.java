package com.act61.str_consumer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "kafka_message")
public class KafkaMessage {

    // Identificador único del mensaje. Se genera automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Contenido del mensaje recibido desde Kafka.
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // Nombre del listener que procesó el mensaje.
    @Column(nullable = false)
    private String listener;

    // Fecha y hora en la que se recibió el mensaje.
    @Column(nullable = false)
    private LocalDateTime receivedAt;

    // Constructor de conveniencia.
    public KafkaMessage(String content, String listener) {
        this.content = content;
        this.listener = listener;
        this.receivedAt = LocalDateTime.now();
    }
}