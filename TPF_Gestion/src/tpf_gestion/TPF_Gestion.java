package tpf_gestion;

import AccesoADatos.*;
import Entidades.*;
import java.time.LocalDate;

public class TPF_Gestion {

    public static void main(String[] args) {
//------------------CREAR MIEMBRO---------------------------- 
//        Miembro mie = new Miembro(2323323, "Urquiza", "Pepe",true );
//        MiembroData md = new MiembroData();
//        md.crearMiembro(mie);

//        ................ BUSCAR MIEMBRO POR DNI ................  
          MiembroData md = new MiembroData();
          System.out.println("Miembro: " + md.buscarMiembroDNI(86782201).toString());

//        ------------------BUSCAR MIEMBRO POR APELLIDO----------------------- 
//        MiembroData md = new MiembroData();
//        System.out.println("Apellido: " + md.buscarMiembroPorApellido("Clavito").toString());
        
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
//        Miembro mie = new Miembro (50, 1234567, "Ramirez", "Pepe", true);
//        MiembroData md = new MiembroData();
//        md.modificarMiembro(mie);
//     ..............CREAR EQUIPO.................
//         Proyecto pro =new Proyecto("SSS","Prueba  datos",LocalDate.of(2022,3,1),true);
//         ProyectoData pd=new ProyectoData();
//         pd.crearProyectos(pro);
//          
//          
//         Equipo eq=new Equipo (pro,"Equipo 06",LocalDate.of(2023,4,10),true);
//         EquipoData ed=new EquipoData();
//         ed.crearEquipo(eq);
//       

//...............BUSCAR POR NOMBRE............
//        EquipoData id = new EquipoData();
//        System.out.println("Equipo :" + id.buscarEquipo("Equipo 2").toString());
//
////...............LISTAR EQUIPOS.................................
//        System.out.println("\n\n---------------------------------------------------------------------------------------------------\n\n");
//
//        EquipoData e = new EquipoData();
//        System.out.println("EQUIPOS");
//        for (Equipo equip : e.listarEquipos(true)) {
//            System.out.println(equip.toString());
//***********BAJA Y ALTA  EQUIPOS**************
//        EquipoData equi = new EquipoData();
//        equi.bajaEquipo(5);
//        equi.altaEquipo(6);

//*********MODIFICAR**************
//         Proyecto pro =new Proyecto(15,"Prueba","Prueba  datos",LocalDate.of(2022,3,1),true);
//         ProyectoData pd=new ProyectoData();
//         pd.crearProyectos(pro);
//          
//          
//         Equipo eq=new Equipo (5,pro,"Equipo 32",LocalDate.of(2023,4,10),true);
//         EquipoData ed=new EquipoData();
//         ed.modificarEquipo(eq);
//       
        }
    }
