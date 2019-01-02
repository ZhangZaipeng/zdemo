package com.example.zdemo.Pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import java.io.IOException;

public class PDFFont {

  public static BaseFont baseFont;

  static {
    try {
      baseFont = BaseFont.createFont("STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
    } catch (DocumentException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Font fontChinese16 = new Font(baseFont, 16, Font.BOLD);

  public static Font fontChinese10 = new Font(baseFont, 10, Font.NORMAL);
}
