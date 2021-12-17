package com.solvia.tesseractandopencv.helperclasses;

import com.solvia.tesseractandopencv.dto.TaxPlateDTO;

import java.util.List;

public class DTOHelper {

    private DTOHelper(){

    }

    public static TaxPlateDTO destroySpaces(List<String> list){

        TaxPlateDTO taxPlateDTO = new TaxPlateDTO();


         list = list.stream().map(field -> field.replaceAll("[|]", "").replaceAll("[\n]", "").trim())
                        .toList();

        taxPlateDTO.setFullName(list.get(0));
        taxPlateDTO.setTaxOffice(list.get(1));
        taxPlateDTO.setTitle(list.get(2));
        taxPlateDTO.setTaxIdentityNumber(list.get(3).replaceAll("[^0-9]", ""));
        taxPlateDTO.setAddress(list.get(4));
        taxPlateDTO.setIdentityNumber(list.get(5).replaceAll("[^0-9]", ""));
        taxPlateDTO.setTaxType(list.get(6));
        taxPlateDTO.setStartJobDate(list.get(7));
        taxPlateDTO.setMainActivityNameAndCode(list.get(8));

        return taxPlateDTO;

    }
}

