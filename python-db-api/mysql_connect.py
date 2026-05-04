"""Simple DB-API MySQL connection example (local port 3306)."""

import mysql.connector
from mysql.connector import Error


def test_connection() -> None:
    # Update these values for your local MySQL setup.
    config = {
        "host": "127.0.0.1",
        "port": 3306,
        "user": "yourusername",
        "password": "yourpassword",
        "database": "company",
    }

    connection = None
    try:
        connection = mysql.connector.connect(**config)
        if connection.is_connected():
            cursor = connection.cursor()
            cursor.execute("SELECT * FROM department")
            while True:
                 row = cursor.fetchone()
                 if row == None:
                    break
                 print(row)
            # 如何轉換db欄位資料為特定型別?
            cursor.close()

    except Error as exc:
        print(exc)

    finally:
        if connection and connection.is_connected():
            connection.close()
            print("MySQL connection closed.")


if __name__ == "__main__":
    test_connection()
