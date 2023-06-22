package com.uep.wap.service;

import com.uep.wap.model.DailyFact;
import com.uep.wap.repository.DailyFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class DailyFactService {
    private final DailyFactRepository dailyFactRepository;

    @Autowired
    public DailyFactService(DailyFactRepository dailyFactRepository) {
        this.dailyFactRepository = dailyFactRepository;
    }

    public List<DailyFact> getAllDailyFacts() {
        return dailyFactRepository.findAll();
    }

    public DailyFact getDailyFactById(int id) {
        return dailyFactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invalid DailyFact ID: " + id));
    }

    public void addDailyFact(DailyFact dailyFact) {
        dailyFactRepository.save(dailyFact);
    }

    public void updateDailyFact(DailyFact updatedDailyFact) {
        DailyFact existingDailyFact = dailyFactRepository.findById(updatedDailyFact.getDaily_id())
                .orElseThrow(() -> new EntityNotFoundException("Invalid DailyFact ID: " + updatedDailyFact.getDaily_id()));

        existingDailyFact.setArticle(updatedDailyFact.getArticle());

        dailyFactRepository.save(existingDailyFact);
    }

    public void deleteDailyFact(int id) {
        dailyFactRepository.deleteById(id);
    }
}
