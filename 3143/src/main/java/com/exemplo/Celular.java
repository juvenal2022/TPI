package com.exemplo;

import java.util.Scanner;

public class Celular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt());
        int N = sc.nextInt();
        sc.nextLine(); // consumir quebra de linha

        long totalLinhas = 0;

        while (sc.hasNextLine()) {
            String msg = sc.nextLine();
            int i = 0;
            int len = msg.length();

            while (i < len) {
                int end = i + N;  // ponto de corte

                if (end < len) {
                    // vai quebrar aqui
                    // se o próximo caractere for espaço, remover
                    if (msg.charAt(end) == ' ') {
                        // pula todos os espaços consecutivos
                        while (end < len && msg.charAt(end) == ' ') {
                            end++;
                        }
                    }
                }

                // conta uma linha
                totalLinhas++;

                i = end; // próximo pedaço começa aqui
            }
        }

        System.out.println(totalLinhas);
        sc.close();
    }
}
