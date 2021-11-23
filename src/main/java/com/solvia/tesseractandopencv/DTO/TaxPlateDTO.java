package com.solvia.tesseractandopencv.DTO;

import java.time.LocalDate;

//PERFORMS THE DTO TRANSFER OPERATION..
public class TaxPlateDTO {
    private String fullName;
    private String title;
    private String address;
    private String taxOffice;
    private String taxType;
    private String taxIdentityNumber;
    private String identityNumber;
    private String startJobDate;
    private String mainActivityNameAndCode;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxIdentityNumber() {
        return taxIdentityNumber;
    }

    public void setTaxIdentityNumber(String taxIdentityNumber) {
        this.taxIdentityNumber = taxIdentityNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getStartJobDate() {
        return startJobDate;
    }

    public void setStartJobDate(String startJobDate) {
        this.startJobDate = startJobDate;
    }

    public String getMainActivityNameAndCode() {
        return mainActivityNameAndCode;
    }

    public void setMainActivityNameAndCode(String mainActivityNameAndCode) {
        this.mainActivityNameAndCode = mainActivityNameAndCode;
    }
}
