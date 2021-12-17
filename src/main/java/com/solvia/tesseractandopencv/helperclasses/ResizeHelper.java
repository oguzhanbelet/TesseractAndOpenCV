package com.solvia.tesseractandopencv.helperclasses;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ResizeHelper {

    private ResizeHelper(){
        throw new UnsupportedOperationException("This class can not created!");
    }

    public static void resize(BufferedImage image, String pathname){
        Mat src = bufferedToMat(image);
        Objects.requireNonNull(src, "conversion failed");
        Mat dst = new Mat(src.rows(), src.cols(), src.type());
        Imgproc.resize(src, dst, new Size(2273, 811));
        Imgcodecs.imwrite(pathname, dst);
    }

    public static Mat bufferedToMat(BufferedImage image){
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

    public static void processImage(File file) throws IOException {
        try{
            Mat src = bufferedToMat(ImageIO.read(file));
            Objects.requireNonNull(src, "conversion failed!");
            Mat dst = new Mat(src.rows(), src.cols(), src.type());
            Imgproc.GaussianBlur(src, dst, new Size(0, 0),5);
            Core.addWeighted(src, 1.5, src, -0.3, -55, dst);
            Imgcodecs.imwrite(file.getAbsolutePath(), dst);
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

}
