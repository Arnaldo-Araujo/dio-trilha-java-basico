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

            System.out.println("Nome: "+conta.getNomeCliente()); 
            System.out.println("Conta Bancário: "+conta.getContaCorrente());
            System.out.println("Agencia: "+conta.getAgencia());
            System.out.print("Seu saldo é: R$ "+conta.getSaldo());
                        
            }

            private static void recebeSaldo(){
                System.out.println("Digite o valor inicial de depósito, ex: 2586.69");
                try {
                    bd = new BigDecimal(sc.nextLine());
                    conta.setSaldo(bd);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            private static void recebeNomeCliente(){
                System.out.println("Digite seu nome completo, ex,: Armandinon Andrade Rocha");
                try {
                    String nomeCompleto = sc.nextLine();
                    conta.setNomeCliente(nomeCompleto);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
                        
            private static void recebeAgencia() {
                System.out.println("Digite a sua agencia ex.: 1658-X");
                try {
                    String agencia = sc.nextLine();
                    conta.setAgencia(agencia);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }            
            }
                
            private static void recebeNumeroConta() {
            System.out.println("Digite seu numero da conta, ex.: 12345");        
            try {
                int numconta = sc.nextInt();
                conta.setContaCorrente(numconta);    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}