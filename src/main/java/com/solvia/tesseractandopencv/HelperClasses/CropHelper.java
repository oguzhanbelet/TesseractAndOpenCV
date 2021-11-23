package com.solvia.tesseractandopencv.HelperClasses;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CropHelper {

    private CropHelper(){
        System.out.println("You can not create this classes object.");
    }

    public static BufferedImage crop(double amount, File file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file);
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();

        double targetWidth = (width * amount) * 0.95;
        double targetHeight = (height * amount) * 0.49;
        // Coordinates of the image's middle
        int xc = (int) ((width - targetWidth) / 1.25);
        int yc = (int) ((height - targetHeight*1.5) / 2);

        // Crop
        BufferedImage croppedImage = originalImage.getSubimage(
                xc,
                yc,
                (int)targetWidth, // widht
                (int)targetHeight // height
        );
        return croppedImage;
    }
}
