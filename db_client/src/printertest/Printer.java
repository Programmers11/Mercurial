package printertest;

import db_client.BookingType;
import db_client.ClientType;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.AttributedString;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class Printer implements Printable {

	//<editor-fold defaultstate="collapsed" desc="Variables">
	private boolean remarksLeft = true;
	private final String CashName;
	private final int count;
	private final String PhoneNumber;
	private final String DDate;
	private final String ReceiptId;
	private String Mode;
	private final String Discount;
	private final double Total;
	private final String CusName;
	private final String IDate;
	private final String Reason;
	private final String GrossAmount;
	private final int row;
	private final int type;
	private double y = 0;
	private double x = 0;
	private boolean cashMemo = false;
	Font font;
	AttributedString Style;
	Graphics2D graphics1;
	private boolean barcodePrinted = false;
	private int pageLength = 710;
	private boolean noPagesLeft = false;
	private double tableYcord = 25;
	private boolean pageLeft;
	private boolean tableValuesLeft;
	private boolean printFooters = false;

	int xcord = 5, ycord = 25;
	double lineSpace = 1.2; // its the number of times you want to have line space (like word)(multiple option)
	double paragraphSpace = 1.5; // it is the space between paragraph more precisely space after the paragraph (multiple not pt)
	int pageBreak = 0;
	boolean firstRun = true;
	private int counter = 1;
	int RectangleHeight = 5;
	boolean tableStarted = false;
	boolean tableEnded = false;
	boolean newPage = false;
	LinkedList<String> remarks;
	LinkedList<myObject> table = new LinkedList<>();
	LinkedList<myObject> totalsTable = new LinkedList<>();
	int globalTableCounter = 0;
	int globalAmountCounter = 0;
        String TaxAmount = "" ;

	Object Table[][];

	StringManip strManip;

	//</editor-fold>
	private int hangers = 0;
        
	public Printer(Object Table1[][], String Data[], String Cname, int num, double Total1, int type, int hang) {

		Table = Table1;
		CashName = Cname;
		count = num;
		PhoneNumber = Data[0];
		DDate = Data[1];
		ReceiptId = Data[2];
		Mode = Data[3];
                if(Data[3].contentEquals("SUrgent")) 
                    Mode="SemiUrgent";
		Discount = Data[4];
		Total = Total1;
		CusName = Data[5];
		IDate = Data[6];
		Reason = Data[7];
		GrossAmount = Data[8];
		row = 0;
		this.type = type;
		hangers = hang;
                TaxAmount = Data[10];
		setItemsTableAndTotals();

	}

	public Printer(Object Table1[][], String Data[], String Cname, int num, double Total1, int type, boolean cashMemo) {

		Table = Table1;
		CashName = Cname;
		count = num;
		PhoneNumber = Data[0];
		DDate = Data[1];
		ReceiptId = Data[2];
		Mode = Data[3];
                if(Data[3].contentEquals("SUrgent")) 
                    Mode="SemiUrgent";
		Discount = Data[4];
		Total = Total1;
		CusName = Data[5];
		IDate = Data[6];
		Reason = Data[7];
		GrossAmount = Data[8];
		row = 0;
		this.type = type;
                TaxAmount = Data[10];
		setItemsTableAndTotals();
		this.cashMemo = cashMemo;

	}

	//overrides default print function
	@Override
	public int print(Graphics graphics, PageFormat pF, int pageIndex) throws PrinterException {

		if (noPagesLeft) {
			return NO_SUCH_PAGE;
		} else {
			graphics1 = (Graphics2D) graphics;
			// System.out.println(pF.getImageableX() + " " + pF.getImageableY());

			graphics1.translate(pF.getImageableX(), pF.getImageableX());
			setVariables();//sets variable for neutralizing dual run problem.
			
			headers(pageIndex, cashMemo);//prints header
			printItemsTableAndTotals(pageIndex);//print the contents of receipt table
			footers();//prints footers
			firstRun = true; //variable for neutralizing dual run problem

			return PAGE_EXISTS;
		}

	}

	//prints the string text on y axis => lineSpace
	void printf(String text, String fontname, int fontsize, int type, int Xcord, double lineSpace) {
		font = new Font(fontname, type, fontsize);
		Style = new AttributedString(text);
		Style.addAttribute(TextAttribute.FONT, font);
		graphics1.drawString(Style.getIterator(), Xcord, ycord);
		if (!firstRun) {
			// ycord += graphics1.getFontMetrics(font).getHeight();
			ycord += font.getSize() * .75 + lineSpace;

		} else {
			tableYcord += font.getSize() * .75 + lineSpace;
		}
	}

        //prints the string text
	void printf(String text, String fontname, int fontsize, int type, int Xcord) {
		font = new Font(fontname, type, fontsize);
		Style = new AttributedString(text);
		Style.addAttribute(TextAttribute.FONT, font);
		graphics1.drawString(Style.getIterator(), Xcord, ycord);
		if (!firstRun) {
			// ycord += graphics1.getFontMetrics(font).getHeight();
			ycord += font.getSize();
		} else {
			tableYcord += font.getSize();

		}
	}

	//<editor-fold defaultstate="collapsed" desc="printfNoLine">
	void printfnoLine(String text, String fontname, int fontsize, int type, int Xcord) {
		font = new Font(fontname, type, fontsize);
		printfnoLine(text, font, Xcord);
		/*Style = new AttributedString(text);
		 Style.addAttribute(TextAttribute.FONT,font);
		 graphics1.drawString(Style.getIterator(),Xcord,ycord);*/

	}

	void printfnoLine(String text, Font font, int Xcord) {
		Style = new AttributedString(text);
		Style.addAttribute(TextAttribute.FONT, font);
		graphics1.drawString(Style.getIterator(), Xcord, ycord);

	}
 //</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="printfemptyString">
	void printEmptyString(int fontsize) {
		String text = " ";
		String fontname = "Verdana";

		font = new Font(fontname, Font.BOLD, fontsize);
		Style = new AttributedString(text);
		Style.addAttribute(TextAttribute.FONT, font);
		graphics1.drawString(Style.getIterator(), 5, ycord);
		if (!firstRun) {
			// ycord += graphics1.getFontMetrics(font).getHeight();
			ycord += font.getSize();
		} else {
			tableYcord += font.getSize();
		}
	}
	//</editor-fold>

	private void headers(int pageIndex, boolean isCashMemo) {

		if (pageIndex == 0) {

			//<editor-fold defaultstate="collapsed" desc="Merc Info">
			if (isCashMemo) {
				graphics1.fillRoundRect(5, 5, 200, 20, 10, 10);

				RectangleHeight = 25;
				ycord -= 2;
				printfWhite("CASH MEMO", "Verdana", 15, Font.BOLD, 55, 15);
				RectangleHeight += 5;
			} else if (ReceiptId.length() > 8) {
				graphics1.fillRoundRect(5, 5, 200, 20, 10, 10);
				RectangleHeight = 25;
				ycord -= 2;
				printfWhite("DUPLICATE", "Verdana", 15, Font.BOLD, 55, 15);
				RectangleHeight += 5;
			}
			Rectangle(5, RectangleHeight, 200, 100, 10, 10);
                       //*
                        System.out.println("soban error");
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File("merc.jpg"));
                        } catch (IOException e) {
                            System.out.println(""+e.getMessage());
                        }
                        System.out.println("\n\n\nImg Height --- Yaaay " + img.getHeight() + "\n\n");
                        printfimgHead(img, 8, ycord-20, 90, 190);
			//*/
                        //(text,fontName,fontSize,fontattr,xCordinateOnPage)
			/*
                         printEmptyString(20);
			printf("MERCURY", "Verdana", 35, Font.BOLD, 10, -5);
			printf("C L E A N E R S", "Verdana", 21, Font.BOLD, 17, 0);
			//*
			printf("12-c, Stadium Lane-1,Kh-e-Shamsheer", "Verdana", 9, Font.PLAIN, 13, 5);
			printf("DHA Phase V, KHI - 35841207, 35850809", "Verdana", 9, Font.PLAIN, 10, 0);
                        //*/
         //</editor-fold>

			//<editor-fold defaultstate="collapsed" desc="Rcpt Info">
			Rectangle(5, RectangleHeight, 200, 113 + (isCashMemo ? 20 : 0), 10, 10);
			printEmptyString(30);
			line(ycord + 5);
			//graphics1.fillRoundRect(5, ycord-16, 75, 20, 3,3);
			printfnoLine("VOUCHER", "Verdana", 12, Font.PLAIN, 10);
			printEmptyString(3);
			printf(ReceiptId.substring(0, 6), "Verdana", 20, Font.BOLD, 80, 0.8);
			//line(ycord-17);

			printfnoLine("Booking Date", "Verdana", 8, Font.PLAIN, 10);
			//printf(IDate/*"Tue, 28 Feb'14 8:00AM"*/,"Verdana",9,Font.BOLD,80,8);
			System.out.println("soban-1");
                        if(!cashMemo){
                            printf(BookingType.getIssueTimeStamp(ReceiptId) + " "/*"Tue, 28 Feb'14 8:00AM"*/, "Verdana", 8, Font.BOLD, 80, 8);
                        }else{
                            printf(BookingType.getIssueTimeStampCashMemo(ReceiptId) + " "/*"Tue, 28 Feb'14 8:00AM"*/, "Verdana", 8, Font.BOLD, 80, 8);
                       
                        }
			printfnoLine("Due Date", "Verdana", 8, Font.PLAIN, 10);
			printf(BookingType.getDueTimeStamp(ReceiptId) + ((isCashMemo)?" ":" - 07:00 PM")/*"Fri, 3 Mar'14 8:00AM"*/, "Verdana", 8, Font.BOLD, 80, 8);
			System.out.println("soban-2");
                        //</editor-fold>

			if (isCashMemo) {
				printfnoLine("Delivery Date", "Verdana", 8, Font.PLAIN, 10);
				printf(BookingType.getDelTimeStamp(ReceiptId), "Verdana", 8, Font.BOLD, 80, 8);
			}

			//<editor-fold defaultstate="collapsed" desc="Customer Info">
			printfnoLine("Name ", "Verdana", 8, Font.PLAIN, 10);
			printf(CusName, "Verdana", 8, Font.BOLD, 80, 8);

			printfnoLine("Phone# ", "Verdana", 8, Font.PLAIN, 10);
			printf(PhoneNumber, "Verdana", 8, Font.BOLD, 80, 8);

			printfnoLine("Address ", "Verdana", 8, Font.PLAIN, 10);
			printf(new ClientType().getClientAddress(PhoneNumber), "Verdana", 8, Font.BOLD, 80, 12);

			printf("Busniess Hours  8:00 AM - 8:00 PM", "Verdana", 8, Font.PLAIN, 25);
			printEmptyString(8);
         //</editor-fold>

			//Rectangle(5,RectangleHeight,200, 20, 10, 10);
			graphics1.drawRoundRect(5, RectangleHeight, 200, 20, 10, 10);
			printEmptyString(3);
			printf(("QTY    " + "PARTICULAR            " + "PRICE"), "Verdana", 10, Font.BOLD, 8, 0);
			printEmptyString(10);

		}

	}

	private void Rectangle(int x, int y, int width, int height, int arcw, int arch) {

		RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(x, y, width, height, arcw, arch);
		graphics1.draw(roundedRectangle);
		if (!firstRun) {
			RectangleHeight += height + 3;
		}
	}

	private void setVariables() {
		//System.out.println("counter = "+counter);
		if (counter % 2 == 0) {
			firstRun = !firstRun;
		}
		counter++;
	}

	private void line(int yCord) {
		graphics1.drawLine(8, yCord, 202, yCord);
	}
        void printfimgHead(BufferedImage img, int posx, int posy, int sizey, int sizex) {
		graphics1.drawImage(img, posx, posy, sizex, sizey, null);

		if (!firstRun) {

			ycord += (sizey / 2) + 25 + (cashMemo?4:0);
		} else {
			tableYcord += (sizey / 2) + 25  + (cashMemo?4:0);
		}

	}
        

	void printfimg(BufferedImage img, int posx, int posy, int sizey, int sizex) {
		graphics1.drawImage(img.getSubimage(0, 0, img.getWidth(), (img.getHeight() / 4) * 3), posx, posy, sizex / 2, sizey / 2, null);

		if (!firstRun) {

			ycord += (sizey / 2) + 5 - (type==1?2:0);
		} else {
			tableYcord += (sizey / 2) + 5 -(type==1?2:0);
		}

	}

	private void footers() {

		if (printFooters) {

			if (remarksLeft) {
				//  printEmptyString(20);
				pageLeft = (ycord < 710 || tableYcord < 710);
				if (pageLeft) {

					//<editor-fold defaultstate="collapsed" desc="Barcode Placement">
					BufferedImage img = null;

					try {
						Barcode b = null;
						b = BarcodeFactory.createCode128(ReceiptId.substring(0, 6));
						b.setBarHeight(50);
						b.setBarWidth(2);

						img = BarcodeImageHandler.getImage(b);

						printfimg(img, 45, ycord, img.getHeight(), img.getWidth());

					} catch (Exception e) {
					}
					//</editor-fold>

					if (!firstRun) {
						table.clear();
					}
					barcodePrinted = true;
				} else {
					if (!firstRun) {
						ycord = 25;
						tableYcord = 25;
						barcodePrinted = false;
					}
				}
			}

			//<editor-fold defaultstate="collapsed" desc="Terms & Conditions">
			if (barcodePrinted) {
				pageLeft = (ycord + 220 < (650) || tableYcord + 220 < (650));

				if (pageLeft) {
					//
					//

					if (type == 1) {
                                                linespacesmall();
						printf("STN-0292788-8", "Arial", 8, Font.BOLD, 75);
						linespacesmall();
						Rectangle(5, ycord, 200, 220, 10, 5);
						int charsize = 8, pos1 = 6, pos2 = 7;
						linespacelarge();
						printf("TERMS & CONDITIONS", "Arial", 8, Font.BOLD, 40);
						linespacesmall();

						try {
							Scanner in = new Scanner(new File("Terms.conf"));
							in.nextLine();
							while (in.hasNextLine()) {

								printf(in.nextLine(), "Arial", charsize, Font.PLAIN, pos1);
							}

						} catch (FileNotFoundException ex) {
							Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
						}
						/*
						 printf("1. All Article are taken at owner's risk.", "Arial", charsize, Font.PLAIN, pos1);
						 printf("2. As its not possible to examine each and every", "Arial", charsize, Font.PLAIN, pos1);
						 printf("   article at the time of booking, articles are", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   throughly examine in the workshop and any", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   report from the workshop about the condition", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   of the article received shall be accepted.", "Arial", charsize, Font.PLAIN, pos2);
						 printf("3. The management reserve the the rigth of ", "Arial", charsize, Font.PLAIN, pos1);
						 printf("   refusing to do the job even after it has", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   been accepted.", "Arial", charsize, Font.PLAIN, pos2);
						 printf("4. The management is not responsible for any", "Arial", charsize, Font.PLAIN, pos1);
						 printf("   delay in executing the order due to", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   unavoidable circumstances though every care", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   will be taken to execute job in time.", "Arial", charsize, Font.PLAIN, pos2);
						 printf("5. No resposibility will be taken if delievery", "Arial", charsize, Font.PLAIN, pos1);
						 printf("   of the clothes is not taken within 1pos1 days.", "Arial", charsize, Font.PLAIN, pos2);
						 printf("6. In case of loss or damage to the garments,", "Arial", charsize, Font.PLAIN, pos1);
						 printf("   compensations which shall not exceed 7 times", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   and shall not be less than five times the", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   cleaning charges will be made to the owner", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   within 1pos1 days of claim.", "Arial", charsize, Font.PLAIN, pos2);
						 printf("7. No responsibility will be taken for shrinking,", "Arial", charsize, Font.PLAIN, pos1);
						 printf("   fastness of color,sub standard buttons ornaments", "Arial", charsize, Font.PLAIN, pos2);
						 printf("   or anything left in pocket.", "Arial", charsize, Font.PLAIN, pos2);
						 printf("8. For removal of stains we will try our best but no ", "Arial", charsize, Font.PLAIN, pos1);
						 printf("   guarantee can be provided.", "Arial", charsize, Font.PLAIN, pos2);
						 s*/
						printEmptyString(5);
					} else if (cashMemo) {
                                               linespacesmall();
						printf("STN-0292788-8", "Arial", 8, Font.BOLD, 75);
						linespacesmall();
                                            Scanner cin=null;
                                            try {//for cash memo printing
                                                cin= new Scanner(new File("Company.txt"));
                                            } catch (FileNotFoundException ex) {
                                                Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                                
						printEmptyString(5);
						printf("CASH MEMO", "Arial", 10, Font.BOLD, 60);
						printf("Note: This slip only represent a cash memo, all articles ", "Arial", 8, Font.PLAIN, 10);
						printf("have been delivered.Management "+cin.nextLine(), "Arial", 8, Font.PLAIN, 10);
					}
					printEmptyString(5);
					serviceTag();
                                        
					
					printf(Calendar.getInstance().getTime().toString(), "Arial", 8, Font.BOLD, 5);
                                        printf("FACEBOOK.com/programmers11 - +92-331-2338554", "Arial", 8, Font.BOLD, 5);

					if (!firstRun) {
						noPagesLeft = true;
					}

				} else {
					if (!firstRun) {
						ycord = 25;
						tableYcord = 25;
						remarksLeft = false;
					}
				}
			}
		}
		//</editor-fold>

	}

	private void linespacelarge() {
		printEmptyString(10);
	}

	private void linespacesmall() {
		printEmptyString(3);
	}

	private void printItemsTableAndTotals(int pageIndex) {
		pageLeft = (ycord < pageLength || tableYcord < pageLength);
		tableValuesLeft = table.size() != 0;
		int vari = 0;
		while (pageLeft && tableValuesLeft) {
			if (!firstRun) {
				myObject obj = table.remove();
				switch (obj.str) {
					case " "://prints text
						line(ycord - 5);
						printf(obj.str, obj.font, 5, 2);
						break;
					case "":// prints  line ---
						line(ycord + obj.lineSpacings);
						//printf(obj.str,obj.font,5,2);
						break;
					case "-x"://print an empty line with no text just like printLn()
						printEmptyString(obj.lineSpacings);
						break;
					default:
						if (obj.lineSpacings != -99) {
							printfnoLine(obj.str, obj.font, obj.lineSpacings);
						} else {
							printf(obj.str, obj.font, 5, 2);
						}
						break;
				}

				tableValuesLeft = table.size() != 0;
				pageLeft = (ycord < pageLength);
			} else {

				myObject obj = table.get(vari);
				switch (obj.str) {
					case " ":
						line(ycord - 5);
						printf(obj.str, obj.font, 5, 2);
						break;
					case "":
						line(ycord + obj.lineSpacings);
						//printf(obj.str,obj.font,5,2);
						break;
					case "-x":
						printEmptyString(obj.lineSpacings);
						break;
					default:
						if (obj.lineSpacings != -99) {
							printfnoLine(obj.str, obj.font, obj.lineSpacings);
						} else {
							printf(obj.str, obj.font, 5, 2);
						}
						break;
				}
				vari++;
				tableValuesLeft = vari < table.size();
				pageLeft = (tableYcord < pageLength);
			}

		}
		if (!firstRun) {
			if (!pageLeft) {
				ycord = 25;
				tableYcord = 25;
			} else {
				printFooters = true;
//               noPagesLeft=true;
				setTotalTable();
			}
		}
		if (!pageLeft) {

		} else {
			if (!tableValuesLeft) {
				printFooters = true;
			}
			// noPagesLeft=true;
			// setTotalTable();
		}

	}

	private void setItemsTableAndTotals() {
		Font particulars = new Font("Verdana", Font.BOLD, 8);
		Font remarksFont = new Font("Verdana", Font.BOLD, 7);
		table.clear();
		for (int i = 0; i < Table.length; i++) {
			table.add(new myObject(TableEntryPrinter.TheCalculator(Table[i][1], Table[i][3], Table[i][4]), particulars, -99));
			remarks = StringManip.getStringsPerLine(TableEntryPrinter.TheCalculator(Table[i][2].toString()), remarksFont);
			while (remarks.size() > 0) {
				table.add(new myObject(" " + remarks.remove(), remarksFont, -99));
			}
			table.add(new myObject(" ", particulars, -5));

		}

		setTotalTable();
	}

	private void printf(String text, Font font, int Xcord, double lineSpace) {

		Style = new AttributedString(text);
		Style.addAttribute(TextAttribute.FONT, font);
		Style.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
		graphics1.drawString(Style.getIterator(), Xcord, ycord);
		if (!firstRun) {
			ycord += font.getSize() + lineSpace;
		} else {
			tableYcord += font.getSize() + lineSpace;
		}
	}

	private void printfWhite(String text, String fontName, int i, int BOLD, int Xcord, int lineSpace) {
		Font font = new Font(fontName, BOLD, i);
		Style = new AttributedString(text);
		Style.addAttribute(TextAttribute.FONT, font);
		Style.addAttribute(TextAttribute.FOREGROUND, Color.WHITE);
		graphics1.drawString(Style.getIterator(), Xcord, ycord);
		if (!firstRun) {
			ycord += font.getSize() + lineSpace;
		} else {
			tableYcord += font.getSize() + lineSpace;
		}
	}

	private void printfnoLineWhite(String text, String fontname, int fontsize, int type, int Xcord) {
		font = new Font(fontname, type, fontsize);
		printfnoLineWhite(text, font, Xcord);
		/*Style = new AttributedString(text);
		 Style.addAttribute(TextAttribute.FONT,font);
		 graphics1.drawString(Style.getIterator(),Xcord,ycord);*/

	}

	private void printfnoLineWhite(String text, Font font, int Xcord) {
		Style = new AttributedString(text);
		Style.addAttribute(TextAttribute.FONT, font);
		Style.addAttribute(TextAttribute.FOREGROUND, Color.WHITE);
		graphics1.drawString(Style.getIterator(), Xcord, ycord);

	}

	private void setTotalTable() {
                /*
                add 
                "-x" --> printf()
                ""  --> prints a line ------
                
                */
            
		Font headings = new Font("Verdana", Font.PLAIN, 9);
		Font values = new Font("Verdana", Font.BOLD, 9);
		
		table.add(new myObject(BookingType.getQuantity(ReceiptId.substring(0, 6)) + " ", new Font("Verdana", Font.BOLD, 10), 10));
		
                
		table.add(new myObject("Gross Amount", headings, 60));
		table.add(new myObject(TableEntryPrinter.TheCalculator(String.format("%.0f", Double.valueOf(GrossAmount)), 120, 172, 9), values, 140));
		
		if (!Discount.startsWith("0")) {
			table.add(new myObject("-x", values, 10));
                        table.add(new myObject(String.format("Discount[%.0f%%]",Double.valueOf(Discount)*100/Double.valueOf(GrossAmount)), headings, 60));
			table.add(new myObject(TableEntryPrinter.TheCalculator("-" + String.format("%.0f", Math.floor(Double.valueOf(Discount))), 120, 172, 9), values, 140));
                /*      SRemoved by jahanzeb 28-oct-15
                        table.add(new myObject("-x", values, 10));
                        double newNetAmount = Double.valueOf(GrossAmount) - Math.floor(Double.valueOf(Discount));
                        table.add(new myObject("NetAmount", headings, 60));
			table.add(new myObject(TableEntryPrinter.TheCalculator(String.format("%.0f", newNetAmount), 120, 172, 9), values, 140));
                */
                        }
		if (hangers > 0) {
			table.add(new myObject("-x", values, 10));
			table.add(new myObject("Hangers(" + hangers + "):", headings, 60));
			table.add(new myObject(TableEntryPrinter.TheCalculator("-" + String.valueOf((hangers * 2)), 123, 172, 9), values, 140));

		}
              //
                /* GST  removed from receipts 24 OCT-13
                table.add(new myObject("-x", values, 10)); 
                table.add(new myObject("GST["+db_client.MainMenu.GST+"%]", headings, 60));
		table.add(new myObject(TableEntryPrinter.TheCalculator(TaxAmount, 120, 172, 9), values, 140));
		//*/                
                table.add(new myObject("", values, 6));
		//  table.add(new myObject("",values,3));
		table.add(new myObject("-x", values, 20));

		Font cashValues = new Font("Verdana", Font.BOLD, 11);

		table.add(new myObject("Total Amount", cashValues, 60));
		table.add(new myObject(TableEntryPrinter.TheCalculator(String.format("%.0f", Total), 120, 172, 11), cashValues, 140));
		table.add(new myObject("-x", values, 15));
		table.add(new myObject("", values, -2));
		table.add(new myObject("", values, -1));
		table.add(new myObject("", values, 0));
		table.add(new myObject("", values, 1));
		table.add(new myObject("", values, -3));
		table.add(new myObject("", values, -4));
		//table.add(new myObject("-x", values, 20));
                table.add(new myObject("-x", values, 10));
                
	}

	public String dateCreator(int toAdd) {

		Calendar c = Calendar.getInstance();

		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			c.add(c.DATE, 1);
		}

		String date = c.getTime().toString();
		String dateArray[] = date.split(" ");
		String timeArray[] = dateArray[3].split(":");
		int hour = Integer.parseInt(timeArray[0]);

		String timeStamp = dateArray[0] + " " + dateArray[1] + " " + dateArray[2] + " " + (hour > 12 ? hour - 12 : hour) + ":" + timeArray[1] + ":" + timeArray[2] + (hour >= 12 ? " PM" : " AM");

		return timeStamp;
	}

	private void serviceTag() {
		if (ReceiptId.length() > 8) {
			Rectangle(5, ycord, 200, 153, 0, 0);
			printEmptyString(15);
			printfnoLine("DUPLICATE", "Arial", 12, Font.BOLD, 68);
			graphics1.drawLine(70, ycord + 1, 140, ycord + 1);
			printEmptyString(25);

			printfnoLine("Recv. Sign: ", "Arial", 10, Font.PLAIN, 20);
			graphics1.drawLine(80, ycord + 1, 185, ycord + 1);
			printEmptyString(25);

			printfnoLine("Name: ", "Arial", 10, Font.PLAIN, 20);
			graphics1.drawLine(80, ycord + 1, 185, ycord + 1);
			printEmptyString(25);
                        
                        printfnoLine("Phone: ", "Arial", 10, Font.PLAIN, 20);
			graphics1.drawLine(80, ycord + 1, 185, ycord + 1);
			printEmptyString(25);

			printfnoLine("Deliverd On: "+ Calendar.getInstance().getTime().toString().replaceAll("PKT", ""), "Arial", 10, Font.PLAIN, 20);
			//graphics1.drawLine(80, ycord + 1, 185, ycord + 1);
			printEmptyString(25);

			printfnoLine("RECIEVED WITH THANKS", "Arial", 11, Font.BOLD, 35);
			printEmptyString(26);
			ServiceBox();
			printEmptyString(10);
                        
		} else {

			ServiceBox();
			if (!cashMemo) {
				if (!Reason.isEmpty()) {
					printfnoLine("Reason  :", "Verdana", 8, Font.PLAIN, 10);
					printf(Reason, "Verdana", 8, Font.PLAIN, 80);
				}
			}

			if (type == 0) {

				printEmptyString(5);
				graphics1.fillRoundRect(42, ycord - 8, 115, 10, 0, 0);
				printfWhite("OFFICIAL COPY", "Verdana", 9, Font.BOLD, 52, 0);

			} else if (type == 1) {
				printEmptyString(5);
				graphics1.fillRoundRect(42, ycord - 8, 115, 10, 10, 10);
				printfWhite("CUSTOMER COPY", "Verdana", 10, Font.BOLD, 52, 0);

				// printf("CUSTOMER COPY","Verdana",10,Font.PLAIN,50);
			} else if (cashMemo) {

			}
			printEmptyString(10);

		}
	}

	private void ServiceBox() {
		Rectangle(5, ycord-10, 200, 60, 10, 5);
		//printEmptyString(10);

		printf(" ", "Verdana", 6, Font.BOLD, 80);
                printfnoLine("Service Type :", "Verdana", 8, Font.BOLD, 10);
		printf(Mode, "Verdana", 11, Font.BOLD, 90);
		printfnoLine("Operated by  :", "Verdana", 8, Font.BOLD, 10);
		printf(CashName, "Verdana", 8, Font.BOLD, 90);
		printf(" ", "Verdana", 6, Font.BOLD, 80);
                printfnoLine("Voucher num  :", "Verdana", 8, Font.BOLD, 10);
		printf(ReceiptId, "Verdana", 11, Font.BOLD, 90);
                //printf(" ", "Verdana", 6, Font.BOLD, 80);
                printfnoLine("Customer name:", "Verdana", 8, Font.BOLD, 10);
		printf(CusName, "Verdana", 11, Font.BOLD, 90);
	}
}
