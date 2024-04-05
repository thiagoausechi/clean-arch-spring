package infrastructure.adapters.persistence.inmemory.mappers.pessoa;

import core.domain.models.Pessoa;
import infrastructure.adapters.persistence.inmemory.entities.pessoa.InMemoryPessoaEntity;

import java.util.UUID;

public class InMemoryPessoaMapper {
    public static InMemoryPessoaEntity toEntity(Pessoa domain) {
        return new InMemoryPessoaEntity(domain.getId().toString(), domain.getName());
    }

    public static Pessoa toDomain(InMemoryPessoaEntity entity) {
        return new Pessoa(UUID.fromString(entity.getId()), entity.getName());
    }
}
