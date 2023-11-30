package ast;

public class Identifier implements Term {
    public String name;

    public Identifier(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}