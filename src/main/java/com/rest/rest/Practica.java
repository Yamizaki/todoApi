package com.rest.rest;




public class Practica{
    public static void main (String[] args) {
        byte edad =10; /* desde 0-255*/

        short cajas= 20; /* desde -32768 - 32768 */

        int carros = 30; /* desde -2147483648 - 2147483648*/

        long id = 9999; /* desde -9223372036854775808 - 9223372036854775808  */

        float interes = 0.0F;  /* desde -3.4 * 10**38 - 3.4 * 10**38  */

        double producto = 12.2;   /* desde -1.79 * 10**380 - 1.79 * 10**380  */

        char letra = 65535; /* desde 0 - 65535  */

        boolean esCasado = true; /* 0(false) o 1(true) */

        String mensaje = "Aqui mensaje"; /* cadenas de texto */

        String y = Character.toString( 128_514 );

        System.out.println( y ) ;
    }
}
