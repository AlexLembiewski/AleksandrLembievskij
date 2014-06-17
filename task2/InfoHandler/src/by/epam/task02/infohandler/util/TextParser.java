/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task02.infohandler.util;

import by.epam.task02.infohandler.entity.Listing;
import by.epam.task02.infohandler.entity.Punctuation;
import by.epam.task02.infohandler.entity.Sentence;
import by.epam.task02.infohandler.entity.Text;
import by.epam.task02.infohandler.entity.Word;
import by.epam.task02.infohandler.resourcebundle.ApplicationValue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author Администратор
 */
public class TextParser {

    private static final Logger log = Logger.getLogger(TextParser.class);
    private int braceCount; //счетчик фигурных скобок

    public Text parse(String pathToFile) {
        Text text = null;
        try {
            FileInputStream fstream = new FileInputStream(pathToFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            ResourceBundle bundle;
            bundle = ResourceBundle.getBundle(ApplicationValue.BUNDLE_LOCATION);

            String textLine;
            text = new Text();
            while ((textLine = br.readLine()) != null) {
                if ((textLine.matches(bundle.getString(ApplicationValue.HEADER))
                        || (textLine.trim().matches(bundle.getString(ApplicationValue.OUTPUT))))) {
                    text.add(splitSentenceByWordsAndPunctuation(textLine));
                } else { //split to sentences
                    if (isCode(textLine)) {//listing check
                        text.add(new Listing(textLine));
                    } else {
                        Pattern sentencePattern = Pattern.compile(bundle.getString(ApplicationValue.SENTENCE));
                        Matcher sentenceMatcher = sentencePattern.matcher(textLine);
                        while (sentenceMatcher.find()) {
                            String sentenceString = sentenceMatcher.group();
                            text.add(splitSentenceByWordsAndPunctuation(sentenceString));
                        }
                    }
                }

            }
        } catch (IOException e) {
            log.error(e);
        }
        return text;
    }

    private Sentence splitSentenceByWordsAndPunctuation(String sourceString) {
        ResourceBundle bundle;
        bundle = ResourceBundle.getBundle(ApplicationValue.BUNDLE_LOCATION);
        Pattern wordPattern = Pattern.compile(bundle.getString(ApplicationValue.WORD_PUNCUATION));
        Matcher wordMatcher = wordPattern.matcher(sourceString);
        Sentence sentence = new Sentence();
        while (wordMatcher.find()) {
            String sentencePartString = wordMatcher.group();
            if (isPunctuation(sentencePartString)) {
                sentence.add(new Punctuation(sentencePartString));
            } else {
                sentence.add(new Word(sentencePartString));
            }
        }
        return sentence;
    }

    private boolean isPunctuation(String sourceString) {
        if (sourceString.length() == 1) {
            switch (sourceString) {
                case ".":
                    return true;
                case ",":
                    return true;
                case "!":
                    return true;
                case "(":
                    return true;
                case ":":
                    return true;
                case ")":
                    return true;
                case "'":
                    return true;
                case ";":
                    return true;
                case ">":
                    return true;
                case "=":
                    return true;
                case "-":
                    return true;
            }
        }
        return false;
    }

    private boolean isCode(String sourceString) {
        if (sourceString.isEmpty()) {
            return false;
        } else if (sourceString.contains("{") && !sourceString.contains("}")) {
            braceCount++;
            return true;
        } else if (sourceString.contains("}") && !sourceString.contains("{")) {
            braceCount--;
            return true;
        } else if (braceCount != 0) {
            return true;
        }
        return false;
    }

}
