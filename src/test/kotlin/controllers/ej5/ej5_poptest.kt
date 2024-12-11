package controllers.ej5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ej5_poptest {

    @Test
    fun poptest() {
        //No se puede eliminar, cima = -2
        var pila1 = arrayOf(10, 20)
        var cima1 = -2
        cima1 = pop(pila1, cima1)
        assert(cima1 == -2)
    }

    @Test
    fun poptest2() {
        //Pila vacia
        var pila3 = arrayOf<Int>()
        var cima3 = -1
        cima3 = pop(pila3, cima3)
        assert(cima3 == -1)
    }
    @Test
    fun poptest3() {
        //
        val pila = arrayOf(10, 20, 30, 0, 0)
        var cima = 2

        cima = pop(pila, cima)

        assertEquals(1, cima)
    }

}