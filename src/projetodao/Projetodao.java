package projetodao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Projetodao {

    public static void main(String[] args) {
        ContaDAO contabd = null;
        try {
            contabd = new ContaDAO();
        } catch (SQLException e) {
            System.err.println("Falha na conexão");

            //informa qual o erro que deu
            System.err.println(e);

            //informa com o "1" que o processo deu erro, para o SO matar todos os processos
            //relacionados ao que deu erro
            System.exit(1);
        }

        Conta obj = new Conta();
        obj.setLogin("hueheuhe");
        obj.setSenha("12321");
        try {
            contabd.inserir(obj);
        } catch (SQLException e) {
            System.err.println("Falha na inserção");
            System.err.println(e);
            System.exit(1);
        }
    }

}
