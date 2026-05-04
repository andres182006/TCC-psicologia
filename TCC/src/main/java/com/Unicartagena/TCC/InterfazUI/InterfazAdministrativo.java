package com.Unicartagena.TCC.InterfazUI;

import javax.swing.*;

public class InterfazAdministrativo extends JFrame {
    private JLabel h;
    private JPanel panelq;

    public InterfazAdministrativo(String usuarioLogueado, String rol) {
        setContentPane(panelq);
        setTitle("Interfaz Estudiante");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
