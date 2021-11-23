package com.solvia.tesseractandopencv.HelperClasses;

import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageIOHelper;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TesseractHelper {

    private TesseractHelper(){
        throw new UnsupportedOperationException("You can not create this classes object.");
    }

    public static synchronized TaxPlateDTO OCRProcess(File file, boolean type){
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        nu.pattern.OpenCV.loadLibrary();

        try {
            ImageIO.write(CropHelper.crop(1,file), ImageIOHelper.getImageFileFormat(file), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Mat source = Imgcodecs.imread(file.getAbsolutePath());


        Mat resultMat =  new Mat();
        Imgproc.threshold(source, resultMat, 250,255, Imgproc.THRESH_BINARY);

        Imgcodecs.imwrite(file.getAbsolutePath(), resultMat);

        String result = null;
        File imageFile = new File(file.getAbsolutePath());

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/usr/local/Cellar/tesseract-lang/4.1.0/share/tessdata");
        tesseract.setPageSegMode(3);
        tesseract.setOcrEngineMode(3);
        tesseract.setLanguage("tur");

        tesseract.setTessVariable("user_defined_dpi", "300");

        //tesseract.setTessVariable("preserve_interword_spaces", "1");
        //tesseract.setTessVariable("tessedit_use_reject_spaces", "1");
        //tesseract.setTessVariable("tessedit_resegment_from_line_boxes","0");

        try {
            result = tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }

        return DTOHelper.destroySpaces(type,result);

    }

}
