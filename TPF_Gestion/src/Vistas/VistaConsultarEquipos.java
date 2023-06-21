package Vistas;

import Entidades.*;
import AccesoADatos.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VistaConsultarEquipos extends javax.swing.JInternalFrame {

    private ArrayList<Miembro> listaMiembros = new ArrayList();
    private ArrayList<Tarea> listaTareas = new ArrayList();
    private TareaData taData = new TareaData();
    private EquipoData eqData = new EquipoData();
    private ProyectoData proData = new ProyectoData();
    private MiembroData miemData = new MiembroData();

    private DefaultTableModel modeloTablaMiembro = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private DefaultTableModel modeloTablaTarea = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaConsultarEquipos() {
        initComponents();
        setLocation(200, 15); //setear ubicacion
        llenarEquipos();
        armarCabeceraMiembros();
        armarCabeceraTareas();
        borrarFilasMiembro();
        borrarFilasTarea();
    }

    private void armarCabeceraMiembros() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("DNI");
        columnas.add("APELLIDO Y NOMBRE");
        columnas.add("ESTADO");
        for (Object c : columnas) {
            modeloTablaMiembro.addColumn(c);
        }
        jtMiembros.setModel(modeloTablaMiembro);

    }

    private void armarCabeceraTareas() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("TAREA");
        columnas.add("PROYECTO");
        for (Object c : columnas) {
            modeloTablaTarea.addColumn(c);
        }
        jtTareas.setModel(modeloTablaTarea);

    }

    private void llenarEquipos() {
        for (Equipo eq : eqData.listarEquiposSinRepetir(true)) {
            cboxEquipos.addItem(eq);
        }
    }

    private void llenarProyectoPorEquipos() {
        Equipo equipoElegido = (Equipo) cboxEquipos.getSelectedItem();
        for (Proyecto pro : proData.listarProyectoPorEquipo(equipoElegido.getNombre())) {
            cboxProyectos.addItem(pro);
        }
    }

    private void borrarFilasMiembro() {
        int filas = modeloTablaMiembro.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTablaMiembro.removeRow(i);
        }
    }

    private void borrarFilasTarea() {
        int filas = modeloTablaTarea.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTablaTarea.removeRow(i);
        }
    }

    private void llenarTablaTareas() {
        borrarFilasTarea();
        TableColumn columna = jtTareas.getColumnModel().getColumn(1);
        if (jrbFiltrarProyectos.isSelected()) {
            columna.setMaxWidth(0);
            columna.setMinWidth(0);
            columna.setPreferredWidth(0);
            jtTareas.doLayout();
            
            
            Proyecto proyectoElegido = (Proyecto) cboxProyectos.getSelectedItem();
            Equipo equipoElegido = (Equipo) cboxEquipos.getSelectedItem();
            int filaElegida = jtMiembros.getSelectedRow();
            int dni = (Integer) jtMiembros.getValueAt(filaElegida, 0);
            listaTareas = taData.obtenerTareasXEqiposYProyecto(proyectoElegido.getNombre(),equipoElegido.getNombre(), dni);
            for (Tarea t : listaTareas) {
                modeloTablaTarea.addRow(new Object[]{t.getNombre()});
            }

        } else {
            columna.setMaxWidth(200);
            columna.setMinWidth(200);
            columna.setPreferredWidth(200);
            jtTareas.doLayout();
            
            int filaElegida = jtMiembros.getSelectedRow();
            int dni = (Integer) jtMiembros.getValueAt(filaElegida, 0);
            Equipo equipoElegido = (Equipo) cboxEquipos.getSelectedItem();
            listaTareas = taData.obtenerTareasXMiembrosYEquipo(equipoElegido.getNombre(), dni);
            for (Tarea t : listaTareas){
                modeloTablaTarea.addRow(new Object[]{t.getNombre(),t.getIncorporacion().getEquipo().getProyecto().getNombre()});
            }
        }

    }

    private void llenarTablaMiembro() {
        borrarFilasMiembro();
        borrarFilasTarea();

        if (jrbFiltrarProyectos.isSelected()) {
            Equipo equipoElegido = (Equipo) cboxEquipos.getSelectedItem();
            Proyecto proyectoElegido = (Proyecto) cboxProyectos.getSelectedItem();
            listaMiembros = miemData.listarMiembroXEquipoYProyecto(equipoElegido.getNombre(), proyectoElegido.getNombre());
            for (Miembro miemb : listaMiembros) {

                if (jcTodos.isSelected()) {
                    if (miemb.isEstado()) {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "ACTIVO"});
                    } else {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "INACTIVO"});
                    }

                } else if (jcActivos.isSelected()) {
                    if (miemb.isEstado()) {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "ACTIVO"});
                    }

                } else if (jcInactivos.isSelected()) {
                    if (!miemb.isEstado()) {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "INACTIVO"});
                    }
                }

            }

        } else {
            Equipo elegido = (Equipo) cboxEquipos.getSelectedItem();
            listaMiembros = miemData.listarMiembrosXEquipo(elegido.getNombre());
            for (Miembro miemb : listaMiembros) {

                if (jcTodos.isSelected()) {
                    if (miemb.isEstado()) {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "ACTIVO"});
                    } else {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "INACTIVO"});
                    }

                } else if (jcActivos.isSelected()) {
                    if (miemb.isEstado()) {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "ACTIVO"});
                    }

                } else if (jcInactivos.isSelected()) {
                    if (!miemb.isEstado()) {
                        modeloTablaMiembro.addRow(new Object[]{miemb.getDni(), miemb.getApellido() + " " + miemb.getNombre(), "INACTIVO"});
                    }
                }

            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMiembros = new javax.swing.JTable();
        cboxEquipos = new javax.swing.JComboBox<>();
        cboxProyectos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTareas = new javax.swing.JTable();
        jcActivos = new javax.swing.JCheckBox();
        jcInactivos = new javax.swing.JCheckBox();
        jcTodos = new javax.swing.JCheckBox();
        jrbFiltrarProyectos = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbSalir = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 40)); // NOI18N
        jLabel1.setText("CONSULTAR EQUIPOS");
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 40));

        jtMiembros.setBackground(new java.awt.Color(51, 51, 51));
        jtMiembros.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jtMiembros.setForeground(new java.awt.Color(255, 255, 255));
        jtMiembros.setModel(new javax.swing.table.DefaultTableModel(
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
        jtMiembros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtMiembros.setFocusCycleRoot(true);
        jtMiembros.setFocusable(false);
        jtMiembros.setGridColor(new java.awt.Color(241, 226, 226));
        jtMiembros.setRowHeight(30);
        jtMiembros.setSelectionBackground(new java.awt.Color(241, 226, 226));
        jtMiembros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtMiembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMiembrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMiembros);

        cboxEquipos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cboxEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxEquiposActionPerformed(evt);
            }
        });

        cboxProyectos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cboxProyectos.setEnabled(false);
        cboxProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxProyectosActionPerformed(evt);
            }
        });

        jtTareas.setBackground(new java.awt.Color(51, 51, 51));
        jtTareas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtTareas.setForeground(new java.awt.Color(255, 255, 255));
        jtTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jtTareas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtTareas.setFocusable(false);
        jtTareas.setGridColor(new java.awt.Color(241, 226, 226));
        jtTareas.setRowHeight(30);
        jtTareas.setSelectionBackground(new java.awt.Color(241, 226, 226));
        jtTareas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jtTareas);

        jcActivos.setText("Activos");
        jcActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcActivosActionPerformed(evt);
            }
        });

        jcInactivos.setText("Inactivos");
        jcInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcInactivosActionPerformed(evt);
            }
        });

        jcTodos.setText("Todos");
        jcTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTodosActionPerformed(evt);
            }
        });

        jrbFiltrarProyectos.setText("FILTRAR POR PROYECTOS");
        jrbFiltrarProyectos.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jrbFiltrarProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFiltrarProyectosActionPerformed(evt);
            }
        });

        jLabel3.setText("FILTRAR POR ESTADO");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(237, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)
                                .addComponent(jrbFiltrarProyectos)
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcTodos)
                                .addGap(158, 158, 158)
                                .addComponent(cboxProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 114, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcActivos)
                                .addGap(69, 69, 69)
                                .addComponent(jcInactivos))
                            .addComponent(cboxEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(353, 353, 353)))
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(cboxEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbFiltrarProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcTodos))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcInactivos)
                    .addComponent(jcActivos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxEquiposActionPerformed
        jcActivos.setSelected(false);
        jcInactivos.setSelected(false);
        jcTodos.setSelected(false);
        jrbFiltrarProyectos.setSelected(false);
        cboxProyectos.removeAllItems();
        cboxProyectos.setEnabled(false);
        borrarFilasMiembro();
        borrarFilasTarea();
        jrbFiltrarProyectos.setSelected(false);
        cboxProyectos.removeAllItems();
        cboxProyectos.setEnabled(false);
    }//GEN-LAST:event_cboxEquiposActionPerformed

    private void cboxProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxProyectosActionPerformed
        jcActivos.setSelected(false);
        jcInactivos.setSelected(false);
        jcTodos.setSelected(false);
        borrarFilasMiembro();
        borrarFilasTarea();
    }//GEN-LAST:event_cboxProyectosActionPerformed

    private void jrbFiltrarProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFiltrarProyectosActionPerformed
        jcActivos.setSelected(false);
        jcInactivos.setSelected(false);
        jcTodos.setSelected(false);
        borrarFilasMiembro();
        borrarFilasTarea();
        if (jrbFiltrarProyectos.isSelected()) {
            cboxProyectos.setEnabled(true);
            llenarProyectoPorEquipos();
        } else {
            cboxProyectos.removeAllItems();
            cboxProyectos.setEnabled(false);
        }


    }//GEN-LAST:event_jrbFiltrarProyectosActionPerformed

    private void jcTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTodosActionPerformed
        jcActivos.setSelected(false);
        jcInactivos.setSelected(false);
        llenarTablaMiembro();
    }//GEN-LAST:event_jcTodosActionPerformed

    private void jcActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcActivosActionPerformed
        jcTodos.setSelected(false);
        jcInactivos.setSelected(false);
        llenarTablaMiembro();
    }//GEN-LAST:event_jcActivosActionPerformed

    private void jcInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcInactivosActionPerformed
        jcTodos.setSelected(false);
        jcActivos.setSelected(false);
        llenarTablaMiembro();
    }//GEN-LAST:event_jcInactivosActionPerformed

    private void jtMiembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMiembrosMouseClicked
        llenarTablaTareas();
    }//GEN-LAST:event_jtMiembrosMouseClicked

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Equipo> cboxEquipos;
    private javax.swing.JComboBox<Proyecto> cboxProyectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcActivos;
    private javax.swing.JCheckBox jcInactivos;
    private javax.swing.JCheckBox jcTodos;
    private javax.swing.JRadioButton jrbFiltrarProyectos;
    private javax.swing.JTable jtMiembros;
    private javax.swing.JTable jtTareas;
    // End of variables declaration//GEN-END:variables
}
