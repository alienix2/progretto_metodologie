package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.ProfitStrategy;

public class ProfittoManoOpera implements ProfitStrategy {

	private double ore;
	private double percentualeOraria;
	
	public ProfittoManoOpera(double ore, double percentualeOraria) {
		this.ore = ore;
		this.percentualeOraria = percentualeOraria;
	}
	
	@Override
	public double aggiungiProfitto(double costoIntrinseco) {
		return Math.round((costoIntrinseco * (1+(ore*percentualeOraria)/100))*100)/100.0;
	}

}
