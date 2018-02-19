package sample.config;


import sample.network.model.model.Player;

public class MainConfig {
    private static Player player;

    public static void reset() {
        player = null;
    }

    public static Player getUser() {
        return player;
    }

    public static void setUser(Player user) {
        MainConfig.player = user;
    }

}
