package br.edu.up.view;

import java.util.List;
import java.util.Scanner;

import br.edu.up.MovieStorage;
import br.edu.up.model.Filme;
import br.edu.up.util.Fmt;

public class Listagem extends Tela {

	static Scanner scan = new Scanner(System.in);

	public Listagem() {
		super();
		displayOption = "Listar Filmes";
	}

	@Override
	public void displayScreen() {

		displayMovies();
		System.out.println("\n" + Fmt.emCouch("1") + "Selecionar filme por ID | " + Fmt.emCouch("0") + " Sair");
		scan.nextLine();

	}

	public void displayMovies() {
		List<Filme> filmes = MovieStorage.listMovies();

		System.out.println("\nLista de Filmes\n[ID] - Nome do Filme");
		
		for (Filme filme : filmes) {

			String idFormatado = (String) Fmt.emCouch(filme.getId());
			System.out.println(idFormatado + " - " + filme.getNome());

		}
	}

}
