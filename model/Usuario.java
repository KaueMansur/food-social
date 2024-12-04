import database.UsuarioDAO;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String nascimento;
    private String alergias;
    private String receitas;
    private String seguidores;
    private int avaliacaoMedia;
    

    public Usuario(String nome1, String email1, String telefone1, String nascimento1, String senha1, String alergias1, String receitas1, String seguidores1, String avaliacaoMedia1) {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(String nome, String email,String telefone ,String nascimento, String senha, String alergias, int avaliacaoMedia, String receitas,String seguidores) {

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.senha = senha;
        this.alergias = alergias;
        this.receitas = receitas;
        this.seguidores = seguidores;
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public Usuario(int id, String nome, String email, String telefone,String nascimento, String alergias, int avaliacaoMedia, String receitas, String seguidores) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.alergias = alergias;
        this.receitas = receitas;
        this.seguidores = seguidores;
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    
     public String getReceitas() {
        return receitas;
    }

    public void setReceitas(String receitas) {
        this.receitas = receitas;
    }

     public String getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(String seguidores) {
        this.seguidores = seguidores;
    }

    
    public int getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(int avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public boolean login() throws ClassNotFoundException, SQLException {
        boolean key = false;

        UsuarioDAO uDAO = new UsuarioDAO();
        ArrayList<Usuario> list = uDAO.getAllUsers();

        for (Usuario u : list) {
            if (u.getEmail().equals(this.email)) {
                if (u.getSenha().equals(this.senha)) {
                    key = true;
                }
            }
        }
        return key;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone="+ telefone + ", nascimento=" + nascimento + ", senha=" + senha + ", alergias=" + alergias +" ,receitas=" +receitas + ", seguidores=" + seguidores+ ", avaliacaoMedia=" + avaliacaoMedia +  '}';
    }

    
}
