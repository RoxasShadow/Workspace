class GetMeNumber2 {
	public static void main(String[] args) {
		if(args.length > 0) {
			int num = 0;
			int first = Integer.parseInt(args[0]);
			for(int i=1; i<args.length; i++) {
				try {
					num = Integer.parseInt(args[i]);
					System.out.println(first+" + "+num+" = "+(first+num));
					System.out.println(first+" * "+num+" = "+(first*num));
					System.out.println(first+" - "+num+" = "+(first-num));
					System.out.println(first+" / "+num+" = "+(first/num));
					first = num;
				}
				catch(ArithmeticException e) {
					System.out.println("Errore: probabilmente stai tentando di effettuare una divisione per 0.");
                       		}
                       }
               }
               else
                       System.out.println("Usage: java [args]");
       }
}
