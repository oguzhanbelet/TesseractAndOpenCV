package com.solvia.tesseractandopencv.HelperClasses;

import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;
import java.util.regex.*;

import java.util.List;
import java.util.stream.Collectors;

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

