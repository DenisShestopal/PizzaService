package Infrastructure.Exceptions;

public class PizzasOutOfBoundException extends Exception{
    public PizzasOutOfBoundException(){
        super("To many pizzas");
    }
}
