package application.usecases.pessoa;

import application.gateways.pessoa.PessoaGateway;
import core.domain.models.Pessoa;

public class SalvarPessoaUseCase {
    private final PessoaGateway pessoaGateway;

    public SalvarPessoaUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public void salvar(Request request) {
        this.pessoaGateway.salvar(request.getPessoaAtualizada());
    }

    public static class Request {
        private final Pessoa pessoaAtualizada;

        public Request(Pessoa pessoaAtualizada) {
            this.pessoaAtualizada = pessoaAtualizada;
        }

        public Pessoa getPessoaAtualizada() {
            return this.pessoaAtualizada;
        }
    }
}
