package com.example.eths.filtro_iot.bo;

/**
 * Created by eths on 9/18/16.
 */
public class DispositivoBO {

    private String nome;
    private String estado;
    private float consumoAtual;
    private float consumoTotal;

    public DispositivoBO(String nome, String estado, float consumoAtual, float consumoTotal) {
        this.nome = nome;
        this.estado = estado;
        this.consumoAtual = consumoAtual;
        this.consumoTotal = consumoTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(float consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public float getConsumoAtual() {
        return consumoAtual;
    }

    public void setConsumoAtual(float consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
