package de.hhn.labapp.persistence.color_switcher.main_activity

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import de.hhn.labapp.persistence.color_switcher.helper.ColorHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainActivityState(Color(0)))
    val uiState: StateFlow<MainActivityState>
        get() = _uiState

    init {
        _uiState.value = _uiState.value.copy(backgroundColor = ColorHelper.getRandomColor())
    }

    fun setNewColor(){
        val color = ColorHelper.getRandomColor()
        _uiState.value = _uiState.value.copy(backgroundColor = color)
    }

}