package com.example.bmicalculator

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class BmiViewModel : ViewModel() {

    var heightInput by mutableStateOf("")
        private set

    var weightInput by mutableStateOf("")
        private set

    var bmi by mutableStateOf(0.0)
        private set

    fun onHeightChanged(newHeight: String) {
        heightInput = newHeight.replace(',', '.')
        calculateBmi()
    }

    fun onWeightChanged(newWeight: String) {
        weightInput = newWeight.replace(',', '.')
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = heightInput.toDoubleOrNull() ?: 0.0
        val weight = weightInput.toDoubleOrNull() ?: 0.0
        bmi = if (weight > 0 && height > 0) weight / (height * height) else 0.0
    }
}