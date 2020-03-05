package mainDataStr;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by u0139221 on 1/27/2020.
 */
public class POJO {
    private int id;
    private String name;
    private String favoriteBook;
    private Set<POJO> friends = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public Set<POJO> getFriends() {
        return friends;
    }

    public void setFriends(Set<POJO> friends) {
        this.friends = friends;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67* hash + this.id;
        return hash;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        final POJO pojo = (POJO) o;
        if (this.id != pojo.id) {

            return false;
        }
        return true;
    }
}


