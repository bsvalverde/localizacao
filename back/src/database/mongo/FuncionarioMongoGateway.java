package database.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import database.interfaces.FuncionarioGateway;
import models.Funcionario;

public class FuncionarioMongoGateway implements FuncionarioGateway {
	private MongoDbFactory mongoFactory = MongoDbFactory.getInstance();
	
	public void salvar(Funcionario funcionario) {
		MongoDatabase database = mongoFactory.getDatabase(MongoDbSettings.DATABASE);
		MongoCollection<Document> collection = database.getCollection("Funcionarios");
		Document doc = new Document("name", funcionario.getNome())
				.append("latitude", funcionario.getLatitude())
				.append("longitude", funcionario.getLongitude());
		collection.insertOne(doc);
	}
	
	public List<Funcionario> buscarTodos() {
		MongoDatabase database = mongoFactory.getDatabase(MongoDbSettings.DATABASE);
		MongoCollection<Document> collection = database.getCollection("funcionarios");
		FindIterable<Document> db = collection.find();
		List<Funcionario> funcionarios = new ArrayList<>();
		for(Document document : db) {
			String nome = document.getString("name");
			double latitude = document.getDouble("latitude");
			double longitude = document.getDouble("longitude");
			Funcionario funcionario = new Funcionario(nome, latitude, longitude);
			funcionarios.add(funcionario);
		}	
		return funcionarios;
	}

}
