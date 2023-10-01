// 


public class Main {
    public static void main(String[] args) {
        ToyList toys1 = new ToyList();
        toys1.addToy(new Toy(25,"Кукла Барби",3));
        toys1.addToyList(List.of(
                new Toy(5,"Самокат",1),
                new Toy(10,"Пазлы",2),
                new Toy(10,"Юла",2)
        ));
        System.out.println(toys1);
        ParticipantQueue pq = new ParticipantQueue(List.of(
                new Participant("Юра"),
                new Participant("Вениамин"),
                new Participant("Света"),
                new Participant("Таня"),
                new Participant("Женя"),
                new Participant("Петя"),
                new Participant("Вадим"),
                new Participant("Даниил"),
                new Participant("Катя"),
                new Participant("Кристина")
        ));
        Raffle raf = new Raffle(pq,toys1);
        System.out.println(raf.currentToys.toString());
        raf.runRaffle();

        System.out.println("\nРозыгрыш с вероятностью проиграть\n");
        ParticipantQueue pqloss = new ParticipantQueue();
        for (int i = 1; i <= 10 ; i++){
            pqloss.addParticipant(new Participant());
        }
        Raffle raf2 = new Raffle(pqloss,toys1);
        raf2.setLossWeight(30);
        System.out.println(raf2.currentToys.toString());
        raf2.runRaffle();
        toys1.saveToFile();
    }
}