package com.uep.wap.service;

import com.uep.wap.model.HistoryOfChanges;
import com.uep.wap.repository.HistoryOfChangesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryOfChangesService {

    private final HistoryOfChangesRepository historyOfChangesRepository;

    @Autowired
    public HistoryOfChangesService(HistoryOfChangesRepository historyOfChangesRepository) {
        this.historyOfChangesRepository = historyOfChangesRepository;
    }

    public HistoryOfChanges getHistoryOfChangesById(int id) {
        return historyOfChangesRepository.findById(id).orElse(null);
    }

    public List<HistoryOfChanges> getHistoryOfChangesByArticleId(long articleId) {
        return historyOfChangesRepository.findByArticleId(articleId);
    }

    public HistoryOfChanges createHistoryOfChanges(HistoryOfChanges historyOfChanges) {
        return historyOfChangesRepository.save(historyOfChanges);
    }

    public HistoryOfChanges updateHistoryOfChanges(int id, HistoryOfChanges historyOfChanges) {
        if (historyOfChangesRepository.existsById(id)) {
            historyOfChanges.setHistory_id(id);
            return historyOfChangesRepository.save(historyOfChanges);
        } else {
            return null;
        }
    }

    public boolean deleteHistoryOfChanges(int id) {
        if (historyOfChangesRepository.existsById(id)) {
            historyOfChangesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
