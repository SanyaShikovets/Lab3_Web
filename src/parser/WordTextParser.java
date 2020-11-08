package parser;

import exception.InvalidParsingException;
import model.textUnit.text.TextUnit;
import model.textUnit.text.PunctuationMark;
import model.textUnit.text.PunctuationMarkTypeEnum;
import model.textUnit.text.Sentence;
import model.textUnit.text.Word;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * word text splitter parser
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */
public class WordTextParser {

    /**
     * split text into words
     * @param textUnits some textUnits
     * @return parsed text units
     */
    public ArrayList<TextUnit> split(ArrayList<TextUnit> textUnits) throws InvalidParsingException {
        ArrayList<TextUnit> result = new ArrayList<>();
        for (TextUnit textUnit: textUnits) {
            if (textUnit.getClass() == Sentence.class){
                Matcher matcher = Pattern.compile("(" + Word.PATTERN + "|" +
                        PunctuationMark.PATTERN + ")").matcher(textUnit.getValue());
                Sentence sentence = new Sentence(textUnit.getValue());
                while (matcher.find()) {
                    if (Pattern.compile(PunctuationMark.PATTERN).matcher(matcher.group()).matches()) {
                        for (PunctuationMarkTypeEnum type:
                                PunctuationMarkTypeEnum.values()) {
                            if (type.toString().equals(matcher.group())) {
                                PunctuationMark punctuationMark = new PunctuationMark(type);
                                sentence.addPunctuationMark(punctuationMark);
                                break;
                            }
                        }
                    } else {
                        Word word = new Word(matcher.group());
                        sentence.addWord(word);
                    }
                }
                result.add(sentence);
            } else {
                result.add(textUnit);
            }
        }
        if (result.isEmpty())
            throw new InvalidParsingException("There is no words and punctuation marks");

        return result;
    }

    @Override
    public String toString() {
        return "Splitting into words";
    }
}
