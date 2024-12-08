package org.arnaldo.model;

import java.math.BigDecimal;

public class ContaBancaria {

    private Integer contaCorrente;

    private String agencia;

    private String nomeCliente;

    private BigDecimal saldo;


    public ContaBancaria() {
    }

    public Integer getContaCorrente() {
        return this.contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }


}
