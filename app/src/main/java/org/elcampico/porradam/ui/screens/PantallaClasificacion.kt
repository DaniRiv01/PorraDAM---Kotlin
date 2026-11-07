package org.elcampico.porradam.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porradam.data.JornadaDePrueba
import org.elcampico.porradam.data.model.Participante

@Composable
fun PantallaClasificacion() {
    val participantes = JornadaDePrueba.participantes

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
                Text("Clasificación", color = Color(0xFF1E2328), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier
                        .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("General", fontSize = 14.sp, color = Color(0xFF1E2328))
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Gray)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("#", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.width(28.dp))
                Text("Participante", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.weight(1f))
                Text("Puntos", color = Color.Gray, fontSize = 12.sp)
            }
            HorizontalDivider(color = Color(0xFFE0E0E0), thickness = 1.dp)

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(participantes) { participante ->
                    ItemParticipante(participante)
                    HorizontalDivider(color = Color(0xFFF5F5F5), thickness = 1.dp)
                }
            }
        }
    }
}

@Composable
fun ItemParticipante(participante: Participante) {
    val backgroundColor = if (participante.esUsuarioActual) Color(0xFFE8F5E9) else Color.White
    val isPodium = participante.posicion in 1..3

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(horizontal = 20.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isPodium) {
            Box(
                modifier = Modifier
                    .width(28.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .background(getMedalColor(participante.posicion)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = participante.posicion.toString(),
                    color = if (participante.posicion == 2) Color(0xFF424242) else Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        } else {
            Box(
                modifier = Modifier.width(28.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = participante.posicion.toString(),
                    color = if (participante.esUsuarioActual) Color(0xFF00965E) else Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(getAvatarColor(participante.nombre)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = participante.nombre.take(1).uppercase(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Text(
            text = participante.nombre,
            modifier = Modifier.weight(1f),
            fontWeight = if (participante.esUsuarioActual) FontWeight.Bold else FontWeight.Medium,
            fontSize = 16.sp,
            color = Color(0xFF1E2328)
        )
        
        if (participante.posicion == 1) {
            Text("👑", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(8.dp))
        }
        
        Text(
            text = participante.puntos.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF1E2328)
        )
    }
}

fun getMedalColor(posicion: Int): Color {
    return when (posicion) {
        1 -> Color(0xFFFFB300)
        2 -> Color(0xFFE0E0E0)
        3 -> Color(0xFFFF8A65)
        else -> Color.Transparent
    }
}

fun getAvatarColor(nombre: String): Color {
    val colors = listOf(
        Color(0xFF5C6BC0), Color(0xFFAB47BC), Color(0xFF26A69A), 
        Color(0xFFFFA726), Color(0xFFEC407A), Color(0xFF29B6F6),
        Color(0xFF66BB6A), Color(0xFFFF7043)
    )
    val index = Math.abs(nombre.hashCode()) % colors.size
    return colors[index]
}
