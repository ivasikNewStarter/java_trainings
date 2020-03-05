package mainTestofKnowledge;

public class CatTest  extends AnimalTest{
    private String color;



    public CatTest(boolean veg, String food, int legs, String color) {
        super(veg, food, legs);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
