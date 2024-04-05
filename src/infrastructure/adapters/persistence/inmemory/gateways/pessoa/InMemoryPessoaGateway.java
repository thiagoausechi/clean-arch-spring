package infrastructure.adapters.persistence.inmemory.gateways.pessoa;

import application.gateways.pessoa.PessoaGateway;
import core.domain.models.Pessoa;
import infrastructure.adapters.persistence.inmemory.entities.pessoa.InMemoryPessoaEntity;
import infrastructure.adapters.persistence.inmemory.mappers.pessoa.InMemoryPessoaMapper;

import java.util.*;
import java.util.logging.Logger;

public class InMemoryPessoaGateway implements PessoaGateway {
    static Logger logger = Logger.getLogger(InMemoryPessoaGateway.class.getName());
    public Map<String, InMemoryPessoaEntity> pessoasDB = new HashMap<String, InMemoryPessoaEntity>();

    @Override
    public Pessoa criar(Pessoa pessoa) {
        InMemoryPessoaEntity createdPessoa = InMemoryPessoaMapper.toEntity(pessoa);
        this.pessoasDB.put(createdPessoa.getId(), createdPessoa);

        logger.info("Pessoa criada: " + createdPessoa.getId() + " - " + createdPessoa.getName());
        return InMemoryPessoaMapper.toDomain(createdPessoa);
    }

    @Override
    public void salvar(Pessoa pessoa) {
        InMemoryPessoaEntity createdPessoa = InMemoryPessoaMapper.toEntity(pessoa);
        this.pessoasDB.put(createdPessoa.getId(), createdPessoa);

        logger.info("Pessoa salva: " + createdPessoa.getId() + " - " + createdPessoa.getName());
    }

    @Override
    public void apagar(UUID id) {
        this.pessoasDB.remove(id.toString());
        logger.warning("Pessoa deletada: " + id);
    }

    @Override
    public Optional<Pessoa> encontrar(UUID id) {
        InMemoryPessoaEntity createdPessoa = this.pessoasDB.get(id.toString());

        if (Objects.isNull(createdPessoa)) {
            logger.warning("Pessoa não encontrada: " + id);
            return Optional.empty();
        }

        logger.info("Pessoa encontrada: " + createdPessoa.getId() + " - " + createdPessoa.getName());
        return Optional.of(InMemoryPessoaMapper.toDomain(createdPessoa));
    }

    @Override
    public List<Pessoa> encontrarTodos() {
        logger.info("Pessoas encontradas: " + this.pessoasDB.size());
        this.pessoasDB.values().forEach(pessoa -> {
            logger.info(pessoa.getId() + " - " + pessoa.getName());
        });

        return List.of(
                this.pessoasDB.values()
                        .stream()
                        .map(InMemoryPessoaMapper::toDomain)
                        .toArray(Pessoa[]::new));
    }
}
