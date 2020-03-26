import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadExamp  readExamp= new ReadExamp();
        while (true) {
            System.out.println("Введите данные");
            String line = readExamp.readLine();
            line = line.replaceAll(" ", "");
            List<Character> operators = Arrays.asList('+', '-', '*');
            String[] strNumbers = line.split("[-*+/]");
            double a, b, c = 0.0;
            if(strNumbers.length > 2) throw new MyExeption("");
            try {
                if (strNumbers[0].matches("[-+]?\\d+") && strNumbers[1].matches("[-+]?\\d+")
                        || !strNumbers[0].matches("[-+]?\\d+") && !strNumbers[1].matches("[-+]?\\d+")) {
                    if (strNumbers[0].matches("[-+]?\\d+")) {
                        a = Integer.parseInt(strNumbers[0]);
                        b = Integer.parseInt(strNumbers[1]);
                    } else {
                        a = new RomanNumbers(strNumbers[0]).getInt();
                        b = new RomanNumbers(strNumbers[1]).getInt();
                    }
                    if (a > 10 || a < 1 || b < 1 || b > 10) throw new MyExeption("Вышло за границы значений");
                    if (line.indexOf('+') != -1) {
                        c = a + b;
                    } else if (line.indexOf('-') != -1) {
                        c = a - b;
                    } else if (line.indexOf('*') != -1) {
                        c = a * b;
                    } else if (line.indexOf('/') != -1) {
                        c = a / b;
                    }
                    if (isDouble(c)&& (!strNumbers[0].matches("[-+]?\\d+"))) {
                        throw new MyExeption("Я не знаю как отобразить дробные римские цифры :)");
                    } else if (!isDouble(c) && (!strNumbers[0].matches("[-+]?\\d+"))) {
                        System.out.println(new RomanNumbers((int) c));
                    } else {
                        System.out.println(c);
                    }

                } else {
                    throw new MyExeption("Операторы должны быть однотипными");
                }
            }catch (ArrayIndexOutOfBoundsException e ) {
                throw new MyExeption("Калькулятор не может выполнить данное действие");
            }
        }
    }

    private static boolean isDouble(double d) {
        int i = (int)d;
        if((d - i) > 0) {
            return true;
        }
        else return false;
    }
    private static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}