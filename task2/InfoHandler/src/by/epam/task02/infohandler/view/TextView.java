/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task02.infohandler.view;

import by.epam.task02.infohandler.entity.Listing;
import by.epam.task02.infohandler.entity.Punctuation;
import by.epam.task02.infohandler.entity.Sentence;
import by.epam.task02.infohandler.entity.SentencePart;
import by.epam.task02.infohandler.entity.Text;
import by.epam.task02.infohandler.entity.Word;

/**
 *
 * @author Администратор
 */
public class TextView {

    public static String formatTextAsString(Text text) {

        StringBuilder sb = new StringBuilder();
        for (Sentence textpart : text.getAllElements()) {
            if (textpart.getClass().equals(Listing.class)) {
                Listing listing = (Listing) textpart;
                sb.append(listing.getValue());
            }
            for (SentencePart part : textpart.getAllElements()) {
                if (part instanceof Word) {
                    Word word = (Word) part;
                    sb.append(" ").append(word.getValue());
                } else {
                    Punctuation punctuation = (Punctuation) part;
                    sb.append(punctuation.getValue());
                }

            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
