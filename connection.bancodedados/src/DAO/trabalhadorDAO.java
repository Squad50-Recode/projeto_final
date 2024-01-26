package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.conexao;
import crud.Trabalhador;

public class trabalhadorDAO {

    public void cadastraEmpresa(Trabalhador trabalhador) {

        String sql = "INSERT INTO EMPRESA (CPF, NOME, EMAIL, DATANASCIMENTO, SEXO, TELEFONE, CEP, RUA, ESTADO, NUMERO, RG ) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, trabalhador.getCPF());
            ps.setString(2, trabalhador.getNome());
            ps.setString(3, trabalhador.getEmail());
            ps.setString(4, trabalhador.getDataNascimento());
            ps.setString(5, trabalhador.getSexo());
            ps.setString(6, trabalhador.getTelefone());
            ps.setString(7, trabalhador.getCEP());
            ps.setString(8, trabalhador.getRua());
            ps.setString(9, trabalhador.getEstado());
            ps.setString(10, trabalhador.getNumero());
            ps.setString(11, trabalhador.getRG());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
    
