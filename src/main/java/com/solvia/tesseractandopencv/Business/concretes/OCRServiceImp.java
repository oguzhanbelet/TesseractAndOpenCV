package com.solvia.tesseractandopencv.Business.concretes;

import com.solvia.tesseractandopencv.Business.abstracts.OCRService;
import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;
import com.solvia.tesseractandopencv.HelperClasses.ConvertHelper;
import com.solvia.tesseractandopencv.HelperClasses.TesseractHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OCRServiceImp implements OCRService {

    @Override
    public TaxPlateDTO scanFile(MultipartFile file, boolean type) {
        return TesseractHelper.OCRProcess(ConvertHelper.convertFile(file), type);
    }

    @Override
    public String scanFileTest(MultipartFile file) {
        return null;
    }
}
