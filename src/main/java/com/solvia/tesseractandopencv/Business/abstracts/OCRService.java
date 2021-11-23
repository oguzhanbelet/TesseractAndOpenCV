package com.solvia.tesseractandopencv.Business.abstracts;

import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;
import org.springframework.web.multipart.MultipartFile;

public interface OCRService {
    TaxPlateDTO scanFile(MultipartFile file, boolean type);
    String scanFileTest(MultipartFile file);
}
