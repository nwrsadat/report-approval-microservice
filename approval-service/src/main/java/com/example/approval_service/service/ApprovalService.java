package com.example.approval_service.service;

import com.example.approval_service.entity.Approval;
import com.example.approval_service.repository.ApprovalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApprovalService {
    private final ApprovalRepository repository;

    public ApprovalService(ApprovalRepository repository) {
        this.repository = repository;
    }

    public Approval approve(Long reportId) {
        return repository.save(
            new Approval(null, reportId,
        "APPROVED", LocalDateTime.now())
        );
    }

    public Approval reject(Long reportId) {
        return repository.save(
            new Approval(null, reportId,
        "REJECTED", LocalDateTime.now())
        );
    }
}
