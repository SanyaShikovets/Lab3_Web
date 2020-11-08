package controller;

import localization.LocaleHelper;
import model.Text;
import exception.FileException;
import exception.InvalidParsingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.TextParser;

import java.nio.file.Paths;
import java.util.Scanner;

/**
 * word text splitter parser
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */
public class Controller {

    private static Logger log = LogManager.getLogger(Controller.class.getName());
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private String textString = "";

    public String getTextString() {
        return textString;
    }

    /**
     * load text
     * @param path path to file
     * @throws FileException if no file
     * @return text string
     *
     */
    public String loadText(String path) throws FileException {
        log.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.FILE_LOADING) + ANSI_RESET);
        try {
            Scanner load = new Scanner(Paths.get(path));
            while(load.hasNextLine()) {
                textString += load.nextLine();
                textString += "\n";
            }
            load.close();
        } catch (Exception e) {
            throw new FileException(LocaleHelper.getLocalizedString(LocaleHelper.INVALID_ARGS), e);}
        log.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.FILE_LOADED) + ANSI_RESET);
        return textString;
    }

    /**
     * parse text string to text object
     * @return text object
     *
     */
    public Text parseTextStringToText() throws InvalidParsingException {

        TextParser textParser = new TextParser();
        Text parsedText;
        try {
            log.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.START_TEXT_PARSING) + ANSI_RESET);
            parsedText = textParser.splitText(textString);
            log.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.FINISH_TEXT_PARSING) + ANSI_RESET);
        } catch (Exception e) {
            throw e;
        }

        return parsedText;
    }

    /**
     * sort sentences by length
     * @param text text object
     * @return sort sentences text
     *
     */
    public void sortSentencesByLength(Text text) {
        log.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.START_SENTENCES_SORTING) + ANSI_RESET);
        try {
            text.sortSentencesByLength();
        } catch (Exception e) {
            throw e;
        }
        log.info(ANSI_BLUE +LocaleHelper.getLocalizedString(LocaleHelper.FINISH_SENTENCES_SORTING) + ANSI_RESET);
    }

    /**
     * find words that are only the first sentence
     * @param text text object
     *
     */
    public void findWordsThatAreOnlyInTheFirstSentence(Text text) {
        log.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.START_WORDS_FINDING) + ANSI_RESET);
        text.findWordsThatAreOnlyInTheFirstSentence();
        log.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.FINISH_WORDS_FINDING) + ANSI_RESET);
    }

}
