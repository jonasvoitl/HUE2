package net.htlgkr.voitlj190037.uebung3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private final String FILENAME;

    public NumberTester(String fileName) {
        this.FILENAME = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        try (final BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line = br.readLine();
            int lines = Integer.parseInt(line);
            for (int i = 0; i < lines; i++) {
                line = br.readLine();
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "1":
                        System.out.println((oddTester.testNumber(Integer.parseInt(parts[1]))) ? "EVEN" : "ODD");
                        break;
                    case "2":
                        System.out.println((primeTester.testNumber(Integer.parseInt(parts[1]))) ? "PRIME" : "NO PRIME");
                        break;
                    case "3":
                        System.out.println((palindromeTester.testNumber(Integer.parseInt(parts[1]))) ? "PALINDROME" : "NO PALINDROME");
                        break;
                    default:
                        System.out.println("ERROR");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
