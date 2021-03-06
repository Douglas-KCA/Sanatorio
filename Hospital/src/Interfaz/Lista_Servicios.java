package Interfaz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Conexion.Conexion;
import Interfaz.*;
import hospital.Hospital;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Douglas
 */
public class Lista_Servicios extends javax.swing.JFrame {
    Conexion con = new Conexion();
    String servicio="";
    String[] datos = {"Codigo","Nombre Servicio"};
    DefaultTableModel modelo = new DefaultTableModel(null, datos);
    /**
     * Creates new form Citas
     */
    public Lista_Servicios() {
        initComponents();
        setLocationRelativeTo(null);
        
        llenado();
        
        //-------FONDO DE PANTALLA PRINCIPAL---------------
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo1.jpg")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lbl_Agregar = new javax.swing.JLabel();
        lbl_Agregar1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Servicios");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        lbl_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Plus-32.png"))); // NOI18N
        lbl_Agregar.setText("Nuevo Servicio");
        lbl_Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_AgregarMouseClicked(evt);
            }
        });

        lbl_Agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Plus-32.png"))); // NOI18N
        lbl_Agregar1.setText("Agregar");
        lbl_Agregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Agregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_Agregar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_Agregar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap(638, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(10, 10, 10)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(601, Short.MAX_VALUE)
                    .addComponent(lbl_Agregar1)
                    .addGap(20, 20, 20)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(lbl_Agregar)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(350, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(365, Short.MAX_VALUE)
                    .addComponent(lbl_Agregar1)
                    .addGap(12, 12, 12)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
        Informe_Final nuevo = new Informe_Final();
        nuevo.setVisible(true);
        this.hide();
        //exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lbl_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_AgregarMouseClicked
       // TODO add your handling code here:
        String alf = (JOptionPane.showInputDialog("Nuevo Servicio"));
        //System.out.println(alf);
        //String padecimiento= alf.trim();
        if(alf == null){
            //System.out.println("hola");
        }else{
            String tipo= alf.trim();
            
            String sql = "INSERT INTO SERVICIO VALUES (SECUENCIA_SERVICIO.nextval, '"+tipo+"') ";
                
            
            Connection connection = con.iniciarConexion();
            try {
                 Statement sta = connection.createStatement();
                 sta.executeUpdate(sql);
                 sta.close();
            } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null,ex);
            }
            llenado();
        }
        
    }//GEN-LAST:event_lbl_AgregarMouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        
        
         int row=tabla.getSelectedRow();
        servicio = String.valueOf(tabla.getValueAt(row, 0));
    }//GEN-LAST:event_tablaMouseClicked

    private void lbl_Agregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Agregar1MouseClicked
        // TODO add your handling code here:
        Hospital nuevo = new Hospital();
        String dia = nuevo.getDia_informe();
        String mes = nuevo.getMes_informe();
        String ano = nuevo.getAno_informe();
        String codigo_informe = nuevo.getCodigo_informe_paciente();
        
        Connection connection = con.iniciarConexion();
         String sql = "INSERT INTO SERVICIO_PACIENTE VALUES (SECUENCIA_SERVICIO_PACIENTE.nextval, '"+dia+"', '"+mes+"', '"+ano+"','"+servicio+"','"+codigo_informe+"') ";
        
                
            
           // Connection connection = con.iniciarConexion();
            try {
                 Statement sta = connection.createStatement();
                 sta.executeUpdate(sql);
                 sta.close();
            } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null,ex);
            }
            JOptionPane.showMessageDialog(null,"Servicio Agregado","Realizado",JOptionPane.INFORMATION_MESSAGE);            
            servicio="";
    }//GEN-LAST:event_lbl_Agregar1MouseClicked

    void llenado(){
        Connection connection = con.iniciarConexion();
        DefaultTableModel modelo = new DefaultTableModel(null, datos);
                
        
        String datos[] = new String[2];
        String codigo="";
        String nombre="";
        
        String sql3 = "SELECT CODIGO_SERVICIO, NOMBRE FROM SERVICIO";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                 datos[0] = rs2.getString("CODIGO_SERVICIO").trim();
                 datos[1] = rs2.getString("NOMBRE").trim();
                 
                 modelo.addRow(datos);
                 
            }
            
            tabla.setModel(modelo);
            int[] anchos = {50, 150, 300};
           
            for(int i = 0; i < tabla.getColumnCount(); i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
                                    
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
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
            java.util.logging.Logger.getLogger(Lista_Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Servicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Agregar;
    private javax.swing.JLabel lbl_Agregar1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
