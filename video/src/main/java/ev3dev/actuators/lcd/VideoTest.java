package ev3dev.actuators.lcd;

import ev3dev.actuators.LCD;
import lejos.hardware.lcd.GraphicsLCD;
import org.jcodec.api.FrameGrab;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoTest {

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(final String[] args) throws Exception {

        JarResource.export("/" + "giphy.mp4");

        clear();

        List<BufferedImage> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Picture pic = FrameGrab.getFrameFromFile(new File("giphy.mp4"), i*6);
            BufferedImage image = AWTUtil.toBufferedImage(pic);

            int w = image.getWidth();
            int h = image.getHeight();
            BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            AffineTransform at = new AffineTransform();
            at.scale(0.5, 0.5);
            AffineTransformOp scaleOp =
                    new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            after = scaleOp.filter(image, after);

            list.add(after);
            System.out.println(i);
        }

        while(true) {
            list.stream()
                .forEach(x->{
                    lcd.drawImage(x,0,0,0);
                    lcd.refresh();
                });
        }

        //JarResource.delete("giphy.mp4");

    }

    public static void clear(){
        lcd.setColor(lejos.robotics.Color.WHITE);
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());
    }
}
