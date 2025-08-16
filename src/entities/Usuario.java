package entities;
import javax.swing.*;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

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


    public void cadastrastro(){
        JOptionPane.showMessageDialog(null,
                "<html><div style='text-align:center; color:#4B0082;'>"
                        + "<h2>Bem-vindo ao Mini Spotify!</h2>"
                        + "<p>Por favor, faça seu cadastro.</p>"
                        + "</div></html>",
                    "Boas-vindas",
                JOptionPane.INFORMATION_MESSAGE);
        this.nome = JOptionPane.showInputDialog("digite o seu nome de usuario");
        this.email = JOptionPane.showInputDialog("digite o seu gmail");
        this.senha = JOptionPane.showInputDialog("digite sua senha");
        JOptionPane.showMessageDialog(null,"cadastro concluido com sucesso",
                "Bem vindo",JOptionPane.WARNING_MESSAGE);
    }


}
