package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Metodos {
    public static ArrayList<ArrayList<String>> restauraObjeto(String caminho) {
        try {
            FileInputStream recuperaArquivo = new FileInputStream(caminho);
            ObjectInputStream stream = new ObjectInputStream(recuperaArquivo);

            ArrayList<ArrayList<String>> objeto = (ArrayList<ArrayList<String>>) stream.readObject();


//            ArrayList<ArrayList<String>> listaConvertida = new ArrayList<>();
//
//            if (objeto instanceof ArrayList) {
//                ArrayList<String[]> objetoParaArray = (ArrayList<String[]>) objeto;
//
//                for (String[] array : objetoParaArray) {
//                    ArrayList<String> passaLista = new ArrayList<String>();
//                    passaLista.addAll(Arrays.asList(array));
//                    listaConvertida.add(passaLista);
//                    for (String element : array) {
//                        passaLista.add(element);
//                    }
//                    listaConvertida.addAll(Arrays.asList(passaLista));
//                }
//            }
            System.out.println(objeto);
            stream.close();

            return objeto;
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
    };

    public static void salvaObjeto(ArrayList<ArrayList<String>> objeto, String caminho) {
        try {
            FileOutputStream salvaArquivo = new FileOutputStream(caminho);
            ObjectOutputStream stream = new ObjectOutputStream(salvaArquivo);

            stream.writeObject(objeto);
            stream.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    };

    public static void exibirPf (int id, String nome, long cpf, int idade) {
        System.out.println("Id: "+ id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    };

    public static void exibirPj(int id, String nome, long cnpj) {
        System.out.println("Id: "+ id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cnpj);
    };

    public static int opcoesTerminal() {
        System.out.println("""
                ================================================
                1 - Incluir Pessoa
                2 - Alterar Pessoa
                3 - Excluir Pessoa
                4 - Buscar pelo Id
                5 - Exibir Todos
                6 - Persistir Dados
                7 - Recuperar Dados
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

    public static ArrayList<ArrayList<String>> opcao1(String tipoPessoa, ArrayList<ArrayList<String>> lista) {
        System.out.println("Insira os dados:");

        Scanner nome = new Scanner(System.in);
        Scanner doc = new Scanner(System.in);

        if (tipoPessoa == "fisica") {
            Scanner idade = new Scanner(System.in);

            int id = lista.size() + 1;
            System.out.println("Informe o Nome:");
            String name = nome.nextLine();
            System.out.println("Informe o CPF:");
            long cpf = doc.nextLong();
            System.out.println("informe a idade:");
            int age = idade.nextInt();

            ArrayList<String> passaLista = new ArrayList<>();
            passaLista.add(Integer.toString(id));
            passaLista.add(name);
            passaLista.add(Long.toString(cpf));
            passaLista.add(Integer.toString(age));

            lista.addAll(Arrays.asList(passaLista));

            System.out.println(lista);


        } else if (tipoPessoa == "juridica") {
            int id = lista.size() + 1;
            System.out.println("Informe o Nome:");
            String name = nome.nextLine();
            System.out.println("Informe o CNPJ:");
            long cnpj = doc.nextLong();

            ArrayList<String> passaLista = new ArrayList<>();
            passaLista.add(Integer.toString(id));
            passaLista.add(name);
            passaLista.add(Long.toString(cnpj));

            lista.addAll(Arrays.asList((passaLista)));

            System.out.println(lista);
        }
        return lista;
    };

    public static ArrayList<ArrayList<String>> opcao2(String tipoPessoa, ArrayList<ArrayList<String>> lista) {
        System.out.println("Escreva o nome que deseja alterar:");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine().toLowerCase();
        for (int i = 0; i < lista.size(); i++) {

            if (Objects.equals(nome, lista.get(i).get(1).toLowerCase())) {
                if (tipoPessoa == "fisica") {
                    System.out.println("Digite o nome a ser alterado:");
                    Scanner name = new Scanner(System.in);
                    lista.get(i).set(1, name.nextLine());

                    System.out.println("Digite o novo CPF:");
                    Scanner doc = new Scanner(System.in);
                    lista.get(i).set(2, doc.nextLine());

                    System.out.println("Digite a idade corrigida:");
                    Scanner idade = new Scanner(System.in);
                    lista.get(i).set(3, idade.nextLine());
                } else if (tipoPessoa == "juridica") {
                    System.out.println("Digite o nome a ser alterado:");
                    Scanner name = new Scanner(System.in);
                    lista.get(i).set(1, name.nextLine());

                    System.out.println("Digite o novo CNPJ:");
                    Scanner doc = new Scanner(System.in);
                    lista.get(i).set(2, doc.nextLine());
                }
            }
        }
        return lista;
    };

    public static ArrayList<ArrayList<String>> opcao3(ArrayList<ArrayList<String>> lista) {
        System.out.println("Escreva o nome que deseja alterar:");
        Scanner name = new Scanner(System.in);
        String nome = name.nextLine().toLowerCase();
        for (int i = 0; i < lista.size(); i++) {
            if (Objects.equals(nome, lista.get(i).get(1).toLowerCase())) {
                lista.remove(i);
            }
        }
        System.out.println("Deletado com Sucesso!");
        return lista;
    };

    public static void opcao4(String tipoPessoa, ArrayList<ArrayList<String>> lista) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o número do ID que deseja buscar:");
        int id = input.nextInt();

        for (int i = 0; i < lista.size(); i++) {
            if (Objects.equals(Integer.toString(id), lista.get(i).get(0))) {
                if (tipoPessoa == "fisica") {
                    System.out.println("Id:" + lista.get(i).get(0));
                    System.out.println("Nome:" + lista.get(i).get(1));
                    System.out.println("CPF:" + lista.get(i).get(2));
                    System.out.println("Idade:" + lista.get(i).get(3));
                } else if (tipoPessoa == "juridica") {
                    System.out.println("Id:" + lista.get(i).get(0));
                    System.out.println("Nome:" + lista.get(i).get(1));
                    System.out.println("CNPJ:" + lista.get(i).get(2));
                }
            }
        }

    };

    public static void opcao5 (String tipoPessoa, ArrayList<ArrayList<String>> lista) {
        if (tipoPessoa == "fisica") {
            for (int i = 0; i < lista.size(); i++){
                System.out.println("---------------------------------");
                System.out.println("Id:" + lista.get(i).get(0));
                System.out.println("Nome:" + lista.get(i).get(1));
                System.out.println("CPF:" + lista.get(i).get(2));
                System.out.println("Idade:" + lista.get(i).get(3));
            }
            System.out.println("---------------------------------");
        } else if (tipoPessoa == "juridica") {
            for (int i = 0; i < lista.size(); i++){
                System.out.println("---------------------------------");
                System.out.println("Id:" + lista.get(i).get(0));
                System.out.println("Nome:" + lista.get(i).get(1));
                System.out.println("CNPJ:" + lista.get(i).get(2));
            }
            System.out.println("---------------------------------");
        }

    }
}