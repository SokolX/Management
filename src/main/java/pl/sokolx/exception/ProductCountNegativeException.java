package pl.sokolx.exception;

public class ProductCountNegativeException extends Exception {

    public ProductCountNegativeException() {
    }

    public ProductCountNegativeException(String message) {
        super(message);
    }
}
