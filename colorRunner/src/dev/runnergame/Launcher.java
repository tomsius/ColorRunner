package dev.runnergame;

import dev.runnergame.interpreter.AndExpression;
import dev.runnergame.interpreter.Expression;
import dev.runnergame.interpreter.OrExpression;
import dev.runnergame.interpreter.TerminalExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {
	public static void main(String[] args) {
		List<Expression> ruleList = new ArrayList<Expression>();

		Expression any = new TerminalExpression("any");
		Expression effects = new TerminalExpression("effects");
		Expression anyEffects = new AndExpression(any, effects);
		ruleList.add(anyEffects);

		Expression good = new TerminalExpression("good");
		Expression bad = new TerminalExpression("bad");
		Expression goodBad = new OrExpression(good, bad);
		ruleList.add(goodBad);

		SingletonController game = SingletonController.getInstance("ColorRunner", 640, 360);
		game.start();

		Scanner userInput = new Scanner(System.in);

		while (true) {
			if (userInput.hasNextLine()) {
				String input = userInput.nextLine();

				if (input.toLowerCase().contains("any") || input.toLowerCase().contains("effect")) {
					System.out.println(ruleList.get(0).interpret(input) == true? "Yes, there are.": "No, there are many effects.");
				}
				else if (input.toLowerCase().contains("am") || input.toLowerCase().contains("i")) {
					System.out.println(ruleList.get(1).interpret(input) == true? "Yes, you are.": "No, you are not.");
				}
				else {
					System.out.println("I don't understand you.");
				}
			}
		}
	}
}
