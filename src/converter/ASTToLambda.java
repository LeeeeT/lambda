package converter;

import java.util.HashMap;

public class ASTToLambda {
    HashMap<String, Integer> identifierToDepth = new HashMap<>();

    public lambda.Term convert(ast.Term term) {
        return convertTerm(term, 0);
    }

    private lambda.Term convertTerm(ast.Term term, int depth) {
        if (term instanceof ast.Application) {
            return convertApplication((ast.Application) term, depth);
        } else if (term instanceof ast.Abstraction) {
            return convertAbstraction((ast.Abstraction) term, depth);
        } else if (term instanceof ast.Identifier) {
            return convertIdentifier((ast.Identifier) term, depth);
        }
        return null;
    }

    private lambda.Application convertApplication(ast.Application application, int depth) {
        return new lambda.Application(convertTerm(application.body, depth), convertTerm(application.argument, depth));
    }

    private lambda.Abstraction convertAbstraction(ast.Abstraction abstraction, int depth) {
        Integer previousDepth = identifierToDepth.getOrDefault(abstraction.variable.name, null);
        identifierToDepth.put(abstraction.variable.name, depth);
        lambda.Abstraction lambdaAbstraction = new lambda.Abstraction(convertTerm(abstraction.body, depth + 1));
        if (previousDepth == null) {
            identifierToDepth.remove(abstraction.variable.name);
        } else {
            identifierToDepth.put(abstraction.variable.name, previousDepth);
        }
        return lambdaAbstraction;
    }

    private lambda.Index convertIdentifier(ast.Identifier identifier, int depth) {
        return new lambda.Index(depth - identifierToDepth.get(identifier.name) - 1);
    }
}
