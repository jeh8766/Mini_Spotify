package entities;

import aplication.Exception.ImputNullException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Catalogo {
    private ArrayList<Midias> midias=new ArrayList<>();

    public void AdicionarMidias () throws ImputNullException{
        try {
        String titulo = JOptionPane.showInputDialog("digite o titulo da midia a ser cadastrada");
        if (titulo == null || titulo.equals("")){
            throw new ImputNullException("obrigatorio preencher!!!");
        }
        String artista = JOptionPane.showInputDialog("digite o nome do artista");
            if (artista == null || artista.equals("")){
                throw new ImputNullException("obrigatorio preencher!!!");
            }
        double duracao = Double.parseDouble(JOptionPane.showInputDialog("digite a duração da midia"));
        String[] opcoesDeMidia = { "ROCK", "POP", "MPB", "JAZZ", "CLASSICA","ANIME","ELETRONICA","BRAZILIAN FUNK" };
        String genero =(String) JOptionPane.showInputDialog(null,"escolha o genero da midia",
                "generos",JOptionPane.QUESTION_MESSAGE,null,opcoesDeMidia,opcoesDeMidia[0]);
        midias.add(new Midias(titulo,artista,duracao,genero));
        JOptionPane.showMessageDialog(null,"cadastro concluido com sucesso",
                "concluido",JOptionPane.WARNING_MESSAGE);
    }catch (Exception e){
            JOptionPane.showMessageDialog(null,"valor inserido errado !!");
        }
    }
//git teste


    //error ArrayIndexOutOfBoundsException
    public Midias listarMidias() {
        Catalogo[] opcoes = midias.toArray(new Midias[0]);
        Midias escolha = (Midias) JOptionPane.showInputDialog(
                null,
                "Escolha uma música:",
                "Catálogo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes, opcoes[0]
        );
        return escolha;
    }

    public void musicasPreCadastradas (){
        midias.add(new Midias("Believer","Imagine Dragons",4.54,"POP"));
        midias.add(new Midias("Blue bird","NARUTO",4.52,"POP"));
        midias.add(new Midias("Sol Nascente","Imagine Dragons",2.60,"ROCK"));
        midias.add(new Midias("Quando eu Choro","Imagine Dragons",4.52,"POP"));
        midias.add(new Midias("A revolta","Carlão",2.52,"CLASSICA"));
        midias.add(new Midias("Mar Morto","Imagine Dragons",4.56,"JAZZ"));
        midias.add(new Midias("Lua Maritima","Imagine Dragons",4.23,"POP"));
        midias.add(new Midias("Gato Lunar","Nayara nascimento",4.36,"BRAZILIAN FUNK"));
        midias.add(new Midias("O desperar","Aristoteles",4.12,"CLASSICA"));
        midias.add(new Midias("Naquela mesa","Zezo",3.23,"FORRO"));
        midias.add(new Midias("Vaca NO Campo","Pedro Artur",4.33,"JAZZ"));
        midias.add(new Midias("Mirai Nikki","Yuno Gasai",2.11,"POP"));
        midias.add(new Midias("Cavalo Azul","Imagine Dragons",2.52,"BRAZILIAN FUNK"));
        midias.add(new Midias("Caneta Azul","Imagine Dragons",4.38,"POP"));
        midias.add(new Midias("Beliver","Imagine Dragons",1.59,"CLASSICA"));
        midias.add(new Midias("Pequeno Lua","Imagine Dragons",2.45,"ELETRONICA"));
        midias.add(new Midias("Beliver","Imagine Dragons",1.52,"POP"));
        midias.add(new Midias("Azul Caneta","Ariana Grande",2.53,"JAZZ"));
        midias.add(new Midias("O Groso"," Lula",1.54,"CLASSICA"));
        midias.add(new Midias("nsscente","Peixoto",2.53,"POP"));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Catalogo: \n");
        sb.append(midias);
        return sb.toString();
    }

    public ArrayList<Midias> getMidias() {
        return midias;
    }

    public void setMidias(ArrayList<Midias> midias) {
        this.midias = midias;
    }
}
