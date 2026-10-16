package DAO;

import model.Cliente;
import Utils.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    /**
     * Verifica se já existe um cliente cadastrado com o e-mail informado.
     */
    public boolean existeEmail(String email) throws SQLException {
        String sql = "SELECT id FROM clientes WHERE email = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se encontrar algum registro
            }
        }
    }

    /**
     * Insere um novo cliente no banco de dados.
     */
    public boolean cadastrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (email, senha_hash, celular, idade, sexo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getSenhaHash());
            stmt.setString(3, cliente.getCelular());
            stmt.setInt(4, cliente.getIdade());
            stmt.setString(5, cliente.getSexo());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        }
    }
}