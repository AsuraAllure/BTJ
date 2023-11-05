package edu.MazeProject.Maze2D.Elements2DMaze;

public class RectangleMazeNode2D {
    private NodeElements top;
    private NodeElements left;
    private NodeElements bot;
    private NodeElements right;

    public RectangleMazeNode2D(
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
