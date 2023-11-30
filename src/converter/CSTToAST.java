package converter;

public class CSTToAST {
    public static ast.Term convert(cst.Term term) {
        return convertTerm(term);
    }

    private static ast.Term convertTerm(cst.Term term) {
        return convertStrippedTerm(term.strippedTerm);
    }

    private static ast.Term convertStrippedTerm(cst.StrippedTerm term) {
        if (term instanceof cst.Application) {
            return convertApplication((cst.Application) term);
        } else if (term instanceof cst.Abstraction) {
            return convertAbstraction((cst.Abstraction) term);
        } else if (term instanceof cst.Identifier) {
            return convertIdentifier((cst.Identifier) term);
        }
        return null;
    }

    private static ast.Application convertApplication(cst.Application application) {
        return new ast.Application(convertTerm(application.body), convertTerm(application.argument));
    }

    private static ast.Abstraction convertAbstraction(cst.Abstraction abstraction) {
        return new ast.Abstraction(convertIdentifier(abstraction.variable), convertStrippedTerm(abstraction.body));
    }

    private static ast.Identifier convertIdentifier(cst.Identifier identifier) {
        StringBuilder name = new StringBuilder().append(identifier.head);
        while (identifier.tail != null) {
            identifier = identifier.tail;
            name.append(identifier.head);
        }
        return new ast.Identifier(name.toString());
    }
}
