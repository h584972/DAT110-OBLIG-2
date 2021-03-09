package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	
		private String tema;

		public SubscribeMsg(String bruker, String tema) {
			super(MessageType.SUBSCRIBE, bruker);
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
			return "SubscribeMsg [tema=" + tema + "]";
		}
		
		
}
