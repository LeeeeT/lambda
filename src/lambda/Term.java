package lambda;

public interface Term {
    boolean equals(Term other);

    Term substitute(int depth, Term term);

    Term apply(Term argument);
}