package br.com.empregador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.empregador.model.Trabalhador;
import br.com.empregadorfactory.connectionFactory;

public class TrabalhadorDAO {

	
@SuppressWarnings("unused")
private Connection conexao;
	
	public TrabalhadorDAO(Connection  conexao) {
		this.conexao = conexao;
		
	}
	
	public void save (Trabalhador trabalhador) {
		
String sql = "INSERT INTO educacao(CPF, Nome, Email, DataNascimento, Sexo, Telefone, CEP, Rua, Estado, Numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = connectionFactory.creatConnectiontoMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, trabalhador.getCPF());
			pstm.setString(2, trabalhador.getEmail());
			pstm.setString(3, trabalhador.getDataNascimento());
			pstm.setString(4, trabalhador.getSexo());
			pstm.setString(5, trabalhador.getTelefone());
			pstm.setString(6, trabalhador.getCEP());
			pstm.setString(6, trabalhador.getRua());
			pstm.setString(6, trabalhador.getEstado());
			pstm.setString(6, trabalhador.getNumero());
			
			
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
	public List<Trabalhador> getTrabalhador(){
		
		String sql = "SELECT * FROM trabalhador";
		
		List<Trabalhador> trabalhador = new ArrayList<Trabalhador>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
				conn = connectionFactory.creatConnectiontoMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					
					Trabalhador trabalhador1 = new Trabalhador();
					
					//Recuperar os dados
					((Trabalhador) trabalhador).setId(rset.getInt("id"));
					((Trabalhador) trabalhador).setCPF(rset.getString("CPF"));
					((Trabalhador) trabalhador).setNome(rset.getString("Nome"));
					((Trabalhador) trabalhador).setEmail(rset.getString("Email"));
					((Trabalhador) trabalhador).setDataNascimento(rset.getString("DataNascimento"));
					((Trabalhador) trabalhador).setSexo(rset.getString("Sexo"));
					((Trabalhador) trabalhador).setCEP(rset.getString("CEP"));
					((Trabalhador) trabalhador).setRua(rset.getString("Rua"));
					((Trabalhador) trabalhador).setEstado(rset.getString("Estado"));
					((Trabalhador) trabalhador).setNumero(rset.getString("Numero"));
					
					
					((List<Trabalhador>) trabalhador).add((Trabalhador) trabalhador);
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
		
				return trabalhador;
	}
	}
	

