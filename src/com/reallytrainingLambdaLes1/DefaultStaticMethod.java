package com.reallytrainingLambdaLes1;

/**
 * Created by u0139221 on 2/19/2020.
 */

@FunctionalInterface
interface Employee {
    // abstract method
    Employee find (int id);

    // default method

    default boolean isExecute (int id) {
        //logic to find if exec goes here
        return true;
    }
    // static method
    static String getDefaultCountry(){
        return "UK";
    }
}
//Default and Static Methods
public class DefaultStaticMethod {

    public static void main(String[] args) {
        class EmployeeImpl implements Employee {
            @Override
            public Employee find(int id) {
                boolean executive = isExecute(id);
                return null;
            }
        }
        EmployeeImpl impl = new EmployeeImpl();
        impl.isExecute(1234);

        // accessing static method
        String defaultCountry = Employee.getDefaultCountry();
        System.out.println(defaultCountry);

    }
}
