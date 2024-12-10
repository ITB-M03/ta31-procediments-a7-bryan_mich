package controllers.ej4
import java.util.*

fun main(){
    val scanner = abrirScanner()
    titol("Texto centrado")

    cerrarScanner(scanner)
}

/*FUNCION*/
fun titol(text: String) {
    // Amplio pantalla
    val ampliopantalla = 80

    // Longitud texto
    val longitudTexto = text.length

    // calcula centrado
    val espais = (ampliopantalla - longitudTexto) / 2

    // Muestra el texto centrado
    println(" ".repeat(espais) + text)
}
/**
 * Abrir Scanner
 * @author Bryan
 * @version 1.2
 * @since 10/12/2024
 *
 *
 * @param scanner abrimos el scanner
 * @return scanner
 */

fun abrirScanner(): Scanner{
    val scanner = Scanner(System.`in`)
    return scanner
}

/**
 * Cerrar Scanner
 * @author Bryan
 * @version 1.2
 * @since 10/12/2024
 *
 * @param scanner cerramos el scanner
 */

fun cerrarScanner(scanner: Scanner){
    scanner.close()
}