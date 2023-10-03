import java.util.ArrayList;
import java.util.List;

public class Margem {

    private ArrayList<Personagem> personagensMargem = new ArrayList<>();
    private int quantCanibal;
    private int quantMissionario;

    public boolean verificaMargem() throws MaisCanibalException{
        quantCanibal = 0;
        quantMissionario = 0;
        for (Personagem personagem: personagensMargem) {
            if (personagem instanceof Canibal){
                quantCanibal ++;
            }else{
                quantMissionario ++;
            }
        }
        if (quantCanibal != 0) {
            if (quantCanibal >= quantMissionario) {
                return true;
            } else {
                throw new MaisCanibalException();
            }
        }
        return false;

    }

    public void removerPersonagem(Personagem personagem){
        personagensMargem.remove(personagem);
    }

    public void adicionarPersonagemMargem(Personagem personagem){
        personagensMargem.add(personagem);
    }



    public ArrayList<Personagem> getPersonagensMargem() {
        return personagensMargem;
    }

    public ArrayList<Personagem> setPersonagensMargem(ArrayList personagens){
        return personagensMargem = personagens;
    }


}
