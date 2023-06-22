package com.uep.wap.controller;

import com.uep.wap.model.Statistics;
import com.uep.wap.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/{id}")
    public Statistics getStatisticsById(@PathVariable("id") long id) {
        return statisticsService.getStatisticsById(id);
    }

    @GetMapping("/all")
    public List<Statistics> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }

    @PostMapping("/create")
    public Statistics createStatistics(@RequestBody Statistics statistics) {
        return statisticsService.createStatistics(statistics);
    }

    @PutMapping("/{id}")
    public Statistics updateStatistics(@PathVariable("id") long id, @RequestBody Statistics statistics) {
        return statisticsService.updateStatistics(id, statistics);
    }

    @DeleteMapping("/{id}")
    public void deleteStatistics(@PathVariable("id") long id) {
        statisticsService.deleteStatistics(id);
    }
}
