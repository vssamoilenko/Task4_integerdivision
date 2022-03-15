package com.foxminded.integerdivision;

public class Division {

    int IndexOfDevidend = 0;

    public void divide(int devidend, int devider) {
        char[] devidentChar = Integer.toString(devidend).toCharArray();
        int IndexEnd = Integer.toString(devidend).length();
        String subtrahendPartOfDevidend = String.valueOf(devidentChar[IndexOfDevidend]);
        subtrahendPartOfDevidend = calculateNumberOfChar(devidentChar, devider, subtrahendPartOfDevidend);
        int numberForResult = Integer.parseInt(subtrahendPartOfDevidend) / devider;
        int minuend = numberForResult * devider;
        int residual = Integer.parseInt(subtrahendPartOfDevidend) - minuend;
        printFirstLine(devidend, devider);
        printSecondtLine(devidend, devider, minuend);
        printThirdLine(devidend, devider, minuend);
        printNextLInes(devidentChar, devider, residual, IndexEnd);
    }

    private void printNextLInes(char[] devidentChar, int devider, int residual, int IndexEnd) {
        String subtrahendPartOfDevidend = calculateNumberOfChar(devidentChar, devider, Integer.toString(residual));
        int numberForResult = Integer.parseInt(subtrahendPartOfDevidend) / devider;
        int minuend = numberForResult * devider;
        residual = Integer.parseInt(subtrahendPartOfDevidend) - minuend;
        int devidendLength = devidentChar.length;
        printNextLines(devidendLength, minuend, subtrahendPartOfDevidend);
        if (IndexOfDevidend  != IndexEnd-1) {
            printNextLInes(devidentChar, devider, residual, IndexEnd);
        }
        else{
            printEndLine(devidendLength, residual);
        }
    }
    private void printEndLine(int devidendLength, int residual){
        StringBuffer lineForPrint = new StringBuffer(fill(devidendLength + 1, " "));
        int residuaPosition = IndexOfDevidend + 2 - String.valueOf(residual).length();
        int residuaLength = String.valueOf(residual).length();
        lineForPrint.replace(residuaPosition, residuaPosition + residuaLength, Integer.toString(residual));
        System.out.println(lineForPrint);
    }
    private void printNextLines(int devidendLength, int minuend, String subtrahendPartOfDevidend) {
        StringBuffer lineForPrint = new StringBuffer(fill(devidendLength + 1, " "));
        int subtrahendPartOfDevidendPosition = IndexOfDevidend + 2 - String.valueOf(subtrahendPartOfDevidend).length();
        int subtrahendPartOfDevidendLength = String.valueOf(subtrahendPartOfDevidend).length();
        lineForPrint.replace(subtrahendPartOfDevidendPosition - 1, subtrahendPartOfDevidendPosition + subtrahendPartOfDevidendLength - 1, "_" + subtrahendPartOfDevidend);
        System.out.println(lineForPrint);
        lineForPrint = new StringBuffer(fill(devidendLength + 1, " "));
        int minuendPosition = IndexOfDevidend + 2 - String.valueOf(minuend).length();
        int minuendLength = String.valueOf(minuend).length();
        lineForPrint.replace(minuendPosition, minuendPosition + minuendLength, Integer.toString(minuend));
        System.out.println(lineForPrint);
        lineForPrint.replace(minuendPosition, minuendPosition + minuendLength, fill(minuendLength, "-"));
        System.out.println(lineForPrint);

    }

    private void printThirdLine(int devidend, int devider, int minuend) {
        int result = devidend / devider;
        int lineForPrintLength = String.valueOf("_" + devidend + "|" + result).length();
        StringBuffer lineForPrint = new StringBuffer(fill(lineForPrintLength, " "));
        int minuendPosition = IndexOfDevidend + 2 - String.valueOf(minuend).length();
        int minuendLength = String.valueOf(minuend).length();
        int verticalBarPosition = String.valueOf(devidend).length() + 1;
        lineForPrint.replace(minuendPosition, minuendPosition + minuendLength, fill(minuendLength, "-"));
        lineForPrint.replace(verticalBarPosition, verticalBarPosition + 2, "|");
        lineForPrint.replace(verticalBarPosition + 1, verticalBarPosition + 1 + Integer.toString(result).length(), Integer.toString(result));
        System.out.println(lineForPrint);

    }

    private void printSecondtLine(int devidend, int devider, int minuend) {
        int result = devidend / devider;
        int lineForPrintLength = String.valueOf("_" + devidend + "|" + result).length();
        StringBuffer lineForPrint = new StringBuffer(fill(lineForPrintLength, " "));
        int minuendPosition = IndexOfDevidend + 2 - String.valueOf(minuend).length();
        int minuendLength = String.valueOf(minuend).length();
        lineForPrint.replace(minuendPosition, minuendPosition + minuendLength, Integer.toString(minuend));
        int verticalBarPosition = String.valueOf(devidend).length() + 1;
        lineForPrint.replace(verticalBarPosition, verticalBarPosition + 2, "|");
        int fillPosition = String.valueOf(devidend).length() + 2;
        lineForPrint.replace(fillPosition, fillPosition + Integer.toString(result).length(), fill(Integer.toString(result).length(), "-"));
        System.out.println(lineForPrint);

    }

    private void printFirstLine(int devidend, int devider) {
        System.out.println("_" + devidend + "|" + devider);
    }

    private String calculateNumberOfChar(char[] devidentChar, int devider, String subtrahendPartOfDevidend) {

        subtrahendPartOfDevidend = getNumbersEnough(devidentChar, subtrahendPartOfDevidend, devider);
        return subtrahendPartOfDevidend;

    }

    private String getNumbersEnough(char[] devidentChar, String subtrahendPartOfDevidend, int devider) {
        while (isNumbersEnough(subtrahendPartOfDevidend, devider)) {
            IndexOfDevidend++;
            subtrahendPartOfDevidend = subtrahendPartOfDevidend + String.valueOf(devidentChar[IndexOfDevidend]);
        }
        return subtrahendPartOfDevidend;
    }

    private boolean isNumbersEnough(String subtrahendPartOfDevidend, int devider) {
        return (Integer.parseInt(subtrahendPartOfDevidend) / devider == 0);
    }

    private String fill(int length, String with) {
        StringBuffer sb = new StringBuffer(length);
        while (sb.length() < length) {
            sb.append(with);
        }
        return sb.toString();
    }

}
