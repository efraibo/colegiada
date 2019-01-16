package br.ifpe.pg.provacolegiada.model.enumerator;

public enum ETipoQuestao {

	ABERTA("Aberta"),
	MULTIPLA_ESCOLHA("Multipla escolha"),
	VERDADEIRO_FALSO("Verdadeiro e falso");

	String text;

	ETipoQuestao(String t) {
		this.text = t;
	}

	public String getText() {
		return this.text;
	}
}
