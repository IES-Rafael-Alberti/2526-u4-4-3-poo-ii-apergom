// Clase Cuenta
data class Cuenta(val numeroCuenta: Int, var saldo: Double) {
    fun consultarSaldo(): Double = saldo

    fun abonar(cantidad: Double) {
        saldo += cantidad
    }

    fun pagar(cantidad: Double): Boolean {
        return if (cantidad <= saldo) {
            saldo -= cantidad
            true
        } else {
            false
        }
    }

    companion object {
        fun esMorosa(persona: Persona): Boolean {
            return persona.cuentas.any { it?.saldo ?: 0.0 < 0 }
        }

        fun transferencia(personaOrigen: Persona, cuentaOrigenId: Int, personaDestino: Persona, cuentaDestinoId: Int, cantidad: Double): Boolean {
            val cuentaOrigen = personaOrigen.cuentas[cuentaOrigenId]
            val cuentaDestino = personaDestino.cuentas[cuentaDestinoId]

            return if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.saldo >= cantidad) {
                cuentaOrigen.pagar(cantidad)
                cuentaDestino.abonar(cantidad)
                true
            } else {
                false
            }
        }
    }
}

// Clase Persona
data class Persona(val dni: String) {
    val cuentas = arrayOfNulls<Cuenta>(3)

    fun añadirCuenta(cuenta: Cuenta): Boolean {
        for (i in cuentas.indices) {
            if (cuentas[i] == null) {
                cuentas[i] = cuenta
                return true
            }
        }
        return false
    }
}

// Programa principal
fun main() {
    val persona = Persona("12345678A")
    val cuenta1 = Cuenta(1, 0.0)
    val cuenta2 = Cuenta(2, 700.0)

    persona.añadirCuenta(cuenta1)
    persona.añadirCuenta(cuenta2)

    cuenta1.abonar(1100.0)
    cuenta2.pagar(750.0)

    println("¿Es la persona morosa? ${Cuenta.esMorosa(persona)}")

    Cuenta.transferencia(persona, 0, persona, 1, 500.0)
    println("Saldo de las cuentas:")
    persona.cuentas.forEach { println(it) }
}