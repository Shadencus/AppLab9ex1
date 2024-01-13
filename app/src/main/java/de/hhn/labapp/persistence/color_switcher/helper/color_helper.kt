package de.hhn.labapp.persistence.color_switcher.helper

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

abstract class ColorHelper {
    companion object {
        fun getRandomColor(): Color {
            return Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat())
        }
    }
}