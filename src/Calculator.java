public class Calculator {
  //  private int a;
   // private int b;
   // private String charAction;
    private double result;

    public double Calculate(ScanAndPars scanAndPars) {
        switch (scanAndPars.charAction) {
            case ('+'): {
                 result = scanAndPars.a + scanAndPars.b;
                break;
            }
            case ('-'): {
                 result = scanAndPars.a - scanAndPars.b;
                break;
            }
            case ('/'): {
                if (scanAndPars.b==0) {
                    throw new NullPointerException("Деление на 0");
                }result = (double) scanAndPars.a / scanAndPars.b;
                break;
            }
            case ('*'): {
                 result = scanAndPars.a * scanAndPars.b;
                break;
            }
            default:
                throw new IllegalArgumentException("Неправильный оператор");
        }return result;
    }
}
