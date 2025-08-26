package entities;
import excecoes.ImputNullException;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Usuario{
    private String nome;
    private String email;
    private String senha;
    private Set<Playlist> playlists=new HashSet<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(){
    }

    public void criarPlayist(){
        String playlistName=JOptionPane.showInputDialog(null, "Digite o nome da playlist:");
        if ( playlistName.equals("")){
            throw new ImputNullException(JOptionPane.showInputDialog(null,"obrigatorio preencher!!!"));
        }
        if (playlists.add(new Playlist(playlistName))) {
            JOptionPane.showMessageDialog(null, "A Playlist " + playlistName + " foi criada.");
        }else {
            JOptionPane.showMessageDialog(null,"Já existe uma playlist criada com esse nome.");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuarios: ");
        sb.append("nome: '").append(nome).append(" | ");
        sb.append(" email: ").append(email).append(" | ");
        sb.append("playlists: ").append(playlists);
        return sb.toString();
    }

    public String listarPlaylists() {
        StringBuilder sb = new StringBuilder();
        for (Playlist playlist : playlists) {
            sb.append(playlist + "\n");
        }
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }


}
