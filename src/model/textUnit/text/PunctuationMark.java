package model.textUnit.text;

/**
 * punctuation mark
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */

public class PunctuationMark extends TextUnit {

    public static final String PUNCTUATION_MARK_NAME = "PUNCTUATION MARK";
    public static final String PATTERN = "([" + Sentence.DIVIDER + "]|[" + Word.DIVIDER + "])";
    private PunctuationMarkTypeEnum punctuationMarkType;


    /**
     * constructor
     * @param type type of punctuation mark
     *
     */
    public PunctuationMark(PunctuationMarkTypeEnum type) {
        super(type.toString() ,TextUnitTypeEnum.PUNCTUATION_MARK);
        punctuationMarkType = type;
    }

    @Override
    public String toString() {
        return punctuationMarkType.toString();
    }

}