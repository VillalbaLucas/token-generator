package com.lucas.TokenGenerator;

public interface TokenGeneratorInterface {
    public String generateToken();
    public void addSimbol(char simbol);
    public void addSimbols(char... simbols);
    public void setSimbol(char simbol, char newSimbol);
    public Token setSizeToken(int size);
    public int size();
    // public String setToken(Token token);
}
