
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Operacion {
  
       public static String ejecutar(String sql){
        String msg="operacion exitosa";
        try {
            Connection cn=new Conexion().getConexionSqlServer();
            if(cn!=null){
                 Statement st=cn.createStatement();
                 st.executeUpdate(sql);
                 cn.close();
            }else{
                msg="Compruebe la conexion con la base de datos";
            }
        } catch (SQLException e) {
            msg=e.getMessage();
        }
        return msg;
       }

        public static List listar(String sql){
            List lista= new ArrayList();
            try {
                Connection cn= new Conexion().getConexionSqlServer();
                if(cn!=null){
                    Statement st= cn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    ResultSetMetaData rm= rs.getMetaData();// informacion sobre las tablas
                     int numCol=rm.getColumnCount();
                    String [] titCol=new String[numCol];
                    for(int i=0;i<numCol;i++)
                        titCol[i]=rm.getColumnName(i+1);// recuperar el nombre de los titulos
                    	lista.add(titCol);
                    while(rs.next()){
                        Object[] fila=new Object[numCol];
                        for(int i =0;i<numCol;i++)
                            fila[i]=rs.getObject(i+1);
                        lista.add(fila);
                    }
                    cn.close();

                }else{
                    lista=null;
                }
            } catch (SQLException e) {
                lista=null;
            }
            return lista;       
        }

         public static Object[] buscar (String sql ){
             Object[] fila=null;
             List lista= listar(sql);
             if(lista!=null){
                 if(lista.size()>1)
                     fila= (Object[])lista.get(1);
             }
             return fila;
         }
         
      
      public String getAutoCodigoID(String nombre) {
      String numStr = null,numGen = null,numInt=null;
      Object[] fila= new Object[4];
      String sql="select *from "+nombre+" order by  1 asc";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
            fila=(Object[])lista.get(i);
          }
          if(fila[0]!=null){
            String num=fila[0].toString();
            numStr= num.substring(0,1).toUpperCase();// obtener la letra
            numInt=num.substring(1).trim();// obtener los numeros
            numGen= String.valueOf(Integer.parseInt(numInt)+1);
            while(numGen.length()<=3){
                  numGen='0'+numGen; // rellenar 
                  }
          }
          else{
              numStr=nombre.substring(0,1).toUpperCase();
              numGen="0001";
          }
      }
        return numStr+numGen;
    }


      public String getFechaActual(){
          SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
          String fecha=sdf.format(new Date());
          return fecha;
      }
      
      public String Encriptacion(String texto){
          System.out.println("texto:"+texto);
          char array[]=texto.toCharArray();
          for(int i=0;i<array.length;i++){
              array[i]=(char)(array[i]+(char)5);
          }
          String txtEncriptado=String.valueOf(array);
          System.out.println(txtEncriptado);
        
          char arrayD[]=txtEncriptado.toCharArray();
          for(int i=0;i<arrayD.length;i++){
              arrayD[i]=(char)(arrayD[i]-(char)5);
          }
          String txtDesEncriptado=String.valueOf(arrayD);
          System.out.println(txtDesEncriptado);
          
          
          
          
          return null;
      }
   
}
