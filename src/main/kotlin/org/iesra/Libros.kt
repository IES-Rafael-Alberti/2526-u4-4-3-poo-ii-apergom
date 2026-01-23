// Clase Libro
data class Libro(val titulo: String, val autor: String, val paginas: Int, val calificacion: Int)

// Clase ConjuntoLibros
class ConjuntoLibros {
    private val libros = arrayOfNulls<Libro>(5)

    fun añadirLibro(libro: Libro): Boolean {
        for (i in libros.indices) {
            if (libros[i] == null) {
                libros[i] = libro
                return true
            }
        }
        return false
    }

    fun eliminarPorTitulo(titulo: String) {
        for (i in libros.indices) {
            if (libros[i]?.titulo == titulo) {
                libros[i] = null
            }
        }
    }

    fun eliminarPorAutor(autor: String) {
        for (i in libros.indices) {
            if (libros[i]?.autor == autor) {
                libros[i] = null
            }
        }
    }

    fun mostrarMejorPeorCalificacion() {
        val mejor = libros.filterNotNull().maxByOrNull { it.calificacion }
        val peor = libros.filterNotNull().minByOrNull { it.calificacion }
        println("Mejor calificado: $mejor")
        println("Peor calificado: $peor")
    }

    fun mostrarTodo() {
        libros.filterNotNull().forEach { println(it) }
    }
}

// Programa principal
fun main() {
    val libro1 = Libro("Libro A", "Autor A", 200, 8)
    val libro2 = Libro("Libro B", "Autor B", 150, 9)

    val conjunto = ConjuntoLibros()
    conjunto.añadirLibro(libro1)
    conjunto.añadirLibro(libro2)

    conjunto.eliminarPorTitulo("Libro A")
    conjunto.eliminarPorAutor("Autor B")

    conjunto.añadirLibro(libro1)
    conjunto.mostrarTodo()
}