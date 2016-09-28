package dsons;

/**
 * @author kostas
 */
import java.util.ArrayList;
import java.util.Random;

public class Photo {

    public int id_user1, last_edit;
    public int Sizephotos;

    public ArrayList<Integer> photoLike = new ArrayList<Integer>();

    public Photo(int id_user1, int last_edit) { //constructor
        Random rnd = new Random();
        //this.category = category;
        this.id_user1 = id_user1;
        this.last_edit = last_edit;

        int low = 500;
        int high = 4000;
        int num = rnd.nextInt(high - low + 1) + low;//epilegei tuxaia to megethos ths photo metaxu 500KB-4MB
        this.Sizephotos = num;

    }

    public void like_it1(int id_user1, int last_edit) {
        photoLike.add(id_user1);//add sthn photolike

        // System.out.println(" id_user1:" + this.id_user1 + " PhotoLike:" + this.photoLike);
        //////System.out.println(" id_user:" + id_user1 + " Sizephoto:" + Sizephotos + "KB");
    }

    public ArrayList<Integer> getphotoLike() {
        return this.photoLike;
    }

}
