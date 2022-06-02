package br.edu.up.view;

import java.util.Scanner;

import br.edu.up.MovieStorage;
import br.edu.up.model.Filme;
import br.edu.up.util.Fmt;

public class Cadastro extends Tela {

	static Scanner scan = new Scanner(System.in);

	static final String SUCCESS_MESSAGE = "\nFilme Cadastrado com Sucesso!!" + Fmt.pularLinhas(2);

	public Cadastro() {
		super();
		displayOption = "Tela de Cadastro";
	}

	@Override
	public void displayScreen() {

		System.out.println(Fmt.pularLinhas(2) + Fmt.emCouch("Tela de Cadastro"));
		displayMovieInputs();

	}

	public void displayMovieInputs() {
		Filme filme = new Filme();

		System.out.print("Digite o nome do filme: ");
		filme.setNome(scan.nextLine());

		System.out.print("Digite o ano do lançamento: ");
		filme.setAno(scan.nextLine());

		System.out.print("Digite o nome do diretor: ");
		filme.setDiretor(scan.nextLine());

		MovieStorage.insertMovie(filme);
		System.out.println(SUCCESS_MESSAGE);
	}

}
