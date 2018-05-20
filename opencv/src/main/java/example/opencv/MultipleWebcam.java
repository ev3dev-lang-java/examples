package example.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

/**
 * Multiple webcams
 *
 */
public class MultipleWebcam {

    public static void main( String[] args ) {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        for(int i = 0; i < 3; i++) {

            VideoCapture camera = new VideoCapture(i);
            if (!camera.isOpened()) {
                System.out.println("Camera Error");
            }

            Mat frame = new Mat();
            camera.read(frame);
            System.out.println("Frame Obtained");
            System.out.println("Captured Frame Width " + frame.width());

            Highgui.imwrite("camera" + i +".jpg", frame);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Iteration:" + i);

            camera.release();
        }
    }
}
