package com.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CelularTest {

    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void runWithInput(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Celular.main(null);
    }

    @Test
    public void testExemploOficial() throws Exception {
        String input = 
                "10\n" +
                "Oi Ritch\n" +
                "Eh o Roger\n" +
                "Vc ta vivo ainda? Faz dias q vc n me respondeu mais :(:(:(:(:(\n";

        String expected = "8\n";

        runWithInput(input);

        assertEquals(expected, output.toString());
    }

    @Test
    public void testMensagemCurta() throws Exception {
        String input =
                "5\n" +
                "Oi\n";

        String expected = "1\n";

        runWithInput(input);

        assertEquals(expected, output.toString());
    }

    @Test
    public void testMensagemLongaSemEspacosParaRemover() throws Exception {
        String input =
                "4\n" +
                "ABCDE\n"; // quebra em: ABCD | E (2 linhas)

        String expected = "2\n";

        runWithInput(input);

        assertEquals(expected, output.toString());
    }

    @Test
    public void testRemocaoDeEspacosNaQuebra() throws Exception {
        String input =
                "4\n" +
                "Oi   voce\n";  
        // Mensagem: "Oi   voce"
        // 0–3: "Oi  "  (4 chars)
        // próximo trecho começa em index 4 ⇒ caractere ' ' → pula até "voce"
        // resultam 2 linhas

        String expected = "2\n";

        runWithInput(input);

        assertEquals(expected, output.toString());
    }
}

