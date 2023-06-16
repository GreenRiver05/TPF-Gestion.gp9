package Vistas;

import AccesoADatos.*;
import Entidades.Proyecto;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


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
   
        columnas.add("Nombre");
        columnas.add("Descripcion");
//         columnas.add("Fecha Inicial");
        columnas.add("Estado");
        for (Object c : columnas) { //se recorre el arrays para ir llenando los nombres de las columnas
            modeloTabla.addColumn(c);
        }
        jTable1.setModel(modeloTabla);

          


    }

    private void llenarTabla() {
        borrarFilas();
     

        if (JrTodos.isSelected() == true) {
           listaTodosLosProyectos=proyecto.listarTodosLosProyectos();
            for (Proyecto p : listaTodosLosProyectos) {
                modeloTabla.addRow(new Object[]{p.getNombre(),p.getDescripcion(),p.isEstado()});
            }
        }
        
       if (jrEnProceso.isSelected() == true) {
           listaProyecto=proyecto.listarProyectos(true);
            for (Proyecto p : listaProyecto) {
                modeloTabla.addRow(new Object[]{p.getNombre(),p.getDescripcion(),p.isEstado()});
            }
        }
        if (jrFinalizado.isSelected() == true) {
           listaProyecto=proyecto.listarProyectos(false);
            for (Proyecto p : listaProyecto) {
                modeloTabla.addRow(new Object[]{p.getNombre(),p.getDescripcion(),p.isEstado()});
            }
        }

    }

    private void borrarFilas() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    public VistaVerProyectos() {
        initComponents();
        armarCabecera();
        borrarFilas();
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlEstudiante = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jrFinalizado = new javax.swing.JRadioButton();
        jrEnProceso = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JrTodos = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(800, 700));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Castellar", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Inscripcion");

        jlNombre.setBackground(new java.awt.Color(51, 51, 51));
        jlNombre.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 102, 0));
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlEstudiante.setBackground(new java.awt.Color(51, 51, 51));
        jlEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        jlEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setFont(new java.awt.Font("Castellar", 1, 17)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalir3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("LISTADO DE MATERIAS");

        jrFinalizado.setText("Finalizado");
        jrFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrFinalizadoActionPerformed(evt);
            }
        });

        jrEnProceso.setText("En proceso");
        jrEnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEnProcesoActionPerformed(evt);
            }
        });

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
                "ID", "NOMBRE", "AÑO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
        }

        JrTodos.setText("Todos los proyectos");
        JrTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(567, 567, 567)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(jrEnProceso)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jrFinalizado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JrTodos)))
                    .addGap(73, 73, 73)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(78, 78, 78)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrEnProceso)
                            .addComponent(jrFinalizado)
                            .addComponent(JrTodos))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalir3ActionPerformed
        dispose();
    }//GEN-LAST:event_jSalir3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        if (jrEnProceso.isSelected() == true) {
//            jbAnularInscripcion.setEnabled(true);
//        }
//        if (jrFinalizado.isSelected() == true) {
//            jbInscribir.setEnabled(true);
//        }
//
    }//GEN-LAST:event_jTable1MouseClicked

    private void jrEnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEnProcesoActionPerformed
        jrFinalizado.setSelected(false);
        JrTodos.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jrEnProcesoActionPerformed

    private void jrFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrFinalizadoActionPerformed
        jrEnProceso.setSelected(false);
        JrTodos.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jrFinalizadoActionPerformed

    private void JrTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrTodosActionPerformed
       jrFinalizado.setSelected(false);
        jrEnProceso.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_JrTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JrTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlEstudiante;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JRadioButton jrEnProceso;
    private javax.swing.JRadioButton jrFinalizado;
    // End of variables declaration//GEN-END:variables
}
