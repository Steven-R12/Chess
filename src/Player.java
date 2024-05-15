import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Player {
    public ChessColor color;
    private Pattern pattern = Pattern.compile("[A-H]{1},{1}[1-8]{1} [A-H]{1},{1}[1-8]{1}", Pattern.CASE_INSENSITIVE);


    private final Map<String, Integer> inputMap = Map.of("A", 0,
            "B", 1,
            "C", 2,
            "D", 3,
            "E", 4,
            "F", 5,
            "G", 6,
            "H", 7);
    private final Map<String, Integer> inputMap2 = Map.of("1", 0,
            "2", 1,
            "3", 2,
            "4", 3,
            "5", 4,
            "6", 5,
            "7", 6,
            "8", 7);

    public Player(ChessColor color) {
        this.color = color;

    }

    public Move getMove() {
        Scanner scanner = new Scanner(System.in);
        // A,1 B,2
        String userInput;
        while (true) {
            userInput = scanner.nextLine();
            if (!(userInput.length() == 7)) {
                System.out.println("Please input a move inside the board, ex: A,7 A,5");
            }
            if (inputValid(userInput)){
                break;
            }
        }
        String startX = userInput.substring(0,1).toUpperCase();
        String startY= userInput.substring(2,3);
        String endX = userInput.substring(4,5).toUpperCase();
        String endY= userInput.substring(6,7);
        Move move = new Move(inputMap.get(startX),inputMap2.get(startY), inputMap.get(endX), inputMap2.get(endY));
        return move;
    }
    public boolean inputValid(String userInput) {
        Matcher matcher = pattern.matcher(userInput);
        boolean result = matcher.find();
        if(result == false){
            System.out.println("Move is invalid, location not on Board");
        }
        return result;
    }
}
