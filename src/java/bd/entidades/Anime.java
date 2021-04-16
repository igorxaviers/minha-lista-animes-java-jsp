package bd.entidades;

public class Anime {

    private int id, id_genero;
    private String nome, imagem;

    public Anime() {
        this(0, 0, "", "");
    }

    public Anime(int id, int id_genero, String nome, String imagem) {
        this.id = id;
        this.id_genero = id_genero;
        this.nome = nome;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGenero() {
        return id_genero;
    }

    public void setIdGenero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return id + "," + nome + "," + imagem;
    }

}
