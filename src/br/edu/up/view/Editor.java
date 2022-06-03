package br.edu.up.view;

import br.edu.up.Main;
import br.edu.up.MovieStorage;
import br.edu.up.model.Filme;
import br.edu.up.util.Fmt;

import java.util.Scanner;

public class Editor extends Tela {

    private static Filme filmeSelecionado;
    static Scanner scan = new Scanner(System.in);
    private static String opcao = "";


    public Editor(Filme filme) {
        filmeSelecionado = filme;
    }

    @Override
    public void displayScreen(){

        Fmt.println("Filme selecionado:\n" + filmeSelecionado);


        String functions = "O que deseja fazer:"
                +"\n[1] Editar Informações"
                +"\n[2] Apagar Filme"
                +"\n[0] Cancelar";

        while(true) {

            Fmt.println(functions);
            Fmt.print("Escolha: ");
            opcao = scan.next();

            if (opcao.equals("0")){
                break;
            } else if (!Fmt.isValid(opcao, 2)){
                Main.invalidOptionMessage();
            }

            switch (opcao){
                case "1" :
                    Fmt.println("Não tem ainda :(");
                    break;
                case "2":
                    deleteMovie(filmeSelecionado);
                    return;
                default:
                    Fmt.print("Erro");
            }

        }

    }


    public static void deleteMovie(Filme filme){
        Fmt.print("Deseja mesmo deletar " + Fmt.emCouch(filme.getNome())  + " ?\n[1]-Sim [2]-Não\nEscolha: ");
        opcao = scan.next();

        switch(opcao) {
            case "1":
                MovieStorage.removeMovie(filme);
                Fmt.println("Exclusão Realizada com Sucesso\n");
                break;
            case "2":
                Fmt.println("Exclusão Cancelada\n");
                break;
            default:
                Main.invalidOptionMessage();
        }
    }


}
