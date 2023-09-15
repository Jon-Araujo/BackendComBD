package model;

import java.sql.*;
import java.util.Scanner;

public class Metodos {
    public static void restauraObjeto(String tipoPessoa, Connection connection) throws SQLException {
        if (tipoPessoa == "pf") {
            try {
                String sql = "SELECT * FROM fisica";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("idpessoa");
                    String nome = resultSet.getString("nome");
                    String logradouro = resultSet.getString("logradouro");
                    String cidade = resultSet.getString("cidade");
                    String estado = resultSet.getString("estado");
                    String telefone = resultSet.getString("telefone");
                    String email = resultSet.getString("email");
                    String cpf = resultSet.getString("cpf");

                    System.out.println("Id: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Logradouro: " + logradouro);
                    System.out.println("Cidade: " + cidade);
                    System.out.println("Estado: " + estado);
                    System.out.println("Telefone: " + telefone);
                    System.out.println("Email: " + email);
                    System.out.println("CPF: " + cpf);
                    System.out.println("##########################################");
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (tipoPessoa == "pj") {
            try {
                String sql = "SELECT * FROM juridica";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("idpessoa");
                    String nome = resultSet.getString("nome");
                    String logradouro = resultSet.getString("logradouro");
                    String cidade = resultSet.getString("cidade");
                    String estado = resultSet.getString("estado");
                    String telefone = resultSet.getString("telefone");
                    String email = resultSet.getString("email");
                    String cnpj = resultSet.getString("cnpj");

                    System.out.println("Id: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Logradouro: " + logradouro);
                    System.out.println("Cidade: " + cidade);
                    System.out.println("Estado: " + estado);
                    System.out.println("Telefone: " + telefone);
                    System.out.println("Email: " + email);
                    System.out.println("CNPJ: " + cnpj);
                    System.out.println("##########################################");
                }

                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

    public static int opcoesTerminal() {
        System.out.println("""
                ================================================
                1 - Incluir Pessoa
                2 - Alterar Pessoa
                3 - Excluir Pessoa
                4 - Buscar pelo Id
                5 - Exibir Todos
                0 - Finalizar Programa
                ================================================
                """);

        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();
        return opcao;
    };

    public static String tipoPessoa() {
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        Scanner tipo = new Scanner(System.in);
        String tipoPessoa = tipo.nextLine().toLowerCase();

        return tipoPessoa;
    };

    public static int obterUltimoID(Connection connection) {
        int ultimoID = 0;
        try {
            String sql = "SELECT MAX(idpessoa) AS ultimo_id FROM pessoa";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                ultimoID = resultSet.getInt("ultimo_id");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ultimoID;
    };

};