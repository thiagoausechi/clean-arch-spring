package application.usecases.pessoa;

import application.gateways.pessoa.PessoaGateway;
import core.domain.models.Pessoa;

import java.util.Optional;
import java.util.UUID;

public class EncontrarPessoaUseCase {
    private final PessoaGateway pessoaGateway;

    public EncontrarPessoaUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public Optional<Response> encontrar(Request request) {
        Optional<Pessoa> pessoaEncontrada = this.pessoaGateway.encontrar(request.getId());

        return pessoaEncontrada.map(Response::new);
    }

    public static class Request {
        private final UUID id;

        public Request(UUID id) {
            this.id = id;
        }

        public UUID getId() {
            return this.id;
        }
    }

    public static class Response {
        private final Pessoa pessoaEncontrada;

        public Response(Pessoa pessoaEncontrada) {
            this.pessoaEncontrada = pessoaEncontrada;
        }

        public Pessoa getPessoa() {
            return this.pessoaEncontrada;
        }
    }
}
