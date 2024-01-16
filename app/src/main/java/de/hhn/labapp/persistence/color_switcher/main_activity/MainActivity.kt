package de.hhn.labapp.persistence.color_switcher.main_activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.hhn.labapp.persistence.color_switcher.ui.theme.ColorPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorPickerTheme {
                ColorScreen(MainActivityViewModel())
            }
        }
    }
}



@Composable
fun ColorScreen(
    viewModel: MainActivityViewModel
) {
    val context: Context = LocalContext.current
    val sharedPreferencesRepository: SharedPreferencesRepository = remember {
        SharedPreferencesRepository(context)
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    Surface(modifier = Modifier.fillMaxSize(), color = sharedPreferencesRepository.readColor()) {
        Box(modifier = Modifier.clickable {
            viewModel.setNewColor()
            sharedPreferencesRepository.writeColor(uiState.backgroundColor)




        }, contentAlignment = Alignment.Center) {
            Text("Farbe: R:${uiState.backgroundColor.red} G:${uiState.backgroundColor.green} B:${uiState.backgroundColor.blue}")
        }
    }
}

class SharedPreferencesRepository(context: Context){
    private val preferences = context.getSharedPreferences(
        "name",
        Context.MODE_PRIVATE
    )

    fun writeColor(value: Color){
        val editor = preferences.edit()
        editor.putInt("farbe",value.toArgb())
        editor.apply()
    }

    fun readColor(): Color {
        var temp = preferences.getInt("farbe", 0)
        return Color(temp)
    }
}
