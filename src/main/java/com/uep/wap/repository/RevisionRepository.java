package com.uep.wap.repository;

import com.uep.wap.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Long> {
    // Add custom query methods or use the default methods provided by JpaRepository
}
