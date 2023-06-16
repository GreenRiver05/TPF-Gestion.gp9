package Vistas;

import AccesoADatos.ProyectoData;
import Entidades.Proyecto;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VistaCrearProyecto extends javax.swing.JInternalFrame {

    public VistaCrearProyecto() {
        initComponents();
        Jid.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtNombre = new javax.swing.JTextField();
        jtDescripcion = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jlNuevoLegajo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlNacimiento = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();
        jcbInactivo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbRegistrar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        CALENDARIO = new com.toedter.calendar.JDateChooser();
        Jid = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(800, 700));
        setRequestFocusEnabled(false);

        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        jtNombre.setBackground(new java.awt.Color(51, 51, 51));
        jtNombre.setFont(new java.awt.Font("Arial", 1, 29)); // NOI18N
        jtNombre.setForeground(new java.awt.Color(0, 0, 0));
        jtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtNombre.setText("NOMBRE DE PROYECTO");

        jtDescripcion.setBackground(new java.awt.Color(51, 51, 51));
        jtDescripcion.setFont(new java.awt.Font("Arial", 1, 29)); // NOI18N
        jtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jtDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtDescripcion.setText("DESCRIPCION");

        jbBuscar.setBackground(new java.awt.Color(51, 51, 51));
        jbBuscar.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jlNuevoLegajo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlNuevoLegajo.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREACION DE PROYECTO");

        jlNacimiento.setFont(new java.awt.Font("Dialog", 1, 29)); // NOI18N
        jlNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        jlNacimiento.setText("FECHA DE CREACION");

        jcbActivo.setForeground(new java.awt.Color(255, 255, 255));
        jcbActivo.setText("En proceso");
        jcbActivo.setEnabled(false);

        jcbInactivo.setForeground(new java.awt.Color(255, 255, 255));
        jcbInactivo.setText("Finalizado");
        jcbInactivo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ESTADO");

        jbNuevo.setBackground(new java.awt.Color(51, 51, 51));
        jbNuevo.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jbNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jbNuevo.setText("NUEVO");
        jbNuevo.setPreferredSize(new java.awt.Dimension(100, 40));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbRegistrar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegistrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrar.setText("REGISTRAR");
        jbRegistrar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbModificar.setBackground(new java.awt.Color(51, 51, 51));
        jbModificar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbModificar.setText("modificar");
        jbModificar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        CALENDARIO.setName("CALENDARIO"); // NOI18N

        Jid.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jcbActivo)
                                .addGap(18, 18, 18)
                                .addComponent(jcbInactivo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlNacimiento)
                                        .addGap(29, 29, 29)
                                        .addComponent(CALENDARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jtNombre)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlNuevoLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(56, 56, 56)
                                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jlNuevoLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(CALENDARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbActivo)
                    .addComponent(jcbInactivo)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
       
       jtNombre.setText("NOMBRE DE PROYECTO");
       jtDescripcion.setText("DESCRIPCION");
        CALENDARIO.setDateFormatString("");
//        jcbActivo.setSelected(false);
//        jcbInactivo.setSelected(false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        try {
            ProyectoData data = new ProyectoData();
            Proyecto proyecto = new Proyecto();
            String nombre= jtNombre.getText();
            proyecto = data.buscarPorNombre(nombre);
            jtNombre.setText(proyecto.getNombre());
            jtDescripcion.setText(proyecto.getDescripcion());
            CALENDARIO.setDate(java.sql.Date.valueOf(proyecto.getFechaInicial()));
            Jid.setText(proyecto.getIdProyecto()+"");
        
            if (proyecto.isEstado()) {
                jcbActivo.setSelected(true);
                jcbInactivo.setSelected(false);
            }else {
                jcbActivo.setSelected(false);
                jcbInactivo.setSelected(true);
            }
        
        } catch (Exception e) {
        }

           

       


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

        try {
           int id=Integer.parseInt(Jid.getText());
            String nombre = jtNombre.getText();
            String descripcion = jtDescripcion.getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = formatoFecha.format(CALENDARIO.getDate());
            LocalDate fechainicial = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            boolean estado = true;
//            if (jcbActivo.isSelected() == true) {
//                estado = true;
//            } else if (jcbInactivo.isSelected() == false) {
//                estado = false;
//            }

            Proyecto proyecto = new Proyecto(id,nombre,descripcion,fechainicial,estado);
            ProyectoData data = new ProyectoData();
            data.modificarProyecto(proyecto);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un nombre al proyecto");
        }


    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed

        try {
           
            String nombre = jtNombre.getText();
            String descripcion = jtDescripcion.getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = formatoFecha.format(CALENDARIO.getDate());
            LocalDate fechainicial = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            boolean estado = true;
//            if (jcbActivo.isSelected() == true) {
//                estado = true;
//            } else if (jcbInactivo.isSelected() == false) {
//                estado = false;
//            }
           Proyecto proyecto = new Proyecto(nombre,descripcion,fechainicial,estado);
           ProyectoData data = new ProyectoData();
           data.crearProyectos(proyecto);
           
            

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un nombre al proyecto");
        }

    }//GEN-LAST:event_jbRegistrarActionPerformed
 public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //UIManager.setLookAndFeel(new AcrylLookAndFeel());  // plantillas 
                    //UIManager.setLookAndFeel(new GraphiteLookAndFeel());  // plantillas 
                    //UIManager.setLookAndFeel(new McWinLookAndFeel());  // plantillas 
                    //UIManager.setLookAndFeel(new NoireLookAndFeel());  // plantillas 
                    UIManager.setLookAndFeel(new TextureLookAndFeel());  // plantillas 
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(GESTION.class.getName()).log(Level.SEVERE, null, ex);
                }
                new GESTION().setVisible(true);
               
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CALENDARIO;
    private javax.swing.JTextField Jid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JCheckBox jcbInactivo;
    private javax.swing.JLabel jlNacimiento;
    private javax.swing.JLabel jlNuevoLegajo;
    private javax.swing.JTextField jtDescripcion;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}



