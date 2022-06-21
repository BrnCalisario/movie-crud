package br.edu.up;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.util.Fmt;
import br.edu.up.view.Cadastro;
import br.edu.up.view.Listagem;
import br.edu.up.view.Tela;

public class Main {

	static String opcao;
	static Scanner scan = new Scanner(System.in);

	static final String FINAL_MESSAGE = "\n\nObrigado por utilizar o Programa.";
	static ArrayList<Tela> listaTelas = new ArrayList<>();

	public static void main(String[] args) {

		MovieStorage.initialize();
		initializeView();
		
		while (true) {
			opcao = menuDisplay();

			if (Fmt.isValid(opcao, listaTelas.size())) {

				int index = Integer.parseInt(opcao) - 1;
				Tela telaAtual = listaTelas.get(index);

				telaAtual.displayScreen();

			} else if (opcao.equals("0")) {
				Fmt.println(FINAL_MESSAGE);
				break;
			} else {
				invalidOptionMessage();
			}

		}

		scan.close();

	}

	public static String menuDisplay() {
		Fmt.println("[ Menu Principal ]");
		for (Tela tela : listaTelas) {

			int indexDisplay = listaTelas.indexOf(tela) + 1;

			tela.setIndex(indexDisplay);

			String display = Fmt.emCouch(indexDisplay) + " " + tela.getDisplayOption();
			Fmt.println(display);
		}
		Fmt.println("[0] Sair");


		Fmt.print("Escolha: ");
		return scan.next();
	}

	public static void initializeView() {
		Cadastro cad = new Cadastro();
		Listagem list = new Listagem();

		listaTelas.add(cad);
		listaTelas.add(list);
	}

	public static void invalidOptionMessage() { Fmt.println("Opção Inválida\n"); }


}
