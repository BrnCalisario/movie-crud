package br.edu.up.view;

import br.edu.up.Main;
import br.edu.up.MovieStorage;
import br.edu.up.model.Filme;
import br.edu.up.util.Fmt;


import javax.sound.midi.SysexMessage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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

        Fmt.println("\nFilme selecionado:\n" + filmeSelecionado);


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
                    editMovieInfo();
                    break;
                case "2":
                    deleteMovie();
                    return;
                default:
                    Fmt.print("Erro");
            }

        }

    }


    public static void editMovieInfo() {

        Fmt.println("\nEscolha a informação que deseja editar: ");
        displayInfoOption();

    }

    private static void displayInfoOption() {

        List<String> movieInfo = Fmt.getFields(filmeSelecionado);
        movieInfo.remove(movieInfo.get(0));
        movieInfo.remove(movieInfo.get(0));

        for(String info : movieInfo) {
            int index = movieInfo.indexOf(info) + 1;
            Fmt.println(Fmt.emCouch(index) + " - " + Fmt.emCouch(info));
        }

        String result = scan.next();

        if (Fmt.isValid(result, movieInfo.size())){

            String campoStr = movieInfo.get(Integer.parseInt(result) - 1);

            try {
                Field campoSelecionado = getField(campoStr);
                Fmt.print("\nDigite o novo valor para " +  Fmt.emCouch(campoSelecionado.getName()) +": " ) ;
                scan.nextLine();
                String novoValor = scan.nextLine();

                campoSelecionado.set(filmeSelecionado, novoValor);
                MovieStorage.updateMovie(filmeSelecionado);

                Fmt.println("Campo Atualizado com Sucesso!");
                Fmt.println(filmeSelecionado.toString());

            } catch (Exception e) {
                System.out.println("Erro na hora de pegar o campo");
            }

        }


    }


    public static Field getField(String nomeCampo) throws Exception {
        Field campo = filmeSelecionado.getClass().getDeclaredField(nomeCampo);
        campo.setAccessible(true);
        return campo;
    }

    public static void deleteMovie(){
        Fmt.print("Deseja mesmo deletar " + Fmt.emCouch(filmeSelecionado.getNome())  + " ?\n[1]-Sim [2]-Não\nEscolha: ");
        opcao = scan.next();

        switch(opcao) {
            case "1":
                MovieStorage.removeMovie(filmeSelecionado);
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
