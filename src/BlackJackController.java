import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackController implements ActionListener {
    private BlackJackModel model;
    private BlackJackView view;
    private boolean dealerNotFlipped;

    public BlackJackController() {
        model = new BlackJackModel();
        view = new BlackJackView();
        initController();
        initGame();
        view.setVisible(true);
    }

    /**
     * Register this class to be the listener of the buttons.
     */
    public void initController() {
        view.getHitButton().addActionListener(this);
        view.getStandButton().addActionListener(this);
        view.getRestartButton().addActionListener(this);
    }

    /**
     * Display the cards in the beginning, based on the game.
     * The second card of the dealer is hidden.
     */
    public void initGame() {
        view.addCardToPanel(model.getDealerHitCard(), view.getDealerPanel());
        view.addFaceDownCardToPanel(view.getDealerPanel());
        view.addCardToPanel(model.getPlayerHitCard(), view.getPlayerPanel());
        view.addCardToPanel(model.getPlayerHitCard(), view.getPlayerPanel());
        dealerNotFlipped = true;
    }


    /**
     * Starts a new game with a new view.
     */
    public void startAgain() {
        view.setVisible(false);
        view = new BlackJackView();
        model = new BlackJackModel();
        this.initController();
        this.initGame();
        view.setVisible(true);
    }

    public void displayGameOver() {
        if (model.isGameOver()) {
            if (model.tieGame()){
                view.setMessage("PUSH!");
            }

            else if (model.playerBust() || model.dealerBJ()){
                String m = (model.dealerBJ())? "Dealer got BLACKJACK" : "You BUST";
                view.setMessage(m + ", Dealer WIN!");
            }

            else if (model.dealerBust() || model.playerBJ()){
                String m = (model.playerBJ())?  "You got BLACKJACK" : "Dealer BUST";
                view.setMessage(m +  ", You WIN!");
            }

            else {
                view.setMessage(model.getWinner() + " WIN!");
            }


            // clean up buttons
            view.getRestartButton().setVisible(true);
            view.getStandButton().setVisible(false);
            view.getHitButton().setVisible(false);
        }
    }

    public void actionPerformed (ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.equals(view.getHitButton())) {
            view.addCardToPanel(model.getPlayerHitCard(), view.getPlayerPanel());
        }
        if (model.playerBust() || model.playerBJ() || button.equals(view.getStandButton())) {
            model.setPlayerStand();

            // display all dealer's cards
            view.removeFaceDownCard();
            view.addCardToPanel(model.getDealerHitCard(), view.getDealerPanel());
            view.setVisible(true);


            // dealer starts playing
            while (model.dealerCanHit()) {
                view.addCardToPanel(model.getDealerHitCard(), view.getDealerPanel());
            }
            model.setDealerStand();

        }
        if (button.equals(view.getRestartButton())) {
            startAgain();
        }

        displayGameOver();
        view.setVisible(true);
    }

    public static void main(String[] args) {
        BlackJackController c = new BlackJackController();
    }


}