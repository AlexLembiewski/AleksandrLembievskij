/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task02.infohandler.main;

import by.epam.task02.infohandler.entity.Text;
import by.epam.task02.infohandler.util.TextParser;
import by.epam.task02.infohandler.util.TextWorker;
import org.apache.log4j.Logger;

/**
 *
 * @author Администратор
 */
public class InfoHandler {

    private static final Logger log = Logger.getLogger(InfoHandler.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TextParser tp = new TextParser();
        Text text = tp.parse("task2text.txt");
        log.trace("Plain text");
        text.printToConsole();
        
         //12 subtask
         TextWorker.removeWordsStartWithConsonant(text, 6);
         text.printToConsole();
         //2 subtask
         TextWorker.sortBySentence(text);
         text.printToConsole();
         //5 subtask
         TextWorker.swapWords(text);
         text.printToConsole();
         
    }

}
