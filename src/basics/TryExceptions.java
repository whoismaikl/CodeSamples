package basics;

/**
 * Created by mihails_nikitins on 15.09.2016.
 */
public class TryExceptions {
    public static void main(String[] args) {

        tryCompilationErrorWithExceptionBeforeArithmeticException();

    }


    private static void tryCompilationErrorWithExceptionBeforeArithmeticException() {
        try {
            int a = 0;
            int b = 42/a;
            System.out.print("A");
        } catch (Exception e) {
            System.out.print("C");
            // } catch (ArithmeticException e) {     //Arithmetic exceltion already caiught - compilation error!
            //     System.out.print("B");
        }
    }

}
