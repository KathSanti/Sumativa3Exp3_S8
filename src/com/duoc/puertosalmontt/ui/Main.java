package com.duoc.puertosalmontt.ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Mostrar splash screen primero
        mostrarSplashYVentana();
    }

    private static void mostrarSplashYVentana() {
        // Mostrar el splash screen
        PantallaInicio pantallaInicio = new PantallaInicio();

        // Usar un Timer para cerrar el splash y mostrar la ventana principal
        Timer timer = new Timer(3000, e -> {
            pantallaInicio.cerrar();
            mostrarVentanaPrincipal();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private static void mostrarVentanaPrincipal() {
        SwingUtilities.invokeLater(() -> {
            VentanaGestionIntegrada ventana = new VentanaGestionIntegrada();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        });
    }
}