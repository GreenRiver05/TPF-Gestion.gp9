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
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jmConsultarEquipos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 800));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1300, 800));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
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
        MenuMiembros.add(jmVerMiembros);

        jMenuBar1.add(MenuMiembros);

        MenuEquipos.setText("Equipos");
        MenuEquipos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MenuEquipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuEquipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuEquipos.setPreferredSize(new java.awt.Dimension(80, 25));

        jmCrearEquipos.setText("Crear Equipos");
        MenuEquipos.add(jmCrearEquipos);

        jmVerEquipos.setText("Ver Equipos");
        MenuEquipos.add(jmVerEquipos);

        jMenuBar1.add(MenuEquipos);

        MenuIncorporacion.setText("Gestion");
        MenuIncorporacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MenuIncorporacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuIncorporacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuIncorporacion.setPreferredSize(new java.awt.Dimension(115, 25));

        jMenuItem3.setText("Incorporar Miembros en Equipos");
        MenuIncorporacion.add(jMenuItem3);

        jMenuItem4.setText("Asignar Tareas");
        MenuIncorporacion.add(jMenuItem4);

        jMenuItem5.setText("Seguimiento de Tareas");
        MenuIncorporacion.add(jMenuItem5);

        jMenuItem6.setText("Seguimientos de Proyectos");
        MenuIncorporacion.add(jMenuItem6);

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
        
    }//GEN-LAST:event_jmCrearProyectoActionPerformed

    private void jmCrearMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearMiembrosActionPerformed
        
    }//GEN-LAST:event_jmCrearMiembrosActionPerformed

    private void jmConsultarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarEquiposActionPerformed
        
    }//GEN-LAST:event_jmConsultarEquiposActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //UIManager.setLookAndFeel(new AcrylLookAndFeel());  // plantillas 
                    //UIManager.setLookAndFeel(new GraphiteLookAndFeel());  // plantillas 
                    //UIManager.setLookAndFeel(new McWinLookAndFeel());  // plantillas 
                    //UIManager.setLookAndFeel(new NoireLookAndFeel());  // plantillas 
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
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jmConsultarEquipos;
    private javax.swing.JMenuItem jmCrearEquipos;
    private javax.swing.JMenuItem jmCrearMiembros;
    private javax.swing.JMenuItem jmCrearProyecto;
    private javax.swing.JMenuItem jmVerEquipos;
    private javax.swing.JMenuItem jmVerMiembros;
    private javax.swing.JMenuItem jmVerProyectos;
    // End of variables declaration//GEN-END:variables
}