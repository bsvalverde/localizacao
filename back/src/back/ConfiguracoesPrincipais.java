package back;

import database.interfaces.FuncionarioGateway;
import database.interfaces.LojaGateway;
import database.mongo.FuncionarioMongoGateway;
import database.mongo.LojaMongoGateway;

public class ConfiguracoesPrincipais {
	public static final FuncionarioGateway FUNCIONARIO_GATEWAY = new FuncionarioMongoGateway();
	public static final LojaGateway LOJA_GATEWAY = new LojaMongoGateway();

}
