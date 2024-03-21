package aula3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends BaseDAO{

    private final static String CRIAR_TABELA = """
            create table  IF NOT EXISTS pessoa(
                                 id INTEGER PRIMARY KEY
                                ,nome text);
            """;

    public void criarTabela(){
        try(var con = conexao();
            var stat = con.createStatement()){
            stat.execute(CRIAR_TABELA);
        }catch (SQLException e){
            System.out.println("Erro ao criar tabela.");
            e.printStackTrace();
        }
    }

    public void inserir(Pessoa p){
        String inserir = """
                    insert into pessoa(nome) values(?);
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(inserir)){
            stat.setString(1,p.getNome());
            stat.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tabela.");
            e.printStackTrace();
        }
    }

    public void atualizar(Pessoa p){
        String sql = """
                    update pessoa set nome = ? where id = ?;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.setString(1,p.getNome());
            stat.setLong(2,p.getId());
            stat.execute();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar pessoa.");
            e.printStackTrace();
        }
    }

    public void deletar(long id){
        String sql = """
                    drop table pessoa;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.execute();
        }catch (SQLException e){
            System.out.println("Erro ao excluir pessoa.");
            e.printStackTrace();
        }
    }

    public List<Pessoa> obterTodos(){
        List<Pessoa> lista = new ArrayList<>();
        String sql = """
                    select id, nome from pessoa;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            ResultSet rs = stat.executeQuery();
            // Navege para o proximo registro.
            while(rs.next()){
                Pessoa p = new Pessoa();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                lista.add(p);
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar todas as pessoas.");
            e.printStackTrace();
        }
        return lista;
    }

    public Pessoa obterPeloId(long id){
        Pessoa p = null;
        String sql = """
                    select id, nome from pessoa where id = ?;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.setLong(1,id);
            ResultSet rs = stat.executeQuery();
            // Navege para o proximo registro.
            if(rs.next()){
                p = new Pessoa();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar pessoa pelo id.");
            e.printStackTrace();
        }
        return p;
    }

}
