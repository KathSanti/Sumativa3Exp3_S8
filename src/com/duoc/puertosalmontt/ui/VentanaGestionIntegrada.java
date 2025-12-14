package com.duoc.puertosalmontt.ui;

import com.duoc.puertosalmontt.data.GestorUnidades;
import com.duoc.puertosalmontt.model.entidad.CentroCultivo;
import com.duoc.puertosalmontt.model.entidad.PlantaProceso;
import com.duoc.puertosalmontt.model.persona.Empleado;
import com.duoc.puertosalmontt.model.persona.Proveedor;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class VentanaGestionIntegrada extends JFrame {

    private GestorUnidades gestor;
    private JTextArea txtAreaResultado;

    // Componentes para formularios
    private JPanel panelPrincipal;
    private CardLayout cardLayout;

    // Campos para formularios
    private JTextField txtNombre, txtComuna, txtToneladas;
    private JTextField txtNombrePlanta, txtComunaPlanta, txtCapacidad;
    private JTextField txtRutEmp, txtNombreEmp, txtApPaterno, txtApMaterno, txtDireccionEmp, txtTelefonoEmp;
    private JTextField txtRutProv, txtNombreProv, txtDireccionProv, txtTelefonoProv, txtSucursal;

    public VentanaGestionIntegrada() {
        // Mostrar la pantalla que esta cargado el programa
        PantallaInicio pantallaInicio = new PantallaInicio();
        pantallaInicio.cerrar();

        // Inicializar la ventana principal
        inicializarVentana();


    }

    private void inicializarVentana() {
        gestor = new GestorUnidades();
        setTitle("SISTEMA DE GESTIÓN - PUERTOS SALMONT");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponentes();

        // Establecer el icono de la ventana
        establecerIconoVentana();


        setLocationRelativeTo(null);
    }



    private void establecerIconoVentana() {
        try {
            // Buscar la imagen en varias rutas posibles
            String[] rutasPosibles = {
                    "/images/logo.png",
                    "/resource/logo.png",
                    "images/logo.png",
            };

            ImageIcon icono = null;

            for (String ruta : rutasPosibles) {
                URL iconURL = getClass().getResource(ruta);
                if (iconURL != null) {
                    icono = new ImageIcon(iconURL);
                    System.out.println("Icono encontrado en: " + ruta);
                    break;
                }
            }

            if (icono != null) {
                setIconImage(icono.getImage());
            } else {
                System.out.println("No se encontró el icono. Verifica la ruta de la imagen.");
            }

        } catch (Exception e) {
            System.out.println("Error al cargar el icono: " + e.getMessage());
        }
    }

    private void initComponentes() {
        // Panel superior con botones
        JPanel panelBotones = crearPanelBotones();
        add(panelBotones, BorderLayout.NORTH);

        // Panel central con CardLayout
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Crear los diferentes paneles
        crearPanelVista();
        crearPanelAgregarCentro();
        crearPanelAgregarPlanta();
        crearPanelAgregarEmpleado();
        crearPanelAgregarProveedor();

        // Área de resultados
        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setFont(new Font("Espaciorusultado", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(txtAreaResultado);

        // Dividir la ventana
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelPrincipal, scroll);
        splitPane.setDividerLocation(300);

        add(splitPane, BorderLayout.CENTER);

        // Mostrar mensaje inicial
        mostrarMensajeInicial();
    }




    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new GridLayout(2, 4, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Botones para ver
        JButton btnVerCentros = new JButton("Ver Centros de Cultivo");
        btnVerCentros.addActionListener(e -> mostrarCentros());

        JButton btnVerPlantas = new JButton("Ver Plantas de Proceso");
        btnVerPlantas.addActionListener(e -> mostrarPlantas());

        JButton btnVerEmpleados = new JButton("Ver Empleados");
        btnVerEmpleados.addActionListener(e -> mostrarEmpleados());

        JButton btnVerProveedores = new JButton("Ver Proveedores");
        btnVerProveedores.addActionListener(e -> mostrarProveedores());

        // Botones para agregar
        JButton btnAgregarCentro = new JButton("Agregar Centro");
        btnAgregarCentro.addActionListener(e -> {
            cardLayout.show(panelPrincipal, "AGREGAR_CENTRO");
            limpiarCamposCentro();
        });

        JButton btnAgregarPlanta = new JButton("Agregar Planta");
        btnAgregarPlanta.addActionListener(e -> {
            cardLayout.show(panelPrincipal, "AGREGAR_PLANTA");
            limpiarCamposPlanta();
        });

        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        btnAgregarEmpleado.addActionListener(e -> {
            cardLayout.show(panelPrincipal, "AGREGAR_EMPLEADO");
            limpiarCamposEmpleado();
        });

        JButton btnAgregarProveedor = new JButton("Agregar Proveedor");
        btnAgregarProveedor.addActionListener(e -> {
            cardLayout.show(panelPrincipal, "AGREGAR_PROVEEDOR");
            limpiarCamposProveedor();
        });

        panel.add(btnVerCentros);
        panel.add(btnVerPlantas);
        panel.add(btnVerEmpleados);
        panel.add(btnVerProveedores);
        panel.add(btnAgregarCentro);
        panel.add(btnAgregarPlanta);
        panel.add(btnAgregarEmpleado);
        panel.add(btnAgregarProveedor);

        return panel;
    }

    private void crearPanelVista() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lblInstrucciones = new JLabel("Seleccione una opción del menú superior", SwingConstants.CENTER);
        lblInstrucciones.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblInstrucciones, BorderLayout.CENTER);
        panelPrincipal.add(panel, "VISTA");
    }

    private void crearPanelAgregarCentro() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Agregar Centro de Cultivo"));

        txtNombre = new JTextField();
        txtComuna = new JTextField();
        txtToneladas = new JTextField();

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Comuna:"));
        panel.add(txtComuna);
        panel.add(new JLabel("Toneladas:"));
        panel.add(txtToneladas);

        JButton btnGuardar = new JButton("Guardar Centro");
        btnGuardar.addActionListener(e -> guardarCentro());
        panel.add(new JLabel());
        panel.add(btnGuardar);

        panelPrincipal.add(panel, "AGREGAR_CENTRO");
    }

    private void crearPanelAgregarPlanta() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Agregar Planta de Proceso"));

        txtNombrePlanta = new JTextField();
        txtComunaPlanta = new JTextField();
        txtCapacidad = new JTextField();

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombrePlanta);
        panel.add(new JLabel("Comuna:"));
        panel.add(txtComunaPlanta);
        panel.add(new JLabel("Capacidad:"));
        panel.add(txtCapacidad);

        JButton btnGuardar = new JButton("Guardar Planta");
        btnGuardar.addActionListener(e -> guardarPlanta());
        panel.add(new JLabel());
        panel.add(btnGuardar);

        panelPrincipal.add(panel, "AGREGAR_PLANTA");
    }

    private void crearPanelAgregarEmpleado() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Agregar Empleado"));

        txtRutEmp = new JTextField();
        txtNombreEmp = new JTextField();
        txtApPaterno = new JTextField();
        txtApMaterno = new JTextField();
        txtDireccionEmp = new JTextField();
        txtTelefonoEmp = new JTextField();

        panel.add(new JLabel("RUT:"));
        panel.add(txtRutEmp);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombreEmp);
        panel.add(new JLabel("Apellido Paterno:"));
        panel.add(txtApPaterno);
        panel.add(new JLabel("Apellido Materno:"));
        panel.add(txtApMaterno);
        panel.add(new JLabel("Dirección:"));
        panel.add(txtDireccionEmp);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefonoEmp);

        JButton btnGuardar = new JButton("Guardar Empleado");
        btnGuardar.addActionListener(e -> guardarEmpleado());
        panel.add(new JLabel());
        panel.add(btnGuardar);

        panelPrincipal.add(panel, "AGREGAR_EMPLEADO");
    }

    private void crearPanelAgregarProveedor() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Agregar Proveedor"));

        txtRutProv = new JTextField();
        txtNombreProv = new JTextField();
        txtDireccionProv = new JTextField();
        txtTelefonoProv = new JTextField();
        txtSucursal = new JTextField();

        panel.add(new JLabel("RUT:"));
        panel.add(txtRutProv);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombreProv);
        panel.add(new JLabel("Dirección:"));
        panel.add(txtDireccionProv);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefonoProv);
        panel.add(new JLabel("Sucursal:"));
        panel.add(txtSucursal);

        JButton btnGuardar = new JButton("Guardar Proveedor");
        btnGuardar.addActionListener(e -> guardarProveedor());
        panel.add(new JLabel());
        panel.add(btnGuardar);

        panelPrincipal.add(panel, "AGREGAR_PROVEEDOR");
    }

    // Métodos para mostrar listas
    private void mostrarCentros() {
        cardLayout.show(panelPrincipal, "VISTA");
        String centros = gestor.listarCentrosString();
        txtAreaResultado.setText("=== CENTROS DE CULTIVO ===\n\n" + centros);
    }

    private void mostrarPlantas() {
        cardLayout.show(panelPrincipal, "VISTA");
        String plantas = gestor.listarPlantasString();
        txtAreaResultado.setText("=== PLANTAS DE PROCESO ===\n\n" + plantas);
    }

    private void mostrarEmpleados() {
        cardLayout.show(panelPrincipal, "VISTA");
        String empleados = gestor.listarEmpleadosString();
        txtAreaResultado.setText("=== EMPLEADOS ===\n\n" + empleados);
    }

    private void mostrarProveedores() {
        cardLayout.show(panelPrincipal, "VISTA");
        String proveedores = gestor.listarProveedoresString();
        txtAreaResultado.setText("=== PROVEEDORES ===\n\n" + proveedores);
    }

    // Métodos para guardar
    private void guardarCentro() {
        try {
            String nombre = txtNombre.getText();
            String comuna = txtComuna.getText();
            float toneladas = Float.parseFloat(txtToneladas.getText());

            CentroCultivo centro = new CentroCultivo(nombre, comuna, toneladas);
            gestor.agregarCentro(centro);

            JOptionPane.showMessageDialog(this, "Centro de cultivo agregado exitosamente!");
            limpiarCamposCentro();
            mostrarCentros();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Las toneladas deben ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarPlanta() {
        try {
            String nombre = txtNombrePlanta.getText();
            String comuna = txtComunaPlanta.getText();
            int capacidad = Integer.parseInt(txtCapacidad.getText());

            PlantaProceso planta = new PlantaProceso(nombre, comuna, capacidad);
            gestor.agregarPlanta(planta);

            JOptionPane.showMessageDialog(this, "Planta de proceso agregada exitosamente!");
            limpiarCamposPlanta();
            mostrarPlantas();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La capacidad debe ser un número entero válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarEmpleado() {
        try {
            String rut = txtRutEmp.getText();
            String nombre = txtNombreEmp.getText();
            String apPaterno = txtApPaterno.getText();
            String apMaterno = txtApMaterno.getText();
            String direccion = txtDireccionEmp.getText();
            String telefono = txtTelefonoEmp.getText();

            Empleado empleado = new Empleado(rut, nombre, apMaterno, apPaterno, direccion, telefono);
            gestor.agregarEmpleado(empleado);

            JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente!");
            limpiarCamposEmpleado();
            mostrarEmpleados();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarProveedor() {
        try {
            String rut = txtRutProv.getText();
            String nombre = txtNombreProv.getText();
            String direccion = txtDireccionProv.getText();
            String telefono = txtTelefonoProv.getText();
            int sucursal = Integer.parseInt(txtSucursal.getText());

            Proveedor proveedor = new Proveedor(rut, nombre, direccion, telefono, sucursal);
            gestor.agregarProveedor(proveedor);

            JOptionPane.showMessageDialog(this, "Proveedor agregado exitosamente!");
            limpiarCamposProveedor();
            mostrarProveedores();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La sucursal debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Métodos para limpiar campos
    private void limpiarCamposCentro() {
        txtNombre.setText("");
        txtComuna.setText("");
        txtToneladas.setText("");
    }

    private void limpiarCamposPlanta() {
        txtNombrePlanta.setText("");
        txtComunaPlanta.setText("");
        txtCapacidad.setText("");
    }

    private void limpiarCamposEmpleado() {
        txtRutEmp.setText("");
        txtNombreEmp.setText("");
        txtApPaterno.setText("");
        txtApMaterno.setText("");
        txtDireccionEmp.setText("");
        txtTelefonoEmp.setText("");
    }

    private void limpiarCamposProveedor() {
        txtRutProv.setText("");
        txtNombreProv.setText("");
        txtDireccionProv.setText("");
        txtTelefonoProv.setText("");
        txtSucursal.setText("");
    }


    private void mostrarMensajeInicial() {
        String mensaje = "BIENVENIDO AL SISTEMA DE GESTIÓN\n" +
                "=================================\n\n" +
                "Sistema de administración para:\n" +
                "• Centros de Cultivo\n" +
                "• Plantas de Proceso\n" +
                "• Empleados\n" +
                "• Proveedores\n\n" +
                "Use los botones superiores para navegar.";

        txtAreaResultado.setText(mensaje);
    }


}