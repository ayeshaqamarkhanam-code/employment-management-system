# Employment Management System

A full-stack Java web application for managing employee records, built with the MVC pattern using Java Servlets, JSP, and MySQL.

## Tech Stack

| Layer | Technology |
|-------|------------|
| Frontend | HTML, CSS, JSP |
| Backend | Java Servlets (Jakarta EE) |
| Database | MySQL 8.0 |
| Server | Apache Tomcat 10.1.53 |

## Features

- Add new employees with full details
- View all employees in a styled table
- Edit and update existing employee records
- Delete employees with confirmation prompt
- Dark themed responsive UI

## Project Structure
employment-management-system/
├── src/main/java/com/ems/
│   ├── dao/          # DatabaseConnection, EmployeeDAO
│   ├── model/        # Employee.java
│   └── servlet/      # Add, List, Update, Delete servlets
├── web/
│   ├── css/          # style.css
│   ├── html/         # index.html, addEmployee.html
│   └── WEB-INF/
│       ├── views/    # listEmployees.jsp, updateEmployee.jsp
│       └── web.xml
├── lib/              # servlet-api.jar, mysql-connector
└── database.sql

## Setup & Run

### Prerequisites
- JDK 17+
- MySQL 8.0
- Apache Tomcat 10.x

### Steps

1. Clone the repo
```bash
git clone https://github.com/ayeshaqamarkhanam-code/employment-management-system.git
```

2. Import the database
```bash
mysql -u root -p < database.sql
```

3. Update DB credentials in `DatabaseConnection.java`
```java
private static final String URL = "jdbc:mysql://localhost:3306/ems_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";
```

4. Compile all Java files
```bash
javac -cp "lib/servlet-api.jar;lib/mysql-connector-j-9.6.0.jar" -d out/WEB-INF/classes src/main/java/com/ems/**/*.java
```

5. Deploy `out/` to `tomcat/webapps/ems/` and start Tomcat

6. Open `http://localhost:8080/ems/`

## Database Schema

```sql
CREATE TABLE employee (
    employee_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    email         VARCHAR(100) UNIQUE,
    phone_number  VARCHAR(15) UNIQUE,
    department    VARCHAR(50),
    job_title     VARCHAR(100),
    date_of_joining DATE,
    salary        DECIMAL(10,2),
    status        VARCHAR(15) DEFAULT 'Active'
);
```

## Author

Ayesha Qamar Khanam — [GitHub](https://github.com/ayeshaqamarkhanam-code) · [LinkedIn](https://linkedin.com/in/ayesha-qamar-khanam-06904532b)