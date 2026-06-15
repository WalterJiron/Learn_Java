/*
    CLASE 1 - Tipos de variables en Java

    ANTES DE TODO: En Java para compilar de manera correcta se de usar esta sintaxis:
        public class NombreDeTuArchivo{
            public static void main(String[] arg){
            }
        }
    Explicacion:
        La sintaxis mostrada es la estructura minima requerida para ejecutar un programa en Java debido a:

        1. 'public class NombreDeTuArchivo':
           - Java exige que el nombre de la clase principal coincida exactamente con el nombre del archivo (.java)
           - El modificador 'public' indica accesibilidad desde cualquier parte

        2. 'public static void main(String[] arg)':
           - Punto de entrada obligatorio para la JVM (Java Virtual Machine)
           - 'public': permite el acceso desde fuera de la clase
           - 'static': permite invocarlo sin crear instancia de la clase
           - 'void': indica que no retorna valor
           - 'String[] args': parametro para recibir argumentos desde la linea de comandos

        3. Requisitos de compilacion:
           - Sin esta estructura, el compilador no reconoce donde comenzar la ejecucion
           - Garantiza un estandar para la maquina virtual Java

    Explicaremos los distintos tipos de variables que existen en Java, su clasificacion,
    alcance y uso comun. Tambien se introducen conceptos fundamentales como constantes,
    clases envoltorio (wrapper classes), diferencias entre variables locales, de instancia y estaticas,
    y el uso de var para inferencia de tipos.

    SECCIONES:
    1) Tipos primitivos
    2) Tipos de referencia (objetos)
    3) Constantes (final)
    4) Tipos envoltorios (Wrapper Classes)
    5) Alcance de variables:
       - Locales
       - De instancia
       - Estaticas (de clase)
    6) Inferencia de tipo con var (Java 10+)
    7) Clasificación de variables según su función o rol en el algoritmo:
       - Variables de trabajo (o auxiliares)
       - Variables acumuladoras
       - Variables contadoras

    REGLAS Y CONCEPTOS CLAVE:
    - Naming Convention (Nomenclatura): En Java se usa camelCase para variables (ej. miVariableDeTrabajo).
    - Inicialización Obligatoria y Valores por defecto: 
      * Las variables locales NO tienen un valor por defecto. Es obligatorio inicializarlas antes de usarlas.
      * Las variables de instancia o estáticas (declaradas a nivel de clase) SÍ tienen valores por defecto
        (0 para enteros, 0.0 para decimales, false para booleans, y null para objetos/referencias).
    - Conversión de tipos (Casting):
      * Implícito (Widening): Conversión automática de un tipo más pequeño a uno más grande (ej. de int a double). No hay pérdida de datos.
      * Explícito (Narrowing): Conversión manual requerida para pasar de un tipo más grande a uno más chico (ej. de double a int).
        Se usa la sintaxis `(tipo) valor` y causa pérdida de precisión (los decimales se truncan).
    - Memoria Stack vs Heap: Los tipos primitivos y las referencias a objetos se guardan en el Stack
      (pila de ejecución rápida). Los objetos (como cadenas String y arreglos) residen en el Heap (área de memoria dinámica).
*/

public class VariableTypes {

    // ========== 5) VARIABLE DE INSTANCIA ==========
    // Se declara fuera de cualquier metodo, dentro de la clase.
    // Pertenece a una instancia del objeto, y cada objeto tiene su propia copia.
    String mesagge = "Hola desde la instancia";

    // Campos sin inicializar para demostrar valores por defecto:
    int enteroPorDefecto;
    boolean booleanPorDefecto;
    String referenciaPorDefecto;

    // ========== 5) VARIABLE ESTATICA ==========
    // Tambien esta fuera de metodos, pero con la palabra clave "static".
    // Pertenece a la clase, no a un objeto, y es compartida por todas las instancias.
    static int contadorGlobal = 50;

    public static void main(String[] args) {

        // ========== 5) VARIABLE LOCAL ==========
        // Solo vive dentro de este metodo.
        // Se crea al entrar en el metodo y desaparece al salir.

        // ========== 1) TIPOS PRIMITIVOS ==========
        byte nivel = 5;               // 1 byte, entre -128 y 127
        short puntos = 1000;          // 2 bytes, entre -32,768 y 32,767
        int edad = 25;                // 4 bytes, el mas usado para enteros
        long poblacion = 8000000000L; // 8 bytes, usa 'L' al final

        float temperatura = 36.6f;    // 4 bytes, usa 'f' al final
        double estatura = 1.75;       // 8 bytes, mas preciso

        char inicial = 'F';           // 2 bytes, un solo caracter Unicode
        boolean esEstudiante = true;  // 1 bit, valor true o false

        // ========== 2) TIPOS DE REFERENCIA ==========
        String nombre = "Felipe";         // Cadena de texto
        int[] notas = {85, 90, 78};       // Arreglo de enteros

        // ========== 3) CONSTANTE ==========
        final double PI = 3.1416;         // No se puede modificar

        // ========== 4) TIPOS ENVOLTORIOS (WRAPPER CLASSES) ==========
        Integer edadWrapper = Integer.valueOf(edad);
        Double estaturaWrapper = Double.valueOf(estatura);
        Boolean estadoWrapper = Boolean.TRUE;

        // ========== 6) INFERENCIA DE TIPO CON VAR (Java 10+) ==========
        // var permite que Java detecte automaticamente el tipo.
        var curso = "Introduccion a Java";   // tipo String
        var totalNotas = notas.length;       // tipo int
        var promedio = 89.5;                 // tipo double
        var aprobado = true;                 // tipo boolean

        // ========== 7) ROLES DE VARIABLES EN ALGORITMOS ==========
        // Las variables también se clasifican según su rol lógico o función al resolver un problema:

        // A) Variable de Trabajo (Auxiliar)
        // Almacena valores intermedios o temporales necesarios para realizar cálculos.
        double subtotal = 150.0;
        double tasaImpuesto = 0.15;
        double valorImpuesto = subtotal * tasaImpuesto; // Variable de trabajo: almacena un paso intermedio
        double totalApagar = subtotal + valorImpuesto;

        // B) Variable Acumuladora
        // Acumula valores de forma progresiva. Su valor final es la suma de los valores anteriores más uno nuevo.
        // ¡Importante! Siempre debe ser inicializada (normalmente en 0 para sumas o 1 para multiplicaciones).
        double bolsaAhorro = 0.0;       // Inicialización
        bolsaAhorro = bolsaAhorro + 10.0; // bolsaAhorro ahora vale 10.0
        bolsaAhorro = bolsaAhorro + 25.5; // bolsaAhorro ahora vale 35.5
        bolsaAhorro += 15.0;            // bolsaAhorro ahora vale 50.5 (usando operador +=)

        // C) Variable Contadora
        // Cuenta el número de veces que se realiza una acción o sucede un evento.
        // Su valor se incrementa (o decrementa) en una cantidad fija constante (normalmente 1).
        int contadorVistas = 0;         // Inicialización
        contadorVistas = contadorVistas + 1; // contadorVistas vale 1
        contadorVistas++;               // contadorVistas vale 2 (usando operador ++)

        // ========== 8) DEMOSTRACIÓN DE CASTING (CONVERSIÓN DE TIPOS) ==========
        // Casting Implícito (Widening): de menor a mayor capacidad
        int enteroOriginal = 42;
        double decimalAutomatico = enteroOriginal; // int se convierte a double automáticamente (42.0)

        // Casting Explícito (Narrowing): de mayor a menor capacidad, requiere cast (tipo)
        double estaturaOriginal = 1.75;
        int estaturaTruncada = (int) estaturaOriginal; // se pierde la parte decimal, queda 1

        // ========== 9) VARIABLES CON VALORES POR DEFECTO ==========
        // Creamos una instancia de esta clase para poder leer sus variables de instancia no inicializadas
        VariableTypes pruebaValores = new VariableTypes();

        // ========== IMPRIMIENDO LOS VALORES ==========
        // Para imprimir en Java se utiliza el objeto reservado System.out.println, System.out.print o System.out.printf()
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Estatura: " + estatura);
        System.out.println("Inicial: " + inicial);
        System.out.println("Es estudiante? " + esEstudiante);
        System.out.println("Primera nota: " + notas[0]);
        System.out.println("Constante PI: " + PI);
        System.out.println("Edad (Wrapper): " + edadWrapper);
        System.out.println("Estatura (Wrapper): " + estaturaWrapper);
        System.out.println("Estado (Wrapper): " + estadoWrapper);

        System.out.println("Curso: " + curso);
        System.out.println("Total de notas: " + totalNotas);
        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobado: " + aprobado);

        // ========== IMPRIMIENDO ROLES DE VARIABLES ==========
        System.out.println("Impuesto de Trabajo: " + valorImpuesto);
        System.out.println("Total Calculado: " + totalApagar);
        System.out.println("Ahorro Acumulado: " + bolsaAhorro);
        System.out.println("Vistas Contadas: " + contadorVistas);

        // ========== IMPRIMIENDO CASTING Y VALORES POR DEFECTO ==========
        System.out.println("\n--- Casting ---");
        System.out.println("Decimal automático (implícito): " + decimalAutomatico);
        System.out.println("Estatura truncada (explícito): " + estaturaTruncada);

        System.out.println("\n--- Valores por Defecto ---");
        System.out.println("Entero por defecto: " + pruebaValores.enteroPorDefecto);
        System.out.println("Boolean por defecto: " + pruebaValores.booleanPorDefecto);
        System.out.println("Referencia por defecto: " + pruebaValores.referenciaPorDefecto);

        // ========== USO DE VARIABLE ESTATICA ==========
        System.out.println("Contador Global: " + contadorGlobal);
    }
}
