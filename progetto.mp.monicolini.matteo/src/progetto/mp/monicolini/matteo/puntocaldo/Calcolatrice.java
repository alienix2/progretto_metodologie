package progetto.mp.monicolini.matteo.puntocaldo;

public class Calcolatrice {

	private ProfitStrategy profitStrategy;
	
	public Calcolatrice(ProfitStrategy profitStrategy) {
		this.profitStrategy = profitStrategy;
	}
	
	public void setProfitStrategy(ProfitStrategy profitStrategy) {
		this.profitStrategy = profitStrategy;
	}
	
	public double prezzoFinale(Ingrediente ingrediente) {
		return profitStrategy.aggiungiProfitto(ingrediente.calcolaCostoIntrinseco());
	}
}
