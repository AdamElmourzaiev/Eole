package Pack;

class ClasseException extends Exception {

	public ClasseException() {
		super();
	}
	
	@Override
	public String toString() {
		return ("ClasseException : La classe doit �tre comprise entre 1 et 4 !!");
	}
}
