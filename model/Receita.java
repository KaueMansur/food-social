package model;

import java.util.ArrayList;

public class Receita {

    private int id;
    private String nome;
    private ArrayList ingredientes;
    private int tempoDePreparo;
    private int rendimento;
    private String tipo;
    private String categoria;
    private ArrayList<String> alergias;
    private Blob imagem;
    private Blob video;
    private String descricao;
    private String climaConservacao;
    private String validade;
    private String opcaoAlimenticia;
    private String privacidade;
    private ArrayList substituicoes;
    

    public Receita(String nome1, String email, String telefone, String nascimento, String alergias1, String receitas, String seguidores, String avaliacaoMedia, String avaliacaoMedia1) {}

    public Receita(int id, String nome, ArrayList ingredientes, int tempoDePreparo ,int rendimento , String tipo, String categoria, 
                   ArrayList alergias, Blob imagem, Blob video, String descricao,
                   String climaConservacao, String validade, String opcaoAlimenticia, String privacidade, ArrayList substituicoes  ) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.tempoDePreparo = tempoDePreparo ;
        this.rendimento =  rendimento ;
        this.tipo = tipo;
        this.categoria = categoria;
        this.alergias = alergias;
        this.imagem = imagem;
        this.video = video;
        this.descricao = descricao;
        this.climaConservacao = climaConservacao;
        this.validade = validade ;
        this.opcaoAlimenticia = opcaoAlimenticia;
        this.privacidade = privacidade ;
        this.substituicoes = substituicoes;
        
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

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

     public int getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(int tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }
    
    public int getRendimento(){
        return rendimento;
    }

    public void setRendimento(int rendimento) {
        this.rendimento = rendimento;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

     public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria =categoria;
    }
    
    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }
    
     public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

     public Blob getVideo() {
        return video;
    }

    public void setVideo(Blob video) {
        this.video = video;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
     public String getClimaConservacao() {
        return climaConservacao;
    }

    public void setClimaConservacao(String  climaConservacao ) {
        this.climaConservacao =  climaConservacao;
    }
    
     public String getValidade() {
        return validade;
    }

    public void setValidade(String  validade ) {
        this.validade =  validade;
    }

     public String getOpcaoAlimenticia() {
        return opcaoAlimenticia;
    }

    public void setOpcaoAlimenticia(String opcaoAlimenticia ) {
        this.opcaoAlimenticia = opcaoAlimenticia;
    }
    
    public String getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(String privacidade ) {
        this.privacidade = privacidade;
    }

    public ArrayList getSubstituicoes() {
        return substituicoes;
    }

    public void setSubstituicoes(ArrayList substituicoes) {
        this.substituicoes = substituicoes ;
    }
    

    @Override
    public String toString() {
        return "Receita{" + "id=" + id + ", nome=" + nome + ", ingredientes=" + ingredientes + ", tempoDePreparo="+ tempoDePreparo + ", rendimento=" +rendimento + ", tipo=" +tipo + ", categoria="+categoria+", alergias=" + alergias +" , imagem=" +imagem+ ", video=" + video+ ", descricao=" + descricao +", climaConservacao="+ climaConservacao+" , validade="+validade+", opcaoAlimenticia="+opcaoAlimenticia+", privacidade="+privacidade+", substituicoes="+substituicoes+ '}';
    }


    public void publicarReceita(){
    
    }
    
    public void enviarSolicitacoesDeAmizade(){
        
    }
    
    public void aceitarSolicitacoesDeAmizade(){
        
    }

    public boolean login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
