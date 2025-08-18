package entities;

import javax.swing.*;
import java.util.ArrayList;

public class Catalogo extends Midias {
    private static ArrayList<Catalogo> catalogos = new ArrayList<>();


    public Catalogo(String titulo, String artista, double duracao, String genero) {
        super(titulo, artista, duracao, genero);
    }
    public void AdicionarMidias () {
        titulo = JOptionPane.showInputDialog("digite o titulo da midia a ser cadastrada");
        artista = JOptionPane.showInputDialog("digite o nome do artista");
        duracao = Double.parseDouble(JOptionPane.showInputDialog("digite a duração da midia"));
        String[] opcoesDeMidia = { "ROCK", "POP", "MPB", "JAZZ", "CLASSICA","ANIME","ELETRONICA","BRASILIN FONK" };
        genero =(String) JOptionPane.showInputDialog(null,"escolha o genero da midia",
                "generos",JOptionPane.QUESTION_MESSAGE,null,opcoesDeMidia,opcoesDeMidia[0]);
        catalogos.add(new Catalogo(titulo,artista,duracao,genero));
        JOptionPane.showMessageDialog(null,"cadastro concluido com sucesso",
                "concluido",JOptionPane.WARNING_MESSAGE);
    }
    public void listar() {
        Catalogo[] opcoes = catalogos.toArray(new Catalogo[0]);
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
        catalogos.add(new Catalogo("Beliver","Imagenis Dragon",4.54,"POP"));
        catalogos.add(new Catalogo("Blue","NARUTO",4.52,"POP"));
        catalogos.add(new Catalogo("Sol Nascente","Imagenis Dragon",2.60,"ROCK"));
        catalogos.add(new Catalogo("Quando eu Choro","Imagenis Dragon",4.52,"POP"));
        catalogos.add(new Catalogo("A revolta","Carlão",2.52,"CLASSICA"));
        catalogos.add(new Catalogo("Mar Morto","Imagenis Dragon",4.56,"JAZZ"));
        catalogos.add(new Catalogo("Lua Maritima","Imagenis Dragon",4.23,"POP"));
        catalogos.add(new Catalogo("Gato Lunar","Nayara nascimento",4.36,"BRASILIN FONK"));
        catalogos.add(new Catalogo("O desperar","Aristoteles",4.12,"CLASSICA"));
        catalogos.add(new Catalogo("Beliver","Imagenis Dragon",3.23,"POP"));
        catalogos.add(new Catalogo("Vaca NO Campo","Pedro Artur",4.33,"JAZZ"));
        catalogos.add(new Catalogo("Mirai Nikki","Yuno Gasai",2.11,"POP"));
        catalogos.add(new Catalogo("Cavalo Azul","Imagenis Dragon",2.52,"BRASILIN FONK"));
        catalogos.add(new Catalogo("Caneta Azul","Imagenis Dragon",4.38,"POP"));
        catalogos.add(new Catalogo("Beliver","Imagenis Dragon",1.59,"CLASSICA"));
        catalogos.add(new Catalogo("Pequeno Lua","Imagenis Dragon",2.45,"ELETRONICA"));
        catalogos.add(new Catalogo("Beliver","Imagenis Dragon",1.52,"POP"));
        catalogos.add(new Catalogo("Azul Caneta","Ariana Grande",2.53,"JAZZ"));
        catalogos.add(new Catalogo("O Groso"," Lula",1.54,"CLASSICA"));
        catalogos.add(new Catalogo("nsscente","Peixoto",2.53,"POP"));



    }


}
