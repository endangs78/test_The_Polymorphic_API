# 💰 Finance Polymorphic API

REST API berbasis Spring Boot untuk mengintegrasikan data kurs mata uang dari Frankfurter API dengan pendekatan **polymorphic (Strategy Pattern)**.

---

## 🚀 Features

* 🔗 Integrasi API eksternal (Frankfurter API)
* 🧠 Polymorphic service (Strategy Pattern)
* 💱 Latest exchange rates (IDR base)
* 📊 Historical exchange rates (IDR → USD)
* 🌍 Supported currencies
* ➕ Custom business logic: **USD Buy Spread (IDR)**
* 🛡️ Global error handling

---

## 🏗️ Tech Stack

* Java 17
* Spring Boot
* Spring WebFlux (WebClient)
* Lombok
* PostgreSQL (optional)

---

## 📌 API Endpoint

### Base URL

```
/api/finance/data/{resourceType}
```

### Available Resource Types

| resourceType         | Description               |
| -------------------- | ------------------------- |
| latest_idr_rates     | Kurs terbaru berbasis IDR |
| historical_idr_usd   | Data historis IDR → USD   |
| supported_currencies | Daftar semua mata uang    |

---

## 📥 Example Request

### 🔹 Latest Rates

```
GET /api/finance/data/latest_idr_rates
```

### 🔹 Historical

```
GET /api/finance/data/historical_idr_usd
```

### 🔹 Supported Currencies

```
GET /api/finance/data/supported_currencies
```

---

## 📤 Example Response (Latest)

```json
{
    "base": "IDR",
    "rates": {
        "AUD": 8.6E-5,
        "BRL": 3.0E-4,
        "CAD": 8.2E-5,
        "CHF": 4.7E-5,
        "CNY": 4.1E-4,
        "CZK": 0.00125,
        "DKK": 3.8E-4,
        "EUR": 5.1E-5,
        "GBP": 4.5E-5,
        "HKD": 4.6E-4,
        "HUF": 0.01958,
        "ILS": 1.9E-4,
        "INR": 0.00547,
        "ISK": 0.00737,
        "JPY": 0.00938,
        "KRW": 0.08916,
        "MXN": 0.00105,
        "MYR": 2.4E-4,
        "NOK": 5.7E-4,
        "NZD": 1.0E-4,
        "PHP": 0.00356,
        "PLN": 2.2E-4,
        "RON": 2.6E-4,
        "SEK": 5.6E-4,
        "SGD": 7.6E-5,
        "THB": 0.00193,
        "TRY": 0.00262,
        "USD": 5.9E-5,
        "ZAR": 0.001
    },
    "usdBuySpreadIdr": 17016.610169491527
}
```

---

## 🧮 Spread Calculation Logic

Spread dihitung berdasarkan username GitHub:

```
Spread Factor = (sum ASCII username % 1000) / 100000.0
USD_BuySpread_IDR = (1 / USD Rate) * (1 + Spread Factor)
```

---

## 🧠 Architecture

Project menggunakan **Strategy Pattern** untuk menangani multiple resource:

```
Controller
   ↓
Factory (dynamic routing)
   ↓
Service (polymorphic)
   ↓
External API Client
```

---

## 📂 Project Structure

```
controller/
service/
factory/
componen/
dto/
```

---

## ⚙️ Configuration

### application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/finance_db
spring.datasource.username=****
spring.datasource.password=****
spring.jpa.hibernate.ddl-auto=update
```

---

## ❗ Error Handling

Contoh response error:

```json
{
  "error": "NOT_FOUND",
  "message": "Resource type not found",
  "timestamp": "2026-04-03T10:00:00"
}
```

---

## ▶️ How to Run

```bash
git clone https://github.com/your-username/finance-api.git
cd finance-api
mvn spring-boot:run
```

---

## 👩‍💻 Author

**Endang Suwarni**
Java Backend Developer

---

## ⭐ Notes

Project ini dibuat sebagai bagian dari technical test untuk menunjukkan:

* Clean Architecture
* API Integration
* Code Quality (Sonar-ready)

---
