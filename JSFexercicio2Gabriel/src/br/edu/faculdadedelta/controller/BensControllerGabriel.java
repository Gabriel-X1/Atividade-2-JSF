package br.edu.faculdadedelta.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.BensDAOGabriel;
import br.edu.faculdadedelta.modelo.BensGabriel;
@SessionScoped
@ManagedBean
public class BensControllerGabriel {
	
private BensGabriel bens = new BensGabriel();
private BensDAOGabriel dao = new BensDAOGabriel();

public BensGabriel getBens() {
	return bens;
}
public void setBens(BensGabriel bens) {
	this.bens = bens;
}
public void limparcampos() {
	bens = new BensGabriel();
}
public String Salvar() {
	try {
	if(bens.getId() == null) {
		
	dao.incluir(bens);	
	FacesMessage mensagem = new FacesMessage("Inclusao realizada com sucesso!!");
	FacesContext.getCurrentInstance().addMessage(null, mensagem);
	limparcampos();
	}else {
		dao.alterar(bens);
		FacesMessage mensagem = new FacesMessage("Alteraçao realizada com sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		limparcampos();
	}
	}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage mensagem = new FacesMessage("Erro ao Realizar operaçao"
					+ " tente novamente mais tarde!!" + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparcampos();
			}
	
	return "CadastroBens.xhtml";
}
public List<BensGabriel> getLista(){
	List<BensGabriel> listaRetorno = new ArrayList<BensGabriel>();
	try {
		listaRetorno = dao.listar();
	} catch (ClassNotFoundException | SQLException e) {
		FacesMessage mensagem = new FacesMessage("Erro ao Realizar operaçao"
				+ " tente novamente mais tarde!!" + e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		e.printStackTrace();
	}
	return listaRetorno;
}
public String Editar() {
	return "CadastroBens.xhtml";
}
public String Excluir() {
	try {
		dao.excluir(bens);
		FacesMessage mensagem = new FacesMessage("Exclusao realizada com sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		limparcampos();
	} catch (ClassNotFoundException | SQLException e) {
		FacesMessage mensagem = new FacesMessage("Erro ao Realizar operaçao"
				+ " tente novamente mais tarde!!" + e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		e.printStackTrace();
	}
	
	return "ListarBens.xhtml";
}

}
