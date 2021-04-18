package ProjetoMV.ProjetoMV;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Sorvete;
import util.JpaUtil;

public class AppTeste {

	public static void main(String[] args) {
		// Traz uma lista com todos os sorvetes presentes na tabela de sorvetes do banco
		// de dados
//		Sorvete s1 = new Sorvete();
//		List<Sorvete> listarSorvetes = buscarTodos(s1);
//		for(Sorvete sorvete : listarSorvetes) {
//			System.out.println("Nome: "+ sorvete.getNome() +" Fabricante: "+ sorvete.getFabricante()
//			+" Igredientes: "+ sorvete.getIngredientes());
//		}

		// Traz um específico
//		String sabor = "cÔcO";
//		Sorvete sorvete = new Sorvete();
//		List<Sorvete> listaSorvetes = buscarTodos(sorvete);
//		for(Sorvete s : listaSorvetes) {
//			if(s.getNome() .equalsIgnoreCase(sabor)) {
//			System.out.println("Nome:"+ s.getNome() +" Fabricante: "+ s.getFabricante()
//			+" Igredientes: "+ s.getIngredientes());
//			}
//		}

		// Inseri um sorvete na tabela sorvetes do banco de dados
//		String nome = "macaiba", fabricante = "xselva", igredientes = "Macaiba da selva";
//		Sorvete s = new Sorvete();
//		s.setNome(nome);
//		s.setFabricante(fabricante);
//		s.setIngredientes(igredientes);
//		inserir(s);

		// Deletar um sorvete
		String sabor = "Côco";
		remover(Sorvete.class, sabor);
	}

	// Fora do Main
	// Método inserir
	public static void inserir(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		ent.merge(obj);
		tx.commit();
		ent.close();
		System.out.println("Inserção efetuada com sucesso!");
	}

	public static List buscarTodos(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		Query query = ent.createQuery(" from " + obj.getClass().getSimpleName());
		return query.getResultList();
	}

	public static Object buscarEspecifico(Class classe, Object primaryKey) {
		EntityManager ent = JpaUtil.getEntityManager();
		return ent.find(classe, primaryKey);
	}

	public static void remover(Class classe, Object primaryKey) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		Object obj = ent.find(classe, primaryKey);
		ent.remove(obj);
		tx.commit();
		ent.close();
		System.out.println("Sorvete descartado!");
	}

}