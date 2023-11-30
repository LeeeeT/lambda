package cst;

public class Term {
    public Whitespaces whitespacesBefore;
    public StrippedTerm strippedTerm;
    public Whitespaces whitespacesAfter;

    public Term(Whitespaces whitespacesBefore, StrippedTerm strippedTerm, Whitespaces whitespacesAfter) {
        this.whitespacesBefore = whitespacesBefore;
        this.strippedTerm = strippedTerm;
        this.whitespacesAfter = whitespacesAfter;
    }

    public String toString() {
        return (whitespacesBefore == null ? "" : whitespacesBefore.toString()) + strippedTerm + (whitespacesAfter == null ? "" : whitespacesAfter.toString());
    }
}
