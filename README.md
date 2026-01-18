# Report & Approval Microservice

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Docker & Docker Compose

## Architecture
- report-service (8081)
- approval-service (8082)

Each service runs independently and is containerized.

## Features
- Report summary using native SQL (CASE WHEN, GROUP BY)
- In-memory aggregation using Java Stream
- Simple approval workflow
- REST-based microservices

## How to Run
1. Build jars
   mvn clean package -DskipTests

2. Run with Docker Compose
   docker compose up --build

## Endpoints
- GET /health
- GET /reports/summary
- GET /reports/summary/stream
- POST /approvals/{id}/approve
