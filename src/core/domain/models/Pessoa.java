package core.domain.models;

import java.util.UUID;

// Model
public class Pessoa {
    private String name;
    private final UUID id;

    public Pessoa(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Pessoa(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pessoa setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
