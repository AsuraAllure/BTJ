package edu.MazeProject.Elements2DMaze;

public class MazeNode {
    private NodeElements top;
    private NodeElements left;
    private NodeElements bot;
    private NodeElements right;

    public MazeNode(
        NodeElements top,
        NodeElements left,
        NodeElements bot,
        NodeElements right
    ) {
        this.top = top;
        this.right = right;
        this.bot = bot;
        this.left = left;
    }

    @Override
    public boolean equals(Object obj){
        if (obj.getClass() != MazeNode.class)
            return false;
        MazeNode another = (MazeNode) obj;
        return bot.equals(another.bot)
            && top.equals(another.top)
            && left.equals(another.left)
            && right.equals(another.right);
    }
    @Override
    public int hashCode(){
        return top.hashCode()
            ^ bot.hashCode()
            ^ left.hashCode()
            ^ right.hashCode();
    }

    public NodeElements getRight() {
        return right;
    }

    public void setRight(NodeElements right) {
        this.right = right;
    }

    public NodeElements getBot() {
        return bot;
    }

    public void setBot(NodeElements bot) {
        this.bot = bot;
    }

    public NodeElements getLeft() {
        return left;
    }

    public void setLeft(NodeElements left) {
        this.left = left;
    }

    public NodeElements getTop() {
        return top;
    }

    public void setTop(NodeElements top) {
        this.top = top;
    }
}
