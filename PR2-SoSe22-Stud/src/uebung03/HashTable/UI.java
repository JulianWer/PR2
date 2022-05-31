package uebung03.HashTable;

import uebung03.HashTable.ProbingAlgorithms.LinearProbing;
import uebung03.HashTable.ProbingAlgorithms.QuadraticProbing;

import static gdi.MakeItSimple.*;

public class UI {
    private HashTable hashTable;

    public void ui() {
        println("Willcome to your HashTable");
        hashTable = initHashTable();
        if (hashTable != null)
            activities(hashTable);

    }

    public HashTable initHashTable() {
        print("Please enter the size here: ");
        int size = readInt();
        print("Do you want to add a special probing? y/n");
        String answer = readLine();
        switch (answer) {
            case "y":
                print(" Which probing do you want to use? \n [1] alternated linear \n [2] alternated squared");
                switch (readInt()) {
                    case 1:
                        return new HashTable(size, new LinearProbing(1, -1));
                    case 2:
                        return new HashTable(size, new QuadraticProbing());
                }
            case "n":
        }
        return new HashTable(size);
    }

    public void activities(HashTable hs) {
        print(" What do you want to do? " +
                "\n [1] clear HashTable " +
                "\n [2] check if empty " +
                "\n [3] getStat " +
                "\n [4] print " +
                "\n [5] get the size " +
                "\n [6] reHash " +
                "\n [7] put an Object " +
                "\n [8] remove an Element " +
                "\n [9] get an Element " +
                "\n [10] check if contains key " +
                "\n [11] check if contains the Object " +
                "\n Please enter here: ");
        switch (readInt()) {
            case 1:
                hs.clear();
            case 2:
                println(hs.isEmpty());
            case 3:
                println(hs.getStat());
            case 4:
                hs.printHT();
            case 5:
                println(hs.size());
            case 6:
                hs.reHash();
                hs.printHT();
            case 7:
                print("Enter key: ");
                int key = readInt();
                print("Enter value: ");
                int value = readInt();
                println("The element on this field was" + ((ElementOfHashTable) (hs.put(key, value))).value);
            case 8:
                print("Enter key: ");
                key = readInt();
                println(hs.remove(key));
            case 9:
                print("Enter key: ");
                key = readInt();
                println(((ElementOfHashTable) (hs.get(key))).key + " : " + ((ElementOfHashTable) (hs.get(key))).value);
            case 10:
                print("Enter key: ");
                key = readInt();
                println(hs.containsKey(key));
            case 11:
                print("Enter key: ");
                key = readInt();
                print("Enter value: ");
                value = readInt();
                println(hs.contains(new ElementOfHashTable(key, value)));

        }
    }
}
