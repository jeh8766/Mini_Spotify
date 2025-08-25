package entities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controle {
    private Set<Usuario> usuarios = new HashSet<>();
    Catalogo catalogo=new Catalogo();
    Usuario usuario=new Usuario();

    public void cadastrarUsuario() {
        String nome = JOptionPane.showInputDialog("Digite o nome de usuário:");
        String email = JOptionPane.showInputDialog("Digite o email:");
        String senha = JOptionPane.showInputDialog("Digite a senha:");
        if (buscarEmail(email) == null) {
            usuarios.add(new Usuario(nome, email, senha));
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Email já cadastrado.");
        }
    }

    public Playlist listarPlaylists(Usuario user) {

        if (user.getPlaylists().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist cadastrada.");
            return null;
        }
        Playlist[] opcoes = user.getPlaylists().toArray(new Playlist[0]);
        Playlist escolha = (Playlist) JOptionPane.showInputDialog(
                null,
                "Escolha uma Playlist:",
                "Catálogo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
        return escolha;
    }

    public void listarMidiasPlaylist(Usuario user) {
        try {


            Playlist escolha = listarPlaylists(user);
            for (Midias midia : escolha.midias) {
                JOptionPane.showMessageDialog(null, midia);
            }
        }catch (NullPointerException e){
        }}
//git teste

        public void adicionarMusicaPlaylist(Usuario user, Catalogo catalogo){
        try {

            Playlist playlistescolhida = listarPlaylists(user);
            Midias midiaEscolhida = catalogo.listarMidias();
            playlistescolhida.midias.add(midiaEscolhida);
            JOptionPane.showMessageDialog(null, "midia adc");
        }catch (Exception e){
        }}

    public void listarUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            sb.append(usuario + "\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

//    public void listarPlaylist(Usuario user) {
//        JOptionPane.showMessageDialog(null, "Playlists: \n" + user.listarPlaylists());
//    }

    public Usuario buscarEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean validarSenha(String senha, String userEmail) {
        Usuario user = buscarEmail(userEmail);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Email não encontrado!");
            return false;
        }

        return user.getSenha().equals(senha);
    }
}
