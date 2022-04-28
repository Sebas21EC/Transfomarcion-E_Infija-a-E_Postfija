/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.Transformacion_Infija;

/**
 *
 * @author SebasCarlosama
 */
public class TrnasformacionInfija {

    //Atributos
    Pila pila;
    String expresion_infija;
    char[] arreglo_infijo;
    char[] arreglo_postfijo;
    int numero_de_caracteres;

    /**
     * Constructor 1
     *
     * @param expresion_infija recibe como parametro una cadena con una
     * expresion infija.
     */
    public TrnasformacionInfija(String expresion_infija) {
        this.expresion_infija = expresion_infija;
        numero_de_caracteres = expresion_infija.length();
        this.pila = new Pila(numero_de_caracteres);
        this.arreglo_infijo = new char[numero_de_caracteres];

    }

    public char[] getArreglo_postfijo() {
        return arreglo_postfijo;
    }

    public int getNumero_de_caracteres() {
        return numero_de_caracteres;
    }

    public void ConvertirArregloInfijo() {
        for (int i = 0; i < numero_de_caracteres; i++) {
            arreglo_infijo[i] = expresion_infija.charAt(i);
        }
    }

    /**
     * Método para dar prioridad a los signos
     *
     * @param caracter Recibe como parametro un caracter que contiene el signo
     * @return Retorna un numero qque corresponda a su prioridad.
     */
    public int Prioridad(char caracter) {
        int prioridad = -1;
        switch (caracter) {
            case '(':
            case ')':
                prioridad = 0;
                break;

            case '+':
            case '-': {
                prioridad = 1;
                break;
            }
            case '*':
            case '/': {
                prioridad = 2;
                break;
            }
            case '^': {
                prioridad = 3;
                break;
            }
        }
        return prioridad;
    }

    /**
     * Metodo transformar de cadena infija a postfija
     */
    public void Transformar_postfijo() {
        int j = 0;
        int numero_parentesis = 0;

        //Contar numero de parentesis en la expresion
        for (int i = 0; i < arreglo_infijo.length; i++) {
            if (Prioridad(arreglo_infijo[i]) == 0) {
                numero_parentesis++;
            }
        }
        this.arreglo_postfijo = new char[numero_de_caracteres - numero_parentesis];

        //Colocar los caracteres en el arreglo postfijo
        for (int i = 0; i < this.numero_de_caracteres; i++) {
            if (pila.VerificarVacia() && Prioridad(arreglo_infijo[i]) != -1) {
                pila.Apilar(arreglo_infijo[i]);
            } else {
                if (Prioridad(arreglo_infijo[i]) == -1) {
                    this.arreglo_postfijo[j] = arreglo_infijo[i];
                    j++;
                } else {

                    if (Prioridad(arreglo_infijo[i]) == 0) {

                        if (((char) arreglo_infijo[i]) == '(') {
                            pila.Apilar(arreglo_infijo[i]);
                        } else {

                            while (!pila.VerificarVacia()) {
                                char a = (char) pila.Desapilar();
                                if (a != '(' && a != ')') {
                                    arreglo_postfijo[j] = a;
                                    j++;
                                }
                            }

                        }

                    } else {
                        if (Prioridad(arreglo_infijo[i]) > Prioridad((char) pila.Cima())) {
                            pila.Apilar(arreglo_infijo[i]);
                        } else {
                            if (Prioridad(arreglo_infijo[i]) <= Prioridad((char) pila.Cima())) {
                                while (!pila.VerificarVacia() && (Prioridad(arreglo_infijo[i]) <= Prioridad((char) pila.Cima()))) {

                                    arreglo_postfijo[j] = (char) pila.Desapilar();
                                    j++;
                                }
                                pila.Apilar(arreglo_infijo[i]);
                            }
                        }

                    }

                }
            }

        }
        while (!pila.VerificarVacia()) {
            arreglo_postfijo[j] = (char) pila.Desapilar();
            j++;
        }

    }

    /**
     * Metodo para concatenar los carcteres del arreglo postfijo
     *
     * @return
     */
    public String Retornar_expresion_postfija() {
        String r = "";
        for (int i = 0; i < arreglo_postfijo.length; i++) {
            r += arreglo_postfijo[i];

        }
        return r;
    }

}
