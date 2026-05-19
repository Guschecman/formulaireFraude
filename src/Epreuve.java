import java.time.LocalDate;

public class Epreuve {
    private String ECUE;
    private LocalDate dateHeurePassage;
    private int duree;
    private Modalite modalite;

    public Epreuve(String ECUE, LocalDate dateHeurePassage, int duree, Modalite modalite) {
        this.ECUE = ECUE;
        this.dateHeurePassage = dateHeurePassage;
        this.duree = duree;
        this.modalite = modalite;
    }

    public Modalite getModalite() {
        return modalite;
    }

    public void setModalite(Modalite modalite) {
        this.modalite = modalite;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public LocalDate getDateHeurePassage() {
        return dateHeurePassage;
    }

    public void setDateHeurePassage(LocalDate dateHeurePassage) {
        this.dateHeurePassage = dateHeurePassage;
    }

    public String getECUE() {
        return ECUE;
    }

    public void setECUE(String ECUE) {
        this.ECUE = ECUE;
    }
}
