import org.ros.RosCore;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

public class ROSConnect {

    RosCore rosCore;
    NodeMainExecutor e = DefaultNodeMainExecutor.newDefault();

    public ROSConnect()
    {
        rosCore = RosCore.newPublic(); //13111 is the ROS port.  if you are launching ros files from roscpp or rospy make sure to  specify the argument '-p 13111' when you run the launch file.
        rosCore.start();

        try {
            rosCore.awaitStart();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void publishChatter()
    {
        System.out.println("Starting talker node...");
        NodeConfiguration talkerConfig = NodeConfiguration.newPrivate();
        talkerConfig.setMasterUri(rosCore.getUri());
        talkerConfig.setNodeName("Talker");
        NodeMain talker = new Talker();
        e.execute(talker, talkerConfig);

        System.out.println("Starting listener node....");
        NodeConfiguration listenerConfig = NodeConfiguration.newPrivate();
        listenerConfig.setMasterUri(rosCore.getUri());
        listenerConfig.setNodeName("Listener");
        NodeMain listener = new Listener();
        e.execute(listener, listenerConfig);
    }
}