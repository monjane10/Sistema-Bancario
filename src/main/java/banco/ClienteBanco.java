package banco;

import java.io.Serializable;
import java.time.LocalDate;

public class ClienteBanco implements Serializable{
    private int numCli;
    private String nome;
    private LocalDate dataNasc;
    private String Bi;
    private String res;

    public ClienteBanco(int numCli, String nome, LocalDate dataNasc, String Bi, String res) {
        this.numCli = numCli;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.Bi = Bi;
        this.res = res;
    }

    public int getNumCli() {
        return numCli;
    }

    public void setNumCli(int numCli) {
        this.numCli = numCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getBi() {
        return Bi;
    }

    public void setBi(String Bi) {
        this.Bi = Bi;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "ClienteBanco{" + "numCli=" + numCli + ", nome=" + nome + ", dataNasc=" + dataNasc + ", Bi=" + Bi + ", res=" + res + '}';
    }
}
