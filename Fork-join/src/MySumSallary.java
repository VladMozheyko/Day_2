import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MySumSallary extends RecursiveTask<Float> {
    private Node node;

    public MySumSallary(Node node) {
        this.node = node;
    }

    @Override
    protected Float compute() {
        float salary = 0;
        if(node.getNodeName().equals("salary"))  {
            salary = Float.parseFloat(node.getTextContent());
        }
        List<MySumSallary> subTask = new ArrayList<>();
        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            MySumSallary task = new MySumSallary(nl.item(i));
            task.fork();
            subTask.add(task);
        }

        return salary;
    }
}
