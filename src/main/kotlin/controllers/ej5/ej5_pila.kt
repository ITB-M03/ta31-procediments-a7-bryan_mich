package controllers.ej5
import java.util.*

fun main() {
    val scanner = abrirScanner()
    val pila = Array(10) { 0 }
    val cima = iniciarCima()

    gestionarPila(pila, cima, scanner)

    cerrarScanner(scanner)
}

/**
 * Inicia la variable cima para gestionarla, el valor inicial de la cima (-1, indicando que la pila está vacía).
 * @return
 */
fun iniciarCima(): Int {
    val resultado : Int
    resultado = -1
    return resultado
}

/**
 * Controla el menú principal para gestionar la pila.
 * @param pila Array que representa la pila.
 * @param cimaInicial controla la cima de la pila.
 * @param scanner Scanner para leer opciones del usuario.
 */
fun gestionarPila(pila: Array<Int>, cimaInicial: Int, scanner: Scanner) {
    var cima = cimaInicial
    var salir = false
    while (!salir) {
        when (mostrarMenu(scanner)) {
            1 -> cima = push(pila, cima, scanner)
            2 -> cima = pop(pila, cima)
            3 -> mostrarPila(pila, cima)
            4 -> {
                println("Exit")
                salir = true
            }
            else -> println("Intentalo de nuevo -_-7")
        }
    }
}

/**
 * Muestra el menú de opciones y devuelve la opcion elegida.
 * @author Bryan
 * @version 1.1
 * @since 9/12/24
 * @param scanner Scanner para leer la entrada.
 * @return.
 */
fun mostrarMenu(scanner: Scanner): Int {
    println("Menú de Pila:")
    println("1. Añadir número (push)")
    println("2. Sacar número (pop)")
    println("3. Mostrar contenido de la pila")
    println("4. Salir")
    print("Seleccione una opción: ")
    return scanner.nextInt()
}

/**
 * Añade un número a la pila si hay espacio.
 * @author Bryan
 * @version 1.1
 * @since 9/12/24
 * @param pila Array que representa la pila.
 * @param cima la cima de la pila.
 * @param scanner Scanner para leer el numero.
 */
fun push(pila: Array<Int>, cima: Int, scanner: Scanner): Int {
    return if (cima < pila.size - 1) {
        print("Introduce un numero: ")
        val numero = scanner.nextInt()
        pila[cima + 1] = numero
        println("Numero $numero añadido a la pila.")
        cima + 1
    } else {
        println("No se puede añadir más elementos!! Pila llena.")
        cima
    }
}

/**
 * Extrae un número de la pila si no está vacía.
 * @author Bryan
 * @version 1.1
 * @since 9/12/24
 * @param pila Array que representa la pila.
 * @param cima la cima de la pila.
 * @return
 */
fun pop(pila: Array<Int>, cima: Int): Int {
    return if (cima >= 0) {
        println("Número ${pila[cima]} eliminado de la pila.")
        cima - 1
    } else {
        println("La pila está vacía, no se puede sacar ningún elemento.")
        cima
    }
}

/**
 * Muestra el contenido de la pila.
 * @author Bryan
 * @version 1.1
 * @since 9/12/24
 * @param pila Array que representa la pila.
 * @param cima la cima de la pila.
 *
 */
fun mostrarPila(pila: Array<Int>, cima: Int) {
    if (cima >= 0) {
        println("Contenido de la pila:")
        for (i in cima downTo 0) {
            println("[$i] -> ${pila[i]}")
        }
    } else {
        println("La pila está vacía.")
    }
}

/**
 * Abre Scanner.
 * @author Bryan
 * @version 1.1
 * @since 9/12/24
 * @param scanner inicio de scanner
 * @return Una nueva instancia de Scanner.
 */
fun abrirScanner(): Scanner {
    val scanner = Scanner(System.`in`)
    return scanner
}

/**
 * Cierra el Scanner.
 * @author Bryan
 * @version 1.1
 * @since 9/12/24
 * @param scanner cierra scanner.
 */
fun cerrarScanner(scanner: Scanner) {
    scanner.close()
}
