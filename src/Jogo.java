import java.util.List;

public class Jogo {

    public Margem inicio;
    public Margem fim;

    public Barco barco;

    public Jogo() {

        this.fim = new Margem();
        this.inicio = new Margem();
        inicio.setPersonagensMargem(Personagem.getPersonagens());
        this.barco = new Barco(inicio);
    }

    public boolean verificaJogo(){
        try {
            if (fim.getPersonagensMargem().size() == 6) {
                System.out.println("Fim de jogo, todos chegaram em segurança");
                return true;
            } else {
                inicio.verificaMargem();
                fim.verificaMargem();
            }
            throw new MaisCanibalException();
        }catch (MaisCanibalException e){
             e.getMessage();
             return false;
        }
    }

    public Personagem buscarPersonagemPorId(int id) {
        try {
            for (Personagem personagem : barco.getOndeEsta().getPersonagensMargem()) {
                if (personagem.getId() == id) {
                    return personagem;
                }
            }
        } catch (BuscarPersonagemException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public void atravessar() throws BarcoVazioException {
        if (barco.getPersonagensBarco().size() > 0) {
            Margem margem = barco.getOndeEsta().equals(inicio) ? fim : inicio;
            barco.setOndeEsta(margem);
            for (Personagem personagem : barco.getPersonagensBarco()) {
                margem.adicionarPersonagemMargem(personagem);

            }
            barco.removerPersonagens();
        } else {
            Margem margem = barco.setOndeEsta(fim);
            throw new BarcoVazioException();
        }
    }

    public void embarcarPersonagem(Personagem personagem) {
        barco.getOndeEsta().removerPersonagem(personagem);
        barco.adicionaPersonagem(personagem);

    }

    public void desembacarPersonagem(Personagem personagem) {
        barco.getOndeEsta().adicionarPersonagemMargem(personagem);
        barco.removerPersonagemDoBarco(personagem);
    }

    public void imprime() {
        try {
            System.out.println("Inicio" + "\n");
            for (Personagem personagem : inicio.getPersonagensMargem()) {
                try {
                    if (personagem instanceof Canibal) {
                        System.out.println(personagem.getId() + "C");
                    } else {
                        System.out.println(personagem.getId() + "M");
                    }
                }catch (NadaEncontradoException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Barco" + "\n");
            for (Personagem personagem : barco.getPersonagensBarco()) {
                try {
                    if (personagem instanceof Canibal) {
                        System.out.println(personagem.getId() + "C");
                    } else {
                        System.out.println(personagem.getId() + "M");
                    }
                }catch (NadaEncontradoException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Fim" + "\n");

            for (Personagem personagem : fim.getPersonagensMargem()) {
                try {
                    if (personagem instanceof Canibal) {
                        System.out.println(personagem.getId() + "C");
                    } else {
                        System.out.println(personagem.getId() + "M");
                    }
                }catch (NadaEncontradoException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (NadaEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }
}

