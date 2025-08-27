package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Playlist {
    private String nome;
    List<Midias> midias = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }
    
    

    public List<Midias> getMidias() {
		return midias;
	}
    
    public String duracao() {
    	double totalMinutes = 0;
    	for(Midias midia : midias) {
    		totalMinutes += midia.getDuracao();
    	}
        int minutos = (int) totalMinutes;
        int segundos = (int) Math.round((totalMinutes - minutos)* 60);
        if (segundos == 60) {
            minutos++;
            segundos = 0;
        }
        return String.format("%02d:%02d", minutos, segundos);
    }
    

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
public String toString() {
    return "- " + nome + " - duração: " + duracao();
}


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(nome, playlist.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
