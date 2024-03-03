import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class ItemTest {

    @Test
    public void testCalculaDataDevolucaoDinamico() {
        // Configuração do teste
        int qtdeLivros = 1;
        Livro livro = new Livro(1);
        Item item = new Item(livro);
        LocalDateTime dataInicial = LocalDateTime.of(2022, 1, 1, 0, 0); // Data inicial fixa para tornar o teste determinístico

        // Execução do teste
        LocalDateTime dataDevolucao = item.calculaDataDevolucao(dataInicial, qtdeLivros);

        // Verificação
        assertEquals(dataInicial.plusDays(5), dataDevolucao);
    }
}
