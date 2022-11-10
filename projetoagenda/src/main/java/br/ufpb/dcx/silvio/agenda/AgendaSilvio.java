package br.ufpb.dcx.silvio.agenda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaSilvio implements Agenda {

    private Map<String, Contato> contatos;

    public AgendaSilvio() {
        this.contatos = new HashMap<>();
    }

    public ArrayList<Contato> MostrarTodosOsAniversariantes() {
        ArrayList<Contato> todosOsAniversariantes = new ArrayList<>();
        for(Contato c : this.contatos.values()) {
            todosOsAniversariantes.add(c);
        }
        return todosOsAniversariantes;
    }

    public Collection<Contato> getContatos() {
        return this.contatos.values();
    }
    public boolean cadastraContato(String nome, int dia, int mes) {
        if(!contatos.containsKey(nome)) {
            this.contatos.put(nome, new Contato(nome, dia, mes));
            return true;
        } else {
            return false;
        }
    }

    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> contatosAchados = new ArrayList<>();
        for(Contato c : this.contatos.values()) {
            if(c.getDiaAniversariante() == dia && c.getMesAniversariante() == mes) {
                contatosAchados.add(c);
            }
        }
        return contatosAchados;
    }

    public boolean removeContato(String nome) {
        if(this.contatos.containsKey(nome)) {
            this.contatos.remove(nome);
            return true;
        } else {
            return false;
        }
    }
}
