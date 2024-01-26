package crud;

public class Empresa {

    private String cnpj;
    private String nome;
    private float telefone;
    private String area;
    private String cargo;

    public String getcnpj() {
        return cnpj;
    }
    public void setCNPJ (String cnpj) {
        this.cnpj = cnpj;
    }

    public String getnome() {
        return nome;
    }
    public void setnome (String nome) {
        this.nome = nome;
    }

    public float gettelefone() {
        return telefone;
    }

    public void settelefone (float telefone) {
        this.telefone = telefone;
    }
    public String getarea() {
        return area;
    }

    public void setarea (String area) {
        this.area = area;
    }
    public String getcargo() {
        return cargo;
    }

    public void setcargo (String cargo) {
        this.cargo = cargo;
    }
}



