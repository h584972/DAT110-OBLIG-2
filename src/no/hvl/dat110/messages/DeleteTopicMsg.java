package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	private String tema;

	public DeleteTopicMsg(String bruker, String tema) {
		super(MessageType.DELETETOPIC,bruker);
		this.tema = tema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "DeleteTopicMsg [tema=" + tema + "]";
	}

	

}
