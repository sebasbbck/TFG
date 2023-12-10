/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sebas
 */
public class addMarcas extends javax.swing.JFrame {

    private String link;
    private String ul;
    private Connection c;
    private String linkImagenSeleccionada;
    private int id;
    
    public addMarcas(int sid) {
        initComponents();
        tabla();
        id=sid;
        this.setTitle("Añadir nueva marca");
        this.setLocationRelativeTo(null);
        String usu = "SA";
        String bd = "jdbc:hsqldb:hsql://localhost/";
        String contra = "";

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            c = DriverManager.getConnection(bd, usu, contra);
            if (c != null) {
                System.out.println("Conectado");
            } else {
                System.out.println("Fallo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    public void tabla(){
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
           DefaultTableModel dtm=new DefaultTableModel()
             {
                 @Override
                public boolean isCellEditable(int row, int column) {
                return false;
                }
                @Override
                public Class getColumnClass(int columnIndex) {
                    switch(columnIndex){
                        case 1: return ImageIcon.class;
                        case 2: return ImageIcon.class;
                        
                        default:return Object.class;
                    }
                }
             };
           
                dtm.addColumn("Marca");               
                dtm.addColumn("Modificar");
                dtm.addColumn("Eliminar");
                
        
                jTable1.setModel(dtm);
                
               
                jTable1.getColumnModel().getColumn(0).setResizable(false);
                jTable1.getColumnModel().getColumn(0).setCellEditor(null);

                jTable1.getColumnModel().getColumn(1).setResizable(false);
                jTable1.getColumnModel().getColumn(1).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(2).setResizable(false);
                jTable1.getColumnModel().getColumn(2).setCellEditor(null);

                
                Object[] datos=new Object[14];
                
        
                Statement leer= c.createStatement();
                ResultSet resul=leer.executeQuery("SELECT DISTINCT marca FROM marcas");
            
                while (resul.next()) {
                    datos[0] = resul.getString(1);
                    datos[1] = new ImageIcon(getClass().getResource("/imagenes/mod.png")); // modificar
                    datos[2] = new ImageIcon(getClass().getResource("/imagenes/borrar.png")); // eliminar
                    

    dtm.addRow(datos);
}

                jTable1.setCellSelectionEnabled(false);
                jTable1.setRowSelectionAllowed(false);
                jTable1.setColumnSelectionAllowed(false);
                jTable1.getTableHeader().setReorderingAllowed(false);
                
                jTable1.setIntercellSpacing(new Dimension(0, 0));
                jTable1.getTableHeader().setForeground(Color.RED);
                
            jTable1.setModel(dtm);
        }
        catch(Exception e){
            System.out.println("errol");
            e.printStackTrace();
        }
    }
    private boolean existeMarca(Connection conexion, String marca) throws SQLException {
    String sql = "SELECT COUNT(*) FROM marcas WHERE marca = ?";
    try (PreparedStatement pst = conexion.prepareStatement(sql)) {
        pst.setString(1, marca);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Retorna true si existe al menos un registro con la matrícula
            }
        }
    }
    return false;
}
   
    public void agregar(String nombreMarca, String rutaImagen) {
    String usu = "SA";
    String bd = "jdbc:hsqldb:hsql://localhost/";
    String contra = "";
    Connection c = null;

    try {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        c = DriverManager.getConnection(bd, usu, contra);
        if (c != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("Fallo");
        }


        if (!jTextField1.getText().isBlank()) {
            

            if (existeMarca(c, jTextField1.getText())) {
                JOptionPane.showMessageDialog(null, "La marca ya existe en la base de datos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // No continuar con la inserción
            }

            
            System.out.println("empezando sql");
            String sql2 = "INSERT INTO marcas VALUES(?, ?)";
    try (PreparedStatement pstmt = c.prepareStatement(sql2)) {
        pstmt.setString(1, nombreMarca);
        pstmt.setString(2, rutaImagen);

        int resultado = pstmt.executeUpdate();

        if (resultado > 0) {
            System.out.println("Registro actualizado correctamente");
            JOptionPane.showMessageDialog(this, "Marca añadida exitosamente");
            tabla();
        } else {
            System.out.println("Error al actualizar el registro");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
            

        } 
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    public void cargarImagen(String t){
        String usu="SA";
        String bd="jdbc:hsqldb:hsql://localhost/";
        String contra="";
        Connection c=null;
        link=t;
        
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
                ResultSet resul2=leer2.executeQuery("SELECT url FROM marcas WHERE marca='"+t+"'");
      
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

                    Image newImage = image.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
    
                    ImageIcon newImageIcon = new ImageIcon(newImage);

                    jLabel1.setIcon(newImageIcon);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
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

        jPanel1.setMaximumSize(new java.awt.Dimension(220, 180));
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 200, 170));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 280, 166));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Logo de la marca");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home.png"))); // NOI18N
        jButton2.setText("Inicio");
        jButton2.setMaximumSize(new java.awt.Dimension(102, 31));
        jButton2.setMinimumSize(new java.awt.Dimension(102, 31));
        jButton2.setPreferredSize(new java.awt.Dimension(102, 31));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/subirimagen.png"))); // NOI18N
        jButton3.setText("Subir imagen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 120, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/blue2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

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

    
    private String copiarImagen(String nombreMarca) {
    try {
        String rutaImagen = "src/imagenesMarcas/" + nombreMarca + ".jpg";
        Files.copy(Paths.get(linkImagenSeleccionada), Paths.get(rutaImagen), StandardCopyOption.REPLACE_EXISTING);
        return rutaImagen;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
} 
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "png"));
    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        // Obtener el archivo seleccionado
        File selectedFile = fileChooser.getSelectedFile();

        // Guardar la imagen en la carpeta del proyecto
        String fileName = selectedFile.getName();
        String destinationPath = "src/imagenesMarcas/" + fileName;

        try {
            linkImagenSeleccionada = selectedFile.getAbsolutePath();
            System.out.println("Imagen seleccionada en: " + linkImagenSeleccionada);

            // Actualizar la URL en la base de datos
            String marca = jTextField1.getText();
            String updateUrlSQL = "UPDATE marcas SET url = ? WHERE marca = ?";
            try (PreparedStatement preparedStatement = c.prepareStatement(updateUrlSQL)) {
                preparedStatement.setString(1, destinationPath);
                preparedStatement.setString(2, marca);
                preparedStatement.executeUpdate();

                // Actualizar la tabla
                tabla();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(jTable1.getSelectedColumn()==0){
            String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();            
                cargarImagen(t);
            }
        if(jTable1.getSelectedColumn()==1){
                String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();            
                modMarcas mm=new modMarcas(t,id);
                mm.setVisible(true);
                this.dispose();
            }
        if(jTable1.getSelectedColumn()==2){
            
                String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                eliminar(t);
            
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            if (!jTextField1.getText().isBlank() && linkImagenSeleccionada != null) {
        String rutaImagen = copiarImagen(jTextField1.getText());

        if (rutaImagen != null) {
            agregar(jTextField1.getText(), rutaImagen);
        } else {
            JOptionPane.showMessageDialog(this, "Error al copiar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen y proporcionar un nombre de marca.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        filtrarPral f=new filtrarPral(true,id);
        f.setVisible(true);
        f.jCheckBoxMenuItem1.setSelected(true);
        f.jMenu2.setVisible(true);
        f.tablaAdmin();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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

   public void eliminar(String marca) {
    String usu = "SA";
    String bd = "jdbc:hsqldb:hsql://localhost/";
    String contra = "";
    Connection c = null;

    try {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        c = DriverManager.getConnection(bd, usu, contra);

        if (c != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("Fallo");
        }

        // Verificar si existen registros asociados en la tabla coche
        if (existenRegistrosAsociados(marca,c)) {
            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "Existen datos con la marca que se quiere borrar. "
                            + "Al borrar esta marca, también se borrarán dichos registros. ¿Quiere continuar?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                eliminarRegistros(marca, c);
            }
        } else {
            int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que quieres borrar la marca?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                eliminarRegistros(marca, c);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private boolean existenRegistrosAsociados(String marca, Connection connection) {
    String sql = "SELECT COUNT(*) FROM coche WHERE marca = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, marca);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


private void eliminarRegistros(String marca, Connection connection) {
    try {
        // Obtener la URL de la imagen asociada a la marca
        String obtenerUrlSQL = "SELECT url FROM marcas WHERE marca = ?";
        String urlImagen = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(obtenerUrlSQL)) {
            preparedStatement.setString(1, marca);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    urlImagen = resultSet.getString("url");
                }
            }
        }

        // Eliminar registros en la tabla coche
        String eliminarCocheSQL = "DELETE FROM coche WHERE marca = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(eliminarCocheSQL)) {
            preparedStatement.setString(1, marca);
            preparedStatement.executeUpdate();
        }

        // Eliminar la marca en la tabla marcas
        String eliminarMarcaSQL = "DELETE FROM marcas WHERE marca = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(eliminarMarcaSQL)) {
            preparedStatement.setString(1, marca);
            preparedStatement.executeUpdate();
        }

        // Eliminar la imagen asociada a la marca en la carpeta
        if (urlImagen != null) {
            File imagenFile = new File(urlImagen);
            if (imagenFile.exists()) {
                if (imagenFile.delete()) {
                    System.out.println("Imagen eliminada correctamente");
                    jLabel1.setIcon(null);
                } else {
                    System.out.println("Error al eliminar la imagen");
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Marca eliminada correctamente.");
        tabla(); // Método para actualizar la tabla después de eliminar
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public  void main(String args[]) {
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
            java.util.logging.Logger.getLogger(addMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addMarcas(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
