package com.uep.wap.repository;

import com.uep.wap.model.DailyFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyFactRepository extends JpaRepository<DailyFact, Integer> {
    // You can define additional custom query methods here if needed
}
