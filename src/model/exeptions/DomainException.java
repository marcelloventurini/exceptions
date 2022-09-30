package model.exeptions;

public class DomainException extends Exception {
	//construtor usado para permitir a instanciacao da excecao usando uma mensagem
	public DomainException(String msg) {
		super(msg);
	}
}
