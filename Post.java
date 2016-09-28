package dsons;

/**
 * @author kostas
 */
import dsons.User;
import dsons.DSoNs;
import java.util.ArrayList;
import java.util.Random;

public class Post {

    public int id_user, cou, last_edit;
    public String cat;
    public String textPost;

    public int Sizeposts;
    public ArrayList<Integer> postLike = new ArrayList<Integer>();

    public Post(int id_user, String cat, int last_edit) {//constructor
        Random rnd = new Random();
        this.cat = cat;
        this.id_user = id_user;
        this.last_edit = last_edit;
        this.textPost = textPost;

        int low = 2;
        int high = 10;
        int num = rnd.nextInt(high - low + 1) + low;//epilegei tuxaia to megethos ths photo metaxu 500KB-4MB
        this.Sizeposts = num;

    }

    public void like_it(int id_user, String cat, int last_edit) {
        postLike.add(id_user);//prosthhkh sthn lista postlike
        //int sizepostLike = postLike.size();
        //System.out.println("to size ths postLike: "+sizepostLike+ " for id_user: "+id_user);
        //System.out.println(" id_user:" + this.id_user + " cat:" + this.cat + " PostLike:" + this.getpostLike());
        //o id_user ths kathgorias cat ekana like se auton ton id_user
    }

    public ArrayList<Integer> getpostLike() {
        return this.postLike;
    }

}
