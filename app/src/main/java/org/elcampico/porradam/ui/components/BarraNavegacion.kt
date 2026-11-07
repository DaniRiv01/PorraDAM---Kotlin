package org.elcampico.porradam.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.elcampico.porradam.ui.navigation.AppRouter
import org.elcampico.porradam.ui.navigation.Rutas

@Composable
fun BarraNavegacion() {
    val rutaActual = AppRouter.rutaActual
    if (rutaActual == Rutas.BIENVENIDA) return

    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = rutaActual == Rutas.JORNADA,
            onClick = { AppRouter.navegar(Rutas.JORNADA) },
            icon = { Icon(Icons.Default.DateRange, contentDescription = null) },
            label = { Text("Jornada") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF00965E),
                selectedTextColor = Color(0xFF00965E),
                indicatorColor = Color(0xFFE8F5E9),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = rutaActual == Rutas.RESULTADOS,
            onClick = { AppRouter.navegar(Rutas.RESULTADOS) },
            icon = { Icon(Icons.Default.SportsSoccer, contentDescription = null) },
            label = { Text("Resultados") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF00965E),
                selectedTextColor = Color(0xFF00965E),
                indicatorColor = Color(0xFFE8F5E9),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = rutaActual == Rutas.CLASIFICACION,
            onClick = { AppRouter.navegar(Rutas.CLASIFICACION) },
            icon = { Icon(Icons.Default.Leaderboard, contentDescription = null) },
            label = { Text("Clasificación") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF00965E),
                selectedTextColor = Color(0xFF00965E),
                indicatorColor = Color(0xFFE8F5E9),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = rutaActual == Rutas.PERFIL,
            onClick = { AppRouter.navegar(Rutas.PERFIL) },
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF00965E),
                selectedTextColor = Color(0xFF00965E),
                indicatorColor = Color(0xFFE8F5E9),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )
    }
}
