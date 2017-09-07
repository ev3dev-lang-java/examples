package ev3dev.sensors.mindsensors;

import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

/**
 * <b>Mindsensors AbsoluteIMU</b><br>
 * Sensor interface for the Mindsensors AbsoluteIMU family of sensors. The
 * AbsoluteIMU sensors combine gyro, accelerometer and compass sensors in
 * various combinations in a single housing. This interface works with all
 * AbsoluteIMU models, but not all modes will work with any particular model.
 *
 *
 * <p>
 * <table border=1>
 * <tr>
 * <th colspan=4>Supported modes</th>
 * </tr>
 * <tr>
 * <th>Mode name</th>
 * <th>Description</th>
 * <th>unit(s)</th>
 * <th>Getter</th>
 * </tr>
 * <tr>
 * <td>Magnetic</td>
 * <td>Measures the strength of the magnetic field over three axes</td>
 * <td></td>
 * <td> {getMagneticMode() }</td>
 * </tr>
 * <tr>
 * <td>Compass</td>
 * <td>Measures the orientation of the sensor</td>
 * <td>Degrees, corresponding to the compass rose</td>
 * <td> {getCompassMode() }</td>
 * </tr>
 * <tr>
 * <td>Angle</td>
 * <td>Measures the orientation of the sensor</td>
 * <td>Degrees, corresponding to the right hand coordinate system</td>
 * <td> {getAngleMode() }</td>
 * </tr>
 * <tr>
 * <td>Acceleration</td>
 * <td>The Acceleration mode measures the linear acceleration of the sensor over
 * three axes</td>
 * <td>Metres/second^2</td>
 * <td> {getAccelerationMode() }</td>
 * </tr>
 * <tr>
 * <td>Rate</td>
 * <td>The Rate mode measures the angular speed of the sensor over three axes</td>
 * <td>Degrees/second</td>
 * <td> {getRateMode() }</td>
 * </tr>
 * </table>
 *
 *
 * <p>
 *
 * <b>Sensor configuration</b><br>
 * The gyro sensor of the AbsoluteIMU uses a filter to remove noise from
 * the samples. The filter can be configured using the {setGyroFilter }
 * method. <br>
 * The compass sensor of the AbsoluteIMU can be calibrated to compensate for magnetical disturbances on the robot (soft iron
 * calibration) using the {#startCalibration} and {stopCalibration}
 * methods.<p>
 *   To calibrate Compass, mount it on your robot where it will be used and
 * issue startCalibration method and then rotate AbsoluteIMU slowly along all
 * three axes. (The Compass in AbsoluteIMU is a 3 axis compass, and hence
 * needs to be turned along all three axes, and if it's mounted on your robot,
 * the whole robot needs to rotate). Rotate one axis at a time, turn once in
 * clock-wise direction completing at-least 360 degrees, and then turn it in
 * anti-clock-wise direction, then go to next axis. Upon finishing turning
 * along all axes, issue stopCalibration method.
 *
 *
 * <p>
 *
 * See <a href=
 *      "http://mindsensors.com/index.php?module=documents&JAS_DocumentManager_op=downloadFile&JAS_File_id=1369"
 *      >Mindsensors IMU user guide"> Sensor Product page </a>
 * See <a href="http://sourceforge.net/p/lejos/wiki/Sensor%20Framework/"> The
 *      leJOS sensor framework</a>
 * See {@link lejos.robotics.SampleProvider leJOS conventions for
 *      SampleProviders}
 *
 *      <p>
 *
 *
 * @author Andy, Juan Antonio Breña Moral
 *
 */
public class AbsoluteIMUTiltTest {

    private static int HALF_SECOND = 500;

    public static void main(String[] args) {

        System.out.println("Absolute IMU Demo");

        final AbsoluteIMU absoluteIMU = new AbsoluteIMU(SensorPort.S1);
        SampleProvider sp = absoluteIMU.getTiltMode();

        int sampleSize = sp.sampleSize();
        System.out.println("Sample Size:" + sampleSize);
        float[] sample = new float[sampleSize];

        // Takes some samples and prints them
        for (int i = 0; i < 10; i++) {
            sp.fetchSample(sample, 0);

            System.out.println("N={} Sample={}" + i + " " +  sample[0]);
            System.out.println("N={} Sample={}" + i + " " +  sample[1]);
            System.out.println("N={} Sample={}" + i + " " +  sample[2]);

            Delay.msDelay(HALF_SECOND);

        }


    }

}
