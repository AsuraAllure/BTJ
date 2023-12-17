package edu.MazeProject.Elements2DMaze;

public record Wall() implements NodeElements {
    @Override
    public NodeType getType() {
        return NodeType.WALL;
    }
}
