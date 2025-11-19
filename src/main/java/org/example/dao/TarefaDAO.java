package org.example.dao;

import org.example.Model.Tarefa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.telemetry.TelemetryAttribute.DB_USER;

public class TarefaDAO {

    /*
        primeiro vamos guarda a URL, usuário e senha em variáveis para fazermos o login no Banco de Dados
     */
    private static final String URL = "jdbc:mysql://luismjava.duckdns.org.duckdns.org:3306/todo_list";
    private static final String USER = System.getenv("DB_USER"); // Ex: root
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    /*
        Agora vamos fazer a conexão com o banco
     */
    public Connection getConnection() throws SQLException {
        //pega variaveis que contem os acessos dentro delas, para fazer o login
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    /*
        Metodo para adicionar tarefas
     */
    public void adicionar(Tarefa tarefa) {
        //vamos guardar um comando sql dentro de uma String para utilizarmos
        String sql = "INSERT INTO tarefas (tarefa, concluida) VALUES (?, ?)";

        //bloco try catch para tratarmos as excessões
        try (Connection conn = getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(sql);

            //Usa um get para pegar a descricao da tarefa
            stmt.setString(1, tarefa.getTarefa());

            //Status (Concluida ou não)
            stmt.setBoolean(2, tarefa.isConcluida());

            // Mandar o banco executar
            stmt.execute();

            stmt.close(); // Boa prática fechar o statement

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        METODO PARA LISTARMOS AS TAREFAS
     */
    public List<Tarefa> listarTarefas() {
        //criar um array para guardar as tarefas
        ArrayList<Tarefa> tarefasList = new ArrayList<>();

        //guarda o comando sql dentro de uma variavel
        String sql = "SELECT * FROM tarefas";

        //bloco try catch para tratarmos as excessões
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();//esse aqui executa uma consulta no sql e retorna a consulta realizada

            while (rs.next()) {
                int id = rs.getInt("id");
                String tarefa = rs.getString("tarefa");
                boolean concluida = rs.getBoolean("concluida");
                Tarefa t = new Tarefa(id, tarefa);
                t.setConcluida(concluida);
                tarefasList.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefasList;
    }

    public boolean concluir(int id) {
        String sql = "UPDATE tarefas SET concluida = true WHERE id = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            // 1. Preenche o ID no lugar da interrogação
            stmt.setInt(1, id);

            // 2. Manda o banco executar a atualização
            stmt.executeUpdate();

            // (Opcional) Se quiser fechar manualmente, embora o try já ajude
            stmt.close();

            return true; // Retorna sucesso!

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna falha se der erro
        }
    }

    public void remover(int id) {

        //Guarda o comando aql numa variavel
        String sql = "DELETE FROM tarefas WHERE id = ?";

        //bloco try catch para tratarmos as excessões
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            //seleciona por id
            stmt.setInt(1, id);
            //e executa e salva no banco
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
