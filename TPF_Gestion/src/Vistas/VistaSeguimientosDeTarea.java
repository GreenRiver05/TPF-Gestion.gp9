package Vistas;

import Entidades.*;
import AccesoADatos.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VistaSeguimientosDeTarea extends javax.swing.JInternalFrame {

    private ArrayList<Comentarios> listaComentarios = new ArrayList();
    private ArrayList<Tarea> listaTareas = new ArrayList();
    private ProyectoData proData = new ProyectoData();
    private TareaData taData = new TareaData();
    private MiembroData mieData = new MiembroData();
    private ComentarioData comData = new ComentarioData();

    private DefaultTableModel modeloTablaTarea = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private DefaultTableModel modeloTablaComentario = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaSeguimientosDeTarea() {
        initComponents();
        setLocation(200, 15);
        llenarProyectos();
        armarCabeceraComentario();
        armarCabeceraTareas();

    }

    public void llenarProyectos() {
        for (Proyecto proyecto : proData.listarTodosLosProyectos()) {
            boxProyecto.addItem(proyecto);
        }
    }

    private void borrarFilasComentario() {
        int filas = modeloTablaComentario.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTablaComentario.removeRow(i);
        }
    }

    private void borrarFilasTarea() {
        int filas = modeloTablaTarea.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTablaTarea.removeRow(i);
        }
    }

    private void armarCabeceraComentario() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("COMENTARIO");
        columnas.add("AVANCE");
        for (Object c : columnas) {
            modeloTablaComentario.addColumn(c);
        }
        jtComentarios.setModel(modeloTablaComentario);

    }

    private void armarCabeceraTareas() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("ID");
        columnas.add("NOMBRE");
        columnas.add("FECHA COMIENZO");
        columnas.add("FECHA CIERRE");
        columnas.add("ESTADO");
        for (Object c : columnas) {
            modeloTablaTarea.addColumn(c);
        }
        jtTarea.setModel(modeloTablaTarea);

    }

    public void restaurar() {
        jtfComentario.setText("");
        jFechaAvance.setDate(null);
        jbRegistrar.setEnabled(false);
        borrarFilasComentario();
        borrarFilasTarea();
        jtfComentario.setText("");
        jFechaAvance.setDate(null);
        jbRegistrar.setEnabled(false);
    }

    public void llenarTablaComentario() {
        borrarFilasComentario();
        int filaElegida = jtTarea.getSelectedRow();
        int id = (Integer) jtTarea.getValueAt(filaElegida, 0);
        for (Comentarios c : comData.listarComentariosXTarea(id)) {
            modeloTablaComentario.addRow(new Object[]{c.getComentario(), c.getAvance()});
        }

    }

    public void llenarTablaTarea() {
        borrarFilasTarea();
        Proyecto nombre = (Proyecto) boxProyecto.getSelectedItem();
        listaTareas = taData.obtenerTareasXProyectos(nombre.getNombre());
        for (Tarea t : listaTareas) {

            if (jcTODAS.isSelected()) {
                if (t.isEstado()) {
                    modeloTablaTarea.addRow(new Object[]{t.getIdTarea(), t.getNombre(), t.getComienzo(), t.getCierre(), "EN PROGRESO"});
                } else {
                    modeloTablaTarea.addRow(new Object[]{t.getIdTarea(), t.getNombre(), t.getComienzo(), t.getCierre(), "COMPLETADA"});
                }
            } else if (jcProgresos.isSelected()) {
                if (t.isEstado()) {
                    modeloTablaTarea.addRow(new Object[]{t.getIdTarea(), t.getNombre(), t.getComienzo(), t.getCierre(), "EN PROGRESO"});
                }
            } else if (jcCompletadas.isSelected()) {
                if (!t.isEstado()) {
                    modeloTablaTarea.addRow(new Object[]{t.getIdTarea(), t.getNombre(), t.getComienzo(), t.getCierre(), "COMPLETADA"});
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcCompletadas = new javax.swing.JCheckBox();
        jcTODAS = new javax.swing.JCheckBox();
        jcProgresos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTarea = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtComentarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfComentario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFechaAvance = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jbRegistrar = new javax.swing.JButton();
        jbFinalizarTarea = new javax.swing.JButton();
        boxProyecto = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jbEnProgreso = new javax.swing.JButton();
        jlErrorComentario = new javax.swing.JLabel();
        jlErrorFecha = new javax.swing.JLabel();
        jlErrorTarea = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 850));
        setMinimumSize(new java.awt.Dimension(900, 850));
        setPreferredSize(new java.awt.Dimension(900, 750));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("LISTAR TAREAS");

        jcCompletadas.setText("COMPLETADAS");
        jcCompletadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCompletadasActionPerformed(evt);
            }
        });

        jcTODAS.setText("TODAS");
        jcTODAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTODASActionPerformed(evt);
            }
        });

        jcProgresos.setText("EN PROGRESO");
        jcProgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProgresosActionPerformed(evt);
            }
        });

        jtTarea.setBackground(new java.awt.Color(51, 51, 51));
        jtTarea.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jtTarea.setForeground(new java.awt.Color(255, 255, 255));
        jtTarea.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTarea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtTarea.setFocusCycleRoot(true);
        jtTarea.setFocusable(false);
        jtTarea.setGridColor(new java.awt.Color(241, 226, 226));
        jtTarea.setRowHeight(30);
        jtTarea.setSelectionBackground(new java.awt.Color(241, 226, 226));
        jtTarea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTareaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTarea);

        jtComentarios.setBackground(new java.awt.Color(51, 51, 51));
        jtComentarios.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jtComentarios.setForeground(new java.awt.Color(255, 255, 255));
        jtComentarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jtComentarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtComentarios.setFocusCycleRoot(true);
        jtComentarios.setFocusable(false);
        jtComentarios.setGridColor(new java.awt.Color(241, 226, 226));
        jtComentarios.setRowHeight(30);
        jtComentarios.setSelectionBackground(new java.awt.Color(241, 226, 226));
        jtComentarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jtComentarios);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("COMENTARIOS Y AVANCE");

        jtfComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfComentarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setText("COMENTARIO :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setText("FECHA DE AVANCE :");

        jbRegistrar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegistrar.setFont(new java.awt.Font("Engravers MT", 1, 13)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrar.setText("REGISTRAR COMENTARIO");
        jbRegistrar.setEnabled(false);
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });

        jbFinalizarTarea.setBackground(new java.awt.Color(51, 51, 51));
        jbFinalizarTarea.setFont(new java.awt.Font("Engravers MT", 1, 13)); // NOI18N
        jbFinalizarTarea.setForeground(new java.awt.Color(255, 255, 255));
        jbFinalizarTarea.setText("FINALIZAR TAREA");
        jbFinalizarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarTareaActionPerformed(evt);
            }
        });

        boxProyecto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        boxProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxProyectoActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("salir");

        jLabel5.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        jLabel5.setText("PROYECTOS:");

        jbEnProgreso.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        jbEnProgreso.setText("EN PROGRESO");
        jbEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnProgresoActionPerformed(evt);
            }
        });

        jlErrorComentario.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jlErrorComentario.setForeground(new java.awt.Color(255, 0, 51));

        jlErrorFecha.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jlErrorFecha.setForeground(new java.awt.Color(255, 0, 51));

        jlErrorTarea.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jlErrorTarea.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbFinalizarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbEnProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jcTODAS)
                                .addGap(18, 18, 18)
                                .addComponent(jcCompletadas)
                                .addGap(18, 18, 18)
                                .addComponent(jcProgresos))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jlErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFechaAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbRegistrar)
                                        .addGap(73, 73, 73))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlErrorComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jlErrorTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcTODAS)
                    .addComponent(jcCompletadas)
                    .addComponent(jcProgresos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbEnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jbFinalizarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlErrorComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlErrorTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFechaAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jlErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcTODASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTODASActionPerformed
        jcCompletadas.setSelected(false);
        jcProgresos.setSelected(false);
        restaurar();
        llenarTablaTarea();
    }//GEN-LAST:event_jcTODASActionPerformed

    private void jcCompletadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCompletadasActionPerformed
        jcTODAS.setSelected(false);
        jcProgresos.setSelected(false);
        restaurar();
        llenarTablaTarea();
    }//GEN-LAST:event_jcCompletadasActionPerformed

    private void jcProgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProgresosActionPerformed
        jcTODAS.setSelected(false);
        jcCompletadas.setSelected(false);
        restaurar();
        llenarTablaTarea();
    }//GEN-LAST:event_jcProgresosActionPerformed

    private void jbFinalizarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarTareaActionPerformed
        int filaElegida = jtTarea.getSelectedRow();
        int id = (Integer) jtTarea.getValueAt(filaElegida, 0);
        restaurar();
        taData.finalizada(id);
        llenarTablaTarea();
    }//GEN-LAST:event_jbFinalizarTareaActionPerformed

    private void jtTareaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTareaMouseClicked
        llenarTablaComentario();

    }//GEN-LAST:event_jtTareaMouseClicked

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed
        jlErrorFecha.setText("");
        jlErrorTarea.setText("");
        try {
            Tarea tarea = new Tarea();
            String texto = jtfComentario.getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = formatoFecha.format(jFechaAvance.getDate());
            LocalDate avance = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            int filaElegida = jtTarea.getSelectedRow();
            int id = (Integer) jtTarea.getValueAt(filaElegida, 0);
            tarea.setIdTarea(id);
            Comentarios comentario = new Comentarios(tarea, texto, avance);
            comData.crearComentario(comentario);
            llenarTablaComentario();
            jtfComentario.setText("");
            jFechaAvance.setDate(null);
            jbRegistrar.setEnabled(false);

        } catch (ArrayIndexOutOfBoundsException ex) {
            jlErrorTarea.setText("DEBE SELECCIONAR UNA TAREA");
        } catch (NullPointerException ex) {
            jlErrorFecha.setText("INGRESE FECHA VALIDA");
        }

    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jbEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnProgresoActionPerformed
        int filaElegida = jtTarea.getSelectedRow();
        int id = (Integer) jtTarea.getValueAt(filaElegida, 0);
        restaurar();
        taData.enProceso(id);
        llenarTablaTarea();
    }//GEN-LAST:event_jbEnProgresoActionPerformed

    private void boxProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProyectoActionPerformed
        jcTODAS.setSelected(false);
        jcProgresos.setSelected(false);
        jcCompletadas.setSelected(false);
        restaurar();
        borrarFilasComentario();
        borrarFilasTarea();
    }//GEN-LAST:event_boxProyectoActionPerformed

    private void jtfComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfComentarioActionPerformed
        if (jtfComentario.getText().equals("")) {
            jlErrorComentario.setText("INGRESE COMENTARIO POR FAVOR");
            jbRegistrar.setEnabled(false);
        } else {
            jlErrorComentario.setText("");
            jbRegistrar.setEnabled(true);
        }
    }//GEN-LAST:event_jtfComentarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Proyecto> boxProyecto;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jFechaAvance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbEnProgreso;
    private javax.swing.JButton jbFinalizarTarea;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JCheckBox jcCompletadas;
    private javax.swing.JCheckBox jcProgresos;
    private javax.swing.JCheckBox jcTODAS;
    private javax.swing.JLabel jlErrorComentario;
    private javax.swing.JLabel jlErrorFecha;
    private javax.swing.JLabel jlErrorTarea;
    private javax.swing.JTable jtComentarios;
    private javax.swing.JTable jtTarea;
    private javax.swing.JTextField jtfComentario;
    // End of variables declaration//GEN-END:variables
}
