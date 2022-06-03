package br.edu.up.view;

import java.util.Scanner;

import br.edu.up.MovieStorage;
import br.edu.up.model.Filme;
import br.edu.up.util.Fmt;

public class Cadastro extends Tela {

	static Scanner scan = new Scanner(System.in);

	static final String SUCCESS_MESSAGE = "\nFilme Cadastrado com Sucesso!!" + Fmt.pularLinhas(2);
	static final String CANCEL_MESSAGE = "\nCadastro Cancelado - Voltando para o Menu Principal\n";

	public Cadastro() {
		super();
		displayOption = "Tela de Cadastro";
	}

	@Override
	public void displayScreen() {

		Fmt.println(Fmt.pularLinhas(2) + "[ Tela de Cadastro ]");
		displayMovieInputs();

	}

	private void displayMovieInputs() {
		Filme filme = new Filme();

		Fmt.print("Digite o nome do filme: ");
		filme.setNome(scan.nextLine());

		Fmt.print("Digite o ano do lançamento: ");
		filme.setAno(scan.nextLine());

		Fmt.print("Digite o nome do diretor: ");
		filme.setDiretor(scan.nextLine());

		String movieFormat =
				"\nDados Informados:"
				+"\nNome: " + Fmt.emCouch(filme.getNome())
				+"\nAno: " + Fmt.emCouch(filme.getAno())
				+"\nDiretor: " + Fmt.emCouch(filme.getDiretor())
				+"\nPressione qualquer tecla para confirmar ou 0 para cancelar";

		Fmt.println(movieFormat);
		if (scan.nextLine().equals("0")){
			displayCancelMessage();
			return;
		}

		MovieStorage.insertMovie(filme);
		Fmt.println(SUCCESS_MESSAGE);
	}

	private void displayCancelMessage(){
		Fmt.println(CANCEL_MESSAGE);
	}

}
