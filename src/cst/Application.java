package cst;

public class Application implements StrippedTerm {
    public char leftBodyParenthesis;
    public Term body;
    public char rightBodyParenthesis;
    public Whitespaces whitespacesBetweenBodyAndArgument;
    public char leftArgumentParenthesis;
    public Term argument;
    public char rightArgumentParenthesis;

    public Application(char leftBodyParenthesis, Term body, char rightBodyParenthesis, Whitespaces whitespacesBetweenBodyAndArgument, char leftArgumentParenthesis, Term argument, char rightArgumentParenthesis) {
        this.leftBodyParenthesis = leftBodyParenthesis;
        this.body = body;
        this.rightBodyParenthesis = rightBodyParenthesis;
        this.whitespacesBetweenBodyAndArgument = whitespacesBetweenBodyAndArgument;
        this.leftArgumentParenthesis = leftArgumentParenthesis;
        this.argument = argument;
        this.rightArgumentParenthesis = rightArgumentParenthesis;
    }

    public String toString() {
        return String.valueOf(leftBodyParenthesis) + body + rightBodyParenthesis + (whitespacesBetweenBodyAndArgument == null ? "" : whitespacesBetweenBodyAndArgument.toString()) + leftArgumentParenthesis + argument + rightArgumentParenthesis;
    }
}