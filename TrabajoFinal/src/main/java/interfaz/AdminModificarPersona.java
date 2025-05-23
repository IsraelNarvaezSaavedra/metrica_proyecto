package interfaz;

import bdd.DAOCiudad;
import bdd.DAOPersona;
import entidades.Cliente;
import entidades.Persona;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminModificarPersona extends javax.swing.JFrame {

    protected AdminMain main;
    protected DAOPersona daoPersona = new DAOPersona();
    protected Persona persona;
    protected Cliente cliente;
    /**
     * Creates new form AdminModificarPersona
     */
    public AdminModificarPersona() {
        initComponents();
        listaPersonas.setLayout(new GridLayout(0, 5, 15, 15));
        cargarPersonas();
        cargarCiudadesEnComboBox();
    }

    public void cargarPersonas() {
        listaPersonas.removeAll();
        List<Cliente> sociedad = daoPersona.listaDePersonas();

        for (Cliente llenar : sociedad) {
            /*JPanel con su personalizacion donde se introduciran los siguientes 
           botones y etiquetas*/
            JPanel personas = new JPanel();
            personas.setBackground(Color.gray);
            personas.setLayout(new BoxLayout(personas, BoxLayout.Y_AXIS)); //Para que vayan saliendo de manera vertical
            personas.setPreferredSize(new Dimension(100, 20)); //Tamanio del panel

            //Etiqueta IDPersona y su personalizacion
            JLabel idPersona = new JLabel(String.valueOf(llenar.getId()));
            idPersona.setForeground(Color.WHITE);
            idPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            idPersona.setAlignmentY(Component.CENTER_ALIGNMENT);

            //Etiqueta NombreUsuario y su personalizacion
            JLabel nombreUsuario = new JLabel(llenar.getNombreUsuario());
            nombreUsuario.setForeground(Color.white);
            nombreUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
            nombreUsuario.setAlignmentY(Component.CENTER_ALIGNMENT);
            
            //Etiqueta nombrePersona y su personalizacion
            JLabel nombrePersona = new JLabel(llenar.getNombre());
            nombrePersona.setForeground(Color.WHITE);
            nombrePersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            nombrePersona.setAlignmentY(Component.CENTER_ALIGNMENT);

            //Etiqueta apellidosPersona y su personalizacion
            JLabel apellidosPersona = new JLabel(llenar.getApellidos());
            apellidosPersona.setForeground(Color.white);
            apellidosPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            apellidosPersona.setAlignmentY(Component.CENTER_ALIGNMENT);
            
            //Etiqueta ciudadPersona y su personalizacion
            JLabel ciudadPersona = new JLabel(llenar.getCiudad());
            ciudadPersona.setForeground(Color.WHITE);
            ciudadPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            ciudadPersona.setAlignmentY(Component.CENTER_ALIGNMENT);

            //Etiqueta localidadPersona y su personalizacion
            JLabel localidadPersona = new JLabel(llenar.getLocalidad());
            localidadPersona.setForeground(Color.white);
            localidadPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            localidadPersona.setAlignmentY(Component.CENTER_ALIGNMENT);
            
            //Etiqueta callePersona y su personalizacion
            JLabel callePersona = new JLabel(llenar.getCalle());
            callePersona.setForeground(Color.WHITE);
            callePersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            callePersona.setAlignmentY(Component.CENTER_ALIGNMENT);
            
            //Etiqueta ncasaPersona y su personalizacion
            JLabel ncasaPersona = new JLabel(llenar.getnCasa());
            ncasaPersona.setForeground(Color.WHITE);
            ncasaPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            ncasaPersona.setAlignmentY(Component.CENTER_ALIGNMENT);

            //Etiqueta emailPersona y su personalizacion
            JLabel emailPersona = new JLabel(llenar.getEmail());
            emailPersona.setForeground(Color.white);
            emailPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            emailPersona.setAlignmentY(Component.CENTER_ALIGNMENT);
            
            //Etiqueta tlfPersona y su personalizacion
            JLabel tlfPersona = new JLabel(llenar.getEmail());
            tlfPersona.setForeground(Color.white);
            tlfPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            tlfPersona.setAlignmentY(Component.CENTER_ALIGNMENT);
            
            //Etiqueta contraseñaPersona y su personalizacion
            JLabel contraseñaPersona = new JLabel(llenar.getContraseñaUsuario());
            contraseñaPersona.setForeground(Color.white);
            contraseñaPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
            contraseñaPersona.setAlignmentY(Component.CENTER_ALIGNMENT);

            //Añadir los productos al jpanel
            personas.add(idPersona);
            personas.add(nombreUsuario);
            personas.add(nombrePersona);
            personas.add(apellidosPersona);
            personas.add(ciudadPersona);
            personas.add(tlfPersona);
            personas.add(emailPersona);
            personas.add(localidadPersona);
            personas.add(callePersona);
            personas.add(ncasaPersona);
            personas.add(contraseñaPersona);
            listaPersonas.add(personas);
        }
        listaPersonas.revalidate();
        listaPersonas.repaint();
    }
    
    //Mete las ciudades en una lista para luego mostrarla en un combo box
    private void cargarCiudadesEnComboBox() {
        DAOCiudad dao = new DAOCiudad();
        List<String> listaCiudades = dao.obtenerCiudades();
        for (String ciudad : listaCiudades) {
            ciudadUs.addItem(ciudad);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        localidadUs = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        botonRegistarse1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nombreUs = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        apellidosUs = new javax.swing.JTextField();
        calleUs = new javax.swing.JTextField();
        contraseñaUs = new javax.swing.JPasswordField();
        casaUs = new javax.swing.JTextField();
        ciudadUs = new javax.swing.JComboBox<>();
        us = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tlfUs = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        emailUs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        IDus = new javax.swing.JTextField();
        volver1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPersonas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Modificar persona");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Contraseña:");

        localidadUs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("teléfono:");

        botonRegistarse1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonRegistarse1.setText("Modificar");
        botonRegistarse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistarse1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Nº Casa:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Nombre: ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Localidad:");

        nombreUs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Ciudad:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Apellidos: ");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Calle:");

        apellidosUs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        calleUs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        casaUs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        us.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("E-mail:");

        tlfUs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tlfUs.setMaximumSize(new java.awt.Dimension(9, 2147483647));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Usuario:");

        emailUs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("ID:");

        volver1.setBackground(new java.awt.Color(153, 204, 255));
        volver1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        volver1.setText("<-- Volver");
        volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listaPersonasLayout = new javax.swing.GroupLayout(listaPersonas);
        listaPersonas.setLayout(listaPersonasLayout);
        listaPersonasLayout.setHorizontalGroup(
            listaPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        listaPersonasLayout.setVerticalGroup(
            listaPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listaPersonas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(botonRegistarse1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(volver1)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel16))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(contraseñaUs, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(localidadUs)
                                    .addComponent(emailUs)))
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(82, 82, 82)
                                .addComponent(us, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(apellidosUs)
                                    .addComponent(ciudadUs, 0, 200, Short.MAX_VALUE)
                                    .addComponent(tlfUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(casaUs)
                                    .addComponent(nombreUs)
                                    .addComponent(calleUs)
                                    .addComponent(IDus)))
                            .addComponent(jLabel19)
                            .addComponent(jLabel17))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(contraseñaUs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(emailUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(localidadUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tlfUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ciudadUs, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(calleUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(casaUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidosUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IDus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(botonRegistarse1)
                .addGap(29, 29, 29))
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Comprueba que los campos introducidos son validos y luego cambia los valores antiguos por los
    valores introducidos ahora*/
    private void botonRegistarse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistarse1ActionPerformed
        if (IDus.getText().isEmpty()) {
            Persona.UsuarioVacio("No se puede dejar el ID vacio", "Error");
        } else if (!persona.esTelefonoValido(tlfUs.getText())) {
            Persona.UsuarioVacio("Debes introducir un telefono valido (9 digitos numericos)", "Error");
            tlfUs.setText("");
        } else if (!persona.esEmailValido(emailUs.getText())) {
            Persona.UsuarioVacio("el correo debe ser valido", "Error");
            emailUs.setText("");
        } else {
            cliente = new Cliente(Integer.parseInt(IDus.getText()), nombreUs.getText(), apellidosUs.getText(), 
            tlfUs.getText(), emailUs.getText(), localidadUs.getText(), (String)ciudadUs.getSelectedItem(), calleUs.getText(), 
            casaUs.getText(), us.getText(), contraseñaUs.getText());
            daoPersona.modificarPersona(cliente);
            javax.swing.JOptionPane.showMessageDialog(this, "Modificacion Realizada");
        }
    }//GEN-LAST:event_botonRegistarse1ActionPerformed

    // Vuelve a Admin Main
    private void volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver1ActionPerformed
        AdminMain ventanaMain = new AdminMain();

        this.setVisible(false);
        ventanaMain.setVisible(true);
    }//GEN-LAST:event_volver1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminModificarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminModificarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminModificarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminModificarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminModificarPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDus;
    private javax.swing.JTextField apellidosUs;
    private javax.swing.JButton botonRegistarse1;
    private javax.swing.JTextField calleUs;
    private javax.swing.JTextField casaUs;
    private javax.swing.JComboBox<String> ciudadUs;
    private javax.swing.JPasswordField contraseñaUs;
    private javax.swing.JTextField emailUs;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listaPersonas;
    private javax.swing.JTextField localidadUs;
    private javax.swing.JTextField nombreUs;
    private javax.swing.JTextField tlfUs;
    private javax.swing.JTextField us;
    private javax.swing.JButton volver1;
    // End of variables declaration//GEN-END:variables
}
