package net.htlgkr.voitlj190037.uebung2;

import java.util.Arrays;
import java.util.List;

public class HalloJavaMitForEach {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("IntelliJ", "Davinci Resolve", "OBS");
        for (String s : strings) {
            System.out.println(s);
        }
        strings.forEach(System.out::println);

    }
}
