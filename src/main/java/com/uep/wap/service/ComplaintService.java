package com.uep.wap.service;

import com.uep.wap.model.Complaint;
import com.uep.wap.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class ComplaintService {
    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found with ID: " + id));
    }

    public Complaint addComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public Complaint updateComplaint(long id, Complaint updatedComplaint) {
        Complaint existingComplaint = complaintRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found with ID: " + id));

        existingComplaint.setDescription(updatedComplaint.getDescription());
        existingComplaint.setDateOfComplaint(updatedComplaint.getDateOfComplaint());
        existingComplaint.setUser(updatedComplaint.getUser());
        existingComplaint.setArticle(updatedComplaint.getArticle());

        return complaintRepository.save(existingComplaint);
    }

    public void deleteComplaint(long id) {
        if (complaintRepository.existsById(id)) {
            complaintRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Complaint not found with ID: " + id);
        }
    }
}
