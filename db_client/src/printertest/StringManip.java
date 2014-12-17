package printertest;



import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class StringManip {
	
    public static LinkedList<String> getStringsPerLine(String text,Font fontDetail,int width){
		FontRenderContext myfont;
		myfont = new FontRenderContext(null, true, true);
		LinkedList<String> lines = new LinkedList<String>();
		
		String finalText;
		String[] arr = text.split(",");
		int i = 0;
		while(i<arr.length){
			finalText = "";
			do{
                            finalText+=arr[i];
                            finalText+=",";	
                            i++;
			}while(fontDetail.getStringBounds(finalText, myfont).getWidth() < width && i < arr.length);
			lines.add(finalText.replace(",,", ","));
		}
		return lines;
	}
     public static double fontsInLine(String text ){
		FontRenderContext myfont;
                Font fontDetail = new Font("verdana",Font.BOLD,10);
		myfont = new FontRenderContext(null, true, true);
		Rectangle2D textBound = fontDetail.getStringBounds(text, myfont);
		return (textBound.getWidth());
	}
     
         public static double fontsInLineReport(String text ){
		FontRenderContext myfont;
                Font fontDetail = new Font("verdana",Font.BOLD,10);
		myfont = new FontRenderContext(null, true, true);
		Rectangle2D textBound = fontDetail.getStringBounds(text, myfont);
		return (textBound.getWidth());
	}
     
     public static double fontsInLine2(String text ,int size){
		FontRenderContext myfont;
                Font fontDetail = new Font("Verdana",Font.BOLD,size);
		myfont = new FontRenderContext(null, true, true);
		Rectangle2D textBound = fontDetail.getStringBounds(text, myfont);
		return (textBound.getWidth());
	}
	public static LinkedList<String> getStringsPerLine(String text,Font fontDetail){
		return getStringsPerLine(text, fontDetail,160);
	}
	public double fontsInLine(Font fontDetail,int width){
		String text = "The Quick Brown Fox Jumps Over the Hazy Dog";
		FontRenderContext myfont;
		myfont = new FontRenderContext(null, true, true);
		Rectangle2D textBound = fontDetail.getStringBounds(text, myfont);
		return width/(textBound.getWidth()/text.length());
	}
	public double fontsInLine(Font fontDetail){
		return fontsInLine(fontDetail, 190);
	}
	public double getFontHeight(Font fontDetail){
		String text = "The Quick Brown Fox Jumps Over the Hazy Dog";
		FontRenderContext myfont;
		myfont = new FontRenderContext(null, true, true);
		Rectangle2D textBound = fontDetail.getStringBounds(text, myfont);
		return textBound.getHeight();
	}
	
}
