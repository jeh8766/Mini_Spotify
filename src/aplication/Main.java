package aplication;
import entities.Catalogo;
import entities.Controle;
import entities.Usuario;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo=new Catalogo();
        Controle controle = new Controle();
        catalogo.musicasPreCadastradas();
        String[] opcoesDeLogin = {"Cadastrar-se", "Fazer Login", "Sair"};
        int escolhaDeLogin = 0;
        int escolha = -1;
        escolha++;
        do {
            escolhaDeLogin = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "MINI SPOTIFY", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDeLogin, opcoesDeLogin[0]);
            switch (escolhaDeLogin) {
                case 0:
                    //cadatro
                    controle.cadastrarUsuario();
                    //Não está salvando o usuário corretamente. Após fazer login e deslogar, a lista de usuários é reiniciada
                    break;
                case 1:
                    //Login
                    String userEmail = JOptionPane.showInputDialog("Digite o email: ");
                    String userSenha = JOptionPane.showInputDialog("Digite a senha: ");
                    //controle.validarSenha(userSenha, userEmail);

                    String[] opcoes = {"Criar Playlist", "Gerenciar playlist", "Visualizar playlists", "Catálogo de musicas", "Adicionar música", "Sair"};

                    if (controle.validarSenha(userSenha, userEmail)) {
                        Usuario user = controle.buscarEmail(userEmail);
                        JOptionPane.showMessageDialog(null, "Bem vindo(a) " + user.getNome());

                        do {
                            escolha = JOptionPane.showOptionDialog(
                                    null,
                                    "Escolha uma opção:",
                                    "Mini Spotify",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcoes,
                                    opcoes[0]);

                            // kaique : ai agente so coloca como eu fiz com o teste tipo o metodo adciona ai o main vai fica bem organizado

                            switch (escolha) {
                                case 0:
                                    user.criarPlayist();
                                    break;
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Você escolheu: Atualizar playlist");
                                    //Apagar playlist; Adicionar e remover mídia da playlist;

                                    break;
                                case 2:
                                    JOptionPane.showMessageDialog(null, "Você escolheu: visualizar playlist");
                                    controle.listarPlaylist(user);
                                    //Visualizar playList e mídias contidas tal como sua duração total
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, "Você escolheu: catálogo de musicas");
                                    catalogo.listarMidias();
                                    //Armazena todas as mídias; Permite buscar músicas por título, artista ou gênero; talvez adc mídia à playlist?
                                    break;
                                case 4:
                                    JOptionPane.showMessageDialog(null, "Adicionar música");
                                    catalogo.AdicionarMidias();
                                    break;
                                case 5:
                                    JOptionPane.showMessageDialog(null, "Deslogando");
                            }
                        } while (escolha != 5);
                    } else {
                        JOptionPane.showMessageDialog(null, "Tente novamente");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;
            }
        } while (escolhaDeLogin != 2);
    }
}

//    public static void main(String[] args) {
//
//        String[] opcoes = { "Adicionar musicas", "Lista de Musicas", "criar plalit ", "Remover", "Sair" };
//        int escolha = -1;
//        Usuario usuario = new Usuario();
//        usuario.cadastro();
//        while (escolha !=4) {
//             escolha = JOptionPane.showOptionDialog(
//                    null,
//                    "Escolha uma opção:",
//                    "mini Spotify: "+usuario.getNome(),
//                    JOptionPane.DEFAULT_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,opcoes,opcoes[0]
//
//            );
//
//            if (escolha == 0) {
//                JOptionPane.showMessageDialog(null, "Você escolheu: Adicionar");
//                Catalogo catalogo = new Catalogo("","",0.0,"");
//                catalogo.AdicionarMidias();
//
//
//            }
//            else if (escolha == 1) {
//                JOptionPane.showMessageDialog(null, "lISTA DE MUSICAS DISPONIVEL");
//                Catalogo catalogo = new Catalogo("","",0.0,"");
//                catalogo.MusicaPreCadastradas();
//                catalogo.listar();
//            }
//            else if (escolha == 2) {
//                JOptionPane.showMessageDialog(null, "Você escolheu: Atualizar");
//            }
//            else if (escolha == 3) {
//                JOptionPane.showMessageDialog(null, "Você escolheu: Remover");
//            }
//            else if (escolha == 4) {
//                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
//            }
//            else {
//                JOptionPane.showMessageDialog(null, "Opção inválida!");
//            }
//        }
//
//
//
//    }