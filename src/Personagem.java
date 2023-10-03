import java.util.ArrayList;
import java.util.List;

public class Personagem {
        private int id;
        static int idStatic=0;

    private static ArrayList<Personagem> personagens = new ArrayList<>();

    public Personagem (){
        this.id = idStatic;
        idStatic++;
    }



    public static ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Personagem{" +
                ", id=" + id +
                '}';
    }
}
