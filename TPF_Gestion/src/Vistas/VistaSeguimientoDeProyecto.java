package Vistas;

import AccesoADatos.*;
import Entidades.*;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.table.DefaultTableModel;

public class VistaSeguimientoDeProyecto extends javax.swing.JInternalFrame {

    private ArrayList<Tarea> listaTarea = new ArrayList();
    private ProyectoData proData = new ProyectoData();
    private TareaData taData = new TareaData();

    public VistaSeguimientoDeProyecto() {
        initComponents();
        setLocation(200, 15);
        armarCabecera();
        llenarProyectos();
    }
    private DefaultTableModel modeloTabla = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("TAREA");
        columnas.add("ESTADO");
        columnas.add("MIEMBRO");
        for (Object c : columnas) {
            modeloTabla.addColumn(c);
        }
        jtTabla.setModel(modeloTabla);

        jtTabla.getColumnModel().getColumn(0).setPreferredWidth(70);
        jtTabla.getColumnModel().getColumn(1).setPreferredWidth(45);
        jtTabla.getColumnModel().getColumn(2).setPreferredWidth(250);

        if (jtTabla.getColumnModel().getColumnCount() > 0) {
            jtTabla.getColumnModel().getColumn(0).setResizable(false);
            jtTabla.getColumnModel().getColumn(1).setResizable(false);
            jtTabla.getColumnModel().getColumn(2).setResizable(false);
        }

        // Le cambiamos color al seleccionar las filas, la configuramos para que no sen editables
        // Solo se puede seleccionar una, le cambiamos el tamañano a cada columnas, y le desactivamos el rezisable
        // Le colocamos un Cursor pointer, le cambiamos el color a la cuadricula
    }

    private void llenarProyectos() {
        for (Proyecto pro : proData.listarProyectos(true)) {
            System.out.println(pro.getFechaInicial());
            jcProyectos.addItem(pro);

        }
    }

    private void borrarFilas() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    private void llenarTabla() {
        borrarFilas();
        Proyecto elegido = (Proyecto) jcProyectos.getSelectedItem();

        listaTarea = taData.obtenerProyectoTarea(elegido.getNombre());
        for (Tarea e : listaTarea) {

            if (jcbTodas.isSelected()) {
                if (e.isEstado()) {
                    modeloTabla.addRow(new Object[]{e.getNombre(), " EN PROCESO ", e.getIncorporacion().getMiembro().getApellido() + " "
                        + e.getIncorporacion().getMiembro().getNombre() + " " + e.getIncorporacion().getMiembro().getDni()});
                } else {
                    modeloTabla.addRow(new Object[]{e.getNombre(), " FINALIZADA ", e.getIncorporacion().getMiembro().getApellido() + " "
                        + e.getIncorporacion().getMiembro().getNombre() + " " + e.getIncorporacion().getMiembro().getDni()});
                }
            } else if (jcbTareasEnProcesos.isSelected()) {
                if (e.isEstado()) {
                    modeloTabla.addRow(new Object[]{e.getNombre(), " EN PROCESO ", e.getIncorporacion().getMiembro().getApellido() + " "
                        + e.getIncorporacion().getMiembro().getNombre() + " " + e.getIncorporacion().getMiembro().getDni()});
                }
            } else if (jcbTareasFinalizadas.isSelected()) {
                if(!e.isEstado()){
                    modeloTabla.addRow(new Object[]{e.getNombre(), " FINALIZADA ", e.getIncorporacion().getMiembro().getApellido() + " "
                        + e.getIncorporacion().getMiembro().getNombre() + " " + e.getIncorporacion().getMiembro().getDni()});
                }
               
            }

        }


}

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jcbTareasFinalizadas = new javax.swing.JCheckBox();
        jcbTareasEnProcesos = new javax.swing.JCheckBox();
        jcProyectos = new javax.swing.JComboBox<>();
        jcMiembros = new javax.swing.JComboBox<>();
        jrbMiembros = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbTodas = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel1.setText("SEGUIMIENTO DE PROYECTOS");
        jLabel1.setPreferredSize(new java.awt.Dimension(450, 34));

        jtTabla.setBackground(new java.awt.Color(51, 51, 51));
        jtTabla.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jtTabla.setForeground(new java.awt.Color(255, 255, 255));
        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtTabla.setFocusCycleRoot(true);
        jtTabla.setFocusable(false);
        jtTabla.setGridColor(new java.awt.Color(241, 226, 226));
        jtTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtTabla.setRowHeight(30);
        jtTabla.setSelectionBackground(new java.awt.Color(241, 226, 226));
        jtTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtTabla);
        if (jtTabla.getColumnModel().getColumnCount() > 0) {
            jtTabla.getColumnModel().getColumn(0).setResizable(false);
            jtTabla.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtTabla.getColumnModel().getColumn(1).setResizable(false);
            jtTabla.getColumnModel().getColumn(1).setPreferredWidth(1);
            jtTabla.getColumnModel().getColumn(2).setResizable(false);
        }

        jcbTareasFinalizadas.setText("Tareas Finalizadas");
        jcbTareasFinalizadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbTareasFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTareasFinalizadasActionPerformed(evt);
            }
        });

        jcbTareasEnProcesos.setText("Tareas en Proceso");
        jcbTareasEnProcesos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbTareasEnProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTareasEnProcesosActionPerformed(evt);
            }
        });

        jcProyectos.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N

        jcMiembros.setEnabled(false);

        jrbMiembros.setText("Filtrar por Miembro");
        jrbMiembros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrbMiembros.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jrbMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMiembrosActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar por Estado");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("PROYECTO :");

        jcbTodas.setText("Todas");
        jcbTodas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTodasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jcProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jcbTareasFinalizadas)
                        .addGap(18, 18, 18)
                        .addComponent(jcbTareasEnProcesos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcbTodas)
                        .addGap(117, 117, 117)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jcMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbMiembros)
                .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbTodas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbTareasEnProcesos)
                            .addComponent(jcbTareasFinalizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jcMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTareasFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTareasFinalizadasActionPerformed
        jcbTareasEnProcesos.setSelected(false);
        jcbTodas.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jcbTareasFinalizadasActionPerformed

    private void jcbTareasEnProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTareasEnProcesosActionPerformed
        jcbTareasFinalizadas.setSelected(false);
        jcbTodas.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jcbTareasEnProcesosActionPerformed

    private void jrbMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMiembrosActionPerformed
        if (jrbMiembros.isSelected()) {
            jcMiembros.setEnabled(true);
        }


    }//GEN-LAST:event_jrbMiembrosActionPerformed

    private void jcbTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTodasActionPerformed
        jcbTareasEnProcesos.setSelected(false);
        jcbTareasFinalizadas.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jcbTodasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Miembro> jcMiembros;
    private javax.swing.JComboBox<Proyecto> jcProyectos;
    private javax.swing.JCheckBox jcbTareasEnProcesos;
    private javax.swing.JCheckBox jcbTareasFinalizadas;
    private javax.swing.JCheckBox jcbTodas;
    private javax.swing.JRadioButton jrbMiembros;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
}
