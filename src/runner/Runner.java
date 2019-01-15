package runner;

import GenericList.ListM;

import java.util.Random;

public class Runner {
    public static void main(String[] args){
        ListM<Integer> liste = new ListM<Integer>();
        for(int i=0; i<8; i++)
            liste.ekle(new Random().nextInt(25));
        liste.yazdir();
        liste.arayaEkle(0 ,10);
        liste.yazdir();
        System.out.println(liste.getLoc());
        System.out.println(liste.varmi(85));
        System.out.println(liste.konumGetir(85));
        System.out.println(liste.kacTaneVar(85));
        liste.sirala();
        liste.yazdir();

        ListM<String> liste1 = new ListM<String>();
        liste1.ekle("Mustafa");
        liste1.ekle("Ahmet");
        liste1.ekle("Mehmet");
        liste1.ekle("Ayşe");
        liste1.ekle("Betül");
        liste1.ekle("Fatma");
        liste1.yazdir();
        liste1.sirala();
        liste1.yazdir();

    }
}
