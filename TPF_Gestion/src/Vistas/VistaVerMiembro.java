
package Vistas;

import AccesoADatos.MiembroData;
import Entidades.Miembro;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class VistaVerMiembro extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
  
    private MiembroData miembro = new MiembroData();
    private ArrayList<Miembro> ListarTodos = new ArrayList();
    private ArrayList<Miembro> miembrosPorEstado = new ArrayList();
   
    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList();
   
        columnas.add("DNI");
        columnas.add("Apellido");
        columnas.add("Nombre");
        for (Object c : columnas) { //se recorre el arrays para ir llenando los nombres de las columnas
            modeloTabla.addColumn(c);
        }
        jTable1.setModel(modeloTabla);
    }

    private void llenarTabla() {
    borrarFilas();
    
    if (jcbTodos.isSelected()) {
        ListarTodos = miembro.listarTodosLosMiembros();
        for (Miembro m : ListarTodos) {
            modeloTabla.addRow(new Object[]{m.getDni(), m.getApellido(), m.getNombre()});
        }
    } else {
        if (jcbActivo.isSelected()) {
            miembrosPorEstado = miembro.listarMiembrosPorEstado(true);
            for (Miembro m : miembrosPorEstado) {
                modeloTabla.addRow(new Object[]{m.getDni(), m.getApellido(), m.getNombre()});
            }
        }
        if (jcbInactivo.isSelected()) {
            miembrosPorEstado = miembro.listarMiembrosPorEstado(false);
            for (Miembro m : miembrosPorEstado) {
                modeloTabla.addRow(new Object[]{m.getDni(), m.getApellido(), m.getNombre()});
            }
        }
    }
}
    
    private void borrarFilas() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }
    public VistaVerMiembro() {
        initComponents();
        setLocation(200, 15);
        armarCabecera();
        borrarFilas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();
        jcbInactivo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jcbTodos = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("MIEMBROS POR ESTADO");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("ESTADO");

        jcbActivo.setForeground(new java.awt.Color(51, 0, 51));
        jcbActivo.setText("ACTIVO");
        jcbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActivoActionPerformed(evt);
            }
        });

        jcbInactivo.setForeground(new java.awt.Color(51, 0, 51));
        jcbInactivo.setText("INACTIVO");
        jcbInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInactivoActionPerformed(evt);
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
                "DNI", "Apellido", "Nombre"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFocusCycleRoot(true);
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(241, 226, 226));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(241, 226, 226));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

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

        jcbTodos.setForeground(new java.awt.Color(51, 0, 51));
        jcbTodos.setText("TODOS");
        jcbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jcbTodos)
                                .addGap(53, 53, 53)
                                .addComponent(jcbActivo)
                                .addGap(51, 51, 51)
                                .addComponent(jcbInactivo)))
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbActivo)
                        .addComponent(jcbInactivo)
                        .addComponent(jcbTodos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTodosActionPerformed
        jcbActivo.setSelected(false);
        jcbInactivo.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jcbTodosActionPerformed

    private void jcbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActivoActionPerformed
        jcbInactivo.setSelected(false);
        jcbTodos.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jcbActivoActionPerformed

    private void jcbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInactivoActionPerformed
        jcbActivo.setSelected(false);
        jcbTodos.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jcbInactivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JCheckBox jcbInactivo;
    private javax.swing.JCheckBox jcbTodos;
    // End of variables declaration//GEN-END:variables
}
