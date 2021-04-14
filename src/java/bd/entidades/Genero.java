package bd.entidades;

public class Genero {
    private int id;
    private String nome;

    public Genero() {
        this(0, "");
    }

    public Genero(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return id + "," + nome;
    }
}
