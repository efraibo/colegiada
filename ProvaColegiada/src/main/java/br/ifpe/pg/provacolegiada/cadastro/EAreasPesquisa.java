package br.ifpe.pg.provacolegiada.cadastro;

public enum EAreasPesquisa {
    CIENCIAS_AGRARIAS_E_AGRONEGOCIO("CIÊNCIAS AGRÁRIAS E AGRONEGÓCIO"),
    ENERGIA("ENERGIA"),
    ENGENHARIA_E_TECNOLOGIA_DA_INFORMACAO_E_COMUNICACAO("ENGENHARIA E TECNOLOGIA DA INFORMAÇÃO E COMUNICAÇÃO"),
    EXATAS_E_NATURAIS("EXATAS E NATURAIS"),
    HUMANAS_E_SOCIAIS("HUMANAS E SOCIAIS"),
    ECOLOGIA_E_MEIO_AMBIENTE("ECOLOGIA E MEIO AMBIENTE"),
    NANOTECNOLOGIA("NANOTECNOLOGIA"),
    SAUDE("SAÚDE");

    String text;

    EAreasPesquisa(String t) {
        this.text = t;
    }

    public String getText() {
        return this.text;
    }
}
