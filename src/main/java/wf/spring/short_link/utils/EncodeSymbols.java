package wf.spring.short_link.utils;

import lombok.Getter;

public enum EncodeSymbols {

    DIGITS("0123456789"),
    LOWER_LETTERS("abcdefghijklmnopqrstuvwxyz"),
    UPPER_LETTERS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    SPECIAL_SYMBOLS(".<>!()~-_\""),

    RADIX_10(DIGITS.getSymbols()),
    RADIX_36(RADIX_10.getSymbols() + LOWER_LETTERS.getSymbols()),
    RADIX_62(RADIX_36.getSymbols() + UPPER_LETTERS.getSymbols()),
    RADIX_72(RADIX_62.getSymbols() + SPECIAL_SYMBOLS.getSymbols());

    @Getter
    private final String symbols;

    EncodeSymbols(String symbols) {
        this.symbols = symbols;
    }



    public String encode(long l) {
        return encode(l, this);
    }

    public String decode(String s) {
        return decode(s, this);
    }


    public static String encode(long l, EncodeSymbols encodeSymbols) {
        String symbols = encodeSymbols.getSymbols();

        StringBuilder sb = new StringBuilder();
        while (l > 0) {
            sb.append(symbols.charAt((int) (l % symbols.length())));
            l /= symbols.length();
        }
        return sb.reverse().toString();
    }

    public static String decode(String s, EncodeSymbols encodeSymbols) {
        String symbols = encodeSymbols.getSymbols();

        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = symbols.indexOf(c);
            result = result * symbols.length() + digit;
        }
        return String.valueOf(result);
    }

}
