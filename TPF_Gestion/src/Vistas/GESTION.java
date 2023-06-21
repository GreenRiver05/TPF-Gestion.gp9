package Vistas;

import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GESTION extends javax.swing.JFrame {

    public GESTION() {
        initComponents();
        setLocationRelativeTo(null);
        //this.setExtendedState(GESTION.MAXIMIZED_BOTH);//MAXIMIXAR VENTANA
        this.setResizable(false);// NO ES RESIZABLE

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuProyectos = new javax.swing.JMenu();
        jmCrearProyecto = new javax.swing.JMenuItem();
        jmVerProyectos = new javax.swing.JMenuItem();
        MenuMiembros = new javax.swing.JMenu();
        jmCrearMiembros = new javax.swing.JMenuItem();
        jmVerMiembros = new javax.swing.JMenuItem();
        MenuEquipos = new javax.swing.JMenu();
        jmCrearEquipos = new javax.swing.JMenuItem();
        jmVerEquipos = new javax.swing.JMenuItem();
        MenuIncorporacion = new javax.swing.JMenu();
        jmIncorporarMiembros = new javax.swing.JMenuItem();
        jmAsignarTareas = new javax.swing.JMenuItem();
        jmSeguimientoTareas = new javax.swing.JMenuItem();
        jmSeguimientoDeProyectos = new javax.swing.JMenuItem();
        jmConsultarEquipos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 850));
        setPreferredSize(new java.awt.Dimension(1300, 850));

        jDesktopPane1.setMaximumSize(new java.awt.Dimension(1300, 850));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1300, 850));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );

        MenuProyectos.setText("Proyecto");
        MenuProyectos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MenuProyectos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuProyectos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuProyectos.setPreferredSize(new java.awt.Dimension(80, 25));

        jmCrearProyecto.setText("Crear Proyectos");
        jmCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearProyectoActionPerformed(evt);
            }
        });
        MenuProyectos.add(jmCrearProyecto);

        jmVerProyectos.setText("Ver Proyectos");
        jmVerProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVerProyectosActionPerformed(evt);
            }
        });
        MenuProyectos.add(jmVerProyectos);

        jMenuBar1.add(MenuProyectos);

        MenuMiembros.setText("Miembro");
        MenuMiembros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MenuMiembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuMiembros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuMiembros.setPreferredSize(new java.awt.Dimension(80, 25));

        jmCrearMiembros.setText("Crear Miembros");
        jmCrearMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearMiembrosActionPerformed(evt);
            }
        });
        MenuMiembros.add(jmCrearMiembros);

        jmVerMiembros.setText("Ver Miembros");
        jmVerMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVerMiembrosActionPerformed(evt);
            }
        });
        MenuMiembros.add(jmVerMiembros);

        jMenuBar1.add(MenuMiembros);

        MenuEquipos.setText("Equipos");
        MenuEquipos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MenuEquipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuEquipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuEquipos.setPreferredSize(new java.awt.Dimension(80, 25));

        jmCrearEquipos.setText("Crear Equipos");
        jmCrearEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearEquiposActionPerformed(evt);
            }
        });
        MenuEquipos.add(jmCrearEquipos);

        jmVerEquipos.setText("Ver Equipos");
        jmVerEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVerEquiposActionPerformed(evt);
            }
        });
        MenuEquipos.add(jmVerEquipos);

        jMenuBar1.add(MenuEquipos);

        MenuIncorporacion.setText("Gestion");
        MenuIncorporacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MenuIncorporacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuIncorporacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuIncorporacion.setPreferredSize(new java.awt.Dimension(115, 25));

        jmIncorporarMiembros.setText("Incorporar Miembros en Equipos");
        jmIncorporarMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIncorporarMiembrosActionPerformed(evt);
            }
        });
        MenuIncorporacion.add(jmIncorporarMiembros);

        jmAsignarTareas.setText("Asignar Tareas");
        jmAsignarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAsignarTareasActionPerformed(evt);
            }
        });
        MenuIncorporacion.add(jmAsignarTareas);

        jmSeguimientoTareas.setText("Seguimiento de Tareas");
        jmSeguimientoTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeguimientoTareasActionPerformed(evt);
            }
        });
        MenuIncorporacion.add(jmSeguimientoTareas);

        jmSeguimientoDeProyectos.setText("Seguimientos de Proyectos");
        jmSeguimientoDeProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeguimientoDeProyectosActionPerformed(evt);
            }
        });
        MenuIncorporacion.add(jmSeguimientoDeProyectos);

        jmConsultarEquipos.setText("Consultar Equipos");
        jmConsultarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarEquiposActionPerformed(evt);
            }
        });
        MenuIncorporacion.add(jmConsultarEquipos);

        jMenuBar1.add(MenuIncorporacion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearProyectoActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaCrearProyecto fProyecto = new VistaCrearProyecto();
        jDesktopPane1.add(fProyecto);
        fProyecto.setVisible(true);

    }//GEN-LAST:event_jmCrearProyectoActionPerformed

    private void jmCrearMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearMiembrosActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaCrearMiembro fMiembro = new VistaCrearMiembro();
        jDesktopPane1.add(fMiembro);
        fMiembro.setVisible(true);
    }//GEN-LAST:event_jmCrearMiembrosActionPerformed

    private void jmConsultarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarEquiposActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaConsultarEquipos consultaEquipos = new VistaConsultarEquipos();
        jDesktopPane1.add(consultaEquipos);
        consultaEquipos.setVisible(true);

    }//GEN-LAST:event_jmConsultarEquiposActionPerformed

    private void jmVerProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVerProyectosActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaVerProyectos fProyecto = new VistaVerProyectos();
        jDesktopPane1.add(fProyecto);
        fProyecto.setVisible(true);
    }//GEN-LAST:event_jmVerProyectosActionPerformed

    private void jmSeguimientoDeProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeguimientoDeProyectosActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaSeguimientoDeProyecto seguimientoProyecto = new VistaSeguimientoDeProyecto();
        jDesktopPane1.add(seguimientoProyecto);
        seguimientoProyecto.setVisible(true);
    }//GEN-LAST:event_jmSeguimientoDeProyectosActionPerformed

    private void jmCrearEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearEquiposActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaCrearEquipos crearEquipos = new VistaCrearEquipos();
        jDesktopPane1.add(crearEquipos);
        crearEquipos.setVisible(true);
    }//GEN-LAST:event_jmCrearEquiposActionPerformed

    private void jmVerEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVerEquiposActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaVerEquipos verEquipos = new VistaVerEquipos();
        jDesktopPane1.add(verEquipos);
        verEquipos.setVisible(true);
    }//GEN-LAST:event_jmVerEquiposActionPerformed

    private void jmVerMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVerMiembrosActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaVerMiembro fMiembro = new VistaVerMiembro();
        jDesktopPane1.add(fMiembro);
        fMiembro.setVisible(true);
    }//GEN-LAST:event_jmVerMiembrosActionPerformed

    private void jmAsignarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAsignarTareasActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaAsignarTareas tarea = new VistaAsignarTareas();
        jDesktopPane1.add(tarea);
        tarea.setVisible(true);
    }//GEN-LAST:event_jmAsignarTareasActionPerformed

    private void jmSeguimientoTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeguimientoTareasActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaSeguimientosDeTarea verTareas = new VistaSeguimientosDeTarea();
        jDesktopPane1.add(verTareas);
        verTareas.setVisible(true);
    }//GEN-LAST:event_jmSeguimientoTareasActionPerformed

    private void jmIncorporarMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmIncorporarMiembrosActionPerformed
     
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaIncorporarMiembros incorporar = new VistaIncorporarMiembros();
        jDesktopPane1.add(incorporar);
        incorporar.setVisible(true);
    }//GEN-LAST:event_jmIncorporarMiembrosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new TextureLookAndFeel());  // plantillas 
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(GESTION.class.getName()).log(Level.SEVERE, null, ex);
                }
                new GESTION().setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuEquipos;
    private javax.swing.JMenu MenuIncorporacion;
    private javax.swing.JMenu MenuMiembros;
    private javax.swing.JMenu MenuProyectos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmAsignarTareas;
    private javax.swing.JMenuItem jmConsultarEquipos;
    private javax.swing.JMenuItem jmCrearEquipos;
    private javax.swing.JMenuItem jmCrearMiembros;
    private javax.swing.JMenuItem jmCrearProyecto;
    private javax.swing.JMenuItem jmIncorporarMiembros;
    private javax.swing.JMenuItem jmSeguimientoDeProyectos;
    private javax.swing.JMenuItem jmSeguimientoTareas;
    private javax.swing.JMenuItem jmVerEquipos;
    private javax.swing.JMenuItem jmVerMiembros;
    private javax.swing.JMenuItem jmVerProyectos;
    // End of variables declaration//GEN-END:variables
}
