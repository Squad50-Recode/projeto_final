package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.conexao;
import crud.Empresa;

public class empresaDAO {
    
    public void cadastraEmpresa(Empresa empresa) {

        String sql = "INSERT INTO EMPRESA (cnpj, Nome, Area, Cargo) VALUE (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(4, empresa.getcnpj());
            ps.setString(2, empresa.getnome());
            ps.setString(3, empresa.getarea());
            ps.setString(4, empresa.getcargo());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
