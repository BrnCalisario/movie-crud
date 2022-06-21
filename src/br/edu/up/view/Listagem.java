package br.edu.up.view;

import java.util.List;
import java.util.Scanner;

import br.edu.up.Main;
import br.edu.up.MovieStorage;
import br.edu.up.model.Filme;
import br.edu.up.util.Fmt;

public class Listagem extends Tela {

	static Scanner scan = new Scanner(System.in);
	private static String opcao = "";

	private static List<Filme> filmes;

	public Listagem() {
		super();
		displayOption = "Listar Filmes";
	}

	@Override
	public void displayScreen() {

		while(true){
			filmes = MovieStorage.listMovies();
			displayMovies();

			Fmt.println("\n" + Fmt.emCouch("1") + "Selecionar filme por ID | [0] Sair");
			Fmt.print("Escolha: ");
			opcao = scan.next();

			if(Fmt.isValid(opcao, 1)){

				Filme filme = selectByID();
				
				if (filme != null) {
					Editor editor = new Editor(filme);
					editor.displayScreen();
				}	


			} else if (opcao.equals("0")){
				Fmt.println("\n");
				break;
			} else {
				Main.invalidOptionMessage();
			}


		}
	}

	private void displayMovies() {
		Fmt.println("\nLista de Filmes\n[ID] - Nome do Filme");
		for (Filme filme : filmes) {
			String idFormatado = (String) Fmt.emCouch(filme.getId());
			Fmt.println(idFormatado + " - " + filme.getNome());

		}
	}

	private static Filme selectByID() {
		while(true) {
			Fmt.println("\nDigite o ID do filme desejado (digite 0 para voltar): ");
			try {

				int id = scan.nextInt();
				if (id == 0) return null;

				return localizeByID(id);

			} catch (Exception e) {
				Fmt.println(e.getMessage());
			}
		}
	}

	private static Filme localizeByID(int id) throws Exception {
		for(Filme filme : filmes){
			if(filme.getId() == id){
				return filme;
			}
		}
		throw new Exception("ID Inválido");
	}

}
