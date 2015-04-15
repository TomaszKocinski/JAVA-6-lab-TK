/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.wmp.prja.laboratorium6;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author kot
 */
public class CezarWriter extends FilterWriter {
    int offset;
    public CezarWriter(int offset, Writer out) {
       super(out);
       this.offset=offset;
    }
    @Override
    public void write(String str) throws IOException {
        String temp="";
        for(int i=0;i<str.length();i++){
            char charInArgStr=str.charAt(i);
            if(charInArgStr<'A' ||charInArgStr>'z' || charInArgStr>'Z' && charInArgStr<'a'){
                throw new IOException();
            }
            charInArgStr+=offset;
            if(charInArgStr>'Z' && charInArgStr<'a' || charInArgStr>'z') {
               
                charInArgStr-=26;
            }
            temp+=charInArgStr;
        }
        this.write(temp, 0, temp.length());
    }

    @Override
    public String toString() {
        return this.out.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
