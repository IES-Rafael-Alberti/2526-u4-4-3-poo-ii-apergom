// Clase Domicilio
data class Domicilio(val calle: String, val numero: Int) {
    fun dirCompleta(): String {
        return "$calle $numero"
    }
}

// Clase Cliente
data class Cliente(val nombre: String, val domicilio: Domicilio)

// Clase Compra
data class Compra(val cliente: Cliente, val dia: String, val monto: Double)

// Clase RepositorioCompras
class RepositorioCompras {
    private val compras: MutableList<Compra> = mutableListOf()

    fun agregarCompra(compra: Compra) {
        compras.add(compra)
    }

    fun domicilios(): Set<String> {
        return compras.map { it.cliente.domicilio.dirCompleta() }.toSet()
    }
}

// Programa principal
fun main() {
    val domicilio1 = Domicilio("Calle Luna", 123)
    val cliente1 = Cliente("Juan Pérez", domicilio1)
    val compra1 = Compra(cliente1, "2026-01-23", 150.0)

    val repositorio = RepositorioCompras()
    repositorio.agregarCompra(compra1)

    println("Domicilios únicos:")
    repositorio.domicilios().forEach { println(it) }
}