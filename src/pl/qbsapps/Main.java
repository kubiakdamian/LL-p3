package pl.qbsapps;

public class Main {

    public static void main(String[] args) {
        String expression = "(1.2*3)+5-(23.4+3)^3;8:13;";

        SyntaxChecker syntaxChecker = new SyntaxChecker(expression);

        if (syntaxChecker.checkExpression()) {
            System.out.println(expression + " is correct!");
        } else {
            System.out.println(expression + " is not correct!");
        }
    }
}
