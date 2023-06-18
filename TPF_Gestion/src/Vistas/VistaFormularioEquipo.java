package Vistas;

import AccesoADatos.EquipoData;
import AccesoADatos.ProyectoData;
import Entidades.Equipo;
import Entidades.Proyecto;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class VistaFormularioEquipo extends javax.swing.JInternalFrame {
    private void LlenarComboBox(){
        ProyectoData pd=new ProyectoData();
        
        for (Proyecto proyecto : pd.listarProyectos(true)) {
           jCProyecto.addItem(proyecto);
        }
    }
    public VistaFormularioEquipo() {
        
        initComponents();
        LlenarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtProyecto = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jlNuevoLegajo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        CALENDARIO = new com.toedter.calendar.JDateChooser();
        jlCreacion = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();
        jcbInactivo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbRegistrar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEstado = new javax.swing.JButton();
        jCProyecto = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(800, 700));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        jtProyecto.setBackground(new java.awt.Color(51, 51, 51));
        jtProyecto.setFont(new java.awt.Font("Century Gothic", 1, 29)); // NOI18N
        jtProyecto.setForeground(new java.awt.Color(255, 255, 255));
        jtProyecto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtProyecto.setText("PROYECTO:");
        jtProyecto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtProyectoFocusGained(evt);
            }
        });

        jbBuscar.setBackground(new java.awt.Color(51, 51, 51));
        jbBuscar.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
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
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO DE EQUIPO");

        jtNombre.setBackground(new java.awt.Color(51, 51, 51));
        jtNombre.setFont(new java.awt.Font("Century Gothic", 1, 29)); // NOI18N
        jtNombre.setForeground(new java.awt.Color(255, 255, 255));
        jtNombre.setText("NOMBRE:");
        jtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtNombreFocusGained(evt);
            }
        });

        CALENDARIO.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        CALENDARIO.setForeground(new java.awt.Color(255, 255, 255));
        CALENDARIO.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jlCreacion.setFont(new java.awt.Font("Century Gothic", 1, 29)); // NOI18N
        jlCreacion.setForeground(new java.awt.Color(255, 255, 255));
        jlCreacion.setText("FECHA DE CREACION:");

        jcbActivo.setForeground(new java.awt.Color(255, 255, 255));
        jcbActivo.setText("ACTIVO");

        jcbInactivo.setForeground(new java.awt.Color(255, 255, 255));
        jcbInactivo.setText("INACTIVO");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ESTADO");

        jbNuevo.setBackground(new java.awt.Color(51, 51, 51));
        jbNuevo.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jbNuevo.setText("NUEVO");
        jbNuevo.setPreferredSize(new java.awt.Dimension(100, 40));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbRegistrar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegistrar.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrar.setText("REGISTRAR");
        jbRegistrar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbModificar.setBackground(new java.awt.Color(51, 51, 51));
        jbModificar.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbModificar.setText("MODIFICAR");
        jbModificar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEstado.setBackground(new java.awt.Color(51, 51, 51));
        jbEstado.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbEstado.setForeground(new java.awt.Color(255, 255, 255));
        jbEstado.setText("ESTADO");
        jbEstado.setPreferredSize(new java.awt.Dimension(100, 32));
        jbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadoActionPerformed(evt);
            }
        });

        jCProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCProyectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jcbActivo)))
                        .addGap(18, 18, 18)
                        .addComponent(jcbInactivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jlNuevoLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlCreacion)
                        .addGap(77, 77, 77)
                        .addComponent(CALENDARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jlNuevoLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCProyecto)
                        .addGap(2, 2, 2)))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CALENDARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbActivo)
                    .addComponent(jcbInactivo)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
       
        jtProyecto.setText("PROYECTO");
        jtNombre.setText("NOMBRE");
        CALENDARIO.setDateFormatString("");
        jcbActivo.setSelected(false);
        jcbInactivo.setSelected(false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

       
            jcbActivo.setSelected(false);
            jcbInactivo.setSelected(false);
            String nom = jtNombre.getText();
            EquipoData data = new EquipoData();
            Equipo equipo = new     Equipo();
            equipo = data.buscarEquipo(nom);
            jtNombre.setText(equipo.getNombre());
            jtProyecto.setText(equipo.getProyecto().getNombre());
       
            CALENDARIO.setDate(java.sql.Date.valueOf(equipo.getFechaCreacion()));
            if (equipo.isEstado() == true) {
                jcbActivo.setSelected(true);
                jbEstado.setText("Dar de Baja");
            } else {
                jcbInactivo.setSelected(true);
                jbEstado.setText("Dar de Alta");
            }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

      
            String nombre = jtNombre.getText();
            String proyecto = jtProyecto.getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = formatoFecha.format(CALENDARIO.getDate());
            LocalDate FechaCreacion = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            boolean estado = false;
            if (jcbActivo.isSelected() == true) {
                estado = true;
            } else if (jcbInactivo.isSelected() == false) {
                estado = false;
            }
            Proyecto proyec=new Proyecto();
            Equipo equipo = new Equipo(proyec,  nombre, FechaCreacion, estado);
            EquipoData data = new EquipoData();
            data.modificarEquipo(equipo);

     
      
      


    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadoActionPerformed
      
        String nombre=jtNombre.getText();
        EquipoData data = new EquipoData();
        if (jcbActivo.isSelected() == true) {
            data.bajaEquipo(nombre);
            jcbActivo.setSelected(false);
            jcbInactivo.setSelected(true);
            jbEstado.setText("Dar de Alta");
        } else if (jcbInactivo.isSelected() == true) {
            data.altaEquipo(nombre);
            jcbActivo.setSelected(true);
            jcbInactivo.setSelected(false);
            jbEstado.setText("Dar de Baja");
        }

    }//GEN-LAST:event_jbEstadoActionPerformed

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed

        
            
            String nombre = jtNombre.getText();
            Proyecto proyecto=(Proyecto) jCProyecto.getSelectedItem();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = formatoFecha.format(CALENDARIO.getDate());
            LocalDate FechaDeCreacion= LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            boolean estado = false;
            if (jcbActivo.isSelected() == true) {
                estado = true;
            } else if (jcbInactivo.isSelected() == false) {
                estado = false;
            }
          
            Equipo equipo=new Equipo(proyecto,nombre,FechaDeCreacion,estado);
            EquipoData data = new EquipoData();
            data.crearEquipo(equipo);

     
         
        

    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtNombreFocusGained
        if(jtNombre.getText().equals("NOMBRE:")){
            jtNombre.setText("");
        }
    }//GEN-LAST:event_jtNombreFocusGained

    private void jtProyectoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtProyectoFocusGained
        if(jtProyecto.getText().equals("PROYECTO:")){
            jtProyecto.setText("");
        }
    }//GEN-LAST:event_jtProyectoFocusGained

    private void jCProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCProyectoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CALENDARIO;
    private javax.swing.JComboBox<Proyecto> jCProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEstado;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JCheckBox jcbInactivo;
    private javax.swing.JLabel jlCreacion;
    private javax.swing.JLabel jlNuevoLegajo;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtProyecto;
    // End of variables declaration//GEN-END:variables
}


