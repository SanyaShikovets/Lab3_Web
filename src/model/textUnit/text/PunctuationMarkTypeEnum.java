package model.textUnit.text;

/**
 * types of punctuation marks
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */
public enum PunctuationMarkTypeEnum {
    DOT("."),
    COMMA(","),
    EXCLAMATION("!"),
    QUESTION("?"),
    COLON(":"),
    SEMICOLON(";"),
    SINGLE_QUOTES("'"),
    QUOTES("\"");

    private final String text;

    PunctuationMarkTypeEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
