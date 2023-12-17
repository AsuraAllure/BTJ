package edu.MazeProject.Elements2DMaze;

public record Pass() implements NodeElements {
    @Override
    public NodeType getType() {
        return NodeType.PASS;
    }
}
