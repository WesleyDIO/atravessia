import java.util.ArrayList;

public class Barco {

    private ArrayList<Personagem> personagensBarco = new ArrayList<>();
    private Margem ondeEsta;

    public Barco(Margem margem){
       this.ondeEsta = margem;
    }

     public void adicionaPersonagem(Personagem personagem){
            try {
                if (!(personagensBarco.size() >= 2)) {
                         personagensBarco.add(personagem);
                     }
                     throw new BarcoCheioException();
                 } catch (BarcoCheioException e) {
                     System.out.println(e.getMessage());
                 }
     }

     public void removerPersonagemDoBarco(Personagem personagem){
         personagensBarco.remove(personagem);
     }

     public Personagem buscarPersonagensBarco(int id){
        try {
            for (Personagem personagem : personagensBarco) {
                if (personagem.getId() == id) {
                    return personagem;
                }
            }
        }catch ( BuscarPersonagemException e){
            System.out.println(e.getMessage());
        }
        return null;
     }

     public void removerPersonagens(){
        personagensBarco.clear();
     }

    public Margem getOndeEsta() {
        return ondeEsta;
    }

    public Margem setOndeEsta(Margem ondeEsta) {
        this.ondeEsta = ondeEsta;
        return ondeEsta;
    }

    public ArrayList<Personagem> getPersonagensBarco() {
        return personagensBarco;
    }

}
