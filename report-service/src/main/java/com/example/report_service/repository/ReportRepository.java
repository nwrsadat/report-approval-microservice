package com.example.report_service.repository;

import com.example.report_service.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = """
        SELECT
            category AS category,
            SUM(CASE WHEN status = 'APPROVED' THEN amount ELSE 0 END) AS totalAmount
        FROM report
        WHERE created_date BETWEEN :startDate AND :endDate
        GROUP BY category
        """, nativeQuery = true)
    List<Object[]> getSummary(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<Report> findByCreatedDateBetween(
            LocalDateTime startDate,
            LocalDateTime endDate
    );
}
