package com.exemplo;

import java.util.Scanner;

public class NossosDias {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            String frase = "LIFE IS NOT A PROBLEM TO BE SOLVED BUT A REALITY TO BE EXPERIENCED";

            // Imprime apenas os N primeiros caracteres
            System.out.println(frase.substring(0, N));
        }
    }
}

