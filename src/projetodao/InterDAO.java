package projetodao;

import java.sql.SQLException;
import java.util.List;

public interface InterDAO {

    public void inserir(Object obj) throws SQLException;

    public List consultar(String chave) throws SQLException;

    public void atualizar(String chave, Object obj) throws SQLException;

    public void remover(String chave) throws SQLException;

}
