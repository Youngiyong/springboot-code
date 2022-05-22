package com.kafka.consumer.domain.entity.snsHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnsHistoryRepository extends JpaRepository<SnsHistory, Long> {
}
