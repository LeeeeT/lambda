package ast;

public class Abstraction implements Term {
    public Identifier variable;
    public Term body;

    public Abstraction(Identifier variable, Term body) {
        this.variable = variable;
        this.body = body;
    }

    public String toString() {
        return variable + " => " + body;
    }
}