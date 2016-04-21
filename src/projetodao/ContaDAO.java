package projetodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO implements InterDAO {

    private Connection con;

    public ContaDAO() throws SQLException {
        con = new DataSource("banco").getCon();
    }

    @Override
    public void inserir(Object obj) throws SQLException {

        //dando um casting do objeto abstrato para um do tipo Conta
        Conta conta = (Conta) obj;
        String sql = "INSERT INTO untitled (login, senha) VALUES (?,?)";

        //faz com que o comando enviado para o banco seja "preparado" previamente sem valores
        //para evitar sql injection
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, conta.getLogin());
        stm.setString(2, conta.getSenha());
        stm.executeUpdate();

    }

    @Override
    public List consultar(String chave) throws SQLException {
        String sql = "SELECT * FROM conta WHERE login=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, chave);
        ResultSet rs = stm.executeQuery();

        ArrayList<Conta> vet = new ArrayList<Conta>();
        while (rs.next()) {
            Conta novo = new Conta();
            novo.setLogin(rs.getString(1));
            novo.setSenha(rs.getString(2));
            vet.add(novo);
        }
        return vet;
    }

    @Override
    public void atualizar(String chave, Object obj) throws SQLException {
    }

    @Override
    public void remover(String chave) throws SQLException {
    }

}
