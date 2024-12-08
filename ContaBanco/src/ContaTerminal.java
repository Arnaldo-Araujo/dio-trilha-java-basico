/**
 * Classe principal para simular um terminal de conta bancária.
 * Autor: Arnaldo Junior Dev
 * Data de criação: [Insira a data]
 *
 * Descrição:
 * Esta classe permite que o usuário interaja com uma conta bancária simulada.
 * O programa solicita informações como agência, número da conta, nome do cliente
 * e valor inicial de depósito. Após coletar os dados, exibe uma mensagem de 
 * confirmação com as informações fornecidas.
 */

import java.math.BigDecimal;
import java.util.Scanner;

import org.arnaldo.model.ContaBancaria;

public class ContaTerminal {

    // Atributos globais para manipulação da conta, entrada de dados e valores numéricos
    private static ContaBancaria conta; // Objeto que representa a conta bancária
    private static Scanner sc;          // Scanner para leitura de entradas do usuário
    private static BigDecimal bd;       // BigDecimal para manipulação de valores monetários

    /**
     * Método principal.
     * É o ponto de entrada do programa e coordena a execução dos métodos.
     */
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in); // Inicializa o Scanner
        conta = new ContaBancaria(); // Inicializa a conta bancária

        // Solicita e valida os dados do usuário
        recebeAgencia();
        recebeNumeroConta();
        recebeNomeCliente();
        recebeSaldo();

        // Exibe mensagem de confirmação com os dados fornecidos
        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência" 
        +" é %s, sua conta é %s e seu saldo %f já está disponível para saque158-x!", 
        conta.getNomeCliente(), 
        conta.getAgencia(),
        conta.getContaCorrente(), 
        conta.getSaldo());
    }

    /**
     * Método para receber e validar o saldo inicial do cliente.
     * Solicita um valor monetário e valida se é numérico.
     */
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

    /**
     * Método para receber e validar o nome completo do cliente.
     * Solicita que o cliente informe o nome e valida se não está vazio.
     */
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

    /**
     * Método para receber e validar o número da agência.
     * Solicita o número da agência e valida se não está vazio.
     */
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

     /**
     * Método para receber e validar o número da conta.
     * Solicita um número inteiro e valida se a entrada é numérica.
     */
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