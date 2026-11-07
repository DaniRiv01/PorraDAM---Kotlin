package org.elcampico.porradam

import org.elcampico.porradam.data.model.Marcador
import org.elcampico.porradam.domain.PuntuacionUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class PuntuacionUseCaseTest {

    @Test
    fun calcularPuntos_resultadoExacto_devuelve8() {
        val real = Marcador(2, 1)
        val porra = Marcador(2, 1)
        val resultado = PuntuacionUseCase.calcularPuntos(real, porra)
        assertEquals(8, resultado)
    }

    @Test
    fun calcularPuntos_aciertoSignoYGolesLocal_devuelve4() {
        val real = Marcador(2, 1)
        val porra = Marcador(2, 0)
        val resultado = PuntuacionUseCase.calcularPuntos(real, porra)
        assertEquals(4, resultado)
    }

    @Test
    fun calcularPuntos_aciertoSigno_devuelve2() {
        val real = Marcador(3, 1)
        val porra = Marcador(2, 0)
        val resultado = PuntuacionUseCase.calcularPuntos(real, porra)
        assertEquals(2, resultado)
    }

    @Test
    fun calcularPuntos_aciertoGolesLocal_devuelve2() {
        val real = Marcador(1, 2)
        val porra = Marcador(1, 1)
        val resultado = PuntuacionUseCase.calcularPuntos(real, porra)
        assertEquals(2, resultado)
    }

    @Test
    fun calcularPuntos_falloTotal_devuelve0() {
        val real = Marcador(2, 1)
        val porra = Marcador(0, 3)
        val resultado = PuntuacionUseCase.calcularPuntos(real, porra)
        assertEquals(0, resultado)
    }
}
