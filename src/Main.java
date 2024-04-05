import application.gateways.pessoa.PessoaGateway;
import application.usecases.pessoa.*;
import infrastructure.adapters.persistence.inmemory.gateways.pessoa.InMemoryPessoaGateway;

import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Starting application...");
        logger.info("Creating a new person");

        // POST - /api/pessoa
        PessoaGateway inMemoryPessoaGateway = new InMemoryPessoaGateway();

        CriarPessoaUseCase criarPessoaUseCase = new CriarPessoaUseCase(inMemoryPessoaGateway);
        CriarPessoaUseCase.Response response = criarPessoaUseCase.criar(new CriarPessoaUseCase.Request("John Doe"));

        // GET - /api/pessoa/{id}
        EncontrarPessoaUseCase encontrarPessoaUseCase = new EncontrarPessoaUseCase(inMemoryPessoaGateway);
        encontrarPessoaUseCase.encontrar(new EncontrarPessoaUseCase.Request(response.getPessoa().getId())).orElseThrow();

        // PUT - /api/pessoa/{id}
        SalvarPessoaUseCase salvarPessoaUseCase = new SalvarPessoaUseCase(inMemoryPessoaGateway);
        response.getPessoa().setName("Thiago Ausechi");
        salvarPessoaUseCase.salvar(new SalvarPessoaUseCase.Request(response.getPessoa()));

        // GET - /api/pessoas
        EncontrarTodosUseCase encontrarTodosUseCase = new EncontrarTodosUseCase(inMemoryPessoaGateway);
        encontrarTodosUseCase.encontrarTodos();

        // DELETE - /api/pessoa/{id}
        ApagarPessoaUseCase apagarPessoaUseCase = new ApagarPessoaUseCase(inMemoryPessoaGateway);
        apagarPessoaUseCase.apagar(new ApagarPessoaUseCase.Request(response.getPessoa().getId()));

        // GET - /api/pessoas
        encontrarTodosUseCase.encontrarTodos();

        // GET - /api/pessoa/{id}
        try {
            encontrarPessoaUseCase.encontrar(new EncontrarPessoaUseCase.Request(response.getPessoa().getId())).orElseThrow();
        } catch (Exception e) {
            logger.warning("Pessoa não encontrada - " + response.getPessoa().getId());
        }
    }
}
