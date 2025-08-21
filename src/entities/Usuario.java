package entities;
import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Set<Playlist> playlists=new HashSet<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void criarPlayist(){
        String playlistName=JOptionPane.showInputDialog(null, "Digite o nome da playlist:");
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

//    public void cadastrastro(){
//        JOptionPane.showMessageDialog(null,
//                "<html><div style='text-align:center; color:#4B0082;'>"
//                        + "<h2>Bem-vindo ao Mini Spotify!</h2>"
//                        + "<p>Por favor, faça seu cadastro.</p>"
//                        + "</div></html>",
//                    "Boas-vindas",
//                JOptionPane.INFORMATION_MESSAGE);
//        this.nome = JOptionPane.showInputDialog("digite o seu nome de usuario");
//        this.email = JOptionPane.showInputDialog("digite o seu gmail");
//        this.senha = JOptionPane.showInputDialog("digite sua senha");
//        JOptionPane.showMessageDialog(null,"cadastro concluido com sucesso",
//                "Bem vindo",JOptionPane.WARNING_MESSAGE);
//    }


}
