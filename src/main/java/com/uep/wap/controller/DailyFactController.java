package com.uep.wap.controller;

import com.uep.wap.model.DailyFact;
import com.uep.wap.service.DailyFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daily-facts")
public class DailyFactController {
    private final DailyFactService dailyFactService;

    @Autowired
    public DailyFactController(DailyFactService dailyFactService) {
        this.dailyFactService = dailyFactService;
    }

    @GetMapping
    public List<DailyFact> getAllDailyFacts() {
        return dailyFactService.getAllDailyFacts();
    }

    @GetMapping("/{id}")
    public DailyFact getDailyFactById(@PathVariable int id) {
        return dailyFactService.getDailyFactById(id);
    }

    @PostMapping
    public void addDailyFact(@RequestBody DailyFact dailyFact) {
        dailyFactService.addDailyFact(dailyFact);
    }

    @PutMapping("/{id}")
    public void updateDailyFact(@PathVariable int id, @RequestBody DailyFact dailyFact) {
        dailyFact.setDaily_id(id);
        dailyFactService.updateDailyFact(dailyFact);
    }

    @DeleteMapping("/{id}")
    public void deleteDailyFact(@PathVariable int id) {
        dailyFactService.deleteDailyFact(id);
    }
}
