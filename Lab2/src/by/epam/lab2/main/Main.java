package by.epam.lab2.main;

import java.util.Objects;

public class Main {

    public static final String SEPARATORS_REGEX = " ";

    public static void main(String[] args) {
        String input = "aBcDdeFaBc abcdefg hijklmn aaaaaaahhhhhhhhh some string";

        System.out.println("1) even and odd symbols: " + getEvenCharactersAsString(input) + "\n" + getOddCharactersAsString(input));

        System.out.printf("2) percentage: %f%% \n",
                (double) getNumberLowercaseLetters(input) /
                        Objects.requireNonNullElse(getNumberUppercaseLetters(input), 1) * 100);

        System.out.println("3) delete duplicate symbols: " + getStringWithoutDuplicateCharacters(input));

        System.out.println("4) occurrences of a character in a string: " + countOccurrences(input, "a"));

        System.out.println("5) string reverse: " + getReversedString(input));

        System.out.println("6) insert substring: " + new StringBuilder(input).insert(3, "abcd"));

        System.out.println("7) delete substring: " + new StringBuilder(input).delete(3, 3 + "abcd".length()));

        System.out.println("8) copy part of string: " + input.substring(1, 4));

        System.out.println("9) string length: " + input.length());

        System.out.println("10) occurrences of a substring in a string: " + countOccurrences(input, "aBc"));

        System.out.println("11) words of a string in reverse order: " + String.join(", ", getStringWordsInReverseOrder(input)));

        System.out.println("12) replace whitespaces with *: " + replaceAllWhiteSpaces(input));

        System.out.println("13) replace a with b in longest word: " + getLongestWord(input).replace("a", "b"));

        System.out.println("14) get shortest word length: " + getShortestWord(input).length());

        System.out.println("15) words number in a string: " + getStringWordsInReverseOrder(input).length);

        System.out.println("16) swap words: " + swapWords(input, 1, 2));

        System.out.println("17) delete last word: " + deleteLastWord(input));

        System.out.println("18) add whitespaces to string: " + addWhiteSpaces(input));

        System.out.println("19) is palindrome: " + isPalindrome(input));

        System.out.println("20) replace substring in a string: " + new StringBuilder().replace(0, 5, "abcde"));

        System.out.println("21) add 12345678910111213141516 to 16151413121110987654321: " + add("12345678910111213141516", "16151413121110987654321"));

        System.out.println("22) delete words by given length: " + deleteWordsByLength(input, 4));

        System.out.println("23) delete redundant white spaces: " + deleteRedundantWhitespaces(input));

        System.out.println("24) get string words: " + String.join(", ", getWordsArray(input)));
    }

    public static String getEvenCharactersAsString(String input) {
        char[] chars = input.toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < chars.length; i += 2) {
            result.append(chars[i]);
        }

        return result.toString();
    }

    public static String getOddCharactersAsString(String input) {
        char[] chars = input.toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i += 2) {
            result.append(chars[i]);
        }

        return result.toString();
    }

    public static int getNumberLowercaseLetters(String input) {
        char[] chars = input.toCharArray();

        int number = 0;

        for (char character : chars) {
            if (Character.isLowerCase(character)) {
                number++;
            }
        }

        return number;
    }

    public static int getNumberUppercaseLetters(String input) {
        char[] chars = input.toCharArray();

        int number = 0;

        for (char character : chars) {
            if (Character.isUpperCase(character)) {
                number++;
            }
        }

        return number;
    }

    public static String getStringWithoutDuplicateCharacters(String input) {
        char[] chars = input.toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (input.indexOf(chars[i], i + 1) == -1) {
                result.append(chars[i]);
            }
        }

        return result.toString();
    }

    public static int countOccurrences(String input, String subString) {
        return input.length() -
                input.replaceAll(String.valueOf(subString), "").length();
    }

    public static String getReversedString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String[] getStringWordsInReverseOrder(String input) {
        String[] words = input.split(SEPARATORS_REGEX);

        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = temp;
        }

        return words;
    }

    public static String replaceAllWhiteSpaces(String input) {
        return input.replaceAll(" +", "*");
    }

    public static String getLongestWord(String input) {
        String[] words = input.split(SEPARATORS_REGEX);

        int longestWordIndex = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > words[longestWordIndex].length()) {
                longestWordIndex = i;
            }
        }

        return words[longestWordIndex];
    }

    public static String getShortestWord(String input) {
        String[] words = input.split(SEPARATORS_REGEX);

        int shortestWordIndex = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < words[shortestWordIndex].length()) {
                shortestWordIndex = i;
            }
        }

        return words[shortestWordIndex];
    }

    public static String swapWords(String input, int firstIndex, int secondIndex) {
        String[] words = input.split(SEPARATORS_REGEX);

        String temp = words[firstIndex];
        words[firstIndex] = words[secondIndex];
        words[secondIndex] = temp;

        return String.join(" ", words);
    }

    public static String deleteLastWord(String input) {
        return input.replaceAll(" [^ ]*$", "");
    }

    public static String addWhiteSpaces(String input) {
        return input.replaceAll(" ", "  ");
    }

    public static boolean isPalindrome(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }

    public static String add(String firstTerm, String secondTerm) {
        if (firstTerm.length() > secondTerm.length()) {
            StringBuilder secondTermBuilder = new StringBuilder(secondTerm);

            secondTermBuilder.insert(0, "0".repeat(firstTerm.length() - secondTermBuilder.length()));

            secondTerm = secondTermBuilder.toString();
        } else {
            StringBuilder firstTermBuilder = new StringBuilder(firstTerm);

            firstTermBuilder.insert(0, "0".repeat(firstTerm.length() - firstTermBuilder.length()));

            secondTerm = firstTermBuilder.toString();
        }

        StringBuilder result = new StringBuilder();

        int temp = 0;

        for (int i = secondTerm.length() - 1; i >= 0; i--) {
            int sum = Integer.parseInt(firstTerm.substring(i, i + 1))
                    + Integer.parseInt(secondTerm.substring(i, i + 1)) + temp;

            temp = sum / 10;

            result.append(sum % 10);
        }

        return result.reverse().toString();
    }

    public static String deleteWordsByLength(String input, int length) {
        String regex = String.format(" ?[^ ]{%d}( |$)", length);

        return input.replaceAll(regex,"");
    }

    public static String deleteRedundantWhitespaces(String input) {
        return input.replaceAll("(^ )|( $)", "").replaceAll(" {2}", " ");
    }

    public static String[] getWordsArray(String input) {
        return input.split(" ");
    }
}