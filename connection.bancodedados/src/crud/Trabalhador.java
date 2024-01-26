package crud;

public class Trabalhador {
    private String CPF;
    private String Nome;
    private String Email;
    private String DataNascimento;
    private String Sexo;
    private String Telefone ;
    private String CEP;
    private String Rua;
    private String Estado;
    private String Numero;
    private String RG;

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail (String Email) {
        this.Email = Email;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }
    public void setDataNascimento (String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getSexo() {
        return Sexo;
    }
    public void setSexo (String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefone() {
        return Telefone;
    }
    public void setTelefone (String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCEP() {
        return CEP;
    }
    public void setCEP (String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return Rua;
    }
    public void setRua (String Rua) {
        this.Rua = Rua;
    }

    public String getEstado() {
        return Estado;
    }
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNumero() {
        return Numero;
    }
    public void setNumero (String Numero) {
        this.Numero = Numero;
    }

    public String getRG() {
        return RG;
    }
    public void setRG (String RG) {
        this.RG = RG;
    }
}