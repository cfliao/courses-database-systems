# Database Systems Course Sample Codes

This repository contains small, focused sample programs used in a Database Systems course.

## Current Samples

### Company Sample Database (SQL Dump)
- Path: `company.sql`
- Purpose: creates and populates the `company` database used by course examples.
- Includes tables such as `department`, `employee`, `project`, `dependent`, `dept_locations`, and `works_on`.

### Python DB-API MySQL Example
- Path: `python-db-api/mysql_connect.py`
- Purpose: demonstrates how to connect to a MySQL server using Python DB-API (`mysql-connector-python`).

## Prerequisites

- Python 3.9+ (3.10+ recommended)
- A running MySQL server
- A MySQL user with access to your target database
- `mysql-connector-python`

## Setup

From the repository root:

```bash
cd python-db-api
python -m pip install mysql-connector-python
```

## Initialize Database

Import the SQL dump from the repository root:

```bash
mysql -u root -p < company.sql
```

Or with explicit host/port:

```bash
mysql -h 127.0.0.1 -P 3306 -u root -p < company.sql
```

After import, verify quickly:

```bash
mysql -u root -p -e "USE company; SELECT COUNT(*) AS departments FROM department;"
```

## Configure Connection

Open `python-db-api/mysql_connect.py` and update the `config` dictionary in `test_connection()`:

- `host`
- `port`
- `user`
- `password`
- `database`

Set `database` to `company` if you imported `company.sql` without changes.

## Run

From `python-db-api/`:

```bash
python mysql_connect.py
```

If successful, rows from `department` are printed and then:

```text
MySQL connection closed.
```

## 常見問題

- Authentication error: verify username/password and auth plugin settings.
- Connection refused: verify MySQL is running and listening on the configured host/port.
- Unknown database/table: run `company.sql` again, or update query/config values.
- Missing package: install `mysql-connector-python` in the active Python environment.

## Notes

- For learning/demo use only: avoid hardcoding credentials in real projects.
- Prefer environment variables or a `.env` file for sensitive settings in production.
