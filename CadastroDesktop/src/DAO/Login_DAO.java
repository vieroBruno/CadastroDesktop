/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Viero
 */
public class Login_DAO extends conexao_DAO{
    
    public int validar(String login,String senha){
        int idLogin=0;
        con();
        String query="select id from usuario where"
                + " login='"+login+""
                + "'and senha='"+senha+"'";
        try {
            rst=sta.executeQuery(query);
            while(rst.next()){
            idLogin=rst.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return idLogin;
    }
    
}
