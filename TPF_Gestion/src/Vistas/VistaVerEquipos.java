package Vistas;

import AccesoADatos.*;
import Entidades.Equipo;
import Entidades.Proyecto;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class VistaVerEquipos extends javax.swing.JInternalFrame {

  private DefaultTableModel modeloTabla = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
  
    private EquipoData proyecto = new EquipoData();
   
    private ArrayList<Equipo> listaTodosLosEquipos = new ArrayList();
    private ArrayList<Equipo> listaEquipo = new ArrayList();
   

    

    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList();
   
        columnas.add("Proyecto");
        columnas.add("Nombre");
       //columnas.add("FechaDeCreacion");
        for (Object c : columnas) { //se recorre el arrays para ir llenando los nombres de las columnas
            modeloTabla.addColumn(c);
        }
        jTable1.setModel(modeloTabla);

          


    }

    private void llenarTabla() {
        borrarFilas();
     

       
        
       if (jrActivos.isSelected() == true) {
           listaEquipo=proyecto.listarEquipos(true);
            for (Equipo p : listaEquipo) {
                modeloTabla.addRow(new Object[]{p.getProyecto().getNombre(),p.getNombre()});
            }
        }
        if (jrInactivos.isSelected() == true) {
           listaEquipo=proyecto.listarEquipos(false);
            for (Equipo p : listaEquipo) {
                modeloTabla.addRow(new Object[]{p.getProyecto().getNombre(),p.getNombre()});
            }
        }

    }

    private void borrarFilas() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    public VistaVerEquipos() {
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
        jrInactivos = new javax.swing.JRadioButton();
        jrActivos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(800, 700));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Castellar", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EQUIPOS");

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

        jrInactivos.setText("INACTIVOS");
        jrInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrInactivosActionPerformed(evt);
            }
        });

        jrActivos.setText("ACTIVOS");
        jrActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrActivosActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jrActivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrInactivos)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(567, 567, 567)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(108, 108, 108)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrActivos)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrInactivos)))
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
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

    private void jrActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrActivosActionPerformed
        jrInactivos.setSelected(false);
  
        llenarTabla();
    }//GEN-LAST:event_jrActivosActionPerformed

    private void jrInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrInactivosActionPerformed
        jrActivos.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jrInactivosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlEstudiante;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JRadioButton jrActivos;
    private javax.swing.JRadioButton jrInactivos;
    // End of variables declaration//GEN-END:variables
}
