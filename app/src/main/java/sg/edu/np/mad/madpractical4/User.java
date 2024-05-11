package sg.edu.np.mad.madpractical4;

public class User {
    // Attributes
    public String name;
    public String description;
    public int id;
    public boolean followed;

    // Constructor
    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    public boolean isFollowed(){
        return followed;
    }

    public void setFollowed(boolean followed){
        this.followed = followed;
    }
}