package main.database.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import main.database.interfaces.FuncionarioGateway;
import main.modelos.Funcionario;

public class FuncionarioMongoGateway implements FuncionarioGateway {
	private MongoDbFactory mongoFactory = MongoDbFactory.getInstance();

	public Document buscar(Funcionario funcionario) {
		MongoCollection<Document> collection = pegaColecao();
		Document document = collection.find(
				Filters.and(
						Filters.eq("name", funcionario.getNome()),
						Filters.eq("latitude", funcionario.getLatitude()),
						Filters.eq("longitude", funcionario.getLongitude())
					)
			).first();
		return document;
	}

	public List<Funcionario> buscarTodos() {
		MongoCollection<Document> collection = pegaColecao();
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

	private MongoCollection<Document> pegaColecao() {
		MongoDatabase database = mongoFactory.getDatabase(ConfiguracoesMongoDb.DATABASE);
		MongoCollection<Document> collection = database.getCollection(ConfiguracoesMongoDb.FUNCIONARIOS);
		return collection;
	}

}
