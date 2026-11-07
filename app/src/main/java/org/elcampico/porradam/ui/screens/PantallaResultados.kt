package org.elcampico.porradam.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porradam.data.JornadaDePrueba
import org.elcampico.porradam.data.model.Partido
import org.elcampico.porradam.ui.components.EscudoEquipo

@Composable
fun PantallaResultados() {
    val partidos = JornadaDePrueba.partidos
    val totalPuntos = partidos.sumOf { it.puntosObtenidos ?: 0 }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Resultados", color = Color(0xFF1E2328), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier
                        .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Jornada 1", fontSize = 14.sp, color = Color(0xFF1E2328))
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Gray)
                }
            }
            Text(
                text = "Resultados oficiales y puntos obtenidos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 16.dp),
                fontSize = 15.sp,
                color = Color.Gray
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize().background(Color(0xFFF1F5F9)),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(partidos) { partido ->
                    ItemResultado(partido)
                }
                item {
                    Spacer(modifier = Modifier.height(4.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFB300), modifier = Modifier.size(24.dp))
                                Spacer(modifier = Modifier.width(12.dp))
                                Text("Total jornada", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color(0xFF1E2328))
                            }
                            Text("+$totalPuntos pts", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFF00965E))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun ItemResultado(partido: Partido) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    EscudoEquipo(equipo = partido.equipoLocal, modifier = Modifier.size(32.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(partido.equipoLocal.nombre, fontSize = 15.sp, color = Color(0xFF1E2328))
                    Spacer(modifier = Modifier.weight(1f))
                    Text(partido.resultadoReal?.golesLocal?.toString() ?: "-", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E2328))
                    Spacer(modifier = Modifier.width(32.dp))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    EscudoEquipo(equipo = partido.equipoVisitante, modifier = Modifier.size(32.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(partido.equipoVisitante.nombre, fontSize = 15.sp, color = Color(0xFF1E2328))
                    Spacer(modifier = Modifier.weight(1f))
                    Text(partido.resultadoReal?.golesVisitante?.toString() ?: "-", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E2328))
                    Spacer(modifier = Modifier.width(32.dp))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    Spacer(modifier = Modifier.width(44.dp))
                    PillTuPorra(partido)
                }
            }
            BadgePuntos(puntos = partido.puntosObtenidos ?: 0)
        }
    }
}

@Composable
fun PillTuPorra(partido: Partido) {
    val puntos = partido.puntosObtenidos ?: 0
    val backgroundColor = when (puntos) {
        8 -> Color(0xFFE8F5E9)
        0 -> Color(0xFFFFEBEE)
        else -> Color(0xFFF5F5F5)
    }
    val textColor = when (puntos) {
        8 -> Color(0xFF00965E)
        0 -> Color(0xFFE30613)
        else -> Color(0xFF757575)
    }

    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = "Tu porra: ${partido.porraUsuario?.golesLocal ?: "-"} - ${partido.porraUsuario?.golesVisitante ?: "-"}",
            fontSize = 12.sp,
            color = textColor,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BadgePuntos(puntos: Int) {
    val backgroundColor = when (puntos) {
        8 -> Color(0xFFE8F5E9)
        0 -> Color(0xFFFFEBEE)
        else -> Color(0xFFF5F5F5)
    }
    val textColor = when (puntos) {
        8 -> Color(0xFF00965E)
        0 -> Color(0xFFE30613)
        else -> Color(0xFF616161)
    }
    val prefix = if (puntos > 0) "+" else ""

    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$prefix$puntos",
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
