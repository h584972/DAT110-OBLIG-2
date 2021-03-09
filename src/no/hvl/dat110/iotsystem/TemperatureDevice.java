package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		TemperatureSensor sn = new TemperatureSensor();
		

		
		Client klient = new Client("Tempratursensor", Common.BROKERHOST, Common.BROKERPORT);
		klient.connect();
		

		for (int i = 0; i < COUNT; i++) {
			klient.publish(Common.TEMPTOPIC, Integer.toString(sn.read()));
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		klient.disconnect();
		
		System.out.println("Temperature device stopping ... ");

		

	}
}
