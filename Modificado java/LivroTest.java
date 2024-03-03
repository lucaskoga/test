import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LivroTest {

    @Test
    public void testVerificaLivroDisponivel() {
        // Arrange
        Livro livroDisponivel = new Livro(3);

        // Act & Assert
        assertTrue(livroDisponivel.verificaLivro());
    }

    @Test
    public void testVerificaLivroIndisponivel() {
        // Arrange
        Livro livroIndisponivel = new Livro(1);

        // Act & Assert
        assertFalse(livroIndisponivel.verificaLivro());
    }

    @Test
    public void testVerificaLivroLimiteInferior() {
        // Arrange
        Livro livroLimiteInferior = new Livro(Integer.MIN_VALUE);

        // Act & Assert
        assertFalse(livroLimiteInferior.verificaLivro());
    }

    @Test
    public void testVerificaLivroLimiteSuperior() {
        // Arrange
        Livro livroLimiteSuperior = new Livro(Integer.MAX_VALUE);

        // Act & Assert
        assertFalse(livroLimiteSuperior.verificaLivro());
    }
}
