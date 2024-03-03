import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EmprestimoTest {

    @Test
    public void testEmprestarNenhumLivro() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        assertFalse(emprestimo.emprestar(livros, 0));
    }

    @Test
    public void testEmprestarPeloMenosUmLivro() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(666)); 
        assertTrue(emprestimo.emprestar(livros, 1));
    }

    @Test
    public void testEmprestarPeloMenosUmLivroParticaoEquivalencia() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(7)); 
        assertTrue(emprestimo.emprestar(livros, 1));
    }

    @Test
    public void testEmprestarMaximoLivros() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            livros.add(new Livro(i)); // Adiciona livros com IDs sequenciais
        }
        assertTrue(emprestimo.emprestar(livros, 10));
    }

    @Test
    public void testEmprestarNenhumLivroParticaoEquivalencia() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        assertFalse(emprestimo.emprestar(livros, 2));
    }
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = Error.class)
    public void testEmprestarAlem() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        Random generator = new Random();

        // Adiciona 18 livros à lista
        for (int i = 0; i < 18; i++) {
            livros.add(new Livro(generator.nextInt()));
        }

        emprestimo.emprestar(livros, 18); // Deve lançar uma exceção
    }
}
