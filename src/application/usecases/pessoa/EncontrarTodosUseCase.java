package application.usecases.pessoa;

import application.gateways.pessoa.PessoaGateway;
import core.domain.models.Pessoa;

import java.util.List;

public class EncontrarTodosUseCase {
    private final PessoaGateway pessoaGateway;

    public EncontrarTodosUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public Response encontrarTodos() {
        return new Response(this.pessoaGateway.encontrarTodos());
    }

    public static class Response {
        private final List<Pessoa> pessoas;

        public Response(List<Pessoa> pessoas) {
            this.pessoas = pessoas;
        }

        public List<Pessoa> getPessoas() {
            return this.pessoas;
        }
    }
}
