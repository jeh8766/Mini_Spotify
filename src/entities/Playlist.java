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

    private int converterTempoEmSegundos(String tempo){
        String[] partes = tempo.split(":");
        int minutos = Integer.parseInt(partes[0]);
        int segundos = Integer.parseInt(partes[1]);
        return minutos * 60 + segundos;
    }

    private String duracao(){
        StringBuilder sb = new StringBuilder();
        int somaDeDuracoes=0;
        for (Midias midia:midias){
            somaDeDuracoes+= converterTempoEmSegundos(midia.getDuracao());
        }
        int hora = somaDeDuracoes / 3600;
        int minutos = (somaDeDuracoes % 3600) / 60;
        int segundos = somaDeDuracoes % 60;

        sb.append(String.format("%02d:%02d:%02d", hora, minutos, segundos));
        return sb.toString();
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
