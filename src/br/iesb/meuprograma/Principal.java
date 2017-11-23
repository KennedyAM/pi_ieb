package br.iesb.meuprograma;

import br.iesb.meuprograma.apresentacao.TelaLogin;
import java.awt.EventQueue;

public class Principal {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin login = new TelaLogin();
                login.setVisible(true);
            }
        });
    }
}
