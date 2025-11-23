package com.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VirgulaTest {

    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testEntradaSimples() {
        String input = "O João, eh o maior\n";
        String expectedOutput = "O João\n eh o maior\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Virgula.main(null);

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testMultiplasLinhas() {
        String input =
                "O Sol, eh o melhor remédio\n" +
                "Seja bem vindo, Comendador!\n";

        String expectedOutput =
                "O Sol\n eh o melhor remédio\n" +
                "Seja bem vindo\n Comendador!\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Virgula.main(null);

        assertEquals(expectedOutput, outputStream.toString());
    }
}

