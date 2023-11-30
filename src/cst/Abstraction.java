package cst;

public class Abstraction implements StrippedTerm {
    public Identifier variable;
    public Whitespaces whitespacesBetweenVariableAndArrow;
    public String arrow;
    public Whitespaces whitespacesBetweenArrowAndBody;
    public StrippedTerm body;

    public Abstraction(Identifier variable, Whitespaces whitespacesBetweenVariableAndArrow, String arrow, Whitespaces whitespacesBetweenArrowAndBody, StrippedTerm body) {
        this.variable = variable;
        this.whitespacesBetweenVariableAndArrow = whitespacesBetweenVariableAndArrow;
        this.arrow = arrow;
        this.whitespacesBetweenArrowAndBody = whitespacesBetweenArrowAndBody;
        this.body = body;
    }

    public String toString() {
        return variable + (whitespacesBetweenVariableAndArrow == null ? "" : whitespacesBetweenVariableAndArrow.toString()) + arrow + (whitespacesBetweenArrowAndBody == null ? "" : whitespacesBetweenArrowAndBody.toString()) + body;
    }
}
