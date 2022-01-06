package ch.tom.tcodes.rulesverify.player;

public class PlayerAlreadyExists extends RuntimeException{

    public PlayerAlreadyExists(String message) {
        super(message);
    }
}
