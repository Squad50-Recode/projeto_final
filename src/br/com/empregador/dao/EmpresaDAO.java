package br.com.empregador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.empregador.model.Empresa;
import br.com.empregadorfactory.connectionFactory;

public class EmpresaDAO {

    public void salvar(Empresa empresa) {

        String sql = "INSERT INTO empresa(cnpj, nome, telefone, area, cargo) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setFloat(1, empresa.getCnpj());
            pstm.setString(2, empresa.getNome());
            pstm.setFloat(3, empresa.getTelefone());
            pstm.setString(4, empresa.getArea());
            pstm.setString(5, empresa.getCargo());

            pstm.execute();

            System.out.println("Empresa salva com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Empresa> obterEmpresas() {

        String sql = "SELECT * FROM empresa";

        List<Empresa> empresas = new ArrayList<Empresa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = connectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Empresa empresa = new Empresa();

                empresa.setId(rset.getInt("id"));
                empresa.setCnpj(rset.getFloat("cnpj"));
                empresa.setNome(rset.getString("nome"));
                empresa.setTelefone(rset.getFloat("telefone"));
                empresa.setArea(rset.getString("area"));
                empresa.setCargo(rset.getString("cargo"));

                empresas.add(empresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return empresas;
    }
}

