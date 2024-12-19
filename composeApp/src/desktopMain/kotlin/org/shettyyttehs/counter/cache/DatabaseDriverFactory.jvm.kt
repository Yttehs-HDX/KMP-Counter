package org.shettyyttehs.counter.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import java.io.File

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val dbPath = getDatabasePath()
        val driver = JdbcSqliteDriver(
            url = "jdbc:sqlite:$dbPath"
        )

        return driver.apply {
            // Create the database if it doesn't exist
            val dbFile = File(dbPath)
            if (!dbFile.exists()) {
                AppDatabase.Schema.create(driver)
            }
        }
    }
}

actual val databaseFactory by lazy {
    DatabaseDriverFactory()
}

fun getDatabasePath(): String {
    // Test environment
    return "counter.db"
}