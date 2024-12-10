package controllers.ej5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Ej5_mostrarpilatest {

    @Test
    fun mostrarPilatest1() {

        //Indicar que la pila está vacía."
        val pila = arrayOf(0, 0, 0, 0, 0) // Pila vacía
        val cima = -1

        assertTrue(cima < 0)
    }
    @Test
    fun mostrarPilatest2() {
        val pila = arrayOf(10, 20, 0, 0, 0) // Pila parcialmente llena
        val cima = 1

        if (cima >= 0) {
            for (i in cima downTo 0) {
                assertEquals(pila[i], pila[i])
            }
        } else {
            fail("ERROR")
        }
    }
}