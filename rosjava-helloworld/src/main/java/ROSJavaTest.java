
import lombok.extern.slf4j.Slf4j;
import org.ros.RosCore;
import org.ros.internal.node.server.master.MasterServer;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

import java.util.List;
import java.util.concurrent.TimeUnit;

public @Slf4j class ROSJavaTest {

    private static RosCore mRosCore;

    public static void main(String [] args) {
        mRosCore = RosCore.newPublic("192.168.1.244",11311);
        mRosCore.start();
        try {
            mRosCore.awaitStart(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Ros core started");

        startChatter();
        while (true) {

        }
    }

    private static void startChatter() {
        NodeMainExecutor e = DefaultNodeMainExecutor.newDefault();

        log.info("Starting listener node...");
        NodeConfiguration listenerConfig = NodeConfiguration.newPrivate();
        listenerConfig.setMasterUri(mRosCore.getUri());
        listenerConfig.setNodeName("Listener");
        NodeMain listener = new Listener();
        e.execute(listener, listenerConfig);

        log.info("Starting talker node...");
	    NodeConfiguration talkerConfig = NodeConfiguration.newPrivate();
	    talkerConfig.setMasterUri(mRosCore.getUri());
	    talkerConfig.setNodeName("Talker");
	    NodeMain talker = new Talker();
	    e.execute(talker, talkerConfig);
    }

}
