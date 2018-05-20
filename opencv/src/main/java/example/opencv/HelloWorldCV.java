package example.opencv;

import lombok.extern.slf4j.Slf4j;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

@Slf4j
public class HelloWorldCV {

    public static void main(String[] args) {
        LOGGER.info("Welcome to OpenCV {}", Core.VERSION);
        LOGGER.info(System.getProperty("java.library.path"));
        LOGGER.info(Core.NATIVE_LIBRARY_NAME);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //System.loadLibrary("libopencv_java249.so");
        Mat m  = Mat.eye(3, 3, CvType.CV_8UC1);
        LOGGER.info("m = {}", m.dump());
    }

}