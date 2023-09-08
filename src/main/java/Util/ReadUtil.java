package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ReadUtil {
    public static Stack<Character>[] getShipLayout(String filename) {
        Stack<Character>[] shipLayout;
        LinkedList<String> stringList = new LinkedList<>();

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e)  {
            System.out.println("An error occurred getting the ship layout.");
            e.printStackTrace();
        }

        shipLayout = new Stack[stringList.size()];

        for (int i = 0; i < stringList.size(); i++) {
            String containerRow = stringList.get(i);
            Stack<Character> stackOfContainers = new Stack<>();

            for (String string : containerRow.split(",")) {
                stackOfContainers.push(string.charAt(0));
            }

            shipLayout[i] = stackOfContainers;
        }

        return shipLayout;
    }

    public static List<Integer> extractMovesFromFile(String filePath) {
        LinkedList<String> stringList = new LinkedList<>();
        LinkedList<Integer> moves = new LinkedList<>();
        try {
            File fileObj = new File(filePath);
            Scanner reader = new Scanner(fileObj);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                stringList.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found for moves");
            e.printStackTrace();
        }
        for (String line : stringList) {
            for (String string : line.split(" ")) {
                try {
                    int x = Integer.parseInt(string);
                    moves.add(x);
                } catch (NumberFormatException e) {
                }
            }
        }
        return moves;
    }
}
