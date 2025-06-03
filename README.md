# Spring Boot Demo

A simple RESTful API for CRUD operations built with Spring Boot and PostgreSQL.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## 🔍 Overview

This Spring Boot application demonstrates the implementation of a RESTful API with complete CRUD (Create, Read, Update, Delete) operations. It serves as a foundation for building scalable web applications and microservices using modern Java technologies.

## ✨ Features

- **RESTful API Design**: Clean and intuitive REST endpoints
- **CRUD Operations**: Full Create, Read, Update, and Delete functionality
- **PostgreSQL Integration**: Robust database operations with PostgreSQL
- **Spring Boot Framework**: Leveraging the power of Spring Boot for rapid development
- **Data Validation**: Input validation and error handling
- **JSON Response Format**: Standardized JSON responses for all endpoints
- **Exception Handling**: Comprehensive error handling and custom exceptions

## 🛠 Technologies Used

- **Java 17+** - Programming language
- **Spring Boot 3.x** - Application framework
- **Spring Data JPA** - Data persistence layer
- **PostgreSQL** - Relational database
- **Maven** - Dependency management and build tool
- **Spring Web** - Web layer and REST endpoints
- **Hibernate** - ORM framework

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- Java 17 or higher
- Maven 3.6 or higher
- Docker and Docker Compose
- Git

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Lupo-Albi/spring-boot-demo.git
   cd spring-boot-demo
   ```

2. **Start PostgreSQL with Docker**
   ```bash
   docker-compose up -d
   ```
   This will start a PostgreSQL container with the following configuration:
   - Container name: `postgres-spring-boot`
   - Database user: `your-database-user`
   - Database password: `password`
   - Port: `5332` (mapped to container's 5432)

3. **Install dependencies**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## ⚙️ Configuration

### Docker Compose Setup

The project includes a `docker-compose.yml` file that sets up PostgreSQL.

### Database Configuration

The `application.properties` file should be configured as follows:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5332/postgres
spring.datasource.username=your-database-user
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Environment Variables

For production deployment, consider using environment variables:

```bash
export DB_URL=jdbc:postgresql://localhost:5332/postgres
export DB_USERNAME=your-database-user
export DB_PASSWORD=password
```

## 💻 Usage

### Running the Application

1. **Start the PostgreSQL database:**
   ```bash
   docker-compose up -d
   ```

2. **Verify the database is running:**
   ```bash
   docker ps
   ```
   You should see the `postgres-spring-boot` container running.

3. **Start the Spring Boot application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. The API will be available at `http://localhost:8080`

### Stopping the Application

To stop the application and database:

```bash
# Stop the Spring Boot application (Ctrl+C)
# Stop the Docker containers
docker-compose down
```

### Database Management

To access the PostgreSQL database directly:

```bash
# Connect to the database
docker exec -it postgres-spring-boot psql -U your-database-user -d postgres

# Or using a database client with these connection details:
# Host: localhost
# Port: 5332
# Database: postgres
# Username: your-database-user
# Password: password
```

### Testing the API

You can test the API endpoints using tools like:
- **Postman**
- **cURL**
- **HTTPie**
- **Insomnia**

## 🔗 API Endpoints

### Base URL: `http://localhost:8080/api/v1`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/software-engineers` | Get all entities |
| GET    | `/software-engineers/{id}` | Get entity by ID |
| POST   | `/software-engineers` | Create new entity |
| PUT    | `/software-engineers/{id}` | Update entity by ID |
| DELETE | `/software-engineers/{id}` | Delete entity by ID |

### Example Requests

#### Create Entity
```bash
curl -X POST http://localhost:8080/api/v1/software-engineers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Lupo Albi",
    "techStack": "node, typescript, react"
  }'
```

#### Get All Entities
```bash
curl -X GET http://localhost:8080/api/v1/software-engineers
```

#### Get Entity by ID
```bash
curl -X GET http://localhost:8080/api/v1/software-engineers/1
```

#### Update Entity
```bash
curl -X PUT http://localhost:8080/api/v1/software-engineers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Luanderson",
    "techStack": "java, spring, postgresql"
  }'
```

#### Delete Entity
```bash
curl -X DELETE http://localhost:8080/api/v1/software-engineers/1
```

## 📁 Project Structure

```
spring-boot-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── demo/
│   │   │               ├── SpringBootDemoApplication.java
│   │   │               ├── controller/
│   │   │               ├── service/
│   │   │               ├── repository/
│   │   │               ├── model/
│   │   │               └── config/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
├── pom.xml
└── README.md
```

## 🔧 Development

### Adding New Features

1. Create a new branch for your feature
2. Implement your changes
3. Add appropriate tests
4. Update documentation
5. Submit a pull request

### Code Style

This project follows standard Java coding conventions:
- Use meaningful variable and method names
- Follow proper indentation
- Add appropriate comments and documentation
- Write unit tests for new functionality

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Lupo-Albi**

- GitHub: [@Lupo-Albi](https://github.com/Lupo-Albi)

## 🙏 Acknowledgments

- This project was inspired by [Amigoscode’s Spring Boot tutorial](https://youtu.be/Cw0J6jYJtzw?si=q4TYGhb9slUM9Gkx). Check out their [YouTube channel](https://www.youtube.com/@amigoscode) for more great content!
- Spring Boot community for excellent documentation
- PostgreSQL team for the robust database system
- All contributors who help improve this project

---

⭐ **If you found this project helpful, please give it a star!** ⭐
