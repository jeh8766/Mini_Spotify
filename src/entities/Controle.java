package entities;

import javax.swing.*;

public class Controle {
    private String teste;

    public static void testar (){
        JOptionPane.showMessageDialog(null,"teste estou testando");
    }

    public Controle(String teste){
        this.teste = teste;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
}
