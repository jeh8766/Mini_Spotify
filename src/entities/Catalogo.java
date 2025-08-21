package entities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Catalogo extends Midias {
    private static ArrayList<Midias> midia = new ArrayList<>();


    public Catalogo(String titulo, String artista, double duracao, String genero) {
        super(titulo, artista, duracao, genero);
    }
    public void AdicionarMidias () {
        try {
        titulo = JOptionPane.showInputDialog("digite o titulo da midia a ser cadastrada");
        artista = JOptionPane.showInputDialog("digite o nome do artista");
        duracao = Double.parseDouble(JOptionPane.showInputDialog("digite a duração da midia"));
        String[] opcoesDeMidia = { "ROCK", "POP", "MPB", "JAZZ", "CLASSICA","ANIME","ELETRONICA","BRASILIN FONK" };
        genero =(String) JOptionPane.showInputDialog(null,"escolha o genero da midia",
                "generos",JOptionPane.QUESTION_MESSAGE,null,opcoesDeMidia,opcoesDeMidia[0]);
        midia.add(new Catalogo(titulo,artista,duracao,genero));
        JOptionPane.showMessageDialog(null,"cadastro concluido com sucesso",
                "concluido",JOptionPane.WARNING_MESSAGE);
    }catch (Exception e){
            JOptionPane.showMessageDialog(null,"digite somente numeros!!");
        }}
    public void listar() {
        Catalogo[] opcoes = midia.toArray(new Catalogo[0]);
        Catalogo escolha = (Catalogo) JOptionPane.showInputDialog(
                null,
                "Escolha uma música:",
                "Catálogo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes, opcoes[0]
        );
        JOptionPane.showMessageDialog(null,"musica salva com sucesso",
                "concluido",JOptionPane.WARNING_MESSAGE);
    }

    public void MusicaPreCadastradas (){
        midia.add(new Midias("Beliver","Imagenis Dragon",4.54,"POP"));
        midia.add(new Midias("Blue","NARUTO",4.52,"POP"));
        midia.add(new Midias("Sol Nascente","Imagenis Dragon",2.60,"ROCK"));
        midia.add(new Midias("Quando eu Choro","Imagenis Dragon",4.52,"POP"));
        midia.add(new Midias("A revolta","Carlão",2.52,"CLASSICA"));
        midia.add(new Midias("Mar Morto","Imagenis Dragon",4.56,"JAZZ"));
        midia.add(new Midias("Lua Maritima","Imagenis Dragon",4.23,"POP"));
        midia.add(new Midias("Gato Lunar","Nayara nascimento",4.36,"BRASILIN FONK"));
        midia.add(new Midias("O desperar","Aristoteles",4.12,"CLASSICA"));
        midia.add(new Midias("Beliver","Imagenis Dragon",3.23,"POP"));
        midia.add(new Midias("Vaca NO Campo","Pedro Artur",4.33,"JAZZ"));
        midia.add(new Midias("Mirai Nikki","Yuno Gasai",2.11,"POP"));
        midia.add(new Midias("Cavalo Azul","Imagenis Dragon",2.52,"BRASILIN FONK"));
        midia.add(new Midias("Caneta Azul","Imagenis Dragon",4.38,"POP"));
        midia.add(new Midias("Beliver","Imagenis Dragon",1.59,"CLASSICA"));
        midia.add(new Midias("Pequeno Lua","Imagenis Dragon",2.45,"ELETRONICA"));
        midia.add(new Midias("Beliver","Imagenis Dragon",1.52,"POP"));
        midia.add(new Midias("Azul Caneta","Ariana Grande",2.53,"JAZZ"));
        midia.add(new Midias("O Groso"," Lula",1.54,"CLASSICA"));
        midia.add(new Midias("nsscente","Peixoto",2.53,"POP"));



    }


}
