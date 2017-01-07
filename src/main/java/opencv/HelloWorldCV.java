package opencv;

import lombok.extern.slf4j.Slf4j;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public @Slf4j class HelloWorldCV {

    public static void main(String[] args) {
        log.info("Welcome to OpenCV {}", Core.VERSION);
        log.info(System.getProperty("java.library.path"));
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat m  = Mat.eye(3, 3, CvType.CV_8UC1);
        log.info("m = {}", m.dump());
    }

}