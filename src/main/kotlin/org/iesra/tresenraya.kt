// Clase Jugador
data class Jugador(val nombre: String, val simbolo: Char)

// Clase Tablero
class Tablero {
    private val tablero: Array<CharArray> = Array(3) { CharArray(3) { ' ' } }

    fun mostrarTablero() {
        for (fila in tablero) {
            println(fila.joinToString(" | "))
            println("-".repeat(5))
        }
    }

    fun realizarMovimiento(fila: Int, columna: Int, simbolo: Char): Boolean {
        if (fila in 0..2 && columna in 0..2 && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = simbolo
            return true
        }
        return false
    }

    fun hayGanador(simbolo: Char): Boolean {
        // Comprobar filas y columnas
        for (i in 0..2) {
            if ((tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo) ||
                (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo)
            ) {
                return true
            }
        }
        // Comprobar diagonales
        if ((tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) ||
            (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo)
        ) {
            return true
        }
        return false
    }

    fun tableroLleno(): Boolean {
        return tablero.all { fila -> fila.all { it != ' ' } }
    }
}

// Programa principal
fun main() {
    val jugador1 = Jugador("Jugador 1", 'X')
    val jugador2 = Jugador("Jugador 2", 'O')
    val tablero = Tablero()

    var turnoJugador1 = true
    var juegoEnCurso = true

    println("¡Bienvenidos al Tres en Raya!")
    tablero.mostrarTablero()

    while (juegoEnCurso) {
        val jugadorActual = if (turnoJugador1) jugador1 else jugador2
        println("${jugadorActual.nombre}, es tu turno (${jugadorActual.simbolo}).")

        println("Introduce la fila (0-2):")
        val fila = readLine()?.toIntOrNull() ?: -1
        println("Introduce la columna (0-2):")
        val columna = readLine()?.toIntOrNull() ?: -1

        if (tablero.realizarMovimiento(fila, columna, jugadorActual.simbolo)) {
            tablero.mostrarTablero()

            if (tablero.hayGanador(jugadorActual.simbolo)) {
                println("¡${jugadorActual.nombre} ha ganado!")
                juegoEnCurso = false
            } else if (tablero.tableroLleno()) {
                println("¡Empate!")
                juegoEnCurso = false
            } else {
                // Cambiar turno al siguiente jugador
                turnoJugador1 = !turnoJugador1
            }
        } else {
            println("Movimiento no válido. Intenta nuevamente.")
        }
    }
    println("Fin del juego. ¡Gracias por jugar!")
}