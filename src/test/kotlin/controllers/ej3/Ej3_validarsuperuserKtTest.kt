package controllers.ej3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import validarSuperusuari
import java.util.*

class Ej3_validarsuperuserKtTest {

    // Función para simular el comportamiento del Scanner con entradas predefinidas
    fun crearScannerConEntradas(vararg entradas: String): Scanner {
        return Scanner(entradas.joinToString("\n"))
    }

    @Test
    fun accesoPermitidoPrimerIntento() {
        val scanner = crearScannerConEntradas("Itbcontraseña")  // Simula la contraseña correcta en el primer intento
        val resultado = validarSuperusuari(scanner)
        assertTrue(resultado, "El acceso debería permitirse si la contraseña es correcta en el primer intento.")
    }

    @Test
    fun entradaVaciaTresVecesAccesoDenegado() {
        val scanner = crearScannerConEntradas("", "", "")  // Simula entradas vacías
        val resultado = validarSuperusuari(scanner)
        assertFalse(resultado, "El acceso debería denegarse si las entradas son vacías en los 3 intentos.")
    }

    @Test
    fun accesoDenegadoDespuesDeTresIntentosFallidos() {
        val scanner = crearScannerConEntradas("incorrecta1", "incorrecta2", "incorrecta3")  // Todas las contraseñas son incorrectas
        val resultado = validarSuperusuari(scanner)
        assertFalse(resultado, "El acceso debería denegarse si las contraseñas son incorrectas en los 3 intentos.")
    }


}