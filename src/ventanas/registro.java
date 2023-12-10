/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class registro extends javax.swing.JFrame {

    /**
     * Creates new form registro
     */
    private boolean h;
    public registro() {
        initComponents();
        this.setTitle("Registro de usuarios");
        this.setLocationRelativeTo(null);
        h=false;
    }
    public registro(boolean j) {
        initComponents();
        this.setTitle("Registro de usuarios");
        this.setLocationRelativeTo(null);
        h=j;
    }
    public void registrar() {
    String nombre = nom.getText();
    String apellido1 = ap1.getText();
    String apellido2 = ap2.getText();
    String nuevoUsuario = n_us.getText();
    String nuevaContrasena = new String(cont.getPassword());
    boolean esAdministrador = admin.isSelected();
    if(nombre.isBlank()){
        JOptionPane.showMessageDialog(this, "Introduzca un nombre, es obligatorio");
    }
    if(apellido1.isBlank()){
        JOptionPane.showMessageDialog(this, "Introduzca un primer apellido, es obligatorio");
    }
    if(apellido2.isBlank()){
        JOptionPane.showMessageDialog(this, "Introduzca un segundo apellido, es obligatorio");
    }
    if(nuevoUsuario.isBlank()){
        JOptionPane.showMessageDialog(this, "Introduzca un usuario, es obligatorio");
    }
    if(nuevaContrasena.isBlank()){
        JOptionPane.showMessageDialog(this, "Introduzca una contraseña, es obligatorio");
    }
    if(correo.getText().isBlank()){
        JOptionPane.showMessageDialog(this, "Introduzca un correo, es obligatorio");
    }
    if(!nombre.isBlank()&&!apellido1.isBlank()&&!apellido2.isBlank()&&!nuevoUsuario.isBlank()&&!nuevaContrasena.isBlank()&&!correo.getText().isBlank()){
        if (esAdministrador) {
        // Abre el JDialog de administrador para ingresar las credenciales
        comp_admin adDia = new comp_admin(this, true);
        adDia.setVisible(true);

        if (adDia.isCredencialesValidas()) {
            // Continúa con el registro como administrador
            if (existeUsuario(nuevoUsuario)) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Elija otro nombre de usuario.");
            }
            if(existeCorreo(correo.getText())){
                JOptionPane.showMessageDialog(this, "El correo ya está asignado a una cuenta. Elija otro correo.");
            }
                if(!existeUsuario(nuevoUsuario)&&!existeCorreo(correo.getText())) {
                Connection conn = null;
                PreparedStatement userPreparedStatement = null;

                try {
                    String url = "jdbc:hsqldb:hsql://localhost/"; // Cambia la URL a tu base de datos
                    String user = "SA";
                    String pass = "";
                    conn = DriverManager.getConnection(url, user, pass);

                    // Insertar el nuevo usuario en la tabla "usuarios"
                    String sqlUser = "INSERT INTO usuarios (nombre, apellido1, apellido2, n_usuario, contra, administrador, correo) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    userPreparedStatement = conn.prepareStatement(sqlUser);
                    userPreparedStatement.setString(1, nombre);
                    userPreparedStatement.setString(2, apellido1);
                    userPreparedStatement.setString(3, apellido2);
                    userPreparedStatement.setString(4, nuevoUsuario);
                    userPreparedStatement.setString(5, nuevaContrasena);
                    userPreparedStatement.setBoolean(6, esAdministrador);
                    userPreparedStatement.setString(7, correo.getText());
                    userPreparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Usuario registrado con éxito");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al registrar el usuario");
                } finally {
                    try {
                        if (userPreparedStatement != null) {
                            userPreparedStatement.close();
                        }
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    } else {
        // Continuar con el registro del usuario como no administrador
        if (existeUsuario(nuevoUsuario)) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Elija otro nombre de usuario.");
        } else {
            Connection conn = null;
            PreparedStatement userPreparedStatement = null;

            try {
                String url = "jdbc:hsqldb:hsql://localhost/"; // Cambia la URL a tu base de datos
                String user = "SA";
                String pass = "";
                conn = DriverManager.getConnection(url, user, pass);

                // Insertar el nuevo usuario en la tabla "usuarios"
                String sqlUser = "INSERT INTO usuarios (nombre, apellido1, apellido2, n_usuario, contra, administrador) VALUES (?, ?, ?, ?, ?, ?)";
                userPreparedStatement = conn.prepareStatement(sqlUser);
                userPreparedStatement.setString(1, nombre);
                userPreparedStatement.setString(2, apellido1);
                userPreparedStatement.setString(3, apellido2);
                userPreparedStatement.setString(4, nuevoUsuario);
                userPreparedStatement.setString(5, nuevaContrasena);
                userPreparedStatement.setBoolean(6, esAdministrador);
                userPreparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Usuario registrado con éxito");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al registrar el usuario");
            } finally {
                try {
                    if (userPreparedStatement != null) {
                        userPreparedStatement.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }    
                    nom.setText(null);
                    ap1.setText(null);
                    ap2.setText(null);
                    n_us.setText(null);
                    cont.setText(null);
                    admin.setSelected(false);
                    correo.setText(null);
}

private boolean existeUsuario(String nombreUsuario) {
    // Verificar si el nombre de usuario ya existe en la base de datos
    boolean usuarioExiste = false;
    Connection conn = null;
    PreparedStatement userPreparedStatement = null;
    ResultSet resultSet = null;

    try {
        String url = "jdbc:hsqldb:hsql://localhost/"; // Cambia la URL a tu base de datos
        String user = "SA";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);

        String sql = "SELECT n_usuario FROM usuarios WHERE n_usuario = ?";
        userPreparedStatement = conn.prepareStatement(sql);
        userPreparedStatement.setString(1, nombreUsuario);
        resultSet = userPreparedStatement.executeQuery();

        usuarioExiste = resultSet.next();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (userPreparedStatement != null) {
                userPreparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return usuarioExiste;
}
private boolean existeCorreo(String nombreUsuario) {
    // Verificar si el nombre de usuario ya existe en la base de datos
    boolean correoExiste = false;
    Connection conn = null;
    PreparedStatement userPreparedStatement = null;
    ResultSet resultSet = null;

    try {
        String url = "jdbc:hsqldb:hsql://localhost/";
        String user = "SA";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);

        String sql = "SELECT correo FROM usuarios WHERE n_usuario = ?";
        userPreparedStatement = conn.prepareStatement(sql);
        userPreparedStatement.setString(1, nombreUsuario);
        resultSet = userPreparedStatement.executeQuery();

        correoExiste = resultSet.next();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (userPreparedStatement != null) {
                userPreparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return correoExiste;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ap1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ap2 = new javax.swing.JTextField();
        n_us = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cont = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        admin = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Javanese Text", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Registrar Nuevo Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Primer apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));
        getContentPane().add(ap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 150, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Segundo apellido:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        getContentPane().add(ap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 150, -1));
        getContentPane().add(n_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 150, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuario:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));
        getContentPane().add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/volver.png"))); // NOI18N
        jButton2.setText("VOLVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 110, 40));

        admin.setBackground(new java.awt.Color(0, 51, 153));
        admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("Administrador");
        getContentPane().add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 150, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/boton.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/blue2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        main m=new main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox admin;
    private javax.swing.JTextField ap1;
    private javax.swing.JTextField ap2;
    private javax.swing.JPasswordField cont;
    private javax.swing.JTextField correo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField n_us;
    private javax.swing.JTextField nom;
    // End of variables declaration//GEN-END:variables
}
