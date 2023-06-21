package Vistas;

import AccesoADatos.EquipoData;
import AccesoADatos.ProyectoData;
import Entidades.Equipo;
import Entidades.Proyecto;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VistaCrearEquipos extends javax.swing.JInternalFrame {

    private void LlenarComboBox() {
        ProyectoData pd = new ProyectoData();

        for (Proyecto proyecto : pd.listarProyectos(true)) {
            jCProyecto.addItem(proyecto);
        }
    }

    public VistaCrearEquipos() {
        initComponents();
        LlenarComboBox();
        setLocation(200, 15);
        IDEQUIPO.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbBuscar = new javax.swing.JButton();
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlErrorNombre = new javax.swing.JLabel();
        jlNombreProyecto = new javax.swing.JLabel();
        jlErrorFecha = new javax.swing.JLabel();
        jlProyectoMostrar = new javax.swing.JLabel();
        jlNombreProyectoMostrar = new javax.swing.JLabel();
        IDEQUIPO = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 700));
        setRequestFocusEnabled(false);

        jbBuscar.setBackground(new java.awt.Color(51, 51, 51));
        jbBuscar.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("BUSCAR");
        jbBuscar.setEnabled(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO DE EQUIPO");

        jtNombre.setFont(new java.awt.Font("Engravers MT", 0, 18)); // NOI18N
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });

        CALENDARIO.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        CALENDARIO.setEnabled(false);
        CALENDARIO.setFont(new java.awt.Font("Dialog", 0, 26)); // NOI18N

        jlCreacion.setFont(new java.awt.Font("Dialog", 1, 29)); // NOI18N
        jlCreacion.setText("FECHA DE CREACION:");

        jcbActivo.setText("ACTIVO");
        jcbActivo.setEnabled(false);
        jcbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActivoActionPerformed(evt);
            }
        });

        jcbInactivo.setText("INACTIVO");
        jcbInactivo.setEnabled(false);
        jcbInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInactivoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setText("ESTADO");

        jbNuevo.setBackground(new java.awt.Color(51, 51, 51));
        jbNuevo.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jbNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jbNuevo.setText("NUEVO");
        jbNuevo.setEnabled(false);
        jbNuevo.setPreferredSize(new java.awt.Dimension(100, 40));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbRegistrar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegistrar.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrar.setText("REGISTRAR");
        jbRegistrar.setEnabled(false);
        jbRegistrar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbModificar.setBackground(new java.awt.Color(51, 51, 51));
        jbModificar.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbModificar.setText("MODIFICAR");
        jbModificar.setEnabled(false);
        jbModificar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEstado.setBackground(new java.awt.Color(51, 51, 51));
        jbEstado.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jbEstado.setForeground(new java.awt.Color(255, 255, 255));
        jbEstado.setText("ESTADO");
        jbEstado.setEnabled(false);
        jbEstado.setPreferredSize(new java.awt.Dimension(100, 32));
        jbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadoActionPerformed(evt);
            }
        });

        jCProyecto.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jCProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCProyecto.setEnabled(false);
        jCProyecto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCProyectoFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel2.setText("PROYECTO:");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jlErrorNombre.setForeground(new java.awt.Color(255, 0, 0));

        jlNombreProyecto.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlNombreProyecto.setText("NOMBRE DEL EQUIPO:");

        jlErrorFecha.setForeground(new java.awt.Color(255, 0, 0));

        jlProyectoMostrar.setFont(new java.awt.Font("Engravers MT", 1, 28)); // NOI18N
        jlProyectoMostrar.setForeground(new java.awt.Color(0, 153, 153));

        jlNombreProyectoMostrar.setFont(new java.awt.Font("Engravers MT", 1, 30)); // NOI18N
        jlNombreProyectoMostrar.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jlCreacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGap(299, 299, 299))
                                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jlNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jlErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jlProyectoMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(47, 47, 47)
                                        .addComponent(jlNombreProyectoMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(jbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbBuscar)
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(IDEQUIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(49, 49, 49))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CALENDARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbActivo)
                                .addGap(42, 42, 42)
                                .addComponent(jcbInactivo))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(217, 217, 217))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jlNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(IDEQUIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlProyectoMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombreProyectoMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CALENDARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbActivo)
                    .addComponent(jcbInactivo))
                .addGap(27, 27, 27)
                .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed

        jtNombre.setText("");
        IDEQUIPO.setText("");
        CALENDARIO.setDate(null);
        jcbActivo.setSelected(false);
        jcbInactivo.setSelected(false);
        jbBuscar.setEnabled(false);
        jbEstado.setEnabled(false);
        jbModificar.setEnabled(false);
        jbNuevo.setEnabled(false);
        jbRegistrar.setEnabled(false);
        jcbActivo.setEnabled(false);
        jcbInactivo.setEnabled(false);
        jlNombreProyectoMostrar.setText("");
        jlProyectoMostrar.setText("");
        jCProyecto.setEnabled(false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        jcbActivo.setSelected(false);
        jcbInactivo.setSelected(false);
        String nom = jtNombre.getText();
        EquipoData data = new EquipoData();
        Equipo equipo = new Equipo();
        equipo = data.buscarEquipo(nom);
        if (equipo != null) {
            jtNombre.setText(equipo.getNombre());
            jlNombreProyectoMostrar.setText(equipo.getProyecto().getNombre());
            jlProyectoMostrar.setText("PROYECTO:");
            CALENDARIO.setDate(java.sql.Date.valueOf(equipo.getFechaCreacion()));
            IDEQUIPO.setText(equipo.getIdEquipo() + "");
            jbModificar.setEnabled(true);
            jbEstado.setEnabled(true);
            jbNuevo.setEnabled(true);
            
            if (equipo.isEstado() == true) {
                jcbActivo.setSelected(true);
                jbEstado.setText("DAR BAJA");
            } else {
                jcbInactivo.setSelected(true);
                jbEstado.setText("DAR ALTA");
            }
        }


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

        String nombre = jtNombre.getText();
        int ID = Integer.parseInt(IDEQUIPO.getText());
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formatoFecha.format(CALENDARIO.getDate());
        LocalDate FechaCreacion = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        boolean estado = false;
        if (jcbActivo.isSelected() == true) {
            estado = true;
        } else if (jcbInactivo.isSelected() == false) {
            estado = false;
        }
        Proyecto proyecto = (Proyecto) jCProyecto.getSelectedItem();
        Equipo equipo = new Equipo(ID, proyecto, nombre, FechaCreacion, estado);
        EquipoData data = new EquipoData();
        data.modificarEquipo(equipo);


    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadoActionPerformed

        String nombre = jtNombre.getText();
        EquipoData data = new EquipoData();
        if (jcbActivo.isSelected()) {
            data.bajaEquipo(nombre);
            jcbActivo.setSelected(false);
            jcbInactivo.setSelected(true);
            jbEstado.setText("DAR ALTA");
        } else if (jcbInactivo.isSelected()) {
            data.altaEquipo(nombre);
            jcbActivo.setSelected(true);
            jcbInactivo.setSelected(false);
            jbEstado.setText("DAR BAJA");
        }

    }//GEN-LAST:event_jbEstadoActionPerformed

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed
        jlErrorNombre.setText("");
        jlErrorFecha.setText("");
        if (jtNombre.getText().equals("")) {
            jlErrorNombre.setText("INGRESE EL NOMBRE DEL EQUIPO");
        }
        try {
            String nombre = jtNombre.getText();
            Proyecto proyecto = (Proyecto) jCProyecto.getSelectedItem();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = formatoFecha.format(CALENDARIO.getDate());
            LocalDate FechaDeCreacion = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            boolean estado = false;
            if (jcbActivo.isSelected() == true) {
                estado = true;
            } else if (jcbInactivo.isSelected() == false) {
                estado = false;
            }
            Equipo equipo = new Equipo(proyecto, nombre, FechaDeCreacion, estado);
            EquipoData data = new EquipoData();
            data.crearEquipo(equipo);
            jbNuevo.setEnabled(true);
            jbRegistrar.setEnabled(false);
        } catch (NullPointerException ex) {
            jlErrorFecha.setText("INGRESE LA FECHA DE CREACION");
        }

    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        if (jtNombre.getText().equals("")) {
            jlErrorNombre.setText("INGRESE EL NOMBRE DEL EQUIPO");
            jbBuscar.setEnabled(false);
        } else {
            jlErrorNombre.setText("");
            jbBuscar.setEnabled(true);
            jCProyecto.setEnabled(true);
        }
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jcbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActivoActionPerformed
        if (jbModificar.isEnabled()) {
            if (jcbActivo.isSelected()) {
                jbEstado.setEnabled(true);
            } else {
                jbEstado.setEnabled(false);
            }
        } else {
            if (jcbActivo.isSelected()) {
                jbRegistrar.setEnabled(true);
            } else {
                jbRegistrar.setEnabled(false);
            }
        }
        jcbInactivo.setSelected(false);
    }//GEN-LAST:event_jcbActivoActionPerformed

    private void jcbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInactivoActionPerformed
        if (jcbInactivo.isSelected()) {
            jbRegistrar.setEnabled(true);
        } else {
            jbRegistrar.setEnabled(false);
        }
        jcbActivo.setSelected(false);
    }//GEN-LAST:event_jcbInactivoActionPerformed

    private void jCProyectoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCProyectoFocusGained
        CALENDARIO.setEnabled(true);
        jcbActivo.setEnabled(true);
        jcbInactivo.setEnabled(true);
    }//GEN-LAST:event_jCProyectoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CALENDARIO;
    private javax.swing.JLabel IDEQUIPO;
    private javax.swing.JComboBox<Proyecto> jCProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEstado;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JCheckBox jcbInactivo;
    private javax.swing.JLabel jlCreacion;
    private javax.swing.JLabel jlErrorFecha;
    private javax.swing.JLabel jlErrorNombre;
    private javax.swing.JLabel jlNombreProyecto;
    private javax.swing.JLabel jlNombreProyectoMostrar;
    private javax.swing.JLabel jlProyectoMostrar;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
