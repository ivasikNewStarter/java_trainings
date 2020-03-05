package mainTestofKnowledge;

public class AnimalTest {
    private boolean vegetarian;
    private String eats;
    private int noOflegs;

    public AnimalTest(){ }

    public AnimalTest(boolean veg, String food, int legs) {
        this.vegetarian = veg;
        this.eats = food;
        this.noOflegs = legs;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String getEats() {
        return eats;
    }

    public int getNoOflegs() {
        return noOflegs;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setEats(String eats) {
        this.eats = eats;
    }

    public void setNoOflegs(int noOflegs) {
        this.noOflegs = noOflegs;
    }
    @Override
    public String toString() {
        return vegetarian + " " + eats + " " + noOflegs +" ";
    }
}
