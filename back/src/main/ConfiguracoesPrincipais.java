package main;

import main.database.interfaces.FuncionarioGateway;
import main.database.interfaces.FuncionarioLojaGateway;
import main.database.interfaces.LojaGateway;
import main.database.mongo.FuncionarioLojaMongoGateway;
import main.database.mongo.FuncionarioMongoGateway;
import main.database.mongo.LojaMongoGateway;

public class ConfiguracoesPrincipais {
	public static final FuncionarioGateway FUNCIONARIO_GATEWAY = new FuncionarioMongoGateway();
	public static final LojaGateway LOJA_GATEWAY = new LojaMongoGateway();
	public static final FuncionarioLojaGateway FUNCIONARIO_LOJA_GATEWAY = new FuncionarioLojaMongoGateway();

}
