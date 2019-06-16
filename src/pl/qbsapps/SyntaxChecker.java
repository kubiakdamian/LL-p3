package pl.qbsapps;

class SyntaxChecker {
    private static final String OPERATORS = "*:+-^";
    private static final String NUMBERS = "0123456789";

    private char[] dividedExpression;
    private int index = -1;

    SyntaxChecker(String expression) {
        dividedExpression = expression.toCharArray();
    }

    boolean checkExpression() {
        return checkS();
    }

    private boolean checkS() {
        return checkW() && checkChar(';') && checkZ() && index == dividedExpression.length - 1;
    }

    private boolean checkZ() {
        int currentIndex = index;

        if (checkW()) {
            return checkChar(';') && checkZ();
        } else {
            index = currentIndex;

            return true;
        }
    }

    private boolean checkW() {
        return checkP() && checkWPrim();
    }

    private boolean checkWPrim() {
        int currentIndex = index;

        if (checkO()) {
            return checkW();
        } else {
            index = currentIndex;

            return true;
        }
    }

    private boolean checkP() {
        int currentIndex = index;

        if (checkR()) {
            return true;
        } else {
            index = currentIndex;

            return checkChar('(') && checkW() && checkChar(')');
        }
    }

    private boolean checkR() {
        return checkL() && checkRPrim();
    }

    private boolean checkRPrim() {
        int currentIndex = index;

        if (checkChar('.')) {
            return checkL();
        } else {
            index = currentIndex;

            return true;
        }
    }

    private boolean checkL() {
        return checkC() && checkLPrim();
    }

    private boolean checkLPrim() {
        int currentIndex = index;

        if (checkL()) {
            return true;
        } else {
            index = currentIndex;

            return true;
        }
    }

    private boolean checkC() {
        index++;

        return index < dividedExpression.length && NUMBERS.indexOf(dividedExpression[index]) != -1;
    }

    private boolean checkO() {
        index++;

        return index < dividedExpression.length && OPERATORS.indexOf(dividedExpression[index]) != -1;
    }

    private boolean checkChar(char c) {
        index++;
        return index < dividedExpression.length && dividedExpression[index] == c;
    }
}
