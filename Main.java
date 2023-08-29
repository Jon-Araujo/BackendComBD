import model.Metodos;
import java.util.Objects;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/MissaoPratica3";
        String username = "loja";
        String password = "loja";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("conectadoooo");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> pf = Metodos.restauraObjeto("./dadosPf");
        ArrayList<ArrayList<String>> pj = Metodos.restauraObjeto("./dadosPj");

        int opcao = -1;

        while (opcao != 0) {
            opcao = Metodos.opcoesTerminal();
            if (opcao == 1) {
                String tipoPessoa = Metodos.tipoPessoa();

                if (Objects.equals(tipoPessoa, "f")) {
                    pf = Metodos.opcao1("fisica", pf);
                } else if (Objects.equals(tipoPessoa, "j")) {
                    pj = Metodos.opcao1("juridica", pj);
                }
            } else if (opcao == 2) {
                String tipoPessoa = Metodos.tipoPessoa();
                if (Objects.equals(tipoPessoa, "f")) {
                    pf = Metodos.opcao2("fisica", pf);
                } else if (Objects.equals(tipoPessoa, "j")) {
                    pj = Metodos.opcao2("juridica", pj);
                }
            } else if (opcao == 3) {
                String tipoPessoa = Metodos.tipoPessoa();
                if (Objects.equals(tipoPessoa, "f")) {
                    pf = Metodos.opcao3(pf);
                } else if (Objects.equals(tipoPessoa, "j")) {
                    pj = Metodos.opcao3(pj);
                }
            } else if (opcao == 4) {
                String tipoPessoa = Metodos.tipoPessoa();
                if (Objects.equals(tipoPessoa, "f")) {
                    Metodos.opcao4("fisica", pf);
                } else if (Objects.equals(tipoPessoa, "j")) {
                    Metodos.opcao4("juridica", pj);
                }
            } else if (opcao == 5) {
                String tipoPessoa = Metodos.tipoPessoa();

                if (Objects.equals(tipoPessoa, "f")) {
                    Metodos.opcao5("fisica", pf);
                } else if (Objects.equals(tipoPessoa, "j")) {
                    Metodos.opcao5("juridica", pj);
                }
            } else if (opcao == 6) {
                String tipoPessoa = Metodos.tipoPessoa();

                if (Objects.equals(tipoPessoa, "f")) {
                    Metodos.salvaObjeto(pf, "./dadosPf");
                } else if (Objects.equals(tipoPessoa, "j")) {
                    Metodos.salvaObjeto(pj, "./dadosPj");
                }
            } else if (opcao == 7) {
                String tipoPessoa = Metodos.tipoPessoa();

                if (Objects.equals(tipoPessoa, "f")) {
                    Metodos.restauraObjeto("./dadosPf");
                } else if (Objects.equals(tipoPessoa, "j")) {
                    Metodos.restauraObjeto("./dadosPj");
                }

                System.out.println("Dados recuperados com sucesso!");
            }
        }
    }
}
