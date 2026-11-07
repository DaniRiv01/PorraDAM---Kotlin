package org.elcampico.porradam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.elcampico.porradam.ui.MainScreen
import org.elcampico.porradam.ui.theme.PorraDAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PorraDAMTheme {
                MainScreen()
            }
        }
    }
}
