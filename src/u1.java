import java.util.Random;

public class u1 extends Rocket {
    private double weight=10000;
    private double max_weight=18000;
    private double cost=100;//million dollars
    private double chance_of_launch_explosion;//5% * (cargo carried / cargo limit);
    private double chance_of_landing_crash;//1% * (cargo carried / cargo limit)    int cost= 100;
    private double randomNumber;
    public u1() {
        current_weight=weight;
        weight_limit=max_weight;
        current_cost = this.cost;
        chance_of_launch_explosion=0.05*(current_weight/max_weight);
        chance_of_landing_crash= 0.01*(current_weight/max_weight);
        randomNumber = (double)(Math.random());
    }
    @Override
    public boolean land() {
        if(randomNumber<=chance_of_landing_crash){
            return false;
        }
        return true;
    }
    @Override
    public boolean launch() {
        if(Rocket.checker)
            randomNumber=(double)(Math.random());
        if(randomNumber<=chance_of_launch_explosion) {
            return false;
        }
        return true;
    }


}
