package model;
import java.io.Serializable;


public class Pessoa implements Serializable{
    int id;
    String nome;

    public static void exibir() {
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

    public void setNome(String texto) {
        this.nome = texto;
    }

    public static void msg(String tipo) {
        System.out.println("Dados de Pessoa " + tipo + " Armazenados.");
        System.out.println("Dados de Pessoa " + tipo + " Recuperados.");
    }
}
