/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.wmp.prja.laboratorium6;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;

/**
 *
 * @author kot
 */
public class TajnyDokument implements Serializable {
    
    private transient String zawartosc;
    private String podpis;

    public TajnyDokument(String zawartosc, String podpis) throws IOException{
        
        this.zawartosc=zawartosc;
        this.podpis=podpis;
    }
    private void writeObject(java.io.ObjectOutputStream out) throws IOException{
        CezarWriter temp=new CezarWriter(3, new StringWriter());
        temp.write(zawartosc);
        out.writeBytes(temp.toString());
        out.defaultWriteObject();
    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        zawartosc=decode(in.readLine());
        in.defaultReadObject();
    }
    public String getZawartosc() {
        return zawartosc;
    }

    public String getPodpis() {
        return podpis;
    }    
    public String decode(String arg) throws IOException{
        String temp="";
        for (int i = 0; i < arg.length(); i++) {
           
            char u = arg.charAt(i);
            if (u < 'A' || u > 'z' || u > 'Z' && u < 'a') {
                throw new IOException();
            }
            u -= 3;
            if (u < 'A' || u < 'a' && u > 'Z') {
                u += 26;
            }
            temp+=u;
            
        }
    return temp;
    }
}
