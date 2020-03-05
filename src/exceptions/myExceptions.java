package exceptions;

public class myExceptions extends Exception {
    public myExceptions() {
    }
    public myExceptions(String msg) {
        super( msg );
    }
    public myExceptions(String msg, Throwable cause) {
        super( msg, cause );
    }
}
