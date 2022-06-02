package br.edu.up.view;

import java.util.List;
import java.util.Scanner;

import br.edu.up.Main;
import br.edu.up.MovieStorage;
import br.edu.up.model.Filme;
import br.edu.up.util.Fmt;

public class Listagem extends Tela {

	static Scanner scan = new Scanner(System.in);
	static String opcao = "";

	static List<Filme> filmes;

	public Listagem() {
		super();
		displayOption = "Listar Filmes";
		loadMovies();
	}

	@Override
	public void displayScreen() {

		while(true){
			displayMovies();
			System.out.println("\n" + Fmt.emCouch("1") + "Selecionar filme por ID | "
					+ Fmt.emCouch("0") + " Sair");
			System.out.print("Escolha: ");
			opcao = scan.next();

			//TODO  Tela de informações detalhadas sobre o filme e opções de Edição e Exclusão
			if(Fmt.isValid(opcao, 1)){


				Filme selecionado = selectByID();
			} else if (opcao.equals("0")){
				System.out.println("\n");
				break;
			} else {
				Main.invalidOptionMessage();
			}


		}
	}

	public void loadMovies() {
		filmes = MovieStorage.listMovies();
	}

	public void displayMovies() {
		System.out.println("\nLista de Filmes\n[ID] - Nome do Filme");
		for (Filme filme : filmes) {
			String idFormatado = (String) Fmt.emCouch(filme.getId());
			System.out.println(idFormatado + " - " + filme.getNome());

		}
	}
	public static Filme selectByID() {
		while(true) {
			System.out.println("Digite o ID do filme desejado (digite 0 para voltar): ");
			try {
				int id = scan.nextInt();

				if (id == 0) {
					return null;
				}

				Filme filmeSelecionado = localizeByID(id);
				System.out.println("Filme selecionado: " + filmeSelecionado.getNome());
				return filmeSelecionado;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static Filme localizeByID(int id) throws Exception {
		for(Filme filme : filmes){
			if(filme.getId() == id){
				return filme;
			}
		}
		throw new Exception("ID Inválido");
	}

}
