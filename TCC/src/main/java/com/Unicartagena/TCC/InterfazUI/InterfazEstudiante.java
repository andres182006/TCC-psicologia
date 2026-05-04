package com.Unicartagena.TCC.InterfazUI;

import javax.swing.*;
import java.awt.*;

public class InterfazEstudiante extends JFrame {
    private String usuarioLogueado;
    private JPanel panel1;


    public InterfazEstudiante(String usuario) {
        this.usuarioLogueado = usuario;
        setContentPane(panel1);
        setTitle("Interfaz Estudiante");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}