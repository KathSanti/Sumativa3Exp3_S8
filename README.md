# Suamantiva Experiencia 3 - Semana 8


## Descripción

Este código implementa un sistema de gestión para unidades operativas de una empresa acuícola, 
permitiendo cargar y visualizar información de centros de cultivo y plantas de proceso itegrando una interfaz gráfica.

## Estructura del Proyecto (Paquetes y clases)

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── puertosalmontt/
│   │           ├── Main.java
│   │           │
│   │           ├── ui/
│   │           │   ├── PantallaInicio.java
│   │           │   └── VentanaGestionIntegrada.java
│   │           │
│   │           ├── model/
│   │           │   ├── entidad/
│   │           │   │   ├── CentroCultivo.java
│   │           │   │   ├── PlantaProceso.java
│   │           │   │   └── UnidadOperativa.java
│   │           │   │
│   │           │   └── persona/
│   │           │       ├── Agente.java
│   │           │       ├── Empleado.java
│   │           │       ├── Proveedor.java
│   │           │       └── Registrable.java
│   │           │
│   │           └── data/
│   │               └── GestorUnidades.java
│   │
│   └── resources/
│       ├── logo.png
│       ├── PantallaInicio.png


# Aplicación de Interfaz (GUI) 

Esta clase VentanaGestionIntegrada implementa una interfaz gráfica de usuario (GUI) completa usando Swing, 
el framework de Java para aplicaciones de escritorio.

##1.Arquitectura
 - Extiende JFrame: Crea una ventana principal de la aplicación.
 - Usa CardLayout: Permite alternar entre diferentes "paneles" (pantallas) sin cambiar ventana.
 - Divide la ventana con JSplitPane: Parte superior para formularios, inferior para resultados.

 ##2. Componentes Clave

    // Gestor de datos (lógica de negocio)
    private GestorUnidades gestor;
    
    // Layout para cambiar entre paneles
    private CardLayout cardLayout;
    private JPanel panelPrincipal;
    
    // Campos de formulario
    private JTextField txtNombre, txtComuna, txtToneladas;

##3. Flujo de la Aplicación

   1. Inicio: Muestra PantallaInicio (splash screen).
   2. Configuración: Inicializa ventana, icono y componentes.
   3. Navegación:
      - Botones superiores alternan entre vistas ("Ver...") y formularios ("Agregar...").
      - CardLayout.show() cambia el panel visible.
   4. Operaciones:
      - Visualizar: Llama a métodos del gestor y muestra resultados en el JTextArea.
      - Agregar: Captura datos de formularios, crea objetos y los envía al gestor.     

## Funcionalidades Implementadas

1. Separación de responsabilidades: La UI solo maneja presentación, la lógica está en GestorUnidades.
2. Escalable: Fácil añadir nuevos paneles al CardLayout.
3. Usuario intuitivo: Botones claros, mensajes informativos.
4. Mantenible: Métodos organizados por funcionalidad.
