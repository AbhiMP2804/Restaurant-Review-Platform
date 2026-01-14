# 🍽️ Restaurant Review System

<!-- ![Restaurant Review](https://raw.githubusercontent.com/username/repository/main/images/restaurant_banner.png) -->

A modern **Restaurant Review Platform** built with **Spring Boot**, **Elasticsearch**, and **Java**, with a **Next.js frontend**.  
Users can search restaurants, view ratings, operating hours, locations, photos, and leave reviews.

---

## 📝 Features

- Search restaurants by name, cuisine, or rating using **Elasticsearch**.
- Geo-location based search – find restaurants near you.
- Operating hours for each day.
- User reviews and ratings.
- Upload and browse restaurant photos.
- Secure access with Spring Security and OAuth2.
- Modern, responsive frontend built with **Next.js**.

---

## 🏗️ Technology Stack

| Layer       | Technology |
|------------|------------|
| Backend    | Java 21, Spring Boot 4 |
| Search     | Elasticsearch 8.x |
| Security   | Spring Security, OAuth2 |
| Frontend   | Next.js (React) |
| Mapping    | Spring Data Elasticsearch |
| Build      | Maven |
| IDE        | IntelliJ IDEA / Eclipse |

---


---

## 🖼️ Class Diagram

<!-- ![Class Diagram](images/class_diagram.png) -->

---

## 🌐 Frontend

The frontend is built using **Next.js**.  
- Server-side rendering (SSR) for fast page loads  
- API integration with Spring Boot backend  
- Responsive UI for desktop and mobile  
- Modern interface for browsing restaurants, reviews, and photos  

The frontend code is located in the `/frontend` directory.

---

## 🛠️ Prerequisites

- Java 21
- Maven
- Node.js & npm
- Elasticsearch running locally or remotely

---

## 🚀 How to Run

### 1. Clone the repository
```bash
git clone https://github.com/AbhiMP2804/Restaurant-Review-Application.git
cd Restaurant-Review-Application
```

### 2. Run the backend
```bash
mvn clean install
mvn spring-boot:run

** Backend runs at http://localhost:8080
```

### 3. Run the frontend
```bash
cd frontend
npm install
npm run dev

** Frontend runs at http://localhost:3000
** Connects to backend APIs automatically
```