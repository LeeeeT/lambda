package converter;

public class TextToLambda {
    public static lambda.Term convert(String text) {
        return new ASTToLambda().convert(CSTToAST.convert(new TextToCST(text).convert()));
    }
}
