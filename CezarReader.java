/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.wmp.prja.laboratorium6;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author pkacz_000
 */
public class CezarReader extends FilterReader {
    int offset;
    public CezarReader(int offset, Reader in) {
        super(in);
        this.offset=offset;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int licznik=0;
        for (int i = off; i < len; i++) {
            licznik=i;
            int temp = this.in.read();
            
            if (temp == -1) {
                break;
               // return -1;
                
            }
            char u = (char) temp;
            if (u < 'A' || u > 'z' || u > 'Z' && u < 'a') {
                throw new IOException();
            }
            u -= offset;
            if (u < 'A' || u < 'a' && u > 'Z') {
                u += 26;
            }
            cbuf[i] = u;
            System.out.println(u);
            
        }
        if (licznik > 0)
            return licznik;
        return -1;
    }
    
}
