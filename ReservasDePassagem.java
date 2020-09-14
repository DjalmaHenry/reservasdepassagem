package reservasdepassagem;

import java.util.Scanner;

public class ReservasDePassagem {

    public static boolean verificaEspaco(boolean vet[]) {
        boolean verificado = true;
        int i;
        for (i = 1; i < vet.length; i++) {
            if (vet[i] == false) {
                verificado = false;
            }
        }
        return verificado;
    }

    public static void verificaPoltronas(boolean vet[], char fila) {
        int i;
        for (i = 1; i < vet.length; i++) {
            if (vet[i] == false) {
                System.out.println("Vaga " + fila + i);
            }
        }
    }

    public static boolean verificaVaga(boolean vet[], int poltrona) {
        boolean verificado = true;
        if (vet[poltrona] == false) {
            verificado = false;
        }
        return verificado;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] filaA = new boolean[13];
        boolean[] filaB = new boolean[13];
        boolean[] filaC = new boolean[13];
        boolean[] filaD = new boolean[13];
        boolean verificaA, verificaB, verificaC, verificaD,
                verificaOnibus = true, verificado;
        char escolhe, fila, opcao, opçao;
        int poltrona, loop;
        do {
            System.out.println("Bem-vindo à Viagem Bem, linha "
                    + "Recife-Fortaleza.");
            verificaA = verificaEspaco(filaA);
            verificaB = verificaEspaco(filaB);
            verificaC = verificaEspaco(filaC);
            verificaD = verificaEspaco(filaD);
            if (verificaA == false) {
                verificaOnibus = false;
            } else if (verificaB == false) {
                verificaOnibus = false;
            } else if (verificaC == false) {
                verificaOnibus = false;
            } else if (verificaD == false) {
                verificaOnibus = false;
            }
            if (verificaA == true && verificaB == true && verificaC && verificaD == true) {
                System.out.println("Infelizmente não existem mais vagas "
                        + "disponíveis para essa viagem. Viagem Bem agradeçe a "
                        + "preferencia.");
                System.exit(0);
            }
            if (verificaOnibus == false) {
                System.out.println("Para um maior conforto de sua viagem,"
                        + " por favor informe se você prefere sentar-se na"
                        + " janela ou corredor?");
                System.out.print("Digite J para janela ou C para corredor: ");
                escolhe = input.next().charAt(0);
                input.nextLine();
                escolhe = Character.toUpperCase(escolhe);
                while (escolhe != 'J' && escolhe != 'C') {
                    System.out.println("Erro, informe um valor válido.");
                    System.out.print("Digite J para janela ou C para"
                            + " corredor: ");
                    escolhe = input.next().charAt(0);
                    input.nextLine();
                    escolhe = Character.toUpperCase(escolhe);
                }
                if (escolhe == 'J') {
                    if (verificaA == false && verificaC == false) {
                        System.out.println("Temos vaga na fileira A e C:");
                        verificaPoltronas(filaA, fila = 'A');
                        verificaPoltronas(filaC, fila = 'C');
                        System.out.println("Deseja sentar-se na fileira A ou C?"
                                + " Informe a letra:");
                        fila = input.next().charAt(0);
                        input.nextLine();
                        fila = Character.toUpperCase(fila);
                        while (fila != 'A' && fila != 'C') {
                            System.out.println("Erro, informe um valor"
                                    + " válido.");
                            System.out.println("Deseja sentar-se na fileira "
                                    + "A ou C? Informe a letra:");
                            fila = input.next().charAt(0);
                            input.nextLine();
                            fila = Character.toUpperCase(fila);
                        }
                        System.out.println("Qual poltrona deseja sentar-se? "
                                + "Informe o número do assento de 1 a 12:");
                        poltrona = input.nextInt();
                        input.nextLine();
                        while (poltrona < 1 || poltrona > 12) {
                            System.out.println("Erro, informe um valor "
                                    + "válido.");
                            System.out.println("Qual poltrona deseja "
                                    + "sentar-se? Informe o número do "
                                    + "assento de 1 a 12:");
                            poltrona = input.nextInt();
                            input.nextLine();
                        }
                        if (fila == 'A') {
                            verificado = verificaVaga(filaA, poltrona);
                            if (verificado == false) {
                                filaA[poltrona] = true;
                                System.out.println("Poltrona " + fila + poltrona
                                        + " reservada com sucesso!");
                            } else {
                                System.out.println("Erro, cadeira já reservada,"
                                        + " por favor faça outra consulta e "
                                        + "escolha outra poltrona.");
                            }
                        } else {
                            verificado = verificaVaga(filaC, poltrona);
                            if (verificado == false) {
                                filaC[poltrona] = true;
                                System.out.println("Poltrona " + fila + poltrona
                                        + " reservada com sucesso!");
                            } else {
                                System.out.println("Erro, cadeira já reservada,"
                                        + " por favor faça outra consulta e "
                                        + "escolha outra poltrona.");
                            }
                        }
                    } else if (verificaA == true && verificaC == false) {
                        System.out.println("Temos vaga na fileira C:");
                        verificaPoltronas(filaC, fila = 'C');
                        System.out.println("Qual poltrona deseja sentar-se?"
                                + " Informe o número do assento de 1 a 12:");
                        poltrona = input.nextInt();
                        input.nextLine();
                        while (poltrona < 1 || poltrona > 12) {
                            System.out.println("Erro, informe um valor"
                                    + " válido.");
                            System.out.println("Qual poltrona deseja "
                                    + "sentar-se? Informe o número do "
                                    + "assento de 1 a 12:");
                            poltrona = input.nextInt();
                            input.nextLine();
                        }
                        verificado = verificaVaga(filaC, poltrona);
                        if (verificado == false) {
                            filaC[poltrona] = true;
                            System.out.println("Poltrona " + fila + poltrona
                                    + " reservada com sucesso!");
                        } else {
                            System.out.println("Erro, cadeira já reservada,"
                                    + " por favor faça outra consulta e "
                                    + "escolha outra poltrona.");
                        }
                        System.out.println("Poltrona " + fila + poltrona
                                + " reservada com sucesso!");
                    } else if (verificaA == false && verificaC == true) {
                        System.out.println("Temos vaga na fileira A:");
                        verificaPoltronas(filaA, fila = 'A');
                        System.out.println("Qual poltrona deseja sentar-se?"
                                + " Informe o número do assento de 1 a 12:");
                        poltrona = input.nextInt();
                        input.nextLine();
                        while (poltrona < 1 || poltrona > 12) {
                            System.out.println("Erro, informe um valor "
                                    + "válido.");
                            System.out.println("Qual poltrona deseja"
                                    + " sentar-se? Informe o número do"
                                    + " assento de 1 a 12:");
                            poltrona = input.nextInt();
                            input.nextLine();
                        }
                        verificado = verificaVaga(filaA, poltrona);
                        if (verificado == false) {
                            filaA[poltrona] = true;
                            System.out.println("Poltrona " + fila + poltrona
                                    + " reservada com sucesso!");
                        } else {
                            System.out.println("Erro, cadeira já reservada,"
                                    + " por favor faça outra consulta e "
                                    + "escolha outra poltrona.");
                        }
                        System.out.println("Poltrona " + fila + poltrona
                                + " reservada com sucesso!");
                    } else {
                        System.out.println("Não temos vagas disponíveis para a"
                                + " Janela. Realize outra consulta e escolha a"
                                + " opção Corredor.");
                    }
                } else {
                    if (verificaB == false && verificaD == false) {
                        System.out.println("Temos vaga na fileira B e D:");
                        verificaPoltronas(filaB, fila = 'B');
                        verificaPoltronas(filaD, fila = 'D');
                        System.out.println("Deseja sentar-se na fileira B ou D?"
                                + " Informe a letra:");
                        fila = input.next().charAt(0);
                        input.nextLine();
                        fila = Character.toUpperCase(fila);
                        while (fila != 'B' && fila != 'D') {
                            System.out.println("Erro, informe um valor "
                                    + "válido.");
                            System.out.println("Deseja sentar-se na fileira "
                                    + "B ou D? Informe a letra:");
                            fila = input.next().charAt(0);
                            input.nextLine();
                            fila = Character.toUpperCase(fila);
                        }
                        System.out.println("Qual poltrona deseja sentar-se? "
                                + "Informe o número do assento de 1 a 12:");
                        poltrona = input.nextInt();
                        input.nextLine();
                        while (poltrona < 1 || poltrona > 12) {
                            System.out.println("Erro, informe um valor "
                                    + "válido.");
                            System.out.println("Qual poltrona deseja "
                                    + "sentar-se? Informe o número do assento"
                                    + " de 1 a 12:");
                            poltrona = input.nextInt();
                            input.nextLine();
                        }
                        if (fila == 'B') {
                            verificado = verificaVaga(filaB, poltrona);
                            if (verificado == false) {
                                filaB[poltrona] = true;
                                System.out.println("Poltrona " + fila + poltrona
                                        + " reservada com sucesso!");
                            } else {
                                System.out.println("Erro, cadeira já reservada,"
                                        + " por favor faça outra consulta e "
                                        + "escolha outra poltrona.");
                            }
                        } else {
                            verificado = verificaVaga(filaD, poltrona);
                            if (verificado == false) {
                                filaD[poltrona] = true;
                                System.out.println("Poltrona " + fila + poltrona
                                        + " reservada com sucesso!");
                            } else {
                                System.out.println("Erro, cadeira já reservada,"
                                        + " por favor faça outra consulta e "
                                        + "escolha outra poltrona.");
                            }
                        }
                        System.out.println("Poltrona " + fila + poltrona
                                + " reservada com sucesso!");
                    } else if (verificaB == true && verificaD == false) {
                        System.out.println("Temos vaga na fileira D:");
                        verificaPoltronas(filaD, fila = 'D');
                        System.out.println("Qual poltrona deseja sentar-se?"
                                + " Informe o número do assento de 1 a 12:");
                        poltrona = input.nextInt();
                        input.nextLine();
                        while (poltrona < 1 || poltrona > 12) {
                            System.out.println("Erro, informe um valor"
                                    + " válido.");
                            System.out.println("Qual poltrona deseja "
                                    + "sentar-se? Informe o número do assento"
                                    + " de 1 a 12:");
                            poltrona = input.nextInt();
                            input.nextLine();
                        }
                        verificado = verificaVaga(filaD, poltrona);
                        if (verificado == false) {
                            filaD[poltrona] = true;
                            System.out.println("Poltrona " + fila + poltrona
                                    + " reservada com sucesso!");
                        } else {
                            System.out.println("Erro, cadeira já reservada,"
                                    + " por favor faça outra consulta e "
                                    + "escolha outra poltrona.");
                        }
                        System.out.println("Poltrona " + fila + poltrona
                                + " reservada com sucesso!");
                    } else if (verificaB == false && verificaD == true) {
                        System.out.println("Temos vaga na fileira B:");
                        verificaPoltronas(filaB, fila = 'B');
                        System.out.println("Qual poltrona deseja sentar-se? "
                                + "Informe o número do assento de 1 a 12:");
                        poltrona = input.nextInt();
                        input.nextLine();
                        while (poltrona < 1 || poltrona > 12) {
                            System.out.println("Erro, informe um valor "
                                    + "válido.");
                            System.out.println("Qual poltrona deseja "
                                    + "sentar-se? Informe o número do assento "
                                    + "de 1 a 12:");
                            poltrona = input.nextInt();
                            input.nextLine();
                        }
                        verificado = verificaVaga(filaB, poltrona);
                        if (verificado == false) {
                            filaB[poltrona] = true;
                            System.out.println("Poltrona " + fila + poltrona
                                    + " reservada com sucesso!");
                        } else {
                            System.out.println("Erro, cadeira já reservada,"
                                    + " por favor faça outra consulta e "
                                    + "escolha outra poltrona.");
                        }
                        System.out.println("Poltrona " + fila + poltrona
                                + " reservada com sucesso!");
                    } else {
                        System.out.println("Não temos vagas disponíveis para o"
                                + " Corredor. Realize outra consulta e escolha "
                                + "a opção Janela.");
                    }
                }
            }
            System.out.print("Deseja realizar outra reserva? Digite S ou N: ");
            loop = input.next().charAt(0);
            input.nextLine();
            loop = Character.toUpperCase(loop);
            while (loop != 'S' && loop != 'N') {
                System.out.println("Erro, informe um valor válido.");
                System.out.print("Deseja realizar outra reserva? Digite "
                        + "S ou N: ");
                loop = input.next().charAt(0);
                input.nextLine();
                loop = Character.toUpperCase(loop);
            }
        } while (loop == 'S');
    }
}