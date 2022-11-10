package br.ufpb.dcx.silvio.agenda;

import java.util.ArrayList;
import java.util.Collection;

public interface Agenda {

    public boolean cadastraContato(String nome, int dia, int mes);
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes);
    public boolean removeContato(String nome);
    public Collection<Contato> getContatos();
    public ArrayList<Contato> MostrarTodosOsAniversariantes();
        
}

