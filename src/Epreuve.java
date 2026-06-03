import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Epreuve {
    public static List<Epreuve> toutesLesEpreuves = new ArrayList<>();
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

    public static List<Epreuve> getEpreuves() {
        return toutesLesEpreuves;
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


    public static List<Epreuve> rechercherNumeroEpreuve(String numero) {
        List<Epreuve> resultats = new ArrayList<>();
        for (int i = 0; i < toutesLesEpreuves.size(); i++) {
            if (toutesLesEpreuves.get(i).getECUE().equalsIgnoreCase(numero)) {
                resultats.add(toutesLesEpreuves.get(i));
            }
        }
        return resultats;
    }

    @Override
    public String toString() {
        return
                "ECUE='" + ECUE + '\'' +
                ", dateHeurePassage=" + dateHeurePassage +
                ", duree=" + duree +
                ", modalite=" + modalite ;
    }
}
