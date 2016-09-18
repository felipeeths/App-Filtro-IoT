package com.example.eths.filtro_iot.bo;

/**
 * Created by eths on 9/18/16.
 */
public class Dispositivo {

    private int idDisposivio;
    private String nome;
    private boolean estado;
    private float consumoAtual;
    private float consumoTotal;

    public Dispositivo(float consumoTotal, float consumoAtual, boolean estado, String nome, int idDisposivio) {
        this.consumoTotal = consumoTotal;
        this.consumoAtual = consumoAtual;
        this.estado = estado;
        this.nome = nome;
        this.idDisposivio = idDisposivio;
    }

    public int getIdDisposivio() {
        return idDisposivio;
    }

    public void setIdDisposivio(int idDisposivio) {
        this.idDisposivio = idDisposivio;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
