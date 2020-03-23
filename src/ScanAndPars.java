import java.util.Scanner;

public class ScanAndPars {
      int a;
      int b;
      char charAction;
    Scanner scanner = new Scanner(System.in);
    String[] romes={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    String [] grek={"1","2","3","4","5","6","7","8","9","10"};
   // public String  firstString= scanner.nextLine();

    public void getNumberAndCharAction(String s) {           //обработка строки
       String[] pieceString = s.split("[+-/*]");        //разделение строки по символам калькулятора
        charAction = s.charAt(pieceString[0].length());
        pieceString[0]= pieceString[0].trim();
       pieceString[1]= pieceString[1].trim();
        if (pieceString.length <= 1) {
            throw new IllegalArgumentException("Неверный оператор");
        } else if (pieceString.length > 2) {
            throw new IndexOutOfBoundsException("Введено более 2 значений");
        }

        if (isRome(romes, pieceString[0]) && isRome(romes, pieceString[1]) ) {
            a=romanToNumb(pieceString[0]);
            b=romanToNumb(pieceString[1]);
        } else if (isGrees(grek, pieceString[0]) && isGrees(grek, pieceString[1])) {
            a = Integer.parseInt(pieceString[0]);
            b = Integer.parseInt(pieceString[1]);
        } else {
            throw new IllegalArgumentException("Неверный агрумент (Оба значения должны быть однотипными)");

        }
    }
    private int romanToNumb(String s) {
        if (s.equals("I")) {
            return 1;
        } else if (s.equals("II")) {
            return 2;
        } else if (s.equals("III")) {
            return 3;
        } else if (s.equals("IV")) {
            return 4;
        } else if (s.equals("V")) {
            return 5;
        } else if (s.equals("VI")) {
            return 6;
        } else if (s.equals("VII")) {
            return 7;
        } else if (s.equals("VIII")) {
            return 8;
        } else if (s.equals("IX")) {
            return 9;
        } else if (s.equals("X")) {
            return 10;
        } else {
            return -1;
        }
    }

    public boolean isRome(String []arg, String s) {
        for (String d : arg) {
            if (d.equals(s)) {
                return true;
            }
        } return false;
    }public boolean isGrees(String []arg, String s) {
        for (String d : arg) {
            if (d.equals(s)) {
                return true;
            }
        } return false;
    }

}
