# Sistema de Cotización y Venta de Boletos de Transporte Terrestre

Aplicación de escritorio desarrollada en Java Swing para la gestión comercial de pasajes interprovinciales. Centraliza el registro de pasajeros, el catálogo de rutas/destinos y el cálculo automatizado de liquidaciones de venta con descuentos por volumen y métricas de consumo en memoria.

> **Nota de contexto académico:** Proyecto desarrollado originalmente en el periodo académico 2024-I para la asignatura de Programación Orientada a Objetos (POO). Se migró y depuró el código fuente en este repositorio para registrar la evolución técnica, el dominio de fundamentos en Java y la identificación de patrones de refactorización sobre código heredado (*legacy code*).

---

## 1. Stack Tecnológico

* **Lenguaje:** Java (compatible con JDK 8 o superior)
* **Entorno Gráfico:** Java Swing / AWT
* **Gestión de Componentes:** NetBeans GUI Builder (compatibilidad con especificación `.form`)
* **Manejo de Datos:** Colecciones y modelos tabulares en memoria (`DefaultTableModel`)
* **Plataforma:** Multiplataforma de escritorio (Windows, Linux, macOS bajo JVM)

---

## 2. Módulos y Flujo Operativo

### 2.1. Gestión de Pasajeros
* Registro de datos personales: Nombre, Apellidos, DNI, Teléfono móvil y Correo electrónico.
* Validación de caracteres en tiempo de captura para nombres y apellidos con soporte para caracteres alfabéticos extendidos (tildes y ñ).
* Visualización tabular estructurada en tiempo real mediante `DefaultTableModel`.
* Control de bajas mediante eliminación selectiva de registros.

### 2.2. Catálogo de Destinos y Rutas
* Definición de tarifas operativas: Ciudad/Terminal de destino, stock de asientos disponibles y precio unitario por boleto.
* Validación estricta de campos obligatorios con prevención de excepciones numéricas (`NumberFormatException`).
* Admisión de tarifas decimales normalizadas con punto decimal.
* Consola de administración de servicios con soporte de altas y bajas en tabla.

### 2.3. Emisión de Boletos, Descuentos y Facturación
* Selección contextual de ruta desde la grilla de servicios e ingreso de cantidad requerida.
* Generación de orden de compra detallada con desglose por ítem.
* **Motor de liquidación y descuentos:**
  * Determinación de subtotales por destino seleccionado.
  * Cálculo de extremos de consumo (detección automatizada del subtotal más alto y más bajo de la cotización).
  * Aplicación de escala de descuentos por tramos de facturación (0%, 20%, 40% y 50%).
  * Secuencia de cálculo síncrona: Subtotal bruto acumulado → Determinación de porcentaje y monto de descuento → Importe total neto facturable.

---

## 3. Consideraciones de Arquitectura y Deuda Técnica Identificada

Como parte del análisis técnico del proyecto académico de 2024, se identificaron y documentaron los siguientes aspectos de diseño:

* **Acoplamiento UI/Dominio:** Las clases de control (`Clientes`, `Servicio`, `Venta`) mantienen referencias directas a componentes visuales de Swing (`JTextField`, `JTable`). Como propuesta evolutiva, se recomienda la transición a un patrón Modelo-Vista-Controlador (MVC) estricto donde los modelos funcionen como POJOs puros y la vista actúe como observador pasivo.
* **Persistencia en Memoria:** El sistema almacena la información durante el ciclo de vida del proceso en memoria RAM mediante modelos de tabla. Se contempla la incorporación de una capa de acceso a datos (DAO/Repository) conectada a un motor relacional embebido (SQLite o H2) para almacenamiento permanente.
* **Control de Inventario Transaccional:** La versión actual calcula subtotales en función de la tarifa; una versión empresarial requeriría el descuento atómico de los asientos disponibles en la tabla de servicios tras la confirmación de la venta.

---

## 4. Requisitos y Ejecución

### Prerrequisitos
* Java Development Kit (JDK 8 o superior instalado).
* Variable de entorno `JAVA_HOME` configurada en el sistema.

### Ejecución directa desde terminal

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/AlexanderValverdeReyes/Venta_boletos_de_viaje.git 
   cd Venta_boletos_de_viaje

2. Obtener las dependencias del proyecto:
   ```bash
   flutter pub get
   ```
3. Ejecutar la aplicación:
   ```bash
   flutter run
   ```
