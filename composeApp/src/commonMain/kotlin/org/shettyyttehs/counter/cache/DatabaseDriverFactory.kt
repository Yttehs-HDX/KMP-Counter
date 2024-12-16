package org.shettyyttehs.counter.cache

import app.cash.sqldelight.db.SqlDriver

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

expect val databaseFactory: DatabaseDriverFactory

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getNumber(): Long {
        return dbQuery.getNumber().executeAsOne()
    }

    internal fun setNumber(number: Long) {
        dbQuery.updateNumber(number)
    }

    internal fun initNumber() {
        dbQuery.insertNumber(0L)
    }
}