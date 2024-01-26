package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.conexao;
import crud.Educacao;


public class educacaoDAO {
    


    public void cadastraEmpresa(Educacao educacao) {

        String sql = "INSERT INTO EMPRESA (CNPJ, NIVELENSINO, NOME, CURSO, ENDEREÇO, TELEFONE ) VALUE (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setFloat(1, educacao.getcnpj());
            ps.setString(2, educacao.getniveldeensino());
            ps.setString(3, educacao.getnome());
            ps.setString(4, educacao.getcurso());
            ps.setString(5, educacao.getendereco());
            ps.setString(6, educacao.gettelefone());
            

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

