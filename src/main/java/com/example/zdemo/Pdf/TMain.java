package com.example.zdemo.Pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.Cell;

public class TMain {

  public static void main(String[] args) throws IOException, DocumentException {
    Document document =  new  Document();
    PdfWriter.getInstance(document, new FileOutputStream("D:/hello.pdf"));
    document.open();

    // 标题
    PdfPTable table_1 = new PdfPTable(1);
    table_1.setWidthPercentage(95);
    PdfPCell cell_11 = new PdfPCell(
        new Paragraph("钢 筋 检 查 记 录 表", PDFFont.fontChinese16));
    cell_11.setBorderColor(BaseColor.BLACK);
    cell_11.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_11.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_11.setMinimumHeight(25);

    table_1.addCell(cell_11);
    document.add(table_1);

    // 施工单位
    PdfPTable table_2 = new PdfPTable(2);
    table_2.setWidthPercentage(95);
    table_2.setWidths(new float[] {50, 50});

    PdfPCell cell_21 = new PdfPCell(
        new Paragraph("施工单位：", PDFFont.fontChinese10));
    cell_21.setBorderColor(BaseColor.BLACK);
    cell_21.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell_21.setUseAscender(true);
    cell_21.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_21.setMinimumHeight(15);

    PdfPCell cell_22 = new PdfPCell(
        new Paragraph("合同号：", PDFFont.fontChinese10));
    cell_22.setBorderColor(BaseColor.BLACK);
    cell_22.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell_22.setUseAscender(true);
    cell_22.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_22.setMinimumHeight(15);

    // add to document
    table_2.addCell(cell_21);
    table_2.addCell(cell_22);
    document.add(table_2);

    // 监理
    PdfPTable table_3 = new PdfPTable(2);
    table_3.setWidthPercentage(95);
    table_3.setWidths(new float[] {50, 50});

    PdfPCell cell_31 = new PdfPCell(
        new Paragraph("监理单位：", PDFFont.fontChinese10));
    cell_31.setBorderColor(BaseColor.BLACK);
    cell_31.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell_31.setUseAscender(true);
    cell_31.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_31.setMinimumHeight(15);

    PdfPCell cell_32 = new PdfPCell(
        new Paragraph("编 号：", PDFFont.fontChinese10));
    cell_32.setBorderColor(BaseColor.BLACK);
    cell_32.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell_32.setUseAscender(true);
    cell_32.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_32.setMinimumHeight(15);

    // add to document
    table_3.addCell(cell_31);
    table_3.addCell(cell_32);
    document.add(table_3);


    PdfPTable table_4 = new PdfPTable(4);
    table_4.setWidthPercentage(95);
    table_4.setWidths(new float[] {15, 35, 15, 35});

    PdfPCell cell_41 = new PdfPCell(
        new Paragraph("分项工程名称", PDFFont.fontChinese10));
    cell_41.setBorderColor(BaseColor.BLACK);
    cell_41.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_41.setUseAscender(true);
    cell_41.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_41.setMinimumHeight(15);

    PdfPCell cell_42 = new PdfPCell(
        new Paragraph(" ", PDFFont.fontChinese10));
    cell_42.setBorderColor(BaseColor.BLACK);
    cell_42.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_42.setUseAscender(true);
    cell_42.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_42.setMinimumHeight(15);

    PdfPCell cell_43 = new PdfPCell(
        new Paragraph("施工时间", PDFFont.fontChinese10));
    cell_43.setBorderColor(BaseColor.BLACK);
    cell_43.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_43.setUseAscender(true);
    cell_43.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_43.setMinimumHeight(15);

    PdfPCell cell_44 = new PdfPCell(
        new Paragraph(" ", PDFFont.fontChinese10));
    cell_44.setBorderColor(BaseColor.BLACK);
    cell_44.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_44.setUseAscender(true);
    cell_44.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_44.setMinimumHeight(15);

    // add to document
    table_4.addCell(cell_41);
    table_4.addCell(cell_42);
    table_4.addCell(cell_43);
    table_4.addCell(cell_44);
    document.add(table_4);

    PdfPTable table_5 = new PdfPTable(4);
    table_5.setWidthPercentage(95);
    table_5.setWidths(new float[] {15, 35, 15, 35});

    PdfPCell cell_51 = new PdfPCell(
        new Paragraph("桩号及部位", PDFFont.fontChinese10));
    cell_51.setBorderColor(BaseColor.BLACK);
    cell_51.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_51.setUseAscender(true);
    cell_51.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_51.setMinimumHeight(15);

    PdfPCell cell_52 = new PdfPCell(
        new Paragraph(" ", PDFFont.fontChinese10));
    cell_52.setBorderColor(BaseColor.BLACK);
    cell_52.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_52.setUseAscender(true);
    cell_52.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_52.setMinimumHeight(15);

    PdfPCell cell_53 = new PdfPCell(
        new Paragraph("检验时间", PDFFont.fontChinese10));
    cell_53.setBorderColor(BaseColor.BLACK);
    cell_53.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_53.setUseAscender(true);
    cell_53.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_53.setMinimumHeight(15);

    PdfPCell cell_54 = new PdfPCell(
        new Paragraph(" ", PDFFont.fontChinese10));
    cell_54.setBorderColor(BaseColor.BLACK);
    cell_54.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell_54.setUseAscender(true);
    cell_54.setVerticalAlignment(Element.ALIGN_CENTER);
    cell_54.setMinimumHeight(15);

    // add to document
    table_5.addCell(cell_51);
    table_5.addCell(cell_52);
    table_5.addCell(cell_53);
    table_5.addCell(cell_54);
    document.add(table_5);

    document.close();
  }
}
