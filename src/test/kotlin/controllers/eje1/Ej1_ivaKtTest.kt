package controllers.eje1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate

class Ej1_ivaKtTest {

    @Test
    fun calculaCorrectamenteParaPrecioCero() {
        val precio = 0.0
        val fecha = LocalDate.of(2012, 7, 16)
        val resultado = calcularIVA(precio, "GENERAL", fecha)
        assertEquals(0.0, resultado, 0.01) // El IVA sobre 0.0 sigue siendo 0.0
    }

    @Test
    fun calculaIVAREDUCIDOCorrectamenteEnFecha2012() {
        val precio = 200.0
        val fecha = LocalDate.of(2012, 7, 16)
        val resultado = calcularIVA(precio, "REDUCIDO", fecha)
        assertEquals(220.0, resultado, 0.01) // 10% aplicado
    }

    @Test
    fun lanzarExcepcionParaTipoIVAnoValido() {
        val precio = 200.0
        val fecha = LocalDate.of(2012, 7, 16)
        val resultado = calcularIVA(precio, tipoIva = "INVALIDO", fecha)
        assertEquals(220, resultado)
    }

    @Test
    fun lanzarExcepcionParaTipoIVAnoValidoTestQueNoPasaría() {
        val precio = 500.0
        val fecha = LocalDate.of(2012, 7, 16)

        // Intentamos con un tipo de IVA no válido
        val exception = assertThrows(IllegalArgumentException::class.java) {
            calcularIVA(precio, "INVALIDO", fecha)
        }

        // Suponiendo que la función no lanza la excepción correctamente, esto fallará
        assertEquals("Tipo de IVA no válido", exception.message)
    }


}