package no.hvl.dat110.messages;

import no.hvl.dat110.common.TODO;

public class PublishMsg extends Message {
	
	
	private String melding;
	private String tema;
	
	public PublishMsg(String bruker, String melding, String tema) {
		super(MessageType.PUBLISH, bruker);
		this.melding = melding;
		this.tema = tema;
	}

	public String getMelding() {
		return melding;
	}

	public void setMelding(String melding) {
		this.melding = melding;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "PublishMsg [melding=" + melding + ", tema=" + tema + "]";
	}

	
}
