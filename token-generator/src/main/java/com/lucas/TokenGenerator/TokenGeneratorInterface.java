package com.lucas.TokenGenerator;

public interface TokenGeneratorInterface {

    public String generateToken();
    public void addSimbol(char simbol);
    public void setSimbol(char simbol, char newSimbol);
    public void setSizeToken(int size);
    public int sizeToken();
    // public String setToken(Token token);
}
