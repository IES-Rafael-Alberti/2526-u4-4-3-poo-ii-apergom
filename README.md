# Práctica 4.3: Programación Orientada a Objetos II

## Identificación de la Actividad

- **ID de la Actividad:** POO-Práctica-4.3
- **Módulo:** Programación (`PROG`)
- **Unidad de Trabajo:** 4 - Programación Orientada a Objetos II
- **Fecha de Creación:** 2026-01-23
- **Fecha de Entrega:** 23/01
- **Alumno(s):**
  - **Nombre y Apellidos:** Antonio Manuel Perez Gomez
  - **Correo electrónico:** apergom459w@g.educaand.es
  - **Iniciales del Alumno/Grupo:** AMPG

---

## Descripción de la Actividad

En esta práctica se desarrollaron varios ejercicios aplicando conceptos de Programación Orientada a Objetos (POO) en Kotlin. Cada uno de los ejercicios fue resuelto siguiendo las especificaciones dadas y aplicando principios básicos de diseño orientado a objetos, como encapsulación y modularidad, junto con el correcto uso de `data classes`, métodos, y estructuras de control.

Los ejercicios son los siguientes:

1. **Ejercicio 4.6:** Implementar un sistema básico de gestión de compras con clientes y domicilios utilizando clases como `Domicilio`, `Cliente`, `Compra` y `RepositorioCompras`.
2. **Ejercicio 4.7:** Crear un sistema de cuentas bancarias con `Cuenta` y `Persona`, incluyendo funcionalidades como abonar, pagar, y transferir entre cuentas, con validaciones para detectar morosidad.
3. **Ejercicio 4.8:** Diseñar una colección de libros con calificaciones y opciones para añadir, eliminar, y ordenar libros.
4. **Ejercicio 4.9:** Gestionar una lista de tareas para realizar, pendiente o completada, mostrando las tareas según su estado.
5. **Ejercicio 4.10:** Realizar un juego del tres en raya (ta-te-tí) utilizando POO, con clases `Jugador` y `Tablero`.

---

## Instrucciones de Compilación y Ejecución

### 1. **Requisitos Previos:**

   - **Lenguaje de programación:** Kotlin (versión 1.9 o superior recomendada)
   - **Entorno de desarrollo:** IntelliJ IDEA (o cualquier IDE compatible con Kotlin)
   - **Dependencias adicionales:** No se requieren dependencias externas.

### 2. **Pasos para Compilar el Código:**

   Navega al directorio donde están almacenados los archivos fuente. Luego, utiliza el siguiente comando:
   ```bash
   kotlinc <archivo>.kt -include-runtime -d output.jar
   ```

### 3. **Pasos para Ejecutar el Código:**

   Ejecuta el archivo generado después de la compilación con:
   ```bash
   java -jar output.jar
   ```

### 4. **Ejecución de Pruebas:**

   En caso de que el proyecto incluya pruebas automatizadas, estas se pueden ejecutar utilizando Gradle:
   ```bash
   ./gradlew test
   ```

---

## Desarrollo de la Actividad

### Descripción del Desarrollo

Para cada ejercicio, se identificaron las entidades principales y sus atributos, métodos y comportamientos. A continuación, se utilizó una arquitectura orientada a objetos para modelar cada ejercicio.

#### Ejercicio 4.6: Gestión de Compras
Este ejercicio implementa un sistema básico para gestionar compras, clientes y domicilios. Se crearon las siguientes clases:
- `Domicilio`: Representa un domicilio con calle y número.
- `Cliente`: Representa un cliente con un nombre y un domicilio asociado.
- `Compra`: Representa una compra realizada por un cliente en un día determinado con monto.
- `RepositorioCompras`: Sirve como almacenamiento y proporciona métodos para agregar compras y obtener domicilios únicos.

#### Ejercicio 4.7: Sistema de Cuentas Bancarias
En este ejercicio, las clases `Cuenta` y `Persona` se implementaron para representar un sistema bancario. Se incluyeron funcionalidades como:
- Consultar saldo, recibir abonos y realizar pagos.
- Transferencias entre cuentas.
- Verificar si una persona tiene cuentas morosas.

#### Ejercicio 4.8: Conjunto de Libros
Este ejercicio implementa una colección de libros con funcionalidades adicionales:
- Añadir y eliminar libros según el autor o el título.
- Mostrar los libros con calificación más alta, más baja o ver todo el contenido.

#### Ejercicio 4.9: Lista de Tareas Gestionable
Se diseñó una lista de tareas donde cada tarea tiene un identificador, una descripción y puede estar pendiente o completada. Se incluyeron funcionalidades para:
- Agregar, eliminar y cambiar el estado de las tareas.
- Mostrar tareas pendientes, todas, o realizadas con fecha.

#### Ejercicio 4.10: Juego del Tres en Raya
Se implementó un juego del tres en raya utilizando:
- `Jugador`: Contiene el nombre y símbolo del jugador ('X' o 'O').
- `Tablero`: Representa el tablero y contiene métodos para realizar movimientos, comprobar si hay un ganador o verificar si el tablero está lleno.

---

## Ejemplos de Ejecución

### Ejemplo 1: Gestión de Compras (Ejercicio 4.6)

- **Entrada:**
  ```plaintext
  Cliente: Juan Pérez
  Domicilio: Calle Luna 123
  Compra: Día "2026-01-23", Monto: 150.0€
  ```

- **Salida Esperada:**
  ```plaintext
  Domicilios únicos:
  Calle Luna 123
  ```

### Ejemplo 2: Tres en Raya (Ejercicio 4.10)
- **Entrada:**
  ```plaintext
  Jugador 1 realiza un movimiento en (0, 0)
  Jugador 2 realiza un movimiento en (1, 1)
  ...
  ```

- **Salida Esperada:**
  ```plaintext
  Jugador 1 ha ganado.
  ```

---

## Resultados de Pruebas

Todos los ejercicios fueron probados manualmente y cumplen con las especificaciones descritas. Ejemplos específicos y flujos de prueba están incluidos en las secciones relevantes de cada ejercicio.

---

## Documentación Adicional

- **Manual de Usuario:**
  Este programa es sencillo y de uso intuitivo en consola. Consulta el programa para obtener mensajes interactivos.

- **Permisos:**
  Asegúrate de que el profesor tiene permisos de lectura en el repositorio para revisar el código.

---

## Conclusiones

1. **POO aplicada:** Todos los ejercicios están diseñados aplicando conceptos básicos de la programación orientada a objetos en Kotlin, como encapsulación, herencia (en caso de ampliación) y clases de datos (`data class`).
2. **Clases y Objetos:** Se creó un modelo de solución estructurado y con interacciones claras entre clases, asegurando la extensibilidad del diseño.
3. **Lecciones Aprendidas:**
   - El diseño de clases debe enfocarse en la responsabilidad única (SRP: Single Responsibility Principle).
   - El flujo de control debe validarse para evitar inconsistencias y entradas incorrectas.
4. **Mejoras Futuras:**
   - Automatizar pruebas para verificar más casos de borde.
   - Ampliar funcionalidades, como soporte de persistencia o interfaz gráfica.

```