
package tpf_gestion;

import AccesoADatos.EquipoData;
import Entidades.Equipo;


public class TPF_Gestion {

  
    public static void main(String[] args) {
        ..............CREAR EQUIPO.................
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
//      EquipoData id=new EquipoData();
//      System.out.println("Equipo :"+id.buscarEquipo("Equipo 2").toString());
        
//...............LISTAR EQUIPOS.................................
       EquipoData e=new EquipoData();
       System.out.println("EQUIPOS");
       for(Equipo equip : e.listarEquipos(true)){
           System.out.println(equip.toString());
       
//***********BAJA Y ALTA  EQUIPOS**************
        EquipoData equi=new EquipoData();
        equi.bajaEquipo(6);
        equi.altaEquipo(5);
    
        
   
//*********MODIFICAR**************

//         Proyecto pro =new Proyecto("Prueba","Prueba  datos",LocalDate.of(2022,3,1),true);
//         ProyectoData pd=new ProyectoData();
//         pd.crearProyectos(pro);
//          
//          
//         Equipo eq=new Equipo (pro,"Equipo 32",LocalDate.of(2023,4,10),true);
//         EquipoData ed=new EquipoData();
//         ed.modificarEquipo(eq);
//       
       
    
}}

        
    }
    

