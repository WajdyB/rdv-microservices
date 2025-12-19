🏥 RDV Microservices System

A Spring Boot microservices-based appointment (RDV) management system designed to handle medical appointments while integrating Patient and Medecin services via REST communication.

This project demonstrates a real microservices architecture with service-to-service communication, API Gateway routing, and data aggregation.

📌 Architecture Overview

The system is composed of multiple independent microservices:

RDV Service
Manages appointments (RDVs)
Stores only patientId and medecinId
Fetches patient & medecin details from other services

Patient Service
Manages patient information

Medecin Service
Manages doctor information

API Gateway
Routes requests to appropriate microservices

(Optional) Eureka Discovery Server

🧱 Technologies Used

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Spring Cloud Gateway

Spring Cloud OpenFeign

Hibernate

MySQL

Lombok

Maven

Git & GitHub

🗂 Project Structure
rdv-microservices/
│
├── rdv-service/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   └── clients/
│
├── patient-service/
│
├── medecin-service/
│
├── gateway-service/
│
└── README.md

🔁 RDV Microservice – Key Concept

The RDV service does NOT store Patient or Medecin objects in the database.

Instead:

It stores:

patientId

medecinId

Uses REST clients to fetch full details dynamically

Combines the data before returning the response

This approach respects microservices boundaries.

🔗 Example API Endpoints
➤ Get all RDVs
GET /api/rdv/all

➤ Get RDV by ID
GET /api/rdv/{id}

➤ Create a new RDV
POST /api/rdv/add

Sample JSON request
{
  "dateRdv": "2025-02-03 09:15:00",
  "etat": "CONFIRME",
  "patientId": 2,
  "medecinId": 1
}

📦 Sample Response (Aggregated Data)
{
  "id": 1,
  "dateRdv": "2025-01-10 14:30:00",
  "etat": "EN_ATTENTE",
  "patientId": 1,
  "patient": {
    "id": 1,
    "nom": "Ali",
    "email": "ali@mail.com"
  },
  "medecinId": 1,
  "medecin": {
    "id": 1,
    "nom": "Dr Ahmed",
    "specialite": "Cardiologie"
  }
}

⚙️ How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/YOUR_USERNAME/rdv-microservices.git

2️⃣ Start services in order

Discovery Server (if used)

Patient Service

Medecin Service

RDV Service

API Gateway

3️⃣ Access via Gateway
http://localhost:8080/rdv/all

🛡 Best Practices Applied

Clean separation of concerns

No JPA relationships across microservices

REST-based service communication

Business logic in service layer

Scalable and maintainable architecture

🎓 Academic Context

This project was developed as part of an academic microservices learning project to demonstrate:

Spring Boot microservices

RESTful APIs

Inter-service communication

API Gateway usage

👤 Author

Bouon Wajdy
Software Engineering Student
Spring Boot | Microservices | Backend Development

📄 License

This project is for educational purposes.
