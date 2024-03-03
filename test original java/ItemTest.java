

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ItemTest {

	@Test
    public void testCalculaDataDevolucaoDinamico() {
        int diasAdicionais = 0;
        int qtdeLivros = 1;  
        Livro livro = new Livro(1);  
        Item item = new Item(livro);

        List<Livro> livros = new ArrayList<>();
        for (int i = 1; i <= qtdeLivros; i++) {
            livros.add(new Livro(i));
        }

        LocalDateTime dataInicial = LocalDateTime.now();

        for (Livro livroDoItem : livros) {
            Item itemDoEmprestimo = new Item(livroDoItem);
            itemDoEmprestimo.calculaDataDevolucao(dataInicial, qtdeLivros);
        }

        LocalDateTime dataDevolucao = item.calculaDataDevolucao(dataInicial, qtdeLivros);


        if (qtdeLivros == 1) {
            diasAdicionais = 5;
        } else if (qtdeLivros >= 2 && qtdeLivros <= 10) {
            diasAdicionais = 5 + 2 * qtdeLivros - 1;
        } else {
            throw new IllegalArgumentException("Número inválido de livros");
        }
        

        assertEquals(dataInicial.plusDays(diasAdicionais), dataDevolucao);
    }

}
