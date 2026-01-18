package com.example.report_service.service;

import com.example.report_service.dto.ReportSummaryDTO;
import com.example.report_service.entity.Report;
import com.example.report_service.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public List<Object[]> getSummary(LocalDateTime start, LocalDateTime end) {
        return repository.getSummary(start, end);
    }

    public List<ReportSummaryDTO> getSummaryWithStream(LocalDateTime startDate, LocalDateTime endDate)
    {
        List<Report> reports = repository.findByCreatedDateBetween(startDate, endDate);

        return reports.stream()
                .filter(r -> "APPROVED".equals(r.getStatus()))
                .collect(Collectors.groupingBy(
                        Report::getCategory,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Report::getAmount,
                                BigDecimal::add
                        )
                ))
                .entrySet()
                .stream()
                .map(e -> new ReportSummaryDTO(
                        e.getKey(),
                        e.getValue()
                ))
                .toList();
    }
}
