package interfaces;

/**
 * Created by u0139221 on 2/19/2020.
 */
public interface FuncInterface {

    // An abstract function
    void abstractFun (int x);

    // A non-abstract (or default) function
    default void normalFun () {
        System.out.println("Hello");




    }

}
