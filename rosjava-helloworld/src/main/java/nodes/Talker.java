package nodes;

import org.ros.concurrent.CancellableLoop;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;

public class Talker extends AbstractNodeMain {

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("Talker");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {

        final Publisher<std_msgs.String> publisher = connectedNode.newPublisher("chatter", std_msgs.String._TYPE);
        connectedNode.executeCancellableLoop(new CancellableLoop() {
            private int sequence = 0;

            @Override
            protected void loop() throws InterruptedException {
                std_msgs.String str = publisher.newMessage();
                str.setData("Hello World" + sequence);
                publisher.publish(str);
                sequence++;
                Thread.sleep(1000);
            }
        });
    }

}