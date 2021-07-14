package ca.elecsoft.util;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Word {
    public static Word INSTANCE;

    private Word() {
    }


    public void writeFile(File filePath, List<BufferedImage> imageList, String errorMessage) {
        try {

            XWPFDocument docx = new XWPFDocument();
            XWPFRun run = docx.createParagraph().createRun();
            FileOutputStream out = new FileOutputStream(filePath);
            captureScreenShot(run, imageList);
            if (errorMessage != null) {
                run.setText(errorMessage);
            }
            TimeUnit.SECONDS.sleep(1);


            docx.write(out);
            out.flush();
            out.close();
            docx.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public BufferedImage takeBrowerSinglePhone(WebDriver driver) throws AWTException, IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(scrFile);
        return image;
    }

    public BufferedImage takeWindowSinglePhone() throws AWTException {
        BufferedImage image = new Robot()
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        return image;
    }


    public static void captureScreenShot(XWPFRun run, List<BufferedImage> imageList) throws Exception {

        String screenshot_name = System.currentTimeMillis() + ".png";
        for (BufferedImage image : imageList) {

            File file = new File("./" + screenshot_name);
            ImageIO.write(image, "png", file);
            InputStream pic = new FileInputStream("./" + screenshot_name);
            run.addBreak();
            run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(image.getWidth() / 6), Units.toEMU(image.getHeight() / 6));
            pic.close();
            file.delete();

        }

    }

    public static Word getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Word();
        }
        return INSTANCE;
    }
}
