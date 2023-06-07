/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Viero
 */
public class Usuario_DAO extends conexao_DAO{
    
    public boolean cadastrar(Usuario user){
        boolean funcionou=false;
        con();
        String query="insert into usuario(nome,email,login,senha)"
                + "values('"+user.getNome()+"'"
                + ",'"+user.getEmail()+"'"
                + ",'"+user.getLogin()+"'"
                + ",'"+user.getSenha()+"');";
        System.err.println(query);
        
        try {
            sta.execute(query);
            funcionou=true;
        } catch (SQLException ex) {
            System.err.println("Errooooouuuu " + ex);
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionou;
    }
    public List<Usuario> listarUsuario(String nome){
        
        List<Usuario> listU = new ArrayList<>();
        con();
        String query="select* from usuario where nome like '%"+nome+"%'";
        
        try {
            rst=sta.executeQuery(query);
            while(rst.next()){
            
            Usuario user = new Usuario();
            user.setId(rst.getInt("id"));
            user.setNome(rst.getString("nome"));
            user.setEmail(rst.getString("email"));
            user.setLogin(rst.getString("login"));
            user.setSenha(rst.getString("senha"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        


        return listU;
    }
}
