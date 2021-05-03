package pt.ipp.isep.dei.examples.tdd.basic.parser;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public String parse(String input) {
        Stream<Character> stream = getIconsOf(input);
        return getConcatenatedStringOf(stream);
    }

    private Stream<Character> getIconsOf(String input) {
        return input.chars()
                .mapToObj(i -> (char) i)
                .map(this::getIconOfSingle);
    }

    private Character getIconOfSingle(char character) {
        String input = String.valueOf(character);

        if (input.equalsIgnoreCase("F"))
            return '>';
        if (input.equalsIgnoreCase("R"))
            return 'o';
        if (input.equalsIgnoreCase("P"))
            return 'x';

        throw new IllegalArgumentException("Wrong values provided");
    }

    private String getConcatenatedStringOf(Stream<Character> stream) {
        return stream
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
