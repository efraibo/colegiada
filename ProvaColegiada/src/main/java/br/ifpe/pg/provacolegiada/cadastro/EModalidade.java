package br.ifpe.pg.provacolegiada.cadastro;

public enum EModalidade {
    EAD("EAD"), PRESENCIAL("Presencial");

    String text;

    EModalidade(String t) {
        this.text = t;
    }

    public String getText() {
        return this.text;
    }

}
