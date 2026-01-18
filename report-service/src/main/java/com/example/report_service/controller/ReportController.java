package com.example.report_service.controller;

import com.example.report_service.dto.ReportSummaryDTO;
import com.example.report_service.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/reports/summary")
    public List<Object[]> summary(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate
    ) {
        return service.getSummary(startDate, endDate);
    }

    @GetMapping("/reports/summary/stream")
    public List<ReportSummaryDTO> summaryWithStream(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate
    ) {
        return service.getSummaryWithStream(startDate, endDate);
    }
}
