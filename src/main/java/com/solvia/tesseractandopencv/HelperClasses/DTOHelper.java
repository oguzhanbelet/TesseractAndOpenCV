package com.solvia.tesseractandopencv.HelperClasses;

import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;
import java.util.regex.*;

import java.util.List;

public class DTOHelper {

    private DTOHelper(){

    }

    public static TaxPlateDTO destroySpaces(List<String> list){

        TaxPlateDTO taxPlateDTO = new TaxPlateDTO();


        taxPlateDTO.setFullName(list.get(0).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setTaxOffice(list.get(1).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setTitle(list.get(2).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setTaxIdentityNumber(list.get(3).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setAddress(list.get(4).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setIdentityNumber(list.get(5).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setTaxType(list.get(6).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setStartJobDate(list.get(7).replace("|", "").replace("\n", "").trim());
        taxPlateDTO.setMainActivityNameAndCode(list.get(8).replace("|", "").replace("\n", "").trim());

        return taxPlateDTO;

    }
}
