# Database Systems Course Sample Codes

This repository contains small, focused sample programs used in a Database Systems course.

## Current Sample

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

## Configure Connection

Open `python-db-api/mysql_connect.py` and update the `config` dictionary in `test_connection()`:

- `host`
- `port`
- `user`
- `password`
- `database`

Make sure the selected database/table exists (the current query expects a `department` table).

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
- Unknown database/table: create the database/table or update the query/config values.
- Missing package: install `mysql-connector-python` in the active Python environment.

## Notes

- For learning/demo use only: avoid hardcoding credentials in real projects.
- Prefer environment variables or a `.env` file for sensitive settings in production.
