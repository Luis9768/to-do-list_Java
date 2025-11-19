package org.example.Controller;

import org.example.Model.Tarefa;
import org.example.View.TarefaView;
import org.example.dao.TarefaDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TarefaController {
    private TarefaDAO tarefaDAO;
    private TarefaView tarefaView;
    private Scanner scanner = new Scanner(System.in);

    public TarefaController() {
        this.tarefaDAO = new TarefaDAO();
        this.tarefaView = new TarefaView();
    }

    public void adicionarTarefa() {
        String texto = tarefaView.lerTexto();
        Tarefa tarefa = new Tarefa(0, texto);
        tarefaDAO.adicionar(tarefa);
    }

    public void iniciar() {
        tarefaView.mostrarMenu();
        int opcao = tarefaView.lerOpcao();
        while (opcao != 5) {

            switch (opcao) {
                case 1:
                    System.out.println("Adicione uma tarefa: ");
                    adicionarTarefa();
                    break;
                case 2:
                    System.out.println("Exibindo lista de tarefas");
                    List<Tarefa> listaTarefa = tarefaDAO.listarTarefas();
                    tarefaView.mostrarLista(listaTarefa);
                    break;
                case 3:
                    System.out.println("Digite o ID que deseja concluir: ");
                    int id = tarefaView.lerOpcao();
                    tarefaDAO.concluir(id);
                    break;
                case 4:
                    System.out.println("Digite o id da tarefa que deseja apagar: ");
                    int remove = tarefaView.lerOpcao();
                    tarefaDAO.remover(remove);
                    break;
                default:
            }

            tarefaView.mostrarMenu();
            opcao = tarefaView.lerOpcao();


        }
    }
}
