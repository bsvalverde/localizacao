package database.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import database.interfaces.LojaGateway;
import modelos.Loja;

public class LojaMongoGateway implements LojaGateway {
	private MongoDbFactory mongoFactory = MongoDbFactory.getInstance();
	
	public void salvar(Loja loja) {
		MongoDatabase database = mongoFactory.getDatabase(ConfiguracoesMongoDb.DATABASE);
		MongoCollection<Document> collection = database.getCollection(ConfiguracoesMongoDb.LOJAS);
		Document doc = new Document("name", loja.getNome())
				.append("latitude", loja.getLatitude())
				.append("longitude", loja.getLongitude());
		collection.insertOne(doc);
	}
	
	public List<Loja> buscarTodos() {
		MongoDatabase database = mongoFactory.getDatabase(ConfiguracoesMongoDb.DATABASE);
		MongoCollection<Document> collection = database.getCollection(ConfiguracoesMongoDb.LOJAS);
		FindIterable<Document> db = collection.find();
		List<Loja> lojas = new ArrayList<>();
		for(Document document : db) {
			String nome = document.getString("name");
			double latitude = document.getDouble("latitude");
			double longitude = document.getDouble("longitude");
			Loja loja = new Loja(nome, latitude, longitude);
			lojas.add(loja);
		}	
		return lojas;
	}

}
