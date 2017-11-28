package Pack;

class DistanceException extends Exception {

	public DistanceException() {
		super();
	}
	
	@Override
	public String toString() {
		return ("DistanceException : Entrez une distance avant de lancer une régate");
	}
}
