package model;

import java.time.LocalDateTime;

public class Cliente {

    // Atributos privados da classe Cliente
    private int id;
    private String email;
    private String senhaHash; // Espaço para guardar o hash do BCrypt
    private String celular;
    private int idade;
    private String sexo;
    private LocalDateTime dataCadastro;

    // Construtor vazio
    public Cliente() {}

    // Construtor completo para novos cadastros
    public Cliente(String email, String senhaHash, String celular, int idade, String sexo) {
        this.email = email;
        this.senhaHash = senhaHash;
        this.celular = celular;
        this.idade = idade;
        this.sexo = sexo;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
}