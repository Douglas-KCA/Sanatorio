/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Douglas
 */
public class Empleados extends javax.swing.JFrame {
    
    Conexion con = new Conexion();
    /**
     * Creates new form Pacientes
     */
    public Empleados() {
        initComponents();
        grupo_sexo.add(op_masculino);
        grupo_sexo.add(op_femenino);
        //btn_2.setVisible(false);
        btn_3.setVisible(false);
        
        setLocationRelativeTo(null);
        
        //-------FONDO DE PANTALLA PRINCIPAL---------------
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo1.jpg")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }
    /*
    void InsertarPersona(){
        String Sexo = "";
        if(op_masculino.isSelected()){
             Sexo = "Masculino";
        }else{
            Sexo = "Femenino";
        }
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellidos.getText().trim();
        String edad = txtEdad.getText().trim();
        String dpi = txtDpi.getText().trim();
        String direccion = txtDireccion.getText().trim();
        //String telefono = txtTelefono.getText().trim();
       // String email = txtEmail.getText().trim();
        
        
        String sql6 = "INSERT INTO PERSONA VALUES (SECUENCIA_PERSONA.nextval, '"+Sexo+"','"+nombre+"','"+edad+"','"+dpi+"','"+direccion+"','"+telefono+"','"+email+"','"+apellido+"') ";
                
        
        Connection connection = con.iniciarConexion();
        try {
             Statement sta7 = connection.createStatement();
             sta7.executeUpdate(sql6);
             sta7.close();
        } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null,ex);
        }
        
    }
    */
    String CodigoPersona(String dpi){
        String CodigoPersona="";
        
         Connection connection = con.iniciarConexion();
        
         String sql3 = "SELECT CODIGO_PERSONA FROM PERSONA WHERE DPI = '"+dpi+"'";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                CodigoPersona = rs2.getString("CODIGO_PERSONA");
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
        
        return CodigoPersona;
    }
    /*
    void InsertarPaciente(String CodigoPersona){
      
        String alergias = txtAlergias.getText().trim();
        String altura = txtAltura.getText().trim();
        //String peso = txtPeso.getText().trim();
        //String ocupacion = txtOcupacion.getText().trim();
        //String medicamento = txtMedicamento.getText().trim();
        if(alergias.isEmpty()){
            alergias= "-";
        }
        if(medicamento.isEmpty()){
            medicamento="-";
        }
        
        
        
        String sql = "INSERT INTO PACIENTE VALUES (secuencia_paciente.nextval,'"+alergias+"','"+altura+"','"+peso+"','"+ocupacion+"','"+medicamento+"','"+CodigoPersona+"')";
                
        
        Connection connection = con.iniciarConexion();
        try {
             Statement sta = connection.createStatement();
             sta.executeUpdate(sql);
             sta.close();
        } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null,ex);
        }
        
    }
    */
    void LlenarCampos(String codigo){
        
        Connection connection = con.iniciarConexion();
        
        String alergias = "";
        String altura = "";
        String peso = "";
        String ocupacion = "";
        String medicamento = "";
        
        String sql3 = "SELECT ALERGIAS, ALTURA, PESO, OCUPACION, MEDICAMENTO FROM PACIENTE WHERE CODIGO_PACIENTE = '"+codigo+"'";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                 
                 alergias = rs2.getString("ALERGIAS").trim();
                 altura = (rs2.getString("ALTURA")).trim();
                 peso = (rs2.getString("PESO")).trim();
                 ocupacion = (rs2.getString("OCUPACION")).trim();
                 medicamento = rs2.getString("MEDICAMENTO").trim();
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
         
        
         
        txtAlergias.setText(alergias);
        txtAltura.setText(altura);
        //txtPeso.setText(peso);
        //txtOcupacion.setText(ocupacion);
        //txtMedicamento.setText(medicamento);
        
    }
    
    void Limpiar(){
        txtNombre.setText("");
        txtEdad.setText("");
        txtDpi.setText("");
        txtDireccion.setText("");
        //txtTelefono.setText("");
        txtAltura.setText("");
        //txtPeso.setText("");
        //txtOcupacion.setText("");
        txtApellidos.setText("");
       // txtMedicamento.setText("");
        //txtEmail.setText("");
        txtAlergias.setText("");
        
        txtNombre.setEditable(true);
        txtEdad.setEditable(true);
        txtDpi.setEditable(true);
        txtDireccion.setEditable(true);
        //txtTelefono.setEditable(true);
        txtAltura.setEditable(true);
        //txtPeso.setEditable(true);
        //txtOcupacion.setEditable(true);
        txtApellidos.setEditable(true);
        //txtMedicamento.setEditable(true);
        //txtEmail.setEditable(true);
        txtAlergias.setEditable(true);
        op_masculino.setEnabled(true);
        op_femenino.setEnabled(true);
    
    }
    
    void Bloquear(){
        txtNombre.setEditable(false);
        txtEdad.setEditable(false);
        txtDpi.setEditable(false);
        txtDireccion.setEditable(false);
        //txtTelefono.setEditable(false);
        txtAltura.setEditable(false);
        //txtPeso.setEditable(false);
        //txtOcupacion.setEditable(false);
        txtApellidos.setEditable(false);
        //txtMedicamento.setEditable(false);
        //txtEmail.setEditable(false);
        txtAlergias.setEditable(false);
        op_masculino.setEnabled(false);
        op_femenino.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_sexo = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtAlergias = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JLabel();
        btn_3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDpi = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        op_masculino = new javax.swing.JRadioButton();
        op_femenino = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Empleado");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 18, -1, -1));

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        lbl_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        jPanel2.setOpaque(false);

        txtAlergias.setEditable(false);

        txtAltura.setEditable(false);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btn_3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_3.setForeground(new java.awt.Color(255, 255, 255));
        btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit-48.png"))); // NOI18N
        btn_3.setText("Editar");
        btn_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Profesion:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Usuario:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Contraseña:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Plus-32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel16))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(43, 43, 43)
                                .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_3)
                    .addComponent(btnGuardar))
                .addGap(66, 66, 66))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 88, 340, 270));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("No. DPI:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, -1, -1));

        txtDpi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDpiKeyTyped(evt);
            }
        });
        jPanel1.add(txtDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 21, 152, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Primer Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 54, 194, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Sexo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 206, -1, -1));

        op_masculino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        op_masculino.setText("Masculino");
        jPanel1.add(op_masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        op_femenino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        op_femenino.setText("Femenino");
        jPanel1.add(op_femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 238, -1, -1));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 238, 194, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Segundo Nombre:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, -1, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 92, 194, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Primer Apellido:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 130, 194, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Segundo Apellido:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 168, 194, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Direccion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 269, -1, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 269, 194, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Telefono:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 303, -1, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 300, 194, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Contraseña:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 334, -1, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 331, 194, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 88, -1, 360));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        /*
        if(btnGuardar.getText().equals("Guardar")){
            String dpi = txtDpi.getText().trim();

            if(txtNombre.getText().isEmpty() || txtEdad.getText().isEmpty() || txtDpi.getText().isEmpty() ||
               txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty()  || txtAltura.getText().isEmpty() || txtPeso.getText().isEmpty() ||
               txtOcupacion.getText().isEmpty()  || txtApellidos.getText().isEmpty()){

                JOptionPane.showMessageDialog(null,"Por Favor llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

            }else{
                InsertarPersona();
                InsertarPaciente(CodigoPersona(dpi));
                JOptionPane.showMessageDialog(null,"Paciente Registrado","Realizado",JOptionPane.INFORMATION_MESSAGE);
                 //MenuPrincipal adm = new MenuPrincipal(); 
                 //adm.setVisible(true);
                 this.hide();
            }  
        }else{
            
        }   */
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtDpiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDpiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpiKeyTyped

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        
        boolean existe = false;
        String codigo_persona= "";
        String sexo="";
        String nombre="";
        String edad="";
        String dpi=txtDpi.getText().trim();
        String telefono="";
        String email="";
        String apellido="";
        String direccion = "";
        
        
        Connection connection = con.iniciarConexion();
        
         String sql3 = "SELECT CODIGO_PERSONA, SEXO, NOMBRE, EDAD, DIRECCION, TELEFONO, EMAIL, APELLIDO FROM PERSONA WHERE DPI = '"+dpi+"'";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                 existe = true;
                 codigo_persona = rs2.getString("CODIGO_PERSONA");
                 sexo = (rs2.getString("SEXO")).trim();
                 nombre = (rs2.getString("NOMBRE")).trim();
                 edad = (rs2.getString("EDAD")).trim();
                 telefono = (rs2.getString("TELEFONO")).trim();
                 email = (rs2.getString("EMAIL"));
                 direccion = (rs2.getString("DIRECCION")).trim();
                 apellido = (rs2.getString("APELLIDO")).trim();
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
         
        if(existe){
            //btnGuardar.setEnabled(false);
            btnGuardar.setVisible(false);
            //btn_2.setVisible(true);
            btn_3.setVisible(true);
            
            txtNombre.setText(nombre);
            txtApellidos.setText(apellido);
            if(sexo.equals("Masculino")){
                op_masculino.setSelected(true);
            }else{
                op_femenino.setSelected(true);
            }
            txtEdad.setText(edad);
            txtDireccion.setText(direccion);
            //txtTelefono.setText(telefono);
            //txtEmail.setText(email);
            
            LlenarCampos(codigo_persona);
            Bloquear();
          
            
        }else{
            JOptionPane.showMessageDialog(null,"Paciente No Encontrado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btn_3;
    private javax.swing.ButtonGroup grupo_sexo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JRadioButton op_femenino;
    private javax.swing.JRadioButton op_masculino;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDpi;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
