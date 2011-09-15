import java.util.InputMismatchException;

public class Binary {
	public String decimalToBinary(int decimal) throws NumberFormatException {
		StringBuffer buffer = new StringBuffer();
		while(decimal != 0) {
			buffer.append(decimal % 2);
			decimal /= 2;
		}
		return buffer.reverse().toString();
	}
	
	public int binaryToDecimal(String binary) throws NumberFormatException {
		String[] array = binary.split("");
		int i = 0;
		int decimal = 0;
		for(String tmp:array) {
			if((tmp != null) && (!tmp.trim().equals(""))) {
				if(Integer.parseInt(tmp) == 0)
					decimal += (0 * Math.pow(2, i));
				else if(Integer.parseInt(tmp) == 1)
					decimal += (1 * Math.pow(2, i));
				else
					--i; // asd
				++i;
			}
		}
		return decimal;
	}
}
