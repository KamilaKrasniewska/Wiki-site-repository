package com.uep.wap.repository;

import com.uep.wap.model.HistoryOfChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryOfChangesRepository extends JpaRepository<HistoryOfChanges, Integer> {

    List<HistoryOfChanges> findByArticleId(long articleId);
}
