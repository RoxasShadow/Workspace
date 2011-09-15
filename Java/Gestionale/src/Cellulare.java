class Cellulare {
	private int CodiceIMEI;
	private String marca;
	private String modello;
	private double prezzo;
	
	Cellulare(int CodiceIMEI, String marca, String modello, double prezzo) {
		this.CodiceIMEI = CodiceIMEI;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
	}
	
	public int getCodiceImei() {
		return CodiceIMEI;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModello() {
		return modello;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String toString() {
		return "IMEI: "+getCodiceImei()+"\nMarca: "+getMarca()+"\nModello: "+getModello()+"\nPrezzo: "+getPrezzo();
	}
}
