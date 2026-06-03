import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireFormulaire {
    private static List<Formulaire> formulaires =  new ArrayList<>();



    public static List<Formulaire> getFormulaires() {
        return formulaires;
    }

    public static void setFormulaires(Formulaire formulaire) {
        formulaires.add(formulaire);
    }

    public static List<Formulaire> getFormulairesParEtudiant(String numApprenant) {
        List<Formulaire> form = null;
        for(int i = 0; i<Formulaire.getNbFormulaires(); i++){
            for(int y = 0; y<formulaires.get(i).getEtudiants().size(); y++){
                if (formulaires.get(i).getEtudiants().get(y).getNumeroApprenant().equals(numApprenant)){
                     form.add(formulaires.get(i));
                }
            }
        }
        return form;
    }

    public static List<Formulaire> getFormulairesParEpreuve(String codeECUE) {
        List<Formulaire> form = null;
        for(int i = 0; i<Formulaire.getNbFormulaires(); i++){
            if (formulaires.get(i).getEpreuve().getECUE().equals(codeECUE)){
                form.add(formulaires.get(i));
            }
        }
        return form;
    }

    public static List<Formulaire> getFormulairesParFraude(Type typeFraude) {
        List<Formulaire> form = null;
        for(int i = 0; i<Formulaire.getNbFormulaires(); i++){
            for(int y = 0; y<formulaires.get(i).getFraudes().size(); y++){
                if (formulaires.get(i).getFraudes().get(y).getType().equals(typeFraude)){
                    form.add(formulaires.get(i));
                }
            }
        }
        return form;
    }

    public static Formulaire getFormulairesParId(int id) {
        for (int i = 0; i < Formulaire.getNbFormulaires(); i++) {
            if (formulaires.get(i).getId() == id) {
                return formulaires.get(i);
            }
        }
        return null;
    }

    public static Formulaire suppressionFormulaire(int id) {
        for (int i = 0; i < Formulaire.getNbFormulaires(); i++) {
            Formulaire formulaire = formulaires.get(i);
            if (formulaire.getId() == id){
                formulaires.remove(i);
                Formulaire.setNbFormulaires(Formulaire.getNbFormulaires()-1);
            }
        }
        return null;
    }
}
