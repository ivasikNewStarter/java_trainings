package mainLesson10;

class Write {
    void write(String msg) {
        System.out.print( "** " + msg );
        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            System.out.println( "Break" );
        }
        System.out.println( " **" );
    }
}

class Writer implements Runnable {
    String msg;
    Write w;
    Thread t;

    public Writer(Write w, String msg) {
        this.w = w;
        this.msg = msg;
        t = new Thread( this );
        t.start();
    }

    @Override
    public void
    run() {
        synchronized (w) {
            w.write( msg );
        }
    }
}

/*class newThread implements Runnable {

    public String name;
    Thread t;

    newThread(String str) {
        this.name = str;
        t = new Thread( this, str );
        t.start();
    }

    @Override
    public void run() {

        System.out.println( "Start subthread 1 : " + name );
        try {
            System.out.println( "Subtread " + name + " sleep 2" );
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "Subthread " + name + " Done 3" );

    }
}*/

public class thread {
    public static void main(String[] args) {

        Write w = new Write();
        Writer wr1 = new Writer( w, "This is" );
        Writer wr2 = new Writer( w, "Java" );
        Writer wr3 = new Writer( w, "course" );

        try {
            wr1.t.join();
            wr2.t.join();
            wr3.t.join();
        } catch (InterruptedException e) {
            System.out.println( "Error" );
        }
        System.out.println( "Done" );




        /*newThread tr1 = new newThread( "1" );
        newThread tr2 = new newThread( "2" );
        newThread tr3 = new newThread( "3" );
        try {
            tr1.t.join();
            tr2.t.join();
            tr3.t.join();

            *//*System.out.println("Thread will be sleep");
            Thread.sleep( 8000 );
            System.out.println("Start again 4");*//*
        } catch (InterruptedException e) {
            System.out.println( "Error" );
        }
        System.out.println( "Done 5" );
        System.out.println( tr1.t.isAlive() );
        System.out.println( tr2.t.isAlive() );
        System.out.println( tr3.t.isAlive() );*/
    }
}
