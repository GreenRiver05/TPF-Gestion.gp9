package Vistas;

import AccesoADatos.*;
import Entidades.Proyecto;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VistaVerProyectos extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private ProyectoData proyecto = new ProyectoData();
    private ArrayList<Proyecto> listaTodosLosProyectos = new ArrayList();
    private ArrayList<Proyecto> listaProyecto = new ArrayList();

    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("NOMBRE");
        columnas.add("DESCRIPCION");
        columnas.add("FECHA INICIAL");
        columnas.add("ESTADO");
        for (Object c : columnas) { 
            modeloTabla.addColumn(c);
        }
        jTable1.setModel(modeloTabla);
//----------------------------------AGREGADO--------------------------------------------------------//
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(180);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(327);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(111);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);

        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false); 
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }
//----------------------------------AGREGADO--------------------------------------------------------//
    }

    private void llenarTabla() {
        borrarFilas();

        if (JrTodos.isSelected() == true) {
            listaTodosLosProyectos = proyecto.listarTodosLosProyectos();
            for (Proyecto p : listaTodosLosProyectos) {
                if (p.isEstado()) {
                    modeloTabla.addRow(new Object[]{p.getNombre(), p.getDescripcion(), p.getFechaInicial(), "EN PROCESO"});  /// MODIFICACION 
                } else {
                    modeloTabla.addRow(new Object[]{p.getNombre(), p.getDescripcion(), p.getFechaInicial(), "FINALIZADO"});  /// MODIFICACION 
                }
            }
        }

        if (jrEnProceso.isSelected() == true) {
            listaProyecto = proyecto.listarProyectos(true);
            for (Proyecto p : listaProyecto) {
                modeloTabla.addRow(new Object[]{p.getNombre(), p.getDescripcion(), p.getFechaInicial(), "EN PROCESO"});  /// MODIFICACION 
            }
        }
        if (jrFinalizado.isSelected() == true) {
            listaProyecto = proyecto.listarProyectos(false);
            for (Proyecto p : listaProyecto) {
                modeloTabla.addRow(new Object[]{p.getNombre(), p.getDescripcion(), p.getFechaInicial(), "FINALIZADO"});  /// MODIFICACION 
            }
        }

    }

    private void modificarTabla() {
 //----------------------------------AGREGADO--------------------------------------------------------//
        TableColumn columna0 = jTable1.getColumnModel().getColumn(0);
        TableColumn columna1 = jTable1.getColumnModel().getColumn(1);
        TableColumn columna2 = jTable1.getColumnModel().getColumn(2);
        TableColumn columna3 = jTable1.getColumnModel().getColumn(3);
        if (JrTodos.isSelected()) {
            columna0.setMaxWidth(180);
            columna0.setMinWidth(180);
            columna0.setPreferredWidth(180);
            columna1.setMaxWidth(327);
            columna1.setMinWidth(327);
            columna1.setPreferredWidth(327);
            columna2.setMaxWidth(111);
            columna2.setMinWidth(111);
            columna2.setPreferredWidth(111);
            columna3.setMaxWidth(140);
            columna3.setMinWidth(140);
            columna3.setPreferredWidth(140);
            jTable1.doLayout();
        } else {
            columna1.setMaxWidth(466);
            columna1.setMinWidth(466);
            columna1.setPreferredWidth(466);
             columna2.setMaxWidth(111);
            columna2.setMinWidth(111);
            columna2.setPreferredWidth(111);
            columna3.setMaxWidth(0);
            columna3.setMinWidth(0);
            columna3.setPreferredWidth(0);
            jTable1.doLayout();
        }
//----------------------------------AGREGADO--------------------------------------------------------//
    }

    
    private void borrarFilas() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }
    public VistaVerProyectos() {
        initComponents();
        setLocation(200, 15);
        armarCabecera();
        borrarFilas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jrFinalizado = new javax.swing.JRadioButton();
        jrEnProceso = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JrTodos = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(900, 700));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Engravers MT", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de proyectos");

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalir.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalir3ActionPerformed(evt);
            }
        });

        jrFinalizado.setText("Finalizado");
        jrFinalizado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrFinalizadoActionPerformed(evt);
            }
        });

        jrEnProceso.setText("En proceso");
        jrEnProceso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrEnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEnProcesoActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(241, 226, 226));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(241, 226, 226));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
        }

        JrTodos.setText("Todos los proyectos");
        JrTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JrTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrTodosActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(392, 392, 392))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JrTodos)
                                .addGap(72, 72, 72)
                                .addComponent(jrEnProceso)
                                .addGap(101, 101, 101)
                                .addComponent(jrFinalizado)
                                .addGap(193, 193, 193))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59))))
                    .addComponent(jSeparator1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrFinalizado)
                    .addComponent(jrEnProceso)
                    .addComponent(JrTodos))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalir3ActionPerformed
        dispose();
    }//GEN-LAST:event_jSalir3ActionPerformed

    private void jrEnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEnProcesoActionPerformed
        jrFinalizado.setSelected(false);
        JrTodos.setSelected(false);
        modificarTabla(); // AGREGADO
        llenarTabla();
    }//GEN-LAST:event_jrEnProcesoActionPerformed

    private void jrFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrFinalizadoActionPerformed
        jrEnProceso.setSelected(false);
        JrTodos.setSelected(false);
        modificarTabla(); // AGREGADO
        llenarTabla();
    }//GEN-LAST:event_jrFinalizadoActionPerformed

    private void JrTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrTodosActionPerformed
        jrFinalizado.setSelected(false);
        jrEnProceso.setSelected(false);
        modificarTabla(); // AGREGADO
        llenarTabla();
    }//GEN-LAST:event_JrTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JrTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrEnProceso;
    private javax.swing.JRadioButton jrFinalizado;
    // End of variables declaration//GEN-END:variables
}
