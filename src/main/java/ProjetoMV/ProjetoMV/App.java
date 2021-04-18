package ProjetoMV.ProjetoMV;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.GestorSorveteGeralDAO;
import dao.GestorSorveteGeralDAOImp;
import entidade.Sorvete;
import util.JpaUtil;

/**
 * Hello world!1
 * 
 *
 */
public class App {
	public static void main(String[] args) {
		GestorSorveteGeralDAO geralDAO = new GestorSorveteGeralDAOImp();
		System.out.println("1-Listar\n2-Inserir\n3-Deletar");
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		if (opcao == 1) {
			System.out.println("Você escolheu opção de lista");
			System.out.println("1-Listar todos os sorvetes\n2-Buscar dados de um sabor específico");
			Scanner listarScanner = new Scanner(System.in);
			int opcaoLista = listarScanner.nextInt();
			if (opcaoLista == 1) {
				Sorvete sorvete = new Sorvete();
				List<Sorvete> sorvetes = geralDAO.buscarTodos(sorvete);
				for (Sorvete svt : sorvetes) {
					System.out.println("Sabor: " + svt.getNome() + " Fabricante: " + svt.getFabricante()
							+ " Igredientes: " + svt.getIngredientes());
				}
			} else if (opcaoLista == 2) {
				System.out.println("Á baixo está a lista de sorvetes:\nescolha um sabor:\n");
				Sorvete sorvete = new Sorvete();
				List<Sorvete> listaSorvetes = geralDAO.buscarTodos(sorvete);
				for (Sorvete svt : listaSorvetes) {
					System.out.println("Sabor: " + svt.getNome() + " Fabricante: " + svt.getFabricante()
							+ " Igredientes: " + svt.getIngredientes());
				}
				System.out.println("Informe o sabor para que seja feita a pesquiza: ");
				Scanner saborEspecifico = new Scanner(System.in);
				String sabor = saborEspecifico.nextLine();
				Sorvete sorvete1 = new Sorvete();
				List<Sorvete> listaSorvetes1 = geralDAO.buscarTodos(sorvete);
				for (Sorvete s : listaSorvetes) {
					if (s.getNome().equalsIgnoreCase(sabor)) {
						System.out.println("Nome:" + s.getNome() + " Fabricante: " + s.getFabricante()
								+ " Igredientes: " + s.getIngredientes());
					}
				}
			}
		}
		if (opcao == 2) {
			System.out.println("Você escolheu opção de inserir");
			System.out.println("1-Inserir sorvete");
			Scanner inserir = new Scanner(System.in);
			int opcaoInserir = inserir.nextInt();
			if (opcaoInserir == 1) {
				System.out.println("Informe o sabor do sorvete: ");
				Scanner inserirSorvete = new Scanner(System.in);
				String sabor = inserirSorvete.nextLine();
				System.out.println("Informe o fabricante do sorvete: ");
				String fabricante = inserirSorvete.nextLine();
				System.out.println("Informe os igredientes do sorvete: ");
				String igredientes = inserirSorvete.nextLine();
				Sorvete sorvete = new Sorvete();
				sorvete.setNome(sabor);
				sorvete.setFabricante(fabricante);
				sorvete.setIngredientes(igredientes);
				geralDAO.inserir(sorvete);
			}
		}
		if (opcao == 3) {
			System.out.println("Você escolheu opção deletar");
			System.out.println("\n1-Remover sorvete");
			Scanner removerSorvete = new Scanner(System.in);
			int opcaoRemover = removerSorvete.nextInt();
			System.out.println("Á baixo está a lista de sorvetes:\nescolha um sabor:\n");
			Sorvete sorvete = new Sorvete();
			List<Sorvete> listaSorvetes = geralDAO.buscarTodos(sorvete);
			for (Sorvete svt : listaSorvetes) {
				System.out.println("Sabor: " + svt.getNome() + " Fabricante: " + svt.getFabricante() + " Igredientes: "
						+ svt.getIngredientes());
			}
			System.out.println();
			System.out.println("Digite o sabor escolhido: ");
			Scanner removerSvt = new Scanner(System.in);
			String saborSorvete = removerSvt.nextLine();
			geralDAO.remover(Sorvete.class, saborSorvete);
		}
	}
}