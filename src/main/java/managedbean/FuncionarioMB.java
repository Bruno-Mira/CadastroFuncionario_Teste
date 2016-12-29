package managedbean;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import services.FuncionarioJPA;
import model.Funcionario;

@ManagedBean
@SessionScoped
public class FuncionarioMB {
	
	private Funcionario funcionario = new Funcionario();
	private FuncionarioJPA jpa = new FuncionarioJPA();
	private List<Funcionario> funcionarios = null; 
	private List<Funcionario> filtroFunc ;
	
	//metodo que busca no JPA todos os Funcionarios e retorna em funcionarios
	// só faz isso uma vez
	public List<Funcionario> getallFuncionario(){
		if(funcionarios == null){
			funcionarios =  jpa.ListarTodos();
		}
		return funcionarios;
	}
	
	//Metodo para Salvar tanto no banco quanto na List funcionarios
	public void salvarBanco(){
		jpa.salvar(funcionario);
		
		if(funcionarios != null)
			addFuncionarios(funcionario);
		
		funcionario = new Funcionario();
	}
	
	//metodo que faz a atualização de um funcionario no banco
	public void onRowEdit(RowEditEvent event){
		Funcionario func = ((Funcionario) event.getObject());
		
		jpa.atualizar(func);
	}

	//metodo que deleta um funcionario do banco
	//preciso implementar no JPA
	public void deletarBanco(Funcionario f){
		funcionarios.remove(f);
		jpa.deletar(f);
		//jpa.deletar(f);
	}
	
	//adiciona um funcionario na lista
	public void addFuncionarios(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public FuncionarioJPA getJpa() {
		return jpa;
	}


	public void setJpa(FuncionarioJPA jpa) {
		this.jpa = jpa;
	}

	public List<Funcionario> getFiltroFunc() {
		return filtroFunc;
	}

	public void setFiltroFunc(List<Funcionario> filtroFunc) {
		this.filtroFunc = filtroFunc;
	}
	
	
}