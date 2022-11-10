package br.ufpb.dcx.silvio.agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaSilvioTest {
    
    AgendaSilvio sistema;

    @BeforeEach
    void setup() {
        this.sistema = new AgendaSilvio();
    }

    @Test
    void testPesquisaECadastroDeAniversariante() {
        try {
            assertTrue(sistema.pesquisaAniversariantes(2, 3).isEmpty());
           // fail("Deveria falhar pois não existe ainda");
        } catch(Exception e) {
            fail("A lista deveria estar vazia");
        }

        try {
            sistema.cadastraContato("Silvio", 2, 3);
            Collection<Contato> pesquisarAniversariante = sistema.pesquisaAniversariantes(2, 3);
            for(Contato aniversariante : pesquisarAniversariante) {
                assertEquals("Silvio", aniversariante.getNome());
                break;
                
            }
        } catch (Exception e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testRemoverContato() {
        sistema.cadastraContato("Maria Cecilia", 5, 3);
        sistema.cadastraContato("Antonia", 4, 12);
        sistema.cadastraContato("Silvio", 2, 3);
        

        try {
            boolean removeu1 = sistema.removeContato("Maria Cecilia");
            assertEquals(true, removeu1);
        } catch (Exception e) {
            fail("Não deveria lançar exceção");
        }

        try {
            boolean removeu2 = sistema.removeContato("Silvio");
            assertEquals(true, removeu2);
        } catch (Exception e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testMostrarTodosOsAniversariantes() {
        sistema.cadastraContato("Maria Cecilia", 5, 3);
        sistema.cadastraContato("Antonia", 4, 12);
        sistema.cadastraContato("Silvio", 2, 3);

        ArrayList<Contato> mostrarAniversariantes = sistema.MostrarTodosOsAniversariantes();

        try {
            assertTrue(!mostrarAniversariantes.isEmpty());
        } catch (Exception e) {
            fail("Não deveria lançar exceção");
        }
    }
}
