package com.example.report_service.config;

import com.example.report_service.entity.Report;
import com.example.report_service.repository.ReportRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataLoader {
    private final ReportRepository repository;

    public DataLoader(ReportRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void load() {
        repository.save(new Report(null, "FOOD",
                new BigDecimal("100"), "APPROVED",
                LocalDateTime.now()));

        repository.save(new Report(null, "FOOD",
                new BigDecimal("50"), "REJECTED",
                LocalDateTime.now()));

        repository.save(new Report(null, "TRANSPORT",
                new BigDecimal("200"), "APPROVED",
                LocalDateTime.now()));
    }
}
