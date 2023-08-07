package com.lucas.TokenGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase Token.
 *
 * <p>Genera cadena de caracteres random para crear token de autentificacion.</p>
 *
 * @author Lucas Villalba
 * @version 1.0
 */
public class Token implements TokenGeneratorInterface {
    private final static int MAX_LENGTH = 100;
    private final static int MIN_LENGTH = 10;

    private int length = 0;
    private final static Random rand = new Random();
    private List<Character> simbols = new ArrayList<>();

    public String token = "";

    /**
     * Crea una clase Token con un tamaño minimo de token  por defecto <b>size=10</b>
     */
    public Token(){
        createSombols();
        length = MIN_LENGTH;
    }

    /**
     * Crea una clase Token con un tamaño especifico de los token que generara.
     * @param size Valores comprendidos entre un minimo de 10 y maximo de 100 por defecto. 
     */
    public Token(int size){
        createSombols();
        setSizeToken(size);
    }

    /**
     * Los <b>simbolos</b> utilizados por defecto son los valores 65 al 126 en la tabla
     * <a href="https://elcodigoascii.com.ar/codigos-ascii/signo-numeral-almohadilla-codigo-ascii-35.html">ASCII</a>
     * @return Lista de <b>simbols</b> que utilizapara generar los tokens.
     */
    public List<Character> getSimbols(){
        return simbols;
    }

    /** Metodo que genera una cadena de caracteres random comprendida entre los valores 65 y 126 en tabla 
     * <a href="https://elcodigoascii.com.ar/codigos-ascii/signo-numeral-almohadilla-codigo-ascii-35.html">ASCII</a> por defecto para el valor de una token.
     * @return String con una combinacion de caracteres random.
     */
    @Override
    public String generateToken() {
        token = "";
        for(int i=0; i<length; i++){
            token = token.concat(
                String.valueOf(simbols.get(rand.nextInt(simbols.size()))));
        }
        return token;
    }

    /**
     * Formatea la longitud que tendran los tokens cuando estos se generen aleatoriamente.
     * <p>El valor comprendido no podra ser menor al minimo como tampoco mayor al maximo ya preestablecido por defecto <b>10<=size<=100</b>.</p>
     * @param size valor entero que  indicara la longitud del token.
     */
    @Override
    public Token setSizeToken(int size) {
        if(size < MIN_LENGTH) length = MIN_LENGTH;
        if(size > MAX_LENGTH) length = MAX_LENGTH;
        if(size>= MIN_LENGTH && size<= MAX_LENGTH) length = size;
        return this;
    }

    /** Longitud que tendran los tokens que se generaran
     * @return <b>int</b> valor entero.
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Agrega o añade un caracter que utilizara para generar la cadena final de tokens.
     * @param simbol hace referencia a un nuevo simbolo de tipo <b>char</b>.
     */
    @Override
    public void addSimbol(char simbol) {
        if(simbols.contains(simbol)) return;
        simbols.add(simbol);
    }

    @Override
    public void addSimbols(char... args) {
        for(char c: args){
            if(simbols.contains(c)) continue;
            simbols.add(c);
        }
    } 

    /**
     * Modifica un simbolo o caracter en la lista de simbolos que utiliza la clase Token para crear una cadena de caracteres "token" aleatorio.
     * @param simbol hace referencia al caracter ya incluido en la lista y quiera reemplazar.
     * @param newSimbol se refiere al nuevo simbolo tipo <b>char</b> que quiera incluir.
     */
    @Override
    public void setSimbol(char simbol, char newSimbol) {
        
        try {
            if(simbols.contains(newSimbol)) return;
            simbols.remove( simbols.indexOf(simbol));
            simbols.add(newSimbol);
        }
        catch (Exception e) {
            System.out.printf("Error al settear el caracter '%c' \nException: %s", newSimbol, e.toString() );
        }
    }

    private void createSombols(){
        for(int i=65; i<127; i++){
            simbols.add((char)i);    
        }
    }

}