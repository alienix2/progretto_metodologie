package progetto.mp.monicolini.matteo.puntocaldo;

public interface IngredienteVisitor {
	
	void visitIngredienteBase(IngredienteBase ingrediente);
	
	void visitIngredienteLavorato(IngredienteLavorato lavorato);

}
