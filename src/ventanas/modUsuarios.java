/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sebas
 */
public class modUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form mInfou
     */
    private Connection c;
    private int id;
    private String ul;
    private String linkImagenSeleccionada;
    private String nimg;
    private String correoActual;
    private String usuarioActual;
    public modUsuarios(int ida) {
        initComponents();
        id=ida;
        this.setTitle("Modificar datos");
        this.setLocationRelativeTo(null);
        escribir();
        cargarImagen();
    }
    public void cargarImagen(){
        String usu="SA";
        String bd="jdbc:hsqldb:hsql://localhost/";
        String contra="";
        Connection c=null;
        
        
        try{
           
           Class.forName("org.hsqldb.jdbc.JDBCDriver");
           c= DriverManager.getConnection(bd,usu,contra); 
           if(c!=null){
               System.out.println("Conectau");
           }
           else{
               System.out.println("fallo");
           }
                Statement leer2= c.createStatement();
                ResultSet resul2=leer2.executeQuery("SELECT imagen FROM usuarios WHERE id_user="+id);
      
                if (resul2.next()) {
                ul = resul2.getString(1);
                System.out.println("url:" + ul);
                if (ul != null) {
                    ImageIcon imageIcon = new ImageIcon(ul);
                    Image image = imageIcon.getImage();
                    int width = imageIcon.getIconWidth();
                    int height = imageIcon.getIconHeight();

                    System.out.println("Ancho de la imagen: " + width);
                    System.out.println("Altura de la imagen: " + height);

                    Image newImage = image.getScaledInstance(180, 150, Image.SCALE_SMOOTH);
    
                    ImageIcon newImageIcon = new ImageIcon(newImage);

                    img.setIcon(newImageIcon);
                    jPanel1.updateUI();
                    jPanel1.repaint();
                    jPanel1.revalidate();
                }
                }
        }
                catch(ClassNotFoundException | SQLException e){
                        e.printStackTrace();
                        }
        class FondoPanel extends JPanel{
        private Image im;
        
        @Override
        public void paint(Graphics g){
        im=new ImageIcon(ul).getImage();
        g.drawImage(im, 0, 0, getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
    }
    }
    
    public void escribir(){
        String usu = "SA";
            String bd = "jdbc:hsqldb:hsql://localhost/";
            String contra = "";
            Connection c=null;
        try{
           Class.forName("org.hsqldb.jdbc.JDBCDriver");
           c= DriverManager.getConnection(bd,usu,contra); 
           if(c!=null){
               System.out.println("Conectau");
           }
           else{
               System.out.println("fallo");
           }
           
           Object[] datos=new Object[14];
                
        
                Statement leer= c.createStatement();
                ResultSet resul=leer.executeQuery("SELECT id_user, nombre, apellido1, apellido2, n_usuario, correo "
                        + " FROM usuarios WHERE id_user="+id);
                /*ResultSet resul=leer.executeQuery("SELECT marca "+"FROM marcas");*/
            
                while(resul.next())
                {
                    datos[0]=resul.getInt(1);
                    idL.setText(datos[0].toString());
                    datos[1]=resul.getString(2);
                    nombreL.setText(datos[1].toString());
                    datos[2]=resul.getString(3);
                    papL.setText(datos[2].toString());
                    datos[3]=resul.getString(4);
                    sapL.setText(datos[3].toString());
                    datos[4]=resul.getString(5);
                    usuarioL.setText(datos[4].toString());
                    datos[5]=resul.getString(6);
                    correoL.setText(datos[5].toString());
                    usuarioActual=usuarioL.getText(); 
                    correoActual=correoL.getText();  
                }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        idL = new javax.swing.JTextField();
        nombreL = new javax.swing.JTextField();
        papL = new javax.swing.JTextField();
        sapL = new javax.swing.JTextField();
        correoL = new javax.swing.JTextField();
        usuarioL = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Modificar datos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new java.awt.GridLayout(6, 1, 20, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID:");
        jPanel2.add(jLabel1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel2.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Primer apellido:");
        jPanel2.add(jLabel4);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Segundo apellido:");
        jPanel2.add(jLabel7);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Correo:");
        jPanel2.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre de usuario:");
        jPanel2.add(jLabel6);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, 250));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new java.awt.GridLayout(6, 1, 20, 0));

        idL.setEditable(false);
        jPanel3.add(idL);
        jPanel3.add(nombreL);
        jPanel3.add(papL);
        jPanel3.add(sapL);
        jPanel3.add(correoL);
        jPanel3.add(usuarioL);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 180, 250));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(img);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 180, 170));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/subirimagen.png"))); // NOI18N
        jButton1.setText("Cambiar imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 110, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Imagen de Perfil");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crema.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 380));

        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home.png"))); // NOI18N
        jMenu1.setText("Volver al inicio");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acciones");

        jMenuItem1.setText("Agregar Coche");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Marcas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Modelos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Usuarios");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         boolean modificarCorreo = !correoL.getText().equals(correoActual); 
    boolean modificarUsuario = !usuarioL.getText().equals(usuarioActual); 
    
    if (linkImagenSeleccionada == null) {
        
        String usu = "SA";
        String bd = "jdbc:hsqldb:hsql://localhost/";
        String contra = "";

        try (Connection c = DriverManager.getConnection(bd, usu, contra)) {
            String selectImageSQL = "SELECT imagen FROM usuarios WHERE id_user = ?";
            try (PreparedStatement preparedStatement = c.prepareStatement(selectImageSQL)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    nimg = resultSet.getString(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    } else {
        
        String rutaImagen = copiarImagen(usuarioL.getText());

        if (rutaImagen != null) {
            nimg = rutaImagen;
        } else {
            JOptionPane.showMessageDialog(this, "Error al copiar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
    }

    
    if (modificarCorreo || modificarUsuario) {
        // Se han modificado, realiza la verificación en la base de datos
        if (existeUsuarioCorreo(usuarioL.getText(), correoL.getText())) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario o correo ya existe. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si ya existe el usuario o correo
        }
    }

    // Continuar con la modificación
    if (!nombreL.getText().isBlank()) {
        modificar();
    } else {
        JOptionPane.showMessageDialog(this, "Debe proporcionar un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed
    private boolean existeUsuarioCorreo(String nuevoUsuario, String nuevoCorreo) {
        try {
            String usu = "SA";
            String bd = "jdbc:hsqldb:hsql://localhost/";
            String contra = "";

            try (Connection c = DriverManager.getConnection(bd, usu, contra)) {
                // Verificar si ya existe un usuario o correo con los datos nuevos
                String selectSQL = "SELECT COUNT(*) FROM usuarios WHERE n_usuario = ? OR correo = ?";
                try (PreparedStatement preparedStatement = c.prepareStatement(selectSQL)) {
                    preparedStatement.setString(1, nuevoUsuario);
                    preparedStatement.setString(2, nuevoCorreo);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0; // Retorna true si ya existe un usuario o correo con los datos nuevos
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Por defecto, retorna false
    }
    private String copiarImagen(String nombreModelo) {
    try {
        String rutaImagen = "src/imagenesPerfil/" + nombreModelo + ".jpg";
        Files.copy(Paths.get(linkImagenSeleccionada), Paths.get(rutaImagen), StandardCopyOption.REPLACE_EXISTING);
        return rutaImagen;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
} 
    public void modificar() {
    Connection c = null;
    PreparedStatement pst = null;

    try {
        String usu = "SA";
        String bd = "jdbc:hsqldb:hsql://localhost/";
        String contra = "";

        // Intenta con recursos para asegurarte de cerrar las conexiones
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            c = DriverManager.getConnection(bd, usu, contra);

            String sql = "UPDATE usuarios SET nombre=?, apellido1=?, apellido2=?, n_usuario=?, correo=?, imagen=? WHERE id_user=?";
            pst = c.prepareStatement(sql);

            pst.setString(1, nombreL.getText());
            pst.setString(2, papL.getText());
            pst.setString(3, sapL.getText());
            pst.setString(4, usuarioL.getText());
            //pst.setString(5, contraL.getText());
            //pst.setBoolean(6, checkboxAdmin.isSelected());
            pst.setString(5, correoL.getText());
            pst.setString(6, nimg);
            pst.setInt(7, id); // Asegúrate de tener el ID correcto del usuario que deseas modificar

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                System.out.println("Registro actualizado correctamente");
                JOptionPane.showMessageDialog(this, "Modificación realizada con éxito");
                escribir();
                cargarImagen();
            } else {
                System.out.println("Error al actualizar el registro");
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (c != null) {
                c.close();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "png"));
        int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        // Obtener el archivo seleccionado
        File selectedFile = fileChooser.getSelectedFile();

        // Guardar la imagen en la carpeta del proyecto
        String fileName = selectedFile.getName();
        String destinationPath = "src/imagenesPerfil/" + usuarioL.getText()+".jpg";
        System.out.println("Filename: "+destinationPath);
        try {
            linkImagenSeleccionada = selectedFile.getAbsolutePath();
            System.out.println("Imagen seleccionada en: " + linkImagenSeleccionada);

            // Actualizar la URL en la base de datos
                String usu = "SA";
                String bd = "jdbc:hsqldb:hsql://localhost/";
                String contra = "";

        // Intenta con recursos para asegurarte de cerrar las conexiones
        
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            c = DriverManager.getConnection(bd, usu, contra);
            String updateUrlSQL = "UPDATE usuarios SET imagen = ? WHERE id_user= ?";
            try (PreparedStatement preparedStatement = c.prepareStatement(updateUrlSQL)) {
                System.out.println("1"+destinationPath);
                preparedStatement.setString(1, destinationPath);
                System.out.println("2"+destinationPath);
                nimg=destinationPath;
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(modUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        filtrarPral f=new filtrarPral(true,id);
        f.setVisible(true);
        f.jCheckBoxMenuItem1.setSelected(true);
        f.jMenu2.setVisible(true);
        f.tablaAdmin();
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        add a=new add(id);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        addMarcas am=new addMarcas(id);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            addModelos m=new addModelos();
            m.setVisible(rootPaneCheckingEnabled);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(filtrarPral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        usuarios u=new usuarios(id);
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(modUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modUsuarios(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correoL;
    private javax.swing.JTextField idL;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nombreL;
    private javax.swing.JTextField papL;
    private javax.swing.JTextField sapL;
    private javax.swing.JTextField usuarioL;
    // End of variables declaration//GEN-END:variables
}
