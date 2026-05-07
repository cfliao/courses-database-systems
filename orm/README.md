# Department ORM Demo (Hibernate + JPA)

This project demonstrates ORM mapping for the `Department` table in the MySQL `Company` database.

## Prerequisites

- Java 17+
- Maven 3.9+
- MySQL running at `localhost:3306`
- Existing `Company` schema loaded from `company.sql`

## Current DB Config

The demo uses local default credentials in `src/main/resources/META-INF/persistence.xml`:

- User: `root`
- Password: `nccutest`

Change these values if your local MySQL setup is different.

## Build

```bash
mvn -f orm/pom.xml clean compile
```

## Run

```bash
mvn -f orm/pom.xml exec:java
```

The app prints all departments and then fetches department `dnumber=5`.
