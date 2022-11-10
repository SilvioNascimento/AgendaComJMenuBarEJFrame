package br.ufpb.dcx.silvio.agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgendaBirthdayListController implements ActionListener {
    private Agenda agenda;
    private JFrame janelaPrincipal;

    public AgendaBirthdayListController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList<Contato> todosOsContatos = agenda.MostrarTodosOsAniversariantes();
        String descricaoCadaContato = "";
        if(todosOsContatos.size() > 0) {
            for(Contato c : todosOsContatos) {
                descricaoCadaContato += c.toString() + "\n";
            }
            JOptionPane.showMessageDialog(janelaPrincipal, descricaoCadaContato);
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não existem aniversariantes cadastrados. Operação não realizado.");
        }
    }

}