package com.example.zdemo.Im.util.model.msg.content;

public interface IMsgContent {

  enum M_TYPE {

    CustomType("CustomElem"), TextType("TextElem"), ImgType("ImgElem"), BusType("BusElem") ;

    private String msyType;

    M_TYPE(String msyType) {
      this.msyType = msyType;
    }

    public String getMsyType() {
      return msyType;
    }

  }

}
