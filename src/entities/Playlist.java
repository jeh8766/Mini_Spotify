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
    
    public double duracao() {
    	double duracion = 0;
    	for(Midias midia : midias) {
    		duracion += midia.getDuracao();
    	}
    	return duracion;
    }
    

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("- ").append(nome).append("- duração: ").append(duracao());
        return sb.toString();
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
