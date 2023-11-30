package runner;

import lambda.Term;

public class Iterable implements java.lang.Iterable<Term> {
    public Term term;

    public Iterable(Term term) {
        this.term = term;
    }

    public Iterator iterator() {
        return new Iterator(term);
    }
}