package com.exemplo;

import java.util.Scanner;

public class ArvoreDeNatal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            // Lê o valor de N
            int N = scanner.nextInt(); 
            // Desenha a parte de cima da árvore (folhas)
            for (int i = 1; i <= N; i += 2) {
                // Calcula a quantidade de espaços à esquerda para centralizar os asteriscos
                int espacos = (N - i) / 2;                
                // Imprime os espaços e os asteriscos
                for (int j = 0; j < espacos; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            int espacosCaule = (N - 1) / 2;
            // Desenha o caule (1 asterisco)
            for (int i = 0; i < espacosCaule; i++) {
                System.out.print(" ");
            }
            System.out.println("*");                       
            // Desenha o tronco (3 asteriscos e depois 1 asterisco)
            int espacosTronco = (N - 3) / 2;
            for (int i = 0; i < espacosTronco; i++) {
                System.out.print(" ");
            }

            System.out.println("***");           
            // Desenha o último asterisco do tronco
            for (int i = 0; i < espacosTronco; i++) {
                System.out.print(" ");
            }            
            // Linha em branco após cada árvore
            System.out.println();
        }       
        scanner.close();
    }
}
