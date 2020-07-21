
//interface
public interface SpaceShip<T> {//using generics
    public boolean launch();
    public boolean land();
    public boolean canCarry(T item);
    public void carry(T item);
}
