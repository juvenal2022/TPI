package com.exemplo;

import java.util.Scanner;

public class Bacteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Lê até o final da entrada (EOF)
        while (scanner.hasNext()) {
            String dna = scanner.next().trim();        // DNA da bactéria
            String sequencia = scanner.next().trim();  // Sequência de resistência

            if (dna.contains(sequencia)) {
                System.out.println("Resistente");
            } else {
                System.out.println("Nao resistente");
            }
        }
        scanner.close();
    }
}
