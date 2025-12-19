# 🏥 RDV Microservices System

A **Spring Boot microservices-based appointment (RDV) management system** designed to handle medical appointments while integrating **Patient** and **Medecin** services via REST communication.

---

## 📌 Architecture Overview

This project follows a **microservices architecture** composed of:

- **RDV Service** – Appointment management
- **Patient Service** – Patient data management
- **Medecin Service** – Doctor data management
- **API Gateway** – Centralized routing
- *(Optional)* **Eureka Discovery Server**

---

## 🧱 Technologies Used

- Java 17+
- Spring Boot
- Spring Cloud Gateway
- Spring Data JPA
- OpenFeign
- Hibernate
- MySQL
- Maven
- Lombok

---

## 🗂 Project Structure

```
rdv-microservices/
├── rdv-service/
├── patient-service/
├── medecin-service/
├── gateway-service/
└── README.md
```

---

## 🔁 RDV Microservice – Key Concept

The RDV service stores only:
- `patientId`
- `medecinId`

It retrieves **Patient** and **Medecin** details dynamically using REST clients, ensuring **loose coupling** between services.

---

## 🔗 API Endpoints

### ➤ Get all RDVs
```
GET /api/rdv/all
```

### ➤ Get RDV by ID
```
GET /api/rdv/{id}
```

### ➤ Create RDV
```
POST /api/rdv/add
```

### Sample Request
```json
{
  "dateRdv": "2025-02-03 09:15:00",
  "etat": "CONFIRME",
  "patientId": 2,
  "medecinId": 1
}
```

---

## 📦 Sample Response

```json
{
  "id": 1,
  "dateRdv": "2025-01-10 14:30:00",
  "etat": "EN_ATTENTE",
  "patientId": 1,
  "patient": {
    "id": 1,
    "nom": "Ali"
  },
  "medecinId": 1,
  "medecin": {
    "id": 1,
    "nom": "Dr Ahmed",
    "specialite": "Cardiologie"
  }
}
```

---

## ⚙️ How to Run

1. Start Discovery Server (if used)
2. Start Patient Service
3. Start Medecin Service
4. Start RDV Service
5. Start API Gateway

Access via Gateway:
```
http://localhost:8080/rdv/all
```

---

## 🎓 Academic Context

This project was developed for educational purposes to demonstrate **Spring Boot Microservices Architecture**.

---

## 👤 Author

**Bouon Wajdy**  
Software Engineering Student
