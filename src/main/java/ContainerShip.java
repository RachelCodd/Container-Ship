import java.util.Stack;

public class ContainerShip {
    private final Stack<Character>[] shipLayout;

    public ContainerShip(Stack<Character>[] shipLayout) {
        this.shipLayout = shipLayout;
    }

    public void moveContainer(int numberOfContainers, int moveFrom, int moveTo) {
        for (int i = 0; i < numberOfContainers; i++) {
            Stack<Character> lineToMoveFrom = shipLayout[moveFrom - 1];
            Character removedCharacter = lineToMoveFrom.pop();

            Stack<Character> lineToMoveTo = shipLayout[moveTo - 1];
            lineToMoveTo.push(removedCharacter);
        }
        //
    }

    public String getAnswer() {
        StringBuilder result = new StringBuilder();
        //Go through the array
        for (Stack<Character> stack : shipLayout) {
            result.append(stack.pop());
        }
        //Return string at the end
        return result.toString();
    }
}
