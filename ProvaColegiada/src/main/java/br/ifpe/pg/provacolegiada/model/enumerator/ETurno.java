package br.ifpe.pg.provacolegiada.model.enumerator;

public enum ETurno {

	MANHA("Manhã"), TARDE("Tarde"), NOITE("Noite");

	String text;

	ETurno(String t) {
		this.text = t;
	}

	public String getText() {
		return this.text;
	}

}
