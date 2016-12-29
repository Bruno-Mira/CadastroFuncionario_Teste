package services;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Funcionario;


public class FuncionarioJPA {
	
	private EntityManagerFactory emf;
	
	
	
		public FuncionarioJPA() {
		emf = Persistence.createEntityManagerFactory("CadastroFuncionario");
	}

		public void salvar(Funcionario funcionario){
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
				em.persist(funcionario);
			em.getTransaction().commit();
			
		
			em.close();
		}
		
		public void atualizar(Funcionario funcionario){
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
				em.merge(funcionario);
			em.getTransaction().commit();
			
	
			em.close();
		}
		
		public void deletar(Funcionario f){
			EntityManager em = emf.createEntityManager();
			
			f = em.find(Funcionario.class, f.getNome()); // torna o objeto gerenciável
			em.getTransaction().begin();
			em.remove(f);
		em.getTransaction().commit();
		
	
		em.close();
		}
		
		public List<Funcionario> ListarTodos(){
			EntityManager em = emf.createEntityManager();
			List<Funcionario> funcionarios = new ArrayList();
			
			Query q = em.createQuery("select l from Funcionario l");
			funcionarios = q.getResultList();
			
	
			em.close();
			
			return funcionarios;
		}
}