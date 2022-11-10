package br.ufpb.dcx.silvio.agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgendaSaveController implements ActionListener {
    private Agenda agenda;
    private GravadorDeDados gravador;
    private JFrame janelaPrincipal;

    public AgendaSaveController(Agenda agenda, JFrame janela, GravadorDeDados gravador) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gravador.gravarContatos(agenda.getContatos());
            JOptionPane.showMessageDialog(janelaPrincipal, "Contatos salvos com sucesso!");
        } catch(IOException ioException) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Contatos não salvos. Erro: "
            + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}
