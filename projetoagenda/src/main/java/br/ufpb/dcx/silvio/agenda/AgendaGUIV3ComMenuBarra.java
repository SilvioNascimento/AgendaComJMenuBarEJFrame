package br.ufpb.dcx.silvio.agenda;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgendaGUIV3ComMenuBarra extends JFrame {

    JLabel linha1, background;
    ImageIcon boloImg = new ImageIcon("projetoagenda" + File.separator + "src" + File.separator + "resources" + File.separator + "img" + File.separator + "bolo.jpg");
    ImageIcon addImg = new ImageIcon("projetoAgenda" + File.separator + "src" + File.separator + "resources" + File.separator + "img" + File.separator + "add_person.png");
    ImageIcon pesqImg = new ImageIcon("projetoAgenda" + File.separator + "src" + File.separator + "resources" + File.separator + "img" + File.separator + "search_person.png");
    ImageIcon removeImg = new ImageIcon("projetoAgenda" + File.separator + "src" + File.separator + "resources" + File.separator + "img" + File.separator + "remove_person.png");
    ImageIcon listImg = new ImageIcon("projetoAgenda" + File.separator + "src" + File.separator + "resources" + File.separator + "img" + File.separator + "list.png");
    Agenda agenda = new AgendaSilvio();
    JButton botaoAdicionar, botaoPesquisar, botaoRemover, botaoListar;
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDeDados gravador = new GravadorDeDados();

    public AgendaGUIV3ComMenuBarra() {
        // Configurando a estrutura da janela
        setTitle("Agenda de Aniversários");
        setSize(616, 600);
        setLocation(300, 100);
        setResizable(false);
        getContentPane().setBackground(Color.blue);
        Collection<Contato> contatos = null;
        try {
            contatos = gravador.recuperaContatos();
            for(Contato c : contatos) {
                this.agenda.cadastraContato(c.getNome(), c.getDiaAniversariante(), c.getMesAniversariante());
            }
            JOptionPane.showMessageDialog(null, "Contatos recuperados com sucesso");
        } catch(IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Contatos não recuperados. Erro: " + e.getMessage());
            e.printStackTrace();
        }

        linha1 = new JLabel("Minha Agenda de Aniversários", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));


        // Criando botões e colocando suas funcionalidades
        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.setToolTipText("Dica: Adiciona um novo aniversariante.");
        botaoAdicionar.addActionListener(new AgendaAddController(agenda, this));

        botaoPesquisar = new JButton("Pesquisar", pesqImg);
        botaoPesquisar.setToolTipText("Dica: Pesquisa todos os aniversariantes através do dia e do mês" +
                " informados");
        botaoPesquisar.addActionListener(new AgendaSearchController(agenda, this));

        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.setToolTipText("Dica: Remove um aniversariante");
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));

        botaoListar = new JButton("Mostrar lista", listImg);
        botaoListar.setToolTipText("Dica: Mostra a lista dos dados de todos os aniversariantes cadastrados");
        botaoListar.addActionListener(new AgendaBirthdayListController(agenda, this));


        // Definindo a imagem no plano de fundo
        background = new JLabel(boloImg);
        setContentPane(background);
        linha1.setBounds(90, 20, 400, 40);
        add(linha1);
        
        // Inserindo os botões 
        botaoPesquisar.setBounds(0, 468, 300, 70);
        add(botaoPesquisar);
        botaoAdicionar.setBounds(0, 398, 300, 70);
        add(botaoAdicionar);
        botaoRemover.setBounds(300, 398, 300, 70);
        add(botaoRemover);
        botaoListar.setBounds(300, 468, 300, 70);
        add(botaoListar);


        // Criando uma barra de menu e colocando suas funcionalidades
        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarComo = new JMenuItem("Salvar dados");
        menuSalvar.add(menuSalvarComo);
        menuSalvarComo.addActionListener(new AgendaSaveController(agenda, this, gravador));
        barraDeMenu.add(menuSalvar);

        JMenu menuSobre = new JMenu("Sobre");
        JMenuItem menuSobreDesenvolvedor = new JMenuItem("Sobre desenvolvedor");
        menuSobre.add(menuSobreDesenvolvedor);
        JMenuItem menuSobrePrograma = new JMenuItem("Sobre programa");
        menuSobre.add(menuSobrePrograma);

        menuSobreDesenvolvedor.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Desenvolvedor: Silvio Nascimento Ribeiro\n\n" + "Motivação: Este programa foi desenvolvido\n" + "com intuito de aprendizagem e a obtenção \n" + "de pontuação para complementar a nota da \n" + "2ª unidade de POO.");
        });
        menuSobrePrograma.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Sobre o programa: O programa Agenda cadastra, pesquisa\n" 
            + "ou remove uma pessoa e a sua data de aniversário,\n" 
            + "como também salva todos os dados do aniversariante.");
        });
        barraDeMenu.add(menuSobre);

        setJMenuBar(barraDeMenu);
        File arquivo = new File(".");
        System.out.println("===>"+arquivo.getAbsolutePath());
    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUIV3ComMenuBarra();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(janela, "Tem " +
                        "certeza de que quer sair?");
                if(resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
