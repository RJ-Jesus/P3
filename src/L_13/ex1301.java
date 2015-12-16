package L_13;

import L_13.ex01.*;

import java.util.ArrayList;
import java.util.List;

public class ex1301 {
    public static void main(String[] args) {
        Capital cid1 = new Capital("Szohod", 31212);
        Capital cid2 = new Capital("Wadesdah", 23423);
        Locality cid3 = new Locality("BedRock", 23423, Locality.TypeLocality.TOWN);
        State est1 = new State("North Borduria", 223133, cid1);
        State est2 = new State("South Borduria", 84321, cid2);
        Country p1 = new Country("Borduria", est1.getCapital());
        Country p2 = new Country("Khemed", cid2);
        //Country p2 = new Country("Khemed", cid3);
        Country p3 = new Country("Aurelia");
        Country p4 = new Country("Atlantis");
        p1.addRegion(est1);
        p1.addRegion(est2);
        p2.addRegion(new Province("Afrinia", 232475, "Aluko Pono"));
        p2.addRegion(new Province("Eriador", 100000, "Dumpgase Liru"));
        p2.addRegion(new Province("Laurania", 30000, "Mukabamba Dabba"));
        List<Country> org = new ArrayList<>();
        org.add(p1);
        org.add(p2);
        org.add(p3);
        org.add(p4);
        System.out.println("----Iterate over the set");
        org.forEach(System.out::println);
        // ToDo:
        // adicionar, remover, ordenar, garantir elementos únicos
    }
}
