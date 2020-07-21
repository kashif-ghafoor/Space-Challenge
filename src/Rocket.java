public class Rocket implements SpaceShip<Item> {
    double current_weight;
    double weight_limit;
    double current_cost;
    static boolean checker;
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if(item.weight+current_weight<weight_limit) {
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item item) {
            current_weight= current_weight+item.weight;

    }
}
