package org.shettyyttehs.counter.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.shettyyttehs.counter.MyApplication

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val context = MyApplication.Context
        return AndroidSqliteDriver(AppDatabase.Schema, context, "counter.db")
    }
}

actual val databaseFactory by lazy {
    DatabaseDriverFactory()
}