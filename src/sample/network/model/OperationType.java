package sample.network.model;

import java.io.Serializable;

public enum OperationType implements Serializable {
    LOGIN,
    REGISTER_USER;

    @Override
    public String toString() {
        return this.name();
    }
}