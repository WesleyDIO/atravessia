import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Jogo jogo  = new Jogo();

    public static void main(String[] args)  {
        criarPersonagens();

        boolean jogoTerminou;
        jogoTerminou = jogo.verificaJogo();
            do {
                int opcao;
                System.out.println("""
                        Escolha as opções do jogo
                        1 - Adicionar personagem
                        2 - Retirar Personagem
                        3 - Troca de lado
                        4 - Sair
                        """);
                opcao = sc.nextInt();
                jogo.imprime();
                switch (opcao){
                    case 1:
                        adicionarPersonagemNoBarco();
                        break;
                    case 2:
                        retirarPersonagemDoBarco();
                        break;
                    case 3:
                        try {
                            jogo.atravessar();
                        }catch (BarcoVazioException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção invalida");
                }
                jogo.imprime();
        }while (!jogoTerminou);
    }

    public static void adicionarPersonagemNoBarco(){
        System.out.println("Digite o id do personagem que deseja colocar no barco");
        int id = sc.nextInt();
        jogo.embarcarPersonagem(jogo.buscarPersonagemPorId(id));
    }

    public static void retirarPersonagemDoBarco(){
        System.out.println("Digite o id do personagem que deseja retira do barco");
        int id = sc.nextInt();
        jogo.desembacarPersonagem(jogo.barco.buscarPersonagensBarco(id));
    }

    public static void criarPersonagens(){
        Missionario missionario = new Missionario();
        Missionario missionario2 = new Missionario();
        Missionario missionario3 = new Missionario();
        Canibal canibal = new Canibal();
        Canibal canibal2 = new Canibal();
        Canibal canibal3 = new Canibal();
        Personagem.getPersonagens().add(missionario);
        Personagem.getPersonagens().add(missionario2);
        Personagem.getPersonagens().add(missionario3);
        Personagem.getPersonagens().add(canibal);
        Personagem.getPersonagens().add(canibal2);
        Personagem.getPersonagens().add(canibal3);

    }


}


