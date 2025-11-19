package org.example.View;

import org.example.Model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class TarefaView {
    private Scanner scanner;

    public TarefaView() {
        this.scanner = new Scanner(System.in);
    }
    public void mostrarMenu(){
        //Exbição do Menu
        System.out.println("--- Menu To-Do List ---");
        System.out.println("1. Adicionar Tarefas");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Remover tarefa");
        System.out.println("5. Sair");
        System.out.println("Digite sua opção: ");

    }
    public int lerOpcao(){
        //vai ler oq o scanner pedir
        int opcao = scanner.nextInt();
        scanner.nextLine(); // <--- Essa linha limpa o buffer (o Enter sobrando)
        return opcao;
    }
    public String lerTexto(){
        return scanner.nextLine();
    }
    public void mostrarLista(List<Tarefa> lista) {
        System.out.println("--- Lista de Tarefas ---");
        for(Tarefa t : lista){
            System.out.println(t);
        }
    }
}
