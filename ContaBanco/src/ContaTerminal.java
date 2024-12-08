import java.math.BigDecimal;
import java.util.Scanner;

import org.arnaldo.model.ContaBancaria;

public class ContaTerminal {
    private static ContaBancaria conta;
    private static Scanner sc;
    private static BigDecimal bd;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        conta = new ContaBancaria();

        recebeAgencia();
        recebeNumeroConta();
        recebeNomeCliente();
        recebeSaldo();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência" 
        +" é %s, sua conta é %s e seu saldo %f já está disponível para saque158-x!", 
        conta.getNomeCliente(), 
        conta.getAgencia(),
        conta.getContaCorrente(), 
        conta.getSaldo());
    }

    private static void recebeSaldo() {

        while (true) {
            System.out.println("Digite o valor inicial de depósito, ex: 2586.69");
            try {
                String input = sc.nextLine();
                bd = new BigDecimal(input);
                conta.setSaldo(bd);
                break; // Sai do loop se o valor for válido
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private static void recebeNomeCliente() {
        while (true) {
            System.out.println("Digite seu nome completo, ex,: Armandinon Andrade Rocha");
            try {
                String nomeCompleto = sc.nextLine().trim();
                if (nomeCompleto.isEmpty()) {
                    throw new IllegalArgumentException("O nome não pode estar vazio.");
                }
                conta.setNomeCliente(nomeCompleto);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void recebeAgencia() {
        while(true){
            System.out.println("Digite a sua agencia ex.: 1658-X");
            try {
                String agencia = sc.nextLine().trim();
                if(agencia.isEmpty()){
                    throw new IllegalArgumentException("A agencia não pode ser vazia");
                }
                conta.setAgencia(agencia);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void recebeNumeroConta() {
        while(true){
            System.out.println("Digite seu numero da conta, ex.: 12345");
            try {
                String input = sc.nextLine().trim();
                int numConta = Integer.parseInt(input);

                conta.setContaCorrente(numConta);
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Erro: Por favor, insira um número inteiro válido.");    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}