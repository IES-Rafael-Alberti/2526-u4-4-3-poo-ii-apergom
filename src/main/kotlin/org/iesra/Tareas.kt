import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Tarea(val id: Int, val descripcion: String, var realizada: Boolean = false, var fechaRealizada: String? = null)

// Clase ListaTareas
class ListaTareas {
    private val tareas = mutableListOf<Tarea>()
    private var proximoId = 1

    fun agregarTarea(descripcion: String) {
        tareas.add(Tarea(proximoId++, descripcion))
    }

    fun eliminarTarea(id: Int) {
        tareas.removeIf { it.id == id }
    }

    fun cambiarEstado(id: Int) {
        val tarea = tareas.find { it.id == id }
        tarea?.let {
            if (!it.realizada) {
                val fechaHoraActual = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                it.fechaRealizada = fechaHoraActual.format(formatter)
            }
            it.realizada = !it.realizada
        }
    }

    fun mostrarTodas() = tareas.forEach { println(it) }
    fun mostrarPendientes() = tareas.filter { !it.realizada }.forEach { println(it) }
    fun mostrarRealizadas() = tareas.filter { it.realizada }.forEach { println(it) }
}

// Programa principal
fun main() {
    val lista = ListaTareas()
    lista.agregarTarea("Aprender Kotlin")
    lista.agregarTarea("Hacer ejercicio")

    lista.cambiarEstado(1)

    println("Tareas realizadas:")
    lista.mostrarRealizadas()

    println("Todas las tareas:")
    lista.mostrarTodas()
}