# Learning Java — Ruta de Aprendizaje

Bienvenido al repositorio de aprendizaje de Java. Este proyecto está organizado en módulos que siguen una progresión pedagógica: de los conceptos más básicos hasta los algoritmos de ordenamiento y búsqueda. Cada archivo incluye teoría detallada en sus comentarios de encabezado y ejemplos prácticos ejecutables.

---

## Estructura del Proyecto

```
learning-java/
├── sequencing-structures/      # Módulo 1: Estructura de Secuenciación
├── selections-structures/      # Módulo 2: Estructura de Selección
├── repetition-strctures/       # Módulo 3: Estructura de Repetición
│   └── Validations/            # Sub-módulo: Validación de entradas
│       ├── with_if/
│       └── with_try/
└── orderingStructures/         # Módulo 4: Ordenamiento y Búsqueda
```

---

## Ruta de Aprendizaje

Sigue las clases en el orden indicado. Cada clase construye sobre los conceptos de la anterior.

---

### Módulo 1 — Estructura de Secuenciación (`sequencing-structures/`)

La secuenciación es la base de todo programa: instrucciones que se ejecutan **una tras otra**, en orden.

| Clase | Archivo | Temas cubiertos |
|-------|---------|-----------------|
| **Clase 1** | `VariableTypes.java` | Tipos primitivos, tipos de referencia, constantes (`final`), Wrapper Classes, inferencia de tipo (`var`), roles de variables (Trabajo, Acumuladora, Contadora), casting implícito y explícito, scope, valores por defecto |
| **Clase 2** | `PrintAndRead.java` | `System.out.print/println/printf`, `System.err`, `Scanner`, `Locale.US`, lectura de `int/double/String/boolean` |
| **Clase 3** | `OperationsTypes.java` | Operadores aritméticos (`+`, `-`, `*`, `/`, `%`), operadores de asignación compuesta (`+=`, `-=`...), concatenación de String, división por cero (`ArithmeticException` vs `Infinity/NaN`), precedencia de operadores |

#### Ejercicios — `sequencing-structures/exercis/`
| Ejercicio | Archivo |
|-----------|---------|
| Ejercicio 1 | `Exercise1.java` |
| Ejercicio 2 | `Exercise2.java` |
| Ejercicio 3 | `Exercise3.java` |
| Ejercicio 4 | `Exercise4.java` |
| Ejercicio 5 | `Exercise5.java` |

---

### Módulo 2 — Estructura de Selección (`selections-structures/`)

Las estructuras de selección permiten que el programa tome **decisiones** basadas en condiciones.

| Clase | Archivo | Temas cubiertos |
|-------|---------|-----------------|
| **Clase 4** | `SelectionsTypes.java` | `if`, `if-else`, `if-else if-else`, `if` anidado, `switch` clásico (fall-through, `break`), `switch` moderno con `->` (Java 12+), agrupación de casos, `==` vs `.equals()` en Strings, String Pool vs Heap |
| **Clase 5** | `LogicalOperators.java` | `&&` (AND), `\|\|` (OR), `!` (NOT), Leyes de De Morgan (`!(A&&B)` = `!A\|\|!B`), cortocircuito lógico, prevención de `NullPointerException` con null guards |
| **Clase 6** | `TernaryOperators.java` | Operador ternario (`? :`), cuándo usarlo y cuándo evitarlo, compatibilidad de tipos, ternarios anidados en 2 niveles (cadena), en 3 niveles, en ambas ramas (TRUE y FALSE) |

#### Ejercicios — `selections-structures/exercis/`
| Ejercicio | Archivo |
|-----------|---------|
| Ejercicio 6  | `Exercise6.java`  |
| Ejercicio 7  | `Exercise7.java`  |
| Ejercicio 8  | `Exercise8.java`  |
| Ejercicio 9  | `Exercise9.java`  |
| Ejercicio 10 | `Exercise10.java` |
| Ejemplos adicionales | `Ejes.java` |

---

### Módulo 3 — Estructura de Repetición (`repetition-strctures/`)

Los bucles permiten **automatizar tareas repetitivas** y procesar datos en volumen sin duplicar código.

| Clase | Archivo | Temas cubiertos |
|-------|---------|-----------------|
| **Clase 7** | `RepetitionsTypes.java` | `while`, `do-while`, `for`, `for-each` (Java 5+), bucles infinitos, error por uno (off-by-one), `ArrayIndexOutOfBoundsException` |
| **Clase 8** | `LoopDeepDive.java` | Diferencias entre los 3 bucles, `break`, `continue`, bucles anidados (nested loops), tabla de multiplicar, etiquetas (`label:`) para `break` y `continue` en bucles externos |
| **Clase 9** | `LoopWithCounters.java` | Variables Contadoras, Acumuladoras y de Trabajo (Auxiliar) dentro de bucles, Valores Centinela (sentinel values), scope de variables dentro de bucles, los 3 roles combinados en un solo ejercicio |

#### Sub-módulo: Validaciones (`repetition-strctures/Validations/`)

La validación de entradas combina bucles con lógica condicional para construir programas robustos.

| Clase | Archivo | Temas cubiertos |
|-------|---------|-----------------|
| **Clase 10** | `with_if/ValidatingInput.java` | `scanner.hasNextInt()` / `hasNextDouble()`, el buffer del Scanner, limpieza del buffer con `scanner.next()`, bucle infinito por buffer no limpiado |
| **Clase 11** | `with_if/AdvancedValidations.java` | Validación de `int`, `double`, `boolean` y `String`, normalización de cadenas (`.trim()`, `.toLowerCase()`), Expresiones Regulares (Regex) con `.matches()`, confirmación de datos con el usuario |
| **Clase 12** | `with_try/TryCatchValidation.java` | `try-catch`, `InputMismatchException`, `NumberFormatException`, peligro del bucle infinito en el `catch` sin limpiar el buffer, ventaja de `try-catch` vs `hasNextInt()` en código profesional |

---

### Módulo 4 — Ordenamiento y Búsqueda (`orderingStructures/`)

Algoritmos clásicos para organizar y encontrar datos. Este módulo requiere dominar los 3 módulos anteriores.

#### Algoritmos de Búsqueda
| Archivo | Algoritmo | Complejidad |
|---------|-----------|-------------|
| `LinearSearchExample.java` / `BusquedaLineal.java` | Búsqueda Lineal | O(n) |
| `BinarySearchExample.java` | Búsqueda Binaria | O(log n) |

#### Algoritmos de Ordenamiento
| Archivo | Algoritmo | Complejidad promedio |
|---------|-----------|----------------------|
| `BubbleSortExample.java`    | Bubble Sort    | O(n²)      |
| `SelectionSortExample.java` | Selection Sort | O(n²)      |
| `InsertionSortExample.java` | Insertion Sort | O(n²)      |
| `ShellSortExample.java`     | Shell Sort     | O(n log n) |
| `MergeSortExample.java`     | Merge Sort     | O(n log n) |
| `QuickSortExample.java`     | Quick Sort     | O(n log n) |
| `HeapSortExample.java`      | Heap Sort      | O(n log n) |

---

## Cómo compilar y ejecutar

Desde la raíz del proyecto (`learning-java/`):

```bash
# Compilar un archivo
javac sequencing-structures/VariableTypes.java

# Ejecutar una clase
java -cp sequencing-structures VariableTypes

# Compilar archivos con package (ej. Validaciones)
javac -cp . repetition-strctures/Validations/with_if/ValidatingInput.java

# Ejecutar con package
java -cp . Validations.with_if.ValidatingInput
```

> **Requisito:** Java 12 o superior (para el switch moderno con `->` en SelectionsTypes.java).

---

## Consejos para el Estudiante

- **Lee siempre el encabezado** de cada archivo antes de revisar el código. Toda la teoría clave está ahí.
- **Compila y ejecuta cada clase** tú mismo. Ver el programa correr en tu terminal refuerza lo aprendido.
- **Completa los ejercicios** de cada módulo antes de pasar al siguiente.
- **Experimenta**: modifica los ejemplos para ver qué pasa si cambias una condición o un operador.
- **No copies**: escribe el código a mano para desarrollar memoria muscular y comprensión real.
