/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Transformacion_Infija;

/**
 *
 * @author SebasCarlosama
 */
public class Pila {

    private int tamaño;
    private Object datos[];
    private int numero_elementos;

    public Pila(int tamaño) {
        this.tamaño = tamaño;
        numero_elementos = 0;
        datos = new Object[tamaño];
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getNumero_elementos() {
        return numero_elementos;
    }

    public void Apilar(Object elemento) {
        if (!VerificarLlena()) {
            datos[numero_elementos++] = elemento;
        }

    }

    public Object Desapilar() {
        if (!VerificarVacia()) {
            Object resultado = datos[--numero_elementos];
            return resultado;
        }
        return "Error";
    }

    public Object Cima() {
        return datos[this.numero_elementos - 1];
    }

    public boolean VerificarVacia() {
        return numero_elementos == 0;
    }

    public boolean VerificarLlena() {
        return numero_elementos == tamaño;
    }

    public String ImprimirPila() {
        String resultado = "";

        for (int i = 0; i < numero_elementos; i++) {
            resultado += datos[i] + "\n\n";
        }
        return resultado;
    }

}
