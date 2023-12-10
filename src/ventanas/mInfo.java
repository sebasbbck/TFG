/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ventanas;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class mInfo extends javax.swing.JDialog {

    /**
     * Creates new form mInfo
     */
    private String mat;
    private boolean admin;
    private JLabel imagenPanel;
    private int idComp;
    
    public mInfo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Más Información");
        this.setLocationRelativeTo(null);
    }
    public mInfo(String r, boolean a, int id){
        this.setTitle("Más Información");
        this.setLocationRelativeTo(null);
        
        this.mat=r; 
        this.admin=a;
        this.idComp=id;
        initComponents();
        this.setLocationRelativeTo(null);
        matricula.setVisible(false);
        bastidor.setVisible(false);
        jLabel17.setVisible(false);
        jLabel18.setVisible(false);
        imagenPanel = new JLabel();
        jPanel1.add(imagenPanel); 
        
       
           
        if(admin==true){
            matricula.setVisible(true);
            bastidor.setVisible(true);
            jLabel17.setVisible(true);
            jLabel18.setVisible(true);
        }
        
        
        
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
           
                Object[] datos=new Object[13];
                
        
                Statement leer= c.createStatement();
                ResultSet resul=leer.executeQuery("SELECT C.matricula, C.n_bastidor, C.marca, C.modelo, C.fecha_fab, C.motor, C.cilindrada, C.potencia, C.n_puertas, C.n_plazas, C.cambio, C.precio, CO.color "
                        + " FROM coche C, colores CO WHERE C.id_color = CO.id_color AND C.matricula LIKE '"+mat+"'");
               
            
                while(resul.next())
                {
                    datos[0]=resul.getString(1);//mat
                    matricula.setText(datos[0].toString());
                    datos[1]=resul.getString(2);//n_bastidor
                    bastidor.setText(datos[1].toString());
                    datos[2]=resul.getString(3);//marca
                    marca.setText(datos[2].toString());
                    datos[3]=resul.getString(4);//modelo
                    modelo.setText(datos[3].toString());
                    datos[4]=resul.getString(5);//fecha_fab
                    f_fab.setText(datos[4].toString());
                    datos[5]=resul.getString(6);//motor
                    motor.setText(datos[5].toString());
                    datos[6]=resul.getString(7);//cilindrada      
                    cilindrada.setText(datos[6].toString());
                    datos[7]=resul.getInt(8);//potencia
                    potencia.setText(datos[7].toString());
                    datos[8]=resul.getInt(9);//n_puertas
                    nPuertas.setText(datos[8].toString());
                    datos[9]=resul.getInt(10);//n_plazas
                    nPlazas.setText(datos[9].toString());
                    datos[10]=resul.getString(11);//cambio
                    cambio.setText(datos[10].toString());
                    datos[11]=resul.getInt(12);//precio
                    precio.setValue((int) datos[11]);
                    datos[12]=resul.getString(13);//cambio
                    color.setText(datos[12].toString());
                }
                
                Statement leer2= c.createStatement();
                ResultSet resul2=leer2.executeQuery("SELECT url FROM modelos WHERE modelo='"+datos[3].toString()+"'");
                System.out.println("sentencia:"+modelo.getText());
                                
                if (resul2.next()) {
                String url = resul2.getString(1);
                System.out.println("url:" + url);
                if (url != null) {
                    ImageIcon imageIcon = new ImageIcon(url);
                    Image image = imageIcon.getImage();
                    int width = imageIcon.getIconWidth();
                    int height = imageIcon.getIconHeight();

                    System.out.println("Ancho de la imagen: " + width);
                    System.out.println("Altura de la imagen: " + height);

                    Image newImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
    
                    ImageIcon newImageIcon = new ImageIcon(newImage);

                    imagenPanel.setIcon(newImageIcon);
                }
                }     
        }
        catch(Exception e){
            System.out.println("error");
            e.printStackTrace();
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        modelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        f_fab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        motor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cilindrada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        potencia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nPuertas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nPlazas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cambio = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        color = new javax.swing.JTextField();
        precio = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        bastidor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Información ampliada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        marca.setEditable(false);
        marca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        modelo.setEditable(false);
        modelo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de fabricación:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        f_fab.setEditable(false);
        f_fab.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(f_fab, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Motor:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        motor.setEditable(false);
        motor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(motor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 130, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("€");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, 20));

        cilindrada.setEditable(false);
        cilindrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(cilindrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 60, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Potencia:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        potencia.setEditable(false);
        potencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(potencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 60, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Número de puertas:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        nPuertas.setEditable(false);
        nPuertas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(nPuertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 40, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cilindrada:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("L");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 60, 10, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Número de plazas:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        nPlazas.setEditable(false);
        nPlazas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(nPlazas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 40, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cambio:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        cambio.setEditable(false);
        cambio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 140, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Color:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        color.setEditable(false);
        color.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 140, -1));

        precio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        precio.setEnabled(false);
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 90, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CV");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, 20));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Matrícula:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        matricula.setEditable(false);
        matricula.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 140, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nº bastidor:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jButton2.setText("Comprar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        bastidor.setEditable(false);
        bastidor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(bastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 140, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Previsualización");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 390, 300));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/blue2.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 480, 380));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/fondos/blue2.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String bast=bastidor.getText();
        comprar(bast);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void comprar(String bast){
        String usu="SA";
        String bd="jdbc:hsqldb:hsql://localhost/";
        String contra="";
        try (Connection connection = DriverManager.getConnection(bd, usu, contra)) {

            // Actualizar estado del coche a 'No Disponible'
            String updateEstadoQuery = "UPDATE coche SET estado = 'No Disponible' WHERE n_bastidor = ?";
            try (PreparedStatement updateEstadoStatement = connection.prepareStatement(updateEstadoQuery)) {
                updateEstadoStatement.setString(1, bast);
                int rowsUpdated = updateEstadoStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Estado del coche actualizado correctamente");
                } else {
                    System.out.println("No se pudo actualizar el estado del coche");
                    return; // No continuar con la inserción en coches_comprados
                }
            }

            // Insertar información de la compra en la tabla coches_comprados
            String insertCompraQuery = "INSERT INTO coches_comprados (bastidor, id_usuario, fecha_compra) VALUES (?, ?, ?)";
            try (PreparedStatement insertCompraStatement = connection.prepareStatement(insertCompraQuery)) {
                insertCompraStatement.setString(1, bast);
                insertCompraStatement.setInt(2, idComp);

                // Obtener la fecha actual en formato 'yyyy-MM-dd'
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaCompra = dateFormat.format(new Date());
                insertCompraStatement.setString(3, fechaCompra);

                int rowsInserted = insertCompraStatement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Compra realizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al realizar la compra", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(mInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mInfo dialog = new mInfo(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField cambio;
    private javax.swing.JTextField cilindrada;
    private javax.swing.JTextField color;
    private javax.swing.JTextField f_fab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField modelo;
    private javax.swing.JTextField motor;
    private javax.swing.JTextField nPlazas;
    private javax.swing.JTextField nPuertas;
    private javax.swing.JTextField potencia;
    private javax.swing.JSpinner precio;
    // End of variables declaration//GEN-END:variables
}
