package aula3;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(0,"Tom cruise");
        Pessoa p2 = new Pessoa(0,"The Rocky");
        PessoaDAO pessoaDAO = new PessoaDAO();
//        pessoaDAO.deletar();
        // UUID
        pessoaDAO.criarTabela();
        //pessoaDAO.inserir(p1);
        //pessoaDAO.inserir(p2);
//        for(Pessoa p : pessoaDAO.obterTodos()){
//            System.out.println(p);
//        }
//        System.out.println("Consulta pelo id 1");
//        Pessoa id1 = pessoaDAO.obterPeloId(1);
//        System.out.println(id1);
//        System.out.println("Consulta pelo id 10");
//        Pessoa id10 = pessoaDAO.obterPeloId(10);
//        System.out.println(id10);
//        id1.setNome("Pedro Pascal");
//        pessoaDAO.atualizar(id1);
//        System.out.println("Consulta de todas as pessoas.");
//        for(Pessoa p : pessoaDAO.obterTodos()){
//            System.out.println(p);
//        }
    }
}