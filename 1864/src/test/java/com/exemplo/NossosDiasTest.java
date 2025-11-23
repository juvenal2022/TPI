package com.exemplo;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class NossosDiasTest {

    private String runMainWithInput(String input) {
        // Simular entrada
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capturar saída
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        NossosDias.main(null);

        return out.toString().trim();
    }

    @Test
    public void testExample1() {
        assertEquals("L", runMainWithInput("1"));
    }

    @Test
    public void testExample2() {
        assertEquals("LIFE", runMainWithInput("4"));
    }

    @Test
    public void testExample3() {
        assertEquals("LIFE IS N", runMainWithInput("9"));
    }

    @Test
    public void testFullPhraseBeginning() {
        assertEquals("LIFE IS NOT A PROBLEM TO BE SOLVED BUT A REALITY TO BE EXPERIENCED", runMainWithInput("66"));
    }
}
