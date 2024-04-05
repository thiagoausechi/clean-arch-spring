package application.usecases.pessoa;

import application.gateways.pessoa.PessoaGateway;
import core.domain.models.Pessoa;

public class CriarPessoaUseCase {
    private final PessoaGateway pessoaGateway;

    public CriarPessoaUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public Response criar(Request request) {
        Pessoa pessoa = new Pessoa(request.getName());
        Pessoa createdPessoa = this.pessoaGateway.criar(pessoa);

        return new Response(createdPessoa);
    }

    public static class Request {
        private final String name;

        public Request(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class Response {
        private final Pessoa pessoa;

        public Response(Pessoa pessoa) {
            this.pessoa = pessoa;
        }

        public Pessoa getPessoa() {
            return this.pessoa;
        }
    }
}
