package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.conexao;
import crud.Empregador;

public class empregadorDAO {
    


    public void cadastraEmpresa(Empregador empregador) {

        String sql = "INSERT INTO EMPRESA (CNPJ, NOME, CARGO, RAMO) VALUE (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, empregador.getCnpj());
            ps.setString(2, empregador.getnome());
            ps.setString(3, empregador.getcargo());
            ps.setString(4, empregador.getRamo());
            

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

