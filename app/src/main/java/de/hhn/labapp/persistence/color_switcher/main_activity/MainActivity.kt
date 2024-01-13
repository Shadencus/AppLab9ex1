package de.hhn.labapp.persistence.color_switcher.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.hhn.labor.color_switcher.ui.theme.ColorPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorPickerTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    Heading(
                        "Persistence in Android",
                        32.sp,
                        Color(0xFF003462),
                    )
                    Heading("Exercise 1")
                    Text(
                        text = "Thanks for cloning the repository.\nThe base code for this exercise will be provided on a separate branch during the lecture"
                    )
                }
            }
        }
    }
}

@Composable
fun Heading(
    text: String,
    fontSize: TextUnit = 24.sp,
    color: Color = MaterialTheme.colorScheme.onSurface,
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        textAlign = TextAlign.Center,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        color = color,
        text = text,
    )
}
