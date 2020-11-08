package model.textUnit.code;

import model.textUnit.text.TextUnit;
import model.textUnit.text.TextUnitTypeEnum;

import java.util.ArrayList;

/**
 * CodeBlock
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */

public class CodeBlock extends TextUnit {

    public static final String DIVIDER = "<code>";

    /**
     * all code lines
     *
     */
    private ArrayList<CodeLine> code;

    /**
     * all code lines getter
     * @return code lines
     */
    public ArrayList<CodeLine> getCodeLines() {
        return code;
    }

    /**
     * constructor
     * @param value code line value
     *
     */
    public CodeBlock(String value) {
        super(value, TextUnitTypeEnum.CODE_BLOCK);
        code = new ArrayList<>();
    }

    /**
     * add new code line
     * @param codeLine code line
     *
     */
    public void addCodeLine(CodeLine codeLine) {
        code.add(codeLine);
    }

    @Override
    public String toString() {
        StringBuilder textToString = new StringBuilder("\n" + DIVIDER);
        for (CodeLine codeLine : code) {
            textToString.append("\n" + codeLine.toString());
        }
        textToString.append("\n" + DIVIDER);
        return textToString.toString();
    }
}