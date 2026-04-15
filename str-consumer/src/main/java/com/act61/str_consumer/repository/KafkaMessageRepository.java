package com.act61.str_consumer.repository;

import com.act61.str_consumer.model.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio JPA para la entidad KafkaMessage.
// Spring Data genera automáticamente las operaciones CRUD básicas.
public interface KafkaMessageRepository extends JpaRepository<KafkaMessage, Long> {
}