package com.example.laboratoriowidgets

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

// Enlace obligatorio exigido por Android para conectar los cambios de estado del widget con la interfaz de Jetpack Glance
class SimpleWidget : GlanceAppWidgetReceiver() {
    // Especifica la clase que contiene las directrices de diseño del widget gráfico
    override val glanceAppWidget: GlanceAppWidget = SimpleWidgetContent()
}