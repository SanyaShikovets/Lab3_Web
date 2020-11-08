package model;

import model.textUnit.text.TextUnit;
import model.textUnit.text.TextUnitTypeEnum;
import model.textUnit.code.CodeBlock;
import model.textUnit.text.Paragraph;
import model.textUnit.text.Word;
import model.textUnit.text.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text extends TextUnit {

    public static final String TEXT_NAME = "TEXT";

    /**
     * text units
     */
    private ArrayList<TextUnit> text;

    public void setText(ArrayList<TextUnit> text) {
        this.text = text;
    }

    public Text() {
        super("",TextUnitTypeEnum.TEXT);
        text = new ArrayList<>();
    }

    /**
     * add sentence to array
     * @param sentence sentence
     */
    public void addSentence(Sentence sentence) {
        text.add(sentence);
    }

    /**
     * add paragraph to array
     * @param paragraph paragraph
     */
    public void addParagraph(Paragraph paragraph) {
        text.add(paragraph);
    }

    /**
     * add codeBlock to array
     * @param codeBlock code block
     */
    public void addCode(CodeBlock codeBlock) {
        text.add(codeBlock);
    }

    /**
     * get all sentences
     * @return  sentences in text
     */
    public ArrayList<Sentence> getSentences() {
        ArrayList<Sentence> sentences = new ArrayList<>();
        for (TextUnit textUnit : text) {
            if (textUnit.getClass() == Sentence.class)
                sentences.add((Sentence)textUnit);
        }
        return sentences;
    }

    /**
     * get all paragraphs
     * @return  paragraphs in text
     */
    public ArrayList<Paragraph> getParagraphs() {
        ArrayList<Paragraph> paragraphs = new ArrayList<>();
        for (TextUnit textUnit : text) {
            if (textUnit.getClass() == Paragraph.class)
                paragraphs.add((Paragraph)textUnit);
        }
        return paragraphs;
    }

    /**
     * get all code blocks
     * @return code blocks in text
     */
    public ArrayList<CodeBlock> getCodeBlocks() {
        ArrayList<CodeBlock> codeBlocks = new ArrayList<>();
        for (TextUnit textUnit : text) {
            if (textUnit.getClass() == CodeBlock.class)
                codeBlocks.add((CodeBlock)textUnit);
        }
        return codeBlocks;
    }

    @Override
    public String toString() {
        StringBuilder textToString = new StringBuilder();
        for (TextUnit textUnit : text) {
            textToString.append(textUnit.toString());
            if (textUnit.getClass() == Sentence.class)
                textToString.append(" ");
        }
        return textToString.toString();
    }

    /**
     * swap two words
     * @return swaped text
     */
    public void sortSentencesByLength() {
        SortedMap<Integer, Sentence> map = new TreeMap<>();
        for (TextUnit textUnit : text) {
            if (textUnit.getClass() == Sentence.class)
                try {
                    int size = ((Sentence) textUnit).sizeSentence();
                    map.put(size, ((Sentence) textUnit));
                }
                catch (Exception e) {
                    throw e;
                }
        }
        for(Sentence sen : map.values()) {
            System.out.println(sen.toString());
        }
    }

    public void findWordsThatAreOnlyInTheFirstSentence(){
        ArrayList<Sentence> sentences = getSentences();
        String [] otherLine = new String[sentences.size()];
        int count = 0;
        String line = "";
        for (TextUnit textUnit : text) {
            if (textUnit.getClass() == Sentence.class) {
                try {
                    if (count == 0) {
                        line = textUnit.toString();
                    } else {
                        otherLine[count - 1] = textUnit.toString();
                    }
                } catch (Exception e) {
                    throw e;
                }
                count++;
            }
        }
        Function<String[], Predicate<String>> function = f ->
                p -> !Stream.of(f)
                        .collect(Collectors.joining(" ")).contains(p);
        Stream.of(line.replaceAll("\\pP", " ").split(" "))
                .filter(function.apply(otherLine))
                .forEach(System.out::println);
    }
}
