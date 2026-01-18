package com.example.approval_service.controller;

import com.example.approval_service.entity.Approval;
import com.example.approval_service.service.ApprovalService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {
    private final ApprovalService service;

    public ApprovalController(ApprovalService service) {
        this.service = service;
    }

    @PostMapping("/{reportId}/approve")
    public Approval approve(@PathVariable Long reportId) {
        return service.approve(reportId);
    }

    @PostMapping("/{reportId}/reject")
    public Approval reject(@PathVariable Long reportId) {
        return service.reject(reportId);
    }
}
