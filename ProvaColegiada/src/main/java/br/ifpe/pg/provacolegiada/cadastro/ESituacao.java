package br.ifpe.pg.provacolegiada.cadastro;

public enum ESituacao {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    String text;

    ESituacao(String t) {
        this.text = t;
    }

    public String getText() {
        return this.text;
    }
}
