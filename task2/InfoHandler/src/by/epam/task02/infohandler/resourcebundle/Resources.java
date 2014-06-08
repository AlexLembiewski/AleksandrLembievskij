/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task02.infohandler.resourcebundle;

import java.util.ListResourceBundle;

/**
 *
 * @author Администратор
 */
public class Resources extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            {"sentence_pattern", "([A-Za-z_0-9](|[^?!.\\(]|\\([^\\)]*\\))*[?!.]|\\w.+:)"},
            {"header_pattern", "1.+"},
            {"output_pattern", "(G.+) = (.+)"},
            {"word_punct_pattern", "([a-zA-Z0-9-])+|(['.,?!><=();:])"}
        };
    }

}
