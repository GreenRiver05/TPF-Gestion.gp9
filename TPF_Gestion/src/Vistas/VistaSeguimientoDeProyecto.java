package Vistas;

import AccesoADatos.*;
import Entidades.*;
import java.awt.Color;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VistaSeguimientoDeProyecto extends javax.swing.JInternalFrame {

    private ArrayList<Tarea> listaTarea = new ArrayList();
    private ProyectoData proData = new ProyectoData();
    private TareaData taData = new TareaData();
    private MiembroData mieData = new MiembroData();

    public VistaSeguimientoDeProyecto() {
        initComponents();
        setLocation(200, 15); // ubicacion de la ventana
        armarCabecera();
        llenarProyectos();
        jlCartelSINO.setVisible(false);
        jlCartelFinalizadas.setVisible(false);
        opcionNO.setVisible(false);
        opcionSI.setVisible(false);
        jbFINALIZAR.setVisible(false);
    }
    private DefaultTableModel modeloTabla = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) { // metodo para que no se edite la tabla
            return false;
        }

    };

    private void armarCabecera() { // Modificamos la tabla, dependiendo si esta seleccionado el radio button Miembro

        if (jrbMiembros.isSelected()) {
            modeloTabla.addColumn("TAREA");
            modeloTabla.addColumn("ESTADO");

        } else {

            modeloTabla.addColumn("TAREA");
            modeloTabla.addColumn("ESTADO");
            modeloTabla.addColumn("MIEMBRO");

        }

        jtTabla.setModel(modeloTabla);

        jtTabla.getColumnModel().getColumn(0).setPreferredWidth(70); // Le seteamos el largo a las columnas
        jtTabla.getColumnModel().getColumn(1).setPreferredWidth(45);
        jtTabla.getColumnModel().getColumn(2).setPreferredWidth(250);

        if (jtTabla.getColumnModel().getColumnCount() > 0) {
            jtTabla.getColumnModel().getColumn(0).setResizable(false); // desactivamos el Resizable a todas las columnas
            jtTabla.getColumnModel().getColumn(1).setResizable(false);
            jtTabla.getColumnModel().getColumn(2).setResizable(false);
        }

        // Le cambiamos color al seleccionar las filas, la configuramos para que no sen editables
        // Solo se puede seleccionar una fila, le cambiamos el tamañano a cada columnas, y le desactivamos el rezisable
        // Le colocamos un Cursor pointer, le cambiamos el color a la cuadricula
    }
    //ocultamos una columna para no mostrar el id, ya que al usuario no le interesa

    private void llenarProyectos() { // Llenar ComboBox con Proyectos 
        for (Proyecto pro : proData.listarTodosLosProyectos()) {
            jcProyectos.addItem(pro);
        }
    }

    private void llenarMiembros() { // Llenar ComboBox con Miembros
        jcProyectos.removeAll(); // removemos todo el contenido del ComboBox y lo volvemos a llenar con datos nuevos
        Proyecto nombre = (Proyecto) jcProyectos.getSelectedItem(); // obtenemos el nombre del proyecto del ComboBox Superior
        for (Miembro miembro : mieData.buscarMiembrosXProyecto(nombre.getNombre())) { //Mandamos por paremetros el nombre obtenido del proyecto
            jcMiembros.addItem(miembro); // recorremos la lista de miembro y lo agregamos al ComboBox
        }
    }

    private void borrarFilas() { // borramos filas de la tabla
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    private void habilitarFinalizado() {
        jlCartelSINO.setVisible(true);
        jlCartelFinalizadas.setVisible(true);
        opcionNO.setVisible(true);
        opcionSI.setVisible(true);
        opcionNO.setSelected(false);
        opcionSI.setSelected(false);
        jbFINALIZAR.setVisible(true);
        jbFINALIZAR.setEnabled(false);
    }

    private void desactivarFinalizado() {
        jlCartelSINO.setVisible(false);
        jlCartelFinalizadas.setVisible(false);
        opcionNO.setVisible(false);
        opcionSI.setVisible(false);
        jbFINALIZAR.setVisible(false);
    }

    private void llenarTabla() {
        borrarFilas(); // primero borramos el contenido para luego agregar nuevo

        if (jrbMiembros.isSelected()) { // si el radio butom de miembro esta seleccionado, se llena la tabla con tarea de ese miembro
            Proyecto nombre = (Proyecto) jcProyectos.getSelectedItem();
            Miembro miembro = (Miembro) jcMiembros.getSelectedItem(); // obtenemos el miembro del ComboBox
            listaTarea = taData.obtenerTareasXMiembrosYProyecto(miembro.getDni(), nombre.getNombre()); // pasamos el dni de ese miembro seleccionado
            for (Tarea e : listaTarea) { // recorremos las tareas y las agregamos a la tabla

                if (jcbTodas.isSelected()) { // muestra las tareas si esta seleccionado el radio button TODAS
                    if (e.isEstado()) {
                        modeloTabla.addRow(new Object[]{e.getNombre(), " EN PROCESO "});
                    } else {
                        modeloTabla.addRow(new Object[]{e.getNombre(), " FINALIZADA "});
                    }

                } else if (jcbTareasEnProcesos.isSelected()) { // muestra las tareas si esta seleccionado el radio button en PROCESO
                    if (e.isEstado()) {
                        modeloTabla.addRow(new Object[]{e.getNombre(), " EN PROCESO "});
                    }

                } else if (jcbTareasFinalizadas.isSelected()) { // muestra las tareas si esta seleccionado el radio button en FINALIZADO
                    if (!e.isEstado()) {
                        modeloTabla.addRow(new Object[]{e.getNombre(), " FINALIZADA "});
                    }
                }
            }

        } else { // si el radio butom de miembro no esta seleccionado, se llena la tabla con tareas de ese proyecto

            Proyecto nombre = (Proyecto) jcProyectos.getSelectedItem(); //obtenemos el nombre del proyecto del ComboBox
            listaTarea = taData.obtenerTareasXProyectos(nombre.getNombre()); // pasamos ese nombre obtenido
            for (Tarea e : listaTarea) { // recorremos las tareas y las agregamos a la tabla

                if (jcbTodas.isSelected()) {  // hace todo lo mismo que el otro
                    if (e.isEstado()) {
                        modeloTabla.addRow(new Object[]{e.getNombre(), " EN PROCESO ", e.getIncorporacion().getMiembro().getApellido() + " "
                            + e.getIncorporacion().getMiembro().getNombre() + " " + e.getIncorporacion().getMiembro().getDni()});

                        habilitarFinalizado();
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
                    if (!e.isEstado()) {
                        modeloTabla.addRow(new Object[]{e.getNombre(), " FINALIZADA ", e.getIncorporacion().getMiembro().getApellido() + " "
                            + e.getIncorporacion().getMiembro().getNombre() + " " + e.getIncorporacion().getMiembro().getDni()});
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
        jtTabla = new javax.swing.JTable();
        jcbTareasFinalizadas = new javax.swing.JCheckBox();
        jcbTareasEnProcesos = new javax.swing.JCheckBox();
        jcMiembros = new javax.swing.JComboBox<>();
        jrbMiembros = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbTodas = new javax.swing.JCheckBox();
        jcProyectos = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        opcionSI = new javax.swing.JCheckBox();
        jlCartelFinalizadas = new javax.swing.JLabel();
        jlCartelSINO = new javax.swing.JLabel();
        opcionNO = new javax.swing.JCheckBox();
        jbFINALIZAR = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jlEstado = new javax.swing.JLabel();

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

        jcMiembros.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jcMiembros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMiembrosActionPerformed(evt);
            }
        });

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

        jcProyectos.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jcProyectos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProyectosActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        opcionSI.setText("SI");
        opcionSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionSIActionPerformed(evt);
            }
        });

        jlCartelFinalizadas.setText("Todas las tareas se encuentran Finalizada");

        jlCartelSINO.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlCartelSINO.setText("Desea Finalizar el Proyecto :");

        opcionNO.setText("NO");
        opcionNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionNOActionPerformed(evt);
            }
        });

        jbFINALIZAR.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jbFINALIZAR.setText("FINALIZAR PROYECTO");
        jbFINALIZAR.setEnabled(false);

        jLabel4.setText("ESTADO:");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(189, 179, 179));

        jlEstado.setBackground(new java.awt.Color(0, 0, 0));
        jlEstado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jlEstado.setForeground(new java.awt.Color(204, 0, 204));
        jlEstado.setText("EN PROCESO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jlCartelFinalizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbMiembros)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlCartelSINO, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcionNO, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opcionSI, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jbFINALIZAR)
                        .addGap(129, 129, 129))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jcbTareasFinalizadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jcbTareasEnProcesos)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbTodas)
                        .addGap(204, 204, 204)))
                .addComponent(jcMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jcProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbTareasFinalizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbTareasEnProcesos)))
                    .addComponent(jcMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jlCartelFinalizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opcionNO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(opcionSI)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbFINALIZAR, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlCartelSINO)
                                .addGap(26, 26, 26)))
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTareasFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTareasFinalizadasActionPerformed
        jcbTareasEnProcesos.setSelected(false);
        jcbTodas.setSelected(false);
        llenarTabla();
        desactivarFinalizado();
    }//GEN-LAST:event_jcbTareasFinalizadasActionPerformed

    private void jcbTareasEnProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTareasEnProcesosActionPerformed
        if (jcbTareasEnProcesos.isSelected()) {
            jcbTareasFinalizadas.setSelected(false);
            jcbTodas.setSelected(false);
            llenarTabla();
            desactivarFinalizado();
        }

    }//GEN-LAST:event_jcbTareasEnProcesosActionPerformed

    private void jrbMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMiembrosActionPerformed
        borrarFilas();
        TableColumn columna = jtTabla.getColumnModel().getColumn(2);
        if (jrbMiembros.isSelected()) {
            llenarMiembros();
            jcMiembros.setEnabled(true);

            columna.setMaxWidth(0);
            columna.setMinWidth(0);
            columna.setPreferredWidth(0);
            jtTabla.doLayout();
        } else {
            jcMiembros.removeAllItems();
            jcMiembros.setEnabled(false);
            columna.setMaxWidth(250);
            columna.setMinWidth(250);
            columna.setPreferredWidth(250);
            jtTabla.doLayout();

        }
        desactivarFinalizado();
    }//GEN-LAST:event_jrbMiembrosActionPerformed

    private void jcbTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTodasActionPerformed
        jcbTareasEnProcesos.setSelected(false);
        jcbTareasFinalizadas.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jcbTodasActionPerformed

    private void jcMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMiembrosActionPerformed
        jcbTareasEnProcesos.setSelected(false);
        jcbTareasFinalizadas.setSelected(false);
        jcbTodas.setSelected(false);
        desactivarFinalizado();

    }//GEN-LAST:event_jcMiembrosActionPerformed

    private void jcProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProyectosActionPerformed
        jrbMiembros.setSelected(false);
        jcMiembros.removeAllItems();
        jcMiembros.setEnabled(false);
        jcbTareasEnProcesos.setSelected(false);
        jcbTareasFinalizadas.setSelected(false);
        jcbTodas.setSelected(false);
        borrarFilas();
        Proyecto nombre = (Proyecto) jcProyectos.getSelectedItem();
        if (nombre.isEstado()) {
            jlEstado.setText("EN PROCESO");
            jlEstado.setForeground(new java.awt.Color(204, 0, 204));
        } else {
            jlEstado.setText("FINALIZADO");
            jlEstado.setForeground(new java.awt.Color(0, 153, 0));

        }
        desactivarFinalizado();
    }//GEN-LAST:event_jcProyectosActionPerformed

    private void opcionNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionNOActionPerformed
        opcionSI.setSelected(false);
        jbFINALIZAR.setEnabled(false);
    }//GEN-LAST:event_opcionNOActionPerformed

    private void opcionSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionSIActionPerformed
        opcionNO.setSelected(false);
        jbFINALIZAR.setEnabled(true);
    }//GEN-LAST:event_opcionSIActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbFINALIZAR;
    private javax.swing.JComboBox<Miembro> jcMiembros;
    private javax.swing.JComboBox<Proyecto> jcProyectos;
    private javax.swing.JCheckBox jcbTareasEnProcesos;
    private javax.swing.JCheckBox jcbTareasFinalizadas;
    private javax.swing.JCheckBox jcbTodas;
    private javax.swing.JLabel jlCartelFinalizadas;
    private javax.swing.JLabel jlCartelSINO;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JRadioButton jrbMiembros;
    private javax.swing.JTable jtTabla;
    private javax.swing.JCheckBox opcionNO;
    private javax.swing.JCheckBox opcionSI;
    // End of variables declaration//GEN-END:variables
}
