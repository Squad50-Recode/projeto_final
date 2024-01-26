package br.com.empregador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import br.com.empregador.model.Empregador;
import br.com.empregadorfactory.connectionFactory;

public class EmpregadorDAO {

	
	@SuppressWarnings("unused")
	private static final String Resultset = null;

	/*
	 * Create, Read, Update, Delete
	 */
	
	public void save(Empregador empregador) {

	
		@SuppressWarnings("unused")
		String sql = "INSERT INTO Empregador(cnpj, nome, cargo, ramo) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = connectionFactory.creatConnectiontoMySQL();
			
			//Criamos uma PreparedStatemet, para executar uma Query
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores que são esperados pela Quary
			pstm.setString(1, empregador.getCnpj());
			pstm.setString(2, empregador.getNome());
			pstm.setString(3, empregador.getCargo());
			pstm.setString(4, empregador.getRamo());
			
			//Executar a Quary
			pstm.execute();		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	

		@SuppressWarnings("unused")
		public void update(Empregador empregador) {
			
			String sql = "UPADATE perifa SET nome = ?, cnpj = ?, nome = ?, cargo = ?, ramo = ?"+
			"WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				//Criar conexão com o banco
				conn = connectionFactory.creatConnectiontoMySQL();
				
				//Criar a classe para executar a quary
				pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
				pstm.setString(1, empregador.getNome());
				pstm.setString(2, empregador.getCnpj());
				pstm.setString(3, empregador.getCargo());
				pstm.setString(4, empregador.getRamo());
				
				//Qual o Id do registro que deseja atualizar
				pstm.setString(5, empregador.getId());
				
				//Executar a quary
				pstm.execute();
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
						
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
		}
		
	public void deleteByID(String id) {
		
		String sql = "DELETE FROM empregador WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = connectionFactory.creatConnectiontoMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(5, id);
			
			pstm.execute();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	@SuppressWarnings("unused")
	public List<Empregador> getempregador(){
	
	String sql = "SELECT * FROM empregador";
	
	List<Empregador> empregador = new ArrayList<Empregador>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	// Classe que vai recuperar os dados do banco ****SELECT****
	ResultSet rst = null;
			
	try {
		conn = connectionFactory.creatConnectiontoMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		ResultSet rset = pstm.executeQuery();
		
		
		while (rset.next()) {
			Empregador Empregador = new Empregador();
			
			//Recuperar o id
			Empregador.setid(rset.getString("id"));
			//Recuperar o cnpj
			Empregador.setCnpj(rset.getString("cnpj"));
			//recuperar nome
			Empregador.setNome(rset.getString("nome"));
			//recuperar cargo
			Empregador.setCargo(rset.getString("cargo"));
			//recuperar ramo
			Empregador.setCargo(rset.getString("ramo"));
			
			Empregador.add(empregador);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			Connection rset = null;
			if(rset!=null) {
				rset.close();
			}
			
			if(pstm!=null) {
				pstm.close();
		}
		
		if(conn!=null) {
			conn.close();
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
		return empregador;
	}
}
