package aplication;
import aplication.Exception.ImputNullException;
import entities.Catalogo;
import entities.Controle;
import entities.Usuario;
import javax.swing.*;
//git teste
public class Main {
    public static void main(String[] args) {
        Catalogo catalogo=new Catalogo();
        Controle controle = new Controle();
        Usuario usuario = new Usuario();
        catalogo.musicasPreCadastradas();
        String[] opcoesDeLogin = {"Cadastrar-se", "Fazer Login", "Sair"};
        int escolhaDeLogin = 0;
        int escolha = -1;
        escolha++;
        usuario.intro();
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

                    String[] opcoes = {"Criar Playlist", "Gerenciar playlist","Catálogo de musicas", "Adicionar música", "Sair"};

                    if (controle.validarSenha(userSenha, userEmail)) {
                        Usuario user = controle.buscarEmail(userEmail);
                        JOptionPane.showMessageDialog(null, "Bem vindo(a) " + user.getNome());

                        do {
                            escolha = JOptionPane.showOptionDialog(
                                    null,
                                    "Escolha uma opção:",
                                    "Mini Spotify: "+user.getNome(),
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcoes,
                                    opcoes[0]);


                            switch (escolha) {
                                case 0:
                                    try {
                                        user.criarPlayist();

                                    }catch (ImputNullException e){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                    
                                case 1:
                                    int number=Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para visualizar playlist e 2 para adc musica"));
                                    if (number==1){
                                        controle.listarMidiasPlaylist(user);
                                    } else{
                                        JOptionPane.showMessageDialog(null, "Você escolheu: adc musica a playlist");
                                        controle.adicionarMusicaPlaylist(user, catalogo);}
                                    //Visualizar playList e mídias contidas tal como sua duração total
                                    break;

                                case 2:
                                    JOptionPane.showMessageDialog(null, "Você escolheu: catálogo de musicas");
                                    catalogo.listarMidias();
                                    //Armazena todas as mídias; Permite buscar músicas por título, artista ou gênero; talvez adc mídia à playlist?
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, "Adicionar música");
                                    try {
                                        catalogo.AdicionarMidias();

                                    }catch (ImputNullException e ){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case 4:
                                    JOptionPane.showMessageDialog(null, "Deslogando");
                            }
                        } while (escolha != 4);
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