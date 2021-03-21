import java.util.Scanner;

public class Player extends AbstractPlayer {

    public Player(Deck deck){
        super(deck);
    }

    @Override
    public void turn(Deck deck) {
        checkBlackJack();
        while (!this.isHold()){
            Scanner scan = new Scanner(System.in);
            System.out.println("Press 1 for HIT, 2 for STAND (hold the value and end your turn):");
            int input = scan.nextInt();
            switch (input) {
                case 1 -> super.turn(deck);
                case 2 -> this.hold();
                default -> System.out.println("Invalid input. Press again!");
            }
            if (this.getPoint() == 21){
                this.hold();
                System.out.println("You got 21!");
                break;
            }
        }
    }
}
