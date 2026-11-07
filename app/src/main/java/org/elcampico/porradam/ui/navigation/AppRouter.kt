package org.elcampico.porradam.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object AppRouter {
    var rutaActual by mutableStateOf(Rutas.BIENVENIDA)

    fun navegar(ruta: Rutas) {
        rutaActual = ruta
    }
}
