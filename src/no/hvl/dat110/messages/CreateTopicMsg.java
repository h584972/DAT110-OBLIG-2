package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	
	private String tema;

	public CreateTopicMsg(String bruker, String tema) {
		super(MessageType.CREATETOPIC, bruker);
		this.tema = tema;
		
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String topic) {
		this.tema = topic;
	}
	
	@Override
	public String toString() {
		return "CreateTopicMsg [Tema=" + tema + "]";
	}
}
