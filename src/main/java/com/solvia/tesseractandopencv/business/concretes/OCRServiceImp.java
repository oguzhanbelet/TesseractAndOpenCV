package com.solvia.tesseractandopencv.business.concretes;

import com.solvia.tesseractandopencv.business.abstracts.OCRService;
import com.solvia.tesseractandopencv.dto.TaxPlateDTO;
import com.solvia.tesseractandopencv.helperclasses.ConvertHelper;
import com.solvia.tesseractandopencv.helperclasses.TesseractHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OCRServiceImp implements OCRService {

    @Override
    public TaxPlateDTO scanFile(MultipartFile file, String selectRotationType) {
       return TesseractHelper.ocrProcess(ConvertHelper.convertFile(file), selectRotationType);
    }

    @Override
    public String scanFileTest(MultipartFile file) {
        return null;
    }
}
