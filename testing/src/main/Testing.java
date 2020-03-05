package main;

public class Testing {
    public int adding (int x, int y) {
        return x+y;
    }
    public boolean checkVolume (int min, int max, int number){
        if (number >= min && number <= max) {
            return true;
        } else {
            return false;
        }
    }

}
