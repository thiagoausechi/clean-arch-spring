package infrastructure.adapters.persistence.inmemory.entities.pessoa;

public class InMemoryPessoaEntity {
    // @Column(name = "id")
    private final String id;
    // @Column(name = "name")
    private String name;

    public InMemoryPessoaEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
