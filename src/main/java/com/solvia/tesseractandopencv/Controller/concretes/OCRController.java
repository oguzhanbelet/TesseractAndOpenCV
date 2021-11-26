package com.solvia.tesseractandopencv.Controller.concretes;

import com.solvia.tesseractandopencv.Business.abstracts.OCRService;
import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/solvia/api")
public class OCRController {
    private final OCRService ocrService;

    @Autowired
    public OCRController(OCRService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("/scanFile")
    public TaxPlateDTO scanFile(@RequestParam("file") MultipartFile file){
        return this.ocrService.scanFile(file);
    }

    @PostMapping("/scanFileTest")
    public String scanFileTest(@RequestParam("file") MultipartFile file){
        return this.ocrService.scanFileTest(file);
    }
}
