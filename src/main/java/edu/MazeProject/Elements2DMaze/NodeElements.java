package edu.MazeProject.Elements2DMaze;

public interface NodeElements {
    NodeType getType();

    enum NodeType {
        WALL,
        PASS
    }

}
