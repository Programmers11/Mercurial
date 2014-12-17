package printertest;


public class myObject {
    String str;
    java.awt.Font font;
    int lineSpacings;
    
    public myObject(String line,java.awt.Font fnt){
    
        str = line;
        font =fnt;
    }
    public myObject(String line,java.awt.Font fnt,int linespace){
    
        str = line;
        font =fnt;
        lineSpacings = linespace;
    }
    
}
