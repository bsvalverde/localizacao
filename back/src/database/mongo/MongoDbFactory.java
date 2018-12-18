package database.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDbFactory {
	private static MongoDbFactory instance;

	private MongoClient client;

	private MongoDbFactory() {
		client = MongoClients.create();
	}

	public MongoDatabase getDatabase(String databaseName) {
		MongoDatabase database = client.getDatabase(databaseName);
		return database;
	}

	public static MongoDbFactory getInstance() {
		if(instance == null) {
			instance = new MongoDbFactory();
		}
		return instance;
	}

}
