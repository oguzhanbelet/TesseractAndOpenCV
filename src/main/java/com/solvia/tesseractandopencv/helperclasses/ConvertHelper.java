package com.solvia.tesseractandopencv.helperclasses;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertHelper {

    private ConvertHelper(){
        throw new UnsupportedOperationException();
    }

    public static File convertFile(MultipartFile multipartFile) {

        final Logger logger = Logger.getLogger(ConvertHelper.class.getName());

        try{

            File convertedFile = new File(multipartFile.getOriginalFilename());
            try (FileOutputStream fileOutputStream = new FileOutputStream(convertedFile)) {
                fileOutputStream.write(multipartFile.getBytes());
            }
            return convertedFile;
        }
        catch (IOException ex) {
            logger.log(Level.WARNING, ex.getLocalizedMessage());
            return null;
        }

    }
}
