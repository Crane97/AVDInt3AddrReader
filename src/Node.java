import java.util.List;

public class Node {

    private Integer id;
    private Instruccion type;

    private Integer variable;

    private List<Node> parentNode;
    private List<Node> childrenNode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instruccion getType() {
        return type;
    }

    public void setType(Instruccion type) {
        this.type = type;
    }

    public Integer getVariable() {
        return variable;
    }

    public void setVariable(Integer variable) {
        this.variable = variable;
    }

    public List<Node> getParentNode() {
        return parentNode;
    }

    public void setParentNode(List<Node> parentNode) {
        this.parentNode = parentNode;
    }

    public List<Node> getChildrenNode() {
        return childrenNode;
    }

    public void setChildrenNode(List<Node> childrenNode) {
        this.childrenNode = childrenNode;
    }

    public void addParentNode(Node parentNode) {
        this.parentNode.add(parentNode);
    }

    public void addChildrenNode(Node childrenNode) {
        this.childrenNode.add(childrenNode);
    }

    public Node() {
    }

    public Node(Integer id, Instruccion type, Integer variable, List<Node> parentNode, List<Node> childrenNode) {
        this.id = id;
        this.type = type;
        this.variable = variable;
        this.parentNode = parentNode;
        this.childrenNode = childrenNode;
    }
}
