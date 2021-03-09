package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		
		Client klient = new Client("display", Common.BROKERHOST, Common.BROKERPORT);
		klient.connect();
		klient.createTopic(Common.TEMPTOPIC);
		klient.subscribe(Common.TEMPTOPIC);
		
		
		for (int i = 0; i < COUNT; i++) {

			PublishMsg melding = (PublishMsg) klient.receive();
			System.out.println("Temperatur er: " + melding.getMelding());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		klient.unsubscribe(Common.TEMPTOPIC);
		klient.disconnect();
	
	
		
		
		System.out.println("Display stopping ... ");
		
	
		
	}
}
