

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
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
        assertFalse(emprestimo.emprestar(livros,0));
    }

    @Test
    public void testEmprestarPeloMenosUmLivro() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(666)); 
        assertTrue(emprestimo.emprestar(livros,1));
    }

  

    @Test
    public void testEmprestarPeloMenosUmLivroParticaoEquivalencia() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(7)); 
        assertTrue(emprestimo.emprestar(livros,1));
    }

    @Test
    public void testEmprestarMaximoLivros() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            livros.add(new Livro(generator.nextInt()));
        }
        assertTrue(emprestimo.emprestar(livros,10));
        
    }
    

    @Test
    public void testEmprestarNenhumLivroParticaoEquivalencia() {
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        assertFalse(emprestimo.emprestar(livros, 2));
    }
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    
    @Test
    public void testEmprestarAlem() {
        Emprestimo emprestimo = new Emprestimo();
        final List<Livro> livros = new ArrayList<>();
        Random generator = new Random();

        // Adiciona 18 livros à lista
        for (int i = 0; i < 18; i++) {
            livros.add(new Livro(generator.nextInt()));
        }

        // Utiliza assertThrows para verificar se a exceção é lançada ao tentar emprestar mais de 10 livros
        assertThrows(Error.class, () -> {
            emprestimo.emprestar(livros, 18);
        });
    }
}
