package controllers.eje2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Ej2_RomanosKtTest {


    @Test
    fun Convertir3999ARomano() {
        val resultado = roman(3999)
        assertEquals("MMMCMXCIX", resultado)
    }

    @Test
    fun Convertir1000ARomano() {
        val resultado = roman(1000)
        assertEquals("M", resultado)
    }

    @Test
    fun convertir500ARomano() {
        val resultado = roman(500)
        assertEquals("D", resultado)
    }

    @Test
    fun convertir0LanzaMensajePeroRetornaCadenaVacia() {
        val resultado = roman(0)
        assertEquals("", resultado)
    }


    @Test
    fun convertirNumeroNegativoLanzaMensajeRetornaCadenaVacia() {
        val resultado = roman(-5)
        assertEquals("", resultado)
    }


}