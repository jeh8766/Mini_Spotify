package aplication;
import entities.Catalogo;
import entities.Usuario;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String[] opcoes = { "Adicionar musicas", "Lista de Musicas", "criar plalit ", "Remover", "Sair" };
        int escolha = -1;
        Usuario usuario = new Usuario();
        usuario.cadastrastro();
        while (escolha !=4) {
             escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "mini Spotify: "+usuario.getNome(),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,opcoes,opcoes[0]

            );

            if (escolha == 0) {
                JOptionPane.showMessageDialog(null, "Você escolheu: Adicionar");
                Catalogo catalogo = new Catalogo("","",0.0,"");
                catalogo.AdicionarMidias();


            }
            else if (escolha == 1) {
                JOptionPane.showMessageDialog(null, "lISTA DE MUSICAS DISPONIVEL");
                Catalogo catalogo = new Catalogo("","",0.0,"");
                catalogo.MusicaPreCadastradas();
                catalogo.listar();
            }
            else if (escolha == 2) {
                JOptionPane.showMessageDialog(null, "Você escolheu: Atualizar");
            }
            else if (escolha == 3) {
                JOptionPane.showMessageDialog(null, "Você escolheu: Remover");
            }
            else if (escolha == 4) {
                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
            }
            else {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }



    }
}