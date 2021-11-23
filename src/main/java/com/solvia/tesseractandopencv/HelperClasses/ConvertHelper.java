package com.solvia.tesseractandopencv.HelperClasses;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertHelper {

    public static File convertFile(MultipartFile multipartFile) {

        try{

            File convertedFile = new File(multipartFile.getOriginalFilename());
            FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
            fileOutputStream.write(multipartFile.getBytes());
            return convertedFile;
        }
        catch (IOException ex) {

            System.out.println(ex.getLocalizedMessage());
            return null;
        }

    }
}
