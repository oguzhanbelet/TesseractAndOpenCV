package com.solvia.tesseractandopencv.HelperClasses;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ResizeHelper {

    private ResizeHelper(){
        throw new UnsupportedOperationException("bida açtını görmiyim burayı senyora şikayet ederim vallah");
    }

    public static void resize(BufferedImage image, String pathname){
        Mat src = BufferedToMat(image);
        Mat dst = new Mat(src.rows(), src.cols(), src.type());
        if (src!=null){
            Imgproc.resize(src, dst, new Size(2273, 811));
        }
        Imgcodecs.imwrite(pathname, dst);
    }

    public static Mat BufferedToMat(BufferedImage image){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_UNCHANGED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
