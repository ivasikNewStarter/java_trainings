package mainLesson7;

public class mieszkanie {
    public String city;
    public String district;
    public String street;
    public int rooms;
    public float space;
    public boolean basement;
    public int price;

    public mieszkanie (String city, String district, String street, int rooms, float space, boolean basement, int price){
        this.city = city;
        this.district = district;
        this.street = street;
        this.rooms = rooms;
        this.space = space;
        this.basement = basement;
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public float getSpace() {
        return space;
    }

    public void setSpace(float space) {
        this.space = space;
    }

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
@Override
public String toString (){
    return "Mieszkanie {" +
            "city " + city + " '" +
            "district " + district + " '" +
            "street " + street + " '" +
            "rooms " + rooms + " '" +
            "space " + space + " '" +
            "basement " + basement + " '" +
            "price " + price +
            "}";

    }
}
