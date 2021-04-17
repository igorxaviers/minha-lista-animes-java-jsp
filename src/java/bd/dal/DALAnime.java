package bd.dal;

import bd.entidades.Anime;
import bd.util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DALAnime {
    public boolean salvar(Anime a) {
        String sql = "insert into animes (id_genero, nome, imagem) values ('$1','$2','$3')";
        sql = sql.replace("$1", Integer.toString(a.getIdGenero()));
        sql = sql.replace("$2", a.getNome());
        sql = sql.replace("$3", a.getImagem());
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean alterar(Anime a) {
        String sql = "update animes set id_genero='$1', nome='$2', imagem='$3' where id_ani = " + a.getId();
        sql = sql.replace("$1", Integer.toString(a.getIdGenero()));
        sql = sql.replace("$2", a.getNome());
        sql = sql.replace("$3", a.getImagem());
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean apagar(int id) {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from animes where id_ani = " + id);
        con.fecharConexao();
        return flag;
    }

    public Anime getAnime(int id) {
        Anime a = null;
        String sql = "select * from animes where id_ani = " + id;
        Conexao con = new Conexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next())
                a = new Anime(rs.getInt("id_ani"), rs.getInt("id_genero"), rs.getString("nome"),
                        rs.getString("imagem"));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return a;
    }

    public ArrayList<Anime> getAnime(String filtro) {
        ArrayList<Anime> lista = new ArrayList();
        String sql = "select * from animes";
        if (!filtro.isEmpty())
            sql += " where " + filtro;
        sql += " order by id_ani DESC";
        Conexao con = new Conexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                lista.add(new Anime(rs.getInt("id_ani"), rs.getInt("id_genero"), rs.getString("nome"),
                        rs.getString("imagem")));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return lista;
    }

}