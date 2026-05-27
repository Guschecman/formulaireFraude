import java.time.LocalDate;

public abstract class Fraude {
    private LocalDate dateReleve;
    private String description;
    private String contenu;
    private Type type;

    public Fraude(LocalDate dateReleve, String description, String contenu, Type type) {
        this.dateReleve = dateReleve;
        this.description = description;
        this.contenu = contenu;
        this.type = type;
    }

    public LocalDate getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(LocalDate dateReleve) {
        this.dateReleve = dateReleve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
