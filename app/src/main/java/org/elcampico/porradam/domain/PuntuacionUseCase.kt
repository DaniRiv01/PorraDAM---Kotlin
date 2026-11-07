package org.elcampico.porradam.domain

import org.elcampico.porradam.data.model.Marcador

object PuntuacionUseCase {
    fun calcularPuntos(real: Marcador, porra: Marcador): Int {
        if (real.golesLocal == porra.golesLocal && real.golesVisitante == porra.golesVisitante) {
            return 8
        }
        var puntos = 0
        val signoReal = real.golesLocal.compareTo(real.golesVisitante)
        val signoPorra = porra.golesLocal.compareTo(porra.golesVisitante)
        if (signoReal == signoPorra) {
            puntos += 2
        }
        if (real.golesLocal == porra.golesLocal) {
            puntos += 2
        }
        if (real.golesVisitante == porra.golesVisitante) {
            puntos += 2
        }
        return puntos
    }
}
