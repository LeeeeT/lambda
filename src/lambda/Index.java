package lambda;

public class Index implements Term {
    int index;

    public Index(int index) {
        this.index = index;
    }

    public boolean equals(Term other) {
        return other instanceof Index && index == ((Index) other).index;
    }

    public Term substitute(int depth, Term term) {
        return index == depth ? term : this;
    }

    public Term apply(Term argument) {
        return new Application(this, argument);
    }

    public String toString() {
        return Integer.toString(index);
    }
}