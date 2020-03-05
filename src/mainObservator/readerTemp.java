package mainObservator;

public class readerTemp {

    private int nrKolejny;

    public readerTemp(int nrKolejny) {
        this.nrKolejny = nrKolejny;
    }

    public void update (int temp) {
        System.out.println("Read nr "+ nrKolejny+ " new temperature "+ temp);
    }
}
