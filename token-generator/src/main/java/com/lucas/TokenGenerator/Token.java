package com.lucas.TokenGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.String.valueOf;

public class Token implements TokenGeneratorInterface {
    private final static int MAX_LENGTH = 100;
    private final static int MIN_LENGTH = 10;

    private int length = 0;
    private final static Random rand = new Random();
    private List<Character> simbols = new ArrayList<>();

    public String token = "";

    public static void main(String[] args) {

        Token token = new Token(50);
        System.out.printf("Token: %s \nToken2: %s \nToken size: %d", token.generateToken(),token.generateToken(), token.length);
    }
    /**
     * Crea una clase Token con un tamaño minimo poe defecto de token a generar <strong>MIN_LENGTH</strong>
     */
    public Token(){
        createSombols();
        length = MIN_LENGTH;
    }

    /**
     * Construye una clase Token con un tamaño especifico de los token que generara.
     * @param size Valores comprendidos entre un minimo de 10 y maximo de 100 por defecto. 
     */
    public Token(int size){
        createSombols();
        setSizeToken(size);
    }

    public List<Character> getSimbols(){
        return simbols;
    }

    @Override
    public String generateToken() {
        token = "";
        for(int i=0; i<length; i++){
            token = token.concat( String.valueOf(simbols.get(rand.nextInt(simbols.size()))));
        }
        return token;
    }

    private String randomStr(){
        // int length = rand.nextInt(2,5);
        String string = "";

        for(int i=0; i<length; i++){
            if(rand.nextBoolean())
                string = string.concat(valueOf((char)rand.nextInt(65,90)));
            else
                string = string.concat(valueOf((char)rand.nextInt(97,122)));
            string = string.concat(valueOf(rand.nextInt(101)));
        }
        return string;
    }



    @Override
    public void setSizeToken(int size) {
        if(size < MIN_LENGTH) length = MIN_LENGTH;
        if(size > MAX_LENGTH) length = MAX_LENGTH;
        if(size>= MIN_LENGTH && size<= MAX_LENGTH) length = size;
    }

    @Override
    public int sizeToken() {
        return token.length();
    }

    @Override
    public void addSimbol(char simbol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSimbol'");
    }

    @Override
    public void setSimbol(char simbol, char newSimbol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSimbol'");
    }

    private void createSombols(){
        for(int i=65; i<127; i++){
            simbols.add((char)i);    
        }
    } 
}