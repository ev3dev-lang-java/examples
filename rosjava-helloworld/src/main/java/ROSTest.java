import org.ros.RosCore;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

public class ROSTest {

    private static RosCore rosCore;
    private static NodeMainExecutor executor = DefaultNodeMainExecutor.newDefault();

    public static void main(String[] args) {
    /*13111 is the ROS port. if you are launching ros files 
      from roscpp or rospy make sure to specify the argument '-p 13111'
      when you run the launch file.*/
        rosCore = RosCore.newPublic(13111);
        rosCore.start();

        try {
            rosCore.awaitStart();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        execute("Talker", new Talker());
        execute("Listener", new Listener());
    }

    private static void execute(String name, NodeMain node)
    {
        System.out.println("Starting " + name + " node...");
        NodeConfiguration config = NodeConfiguration.newPrivate();
        config.setMasterUri(rosCore.getUri());
        config.setNodeName(name);
        executor.execute(node, config);
    }
}