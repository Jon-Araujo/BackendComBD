package model;
import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable{
    long cnpj;


    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
}
