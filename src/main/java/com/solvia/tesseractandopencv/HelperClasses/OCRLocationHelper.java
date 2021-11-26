package com.solvia.tesseractandopencv.HelperClasses;

import java.awt.*;

public enum OCRLocationHelper {
    AD_SOYAD(new Rectangle(371,16,1050,125)),
    TICARET_UNVANI(new Rectangle(365,167,1050,100)),
    ISYERI_ADRESI(new Rectangle(365,321,1050,125)),
    VERGI_TURU(new Rectangle(365,492,1050,125)),
    TC_NO(new Rectangle(1707,325,1050,125)),
    ANA_FAALIYET_KODU(new Rectangle(365,640,2500,125)),
    VERGI_DAIRESI(new Rectangle(1709,16,1050,125)),
    VERGI_KIMLIK_NO(new Rectangle(1707,253,1050,80)),
    ISE_BASLAMA_TARIHI(new Rectangle(1707,460,1050,125));

    public Rectangle getRectangle() {
        return rectangle;
    }

    OCRLocationHelper(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    private final Rectangle rectangle;
}
