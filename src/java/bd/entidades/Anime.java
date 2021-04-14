package bd.entidades;

public class Anime {

    private int id, id_genero;
    private String nome, foto;

    public Anime() {
        this(0, 0, "", "");
    }

    public Anime(int id, int id_genero, String nome, String foto) {
        this.id = id;
        this.id_genero = id_genero;
        this.nome = nome;
        this.foto = foto;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return id + "," + nome + "," + foto;
    }

}
