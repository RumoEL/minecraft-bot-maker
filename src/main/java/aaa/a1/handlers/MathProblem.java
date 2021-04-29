package aaa.a1.handlers;

public class MathProblem {
	String input;
	int answ;

	public MathProblem(String task) {
		input = task;
	}

	public void calculate() {

		int firstArg = 0;
		int secondArg = 0;
		String operation = null;
		input = input.replaceAll(" ", " ");
		String[] args = input.split(" ");
		if (args.length != 3) {
			System.err.println("ОШИБКА ВЫЧ");
		}
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if (i == 0) {// 1
				firstArg = Integer.parseInt(arg);
			}
			if (i == 1) {// 2//oper
				operation = arg;
			}
			if (i == 2) {// 3
				secondArg = Integer.parseInt(arg);
			}
		}
		if (operation.equals("*")) {
			answ = firstArg * secondArg;
		}
		if (operation.equals("/")) {
			try {
				answ = firstArg / secondArg;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (operation.equals("-")) {
			answ = firstArg - secondArg;
		}
		if (operation.equals("+")) {
			answ = firstArg + secondArg;
		}
	}

	public String getAnsw() {
		return Integer.toString(answ);
	}

}
