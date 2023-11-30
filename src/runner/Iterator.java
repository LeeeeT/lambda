package runner;

import lambda.Application;
import lambda.Term;

public class Iterator implements java.util.Iterator<Term> {
    public Term term;

    public Iterator(Term term) {
        this.term = term;
    }

    public boolean hasNext() {
        return term instanceof Application;
    }

    public Term next() {
        return term = ((Application) term).apply();
    }
}