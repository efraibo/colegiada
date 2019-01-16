package br.ifpe.pg.provacolegiada.model.enumerator;

public enum ENivelComplexidade {
	BAIXA("Baixa"), MEDIA("Média"), ALTA("Alta");

	String text;

	ENivelComplexidade(String t) {
		this.text = t;
	}

	public String getText() {
		return this.text;
	}
}
