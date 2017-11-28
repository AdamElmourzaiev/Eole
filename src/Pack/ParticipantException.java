package Pack;

class ParticipantException extends Exception {

	public ParticipantException() {
		super();
	}
	
	@Override
	public String toString() {
		return ("ParticipantException : Entrez des participants avant de lancer une régate");
	}
}
