package portfolio.project.gameon;

public class BookingScreenDataModel
{
    private String name;
    private String state;
    private String About;
    private String Price;

    public BookingScreenDataModel() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public BookingScreenDataModel(String name,String state, String About, String Price) {
        this.name = name;
        this.state = state;
        this.About = About;
        this.Price = Price;
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public String getAbout() {
        return About;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return Price;
    }
    public String getState() {
        return state;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public void setState(String state) {
        this.state = state;
    }
    public void setAbout(String About) {
        this.About = About;
    }
}
