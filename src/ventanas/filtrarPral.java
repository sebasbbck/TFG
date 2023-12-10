/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpinnerNumberModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sebas
 */
public class filtrarPral extends javax.swing.JFrame {

/**
     * Creates new form filtrarPral
     */
        private int idAlm;
        private String fil;
        private String filA;
        private Connection c;
        public filtrarPral() {
        initComponents();
        conectar();
           
        this.setTitle("Página Principal");
        this.setLocationRelativeTo(null);
        jComboBox2.setEnabled(false);
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
        
        SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 500);
        SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 500);

        
        jSpinner1.setModel(spinnerModel1);
        jSpinner2.setModel(spinnerModel2);
       
        jSpinner1.getEditor().getComponent(0).addKeyListener(new NumericKeyListener());
        jSpinner2.getEditor().getComponent(0).addKeyListener(new NumericKeyListener());
        
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             
                   filtrar();
            }
        });

        jComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                   filtrar();
                
            }
        });

        jComboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                   filtrar();
                
            }
        });
        jMenuBar1.setVisible(false);
        jCheckBoxMenuItem1.setSelected(false);

    }
    public filtrarPral(boolean f, int i){
        initComponents();
        jCheckBoxMenuItem1.setSelected(false);
        conectar();
        idAlm=i;
        this.setTitle("Página Principal");
        this.setLocationRelativeTo(null);
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
        jComboBox2.setEnabled(false);
        System.out.println("Iniciando desde constructor raro");
        
        SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 500);
        SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 500);

        
        jSpinner1.setModel(spinnerModel1);
        jSpinner2.setModel(spinnerModel2);
       
        jSpinner1.getEditor().getComponent(0).addKeyListener(new NumericKeyListener());
        jSpinner2.getEditor().getComponent(0).addKeyListener(new NumericKeyListener());
        
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBoxMenuItem1.isSelected()){
                    filtrarAdmin();
                }
                else{
                   filtrar();
                }
            }
        });

        jComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBoxMenuItem1.isSelected()){
                    filtrarAdmin();
                }
                else{
                   filtrar();
                }
            }
        });

        jComboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBoxMenuItem1.isSelected()){
                    filtrarAdmin();
                }
                else{
                   filtrar();
                }
            }
        });
        jMenuBar1.setVisible(true);
        jMenu2.setVisible(false);
    }
     public class NumericKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();           
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {  
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Marcas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 44, -1, -1));

        jLabel2.setText("Modelo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 44, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas las marcas" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los modelos" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 66, -1, -1));

        jLabel3.setText("Motor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 106, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas los motores" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Precio");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 44, -1, -1));

        jLabel5.setText("Desde:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 69, -1, -1));

        jLabel6.setText("Hasta:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 162, 1090, 392));

        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinner1KeyPressed(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 80, -1));

        jSpinner2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinner2KeyPressed(evt);
            }
        });
        getContentPane().add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 80, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reiniciar.png"))); // NOI18N
        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inf.png"))); // NOI18N
        jButton2.setText("Informe");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/logo2.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apply.png"))); // NOI18N
        jButton3.setText("Aplicar precio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logout.png"))); // NOI18N
        jButton4.setText("Desconectar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/gris.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jMenu1.setText("Administrador");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Modo administrador");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()==0){
            jComboBox2.setEnabled(false);
            jComboBox2.setSelectedIndex(0);
        }
        else{
            jComboBox2.setEnabled(true); 
            activarCombo();           
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(jCheckBoxMenuItem1.isSelected()){
            if(jTable1.getSelectedColumn()==11){
            String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            if(jCheckBoxMenuItem1.isSelected()){
                mInfo m=new mInfo(t,true,idAlm);
                m.setVisible(true);
            }else{
               mInfo m=new mInfo(t,false,idAlm); 
               m.setVisible(true);
            }      
            
        }
        }
            if(!jCheckBoxMenuItem1.isSelected()){
                if(jTable1.getSelectedColumn()==9){
                String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();          
               mInfo m=new mInfo(t,false,idAlm); 
               m.setVisible(true);
              
            }
        }           
        
        if(jTable1.getSelectedColumn()==12){
            String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String c=jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
            System.out.println(c);
            Modificar mod=new Modificar(t,c,idAlm );
            mod.setVisible(true);
            this.dispose();
            
            
        }
        if (jTable1.getSelectedColumn() == 13) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                String b = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                eliminar(b);
            }
    }
    }//GEN-LAST:event_jTable1MouseClicked
        public void eliminar(String numeroBastidor) {
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

                String sql = "DELETE FROM coche WHERE n_bastidor = ?";

                try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                    pstmt.setString(1, numeroBastidor);

                    int filasAfectadas = pstmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        tablaAdmin(); // Método para actualizar la tabla después de eliminar
                        filtrarAdmin();
                    } 
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        if(jCheckBoxMenuItem1.isSelected()){
            tablaAdmin();  
        }
        else{
            conectar();
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            try {
                InputStream vinculararchivo = null;
                vinculararchivo = getClass().getResourceAsStream("/informes/informe3.jrxml");
                String ruta_imagen = "informes/logo2.png";
                JasperReport jr = null;

                Map<String, Object> mapa = new HashMap<>();
               
                if(jCheckBoxMenuItem1.isSelected()){
                    mapa.put("filtro", filA);
                }
                else{
                    mapa.put("filtro", fil);
                }
                
                
                System.out.println("where "+mapa.toString());  
                System.out.println("final "+mapa.toString());
                mapa.put("img", ruta_imagen);
                jr = JasperCompileManager.compileReport(vinculararchivo);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jr, mapa, c);
                JasperViewer visor = new JasperViewer(jasperPrint, false);
                visor.setVisible(true);
    

            } catch (JRException ex) {
                Logger.getLogger(filtrarPral.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
       if(jCheckBoxMenuItem1.isSelected()){
                    filtrarAdmin();
                }
        else{
            filtrar();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSpinner2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner2KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jSpinner2KeyPressed

    private void jSpinner1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jSpinner1KeyPressed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        if(jCheckBoxMenuItem1.isSelected()){
            tablaAdmin();
            jMenu2.setVisible(true);
            jMenuBar1.revalidate();
            jMenuBar1.repaint();
        }
        else{
            conectar();
            jMenu2.setVisible(false);
            jMenuBar1.revalidate();
            jMenuBar1.repaint();
        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        main m=new main();
        JOptionPane.showMessageDialog(this, "Cierre de sesión exitoso");
        m.setVisible(true);  
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        add a=new add(idAlm);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        addMarcas am=new addMarcas(idAlm);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
            
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
        usuarios u=new usuarios(idAlm);
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public Connection conectar(){
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
                        case 9: return ImageIcon.class;
                        default:return Object.class;
                    }
                }
             };
           
                dtm.addColumn("Matrícula");                
                dtm.addColumn("Marca");
                dtm.addColumn("Modelo");
                dtm.addColumn("Fecha");
                dtm.addColumn("Motor");                               
                dtm.addColumn("CV");              
                dtm.addColumn("NºPlazas");
                dtm.addColumn("Cambio");
                dtm.addColumn("€");    
                dtm.addColumn("Más info");
                
        
                jTable1.setModel(dtm);
                
                
                jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(0).setMinWidth(0);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
                jTable1.getColumnModel().getColumn(0).setResizable(false);
                jTable1.getColumnModel().getColumn(0).setCellEditor(null);
                
                
                jTable1.getColumnModel().getColumn(1).setMaxWidth(90);
                jTable1.getColumnModel().getColumn(1).setMinWidth(90);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
                jTable1.getColumnModel().getColumn(1).setResizable(false);
                jTable1.getColumnModel().getColumn(1).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
                jTable1.getColumnModel().getColumn(2).setMinWidth(150);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(2).setResizable(false);
                jTable1.getColumnModel().getColumn(2).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
                jTable1.getColumnModel().getColumn(3).setMinWidth(80);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(3).setResizable(false);
                jTable1.getColumnModel().getColumn(3).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(4).setMaxWidth(60);
                jTable1.getColumnModel().getColumn(4).setMinWidth(60);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
                jTable1.getColumnModel().getColumn(4).setResizable(false);
                jTable1.getColumnModel().getColumn(4).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(5).setMaxWidth(55);
                jTable1.getColumnModel().getColumn(5).setMinWidth(55);
                jTable1.getColumnModel().getColumn(5).setPreferredWidth(55);
                jTable1.getColumnModel().getColumn(5).setResizable(false);
                jTable1.getColumnModel().getColumn(5).setCellEditor(null);
                jTable1.getColumnModel().getColumn(6).setResizable(false);
                jTable1.getColumnModel().getColumn(6).setCellEditor(null);
                jTable1.getColumnModel().getColumn(7).setResizable(false);
                jTable1.getColumnModel().getColumn(7).setCellEditor(null);
                jTable1.getColumnModel().getColumn(8).setResizable(false);
                jTable1.getColumnModel().getColumn(8).setCellEditor(null);
                jTable1.getColumnModel().getColumn(9).setResizable(false);
                jTable1.getColumnModel().getColumn(9).setCellEditor(null);
                
                
                
                
                           
     
                Object[] datos=new Object[11];
                
        
                Statement leer= c.createStatement();
                ResultSet resul=leer.executeQuery("SELECT matricula, marca, modelo, fecha_fab, motor, potencia, n_plazas, cambio, precio "
                        + " FROM coche WHERE estado='Disponible'");
                /*ResultSet resul=leer.executeQuery("SELECT marca "+"FROM marcas");*/
            
                while(resul.next())
                {
                    datos[0]=resul.getString(1);                
                    datos[1]=resul.getString(2);
                    datos[2]=resul.getString(3);
                    datos[3]=resul.getString(4);                  
                    datos[4]=resul.getString(5);
                    datos[5]=resul.getInt(6);                   
                    datos[6]=resul.getInt(7);
                    datos[7]=resul.getString(8);
                    datos[8]=resul.getInt(9);
                    datos[9]=new ImageIcon(getClass().getResource("/imagenes/mas.png"));
                    
                    
                    dtm.addRow(datos);
                }
                jTable1.setCellSelectionEnabled(false);
                jTable1.setRowSelectionAllowed(false);
                jTable1.setColumnSelectionAllowed(false);
                jTable1.getTableHeader().setReorderingAllowed(false);
                
                jTable1.setIntercellSpacing(new Dimension(0, 0));
                jTable1.getTableHeader().setForeground(Color.RED);
                
            jTable1.setModel(dtm);
            
            ResultSet resultado1 = null;
            String sql1="SELECT DISTINCT marca from marcas ";
            Statement s1 = c.createStatement();
            resultado1=s1.executeQuery(sql1);
              
            
            
            ResultSet resultado3 = null;
            String sql3="SELECT DISTINCT motor from motores";
            Statement s3 = c.createStatement();
            resultado3=s3.executeQuery(sql3);
            
            
            jComboBox1.removeAllItems();
            jComboBox1.addItem("Todas las marcas");
            while(resultado1.next())
            {
                jComboBox1.addItem(resultado1.getString(1));
            }
                      
            
            jComboBox3.removeAllItems();
            jComboBox3.addItem("Todas las marcas");      
            while(resultado3.next())
            {
                jComboBox3.addItem(resultado3.getString(1));
                
            }
            
        }
        catch(Exception e){
            System.out.println("errol");
        }
        return c;
    }
    public void activarCombo(){
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
        if(jComboBox1.getSelectedIndex()==0){
            jComboBox2.setEnabled(false);
        }
        else{
            ResultSet resultado2 = null;
            String sql2="SELECT modelo " +
            "FROM modelos " +
            "WHERE marca = '"+jComboBox1.getSelectedItem().toString()+"'";
            System.out.print(jComboBox1.getSelectedItem().toString());
            Statement s2 = c.createStatement();
            resultado2=s2.executeQuery(sql2);
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Todos los modelos");
            while(resultado2.next())
            {
                jComboBox2.addItem(resultado2.getString(1));
            }
        }
        
        }
        catch(Exception e){
            
        }
    }
    public void filtrar() {
    String usu = "SA";
    String bd = "jdbc:hsqldb:hsql://localhost/";
    String contra = "";
    Connection c = null;
    try {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        c = DriverManager.getConnection(bd, usu, contra);
        if (c != null) {
            System.out.println("Conectau");
        } else {
            System.out.println("fallo");
        }

        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 9:
                        return ImageIcon.class;
                    default:
                        return Object.class;
                }
            }
        };

        dtm.addColumn("Matrícula");
        dtm.addColumn("Marca");
        dtm.addColumn("Modelo");
        dtm.addColumn("Fecha");
        dtm.addColumn("Motor");
        dtm.addColumn("CV");
        dtm.addColumn("NºPlazas");
        dtm.addColumn("Cambio");
        dtm.addColumn("€");
        dtm.addColumn("Más info");

        jTable1.setModel(dtm);

        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setCellEditor(null);

        jTable1.getColumnModel().getColumn(1).setMaxWidth(90);
                jTable1.getColumnModel().getColumn(1).setMinWidth(90);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
                jTable1.getColumnModel().getColumn(1).setResizable(false);
                jTable1.getColumnModel().getColumn(1).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
                jTable1.getColumnModel().getColumn(2).setMinWidth(150);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(2).setResizable(false);
                jTable1.getColumnModel().getColumn(2).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
                jTable1.getColumnModel().getColumn(3).setMinWidth(80);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(3).setResizable(false);
                jTable1.getColumnModel().getColumn(3).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(4).setMaxWidth(60);
                jTable1.getColumnModel().getColumn(4).setMinWidth(60);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
                jTable1.getColumnModel().getColumn(4).setResizable(false);
                jTable1.getColumnModel().getColumn(4).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(5).setMaxWidth(55);
                jTable1.getColumnModel().getColumn(5).setMinWidth(55);
                jTable1.getColumnModel().getColumn(5).setPreferredWidth(55);
                jTable1.getColumnModel().getColumn(5).setResizable(false);
                jTable1.getColumnModel().getColumn(5).setCellEditor(null);
                jTable1.getColumnModel().getColumn(6).setResizable(false);
                jTable1.getColumnModel().getColumn(6).setCellEditor(null);
                jTable1.getColumnModel().getColumn(7).setResizable(false);
                jTable1.getColumnModel().getColumn(7).setCellEditor(null);
                jTable1.getColumnModel().getColumn(8).setResizable(false);
                jTable1.getColumnModel().getColumn(8).setCellEditor(null);
                jTable1.getColumnModel().getColumn(9).setResizable(false);
                jTable1.getColumnModel().getColumn(9).setCellEditor(null);
        

        int valorMin = (int) jSpinner1.getValue();
        int valorMax = (int) jSpinner2.getValue();

        // Construimos la cláusula WHERE
        StringBuilder condicion = new StringBuilder();

        // Añadimos las condiciones de los ComboBox
        if (jComboBox1.getSelectedIndex() > 0) {
            condicion.append("marca = '").append(jComboBox1.getSelectedItem()).append("'");
        }

        if (jComboBox2.getSelectedIndex() > 0) {
            if (condicion.length() > 0) {
                condicion.append(" AND ");
            }
            condicion.append("modelo = '").append(jComboBox2.getSelectedItem()).append("'");
        }

        if (jComboBox3.getSelectedIndex() > 0) {
            if (condicion.length() > 0) {
                condicion.append(" AND ");
            }
            condicion.append("motor = '").append(jComboBox3.getSelectedItem()).append("'");
        }
         
        if (valorMin > 0 || valorMax > 0) {           
            if (condicion.length() > 0) {
                condicion.append(" AND ");
                System.out.print(jSpinner1.getValue().toString());
            System.out.print(jSpinner2.getValue().toString());
            }

            if (valorMin > 0 && valorMax > 0) {
                
                condicion.append("precio BETWEEN ").append(valorMin).append(" AND ").append(valorMax);
            } else if (valorMin > 0) {
                condicion.append("precio >= ").append(valorMin);
            } else {
                condicion.append("precio <= ").append(valorMax);
            }
        }
        String clausula = condicion.toString();

        // Construimos la consulta SQL
        String consultaSQL = "SELECT matricula, marca, modelo, fecha_fab, motor, potencia, n_plazas, cambio, precio, id_usuario, n_bastidor, n_puertas, id_color, cilindrada "
                + " FROM coche" + " WHERE estado='Disponible' "+(clausula.isEmpty() ? "" : " AND " + clausula);
        
        fil= (clausula.isEmpty() ? "" : " WHERE " + clausula);
        System.out.println(fil);
      
        Object[] datos = new Object[10];

        Statement leer = c.createStatement();
        ResultSet resul = leer.executeQuery(consultaSQL);

        while (resul.next()) {
            datos[0] = resul.getString(1);
            datos[1] = resul.getString(2);
            datos[2] = resul.getString(3);
            datos[3] = resul.getString(4);
            datos[4] = resul.getString(5);
            datos[5] = resul.getInt(6);
            datos[6] = resul.getInt(7);
            datos[7] = resul.getString(8);
            datos[8] = resul.getInt(9);
            datos[9] = new ImageIcon(getClass().getResource("/imagenes/mas.png"));

            dtm.addRow(datos);
        }

        jTable1.setCellSelectionEnabled(false);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setColumnSelectionAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        
        jTable1.setIntercellSpacing(new Dimension(0, 0));
        jTable1.getTableHeader().setForeground(Color.RED);

        jTable1.setModel(dtm);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void filtrarAdmin(){
        String usu = "SA";
    String bd = "jdbc:hsqldb:hsql://localhost/";
    String contra = "";
    Connection c = null;
    try {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        c = DriverManager.getConnection(bd, usu, contra);
        if (c != null) {
            System.out.println("Conectau");
        } else {
            System.out.println("fallo");
        }

        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 11:
                        return ImageIcon.class;
                    case 12:
                        return ImageIcon.class;
                    case 13:
                        return ImageIcon.class;
                    default:
                        return Object.class;
                }
            }
        };

        dtm.addColumn("Matrícula");
        dtm.addColumn("Bastidor");
        dtm.addColumn("Color");
        dtm.addColumn("Marca");
        dtm.addColumn("Modelo");
        dtm.addColumn("Fecha");
        dtm.addColumn("Motor");
        dtm.addColumn("CV");
        dtm.addColumn("NºPlazas");
        dtm.addColumn("Cambio");
        dtm.addColumn("€");
        dtm.addColumn("Más info");
        dtm.addColumn("Modificar");
        dtm.addColumn("Eliminar");

        jTable1.setModel(dtm);

        jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
                jTable1.getColumnModel().getColumn(0).setMinWidth(70);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
                jTable1.getColumnModel().getColumn(0).setResizable(false);
                jTable1.getColumnModel().getColumn(0).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(1).setMaxWidth(160);
                jTable1.getColumnModel().getColumn(1).setMinWidth(160);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(160);
                jTable1.getColumnModel().getColumn(1).setResizable(false);
                jTable1.getColumnModel().getColumn(1).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(2).setMaxWidth(65);
                jTable1.getColumnModel().getColumn(2).setMinWidth(65);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(65);
                jTable1.getColumnModel().getColumn(2).setResizable(false);
                jTable1.getColumnModel().getColumn(2).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
                jTable1.getColumnModel().getColumn(3).setMinWidth(80);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(3).setResizable(false);
                jTable1.getColumnModel().getColumn(3).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
                jTable1.getColumnModel().getColumn(4).setMinWidth(90);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
                jTable1.getColumnModel().getColumn(4).setResizable(false);
                jTable1.getColumnModel().getColumn(4).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(5).setMaxWidth(80);
                jTable1.getColumnModel().getColumn(5).setMinWidth(80);
                jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(5).setResizable(false);
                jTable1.getColumnModel().getColumn(5).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(6).setResizable(false);
                jTable1.getColumnModel().getColumn(6).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
                jTable1.getColumnModel().getColumn(7).setMinWidth(50);
                jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(7).setResizable(false);
                jTable1.getColumnModel().getColumn(7).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(8).setMaxWidth(50);
                jTable1.getColumnModel().getColumn(8).setMinWidth(50);
                jTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(8).setResizable(false);
                jTable1.getColumnModel().getColumn(8).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(9).setResizable(false);
                jTable1.getColumnModel().getColumn(9).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(10).setResizable(false);
                jTable1.getColumnModel().getColumn(10).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(11).setResizable(false);
                jTable1.getColumnModel().getColumn(11).setCellEditor(null);
                jTable1.getColumnModel().getColumn(12).setResizable(false);
                jTable1.getColumnModel().getColumn(12).setCellEditor(null);
                jTable1.getColumnModel().getColumn(13).setResizable(false);
                jTable1.getColumnModel().getColumn(13).setCellEditor(null);

        int valorMin = (int) jSpinner1.getValue();
        int valorMax = (int) jSpinner2.getValue();

        // Construimos la cláusula WHERE
        StringBuilder condicion = new StringBuilder();

        // Añadimos las condiciones de los ComboBox
        if (jComboBox1.getSelectedIndex() > 0) {
            condicion.append("marca = '").append(jComboBox1.getSelectedItem()).append("'");
        }

        if (jComboBox2.getSelectedIndex() > 0) {
            if (condicion.length() > 0) {
                condicion.append(" AND ");
            }
            condicion.append("modelo = '").append(jComboBox2.getSelectedItem()).append("'");
        }

        if (jComboBox3.getSelectedIndex() > 0) {
            if (condicion.length() > 0) {
                condicion.append(" AND ");
            }
            condicion.append("motor = '").append(jComboBox3.getSelectedItem()).append("'");
        }
         
        if (valorMin > 0 || valorMax > 0) {           
            if (condicion.length() > 0) {
                condicion.append(" AND ");
                System.out.print(jSpinner1.getValue().toString());
            System.out.print(jSpinner2.getValue().toString());
            }

            if (valorMin > 0 && valorMax > 0) {
                
                condicion.append("precio BETWEEN ").append(valorMin).append(" AND ").append(valorMax);
            } else if (valorMin > 0) {
                condicion.append("precio >= ").append(valorMin);
            } else {
                condicion.append("precio <= ").append(valorMax);
            }
        }
        
        String clausula = condicion.toString();

        // Construimos la consulta SQL
        String consultaSQL = "SELECT matricula, n_bastidor, id_color, marca, modelo, fecha_fab, motor, potencia, n_plazas, cambio, precio, id_usuario "
                + " FROM coche" + (clausula.isEmpty() ? "" : " WHERE " + clausula);
        
        filA = (clausula.isEmpty() ? "" : " WHERE " + clausula);

      
        Object[] datos = new Object[14];

        Statement leer = c.createStatement();
        ResultSet resul = leer.executeQuery(consultaSQL);

        while (resul.next()) {
            datos[0] = resul.getString(1);
            datos[1] = resul.getString(2);
            datos[2] = resul.getString(3);
            datos[3] = resul.getString(4);
            datos[4] = resul.getString(5);
            datos[5] = resul.getString(6);
            datos[6] = resul.getString(7);
            datos[7] = resul.getInt(8);
            datos[8] = resul.getInt(9);
            datos[9] = resul.getString(10);
            datos[10] = resul.getInt(11);
            datos[11] = new ImageIcon(getClass().getResource("/imagenes/mas.png"));
            datos[12]=new ImageIcon(getClass().getResource("/imagenes/mod.png"));//modificar
            datos[13]=new ImageIcon(getClass().getResource("/imagenes/borrar.png"));//eliminar

            dtm.addRow(datos);
        }

        jTable1.setCellSelectionEnabled(false);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setColumnSelectionAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        
        jTable1.setIntercellSpacing(new Dimension(0, 0));
        jTable1.getTableHeader().setForeground(Color.RED);

        jTable1.setModel(dtm);

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    public void tablaAdmin(){
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
                        case 11: return ImageIcon.class;
                        case 12: return ImageIcon.class;
                        case 13: return ImageIcon.class;
                        default:return Object.class;
                    }
                }
             };
           
                dtm.addColumn("Matrícula");
                dtm.addColumn("Bastidor");
                dtm.addColumn("Color"); 
                dtm.addColumn("Marca");
                dtm.addColumn("Modelo");
                dtm.addColumn("Fecha");
                dtm.addColumn("Motor");                               
                dtm.addColumn("CV");              
                dtm.addColumn("NºPlazas");
                dtm.addColumn("Cambio");
                dtm.addColumn("€");    
                dtm.addColumn("Más info");
                dtm.addColumn("Modificar");
                dtm.addColumn("Eliminar");
                
        
                jTable1.setModel(dtm);
                
                
                jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
                jTable1.getColumnModel().getColumn(0).setMinWidth(70);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
                jTable1.getColumnModel().getColumn(0).setResizable(false);
                jTable1.getColumnModel().getColumn(0).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(1).setMaxWidth(160);
                jTable1.getColumnModel().getColumn(1).setMinWidth(160);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(160);
                jTable1.getColumnModel().getColumn(1).setResizable(false);
                jTable1.getColumnModel().getColumn(1).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(2).setMaxWidth(65);
                jTable1.getColumnModel().getColumn(2).setMinWidth(65);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(65);
                jTable1.getColumnModel().getColumn(2).setResizable(false);
                jTable1.getColumnModel().getColumn(2).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
                jTable1.getColumnModel().getColumn(3).setMinWidth(80);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(3).setResizable(false);
                jTable1.getColumnModel().getColumn(3).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
                jTable1.getColumnModel().getColumn(4).setMinWidth(90);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
                jTable1.getColumnModel().getColumn(4).setResizable(false);
                jTable1.getColumnModel().getColumn(4).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(5).setMaxWidth(80);
                jTable1.getColumnModel().getColumn(5).setMinWidth(80);
                jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(5).setResizable(false);
                jTable1.getColumnModel().getColumn(5).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(6).setResizable(false);
                jTable1.getColumnModel().getColumn(6).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
                jTable1.getColumnModel().getColumn(7).setMinWidth(50);
                jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(7).setResizable(false);
                jTable1.getColumnModel().getColumn(7).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(8).setMaxWidth(50);
                jTable1.getColumnModel().getColumn(8).setMinWidth(50);
                jTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(8).setResizable(false);
                jTable1.getColumnModel().getColumn(8).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(9).setResizable(false);
                jTable1.getColumnModel().getColumn(9).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(10).setResizable(false);
                jTable1.getColumnModel().getColumn(10).setCellEditor(null);
                
                jTable1.getColumnModel().getColumn(11).setResizable(false);
                jTable1.getColumnModel().getColumn(11).setCellEditor(null);
                jTable1.getColumnModel().getColumn(12).setResizable(false);
                jTable1.getColumnModel().getColumn(12).setCellEditor(null);
                jTable1.getColumnModel().getColumn(13).setResizable(false);
                jTable1.getColumnModel().getColumn(13).setCellEditor(null);

                
                Object[] datos=new Object[14];
                
        
                Statement leer= c.createStatement();
                ResultSet resul=leer.executeQuery("SELECT matricula, n_bastidor, id_color, marca, modelo, fecha_fab, motor, potencia, n_plazas, cambio, precio "
                        + " FROM coche ");
                /*ResultSet resul=leer.executeQuery("SELECT marca "+"FROM marcas");*/
            
                while(resul.next())
                {
                    datos[0]=resul.getString(1);
                    datos[1]=resul.getString(2);
                    datos[2]=resul.getString(3);
                    datos[3]=resul.getString(4);
                    datos[4]=resul.getString(5);
                    datos[5]=resul.getString(6);                
                    datos[6]=resul.getString(7);
                    datos[7]=resul.getInt(8);                   
                    datos[8]=resul.getInt(9);
                    datos[9]=resul.getString(10);
                    datos[10]=resul.getInt(11);
                    datos[11]=new ImageIcon(getClass().getResource("/imagenes/mas.png"));
                    datos[12]=new ImageIcon(getClass().getResource("/imagenes/mod.png"));//modificar
                    datos[13]=new ImageIcon(getClass().getResource("/imagenes/borrar.png"));//eliminar
                    
                    
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
            
        }
    }

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
            java.util.logging.Logger.getLogger(filtrarPral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(filtrarPral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(filtrarPral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(filtrarPral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new filtrarPral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
