/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sebas
 */
public class usuarios extends javax.swing.JFrame {

    /**
     * Creates new form usuarios
     */
    private int id;
    private Connection c;
    public usuarios(int idp) {
        initComponents();
        this.setTitle("Página Principal");
        this.setLocationRelativeTo(null);
        id=idp;
        tabla();
        escribir(id);
        System.out.println("Iniciando desde constructor normal");
        String usu = "SA";
            String bd = "jdbc:hsqldb:hsql://localhost/";
            String contra = "";
            c = null;

            try {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
                c = DriverManager.getConnection(bd, usu, contra);

                if (c != null) {
                    System.out.println("Conectado");
                } else {
                    System.out.println("Fallo");
                }
            }
            catch(Exception e){
                
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nomL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usuL = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        papL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sapL = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Centro de usuarios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

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
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 610, 230));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sesión actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 28, -1, -1));

        nomL.setForeground(new java.awt.Color(255, 0, 0));
        nomL.setText("jLabel4");
        jPanel1.add(nomL, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 28, 70, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nombre de usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 28, -1, -1));

        usuL.setForeground(new java.awt.Color(255, 0, 0));
        usuL.setText("jLabel4");
        jPanel1.add(usuL, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 28, 70, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Primer Apellido:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 74, -1, -1));

        papL.setForeground(new java.awt.Color(255, 0, 0));
        papL.setText("jLabel4");
        jPanel1.add(papL, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 74, 70, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Segundo Apellido:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 74, -1, -1));

        sapL.setForeground(new java.awt.Color(255, 0, 0));
        sapL.setText("jLabel4");
        jPanel1.add(sapL, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 74, 70, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        jButton1.setText("Más información");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 150, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoUsuario.png"))); // NOI18N
        jButton3.setText("Añadir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 610, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crema.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 410));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mInfou mi=new mInfou(id);
        mi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(jTable1.getSelectedColumn()==6){
            int nId=(int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            mInfou mi=new mInfou(nId);
            mi.setVisible(true);
            this.dispose();
        }
        if(jTable1.getSelectedColumn()==7){
            int nId=(int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            modUsuarios mi=new modUsuarios(nId);
            mi.setVisible(true);
            this.dispose();
        }
        if(jTable1.getSelectedColumn()==8){
            int nId=(int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {               
                eliminar(nId);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public void eliminar(int elId) {
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

            // Comprobación si hay referencias en la tabla coche
            String comprobacionSQL = "SELECT COUNT(*) FROM coche WHERE id_usuario = ?";
            try (PreparedStatement comprobacionStmt = c.prepareStatement(comprobacionSQL)) {
                comprobacionStmt.setInt(1, elId);
                ResultSet resultado = comprobacionStmt.executeQuery();

                if (resultado.next()) {
                    int cantidadReferencias = resultado.getInt(1);

                    if (cantidadReferencias > 0) {
                        // Pregunta al usuario si desea eliminar también los registros en la tabla coche
                        int respuesta = JOptionPane.showConfirmDialog(this, "¿Eliminar también los registros de coche asociados?", "Confirmar", JOptionPane.YES_NO_OPTION);

                        if (respuesta == JOptionPane.YES_OPTION) {
                            // Eliminar registros en la tabla coche
                            String eliminarCocheSQL = "DELETE FROM coche WHERE id_usuario = ?";
                            try (PreparedStatement eliminarCocheStmt = c.prepareStatement(eliminarCocheSQL)) {
                                eliminarCocheStmt.setInt(1, elId);
                                eliminarCocheStmt.executeUpdate();
                            }
                        } else {
                            // El usuario eligió "No", cancela la operación
                            return;
                        }
                    }
                }
            }
            // Si no hay referencias o si el usuario eligió "Yes", procede con la eliminación del usuario
            String eliminarSQL = "DELETE FROM usuarios WHERE id_user = ?";

            try (PreparedStatement pstmt = c.prepareStatement(eliminarSQL)) {
                pstmt.setInt(1, elId);

                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    tabla(); // Método para actualizar la tabla después de eliminar
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            modUsuarios mi=new modUsuarios(id);
            mi.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        registro r=new registro();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void escribir(int id){
        String usu = "SA";
            String bd = "jdbc:hsqldb:hsql://localhost/";
            String contra = "";
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
                ResultSet resul=leer.executeQuery("SELECT id_user, nombre, apellido1, apellido2, n_usuario "
                        + " FROM usuarios WHERE id_user="+id);
                /*ResultSet resul=leer.executeQuery("SELECT marca "+"FROM marcas");*/
            
                while(resul.next())
                {
                    datos[0]=resul.getInt(1);
                    
                    datos[1]=resul.getString(2);
                    nomL.setText(datos[1].toString());
                    datos[2]=resul.getString(3);
                    papL.setText(datos[2].toString());
                    datos[3]=resul.getString(4);
                    sapL.setText(datos[3].toString());
                    datos[4]=resul.getString(5);
                    usuL.setText(datos[4].toString());
                    
                }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void tabla(){
        String usu = "SA";
            String bd = "jdbc:hsqldb:hsql://localhost/";
            String contra = "";
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
                        case 5: return Boolean.class;
                        case 6: return ImageIcon.class;
                        case 7: return ImageIcon.class;
                        case 8: return ImageIcon.class;
                        default:return Object.class;
                    }
                }
             };
           
                dtm.addColumn("ID");                
                dtm.addColumn("Nombre"); 
                dtm.addColumn("Apellido 1");
                dtm.addColumn("Apellido 2");
                dtm.addColumn("Usuario");
                dtm.addColumn("Admin");
                dtm.addColumn("Más info");
                dtm.addColumn("Modificar");
                dtm.addColumn("Eliminar");
                
        
                jTable1.setModel(dtm);
                
                
                jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(0).setMinWidth(0);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
                jTable1.getColumnModel().getColumn(0).setResizable(false);
                jTable1.getColumnModel().getColumn(0).setCellEditor(null);
                
                
                jTable1.getColumnModel().getColumn(1).setResizable(false);
                jTable1.getColumnModel().getColumn(1).setCellEditor(null);
                
                
                jTable1.getColumnModel().getColumn(2).setResizable(false);
                jTable1.getColumnModel().getColumn(2).setCellEditor(null);
                               
                jTable1.getColumnModel().getColumn(3).setResizable(false);
                jTable1.getColumnModel().getColumn(3).setCellEditor(null);
                
                
                jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
                jTable1.getColumnModel().getColumn(4).setMinWidth(90);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
                jTable1.getColumnModel().getColumn(4).setResizable(false);
                jTable1.getColumnModel().getColumn(4).setCellEditor(null);
                                
                jTable1.getColumnModel().getColumn(5).setResizable(false);
                jTable1.getColumnModel().getColumn(5).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(6).setResizable(false);
                jTable1.getColumnModel().getColumn(6).setCellEditor(null);
                                
                jTable1.getColumnModel().getColumn(7).setResizable(false);
                jTable1.getColumnModel().getColumn(7).setCellEditor(null);
                               
                jTable1.getColumnModel().getColumn(8).setResizable(false);
                jTable1.getColumnModel().getColumn(8).setCellEditor(null);
                
               

                
                Object[] datos=new Object[14];
                
        
                Statement leer= c.createStatement();
                ResultSet resul=leer.executeQuery("SELECT id_user, nombre, apellido1, apellido2, n_usuario, administrador "
                        + " FROM usuarios WHERE id_user!="+id);
                /*ResultSet resul=leer.executeQuery("SELECT marca "+"FROM marcas");*/
            
                while(resul.next())
                {
                    datos[0]=resul.getInt(1);
                    datos[1]=resul.getString(2);
                    datos[2]=resul.getString(3);
                    datos[3]=resul.getString(4);
                    datos[4]=resul.getString(5);
                    datos[5]=resul.getBoolean(6);                                
                    datos[6]=new ImageIcon(getClass().getResource("/imagenes/mas.png"));
                    datos[7]=new ImageIcon(getClass().getResource("/imagenes/mod.png"));//modificar
                    datos[8]=new ImageIcon(getClass().getResource("/imagenes/borrar.png"));//eliminar
                    
                    
                    dtm.addRow(datos);
                }
                jTable1.setCellSelectionEnabled(false);
                jTable1.setRowSelectionAllowed(false);
                jTable1.setColumnSelectionAllowed(false);
                jTable1.getTableHeader().setReorderingAllowed(false);
                jTable1.getColumnModel().setColumnMargin(1);
                jTable1.setIntercellSpacing(new Dimension(1, 1)); 
                jTable1.getTableHeader().setForeground(Color.RED);
                
            jTable1.setModel(dtm);
    }
        catch(Exception e){
            
        }
    }
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
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuarios(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nomL;
    private javax.swing.JLabel papL;
    private javax.swing.JLabel sapL;
    private javax.swing.JLabel usuL;
    // End of variables declaration//GEN-END:variables
}
