package LambdaOrealy;

import interfaces.Family;

/**
 * Created by u0139221 on 2/18/2020.
 */
public class LambdaScope extends SuperScope implements Family{
    String member = "Grandpa";
    @Override
    public String who(String member) {
        return null;
    }

    void testMember(String member){
       // System.out.println("Local member: " + member); //local
        //System.out.println("Family member: " + this.member); // private
       // System.out.println("Family member: " + super.member); //goes from interface

        Family familyLambda = (familymember) -> {
            System.out.println("Local member: " + familymember);
            System.out.println("Local member: " + member);
            System.out.println("Family member: " + this.member);
            return familymember;


        };
        familyLambda.who(member);
    }


    public static void main(String[] args) {
        new LambdaScope().testMember("Son");
    }
}
