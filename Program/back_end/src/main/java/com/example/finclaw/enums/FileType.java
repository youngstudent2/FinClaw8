package com.example.finclaw.enums;

public enum FileType {
    pdf("pdf"),
    doc("doc"),
    docx("docx"),
    csv("csv"),
    xlsx("xlsx"),
    md("md"),
    txt("txt");

    private final String value;

   FileType(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
