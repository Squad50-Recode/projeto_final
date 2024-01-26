package br.com.empregador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.empregador.model.Educacao;
import br.com.empregadorfactory.connectionFactory;

public class EducacaoDAO {
	
	@SuppressWarnings("unused")
	private Connection conexao;
	
	public void ProdutoDao(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	public void save(Educacao educacao) {
		
		String sql = "INSERT INTO educacao(cnpj, nivelensino, nome, curso, endereco, telefone) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = connectionFactory.creatConnectiontoMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, educacao.getcnpj());
			pstm.setString(2, educacao.getnivelensino());
			pstm.setString(3, educacao.getnome());
			pstm.setString(4, educacao.getcurso());
			pstm.setString(5, educacao.getendereco());
			pstm.setString(6, educacao.gettelefone());
			
			//Executar a query
			pstm.execute();					
		}catch (Exception e) {
			e.printStackTrace();
		}finally { 
			
			//Fechar as conexoes
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
	@SuppressWarnings("unchecked")
	public List<Educacao> getEducacao(){
		
		String sql = "SELECT * FROM educacao";
		
		List<Educacao> educacao = new ArrayList<Educacao>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
				conn = connectionFactory.creatConnectiontoMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					
					Educacao educacao = new Educacao();
					
					//Recuperar os dados
					educacao.setId(rset.getString("id"));
					educacao.setcnpj(rset.getString("cnpj"));
					educacao.setcnpj(rset.getString("nivelensino"));
					educacao.setcnpj(rset.getString("nome"));
					educacao.setcnpj(rset.getString("curso"));
					educacao.setcnpj(rset.getString("endereco"));
					educacao.setcnpj(rset.getString("telefone"));
					
					((List<Educacao>) educacao).add(educacao);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
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
		
				return educacao;
	}
	}
	
	


