package com.uep.wap.service;

import com.uep.wap.model.Statistics;
import com.uep.wap.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public Statistics getStatisticsById(long id) {
        return statisticsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Statistics not found with ID: " + id));
    }

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Statistics createStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    public Statistics updateStatistics(long id, Statistics statistics) {
        Statistics existingStatistics = getStatisticsById(id);

        // Update the existing statistics object with the new values
        existingStatistics.setComplaint(statistics.getComplaint());
        existingStatistics.setHistory(statistics.getHistory());
        existingStatistics.setUser(statistics.getUser());
        existingStatistics.setArticle(statistics.getArticle());

        return statisticsRepository.save(existingStatistics);
    }

    public void deleteStatistics(long id) {
        statisticsRepository.deleteById(id);
    }
}
