package com.uep.wap.controller;

import com.uep.wap.model.Revision;
import com.uep.wap.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revisions")
public class RevisionController {

    private final RevisionService revisionService;

    @Autowired
    public RevisionController(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    @PostMapping("/")
    public ResponseEntity<Revision> createRevision(@RequestBody Revision revision) {
        Revision createdRevision = revisionService.createRevision(revision);
        return new ResponseEntity<>(createdRevision, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revision> getRevisionById(@PathVariable("id") long id) {
        Revision revision = revisionService.getRevisionById(id);
        if (revision == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(revision, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revision> updateRevision(@PathVariable("id") long id, @RequestBody Revision revision) {
        Revision updatedRevision = revisionService.updateRevision(id, revision);
        if (updatedRevision == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedRevision, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRevision(@PathVariable("id") long id) {
        boolean deleted = revisionService.deleteRevision(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
