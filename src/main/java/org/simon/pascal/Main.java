
package org.simon.pascal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author simon.pascal.ngos
 */
public class Main {

    /**
     * point d'entree.
     * @param args 
     */
    public static void main(String[] args) {
        //je ne vais qu'utiliser deux arguments le reste sera ignore.
        if (args.length > 1) {
            String data = args[0];
            //validation du premier argument
            try {
                Integer.valueOf(data);
            } catch (NumberFormatException ex) {
                System.out.println("le premier argument ne doit comporter que des chiffres");
                return;
            }
            //validation du deuxieme argument.
            Integer step;
            try {
                step = Integer.valueOf(args[1]);
            } catch (NumberFormatException ex) {
                System.out.println("le deuxieme  argument ne doit etre un entier");
                return;
            }
            //conversion du string en integer
            List<Integer> entiers = new ArrayList<>();
            for (char elt : data.toCharArray()) {
                entiers.add(Integer.parseInt(String.valueOf(elt)));
            }
            //initialisation de la class main
            Main algo = new Main();
            algo.execution(entiers, step);
            System.out.println("");
        } else {
            System.out.println("les arguments en parametre sont obligatoire");
        }

    }
    
    /**
     * methode principale.
     * @param entiers
     * @param step
     * @return 
     */
    public List<String> execution(List<Integer> entiers,Integer step) {
        List<String> list=new ArrayList<>();
        //tranformation en tableau
        Integer[] tab = entiers.toArray(new Integer[]{});
        for (int it = 0; it < step; it++) {
            Integer[] result = new Integer[tab.length];
            for (int i = 0; i < tab.length; i++) {
                adjacent(i, tab, result);
            }
            list.add(affiche(result));            
            tab = Arrays.copyOf(result, result.length);
        }
        
        return list;
    }
    /**
     * affichage du table.
     * @param tab
     * @return 
     */
    private String affiche(Integer[] tab) {
        StringBuilder str=new StringBuilder();
        for (int val : tab) {
            System.out.print(val);
            str.append(val);
        }
        System.out.println("");
        return str.toString();
    }

    /**
     * algorithm adjacent.
     *
     * @param index current index
     * @param tab first table
     * @param result result table
     */
    private void adjacent(int index, Integer[] tab, Integer[] result) {
        //first element 
        if (index == 0) {
            result[index] = tab[index + 1];
        } else if (index == tab.length - 1) {
            //last element
            result[index] = tab[index - 1];
        } else {
            //(adj(i+1)+adj(i-1))%2
            result[index] = (tab[index + 1] + tab[index - 1]) % 2;
        }
    }
}
