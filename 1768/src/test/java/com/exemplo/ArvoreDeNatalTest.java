package com.exemplo;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

public class ArvoreDeNatalTest {
    @Test
    public void testArvoreDeNatalComEntrada5() throws Exception {

        // Simula entrada do usuário: "5\n"
        String input = "5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Captura a saída do System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream fakeOut = new PrintStream(outputStream);
        System.setOut(fakeOut);

        // Executa o main
        ArvoreDeNatal.main(new String[]{});

        // Converte saída para String
        String saida = outputStream.toString().replace("\r\n", "\n");

        String esperado =
                "  *\n" +
                " ***\n" +
                "*****\n" +
                "  *\n" +
                " ***\n" +
                " \n";

        assertEquals(esperado, saida);
    }

}
