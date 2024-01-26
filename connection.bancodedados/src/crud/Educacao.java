package crud;

public class Educacao {
    private float cnpj;
    private String niveldeensino;
    private String nome;
    private String curso;
    private String endereco;
    private String telefone;

    public float getcnpj() {
        return cnpj;
    }
    public void setCNPJ (float cnpj) {
        this.cnpj = cnpj;
    }

    public String getniveldeensino() {
        return niveldeensino;
    }
    public void setniveldeensino (String niveldeensino) {
        this.niveldeensino = niveldeensino;
    }

    public String getnome() {
        return nome;
    }
    public void setnome (String nome) {
        this.nome = nome;
    }

    public String getcurso() {
        return curso;
    }
    public void setcurso (String curso) {
        this.curso = curso;
    }

    public String getendereco() {
        return endereco;
    }
    public void setendereco (String endereco) {
        this.endereco = endereco;
    }

    public String gettelefone() {
        return telefone;
    }
    public void settelefone (String telefone) {
        this.telefone = telefone;
    }
}

