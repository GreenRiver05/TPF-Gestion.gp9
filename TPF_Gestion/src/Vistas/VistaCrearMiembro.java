package Vistas;

import AccesoADatos.MiembroData;
import Entidades.Miembro;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class VistaCrearMiembro extends javax.swing.JInternalFrame {

    public VistaCrearMiembro() {
        initComponents();
        jtIdMiembro.setVisible(false);
        setLocation(200, 15);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();
        jcbInactivo = new javax.swing.JCheckBox();
        jbRegistrar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEstado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jtDni = new javax.swing.JTextField();
        jbSalir = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbBuscar2 = new javax.swing.JButton();
        jtNombre = new javax.swing.JTextField();
        jtIdMiembro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlErrorDni = new javax.swing.JLabel();
        jlErrorApellido = new javax.swing.JLabel();
        jlErrorNombre = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 700));

        jtApellido.setFont(new java.awt.Font("Century Gothic", 1, 29)); // NOI18N
        jtApellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtApellido.setEnabled(false);
        jtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApellidoActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 0, 51));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ESTADO");

        jcbActivo.setForeground(new java.awt.Color(255, 255, 255));
        jcbActivo.setText("ACTIVO");
        jcbActivo.setEnabled(false);

        jcbInactivo.setForeground(new java.awt.Color(255, 255, 255));
        jcbInactivo.setText("INACTIVO");
        jcbInactivo.setEnabled(false);

        jbRegistrar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegistrar.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrar.setText("REGISTRAR");
        jbRegistrar.setEnabled(false);
        jbRegistrar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });

        jbNuevo.setBackground(new java.awt.Color(51, 51, 51));
        jbNuevo.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jbNuevo.setText("NUEVO");
        jbNuevo.setEnabled(false);
        jbNuevo.setPreferredSize(new java.awt.Dimension(100, 40));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEstado.setBackground(new java.awt.Color(51, 51, 51));
        jbEstado.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbEstado.setForeground(new java.awt.Color(255, 255, 255));
        jbEstado.setText("ESTADO");
        jbEstado.setEnabled(false);
        jbEstado.setPreferredSize(new java.awt.Dimension(100, 32));
        jbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("MIEMBROS");

        jbModificar.setBackground(new java.awt.Color(51, 51, 51));
        jbModificar.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbModificar.setText("MODIFICAR");
        jbModificar.setEnabled(false);
        jbModificar.setPreferredSize(new java.awt.Dimension(100, 32));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jtDni.setFont(new java.awt.Font("Century Gothic", 1, 29)); // NOI18N
        jtDni.setSelectedTextColor(new java.awt.Color(51, 0, 51));
        jtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDniActionPerformed(evt);
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

        jbBuscar.setBackground(new java.awt.Color(51, 51, 51));
        jbBuscar.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("BUSCAR");
        jbBuscar.setEnabled(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbBuscar2.setBackground(new java.awt.Color(51, 51, 51));
        jbBuscar2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jbBuscar2.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar2.setText("BUSCAR");
        jbBuscar2.setEnabled(false);
        jbBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscar2ActionPerformed(evt);
            }
        });

        jtNombre.setFont(new java.awt.Font("Century Gothic", 1, 29)); // NOI18N
        jtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtNombre.setEnabled(false);
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });

        jtIdMiembro.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("DNI:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("APELLIDO:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setText("NOMBRE:");

        jlErrorDni.setForeground(new java.awt.Color(255, 0, 0));

        jlErrorApellido.setForeground(new java.awt.Color(255, 0, 0));

        jlErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        jlErrorNombre.setRequestFocusEnabled(false);
        jlErrorNombre.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                                            .addComponent(jtDni))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbBuscar2)
                                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2)
                                    .addComponent(jtIdMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtNombre)
                                    .addComponent(jlErrorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlErrorDni, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(243, 243, 243)
                                    .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jlErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbActivo)
                                    .addGap(41, 41, 41)
                                    .addComponent(jcbInactivo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jtIdMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlErrorDni, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlErrorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbActivo)
                    .addComponent(jcbInactivo)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed

        try {
            int Dni = Integer.parseInt(jtDni.getText());
            String Apellido = jtApellido.getText();
            String Nombre = jtNombre.getText();
            boolean Estado = false;
            if (jcbActivo.isSelected() == true) {
                Estado = true;
            } else if (jcbInactivo.isSelected() == false) {
                Estado = false;
            }

            Miembro mie = new Miembro(Dni, Apellido, Nombre, Estado);
            MiembroData md = new MiembroData();
            md.crearMiembro(mie);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un Valor Numerico para el Dni");
        }
    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed

        jtDni.setText("DNI");
        jtApellido.setText("APELLIDO");
        jtNombre.setText("NOMBRE");
        jcbActivo.setSelected(false);
        jcbInactivo.setSelected(false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadoActionPerformed
        //        int id = Integer.parseInt(jtLegajo.getText());
        int dni = Integer.parseInt(jtDni.getText());
        MiembroData md = new MiembroData();
        if (jcbActivo.isSelected() == true) {
            md.bajaMiembro(dni);
            jcbActivo.setSelected(false);
            jcbInactivo.setSelected(true);
            jbEstado.setText("Dar de Alta");
        } else if (jcbInactivo.isSelected() == true) {
            md.altaMiembro(dni);
            jcbActivo.setSelected(true);
            jcbInactivo.setSelected(false);
            jbEstado.setText("Dar de Baja");
        }
    }//GEN-LAST:event_jbEstadoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

        try {
            int idMiembro = Integer.parseInt(jtIdMiembro.getText());
            int Dni = Integer.parseInt(jtDni.getText());
            String Apellido = jtApellido.getText();
            String Nombre = jtNombre.getText();
            boolean Estado = false;
            if (jcbActivo.isSelected() == true) {
                Estado = true;
            } else if (jcbInactivo.isSelected() == false) {
                Estado = false;
            }

            Miembro mie = new Miembro(idMiembro, Dni, Apellido, Nombre, Estado);
            MiembroData md = new MiembroData();
            md.modificarMiembro(mie);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un Valor Numerico para el Dni");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        try {
            jcbActivo.setSelected(false);
            jcbInactivo.setSelected(false);
            int dni = Integer.parseInt(jtDni.getText());
            MiembroData md = new MiembroData();
            Miembro mie = new Miembro();
            mie = md.buscarMiembroDNI(dni);
            jtIdMiembro.setText(String.valueOf(mie.getIdMiembro()));
            jtApellido.setText(mie.getApellido());
            jtNombre.setText(mie.getNombre());
            if (mie.isEstado() == true) {
                jcbActivo.setSelected(true);
                jbEstado.setText("Dar de Baja");
            } else {
                jcbInactivo.setSelected(true);
                jbEstado.setText("Dar de Alta");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un Valor Numerico para el Dni");

        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscar2ActionPerformed
        try {
            jcbActivo.setSelected(false);
            jcbInactivo.setSelected(false);

            String Apellido = (jtApellido.getText());
            MiembroData md = new MiembroData();
            Miembro mie = new Miembro();
            mie = md.buscarMiembroPorApellido(Apellido);
            jtIdMiembro.setText(String.valueOf(mie.getIdMiembro()));
            jtDni.setText(String.valueOf(mie.getDni()));
            jtNombre.setText(mie.getNombre());
            if (mie.isEstado() == true) {
                jcbActivo.setSelected(true);
                jbEstado.setText("Dar de Baja");
            } else {
                jcbInactivo.setSelected(true);
                jbEstado.setText("Dar de Alta");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un Valor String para el Apellido");

        }
    }//GEN-LAST:event_jbBuscar2ActionPerformed

    private void jtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDniActionPerformed
        validaciones();
    }//GEN-LAST:event_jtDniActionPerformed

    private void jtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellidoActionPerformed
        validaciones();
    }//GEN-LAST:event_jtApellidoActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        validaciones();
    }//GEN-LAST:event_jtNombreActionPerformed

    private void validaciones() {
        int aux = 0;
        try {

            if (jtNombre.getText().equals("") && aux==0) {
                jlErrorNombre.setText("INGRESE UN NOMBRE");
                jcbActivo.setEnabled(false);
                jcbInactivo.setEnabled(false);
                if (aux == 0) {
                    jtNombre.requestFocus();
                }
                aux++;
                
            } else {
                jlErrorNombre.setText("");
                jcbActivo.setEnabled(true);
                jcbInactivo.setEnabled(true);
            }

            if (jtApellido.getText().equals("") && aux==0) {
                jlErrorApellido.setText("INGRESE UN APELLIDO");
                jtNombre.setEnabled(false);
                if (aux == 0) {
                    jtNombre.requestFocus();
                }
                aux++;
            } else {
                jtApellido.setText("");
                jtNombre.setEnabled(true);
            }
            int Dni = Integer.parseInt(jtDni.getText());
            
        } catch (Exception ex) {
            jlErrorDni.setText("INGRESE UN NUMERO ");
            if (aux == 0) {
                jlErrorDni.requestFocus();
            }
            aux++;

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscar2;
    private javax.swing.JButton jbEstado;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JCheckBox jcbInactivo;
    private javax.swing.JLabel jlErrorApellido;
    private javax.swing.JLabel jlErrorDni;
    private javax.swing.JLabel jlErrorNombre;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtIdMiembro;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
