package crud;

public class Empregador {
   
    private String cnpj;
    private String nome;
    private String cargo;
    private String ramo;

    public String getCnpj() {
        return cnpj;
    }
    public void setcnpj (String cnpj) { 
        this.cnpj = cnpj;
    }

    public String getnome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcargo() {
        return cargo;
    }
    public void setcargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRamo() {
        return ramo;
    }
    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
}