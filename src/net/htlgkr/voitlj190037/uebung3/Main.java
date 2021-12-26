package net.htlgkr.voitlj190037.uebung3;

public class Main {
    public static void main(String[] args) {
        NumberTest isEven = n -> (n % 2) == 0;
        NumberTest isPrime = n -> {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {   //sobald Zahl restlos durch eine andere Zahl (außer 1 und der Ausgangszahl) teilbar ist, ist es keine Primzahl
                    return false;
                }
            }
            return true;
        };
        NumberTest isPalindrome = n -> {
            String str = String.valueOf(n);
            char[] charStr = str.toCharArray();
            for (int i = 1; i == str.length() / 2; i++) {   //i = 1 weil Schleife 4 mal durchlaufen werden sollte wenn die Länge 8 beträgt um in der Mitte zu stoppen
                int j = str.length() - i;   //Länge 8 (Schleifendurchlauf 1): j = 7 und startet somit bei der letzten Stelle im array
                if (charStr[i - 1] != charStr[j]) {     //Länge 8 (Schleifendurchlauf 1): wenn char an Stelle 0 nicht mit char an Stelle 7 übereinstimmt, ist es kein Palindrom
                    return false;
                }
            }
            return true;
        };

        NumberTester nt = new NumberTester("numbers.csv");
        nt.setOddEvenTester(isEven);
        nt.setPrimeTester(isPrime);
        nt.setPalindromeTester(isPalindrome);
        nt.testFile();
    }
}
