/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;


/**
 *
 * @author sebas
 */
public class add extends javax.swing.JDialog {

    /**
     * Creates new form mInfo
     */
    private String mat;
    private String bast;
    private String nMat;
    private String nBast;
    private String col;
    private String nCol;
    private String nCol2;
    private String colora;
    private int idA;
    
    public add(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Añadir nuevo coche");
        this.setLocationRelativeTo(null);
        modelo.setEnabled(false);
    }
    public add(int iusu){
        idA=iusu;
                
        this.setTitle("Añadir nuevo coche");
        this.setLocationRelativeTo(null);       
        initComponents();
        this.setLocationRelativeTo(null);
        tablaAdmin();
        SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 500);
        SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 5);
        

        
        precio.setValue((int)0);
        precio.setModel(spinnerModel1);
        
        nPuertas.setValue((int)0);
        nPuertas.setModel(spinnerModel2);
        
        nPlazas.setValue((int)0);
        nPlazas.setModel(spinnerModel3);
        
        potencia.setValue((int)0);
        potencia.setModel(spinnerModel4);
        
        precio.getEditor().getComponent(0).addKeyListener(new add.NumericKeyListener());
        nPuertas.getEditor().getComponent(0).addKeyListener(new add.NumericKeyListener());
        nPlazas.getEditor().getComponent(0).addKeyListener(new add.NumericKeyListener());
        potencia.getEditor().getComponent(0).addKeyListener(new add.NumericKeyListener());
        
        matricula.setVisible(false);
        bastidor.setVisible(false);
        jLabel17.setVisible(false);
        jLabel18.setVisible(false);
        
        
        matricula.setVisible(true);
        bastidor.setVisible(true);
        jLabel17.setVisible(true);
        jLabel18.setVisible(true);
        
        DecimalFilter decimalFilter = new DecimalFilter("\\d(\\.\\d{0,1})?");
        AbstractDocument document = (AbstractDocument) cilindrada.getDocument();
        document.setDocumentFilter(decimalFilter);
           
        
        
        modelo.setEnabled(false);
        
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
           
    
            ResultSet resultado3 = null;
            String sql3="SELECT DISTINCT color from colores";
            Statement s3 = c.createStatement();
            resultado3=s3.executeQuery(sql3);
            color.removeAllItems();
            color.addItem("Elija un color");
            while(resultado3.next())
            {
                color.addItem(resultado3.getString(1));
            }     
            
            ResultSet resultado4 = null;
            String sql4="SELECT DISTINCT marca from marcas";
            Statement s4 = c.createStatement();
            resultado4=s4.executeQuery(sql4);
            marca.removeAllItems();
            marca.addItem("Elija una marca");
            while(resultado4.next())
            {
                marca.addItem(resultado4.getString(1));
            }
                              
            
            
            ResultSet resultado8 = null;
            String sql8="SELECT DISTINCT motor from motores ";
            Statement s8 = c.createStatement();
            resultado8=s8.executeQuery(sql8);
            motor.removeAllItems();
            motor.addItem("Elija un motor");
            while(resultado8.next())
            {
                motor.addItem(resultado8.getString(1));
            }
            
            
            ResultSet resultado10 = null;
            String sql10="SELECT DISTINCT cambio from coche";
            Statement s10 = c.createStatement();
            resultado10=s10.executeQuery(sql10);
            cambio.removeAllItems();
            cambio.addItem("Elija cambio");
            while(resultado10.next())
            {
                cambio.addItem(resultado10.getString(1));
            }
            
            
            
        }
        catch(Exception e){
            System.out.println("errol");
        }
    
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
        
            ResultSet resultado2 = null;
            String sql2="SELECT modelo " +
            "FROM modelos " +
            "WHERE marca = '"+marca.getSelectedItem().toString()+"'";
            System.out.print(marca.getSelectedItem().toString());
            Statement s2 = c.createStatement();
            resultado2=s2.executeQuery(sql2);
            modelo.removeAllItems();
            modelo.addItem("Elija un modelo");
            while(resultado2.next())
            {
                modelo.addItem(resultado2.getString(1));
            }
        
        
        }
        catch(Exception e){
            
        }
    }
   
    
    public class DecimalFilter extends DocumentFilter {
    private final String allowedPattern;

    public DecimalFilter(String allowedPattern) {
        this.allowedPattern = allowedPattern;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        String newText = currentText.substring(0, offset) + text + currentText.substring(offset);

        if (newText.matches(allowedPattern)) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

        if (newText.matches(allowedPattern)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
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

// Método para verificar la existencia de la matrícula en la base de datos
private boolean existeMatricula(Connection conexion, String nuevaMatricula) throws SQLException {
    String sql = "SELECT COUNT(*) FROM coche WHERE matricula = ?";
    try (PreparedStatement pst = conexion.prepareStatement(sql)) {
        pst.setString(1, nuevaMatricula);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Retorna true si existe al menos un registro con la matrícula
            }
        }
    }
    return false;
}

// Método para verificar la existencia del bastidor en la base de datos
private boolean existeBastidor(Connection conexion, String nuevoBastidor) throws SQLException {
    String sql = "SELECT COUNT(*) FROM coche WHERE n_bastidor = ?";
    try (PreparedStatement pst = conexion.prepareStatement(sql)) {
        pst.setString(1, nuevoBastidor);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Retorna true si existe al menos un registro con el bastidor
            }
        }
    }
    return false;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        f_fab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cilindrada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        precio = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        bastidor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        color = new javax.swing.JComboBox<>();
        nPlazas = new javax.swing.JSpinner();
        nPuertas = new javax.swing.JSpinner();
        potencia = new javax.swing.JSpinner();
        cambio = new javax.swing.JComboBox<>();
        marca = new javax.swing.JComboBox<>();
        modelo = new javax.swing.JComboBox<>();
        motor = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Añadir datos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de fabricación:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        f_fab.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(f_fab, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Motor:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("€");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 20));

        cilindrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(cilindrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 60, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Potencia:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Número de puertas:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cilindrada:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("L");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 10, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Número de plazas:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cambio:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Color:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, -1));

        precio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        precio.setFocusable(false);
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 90, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CV");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Matrícula:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        matricula.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 140, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nº bastidor:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, -1));

        bastidor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(bastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, 140, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apply.png"))); // NOI18N
        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 180, 40));

        color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorMouseClicked(evt);
            }
        });
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });
        getContentPane().add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 140, -1));
        getContentPane().add(nPlazas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 50, -1));
        getContentPane().add(nPuertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 50, -1));
        getContentPane().add(potencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 60, -1));

        getContentPane().add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 140, -1));

        marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaActionPerformed(evt);
            }
        });
        getContentPane().add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, -1));

        modelo.setEnabled(false);
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 150, -1));

        getContentPane().add(motor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 150, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 20, 20));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 20, 20));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1050, 270));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/logo2.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 220, 70));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/gris.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 590));

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
        agregar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_colorActionPerformed

    private void colorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_colorMouseClicked

    private void marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaActionPerformed
        // TODO add your handling code here:
        if(marca.getSelectedIndex()>0){
            modelo.setEnabled(true);
            jButton3.setEnabled(true);
            activarCombo(); 
        }
        else{
            
            modelo.setEnabled(false);
            jButton3.setEnabled(false);
        }
       
    }//GEN-LAST:event_marcaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
            if(jTable1.getSelectedColumn()==11){
            String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            
                mInfo m=new mInfo(t,true,idA);
                m.setVisible(true);
            }   
            
        if(jTable1.getSelectedColumn()==12){
            String t=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String c=jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
            System.out.println(c);
            Modificar mod=new Modificar(t,c,idA);
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        addMarcas am=new addMarcas(idA);
        am.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            String t=marca.getSelectedItem().toString();
            addModelos am=new addModelos(idA,t);
            am.jComboBox1.addItem(t);
            am.setVisible(true);
            am.jComboBox1.setEnabled(false);
            am.jComboBox1.setFont(new Font("Segoe UI", Font.BOLD, 14));
            
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        add a=new add(idA);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        filtrarPral f=new filtrarPral(true,idA);
        f.setVisible(true);
        f.jCheckBoxMenuItem1.setSelected(true);
        f.jMenu2.setVisible(true);
        f.tablaAdmin();
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        addMarcas am=new addMarcas(idA);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        usuarios u=new usuarios(idA);
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed
     
    
    public void agregar() {
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

        int p1 = (int) potencia.getValue();
        int p2 = (int) nPuertas.getValue();
        int p3 = (int) nPlazas.getValue();
        int p4 = (int) precio.getValue();
        if(marca.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(this, "Debe seleccionar una marca");
            }
            if(modelo.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un modelo");
            }
            if(f_fab.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Debe introducir una fecha");
            }
            if(motor.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un motor");
            }
            if(cilindrada.getText().isBlank()||matricula.getText().isBlank()||bastidor.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            }
            if(cambio.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de cambio");
            }
            if(color.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un color");
            }
        if (!matricula.getText().isBlank() && !bastidor.getText().isBlank() && marca.getSelectedIndex() > 0
                && modelo.getSelectedIndex() > 0 && color.getSelectedIndex() > 0 && motor.getSelectedIndex() > 0
                && cambio.getSelectedIndex() > 0 && !f_fab.getText().isBlank() && !cilindrada.getText().isBlank()
                && p1 >= 0 && p2 > 0 && p3 > 0 && p4 > 0) {
            String formatoEsperado = "\\d{4}-\\d{2}-\\d{2}";
            String texto = f_fab.getText();

            // Compila la expresión regular proporcionada en el patrón
            Pattern pattern = Pattern.compile(formatoEsperado);

            // Crea un objeto Matcher que comparará el texto con el patrón
            Matcher matcher = pattern.matcher(texto);

            // Verifica si el texto cumple con el formato esperado
            if (matcher.matches()) {
                System.out.println("El formato es válido.");
            } else {
                JOptionPane.showMessageDialog(null, "Introduzca un formato de fecha adecuado (YYYY-MM-DD)", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return; // No continuar con la inserción
            }

            if (existeMatricula(c, matricula.getText())) {
                JOptionPane.showMessageDialog(null, "La matrícula ya existe en la base de datos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // No continuar con la inserción
            }

            // Verifica si el nuevo bastidor ya existe en la base de datos
            if (existeBastidor(c, bastidor.getText())) {
                JOptionPane.showMessageDialog(null, "El bastidor ya existe en la base de datos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // No continuar con la inserción
            }
            System.out.println("Cogiendo color");
            ResultSet resultado9 = null;
            String sql9 = "SELECT DISTINCT id_color from colores WHERE color='" + color.getSelectedItem().toString()
                    + "'";
            Statement s9 = c.createStatement();
            resultado9 = s9.executeQuery(sql9);
            while (resultado9.next()) {
                colora = resultado9.getString(1);
            }
            System.out.println("id color: "+colora);

            int pot = (int) potencia.getValue();
            int puert = (int) nPuertas.getValue();
            int plaz = (int) nPlazas.getValue();
            int prec = (int) precio.getValue();
            
            System.out.println("empezando sql");
            String sql2 = "INSERT INTO coche VALUES('" + matricula.getText() + "', '" + bastidor.getText() 
                     + "', '" + modelo.getSelectedItem().toString() + "', '"
                    + f_fab.getText() + "', '" +motor.getSelectedItem().toString()+"', '"+ colora + "', '" + cilindrada.getText() + "', " + pot + ", " + puert
                    + ", " + plaz + ", '" + cambio.getSelectedItem().toString() + "', " + prec +", "+ idA+", '"+ marca.getSelectedItem().toString()+"', 'Disponible"+"')";

            System.out.print(sql2);

            Statement s2 = c.createStatement();            

            int resultado = s2.executeUpdate(sql2);
            System.out.println("SQL: " + sql2);
            
            
            if (resultado > 0) {
                System.out.println("Registro actualizado correctamente");
                JOptionPane.showMessageDialog(this, "Coche añadido exitosamente");
                tablaAdmin();
            } else {
                System.out.println("Error al actualizar el registro");               
            }
            

        } 
    } catch (Exception e) {
        e.printStackTrace();
    }
}

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
            } 
        }
    } catch (Exception e) {
        e.printStackTrace();
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
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                add dialog = new add(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bastidor;
    private javax.swing.JComboBox<String> cambio;
    private javax.swing.JTextField cilindrada;
    private javax.swing.JComboBox<String> color;
    private javax.swing.JTextField f_fab;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> marca;
    private javax.swing.JTextField matricula;
    private javax.swing.JComboBox<String> modelo;
    private javax.swing.JComboBox<String> motor;
    private javax.swing.JSpinner nPlazas;
    private javax.swing.JSpinner nPuertas;
    private javax.swing.JSpinner potencia;
    private javax.swing.JSpinner precio;
    // End of variables declaration//GEN-END:variables
}
