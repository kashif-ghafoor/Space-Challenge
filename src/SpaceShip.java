
//interface
public interface SpaceShip<T> {//using generics
    boolean launch();
    boolean land();
    boolean canCarry(T item);
    void carry(T item);
}
