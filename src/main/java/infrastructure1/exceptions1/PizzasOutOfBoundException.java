package infrastructure1.exceptions1;

public class PizzasOutOfBoundException extends Exception{
    public PizzasOutOfBoundException(){
        super("To many pizzas");
    }
}
