package Services;

import DAO.ClienteDAO;
import model.Cliente;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {

    private final ClienteDAO clienteDAO;

    public AuthService() {
        this.clienteDAO = new ClienteDAO();
    }

    /**
     * Registra um novo cliente aplicando as regras de negócio e hashing de senha.
     */
    public boolean registrarConta(String email, String senhaPura, String celular, int idade, String sexo) throws Exception {

        // 1. Validação simples dos dados recebidos
        if (email == null || email.isBlank() || senhaPura == null || senhaPura.length() < 6) {
            throw new IllegalArgumentException("E-mail e senha inválidos. A senha deve ter pelo menos 6 caracteres.");
        }

        // 2. Regra de Negócio: Impedir e-mails duplicados
        if (clienteDAO.existeEmail(email)) {
            throw new IllegalArgumentException("O e-mail informado já está cadastrado.");
        }

        // 3. Segurança: Gerar o Hash seguro da senha usando BCrypt (nunca salvar texto puro)
        String senhaHash = BCrypt.hashpw(senhaPura, BCrypt.gensalt(12));

        // 4. Instanciar o modelo com os dados tratados
        Cliente novoCliente = new Cliente(email, senhaHash, celular, idade, sexo);

        // 5. Persistir no MySQL
        return clienteDAO.cadastrarCliente(novoCliente);
    }
}