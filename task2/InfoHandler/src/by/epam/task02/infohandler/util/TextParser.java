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
import by.epam.task02.infohandler.resourcebundle.Const;
import java.io.BufferedReader;
import java.io.DataInputStream;
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
    private int braceCount;

    public Text parse(String pathToFile) {
        Text text = null;
        try {
            FileInputStream fstream = new FileInputStream(pathToFile);
            try (DataInputStream in = new DataInputStream(fstream)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                ResourceBundle bundle;
                bundle = ResourceBundle.getBundle(Const.BUNDLE_LOCATION);
                
                String textLine;
                text = new Text();
                while ((textLine = br.readLine()) != null) {
                    //header check
                    if (textLine.matches(bundle.getString(Const.HEADER))) {
                        text.add(makeSentence(textLine.trim()));
                    } else if (textLine.trim().matches(bundle.getString(Const.OUTPUT))) {
                        text.add(makeSentence(textLine.trim()));
                    } //listing check
                    else if (isCode(textLine)) {
                        text.add(new Listing(textLine));
                    } else { //split to sentences
                        Pattern sentencePattern = Pattern.compile(bundle.getString(Const.SENTENCE));
                        Matcher sentenceMatcher = sentencePattern.matcher(textLine);
                        while (sentenceMatcher.find()) {
                            String sentenceString = sentenceMatcher.group();
                            text.add(makeSentence(sentenceString));
                        }
                    }
                }
            }
        } catch (IOException e) {
            log.error(e);
        }
        return text;
    }

    private Sentence makeSentence(String sourceString) {
        ResourceBundle bundle;
        bundle = ResourceBundle.getBundle(Const.BUNDLE_LOCATION);
        Pattern wordPattern = Pattern.compile(bundle.getString(Const.WORD_PUNCUATION));
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
