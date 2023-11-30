package lambda;

public class Application implements Term {
    Term body;
    Term argument;

    public Application(Term body, Term argument) {
        this.body = body;
        this.argument = argument;
    }

    public boolean equals(Term other) {
        return other instanceof Application && body.equals(((Application) other).body) && argument.equals(((Application) other).argument);
    }

    public Term substitute(int depth, Term term) {
        return new Application(body.substitute(depth, term), argument.substitute(depth, term));
    }

    public Term apply(Term argument) {
        return new Application(apply(), argument);
    }

    public Term apply() {
        return body.apply(argument);
    }

    public String toString() {
        return "(" + body + ") (" + argument + ")";
    }
}