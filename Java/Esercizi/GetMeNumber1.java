class GetMeNumber1 {
	public static void main(String[] args) {
		if(args.length > 0) {
			int num = 0;
			int first = Integer.parseInt(args[0]);
			for(int i=1; i<args.length; i++) {
				num = Integer.parseInt(args[i]);
				System.out.println(first+" + "+num+" = "+(first+num));
				System.out.println(first+" * "+num+" = "+(first*num));
				if(num > first) {
					System.out.println(num+" / "+first+" = "+(num/first));
					System.out.println(num+" - "+first+" = "+(num-first));
				}
				else {
					System.out.println(first+" / "+num+" = "+(first/num));
					System.out.println(first+" - "+num+" = "+(first-num));
				}
				first = num;
			}
		}
		else
			System.out.println("Usage: java [args]");
	}
}
