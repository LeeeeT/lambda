package lambda;

public class Abstraction implements Term {
    Term body;

    public Abstraction(Term body) {
        this.body = body;
    }

    public boolean equals(Term other) {
        return other instanceof Abstraction && body.equals(((Abstraction) other).body);
    }

    public Term substitute(int depth, Term term) {
        return new Abstraction(body.substitute(depth + 1, term));
    }

    public Term apply(Term argument) {
        return body.substitute(0, argument);
    }

    public String toString() {
        return "λ " + body;
    }
}