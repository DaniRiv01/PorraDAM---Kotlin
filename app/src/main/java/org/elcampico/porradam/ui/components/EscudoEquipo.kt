package org.elcampico.porradam.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porradam.R
import org.elcampico.porradam.data.model.Equipo

@Composable
fun EscudoEquipo(equipo: Equipo, modifier: Modifier = Modifier) {
    if (equipo.imagenResId != null) {
        Image(
            painter = painterResource(id = equipo.imagenResId),
            contentDescription = equipo.nombre,
            contentScale = ContentScale.Fit,
            modifier = modifier
        )
    } else {
        val backgroundColor = Color(equipo.colorHex)
        val contentColor = if (backgroundColor.luminance() > 0.5f) Color.Black else Color.White

        Box(
            modifier = modifier
                .background(color = backgroundColor, shape = CircleShape)
                .border(width = 1.dp, color = Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = equipo.siglas,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun EscudoEquipoPreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        EscudoEquipo(
            equipo = Equipo(
                id = "1",
                nombre = "Real Madrid",
                siglas = "RMA",
                colorHex = 0xFFFFFFFF
            ),
            modifier = Modifier.size(48.dp)
        )
        EscudoEquipo(
            equipo = Equipo(
                id = "2",
                nombre = "Equipo Imagen",
                siglas = "IMG",
                colorHex = 0xFF000000,
                imagenResId = R.drawable.ic_launcher_foreground
            ),
            modifier = Modifier.size(48.dp)
        )
    }
}
