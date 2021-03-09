package no.hvl.dat110.broker;


import java.util.Collection;
import java.util.HashSet;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;
	
	protected ConcurrentHashMap<String, Set<Message>> buffer;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, Connection connection) {

		ClientSession cs = new ClientSession(user, connection);

		if (!clients.containsKey(user)) {
			clients.put(user, cs);
		}
		
	}

	public void removeClientSession(String user) {

		if (clients.containsKey(user)) {
			clients.remove(user);
		}
		
	}

	public void createTopic(String topic) {

		if (!subscriptions.containsKey(topic)) {
				Set<String> f�lgere = ConcurrentHashMap.newKeySet();
				subscriptions.put(topic, f�lgere);
		}
	
	}

	public void deleteTopic(String topic) {

		if (subscriptions.containsKey(topic)) {
			subscriptions.remove(topic);
		}
		
	}

	public void addSubscriber(String user, String topic) {

		if (subscriptions.containsKey(topic)) {
			Set<String> f�lgere = subscriptions.get(topic);
			f�lgere.add(user);
			subscriptions.replace(topic, f�lgere);

		}
		
	}

	public void removeSubscriber(String user, String topic) {
		
		if (subscriptions.containsKey(topic)) {
			Set<String> f�lgere = subscriptions.get(topic);
			if(f�lgere.contains(user)) {
				f�lgere.remove(user);
				subscriptions.replace(topic, f�lgere);
			}
		}
	}
	
	public void addBufferMessage(String user, Message msg){
		if (!buffer.containsKey(user)) {
			Set<Message> msgset = new HashSet<Message>();
			msgset.add(msg);
			buffer.put(user, msgset);
		} else {
			buffer.get(user).add(msg);
		}
	}
	
	

	
}
