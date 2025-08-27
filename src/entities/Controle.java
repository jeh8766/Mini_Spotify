package entities;

import excecoes.InfoCadastroInvalidaException;
import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Controle {
    private Set<Usuario> usuarios = new HashSet<>();
    Usuario usuario = new Usuario();

    public void cadastrarUsuario() throws InfoCadastroInvalidaException {
        String nome = JOptionPane.showInputDialog("Digite o nome de usuário:");
        if (nome == null || nome.equals("")) {
            throw new InfoCadastroInvalidaException("Digite um nome");
        }
        String email = JOptionPane.showInputDialog("Digite o email:");
        String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InfoCadastroInvalidaException("Digite um email valido");
        }
        String senha = JOptionPane.showInputDialog("Digite a senha:");
        if (senha == null || senha.equals("")) {
            throw new InfoCadastroInvalidaException("Digite uma senha");
        }

        if (buscarEmail(email) == null) {
            usuarios.add(new Usuario(nome, email, senha));
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Email já cadastrado.");
        }
    }

    public void intro() {
        JOptionPane.showMessageDialog(null,
                "<html><div style='text-align:center; color:Green;'>"
                        + "<h2>Bem-vindo ao Mini Spotify!</h2>"
                        + "<p>Por favor, faça seu cadastro.</p>"
                        + "</div></html>",
                "Boas-vindas",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private Playlist buscarPlaylists(Usuario user) {

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

            Playlist escolha = buscarPlaylists(user);
            if (escolha.getMidias().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Sem mídias adicionadas à PlayList");
            } else {
                StringBuilder sb = new StringBuilder();
                for (Midias midia : escolha.midias) {
                    sb.append(midia).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }

        } catch (NullPointerException e) {
        }
    }

    public void adicionarMusicaPlaylist(Usuario user, Catalogo catalogo) {
        try {
            Playlist playlistescolhida = buscarPlaylists(user);
            if (playlistescolhida != null) {
                Midias midiaEscolhida = catalogo.listarMidias();
                playlistescolhida.midias.add(midiaEscolhida);
                JOptionPane.showMessageDialog(null, "midia adc");
            }
        } catch (Exception e) {
        }
    }

    public Usuario buscarEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public void removerMidiaPlaylist(Usuario user) {
        try {
            Playlist playlistSelecionada = buscarPlaylists(user);
            if (playlistSelecionada == null) return;

            if (playlistSelecionada.midias.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você não adicionou nenhum item à playlist ainda");
                return;
            }
            Midias[] opcoes = playlistSelecionada.midias.toArray(new Midias[0]);
            Midias midiaSelecionada = (Midias) JOptionPane.showInputDialog(null, "Selecione a midia que deseja remover:", "Remover midia", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (midiaSelecionada != null) {
                playlistSelecionada.midias.remove(midiaSelecionada);
                JOptionPane.showMessageDialog(null, "Midia removida com sucesso");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover a midia");
        }
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
