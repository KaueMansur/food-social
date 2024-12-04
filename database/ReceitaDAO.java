package database;

import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Receita;
import model.Usuario;

public class ReceitaDAO {
    private static Connection conn;
    
    public ReceitaDAO() throws ClassNotFoundException, SQLException {
       conn = Conexao.getConn();
    }
    public ArrayList<Receita> getAllUsers() throws SQLException{
       
        ArrayList<Receita> list = new ArrayList();
        
        String query = "select * from usuarios;";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet result = prep.executeQuery();
        
        while( result.next() ) {
            Receita user = new Receita(nome, ingredientes, tempoDepreparo, rendimento, tipo, categoria, alergias, imagem, video,descricao, climaConservacao, opcaoAlimenticia, privacidade, substituicoes);
            
            user.setId(result.getInt("id"));
            user.setNome(result.getString("nome") );
            user.setIngredientes((ArrayList<String>)result.getArray("ingredientes"));
            user.setTempoDePreparo(result.getInt("tempoDePreparo"));
            user.setRendimento(result.getInt("Rendimento"));
            user.setTipo(result.getString("tipo"));
            user.setCategoria(result.getString("categoria"));
            user.setAlergias((ArrayList<String>)result.getArray("alergias"));
            user.setImagem((Blob) result.getBlob("imagem"));
            user.setVideo((Blob) result.getBlob("video"));
            user.setDescricao(result.getString("descricao"));
            user.setClimaConservacao(result.getString("climaConservacao"));
            user.setValidade(result.getString("validade"));
            user.setOpcaoAlimenticia(result.getString("opcaoAlimenticia"));
            user.setPrivacidade(result.getString("privacidade"));
            user.setSubstituicoes((ArrayList<String>)result.getArray("substituicoes"));
            
            list.add(user);
        }
        prep.close();
        return list;
    }
    
    public void setNewUser(Receita user) throws SQLException{
     String query = "insert into usuarios(nome, ingredientes,tempoDePreparo, rendimento, tipo, categoria, "
             + "alergias, imagem, video, descricao, climaConservacao, validade, opcaoAlimenticia,"
             + " privacidade, substituicoes)"
                   + "values( ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?)";
     
     PreparedStatement prep = conn.prepareStatement(query);
     
     prep.setString(1, user.getNome() );
     prep.setObject(2, user.getIngredientes().toArray() );
     prep.setInt(3, user.getTempoDePreparo() );
     prep.setInt(4, user.getRendimento() );
     prep.setString(5, user.getTipo() );
     prep.setString(6, user.getCategoria() );
     prep.setObject(7, user.getAlergias().toArray());
     prep.setBlob(8, (Blob)user.getImagem() );
     prep.setBlob(9, (Blob)user.getVideo() );
     prep.setString(10, user.getDescricao() );
     prep.setString(11, user.getClimaConservacao() );
     prep.setString(12, user.getValidade() );
     prep.setString(13, user.getOpcaoAlimenticia() );
     prep.setString(14, user.getPrivacidade() );
     prep.setObject(15, user.getSubstituicoes().toArray() );
     
     prep.execute();
     prep.close();
     
    }
    
    public void deleteUser(int id) throws SQLException{
       String query = "delete from usuarios where id = " + id;
       
       PreparedStatement prep = conn.prepareStatement(query);
       
       prep.execute();
       prep.close();
    }
    
    public Receita getOneUser(int id) throws SQLException{
        
        String query = "select * from usuarios where id = " + id;
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet result = prep.executeQuery();
        
        Receita user = new Receita(nome,ingredientes, tempoDePreparo, rendimento, tipo,categoria, alergias,imagem, video, descricao, climaConservacao, validade, opcaoAlimenticia, privacidade, substituicoes);
        
        if( result.next() ) {
            
            user.setId(result.getInt("id"));
            user.setNome(result.getString("nome") );
            user.setIngredientes((ArrayList<String>)result.getArray("ingredientes"));
            user.setTempoDePreparo(result.getInt("tempoDePreparo"));
            user.setRendimento(result.getInt("Rendimento"));
            user.setTipo(result.getString("tipo"));
            user.setCategoria(result.getString("categoria"));
            user.setAlergias((ArrayList<String>)result.getArray("alergias"));
            user.setImagem((Blob) result.getBlob("imagem"));
            user.setVideo((Blob) result.getBlob("video"));
            user.setDescricao(result.getString("descricao"));
            user.setClimaConservacao(result.getString("climaConservacao"));
            user.setValidade(result.getString("validade"));
            user.setOpcaoAlimenticia(result.getString("opcaoAlimenticia"));
            user.setPrivacidade(result.getString("privacidade"));
            user.setSubstituicoes((ArrayList<String>)result.getArray("substituicoes"));
            
        }
        prep.close();
        return user;
    }
    
    public void updateUser(Receita user) throws SQLException{
     String query = "update receita set "
             + "nome = ?, ingredientes = ?, "
             + "tempoDePreparo = ?,"
             + "rendimento = ?,"
             + "tipo = ? ,"
             + "categoria= ? ,"
             + "alergias = ? ,"
             + "imagem= ?,"
             + "video = ?,"
             + "descricao = ? ,"
             + "climaConservacao = ? ,"
             + "validade = ? ,"
             + "opcaoAlimenticia = ? ,"
             + "privacidade = ? ,"
             + "substituicoes = ? "
             +"where id = ? ";
             
     
     PreparedStatement prep = conn.prepareStatement(query);
     
    prep.setString(1, user.getNome() );
     prep.setObject(2, user.getIngredientes().toArray() );
     prep.setInt(3, user.getTempoDePreparo() );
     prep.setInt(4, user.getRendimento() );
     prep.setString(5, user.getTipo() );
     prep.setString(6, user.getCategoria() );
     prep.setObject(7, user.getAlergias().toArray());
     prep.setBlob(8, (Blob)user.getImagem() );
     prep.setBlob(9, (Blob)user.getVideo() );
     prep.setString(10, user.getDescricao() );
     prep.setString(11, user.getClimaConservacao() );
     prep.setString(12, user.getValidade() );
     prep.setString(13, user.getOpcaoAlimenticia() );
     prep.setString(14, user.getPrivacidade() );
     prep.setObject(15, user.getSubstituicoes().toArray() );
     
     prep.execute();
     prep.close();
     
    }
    
}
