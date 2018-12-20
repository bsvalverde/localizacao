package main.database.mongo;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import main.database.interfaces.FuncionarioLojaGateway;
import main.modelos.FuncionarioLoja;

public class FuncionarioLojaMongoGateway implements FuncionarioLojaGateway {
	private MongoDbFactory mongoFactory = MongoDbFactory.getInstance();

	public void salvar(FuncionarioLoja funcionarioLoja) {
		MongoDatabase database = mongoFactory.getDatabase(ConfiguracoesMongoDb.DATABASE);
		MongoCollection<Document> collection = database.getCollection(ConfiguracoesMongoDb.FUNCIONARIO_LOJA);
		Document funcionario = new FuncionarioMongoGateway().buscar(funcionarioLoja.getFuncionario());
		Document loja = new LojaMongoGateway().buscar(funcionarioLoja.getLoja());
		Document document = new Document("funcionario_id", funcionario.getObjectId("_id"))
				.append("loja_id", loja.getObjectId("_id"));
		collection.insertOne(document);
	}

}
