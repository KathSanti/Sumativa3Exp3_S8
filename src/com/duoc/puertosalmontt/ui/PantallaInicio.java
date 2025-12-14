package com.duoc.puertosalmontt.ui;

import javax.swing.*;
import java.awt.*;

public class PantallaInicio extends JWindow {

    public PantallaInicio() {
        // Crear el contenido del splash
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);

        try {
            // Cargar la imagen del splash
            ImageIcon splashIcon = new ImageIcon(getClass().getResource("/resource/PantallaInicio.png"));
            JLabel label = new JLabel(splashIcon);
            content.add(label, BorderLayout.CENTER);

            // Agregar una barra de progreso
            JProgressBar progressBar = new JProgressBar();
            progressBar.setIndeterminate(true);
            progressBar.setString("Cargando sistema...");
            progressBar.setStringPainted(true);
            content.add(progressBar, BorderLayout.SOUTH);

        } catch (Exception e) {
            // Si no hay imagen, mostrar mensaje
            JLabel label = new JLabel("SISTEMA DE GESTIÓN - PUERTOS SALMONT PUERTO MONTT", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setForeground(new Color(0, 51, 102));
            content.add(label, BorderLayout.CENTER);
        }

        setContentPane(content);

        // Establecer tamaño
        setSize(900, 700);

        // Centrar en pantalla
        setLocationRelativeTo(null);

        // Hacer visible
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }




}
