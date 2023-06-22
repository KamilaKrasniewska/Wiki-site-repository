package com.uep.wap.controller;

import com.uep.wap.model.HistoryOfChanges;
import com.uep.wap.service.HistoryOfChangesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryOfChangesController {

    private final HistoryOfChangesService historyOfChangesService;

    @Autowired
    public HistoryOfChangesController(HistoryOfChangesService historyOfChangesService) {
        this.historyOfChangesService = historyOfChangesService;
    }

    // Rest of the methods ...

}
