package tpf_gestion;

import AccesoADatos.*;
import Entidades.*;
import java.time.LocalDate;

public class TPF_Gestion {

    public static void main(String[] args) {

//------------------------------------------------------------------------------PROYECTO ---------------------------- FUNCA 
//..........CREAR //
//        Proyecto proyecto = new Proyecto("Pruebas", "Probando Main", LocalDate.of(2023, 6, 10), true);
//        ProyectoData proyData = new ProyectoData();
//        proyData.crearProyectos(proyecto);
//.........BUSCAR //
//        ProyectoData proyData = new ProyectoData();
//        Proyecto proyecto2 = proyData.buscarPorNombre("viaje");
//        System.out.println("METODO BUSCAR\n\n");
//        System.out.println("Id: " + proyecto2.getIdProyecto() + "   Nombre: " + proyecto2.getNombre() + "   Descripcion: " 
//                + proyecto2.getDescripcion() + "    Fecha Inicial: " + proyecto2.getFechaInicial() + "  Estado: " + proyecto2.isEstado());        
//.........LISTAR //
//        ProyectoData proyData = new ProyectoData();
//        for ( Proyecto pro :  proyData.listarProyectos(true)){
//             System.out.println("\nId: " + pro.getIdProyecto() + "  Nombre: " + pro.getNombre() + " Descripcion: " 
//                + pro.getDescripcion() + "  Fecha Inicial: " + pro.getFechaInicial() + "    Estado: " + pro.isEstado());
//        }
//........MODIFICAR //
//        ProyectoData proyData = new ProyectoData();
//        Proyecto proyecto1 = new Proyecto(17,"probando", "Probando Modificaciones", LocalDate.of(2023, 6, 10), true);
//        proyData.modificarProyecto(proyecto1);
//........FINALIZAR Y PROCESO //
//        ProyectoData proyData = new ProyectoData();
//        proyData.enProceso(1);
//        proyData.enProceso(15);
//        proyData.finalizado(14);
//        proyData.finalizado(16);
//------------------------------------------------------------------------------MIEMBRO---------------------------- FUNCA
//        ................ CREAR MIEMBRO ................  
//        Miembro mie = new Miembro(2323323, "Urquiza", "Pepe",true );
//        MiembroData md = new MiembroData();
//        md.crearMiembro(mie);
//        ................ BUSCAR MIEMBRO POR DNI ................  
//        MiembroData md = new MiembroData();
//        System.out.println("Miembro: " + md.buscarMiembroDNI(35715982).toString());
//        ................ BUSCAR MIEMBRO POR APELLIDO ................  
//        MiembroData md = new MiembroData();
//        System.out.println("Apellido: " + md.buscarMiembroPorApellido("sosa").toString());
//        ................ LISTAR MIEMBROS ................  
//        MiembroData md = new MiembroData();
//        System.out.println("Miembros: ");
//        for (Miembro mie : md.listarMiembrosPorEstado(true)){
//            System.out.println(mie.toString());
//         }
//        ................ BAJA Y ALTA MIEMBRO ................ 
//        MiembroData md = new MiembroData();
//        md.bajaMiembro(50);
//        md.altaMiembro(50);
//        ................ MODIFICAR MIEMBRO ................ 
//        Miembro mie = new Miembro (12, 1234567, "Ramirez", "Pepe", true);
//        MiembroData md = new MiembroData();
//        md.modificarMiembro(mie);
//------------------------------------------------------------------------------EQUIPO----------------------------FUNCA
//.....................CREAR EQUIPO.................
//         Proyecto pro =new Proyecto("SSS","Prueba  datos",LocalDate.of(2022,3,1),true);
//         ProyectoData pd=new ProyectoData();
//         pd.crearProyectos(pro);
//         Equipo eq=new Equipo (pro,"Equipo 06",LocalDate.of(2023,4,10),true);
//         EquipoData ed=new EquipoData();
//         ed.crearEquipo(eq);
//  
//.....................BUSCAR POR NOMBRE............
//        EquipoData id = new EquipoData();
//        System.out.println("Equipo :" + id.buscarEquipo("las mariposas").toString());
//.....................LISTAR EQUIPOS.................................
//        System.out.println("\n\n---------------------------------------------------------------------------------------------------\n\n");
//        EquipoData e = new EquipoData();
//        System.out.println("EQUIPOS");
//        for (Equipo equip : e.listarEquipos(true)) {
//            System.out.println(equip.toString());
//        }
//***********BAJA Y ALTA  EQUIPOS**************
//        EquipoData equi = new EquipoData();
//        equi.bajaEquipo("Equipo 4");
//        equi.altaEquipo("Equipo 85");
//*********MODIFICAR**************
//         Proyecto pro =new Proyecto(1,"Prueba","Prueba  datos",LocalDate.of(2022,3,1),true);
//         ProyectoData pd=new ProyectoData();
//         pd.crearProyectos(pro);
//          
//         Equipo eq=new Equipo (5,pro,"Equipo 7",LocalDate.of(2023,4,10),false);
//         EquipoData ed=new EquipoData();
//         ed.modificarEquipo(eq);
//    
//------------------------------------------------------------------------------INCORPORACION----------------------------FUNCA
//..........CREAR //
//        Proyecto pro = new Proyecto(22,"SSS", "Prueba  datos", LocalDate.of(2022, 3, 1), true);
//        Miembro mie = new Miembro(13,2323323, "Urquiza", "Pepe", true);
//        Equipo eq = new Equipo(5,pro, "Equipo 7", LocalDate.of(2023, 4, 10), true);
//        Incorporacion incorporacion = new Incorporacion(eq,mie, LocalDate.of(2022, 3, 1));
//        IncorporacionData incorData = new IncorporacionData();
//        incorData.crearIncorporacion(incorporacion);
//..........BUSCAR POR EQUIPO //
//        Proyecto pro = new Proyecto(1, "Viaje", "Creacion de Viajes", LocalDate.of(2022, 5, 31), true);
//        Equipo eq = new Equipo(6, pro, "Equipo 1", LocalDate.of(2023, 8, 17), true);
//        IncorporacionData incorData = new IncorporacionData();
//        System.out.println("Incorporaciones por Equipo:\n");
//        for (Incorporacion equi : incorData.buscarPorEquipo(eq)) {
//            System.out.println("Miembro: " + equi.getMiembro().getApellido() + " " + equi.getMiembro().getNombre()
//                    + " DNI : " + equi.getMiembro().getDni() + "   Estado : " + equi.getMiembro().isEstado()
//                    + " Fecha Incoroporacion : " + equi.getFechaIncorporacion() + " Proyecto : " + equi.getEquipo().getProyecto().getNombre()
//                    + " Estado Proyecto : " + equi.getEquipo().getProyecto().isEstado() + " Id Incorporacion : " + equi.getIdIncorporacion());
//        }
//..........BUSCAR POR MIEMBRO//
//        Miembro mie = new Miembro(13, 2323323, "Urquiza", "Pepe", true);
//        IncorporacionData incorData1 = new IncorporacionData();
//        System.out.println("\n\nIncorporaciones por Miembro:\n\n");
//        for (Incorporacion miemb : incorData1.buscarPorMiembro(mie)) {
//
//            System.out.println("Equipo : " + miemb.getEquipo().getNombre() + "  Estado Equipo : " + miemb.getEquipo().isEstado()
//            + " Fecha Incorporacion : " + miemb.getFechaIncorporacion() + " Proyecto : " + miemb.getEquipo().getProyecto().getNombre()
//            + " Estado Proyecto : " + miemb.getEquipo().getProyecto().isEstado() + " Id Incorporacion : " + miemb.getIdIncorporacion());
//        }
//..........ELIMINAR//
//        IncorporacionData incorData = new IncorporacionData();
//        incorData.eliminar(22);
//   (OBSERVACION PARA ELIMINAR UNA INCORPORACION TAMBIEN SE ELIMINARIA LA TAREA Y EL COMENTARIO)
//------------------------------------------------------------------------------TAREA----------------------------
//..........CREAR //
//        TareaData tData = new TareaData();
//        Proyecto pro = new Proyecto(22, "SSS", "Prueba  datos", LocalDate.of(2022, 3, 1), true);
//        Miembro mie = new Miembro(13, 2323323, "Urquiza", "Pepe", true);
//        Equipo eq = new Equipo(5, pro, "Equipo 7", LocalDate.of(2023, 4, 10), true);
//        Incorporacion incorporacion = new Incorporacion(23,eq, mie, LocalDate.of(2022, 3, 1));
//        Tarea tarea = new Tarea(incorporacion,"Hacer Pruebas",LocalDate.of(2022, 3, 1),LocalDate.of(2022, 4, 1),true);
//        tData.crearTarea(tarea);
//..........CONSULTAR INFO DE EQUIPO //
//        TareaData tData = new TareaData();
//        System.out.println("INFO DE EQUIPO: \n\n");
//        for (Tarea ta : tData.consultaInfoEquipo(6)) {
//
//            System.out.println("MIEMBRO: " + ta.getIncorporacion().getMiembro().getApellido() + " " + ta.getIncorporacion().getMiembro().getNombre()
//                    + " DNI: " + ta.getIncorporacion().getMiembro().getDni() + "   Estado Miembro: " + ta.getIncorporacion().getMiembro().isEstado()
//                    + " TAREA DESIGNADA: " + ta.getNombre());
//        }
//..........MODIFICAR //
//        TareaData tData = new TareaData();
//        Incorporacion incorporacion = new Incorporacion();
//        incorporacion.setIdIncorporacion(18);
//        Tarea tarea = new Tarea(8,incorporacion, "Ayudante", LocalDate.of(2022, 10, 10), LocalDate.of(2022, 12, 1), true);
//        tData.modificarTarea(tarea);
//........FINALIZAR Y PROCESO //
        TareaData tData = new TareaData();
        tData.finalizada(1);
        tData.finalizada(2);
        tData.finalizada(3);
        tData.enProceso(4);
        tData.enProceso(5);
        tData.enProceso(3);
    }
}
