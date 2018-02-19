package sample.network.model;

import java.io.Serializable;

public enum RequestCode implements Serializable {
    OK,
    ERROR,
    CONNECTION_ERROR;

    @Override
    public String toString() {
        return name();
    }
}