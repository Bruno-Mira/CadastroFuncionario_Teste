package model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Funcionario {
	
	@Id
	private String nome;
	private int idade;
	private String sexo; // oneRadio
	private String estadoCivil; // oneMenu
	private boolean Filhos; // oneSwitch , verdadeiro se possui filhos e falso se não possui
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public boolean isFilhos() {
		return Filhos;
	}
	public void setFilhos(boolean Filhos) {
		this.Filhos = Filhos;
	} 
}