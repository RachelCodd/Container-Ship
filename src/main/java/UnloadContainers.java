import Util.ReadUtil;

import java.util.List;
import java.util.Stack;

public class UnloadContainers {

    public static void main(String[] args) {

        String moveData = System.getProperty("user.dir")+"\\src\\main\\resources\\data.txt";
        String layoutData = System.getProperty("user.dir")+"\\src\\main\\resources\\ContainerLayouts\\dataLayout.txt";

        if (args.length == 2) {
            moveData = args[0];
            layoutData = args[1];
        }

        //Create container ship
        Stack<Character>[] shipLayout = ReadUtil.getShipLayout(layoutData);
        ContainerShip containerShip = new ContainerShip(shipLayout);

        //Process containers
        List<Integer> moves = ReadUtil.extractMovesFromFile(moveData);
        for (int i = 0; i < moves.size(); i = i + 3) {
            containerShip.moveContainer(moves.get(i), moves.get(i + 1), moves.get(i + 2));
        }

        //Reveal message
        System.out.println("Answer is " + containerShip.getAnswer());
    }
}
