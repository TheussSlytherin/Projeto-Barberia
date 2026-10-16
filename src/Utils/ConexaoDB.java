package Utils; // Ou pacote dao

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    // Configurações de conexão com o MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/barbearia_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root"; // Altere para o seu usuário do MySQL
    private static final String SENHA = "sua_senha";  // Altere para a sua senha do MySQL

    /**
     * Método responsável por abrir e retornar uma nova conexão com o MySQL.
     * @return Connection objeto de conexão JDBC
     * @throws SQLException caso ocorra erro na autenticação ou servidor indisponível
     */
    public static Connection getConexao() throws SQLException {
        try {
            // Garante que o driver JDBC do MySQL esteja carregado na memória
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC do MySQL não foi encontrado nas dependências do projeto.", e);
        }
    }

    /**
     * Método utilitário para fechar a conexão de forma segura.
     * @param conexao objeto Connection a ser fechado
     */
    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}