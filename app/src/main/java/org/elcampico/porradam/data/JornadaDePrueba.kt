package org.elcampico.porradam.data

import org.elcampico.porradam.R
import org.elcampico.porradam.data.model.Equipo
import org.elcampico.porradam.data.model.Marcador
import org.elcampico.porradam.data.model.Participante
import org.elcampico.porradam.data.model.Partido

object JornadaDePrueba {
    val participantes = listOf(
        Participante(1, "LUCÍA R.", 45, false),
        Participante(2, "PabloDev", 41, false),
        Participante(3, "Nerea_K", 40, false),
        Participante(4, "Tú - mcoma", 38, true),
        Participante(5, "Hugo M.", 35, false),
        Participante(6, "Aitana", 33, false),
        Participante(7, "xavier.dev", 30, false),
        Participante(8, "Iván G.", 27, false),
        Participante(9, "Sara P.", 26, false),
        Participante(10, "Dani_804", 19, false)
    )

    val partidos = listOf(
        Partido(
            id = "1",
            equipoLocal = Equipo("ATM", "Atlético Madrid", "ATM", 0xFFE30613, R.drawable.escudo_atm),
            equipoVisitante = Equipo("RMA", "Real Madrid", "RMA", 0xFFFFFFFF, R.drawable.escudo_rma),
            resultadoReal = Marcador(2, 1),
            porraUsuario = Marcador(2, 1),
            puntosObtenidos = 8
        ),
        Partido(
            id = "2",
            equipoLocal = Equipo("FCB", "FC Barcelona", "FCB", 0xFFA50044, R.drawable.escudo_fcb),
            equipoVisitante = Equipo("VIL", "Villarreal CF", "VIL", 0xFFF3E500, R.drawable.escudo_vil),
            resultadoReal = Marcador(3, 0),
            porraUsuario = Marcador(2, 0),
            puntosObtenidos = 4
        ),
        Partido(
            id = "3",
            equipoLocal = Equipo("SEV", "Sevilla FC", "SEV", 0xFFFFFFFF, R.drawable.escudo_sev),
            equipoVisitante = Equipo("RSO", "Real Sociedad", "RSO", 0xFF0067B1, R.drawable.escudo_rso),
            resultadoReal = Marcador(1, 1),
            porraUsuario = Marcador(1, 0),
            puntosObtenidos = 2
        ),
        Partido(
            id = "4",
            equipoLocal = Equipo("BET", "Betis", "BET", 0xFF00965E, R.drawable.escudo_bet),
            equipoVisitante = Equipo("VAL", "Valencia CF", "VAL", 0xFFFFFFFF, R.drawable.escudo_val),
            resultadoReal = Marcador(2, 1),
            porraUsuario = Marcador(1, 1),
            puntosObtenidos = 0
        ),
        Partido(
            id = "5",
            equipoLocal = Equipo("ATH", "Athletic Club", "ATH", 0xFFED1C24, R.drawable.escudo_ath),
            equipoVisitante = Equipo("CEL", "Celta de Vigo", "CEL", 0xFF8CB8D9, R.drawable.escudo_cel),
            resultadoReal = Marcador(1, 0),
            porraUsuario = Marcador(1, 0),
            puntosObtenidos = 8
        )
    )
}
