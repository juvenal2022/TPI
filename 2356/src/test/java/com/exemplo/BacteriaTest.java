package com.exemplo;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BacteriaTest {

    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testSequenciaResistente() {
        String input = "ACGTACGT ACGT\n"; // dna contém a sequência
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Bacteria.main(new String[]{});

        assertEquals("Resistente\n", outContent.toString());
    }

    @Test
    void testSequenciaNaoResistente() {
        String input = "AAAAA TTT\n"; // dna NÃO contém a sequência
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Bacteria.main(new String[]{});

        assertEquals("Nao resistente\n", outContent.toString());
    }

    @Test
    void testMultiplasLinhas() {
        String input = ""
                + "AAAAA AAA\n"     // resistente
                + "ACGT TTT\n";      // não resistente
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Bacteria.main(new String[]{});

        assertEquals(
                "Resistente\n" +
                "Nao resistente\n",
                outContent.toString()
        );
    }
}
