package br.ifpe.pg.provacolegiada.security;

public class EmailExistsException extends Exception {

    public EmailExistsException(String string) {
        super(string);
    }

}
