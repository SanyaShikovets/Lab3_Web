package view;

import controller.Controller;
import localization.LocaleHelper;
import model.Text;
import exception.FileException;
import exception.InvalidParsingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static localization.LocaleHelper.*;

/**
 * Main class which run controller's demonstrate method
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */
public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    /**
     * main method
     * @param args argument lines
     */
    public static void main(String[] args) {
        logger.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.CONTROLLER_INIT) + ANSI_RESET);
        Controller controller = new Controller();
        try {

            String result = controller.loadText("input.txt");
            System.out.println(ANSI_BLUE + "------" + LocaleHelper.getLocalizedString(LocaleHelper.FILE_LOADED) + "------" + ANSI_RESET);
            System.out.print(result);
            System.out.println();

            System.out.println(ANSI_BLUE + "------" + (LocaleHelper.getLocalizedString(START_COMBINE)) + "------" + ANSI_RESET);
            Text text = controller.parseTextStringToText();
            System.out.println(text.toString());
            System.out.println();

            System.out.println(ANSI_BLUE + "------" + (LocaleHelper.getLocalizedString(SORT)) + "------" + ANSI_RESET);
            controller.sortSentencesByLength(text);
            System.out.println();

            System.out.println(ANSI_BLUE + "------" + (LocaleHelper.getLocalizedString(FIND_WORDS_ONLY_FIRST)) + "------" + ANSI_RESET);
            controller.findWordsThatAreOnlyInTheFirstSentence(text);

        } catch (FileException | InvalidParsingException  | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        logger.info(ANSI_BLUE + LocaleHelper.getLocalizedString(LocaleHelper.SHUTDOWN) + ANSI_RESET);
    }
}