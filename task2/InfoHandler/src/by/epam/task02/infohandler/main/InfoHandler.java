/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task02.infohandler.main;

import by.epam.task02.infohandler.entity.Sentence;
import by.epam.task02.infohandler.entity.Text;
import by.epam.task02.infohandler.util.TextParser;
import by.epam.task02.infohandler.util.TextWorker;
import by.epam.task02.infohandler.view.TextView;
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
        System.out.println(TextView.formatTextAsString(text));
         //12 subtask
         TextWorker.removeWordsStartWithConsonant(text, 4);
         System.out.println(TextView.formatTextAsString(text));
         //2 subtask
         TextWorker.sortBySentence(text);
         System.out.println(TextView.formatTextAsString(text));
         //5 subtask
         TextWorker.swapWords(text);
         System.out.println(TextView.formatTextAsString(text));
         
    }

}
