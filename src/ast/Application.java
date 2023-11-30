package ast;

public class Application implements Term {
    public Term body;
    public Term argument;

    public Application(Term body, Term argument) {
        this.body = body;
        this.argument = argument;
    }

    public String toString() {
        return "(" + body + ") (" + argument + ")";
    }
}