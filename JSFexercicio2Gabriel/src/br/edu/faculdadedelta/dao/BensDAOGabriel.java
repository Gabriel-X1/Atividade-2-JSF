package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.BensGabriel;
import br.edu.faculdadedelta.util.Conexao;

public class BensDAOGabriel {

	public void incluir(BensGabriel bens) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "INSERT INTO bens (nome_bem, especificacao_bem, desc_departamento, valor_bem, data_cadastro_bem) "
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bens.getBem());
		ps.setString(2, bens.getEspecificacao());
		ps.setString(3, bens.getDepartamento());
		ps.setDouble(4, bens.getValor());
		ps.setDate(5, new java.sql.Date(bens.getData().getTime()));
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void alterar(BensGabriel bens) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "UPDATE bens SET nome_bem = ?,"
				+ "especificacao_bem = ?,"
				+ " desc_departamento = ?, "
				+ "valor_bem = ?,"
				+ " data_cadastro_bem = ?  "
				+ "WHERE id_bem = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bens.getBem());
		ps.setString(2, bens.getEspecificacao());
		ps.setString(3, bens.getDepartamento());
		ps.setDouble(4, bens.getValor());
		ps.setDate(5, new java.sql.Date(bens.getData().getTime()));
		ps.setLong(6, bens.getId());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void excluir(BensGabriel bens) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql= "DELETE FROM bens WHERE id_bem = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, bens.getId());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	public List<BensGabriel> listar() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "SELECT id_bem, nome_bem,  especificacao_bem,  desc_departamento,"
				+ " valor_bem , data_cadastro_bem FROM bens ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<BensGabriel> listaRetorno = new ArrayList<BensGabriel>();
		
		while(rs.next()) {
			BensGabriel bens = new BensGabriel();
			bens.setId(rs.getLong("id_bem"));
			bens.setBem(rs.getString("nome_bem"));
			bens.setEspecificacao(rs.getString("especificacao_bem"));
			bens.setDepartamento(rs.getString("desc_departamento"));
			bens.setValor(rs.getDouble("valor_bem"));
			bens.setData(rs.getDate("data_cadastro_bem"));
			listaRetorno.add(bens);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return listaRetorno;
	}
	
}
