package com.solvia.tesseractandopencv.controller.concretes;

import ch.qos.logback.core.boolex.EvaluationException;
import com.solvia.tesseractandopencv.business.abstracts.OCRService;
import com.solvia.tesseractandopencv.dto.TaxPlateDTO;
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
    public TaxPlateDTO scanFile(@RequestParam("file") MultipartFile file, @RequestParam(value = "rotate", required = false) String selectRotatationType){
        return this.ocrService.scanFile(file, selectRotatationType);
    }

    @PostMapping("/scanFileTest")
    public String scanFileTest(@RequestParam("file") MultipartFile file){
        return this.ocrService.scanFileTest(file);
    }
}
