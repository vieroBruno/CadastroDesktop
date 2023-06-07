/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Bruno Viero
 */
public class conexao_DAO {
    Connection conectar=null;
    Statement sta=null;
    ResultSet rst=null;
    
    public void con(){
        String ip="127.0.0.1";
        String user="Bruno";
        String senha="Bru123no!";
        String banco="cadastro_desktop";
        String porta="3306";
        String servidor ="jdbc:mysql://"+ip+":"+porta
                +"/"+banco+"?useSSL=false";
        String driver = "org.gjt.mm.mysql.Driver";
        
        try {
            Class.forName(driver);
            this.conectar=(Connection)DriverManager.getConnection(servidor,user,senha);
            this.sta=(Statement)this.conectar.createStatement();
            System.out.println("Sucesso");
        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(conexao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar(){
        try {
            conectar.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        
    
}
