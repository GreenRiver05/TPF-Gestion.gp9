package Vistas;

import Entidades.*;
import AccesoADatos.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VistaConsultarEquipos extends javax.swing.JInternalFrame {
    
    private ArrayList<Tarea> listaEquipos = new ArrayList();
    private TareaData taData = new TareaData();
    private EquipoData eqData = new EquipoData();
    
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("DNI");
        columnas.add("APELLIDO Y NOMBRE");
        columnas.add("ESTADO");
        columnas.add("TAREA");
        for (Object c : columnas) {
            modeloTabla.addColumn(c);
        }
        jtTabla.setModel(modeloTabla);

//        //ocultamos una columna para no mostrar el id, ya que al usuario no le interesa
//        TableColumn columna = jtTabla.getColumnModel().getColumn(0);
//        columna.setMaxWidth(0);
//        columna.setMinWidth(0);
//        columna.setPreferredWidth(0);
//        jtTabla.doLayout();
    }
    
    public VistaConsultarEquipos() {
        
        initComponents();
        setLocation(200, 15); //setear ubicacion
        llenarEquipos();
        armarCabecera();
        borrarFilas();
    }
    
    private void llenarEquipos() {
   
        for (Equipo eq : eqData.listarEquipos(true)) {
           
            jcEquipos.addItem(eq);
            
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
        Equipo elegido = (Equipo) jcEquipos.getSelectedItem();
        
        listaEquipos = taData.consultaInfoEquipo(elegido.getIdEquipo());
        for (Tarea e : listaEquipos) {
            modeloTabla.addRow(new Object[]{e.getIncorporacion().getMiembro().getDni(), e.getIncorporacion().getMiembro().getApellido() + " "
                + e.getIncorporacion().getMiembro().getNombre(), e.getIncorporacion().getMiembro().isEstado(), e.getNombre()});
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jcEquipos = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel1.setText("CONSULTAR EQUIPOS");
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 40));

        jtTabla.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTabla.setRowHeight(22);
        jScrollPane1.setViewportView(jtTabla);

        jcEquipos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jcEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEquiposActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jcEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEquiposActionPerformed
        llenarTabla();
    }//GEN-LAST:event_jcEquiposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Equipo> jcEquipos;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
}
