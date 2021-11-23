package com.solvia.tesseractandopencv.HelperClasses;

import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;

public class DTOHelper {

    private DTOHelper(){

    }



    public static TaxPlateDTO destroySpaces(boolean bool, String string){

        TaxPlateDTO taxPlateDTO = new TaxPlateDTO();

        //StringBuilder stringBuilder = new StringBuilder();

        String[] stringArray = string.split("\n");

        if(bool){
            taxPlateDTO.setTitle(stringArray[0].substring(0,stringArray[0].lastIndexOf(".")+1));
            taxPlateDTO.setTaxIdentityNumber((stringArray[1]));
            taxPlateDTO.setAddress(stringArray[stringArray.length-7] + " " + stringArray[stringArray.length-6]);
            taxPlateDTO.setTaxType(stringArray[stringArray.length-4].substring(0,stringArray[stringArray.length-4].length()-10));
            taxPlateDTO.setStartJobDate(stringArray[stringArray.length-4].substring(stringArray[stringArray.length-4].length()-10));
            taxPlateDTO.setMainActivityNameAndCode(stringArray[stringArray.length-2] + " " + stringArray[stringArray.length-1]);
            /*
            stringBuilder.append("Ticaret Ünvanı: ").append(stringArray[0].substring(0,stringArray[0].lastIndexOf(".")+1)).append("\n");
            stringBuilder.append("VergiKimlik: ").append(stringArray[1]).append("\n");
            stringBuilder.append("Adres: ").append(stringArray[stringArray.length-7]).append(" ").append(stringArray[stringArray.length-6]).append("\n");
            stringBuilder.append("Vergi Türü: ").append(stringArray[stringArray.length-4].substring(0,stringArray[stringArray.length-4].length()-10)).append("\n");
            stringBuilder.append("İşe Başlama Tarihi: ").append(stringArray[stringArray.length-4]
                    .substring(stringArray[stringArray.length-4].length()-10)).append("\n");
            stringBuilder.append("Faaliyet Raporu: ").append(stringArray[stringArray.length-2]).append(" ").append(stringArray[stringArray.length-1]);

             */
        }
        else{

            taxPlateDTO.setFullName(stringArray[0].substring(0,stringArray[0].lastIndexOf(" ")));
            taxPlateDTO.setTaxOffice(stringArray[0].substring(stringArray[0].lastIndexOf(" ")));
            taxPlateDTO.setTaxIdentityNumber((stringArray[2]));
            taxPlateDTO.setAddress(stringArray[stringArray.length-9] + " " + stringArray[stringArray.length-8]);
            //taxPlateDTO.setIdentityNumber(stringArray[stringArray.length-9].substring(stringArray[stringArray.length-9].lastIndexOf("/"),stringArray[stringArray.length-9].lastIndexOf("/")+11));
            taxPlateDTO.setTaxType(stringArray[stringArray.length-4].substring(0,stringArray[stringArray.length-4].length()-10));
            taxPlateDTO.setStartJobDate(stringArray[stringArray.length-4].substring(stringArray[stringArray.length-4].length()-10));
            taxPlateDTO.setMainActivityNameAndCode(stringArray[stringArray.length-2] + " " + stringArray[stringArray.length-1]);

            /*
            stringBuilder.append("Ad SOYAD: ").append(stringArray[0].substring(0,stringArray[0].lastIndexOf(" "))).append("\n");
            stringBuilder.append("Vergi Dairesi: ").append(stringArray[0].substring(stringArray[0].lastIndexOf(" "))).append("\n");
            stringBuilder.append("VergiKimlik: ").append(stringArray[2]).append("\n");
            stringBuilder.append("Adres: ").append(stringArray[stringArray.length-8]).append(" ").append(stringArray[stringArray.length-7]).append("\n");
            stringBuilder.append("Vergi Türü: ").append(stringArray[stringArray.length-4].substring(0,stringArray[stringArray.length-4].length()-10)).append("\n");
            stringBuilder.append("İşe Başlama Tarihi: ").append(stringArray[stringArray.length-4]
                    .substring(stringArray[stringArray.length-4].length()-10)).append("\n");
            stringBuilder.append("Faaliyet Raporu: ").append(stringArray[stringArray.length-2]).append(" ").append(stringArray[stringArray.length-1]);

             */
        }
        return taxPlateDTO;

    }
}
