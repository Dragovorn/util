package com.dragovorn.util.lang;

public class GrammarMatcher {

    private String[] code;

    public GrammarMatcher(String code) {
        this.code = code.split(" ");
    }

    // TODO required/optional notation, int, long, and double notation, free form notation (only at end of code)
    public boolean matches(String matches) {
        String[] match = matches.split(" ");

        for (int x = 0; x < this.code.length && x < match.length; x++) {

            if (this.code[x].equalsIgnoreCase("*")) {
                continue;
            }

            if (this.code[x].startsWith("?i") && this.code[x].substring(2).equalsIgnoreCase(match[x])) {
                continue;
            }

            if (this.code[x].equals(match[x])) {
                continue;
            }

            return false;
        }

        return true;
    }
}