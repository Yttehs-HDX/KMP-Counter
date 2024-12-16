package org.shettyyttehs.counter.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.shettyyttehs.counter.cache.Database
import org.shettyyttehs.counter.cache.DatabaseDriverFactory

class NumberViewModel(databaseDriverFactory: DatabaseDriverFactory) : ViewModel() {
    private val database = Database(databaseDriverFactory)

    private val _currentNumber = MutableStateFlow(0L)
    init {
        viewModelScope.launch {
            try {
                database.getNumber()
            } catch (e: Exception) {
                database.initNumber()
            }
            _currentNumber.value = database.getNumber()
        }
    }

    val currentNumber
        get() = _currentNumber

    fun increaseNumber() {
        // memory increment
        ++_currentNumber.value

        viewModelScope.launch {
            // database increment
            database.setNumber(_currentNumber.value)
        }
    }
}