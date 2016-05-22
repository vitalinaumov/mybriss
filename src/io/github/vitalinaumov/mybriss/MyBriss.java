package io.github.vitalinaumov.mybriss;

import multivalent.Behavior;
import multivalent.Document;
import multivalent.ParseException;
import multivalent.std.adaptor.pdf.PDF;

import java.io.File;
import java.io.IOException;

class MyBriss {

  private static File loadPdf() {
    String pathname = "resource/example_040.pdf";
    return new File(pathname);
  }

  public static void main(String[] args) {
    System.out.println("Hello from MyBriss");
    File pdfFile = loadPdf();
    System.out.println(pdfFile.getAbsolutePath());

    PDF pdf = (PDF) Behavior.getInstance("AdobePDF", "AdobePDF", null, null, null);
    System.out.println("Analysing PDF pages");
    try {
      pdf.setInput(pdfFile);
      Document doc = new Document("doc", null, null);
      pdf.parse(doc);
      doc.clear();
      int pageCount = pdf.getReader().getPageCnt();
      System.out.println("Page count: " + pageCount);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}