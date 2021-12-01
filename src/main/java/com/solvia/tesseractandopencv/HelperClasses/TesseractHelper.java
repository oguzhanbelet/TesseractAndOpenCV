package com.solvia.tesseractandopencv.HelperClasses;

import com.solvia.tesseractandopencv.DTO.TaxPlateDTO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageIOHelper;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TesseractHelper {



    private TesseractHelper(){
        throw new UnsupportedOperationException("You can not create this classes object.");
    }

    public static synchronized TaxPlateDTO OCRProcess(File file){

        nu.pattern.OpenCV.loadLibrary();

        try {
            ImageIO.write(CropHelper.crop(1,file), ImageIOHelper.getImageFileFormat(file), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Mat source = Imgcodecs.imread(file.getAbsolutePath());

        /*
        Mat destination = new Mat();

        for (int i = 0; i < 3; i++) {
            destination = new Mat(source.rows(), source.cols(), source.type());
            Imgproc.GaussianBlur(source, destination, new Size(0,0), 10);
            Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
            Imgcodecs.imwrite(file.getAbsolutePath(), destination);
            source = destination;
        }


        Imgproc.threshold(source, resultMat, 55,255, Imgproc.THRESH_BINARY);

         */
        Mat resultMat =  new Mat();
        Imgproc.threshold(source, resultMat, 175,255, Imgproc.THRESH_BINARY);

        Imgcodecs.imwrite(file.getAbsolutePath(), resultMat);

        File imageFile = new File(file.getAbsolutePath());

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/usr/local/Cellar/tesseract-lang/4.1.0/share/tessdata");
        tesseract.setPageSegMode(3);
        tesseract.setOcrEngineMode(3);
        tesseract.setLanguage("tur");

        tesseract.setTessVariable("user_defined_dpi", "300");



        List<String> listString = new ArrayList<>();



        try {

            ResizeHelper.resize(ImageIO.read(imageFile), file.getAbsolutePath());

            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.AD_SOYAD.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.VERGI_DAIRESI.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.TICARET_UNVANI.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.VERGI_KIMLIK_NO.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.ISYERI_ADRESI.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.TC_NO.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.VERGI_TURU.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.ISE_BASLAMA_TARIHI.getRectangle()));
            listString.add(tesseract.doOCR(imageFile, OCRLocationHelper.ANA_FAALIYET_KODU.getRectangle()));

            return DTOHelper.destroySpaces(listString);

        } catch (TesseractException | IOException e) {
            e.printStackTrace();
        }

        return null;

    }


}


        /*

        Mat destination = new Mat();

        for (int i = 0; i < 3; i++) {
            destination = new Mat(source.rows(), source.cols(), source.type());
            Imgproc.GaussianBlur(source, destination, new Size(0,0), 10);
            Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
            Imgcodecs.imwrite(file.getAbsolutePath(),destination);
            source = destination;
        }


                        //Imgproc.threshold(destination, resultMat, 55,255, Imgproc.THRESH_BINARY);


         */


//tesseract.setTessVariable("preserve_interword_spaces", "1");
//tesseract.setTessVariable("tessedit_use_reject_spaces", "1");
//tesseract.setTessVariable("tessedit_resegment_from_line_boxes","0");
