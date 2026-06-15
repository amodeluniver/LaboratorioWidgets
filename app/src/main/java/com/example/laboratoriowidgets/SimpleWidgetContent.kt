package com.example.laboratoriowidgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text

// Renderiza los elementos de control y diseño dentro de la cuadrícula en la pantalla de inicio del celular
class SimpleWidgetContent : GlanceAppWidget() {

    // Construye el contexto asíncrono para inyectar elementos visuales ligeros en el sistema operativo
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                DrawWidgetLayout()
            }
        }
    }

    // Composable propio de Glance encargado de agrupar los componentes visuales del Widget
    @Composable
    private fun DrawWidgetLayout() {
        Column(
            modifier = GlanceModifier.fillMaxSize()
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mensaje interrogativo descriptivo
            Text(
                text = "¿A dónde deseas ingresar?",
                modifier = GlanceModifier.padding(12.dp)
            )

            // Fila de botones para la redirección de flujos
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                // Botón 1: Redirige al flujo inicial de la aplicación
                Button(
                    text = "Principal",
                    onClick = actionStartActivity<MainActivity>()
                )

                // Botón 2: Redirige a la vista alternativa secundaria (Modificación solicitada)
                Button(
                    text = "Trabajo",
                    onClick = actionStartActivity<SecondaryActivity>()
                )
            }
        }
    }
}