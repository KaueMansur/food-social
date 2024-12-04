package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {
    private static Connection conn;
    
    public UsuarioDAO() throws ClassNotFoundException, SQLException {
       conn = Conexao.getConn();
    }
    public ArrayList<Usuario> getAllUsers() throws SQLException{
        ArrayList<Usuario> list = new ArrayList();
        
        String query = "select * from usuarios";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet result = prep.executeQuery();
        
        while( result.next() ) {
            Usuario user = new Usuario(nome, email, telefone, nascimento, senha, alergias, receitas, seguidores, avaliacaoMedia);
            
            user.setId(result.getInt("id"));
            user.setNome(result.getString("nome") );
            user.setEmail(result.getString("email"));
            user.setSenha(result.getString("senha"));
            user.setTelefone(result.getString("telefone"));
            user.setNascimento(result.getString("nascimento"));
            user.setAlergias(result.getString("alergias"));
            user.setReceitas(result.getString("receitas"));
            user.setSeguidores(result.getString("seguidores"));
            user.setAvaliacaoMedia(result.getInt("avaliacaoMedia"));
            
            list.add(user);
          
        }
        prep.close();
        return list;
    }
    
    public void setNewUser(Usuario user) throws SQLException{
     String query = "insert into usuarios(nome, email, telefone, nascimento, senha, alergias,receitas, seguidores, avaliacaoMedia)"
                   + "values( ?, ?, sha1(?),?, ?,  ?, ?, ?, ? )";
     
     PreparedStatement prep = conn.prepareStatement(query);
     
     prep.setString(1, user.getNome() );
     prep.setString(2, user.getEmail() );
     prep.setString(3, user.getSenha() );
     prep.setString(4, user.getTelefone() );
     prep.setString(5, user.getNascimento() );
     prep.setString(6, user.getAlergias());
     prep.setString(7, user.getReceitas() );
     prep.setString(8, user.getSeguidores() );
     prep.setInt(9, user.getAvaliacaoMedia() );
     
     
     prep.execute();
     prep.close();
     
    }
    
    public void deleteUser(int id) throws SQLException{
       String query = "delete from usuarios where id = " + id;
       
       PreparedStatement prep = conn.prepareStatement(query);
       
       prep.execute();
       prep.close();
    }
    
    public Usuario getOneUser(int id) throws SQLException{
        
        String query = "select * from usuarios where id = " + id;
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet result = prep.executeQuery();
        
        Usuario user = new Usuario(nome, email, telefone, nascimento, senha, alergias, receitas, seguidores, avaliacaoMedia);
        
        if( result.next() ) {
            
            user.setId(result.getInt("id"));
            user.setNome(result.getString("nome") );
            user.setEmail(result.getString("email"));
            user.setSenha(result.getString("senha"));
            user.setTelefone(result.getString("telefone"));
            user.setNascimento(result.getString("nascimento"));
            user.setAlergias(result.getString("alergias"));
           
            user.setReceitas(result.getString("receitas"));
            user.setSeguidores(result.getString("seguidores"));
            user.setAvaliacaoMedia(result.getInt("avaliacaoMedia"));
            
        }
        prep.close();
        return user;
    }
    
    public void updateUser(Usuario user) throws SQLException{
     String query = "update usuarios set "
             + "nome = ?, email = ?, "
             + "telefone = ?,"
             + "nascimento = ?,"
             + "alergias = ? ,"
             + "receitas = ?,"
             + "seguidores = ?,"
             + "avaliacaoMedia = ? "
             +"where id = ? ";
             
     
     PreparedStatement prep = conn.prepareStatement(query);
     
     prep.setInt(1, user.getId() );
     prep.setString(2, user.getNome() );
     prep.setString(3, user.getEmail() );
     prep.setString(4, user.getTelefone() );
     prep.setString(5, user.getNascimento() );
     prep.setString(6, user.getAlergias() );
     prep.setString(7, user.getReceitas() );
     prep.setString(8, user.getSeguidores() );
     prep.setInt(9, user.getAvaliacaoMedia() );
     
     prep.execute();
     prep.close();
     
    }
    
}
