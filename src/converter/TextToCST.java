package converter;

public class TextToCST {
    String text;
    int position = 0;

    public TextToCST(String text) {
        this.text = text;
    }

    public cst.Term convert() {
        return parseTerm();
    }

    private cst.Term parseTerm() {
        int lastPosition = position;
        cst.Whitespaces whitespacesBefore = parseWhitespaces();
        cst.StrippedTerm strippedTerm = parseStrippedTerm();
        if (strippedTerm == null) {
            position = lastPosition;
            return null;
        }
        cst.Whitespaces whitespacesAfter = parseWhitespaces();
        return new cst.Term(whitespacesBefore, strippedTerm, whitespacesAfter);
    }

    private cst.StrippedTerm parseStrippedTerm() {
        int lastPosition = position;
        cst.Application application = parseApplication();
        if (application != null) {
            return application;
        }
        cst.Abstraction abstraction = parseAbstraction();
        if (abstraction != null) {
            return abstraction;
        }
        cst.StrippedTerm term = parseIdentifier();
        if (term != null) {
            return term;
        }
        position = lastPosition;
        return null;
    }

    private cst.Identifier parseIdentifier() {
        int lastPosition = position;
        char head = consume();
        if (!Character.isLetterOrDigit(head) && head != '_' && head != '-') {
            position = lastPosition;
            return null;
        }
        return new cst.Identifier(head, parseIdentifier());
    }

    private cst.Abstraction parseAbstraction() {
        int lastPosition = position;
        cst.Identifier variable = parseIdentifier();
        if (variable == null) {
            position = lastPosition;
            return null;
        }
        cst.Whitespaces whitespacesBetweenVariableAndArrow = parseWhitespaces();
        String arrow = parseArrow();
        if (arrow == null) {
            position = lastPosition;
            return null;
        }
        cst.Whitespaces whitespacesBetweenArrowAndBody = parseWhitespaces();
        cst.StrippedTerm body = parseStrippedTerm();
        if (body == null) {
            position = lastPosition;
            return null;
        }
        return new cst.Abstraction(variable, whitespacesBetweenVariableAndArrow, arrow, whitespacesBetweenArrowAndBody, body);
    }

    private String parseArrow() {
        int lastPosition = position;
        char equal = consume();
        if (equal != '=') {
            position = lastPosition;
            return null;
        }
        char greater = consume();
        if (greater != '>') {
            position = lastPosition;
            return null;
        }
        return String.valueOf(equal) + greater;
    }

    private cst.Application parseApplication() {
        int lastPosition = position;
        char leftBodyParenthesis = consume();
        if (leftBodyParenthesis != '(') {
            position = lastPosition;
            return null;
        }
        cst.Term body = parseTerm();
        if (body == null) {
            position = lastPosition;
            return null;
        }
        char rightBodyParenthesis = consume();
        if (rightBodyParenthesis != ')') {
            position = lastPosition;
            return null;
        }
        cst.Whitespaces whitespacesBetweenBodyAndArgument = parseWhitespaces();
        char leftArgumentParenthesis = consume();
        if (leftArgumentParenthesis != '(') {
            position = lastPosition;
            return null;
        }
        cst.Term argument = parseTerm();
        if (argument == null) {
            position = lastPosition;
            return null;
        }
        char rightArgumentParenthesis = consume();
        if (rightArgumentParenthesis != ')') {
            position = lastPosition;
            return null;
        }
        return new cst.Application(leftBodyParenthesis, body, rightBodyParenthesis, whitespacesBetweenBodyAndArgument, leftArgumentParenthesis, argument, rightArgumentParenthesis);
    }

    private cst.Whitespaces parseWhitespaces() {
        int lastPosition = position;
        char head = consume();
        if (!Character.isWhitespace(head) && head != '\n') {
            position = lastPosition;
            return null;
        }
        return new cst.Whitespaces(head, parseWhitespaces());
    }

    private char consume() {
        if (position >= text.length()) {
            return '\0';
        }
        return text.charAt(position++);
    }
}
