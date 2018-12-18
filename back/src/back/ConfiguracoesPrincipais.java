package back;

import database.interfaces.FuncionarioGateway;
import database.interfaces.FuncionarioLojaGateway;
import database.interfaces.LojaGateway;
import database.mongo.FuncionarioLojaMongoGateway;
import database.mongo.FuncionarioMongoGateway;
import database.mongo.LojaMongoGateway;

public class ConfiguracoesPrincipais {
	public static final FuncionarioGateway FUNCIONARIO_GATEWAY = new FuncionarioMongoGateway();
	public static final LojaGateway LOJA_GATEWAY = new LojaMongoGateway();
	public static final FuncionarioLojaGateway FUNCIONARIO_LOJA_GATEWAY = new FuncionarioLojaMongoGateway();

}
