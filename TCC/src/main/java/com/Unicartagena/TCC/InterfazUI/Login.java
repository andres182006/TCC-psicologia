package com.Unicartagena.TCC.InterfazUI;

import javax.swing.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends JFrame {
    private JLabel bienvenidoLabel;
    private JLabel porFavorIntroduceTusLabel;
    private JLabel rolLabel;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel nombreLabel;
    private JLabel contraseñaLabel;
    private JButton iniciarSesionButton;
    private JButton registrarButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPasswordField passwordField1;

    // Para guardar datos del usuario logueado
    private String usuarioLogueado;
    private String rolLogueado;

    public Login() {
        setContentPane(panel1);
        setTitle("Login");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Llenar ComboBox con roles
        for (String rol : new String[]{"estudiante", "administrativo", "psicologa"}) {
            comboBox1.addItem(rol);
        }

        iniciarSesionButton.addActionListener(e -> {
            String correo = textField1.getText();
            String contrasena = new String(passwordField1.getPassword());
            String rolSeleccionado = (String) comboBox1.getSelectedItem();

            String respuesta = hacerLogin(correo, contrasena, rolSeleccionado);

            if (respuesta.equals("OK")) {
                // Guardar datos del usuario
                usuarioLogueado = correo;
                rolLogueado = rolSeleccionado;

                System.out.println("Login exitoso para: " + usuarioLogueado + " con rol: " + rolSeleccionado);

                // Redirigir según el rol
                redirigirSegunRol(rolSeleccionado);

                //  Cerrar ventana de login despues de aceder
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        });

        registrarButton.addActionListener(e -> {
            // Abrir ventana de registro
            new Registro();
        });
    }

    private String hacerLogin(String correo, String contrasena, String rol) {
        try {
            URL url = new URL("http://localhost:8080/api-notas/auth/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{ \"correo\": \"" + correo + "\", \"contrasena\": \"" + contrasena + "\", \"nombreRol\": \"" + rol + "\" }";
            System.out.println("JSON enviado: " + json);

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("Código respuesta: " + responseCode);

            return (responseCode == 200) ? "OK" : "ERROR";

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    //  ingresar segun el rol
    private void redirigirSegunRol(String rol) {
        System.out.println("Redirigiendo para rol: " + rol);

        switch (rol.toLowerCase()) {
            case "estudiante":
                System.out.println("Abriendo InterfazEstudiante...");
                InterfazEstudiante interfazEstudiante = new InterfazEstudiante(usuarioLogueado);
                interfazEstudiante.setVisible(true);
                break;

            case "administrativo":
            case "psicologa":
                System.out.println("Abriendo InterfazAdministrativo para: " + rol);
                InterfazAdministrativo interfazAdmin = new InterfazAdministrativo(usuarioLogueado, rol);
                interfazAdmin.setVisible(true);
                break;

            default:
                System.out.println("Rol no reconocido: " + rol);
                JOptionPane.showMessageDialog(this, "Rol no reconocido");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}