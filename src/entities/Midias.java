package entities;

import javax.swing.*;
import java.util.ArrayList;

public class Midias {
    protected String titulo;
    protected String artista;
    protected double duracao;
    protected String genero;




    public Midias (String titulo, String artista, double duracao, String genero){
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;

    }

public void AdicionarMidias () {
    titulo = JOptionPane.showInputDialog("digite o titulo da midia a ser cadastrada");
    artista = JOptionPane.showInputDialog("digite o nome do artista");
    duracao = Double.parseDouble(JOptionPane.showInputDialog("digite a duração da midia"));
    String[] opcoesDeMidia = { "ROCK", "POP", "MPB", "JAZZ", "CLASSICA" };
    genero =(String) JOptionPane.showInputDialog(null,"escolha o genero da midia",
            "generos",JOptionPane.QUESTION_MESSAGE,null,opcoesDeMidia,opcoesDeMidia[0]);
 }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String toString (){return "Titulo: "+titulo+" Artista: "+artista+" Duração: "+duracao+" Minutos "+" Genero: "+genero;}
}
