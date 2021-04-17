package bd.dal;

import bd.entidades.Genero;
import bd.util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DALGenero {
    public ArrayList<Genero> getGeneros() {
        ArrayList<Genero> listaGeneros = new ArrayList();
        String sql = "select * from generos order by ASC";
        Conexao con = new Conexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                listaGeneros.add(new Genero(rs.getInt("id_gen"), rs.getString("nome")));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return listaGeneros;
    }

    public ArrayList<Genero> getGeneros(String filtro) {
        ArrayList<Genero> listaGeneros = new ArrayList();
        String sql = "select * from generos";
        if (!filtro.isEmpty())
            sql += " where " + filtro;
        sql += " order by id_gen ASC";
        Conexao con = new Conexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                listaGeneros.add(new Genero(rs.getInt("id_gen"), rs.getString("nome")));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return listaGeneros;
    }

    public Genero getGenero(int id) {
        Genero gen = null;
        String sql = "select * from generos where id_gen = " + id;
        Conexao con = new Conexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next())
                gen = new Genero(rs.getInt("id_gen"), rs.getString("nome"));

        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return gen;
    }

}
