package application.usecases.pessoa;

import application.gateways.pessoa.PessoaGateway;

import java.util.UUID;

public class ApagarPessoaUseCase {
    private final PessoaGateway pessoaGateway;

    public ApagarPessoaUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public void apagar(Request request) {
        this.pessoaGateway.apagar(request.getId());
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
}
