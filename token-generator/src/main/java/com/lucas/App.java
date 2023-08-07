package com.lucas;

import com.lucas.TokenGenerator.Token;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        Token token = new Token();
        System.out.println("Generate token: " + token.generateToken());
    }
}
