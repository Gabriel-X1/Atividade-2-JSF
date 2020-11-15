package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class BensGabriel {
private Long id;
private String bem;
private String especificacao;
private String departamento;
private double valor;
private Date data;

public BensGabriel() {
}

public BensGabriel(Long id, String bem, String especificacao, String departamento, double valor, Date data) {
	this.id = id;
	this.bem = bem;
	this.especificacao = especificacao;
	this.departamento = departamento;
	this.valor = valor;
	this.data = data;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getBem() {
	return bem;
}

public void setBem(String bem) {
	this.bem = bem;
}

public String getEspecificacao() {
	return especificacao;
}

public void setEspecificacao(String especificacao) {
	this.especificacao = especificacao;
}

public String getDepartamento() {
	return departamento;
}

public void setDepartamento(String departamento) {
	this.departamento = departamento;
}

public double getValor() {
	return valor;
}

public void setValor(double valor) {
	this.valor = valor;
}

public Date getData() {
	return data;
}

public void setData(Date data) {
	this.data = data;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BensGabriel other = (BensGabriel) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
