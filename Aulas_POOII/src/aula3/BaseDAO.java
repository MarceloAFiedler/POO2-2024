package aula3;

import java.sql.Connection;

public class BaseDAO {


    protected Connection conexao(){
        return FabricaDeConexoes.obterInstancia().conexao();
    }
}
