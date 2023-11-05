package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.MazeGenerators.MazeGenerator;
import edu.MazeProject.Representer.StandartMazeRepresenter;
import edu.MazeProject.Structures.RectangleMazeStructures;
import java.util.List;

public class Maze2D {
    private final RectangleMazeStructures mazeStructures;
    private final StandartMazeRepresenter representer;
    public Maze2D(MazeGenerator generator2D, StandartMazeRepresenter repr){
        representer = repr;
        mazeStructures = generator2D.generate();
    }
    public void print(){
        representer.print(mazeStructures);
    }
    public void printPath(List<CordNode> l){
        representer.printPath(mazeStructures, l);
    }
}
