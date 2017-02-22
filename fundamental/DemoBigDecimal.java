import java.math.BigDecimal;

public class DemoBigDecimal{
	public static void main(String[] args) {
	    BigDecimal op1 = new BigDecimal("0.1");
	    BigDecimal op2 = new BigDecimal("3");
	    BigDecimal result = new BigDecimal("0.3");
	   // System.out.println(op1.add(op2).equals(result));
	    System.out.println(op1.divide(op2));
	    //BigDecimal除法要么返回精确的值，要么报下面的这个异常
	    //java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
	}
}