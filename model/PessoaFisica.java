package model;
import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable{
    long cpf;

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
