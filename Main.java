import model.Metodos;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "loja";
        String password = "loja";

        try {
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Banco de dados conectado com sucesso!");

        int opcao = -1;

            while (opcao != 0) {
                opcao = Metodos.opcoesTerminal();
                if (opcao == 1) {
                    String tipoPessoa = Metodos.tipoPessoa();

                    Scanner nome = new Scanner(System.in);
                    Scanner logradouro = new Scanner(System.in);
                    Scanner cidade = new Scanner(System.in);
                    Scanner estado = new Scanner(System.in);
                    Scanner telefone = new Scanner(System.in);
                    Scanner email = new Scanner(System.in);
                    Scanner doc = new Scanner(System.in);

                    System.out.println("Informe o nome:");
                    String nomeRes = nome.nextLine();
                    System.out.println("Informe o logradouro:");
                    String logradouroRes = logradouro.nextLine();
                    System.out.println("Informe a cidade:");
                    String cidadeRes = cidade.nextLine();
                    System.out.println("Informe o estado:");
                    String estadoRes = estado.nextLine();
                    System.out.println("Informe o telefone:");
                    String telefoneRes = telefone.nextLine();
                    System.out.println("Informe o email:");
                    String emailRes = email.nextLine();

                    String sql = "INSERT INTO pessoa (nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, nomeRes);
                    preparedStatement.setString(2, logradouroRes);
                    preparedStatement.setString(3, cidadeRes);
                    preparedStatement.setString(4, estadoRes);
                    preparedStatement.setString(5, telefoneRes);
                    preparedStatement.setString(6, emailRes);
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (tipoPessoa.equals("f")) {

                        int idPessoa = Metodos.obterUltimoID(connection);

                        System.out.println("Informe o CPF:");
                        long docRes = doc.nextLong();
                        String sqlFisica = "INSERT INTO fisica (nome, logradouro, cidade, estado, telefone, email, idpessoa, cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlFisica);
                        preparedStatement1.setString(1, nomeRes);
                        preparedStatement1.setString(2, logradouroRes);
                        preparedStatement1.setString(3, cidadeRes);
                        preparedStatement1.setString(4, estadoRes);
                        preparedStatement1.setString(5, telefoneRes);
                        preparedStatement1.setString(6, emailRes);
                        preparedStatement1.setInt(7, idPessoa);
                        preparedStatement1.setLong(8, docRes);
                        int rowsAffectedFisica = preparedStatement1.executeUpdate();

                        if (rowsAffected > 0 && rowsAffectedFisica > 0) {
                            System.out.println("Inserção realizada com sucesso!");
                        } else {
                            System.out.println("Nenhum dado foi inserido.");
                        }
                    } else if (tipoPessoa.equals("j")) {
                       int idPessoa = Metodos.obterUltimoID(connection);

                        System.out.println("Informe o CNPJ:");
                        long docRes = doc.nextLong();
                        String sqlFisica = "INSERT INTO juridica (nome, logradouro, cidade, estado, telefone, email, idpessoa, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlFisica);
                        preparedStatement1.setString(1, nomeRes);
                        preparedStatement1.setString(2, logradouroRes);
                        preparedStatement1.setString(3, cidadeRes);
                        preparedStatement1.setString(4, estadoRes);
                        preparedStatement1.setString(5, telefoneRes);
                        preparedStatement1.setString(6, emailRes);
                        preparedStatement1.setInt(7, idPessoa);
                        preparedStatement1.setLong(8, docRes);
                        int rowsAffectedJuridica = preparedStatement1.executeUpdate();

                        if (rowsAffected > 0 && rowsAffectedJuridica > 0) {
                            System.out.println("Inserção realizada com sucesso!");
                        } else {
                            System.out.println("Nenhum dado foi inserido.");
                        }
                    }
                } else if (opcao == 2) {
                    String tipoPessoa = Metodos.tipoPessoa();

                    Scanner nome = new Scanner(System.in);
                    Scanner logradouro = new Scanner(System.in);
                    Scanner cidade = new Scanner(System.in);
                    Scanner estado = new Scanner(System.in);
                    Scanner telefone = new Scanner(System.in);
                    Scanner email = new Scanner(System.in);
                    Scanner doc = new Scanner(System.in);
                    Scanner id = new Scanner(System.in);

                    System.out.println("Insira o ID da pessoa que deseja alterar:");
                    int idP = id.nextInt();
                    System.out.println("Insira o nome da pessoa que deseja alterar:");
                    String novoNome = nome.nextLine();
                    System.out.println("Insira o logradouro da pessoa que deseja alterar:");
                    String novoLogradouro = logradouro.nextLine();
                    System.out.println("Insira a cidade da pessoa que deseja alterar:");
                    String novoCidade = cidade.nextLine();
                    System.out.println("Insira o estado da pessoa que deseja alterar:");
                    String novoEstado = estado.nextLine();
                    System.out.println("Insira o telefone da pessoa que deseja alterar:");
                    String novoTelefone = telefone.nextLine();
                    System.out.println("Insira o email da pessoa que deseja alterar:");
                    String novoEmail = email.nextLine();

                    String sql = "UPDATE pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE idpessoa = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, novoNome);
                    preparedStatement.setString(2, novoLogradouro);
                    preparedStatement.setString(3, novoCidade);
                    preparedStatement.setString(4, novoEstado);
                    preparedStatement.setString(5, novoTelefone);
                    preparedStatement.setString(6, novoEmail);
                    preparedStatement.setInt(7, idP);

                    int linhasAfetadas = preparedStatement.executeUpdate();

                    if (tipoPessoa.equals("f")) {
                        System.out.println("Insira o CPF atualizado:");
                        Long cpf = doc.nextLong();
                        String sqlPf = "UPDATE fisica SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, cpf = ? WHERE idpessoa = ?";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlPf);
                        preparedStatement1.setString(1, novoNome);
                        preparedStatement1.setString(2, novoLogradouro);
                        preparedStatement1.setString(3, novoCidade);
                        preparedStatement1.setString(4, novoEstado);
                        preparedStatement1.setString(5, novoTelefone);
                        preparedStatement1.setString(6, novoEmail);
                        preparedStatement1.setLong(7, cpf);
                        preparedStatement1.setInt(8, idP);

                        int linhasAfetadas1 = preparedStatement1.executeUpdate();
                        if (linhasAfetadas > 0 && linhasAfetadas1 > 0) {
                            System.out.println("Atualização bem-sucedida!");
                        } else {
                            System.out.println("Nenhum registro atualizado. Verifique o ID da pessoa.");
                        }
                    } else if (tipoPessoa.equals("j")) {
                        System.out.println("Insira o CNPJ atualizado:");
                        Long cnpj = doc.nextLong();
                        String sqlPf = "UPDATE juridica SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, cnpj = ? WHERE idpessoa = ?";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlPf);
                        preparedStatement1.setString(1, novoNome);
                        preparedStatement1.setString(2, novoLogradouro);
                        preparedStatement1.setString(3, novoCidade);
                        preparedStatement1.setString(4, novoEstado);
                        preparedStatement1.setString(5, novoTelefone);
                        preparedStatement1.setString(6, novoEmail);
                        preparedStatement1.setLong(7, cnpj);
                        preparedStatement1.setInt(8, idP);

                        int linhasAfetadas1 = preparedStatement1.executeUpdate();
                        if (linhasAfetadas > 0 && linhasAfetadas1 > 0) {
                            System.out.println("Atualização bem-sucedida!");
                        } else {
                            System.out.println("Nenhum registro atualizado. Verifique o ID da pessoa.");
                        }
                    }
                } else if (opcao == 3) {
                    String tipoPessoa = Metodos.tipoPessoa();

                    Scanner id = new Scanner(System.in);
                    System.out.println("Digite o ID de quem deseja excluir:");
                    int idP = id.nextInt();
                    String sqlpessoa = "DELETE FROM pessoa WHERE idpessoa = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sqlpessoa);
                    preparedStatement.setInt(1, idP);
                    int rowsDeletedPessoa = preparedStatement.executeUpdate();

                    if (tipoPessoa.equals("f")) {
                        try {
                            String sql = "DELETE FROM fisica WHERE idpessoa = ?";
                            PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                            preparedStatement1.setInt(1, idP);
                            int rowsDeleted = preparedStatement1.executeUpdate();
                            if (rowsDeleted > 0 && rowsDeletedPessoa > 0) {
                                System.out.println("Registro deletado com sucesso!");
                            } else {
                                System.out.println("Nenhum registro encontrado com o ID fornecido!");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else if (tipoPessoa.equals("j")) {
                        try {
                            String sql = "DELETE FROM juridica WHERE idpessoajuridica = ?";
                            PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                            preparedStatement1.setInt(1, idP);
                            int rowsDeleted = preparedStatement1.executeUpdate();
                            if (rowsDeleted > 0) {
                                System.out.println("Registro deletado com sucesso!");
                            } else {
                                System.out.println("Nenhum registro encontrado com o ID fornecido!");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (opcao == 4) {
                    String tipoPessoa = Metodos.tipoPessoa();
                    if (tipoPessoa.equals("f")) {
                        Scanner id = new Scanner(System.in);
                        System.out.println("Digite o ID para realizar a busca:");
                        int idPf = id.nextInt();
                        try {
                            PreparedStatement preparedStatement = null;
                            ResultSet resultSet = null;
                            String sql = "SELECT * FROM fisica WHERE idpessoafisica = ?";
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setInt(1, idPf);
                            resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {
                                System.out.println("##########################################");
                                System.out.println("Id: " + resultSet.getInt("idpessoa"));
                                System.out.println("Nome: " + resultSet.getString("nome"));
                                System.out.println("Logradouro: " + resultSet.getString("logradouro"));
                                System.out.println("Cidade: " + resultSet.getString("cidade"));
                                System.out.println("Estado: " + resultSet.getString("estado"));
                                System.out.println("Telefone: " + resultSet.getString("telefone"));
                                System.out.println("Email: " + resultSet.getString("email"));
                                System.out.println("CPF: " + resultSet.getLong("cpf"));
                                System.out.println("##########################################");
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else if (tipoPessoa.equals("j")) {
                        Scanner id = new Scanner(System.in);
                        int idPj = id.nextInt();
                        try {
                            PreparedStatement preparedStatement = null;
                            ResultSet resultSet = null;
                            String sql = "SELECT * FROM juridica WHERE idpessoajuridica = ?";
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setInt(1, idPj);
                            resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {
                                System.out.println("##########################################");
                                System.out.println("Id: " + resultSet.getInt("idpessoa"));
                                System.out.println("Nome: " + resultSet.getString("nome"));
                                System.out.println("Logradouro: " + resultSet.getString("logradouro"));
                                System.out.println("Cidade: " + resultSet.getString("cidade"));
                                System.out.println("Estado: " + resultSet.getString("estado"));
                                System.out.println("Telefone: " + resultSet.getString("telefone"));
                                System.out.println("Email: " + resultSet.getString("email"));
                                System.out.println("CNPJ: " + resultSet.getLong("cnpj"));
                                System.out.println("##########################################");
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (opcao == 5) {
                    String tipoPessoa = Metodos.tipoPessoa();
                    if (tipoPessoa.equals("f")) {
                        System.out.println("Exibindo dados de Pessoa Fisíca...");
                        Metodos.restauraObjeto("pf", connection);
                    } else if (tipoPessoa.equals("j")) {
                        System.out.println("Exibindo dados de Pessoa Jurídica...");
                        Metodos.restauraObjeto("pj", connection);
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    };
};
