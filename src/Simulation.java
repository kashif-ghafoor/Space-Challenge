
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Simulation {
    public ArrayList<Item> loadItems(Scanner input) {
        ArrayList<Item> list = new ArrayList<>();
        while(input.hasNext()) {
            String line = input.nextLine();
            String []str=line.split("\\=",2);
            list.add(new Item(str[0], parseDouble(str[1])));
        }
        return list;
    }
    public ArrayList<u1> loadU1(ArrayList<Item> list) {
        ArrayList<u1> rockets1 = new ArrayList<>();
        rockets1.add(new u1());
        int i=0;
        for(Item item:list) {
            if (!rockets1.get(i).canCarry(item)) {
                rockets1.add(new u1());
                i++;
            }
            rockets1.get(i).carry(item);
        }
        return rockets1;
    }
    public ArrayList<u2> loadU2(ArrayList<Item> list) {
        ArrayList<u2> rockets2=new ArrayList<>();
        rockets2.add(new u2());
        int i=0;
        for(Item item:list) {
            if(!rockets2.get(i).canCarry(item)) {
                rockets2.add(new u2());
                i++;
            }
            rockets2.get(i).carry(item);
        }
        return rockets2;
    }
    public double runSimulation(ArrayList<Rocket> rockets) {
        double total_cost=0.0;
        for(int i=0;i<rockets.size();i++) {
            while(!(rockets.get(i).launch() && rockets.get(i).land())) {
                total_cost+=rockets.get(i).current_cost;
                Rocket.checker=true;
            }
            Rocket.checker=false;
            if((rockets.get(i).launch() && rockets.get(i).land())) {
                total_cost+=rockets.get(i).current_cost;

            }
        }
        return total_cost;
    }
}
