package org.elcampico.porradam.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porradam.R
import org.elcampico.porradam.ui.components.BarraNavegacion
import org.elcampico.porradam.ui.navigation.AppRouter
import org.elcampico.porradam.ui.navigation.Rutas
import org.elcampico.porradam.ui.screens.PantallaBienvenida
import org.elcampico.porradam.ui.screens.PantallaClasificacion
import org.elcampico.porradam.ui.screens.PantallaJornada
import org.elcampico.porradam.ui.screens.PantallaResultados

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val rutaActual = AppRouter.rutaActual

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo_pantalla_hd),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .scale(1.3f)
                .offset(y = (-40).dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Black.copy(alpha = 0.6f),
                            Color.Black.copy(alpha = 0.95f)
                        )
                    )
                )
        )
        
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                if (rutaActual != Rutas.BIENVENIDA) {
                    TopAppBar(
                        title = {
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                                Text("Porra DAM", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp)
                            }
                        },
                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.Menu, contentDescription = null, tint = Color.White)
                            }
                        },
                        actions = {
                            Box(
                                modifier = Modifier
                                    .padding(end = 16.dp)
                                    .background(Color(0xFFE8F5E9), RoundedCornerShape(16.dp))
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("38 pts", color = Color(0xFF00965E), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
                    )
                }
            },
            bottomBar = { BarraNavegacion() }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                when (rutaActual) {
                    Rutas.BIENVENIDA -> PantallaBienvenida()
                    Rutas.JORNADA -> PantallaJornada()
                    Rutas.RESULTADOS -> PantallaResultados()
                    Rutas.CLASIFICACION -> PantallaClasificacion()
                    Rutas.PERFIL -> Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp)
                            .background(
                                color = Color(0xFFF1F5F9),
                                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                            )
                    )
                }
            }
        }
    }
}
