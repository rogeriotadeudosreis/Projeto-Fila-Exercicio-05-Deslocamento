/*
 * 5. Se uma fila representada por arranjos (vetores) não é considerada circular,
 * sugere-se que cada operação Desenfileira deve deslocar para “frente” todos
 * elementos restantes de uma fila. Uma maneira alternativa é adiar o
 * deslocamento até que “fim” seja igual ao último índice do vetor. Quando
 * essa situação ocorre e faz-se uma tentativa de inserir um elemento na fila, a
 * fila inteira é deslocada para “frente”, de modo que o primeiro elemento da fila
 * fique na primeira posição do vetor, ou posição 0, implementação em Java.
 * Quais são as vantagens desse método sobre um deslocamento em cada
 * operação Desenfileira? Quais as desvantagens? Reescreva métodos
 * Desenfileira, Enfileira e Vazia usando essa nova maneira.
 */
package br.com.rogerio.model;

/**
 *
 * @author roger
 */
public class Fila_Deslocamento {

    private int tamanho;
    private int inicio;
    private int fim;
    private int array[];
    private int quantElementos;

    public Fila_Deslocamento() {
        this(10);
    }
    
    public Fila_Deslocamento(int tamanho){
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho deve ser maior que zero!\n");
        }
        this.tamanho = tamanho;
        this.array = new int [tamanho];
        inicio = 0;
        fim = 0;
        quantElementos = 0;
    }

    public boolean isEmpty() {
        return quantElementos == 0;
    }

    public boolean isFull() {
        return quantElementos == tamanho;
    }

    public int size() {
        return quantElementos;
    }

    public void enqueue(int elemento) {
        if (isFull()) {
            throw new RuntimeException("A fila está cheia!");
        }
        if (fim == tamanho) {
            for (int i = 0; i < quantElementos; i++) {
                array[i] = array[inicio + i];
            }
            inicio = 0;
            fim = quantElementos;
        }
            array[fim] = elemento;
            quantElementos++;
            fim++;
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia!\n");
        }
        inicio = (inicio + 1) % tamanho;
        quantElementos--;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia!\n");
        }
        return array[inicio];
    }

    public void destroy() {
        inicio = 0;
        fim = 0;
        quantElementos = 0;
    }
    
    public int getInicio(){
        return inicio;
    }

}
