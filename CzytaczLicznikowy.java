/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.wmp.prja.laboratorium6;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Czytacz z licznikiem napotkanych sekwencji.
 *
 * Odczytuje dane ze strumienia znakowego i jednocześnie liczy, ile zostało
 * odczytanych sekwencji podanych przez użytkownika. Sekwencje wyszukiwane są z
 * powtórzeniami, a więc sekwenca "aaa" zawiera dwie sekwencje "aa". Licznik
 * zwiększany jest dopiero po wczytaniu danych przy pomocy metody read.
 *
 * @author kot
 */
public class CzytaczLicznikowy extends FilterReader {

    int licznik;
    String pattern;
    String textToSearch;

    /**
     * Konstruuje czytacza z licznikiem sekwencji <code>pattern</code> w oparciu
     * o odczyt ze strumienia znakowego <code>in</code>.
     *
     * @param pattern Wyszukiwana sekwencja.
     * @param in Znakowy strumień wejściowy, z którego czytamy.
     */
    public CzytaczLicznikowy(String pattern, Reader in) {
        super(in);
        licznik = 0;
        this.pattern = pattern;
        this.textToSearch = "";
    }

    @Override
    public int read() throws IOException {
        licznik = 0;
        textToSearch += (char) in.read();
        Pattern p = Pattern.compile(pattern);
        for (int i = 0, j = pattern.length(); j <= textToSearch.length(); j++, i++) {
            String temp = textToSearch.substring(i, j);
            Matcher m = p.matcher(temp);
            boolean b = m.matches();
            System.out.println(temp);
            if (b) {
                licznik++;
            }
        }
        System.out.println();
        return -1;
    }

    /**
     * Zwraca ilość wczytanych do tej pory sekwencji.
     *
     * @return ilość wczytanych do tej pory sekwencji.
     */
    public int getLicznik() {
        return licznik;
    }

}
