package com.exemplo;

import java.util.Scanner;

public class Virgula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            // Procura a vírgula
            int pos = linha.indexOf(',');

            // Se houver vírgula (como garante o enunciado)
            if (pos != -1) {
                String primeira = linha.substring(0, pos);
                String segunda = linha.substring(pos + 1); // parte após a vírgula

                System.out.println(primeira);
                System.out.println(segunda);
            }
        }

        sc.close();
    }
}
