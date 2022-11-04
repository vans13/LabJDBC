/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratoriodb;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adm
 */
public class LaboratorioDB {

    public static void main(String[] args) {
        
        Connection conectado;
        Statement estadito;
        ResultSet putSet;  
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LaboratorioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Se genera la conexión con la base de datos
            conectado=DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratorio", "root", "");
            estadito=conectado.createStatement();
            estadito.executeUpdate("INSERT INTO datos VALUES (null,'William Wallace','1270-08-23') ");
            
            //Lee los datos de la 
            putSet=estadito.executeQuery("SELECT * FROM datos");
            putSet.next();
            do {                
                System.out.println(putSet.getString("ID")+"\nNombre: "+putSet.getString("Nombre")+"\nFecha de Nacimiento: "+putSet.getString("Nacimiento"));
            } while (putSet.next());
         conectado.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
    
}
