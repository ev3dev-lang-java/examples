
import nodes.Listener;
import nodes.Talker;
import org.ros.RosCore;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class ListenerTest {

    private static RosCore mRosCore;

    public static void main(String [] args) throws UnknownHostException {

        for (String s: args) {
            System.out.println(s);
        }

        //String IP = "localhost";
        String IP = "192.168.1.244";
        if (args.length > 0) {
            IP = args[0];
        }

        mRosCore = RosCore.newPublic(IP, 11311);
        mRosCore.start();
        try {
            mRosCore.awaitStart(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ros core started");

        startChatter();

        //TODO Improve this way
        while (true) {}
    }

    private static void startChatter() throws UnknownHostException {

        NodeMainExecutor e = DefaultNodeMainExecutor.newDefault();

        System.out.println("Starting listener node...");
        NodeConfiguration listenerConfig = NodeConfiguration.newPublic(Inet4Address.getLocalHost().getHostAddress());
        listenerConfig.setMasterUri(mRosCore.getUri());
        listenerConfig.setNodeName("Listener");
        NodeMain listener = new Listener();
        e.execute(listener, listenerConfig);
    }

}
