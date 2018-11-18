package com.example.zdemo.Im;

public interface MsgContent {
  enum M_TYPE {
    CustomType("TIMCustomElem");
    private String msyType;

    M_TYPE(String msyType) {
      this.msyType = msyType;
    }

    public String getMsyType() {
      return msyType;
    }
  }
}
