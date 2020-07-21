import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws Exception {
        Simulation simulation=new Simulation();
        File file1 = new File("phase_1.txt");
        File file2 = new File("phase_2.txt");
        Scanner phase_1 = new Scanner(file1);
        Scanner phase_2 = new Scanner(file2);
        ArrayList<Item> list1;
        ArrayList<Item> list2;
        ArrayList<u1> rocket_u1_1;
        ArrayList<u1> rocket_u1_2;
        list1=simulation.loadItems(phase_1);
        list2=simulation.loadItems(phase_2);
        rocket_u1_1=simulation.loadU1(list1);
        rocket_u1_2=simulation.loadU1(list2);
        double total_budget1= simulation.runSimulation((ArrayList<Rocket>) ((ArrayList<?>) rocket_u1_1));//casting arraylist type
        double total_budget2= simulation.runSimulation((ArrayList<Rocket>) ((ArrayList<?>) rocket_u1_2));//casting arraylist type
        ArrayList<u2> rocket_u2_1;
        ArrayList<u2> rocket_u2_2;
        rocket_u2_1=simulation.loadU2(list1);
        rocket_u2_2=simulation.loadU2(list2);
        double total_budget10= simulation.runSimulation((ArrayList<Rocket>) ((ArrayList<?>) rocket_u2_1));//casting arraylist type
        double total_budget20= simulation.runSimulation((ArrayList<Rocket>) ((ArrayList<?>) rocket_u2_2));//casting arraylist type
        System.out.printf("total cost of u1 for phase-1 is: $%.2f Million\ntotal cost of u1 for phase-2 is: $%.2f Million" +
                "\ntotal cost for u2 for phase-1 is: $%.2f Million\ntotal cost of u2 for phase-2 is: $%.2f Million" +
                "\n\ntotal budget required for u1 is: $%.2f Million\ntotal budget required for u2 is: $%.2f Million\n",total_budget1,
                total_budget2,total_budget10,total_budget20,total_budget1+total_budget2,total_budget10+total_budget20);
    }
}
