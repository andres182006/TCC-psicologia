package com.Unicartagena.TCC.InterfazUI;


import javax.swing.*;

public class Principal {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });

    }

}
