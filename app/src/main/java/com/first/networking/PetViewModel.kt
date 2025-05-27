package com.first.networking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class PetViewModel : ViewModel() {
    private val repository = PetRepository()
    private val _pets = mutableStateOf<List<Pet>>(emptyList())
    val pets: State<List<Pet>> = _pets

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    init {
        loadPets()
    }

    private fun loadPets() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _pets.value = repository.fetchPets()
            } catch (e: Exception) {
                _error.value = "Error fetching pets"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
