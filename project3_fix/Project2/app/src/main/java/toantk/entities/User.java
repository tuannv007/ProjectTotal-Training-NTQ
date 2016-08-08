package toantk.entities;

/**
 * Created by admin on 8/3/2016.
 */
public class User {

    String name;
    String imageUrl;

    public User(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
