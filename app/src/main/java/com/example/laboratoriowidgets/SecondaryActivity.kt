package com.example.laboratoriowidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Pantalla de destino alternativa que simula la sección interna de trabajo del proyecto final
class SecondaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    WorkspaceInfoContent()
                }
            }
        }
    }
}

@Composable
fun WorkspaceInfoContent() {
    Text(
        text = "¡Has ingresado con éxito al Panel de Trabajo del proyecto desde el Widget!",
        modifier = Modifier.padding(16.dp)
    )
}