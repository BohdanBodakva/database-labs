package ua.lviv.iot.database.lab4.exceptions;

public class ItemNotExistException extends RuntimeException{
    public ItemNotExistException(String message) {
        super(message);
    }
}
