# Digital Signature Impression

A robust Spring Boot application for generating and verifying digital signatures using modern cryptographic algorithms. This project demonstrates secure document signing and verification workflows with both RSA and ECC (Elliptic Curve Cryptography), ideal for showcasing expertise in secure software development and applied cryptography.

---

## 🚀 Features

- **Digital Signature Generation**: Sign any document or data using RSA (2048-bit) or ECC (P-256) algorithms.
- **Signature Verification**: Instantly verify signatures for authenticity and integrity.
- **RESTful API**: Clean REST endpoints for signing and verifying documents.
- **User Authentication**: Secure user management with JWT-based authentication and Spring Security.
- **API Documentation**: OpenAPI (Swagger) docs auto-generated for easy exploration and integration.
- **Cryptographic Utilities**: Uses Bouncy Castle for advanced cryptography operations.
- **Maven Project**: Standardized build with Spring Boot, easy to deploy and extend.

---

## 🏗️ Architecture Overview

- **Spring Boot**: Framework for building standalone, production-grade applications.
- **Spring Security & JWT**: Secure endpoints with stateless JWT tokens.
- **Spring Data JPA**: Persist user data and signature records.
- **BouncyCastle**: Cryptographic provider supporting ECC and advanced algorithms.

### Key Classes

- `CryptoUtil`: Generates key pairs, signs and verifies data (RSA & ECC).
- `SignatureService` & `SignatureController`: Core business logic and REST API endpoints.
- `UserService` & `AuthController`: User management and authentication.
- `JwtUtil`: Handles JWT creation and validation.
- DTOs (`SignRequest`, `VerifyRequest`): Typed request/response models.

---

## 🔐 API Usage

### Authentication

- **Register/Login**: Obtain a JWT token by registering or logging in.
- **Authorization**: Pass JWT in `Authorization: Bearer <token>` header to access protected endpoints.

### Signature Endpoints

- `POST /api/signature/generate/rsa`  
  Sign data using RSA.  
- `POST /api/signature/generate/ecc`  
  Sign data using ECC.  
- `POST /api/signature/verify/rsa`  
  Verify RSA signature.  
- `POST /api/signature/verify/ecc`  
  Verify ECC signature.

**Sample Request for Signing (RSA):**
```http
POST /api/signature/generate/rsa
Content-Type: application/json
Authorization: Bearer <token>

{
  "algorithm": "RSA",
  "document": "<base64-encoded-document-bytes>"
}
```

---

## 🛠️ Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security**
- **Spring Data JPA**
- **JWT (io.jsonwebtoken)**
- **BouncyCastle**
- **OpenAPI/Swagger**
- **Maven**

---

## 📁 Project Structure

```
src/main/java/com/sign/
├── config/          # Security configuration
├── controller/      # REST controllers (Signature, Auth)
├── dto/             # Data Transfer Objects (SignRequest, VerifyRequest)
├── entity/          # User entity
├── repository/      # UserRepository (JPA)
├── service/         # Business logic (SignatureService, UserService)
├── util/            # CryptoUtil, JwtUtil
DigitalSignatureImpressionApplication.java
```

---

## 📦 Getting Started

### Prerequisites
- Java 17+
- Maven

### Build & Run

```bash
mvn spring-boot:run
```

### API Docs

Visit: `/swagger-ui.html` or `/v3/api-docs`

---

## 📚 References

- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [BouncyCastle](https://www.bouncycastle.org/java.html)
- [JWT](https://github.com/jwtk/jjwt)
- [OpenAPI/Swagger](https://swagger.io/)

---

## 👤 Author

**Jay Bhavsar**  
[GitHub](https://github.com/JYBhavsar)

---

## 📝 License

Proprietary License

---

> **Showcase this project in your portfolio to highlight your expertise in secure backend development, cryptography, and RESTful API design!
