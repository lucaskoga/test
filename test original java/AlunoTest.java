

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AlunoTest {

	@Test
	public void verificaAlunoCod10Test() {
		Aluno aluno = new Aluno("10");
		assertFalse(aluno.verficaAluno());
	}
	 @Test
	    public void testVerficaAlunoCodigoDiferente10() {
	        Aluno aluno = new Aluno("12345");
	        assertTrue(aluno.verficaAluno());
	    }

	    @Test
	    public void testVerficaAlunoVazioOuNulo() {
	        Aluno aluno = new Aluno("");
	        assertTrue(aluno.verficaAluno());
	    }
	    
	    @Rule
	    public ExpectedException exceptionRule = ExpectedException.none();

	    @Test
	    public void testVerificaDebitoCodigo4() {
	        Aluno aluno = new Aluno("4");
	        assertFalse(aluno.verificaDebito());
	    }

	    @Test
	    public void testVerificaDebitoCodigoDiferente4() {
	        Aluno aluno = new Aluno("123");
	        assertTrue(aluno.verificaDebito());
	    }

	    @Test
	    public void testVerificaDebitoComValorString() {
	    	exceptionRule.expect(NumberFormatException.class);
	        Aluno aluno = new Aluno("AlgumaCoisa");
	        assertTrue(aluno.verificaDebito());
	    }

	   
	    @Test
	    public void testVerificaDebitoCodigoVazioOuNulo() {
	        exceptionRule.expect(NumberFormatException.class);
	        Aluno aluno = new Aluno("");
	        assertTrue(aluno.verificaDebito());
	    }
}
