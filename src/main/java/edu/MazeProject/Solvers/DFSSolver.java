package edu.MazeProject.Solvers;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.Elements2DMaze.Pass;
import edu.MazeProject.Structures.RectangleMazeStructures;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSSolver {
    public List<CordNode> solve(RectangleMazeStructures maze, CordNode start, CordNode finish){
        if(start.equals(finish))
            return List.of(start);

        // map: end -> start. Moving from start to finish.
        HashMap<CordNode, CordNode> pathBetweenNode = new HashMap<>();
        Stack<PairCord> potential = new Stack<>();

        potential.add(new PairCord(start, start));

        while(!potential.isEmpty()){
            PairCord next = potential.pop();
            pathBetweenNode.put(next.c2(), next.c1());

            CordNode cordNode = next.c2();

            if (next.c2() == finish)
                break;

            MazeNode node = maze.get(cordNode);
            CordNode nextNode;
            if (node.getBot().getClass().equals(Pass.class)) {
                nextNode = new CordNode(cordNode.i() + 1, cordNode.j());
                if (!pathBetweenNode.containsKey(nextNode))
                    potential.push(new PairCord(cordNode, nextNode));
            }

            if (node.getLeft().getClass().equals(Pass.class)) {
                nextNode = new CordNode(cordNode.i(), cordNode.j() - 1);
                if (!pathBetweenNode.containsKey(nextNode))
                    potential.push(new PairCord(cordNode, nextNode));
            }

            if (node.getRight().getClass().equals(Pass.class)) {
                nextNode = new CordNode(cordNode.i(), cordNode.j()+1);
                if (!pathBetweenNode.containsKey(nextNode))
                    potential.push(new PairCord(cordNode, nextNode));
            }

            if (node.getTop().getClass().equals(Pass.class)){
                nextNode = new CordNode(cordNode.i() - 1, cordNode.j());
                if (!pathBetweenNode.containsKey(nextNode))
                    potential.push(new PairCord(cordNode, nextNode));
            }
        }
        List<CordNode> resultList = new LinkedList<>();
        CordNode node = finish;

        if(!pathBetweenNode.containsKey(finish))
            return new ArrayList<>();

        while(pathBetweenNode.get(node) != start){
            resultList.add(node);
            node = pathBetweenNode.get(node);
        }
        resultList.add(node);
        resultList.add(start);

        return resultList;
    }
}
