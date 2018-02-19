package sample.network.model.model;


import java.io.Serializable;

public class Player implements Serializable {
    private Long id;
    private String username;
    private String firstName;
    private String secondName;
    private String password;
    private Color color;

    public Player() {
    }

    public Player(Long id, String username, String firstName, String secondName, String password, String color) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        if(color.equalsIgnoreCase("white")) this.color = Color.WHITE;
        else                                                this.color = Color.BLACK;
    }

    public Player(Long id, String username, String firstName, String secondName, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}