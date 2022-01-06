package ch.tom.tcodes.rulesverify.player;

public class Player {

    private String name;
    private String uuid;
    private boolean verified;

    public Player() {

    }

    public Player( String name, String uuid, boolean verified) {
        this.name = name;
        this.uuid = uuid;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", verified=" + verified +
                '}';
    }
}
