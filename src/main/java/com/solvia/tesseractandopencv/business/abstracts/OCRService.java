package com.solvia.tesseractandopencv.business.abstracts;

import com.solvia.tesseractandopencv.dto.TaxPlateDTO;
import org.springframework.web.multipart.MultipartFile;

public interface OCRService {
    TaxPlateDTO scanFile(MultipartFile file, String selectRotationType);
    String scanFileTest(MultipartFile file);
}
