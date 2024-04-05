package application.gateways.pessoa;

import core.domain.models.Pessoa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PessoaGateway {
    Pessoa criar(Pessoa pessoa);

    void salvar(Pessoa pessoaAtualizada);

    void apagar(UUID id);

    Optional<Pessoa> encontrar(UUID id);

    List<Pessoa> encontrarTodos();
}
