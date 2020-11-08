package model.textUnit.text;

/**
 * Paragraph
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */
public class Paragraph extends TextUnit {

    public static final String PARAGRAPH_NAME = "PARAGRAPH";
    public static final String DIVIDER = "\n";
    public static final String DIVIDER_PATTERN = DIVIDER;

    /**
     * constructor
     * @param text text value
     *
     */
    public Paragraph(String text) {
        super(text, TextUnitTypeEnum.PARAGRAPH);
    }

    @Override
    public String toString() {
        return "\n";
    }

}