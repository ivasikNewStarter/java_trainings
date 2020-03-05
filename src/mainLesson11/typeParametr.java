package mainLesson11;

public class typeParametr {
    public static void main(String[] args) {
        TypeN <Integer> tg = new TypeN <>( 10 );
        int x= tg.getObj();
        System.out.println(x);
        tg.showType();
        TypeN <String> tg2 = new TypeN <>("Test" );
        String str = tg2.getObj();
        System.out.println(str);
        tg2.showType();
    }

}

class TypeN<T> {
    T obj;

    TypeN(T obj) {
        this.obj = obj;
    }

    void showType() {
        System.out.println( obj.getClass().getName() );
    }

    public T getObj() {
        return obj;
    }
}
