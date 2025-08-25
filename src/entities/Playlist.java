package entities;
//git teste

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist {
    private String nome;
    List<Midias> midias= new ArrayList<>();
    Catalogo catalogo=new Catalogo();

    public Playlist(String nome) {
        this.nome = nome;
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
        sb.append("- ").append(nome);
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
