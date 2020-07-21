public class u2 extends Rocket{
    private double weight=18000;//in kg
    private double max_weight=29000;//in kg
    private double cost=120;// million dollar
    private double chance_of_launch_explosion;//4% * (cargo carried / cargo limit);
    private double chance_of_landing_crash;//8% * (cargo carried / cargo limit)
    private double randomNumber;
    public u2() {
        current_weight=weight;
        weight_limit=max_weight;
        current_cost=this.cost;
        chance_of_launch_explosion=0.04*(current_weight/max_weight);
        chance_of_landing_crash= 0.08*(current_weight/max_weight);
        randomNumber = (double)(Math.random());
    }
    @Override
    public boolean land() {
        if(randomNumber<=chance_of_landing_crash) {
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
