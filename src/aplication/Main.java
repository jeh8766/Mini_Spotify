package aplication;

import entities.Catalogo;
import entities.Controle;
import entities.Usuario;
import excecoes.ImputNullException;
import excecoes.InfoCadastroInvalidaException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InfoCadastroInvalidaException {
        Catalogo catalogo = new Catalogo();
        Controle controle = new Controle();
        catalogo.musicasPreCadastradas();
        String[] opcoesDeLogin = {"Cadastrar-se", "Fazer Login", "Sair"};
        int escolhaDeLogin = 0;
        int escolha = -1;
        escolha++;
        controle.intro();
        do {
            escolhaDeLogin = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "MINI SPOTIFY", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDeLogin, opcoesDeLogin[0]);
            switch (escolhaDeLogin) {
                case 0:
                	try {
                		controle.cadastrarUsuario();
                		
                	}catch(InfoCadastroInvalidaException e) {
                		JOptionPane.showMessageDialog(null, e.getMessage());
                	}
                    break;
                case 1:
                    String userEmail = JOptionPane.showInputDialog("Digite o email: ");
                    String userSenha = JOptionPane.showInputDialog("Digite a senha: ");

                    String[] opcoes = {"Criar Playlist", "Gerenciar playlists", "Catálogo de musicas", "Adicionar música","Buscar mídia", "Sair"};

                    if (controle.validarSenha(userSenha, userEmail)) {
                        Usuario user = controle.buscarEmail(userEmail);
                        JOptionPane.showMessageDialog(null, "Bem vindo(a) " + user.getNome());

                        do {
                            escolha = JOptionPane.showOptionDialog(
                                    null,
                                    "Escolha uma opção:",
                                    "Mini Spotify: " + user.getNome(),
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcoes,
                                    opcoes[0]);


                            switch (escolha) {
                                case 0:
                                    try {
                                        user.criarPlayist();

                                    } catch (ImputNullException e) {
                                        JOptionPane.showMessageDialog(null,e.getMessage());
                                    } catch (NullPointerException e){
                                        break;
                                    }
                                    break;

                                case 1: //Falta a duração de cada playlist
                                	String[]opc = {"Listar mídias da PlayList", "Adicionar mídia à PlayList", "Remover mídia da PlayList","Cancelar"};
                                	
                                	int opcaoGerenciar = JOptionPane.showOptionDialog(
                                            null,
                                            "Escolha uma opção:",
                                            "Mini Spotify: " + user.getNome(),
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opc,
                                            opc[0]);
                                	switch (opcaoGerenciar) {
									case 0:
										controle.listarMidiasPlaylist(user);
										break;
									case 1:
										controle.adicionarMusicaPlaylist(user, catalogo);
										break;
									case 2:
										controle.removerMidiaPlaylist(user);
										break;
									default:
										break;
									}

                                    break;
                                case 2:
                                    catalogo.listarMidias();
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, "Adicionar música ao Catálogo.");
                                    try {
                                        catalogo.AdicionarMidias();

                                    } catch (ImputNullException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case 4://falta buscar mídia por título, artista ou gênero
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