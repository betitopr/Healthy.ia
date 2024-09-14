package com.example.healthy.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserSelectionsViewModel : ViewModel() {
    // Lista para almacenar las selecciones
    private val _selections = mutableStateListOf<String>()
    val selections: List<String> get() = _selections

    // Variable para almacenar el peso
    var peso by mutableStateOf(70f) // Valor inicial, por ejemplo, 70 Kg
    var pesoObjetivo by mutableStateOf(70f)
        private set
    // Variable para almacenar el objetivo
    var objetivo by mutableStateOf("Perder peso")

    // MutableStateFlow para manejar el estado de altura
    private val _altura = MutableStateFlow(170f)
    val altura: StateFlow<Float> get() = _altura

    // Variable para almacenar la edad
    var edad by mutableStateOf(17) // Valor inicial, por ejemplo, 17 años

    // Variable para almacenar si realiza entrenamiento de fuerza
    var entrenamientoFuerza by mutableStateOf("No") // Valor inicial, por ejemplo, "No"

    // Variable para almacenar el género
    var genero by mutableStateOf("Femenino") // Valor inicial, por ejemplo, "Femenino"

    // Función para agregar una selección a la lista
    fun addSelection(selection: String) {
        _selections.add(selection)
    }

    // Función para actualizar la altura
    fun updateAltura(newAltura: Float) {
        _altura.value = newAltura
    }

    // Función para actualizar el peso
    fun updatePeso(newPeso: Float) {
        peso = newPeso
    }
    fun updatePesoObjetivo(newPesoObjetivo: Float) {
        pesoObjetivo= newPesoObjetivo
    }

    // Función para actualizar la edad
    fun updateEdad(newEdad: Int) {
        edad = newEdad
    }

    // Función para actualizar si realiza entrenamiento de fuerza
    fun updateEntrenamientoFuerza(newEntrenamientoFuerza: String) {
        entrenamientoFuerza = newEntrenamientoFuerza
    }

    // Función para actualizar el objetivo
    fun updateObjetivo(newObjetivo: String) {
        objetivo = newObjetivo
    }

    // Función para actualizar el género
    fun updateGenero(newGenero: String) {
        genero = newGenero
    }
}
