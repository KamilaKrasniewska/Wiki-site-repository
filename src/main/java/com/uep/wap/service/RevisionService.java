package com.uep.wap.service;

import com.uep.wap.model.Revision;
import com.uep.wap.repository.RevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisionService {

    private final RevisionRepository revisionRepository;

    @Autowired
    public RevisionService(RevisionRepository revisionRepository) {
        this.revisionRepository = revisionRepository;
    }

    public Revision createRevision(Revision revision) {
        return revisionRepository.save(revision);
    }

    public Revision getRevisionById(long id) {
        return revisionRepository.findById(id).orElse(null);
    }

    public Revision updateRevision(long id, Revision revision) {
        return revisionRepository.findById(id).map(existingRevision -> {
            existingRevision.setPreviousImage(revision.getPreviousImage());
            existingRevision.setPreviousContent(revision.getPreviousContent());
            return revisionRepository.save(existingRevision);
        }).orElse(null);
    }

    public boolean deleteRevision(long id) {
        if(revisionRepository.existsById(id)) {
            revisionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
