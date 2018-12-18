package database.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import database.interfaces.LojaGateway;
import modelos.Loja;

public class LojaMongoGateway implements LojaGateway {
	private MongoDbFactory mongoFactory = MongoDbFactory.getInstance();

	public Document buscar(Loja loja) {
		MongoCollection<Document> collection = pegaColecao();
		Document document = collection.find(
				Filters.and(
						Filters.eq("name", loja.getNome()),
						Filters.eq("latitude", loja.getLatitude()),
						Filters.eq("longitude", loja.getLongitude())
					)
			).first();
		return document;
	}

	public List<Loja> buscarTodos() {
		MongoCollection<Document> collection = pegaColecao();
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

	private MongoCollection<Document> pegaColecao() {
		MongoDatabase database = mongoFactory.getDatabase(ConfiguracoesMongoDb.DATABASE);
		MongoCollection<Document> collection = database.getCollection(ConfiguracoesMongoDb.LOJAS);
		return collection;
	}

}
