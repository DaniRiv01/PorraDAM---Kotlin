package org.elcampico.porradam.data.model

data class Partido(
    val id: String,
    val equipoLocal: Equipo,
    val equipoVisitante: Equipo,
    val resultadoReal: Marcador?,
    val porraUsuario: Marcador?,
    val puntosObtenidos: Int?
)
