package dsons;

import dsons.DSoNs;
import java.util.ArrayList;
import java.util.Random;
import dsons.Post;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author kostas
 */
public class User {

    public int id, post_counter, photo_counter, like_counter, req_friend_cn, acc_friend_cn;
    //metrhtes gia kathe category gia post,photo,k.t.l

    public int likepost, likephoto, addfriend, days;//metrhtes gia kathe category gia likepost,likephoto,addfriend

    //pithanothtes gia kathe category
    public String category;
    public double ppost;
    public double pphoto;
    public double rfriend;
    public double afriend;
    public double poslike;
    public double pholike;

    public double pview;
    public double pFrview;

    //orismos arraylist
    private ArrayList<Integer> friendList = new ArrayList<Integer>();
    public ArrayList<Post> postList = new ArrayList<Post>();
    public ArrayList<Photo> photoList = new ArrayList<Photo>();

    // View
    public ArrayList<String> lastViewPost = new ArrayList<String>();
    public ArrayList<Integer> lastViewPostSize = new ArrayList<Integer>();
    public ArrayList<String> lastViewPhoto = new ArrayList<String>();
    public ArrayList<Integer> lastViewPhotoSize = new ArrayList<Integer>();

    public Storage storage;
    public Node node;
    public PowerLaw chance;

    private Random rand;

    public User(int id, String category, Storage storage, PowerLaw chance) {//class Users pernei id,category 
        this.id = id;////constructor
        this.category = category;//constructor

        this.storage = storage;
        this.node = node;
        this.chance = chance;

        this.days = 0;

        this.likepost = 0;
        this.likephoto = 0;
        this.like_counter = 0;

        this.post_counter = 0;
        this.photo_counter = 0;

        this.req_friend_cn = 0;
        this.acc_friend_cn = 0;
        this.addfriend = 0;

      
        // Start pithanothtes Post Category
        if (category == "A") {
            // this.ppost = 0.0002357 * 5;
            double poss = 0.0002357/60;
            this.ppost = chance.PowerLawDisplay(poss);
            //System.out.println("}}}}}}"+this.ppost);
        } else if (category == "B") {
            //this.ppost = 0.0002479 * 5;
            double poss = 0.0002479/60;
            this.ppost = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.ppost = 0.0002230 * 5;
            double poss = 0.0002230/60;
            this.ppost = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.ppost = 0.0002208 * 5;
            double poss = 0.0002208/60;
            this.ppost = chance.PowerLawDisplay(poss);
        } else {
            //this.ppost = 0.0002230 * 5;
            double poss = 0.0002230/60;
            this.ppost = chance.PowerLawDisplay(poss);
        } //End request Post Category

        // Start pithanothta Photo Category
        if (category == "A") {
            //this.pphoto = 0.0001850 * 5;
            double poss = 0.0001850/60;
            this.pphoto = chance.PowerLawDisplay(poss);
        } else if (category == "B") {
            //this.pphoto = 0.0001850 * 5;
            double poss = 0.0001850/60;
            this.pphoto = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.pphoto = 0.0001850 * 5;
            double poss = 0.0001850/60;
            this.pphoto = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.pphoto = 0.0001902 * 5;
            double poss = 0.0001902/60;
            this.pphoto = chance.PowerLawDisplay(poss);
        } else {
            //this.pphoto = 0.0001850 * 5;
            double poss = 0.0001850/60;
            this.pphoto = chance.PowerLawDisplay(poss);
        } //End request Photo Category

        // Start pithanothta request Friend Category
        if (category == "A") {
            //this.rfriend = 0.00015703 * 5;
            double poss = 0.00015703/60;
            this.rfriend = chance.PowerLawDisplay(poss);
        } else if (category == "B") {
            //this.rfriend = 0.00018401 * 5;
            double poss = 0.00018401/60;
            this.rfriend = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.rfriend = 0.00014703 * 5;
            double poss = 0.00014703/60;
            this.rfriend = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.rfriend = 0.000146875 * 5;
            double poss = 0.000146875/60;
            this.rfriend = chance.PowerLawDisplay(poss);
        } else {
            //this.rfriend = 0.00015703 * 5;
            double poss = 0.00015703/60;
            this.rfriend = chance.PowerLawDisplay(poss);
        } //End request Friend Category

        // Start pithanothta accept Friend Category
        if (category == "A") {
            //this.afriend = 0.804;
            double poss = 0.804;
            this.afriend = chance.PowerLawDisplay(poss);
        } else if (category == "B") {
            //this.afriend = 0.94216;
            double poss = 0.94216;
            this.afriend = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.afriend = 0.7528;
            double poss = 0.7528;
            this.afriend = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.afriend = 0.752;
            double poss = 0.752;
            this.afriend = chance.PowerLawDisplay(poss);
        } else {
            //this.afriend = 0.804;
            double poss = 0.804;
            this.afriend = chance.PowerLawDisplay(poss);
        } //End accept Friend Category

        // Start pithanothta Likepost Category
        if (category == "A") {
            //this.poslike = 0.0010783 * 5;
            double poss = 0.0010783/60;
            this.poslike = chance.PowerLawDisplay(poss);
        } else if (category == "B") {
            //this.poslike = 0.0010117 * 5;
            double poss = 0.0010117/60;
            this.poslike = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.poslike = 0.0010519 * 5;
            double poss = 0.0010519/60;
            this.poslike = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.poslike = 0.0008924 * 5;
            double poss = 0.0008924/60;
            this.poslike = chance.PowerLawDisplay(poss);
        } else {
            //this.poslike = 0.0009432 * 5;
            double poss = 0.0009432/60;
            this.poslike = chance.PowerLawDisplay(poss);
        }  //End  Likepost Category

        // Start pithanothta  Likephoto Category
        if (category == "A") {
            //this.pholike = 0.0015305 * 5;
            double poss = 0.0015305/60;
            this.pholike = chance.PowerLawDisplay(poss);
        } else if (category == "B") {
            //this.pholike = 0.0014361 * 5;
            double poss = 0.0014361/60;
            this.pholike = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.pholike = 0.0014931 * 5;
            double poss = 0.0014931/60;
            this.pholike = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.pholike = 0.0012667 * 5;
            double poss = 0.0012667/60;
            this.pholike = chance.PowerLawDisplay(poss);
        } else {
            //this.pholike = 0.0013389 * 5;
            double poss = 0.0013389/60;
            this.pholike = chance.PowerLawDisplay(poss);
        }  //End  Likephoto Category

        // Start pithanothtes View Category
        if (category == "A") {
            //this.pview = 0.002357 * 5;
            double poss = 0.00020703/60;
            this.pview = chance.PowerLawDisplay(poss);
        } else if (category == "B") {
            //this.pview = 0.002479 * 5;
            double poss = 0.00023401/60;
            this.pview = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.pview = 0.002230 * 5;
            double poss = 0.00019703/60;
            this.pview = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.pview = 0.002208 * 5;
            double poss = 0.000196875/60;
            this.pview = chance.PowerLawDisplay(poss);
        } else {
            //this.pview = 0.002230 * 5;
            double poss = 0.00020703/60;
            this.pview = chance.PowerLawDisplay(poss);
        } //End request View Category

        // Start pithanothtes View friend Category
        if (category == "A") {
            //this.pFrview = 0.002357 * 5;
            double poss = 0.002357/60;
            this.pFrview = chance.PowerLawDisplay(poss);
        } else if (category == "B") {
            //this.pFrview = 0.002479 * 5;
            double poss = 0.002479/60;
            this.pFrview = chance.PowerLawDisplay(poss);
        } else if (category == "C") {
            //this.pFrview = 0.002230 * 5;
            double poss = 0.002230/60;
            this.pFrview = chance.PowerLawDisplay(poss);
        } else if (category == "D") {
            //this.pFrview = 0.002208 * 5;
            double poss = 0.002208/60;
            this.pFrview = chance.PowerLawDisplay(poss);
        } else {
            //this.pFrview = 0.002230 * 5;
            double poss = 0.002230/60;
            this.pFrview = chance.PowerLawDisplay(poss);
        } //End request View Category
    }

    public void action(final float lf, ArrayList<User> userList, int last_edit) {
        long timeNow1 = System.nanoTime();
        post(lf, last_edit);//kalei thn methodo post
        long timeNow2 = System.nanoTime();
        photo(lf, last_edit);//kalei thn methodo photo
        long timeNow3 = System.nanoTime();
        do_requestFriend(lf, userList, last_edit);//kalei thn methodo do_requestFriend
        long timeNow4 = System.nanoTime();
        LikePost(lf, userList, last_edit);//kalei thn methodo likepost
        long timeNow5 = System.nanoTime();
        LikePhoto(lf, userList, last_edit);//kalei thn methodo likephoto
        long timeNow6 = System.nanoTime();
        ViewOneUser(lf, userList, last_edit);
        long timeNow7 = System.nanoTime();
        ViewFriendUser(lf, userList, last_edit);
        
        long diaf1 = timeNow2 - timeNow1;
        long diaf2 = timeNow3 - timeNow2;
        long diaf3 = timeNow4 - timeNow3;
        long diaf4 = timeNow5 - timeNow4;
        long diaf5 = timeNow6 - timeNow5;
        long diaf6 = timeNow7 - timeNow6;
        //System.out.println("timeNow1: "+timeNow1);
        //System.out.println("diaf1: "+diaf1);
        //System.out.println("diaf2: "+diaf2);
        //System.out.println("diaf3: "+diaf3);
        //System.out.println("diaf4: "+diaf4);
        //System.out.println("diaf5: "+diaf5);
        //System.out.println("diaf6: "+diaf6);
        
        
    }//end action

    public void do_requestFriend(final float lf, ArrayList<User> userList, int last_edit) {
        Random rnd = new Random();
        Random randNums = new Random();//paragwgh tuxaiwn arithmwn
        float rd = randNums.nextFloat();//float tuxaioi
        int listSize = userList.size();//megethos userList

        if ((rd > 1 - lf * rfriend) && listSize > 1) {//sxesh paragwghs request friend
            int num = 0;
            do {
                num = rnd.nextInt((listSize));//dialexe ena tuxaio int apo thn userList
            } while ((friendList.contains(num)) || num == this.id); // true or false? //pou na mhn einai filos sou kai oute to diko sou id

            User newfriend = userList.get(num);//bale to id pou dialexes sto new friend kai kane request
            this.req_friend_cn++;//auxhse to counter request kata 1

            storage.StoreRequestFriendship(userList.get(num).id, last_edit);//sto user pou kanei request o id

            boolean answer = newfriend.accept_request(lf, this.id);//epistrefei to apotelesma apo thn accept
            if (answer == true) {//an se dexthke prothhkh stous filous
                this.addfriend++;//auxhse to counter friend kata 1
                friendList.add(num);

                storage.StoreAcceptFriendship(id, userList.get(num).id, last_edit);//h accept epistrefei sto id pou ekane to request
            }
        }

    }

    public boolean accept_request(final float lf, int y) {
        Random randNums = new Random();
        float rd1 = randNums.nextFloat();
        //ebala tis idies pithanothtes dexetai kai kanei aithma filias pfriend
        if (rd1 > 1 - lf * afriend) { //sxesh paragwghs  accept request
            friendList.add(y);//prosthhkh sthn friend list
            this.acc_friend_cn++;//auxhse to counter friend kata 1
            return true;//an se kanei accept stelnei true alliws false

        } else {
            return false;
        }
    }//end accept_request

    private void post(final float lf, int last_edit) {

        Random randNums = new Random();
        float rd = randNums.nextFloat();
        if (rd > 1 - lf * ppost) {//sxesh paragwghs post
            this.post_counter++;

            //Post postUser = new Post(id, "nice");
            Post postUser = new Post(id, category, last_edit);//postUser periexei id kai cat??????tha prepei na pernaei kai keimeno
            postList.add(postUser);//add sthn post list

            int post_id = (postList.size() - 1);

            storage.StorePost(id, post_id, postUser.Sizeposts, last_edit);

        }
    }//end post

    private void photo(final float lf, int last_edit) {

        Random randNums = new Random();
        float rd = randNums.nextFloat();
        if (rd > 1 - lf * pphoto) {//sxesh paragwghs photo
            this.photo_counter++;
            Photo photoUser = new Photo(id, last_edit);//photoUser periexei id
            photoList.add(photoUser);//add sthn photo list

            int photo_id = (photoList.size() - 1);

            storage.StorePhoto(id, photo_id, photoUser.Sizephotos, last_edit);
        }
    }//end photo

    public void LikePost(final float lf, ArrayList<User> userList, int last_edit) {
        Random randNums = new Random();//paragei tuxaious arithmous
        float rd = randNums.nextFloat();
        int listSize = userList.size();
        int listFriendSize = friendList.size();
        int listPostSize = postList.size();
        if (rd > 1 - lf * poslike) {//sxesh paragwghs like post
            float rd1 = randNums.nextFloat();
            if (rd1 >= 0.0 && rd1 <= 0.75) {//pithanothta na kanei like se filo post 0.75
                if (listFriendSize > 1) {//an exei filous
                    int num = 0;
                    num = randNums.nextInt(listFriendSize);//pernei tuxaia ena id apo tous filous tou
                    User myfriend = userList.get(friendList.get(num));//to bazei sto myfriend
                    int posts = myfriend.postList.size();//mou dinei to size tou postList tou xrhsth myfriend
                    if (posts > 1) {//an exei kanei post
                        int num1 = 0;
                        num1 = randNums.nextInt(posts);//dialegei ena tuxaia
                        Post postlik = myfriend.postList.get(num1);//to sthn postlike
                        this.likepost++;//auxanei to counter ths post like kata ena
                        postlik.like_it(this.id, this.category, last_edit);//to bazei to post like sth lista postLike

                        Post postlik_last = myfriend.postList.get(num1);
                        myfriend.postList.remove(num1);
                        postlik_last.last_edit = last_edit;
                        myfriend.postList.add(postlik_last);

                        // System.out.println("LLL*to postLLL* create from:"+ this.id+ " new_time sloat: "+last_edit);
                        //System.out.println("last time post: " + last_edit);
                        String key = String.valueOf(friendList.get(num));
                        String key1 = String.valueOf(num1);
                        String key2 = "_";
                        String key3 = key + key2 + key1;
                        storage.StoreLikePost(key3, last_edit);

                        //storage.StoreLikePost(friendList.get(num), last_edit);
//                        System.out.println("h friendList sou einai: "+friendList);
//                        for(int i=0; i<listFriendSize;i++){
//                            System.out.println(" node is save: "+storage.userNode.get(friendList.get(i)));
//                        }
//                        System.out.println("o user pou dialexe: "+friendList.get(num)+
//                                " the user is save the node: "+storage.userNode.get(friendList.get(num)));
//                                
                    }
                }
            } else {//kanei like se post mh filou 0.25 pithanothta
                if (listSize > 1) {//an uparxoun xrhstes
                    int num2 = 0;
                    do {
                        num2 = randNums.nextInt(listSize);//pernei enan tuxaia user list
                    } while (friendList.contains(num2)); // true or false?// arkei na mhn einai filos
                    //User nofriend = userLisuserListt.get(num2);
                    User u = userList.get(num2);//ton bazei sto u
                    int posts = u.postList.size();//blepei to post size tou u
                    int num3 = 0;
                    if (posts > 1) {//an exei postarei
                        num3 = randNums.nextInt(posts);//dialexe ena tuxaia kai kan tou like
                        Post postlik = u.postList.get(num3);
                        this.likepost++;
                        postlik.like_it(this.id, this.category, last_edit);
                        // System.out.println("@@@@@@@@@@@@@@@@@@@@");

                        Post postlik_last = u.postList.get(num3);
                        u.postList.remove(num3);
                        postlik_last.last_edit = last_edit;
                        u.postList.add(postlik_last);

                        // System.out.println("LLL*to postLLL* create from:"+ this.id+ " new_time sloat: "+last_edit);
                        //System.out.println("last time post: " + last_edit);
                        String key = String.valueOf(userList.get(num2).id);
                        String key1 = String.valueOf(num3);
                        String key2 = "_";
                        String key3 = key + key2 + key1;
                        storage.StoreLikePost(key3, last_edit);

                        //storage.StoreLikePost(userList.get(num2).id, last_edit);
                    }
                }
            }
            // this.likepost++;
        }

    }

    public void LikePhoto(final float lf, ArrayList<User> userList, int last_edit) {
        Random randNums = new Random();//paragei tuxaious arithmous
        float rd = randNums.nextFloat();
        int listSize = userList.size();
        int listFriendSize = friendList.size();
        int listPhotoSize = photoList.size();
        if (rd > 1 - lf * pholike) { //idies pithanothtes na kaneis like kai se post kai se photo plike
            //h sxesh pou paragei ta sth photo
            float rd1 = randNums.nextFloat();
            if (rd1 >= 0.0 && rd1 <= 0.75) {//h pithanothta na kanei like se photo einai 0.75 gia filo tou
                if (listFriendSize > 1) {//an exei filous
                    int num = 0;
                    num = randNums.nextInt(listFriendSize);//dialegei ena tuxaia
                    User myfriend = userList.get(friendList.get(num));//ton bazei sthn metablhth myfriend
                    int photos = myfriend.photoList.size();//mou dinei postList tou xrhsth myfriend
                    if (photos > 1) {//an exei photo o xrhsths pou dialexe
                        int num1 = 0;
                        num1 = randNums.nextInt(photos);//dialegei mia tuxaia
                        Photo photolik = myfriend.photoList.get(num1);//kanei like sth photo
                        this.likephoto++;//auxanei ton counter
                        photolik.like_it1(this.id, last_edit);

                        Photo photolik_last = myfriend.photoList.get(num1);
                        myfriend.photoList.remove(num1);
                        photolik.last_edit = last_edit;
                        myfriend.photoList.add(photolik_last);

                        //System.out.println("last time photo: " + last_edit);
                        String key = String.valueOf(friendList.get(num));
                        String key1 = String.valueOf(num1);
                        String key2 = "_";
                        String key3 = key + key2 + key1;
                        storage.StoreLikePhoto(key3, last_edit);

                        //storage.StoreLikePhoto(friendList.get(num), last_edit);
                    }
                }
            } else {
                if (listSize > 1) {//kanei like se photo kapoiou pou den einai filos pithanothta 0.25
                    int num2 = 0;
                    do {
                        num2 = randNums.nextInt(listSize);//dialegei kapoion apo thn lista twn xrhstwn
                    } while (friendList.contains(num2)); // true or false? //oso den einai filos tou
                    //User nofriend = userList.get(num2);
                    User u = userList.get(num2);//pernei to id kapoiou
                    int photos = u.photoList.size();//blepei thn lista twn photo tou
                    int num3 = 0;
                    if (photos > 1) {//an exei photo
                        num3 = randNums.nextInt(photos);//dialegei mia tuxaia
                        Photo photolik = u.photoList.get(num3);//kai ths kanei like
                        this.likephoto++;//auxanei ton counter
                        photolik.like_it1(this.id, last_edit);

                        Photo photolik_last = u.photoList.get(num3);
                        u.photoList.remove(num3);
                        photolik.last_edit = last_edit;
                        u.photoList.add(photolik_last);

                        //System.out.println("last time photo: " + last_edit);
                        String key = String.valueOf(userList.get(num2).id);
                        String key1 = String.valueOf(num3);
                        String key2 = "_";
                        String key3 = key + key2 + key1;
                        storage.StoreLikePhoto(key3, last_edit);

                        //storage.StoreLikePhoto(userList.get(num2).id, last_edit);
                    }
                }
            }

        }

    }

    public void printPost() {

        System.out.println("Cat:" + this.category + " ID:" + this.id + " NumPost:" + this.post_counter);
        System.out.println("Cat:" + this.category + " NumPhoto:" + this.photo_counter);
        System.out.println("Cat:" + this.category + " NumRequestFriendship:" + this.req_friend_cn);
        System.out.println("Cat:" + this.category + " NumAcceptRequestFriendship:" + this.acc_friend_cn + " listFriend:" + this.friendList);
        System.out.println("Cat:" + this.category + " NewFriend:" + this.addfriend);

        System.out.println("Cat:" + this.category + " LikePost:" + this.likepost);
        System.out.println("Cat:" + this.category + " LikePhoto:" + this.likephoto);
    }

//    public ArrayList<Post> getpostList() {
//        return this.postList;
//    }
//    public ArrayList<Photo> getphotoList() {
//        return this.photoList;
//    }
    
    public ArrayList<Integer> getfriendList() {
        return this.friendList;
    }

    private void ViewOneUser(final float lf, ArrayList<User> userList, int last_edit) {

        Random randNums = new Random();
        float rd = randNums.nextFloat();
        int listSize = userList.size();
        int listFriendSize = friendList.size();
        int listPhotoSize = photoList.size();
        if (rd > 1 - lf * pview) {//sxesh paragwghs view

            if (listFriendSize > 1) {
                int num = 0;
                num = randNums.nextInt(listFriendSize);//dialegei ena tuxaia
                User myfriend = userList.get(friendList.get(num));//ton bazei sthn metablhth myfriend
                int posts = myfriend.postList.size();//mou dinei postListsize tou xrhsth myfriend
                int photos = myfriend.photoList.size();//mou dinei postListsize tou xrhsth myfriend

                if ((posts > 1) && (photos > 1)) {//an exei posts kai photos
                    //int counterPost = myfriend.postList.size() -1;
                    //int counterPhoto = myfriend.photoList.size() -1;
                    int counterPost = (posts - 1);//dwse ston counterPost thn timh twn posts -1 
                    int counterPhoto = (photos - 1);//dwse ston counterPhoto thn timh twn photos -1 
                    int sum = 0, x = 0, y = 0;
                    //ta prwta 100
                    while ((sum < 100) && ((counterPost >= 0) || (counterPhoto >= 0))) {

                        if (counterPost >= 0) {//an exei post pare to teleutaio
                            x = myfriend.postList.get(counterPost).last_edit;
                        } else {//an exei post pare to teleutaio
                            x = -1;
                        }
                        //System.out.println("fdfdfd: "+x);
                        if (counterPhoto >= 0) {//an exei post pare to teleutaio
                            y = myfriend.photoList.get(counterPhoto).last_edit;
                        } else {//an exei post pare to teleutaio
                            y = -1;
                        }

                        //System.out.println("fdfdfd**: "+y);
                        if (x > y) {
                            //exei th morfh: id_Idpost 
                            String key = String.valueOf(friendList.get(num));//metatrepei ton integer se string
                            String key1 = String.valueOf(counterPost);//counterPost
                            String key2 = "_";
                            String key3 = key + key2 + key1;

                            lastViewPost.add(key3);
                            lastViewPostSize.add(myfriend.postList.get(counterPost).Sizeposts);
                            counterPost--;
                            // System.out.println("lastViewPost@@@@"+lastViewPost);
                            // System.out.println("lastViewPostSize@@@@"+lastViewPostSize);
                        } else {
                            //exei th morfh: id_Idphoto 
                            String key = String.valueOf(friendList.get(num));
                            String key1 = String.valueOf(counterPhoto);
                            String key2 = "_";
                            String key3 = key + key2 + key1;

                            lastViewPhoto.add(key3);
                            lastViewPhotoSize.add(myfriend.photoList.get(counterPhoto).Sizephotos);
                            counterPhoto--;
                            //  System.out.println("lastViewPhoto@@@@"+lastViewPhoto);
                            // System.out.println("lastViewPhotoSize@@@@"+lastViewPhotoSize);
                        }

                        sum++;
                    }
                    //methodo
                    //System.out.println("lastViewPost id: "+lastViewPost);
                    //System.out.println("lastViewPostSize: "+lastViewPostSize);
                    //System.out.println("lastViewPhoto id: "+lastViewPhoto);
                    //System.out.println("lastViewPhotoSize: "+lastViewPhotoSize);

                    storage.StoreViewOneUser(lastViewPost, lastViewPostSize, lastViewPhoto, lastViewPhotoSize, last_edit);
                }

            }

        }
    }

    private void ViewFriendUser(final float lf, ArrayList<User> userList, int last_edit) {

        ArrayList<Integer> counterPost = new ArrayList<Integer>();//create arraylist gia ta counterPost
        ArrayList<Integer> counterPhoto = new ArrayList<Integer>();//create arraylist gia ta counterPhoto

        Random randNums = new Random();
        float rd = randNums.nextFloat();
        int listSize = userList.size();
        int listFriendSize = friendList.size();
        int listPhotoSize = photoList.size();
        if (rd > 1 - lf * pFrview) {//sxesh paragwghs Fview

            if (listFriendSize > 1) {
                //gemizw tis listes counterPost kai counterPhoto
                for (int i = 0; i < listFriendSize; i++) {
                    User myfriend = userList.get(friendList.get(i));

                    counterPost.add((myfriend.postList.size()) - 1);//gemizw thn lista counterPost
                    counterPhoto.add((myfriend.photoList.size()) - 1);//gemizw thn lista counterPhoto
                }

                int sum = 0;
                int post_timeline = 0;
                int photo_timeline = 0;

                boolean end_list = false;

                while ((sum < 400) && (end_list == false)) {//oso sum <400 kai h lista exei pragmata mesa
                    int max = 0, user_index = 0;
                    String kind = "";

                    for (int i = 0; i < friendList.size(); i++) {
                        User myfriend = userList.get(friendList.get(i));
                        //pernw apo thn lista twn filwn mou thn postlist tous kai trabaw to teleutaio

                        if (counterPost.get(i) >= 0) {

                            post_timeline = myfriend.postList.get(counterPost.get(i)).last_edit;

                            if (post_timeline > max) {//an to teleutaio megalutero tou max
                                max = post_timeline;
                                kind = "post";
                                user_index = i;
                            }
                        }

                        if (counterPhoto.get(i) >= 0) {
                            photo_timeline = myfriend.photoList.get(counterPhoto.get(i)).last_edit;

                            if (photo_timeline > max) {
                                max = photo_timeline;
                                kind = "photo";
                                user_index = i;
                            }
                            //edw xerw oti prepei na parw apo to xrhsth user_index to teleutaio
                            //post h thn teleutaia photo tou.

                        }
                    }//end for

                    if (kind == "post") {
                        User myfriend = userList.get(friendList.get(user_index));

                        String key = String.valueOf(counterPost.get(user_index));//kane to int string
                        //String key1 = String.valueOf(user_index);//counterPost
                        String key1 = String.valueOf(friendList.get(user_index));//apo tou filous mou pare id
                        String key2 = "_";
                        String key3 = key1 + key2 + key;

                        lastViewPost.add(key3);
                        lastViewPostSize.add(myfriend.postList.get(counterPost.get(user_index)).Sizeposts);

                        int x = counterPost.get(user_index);
                        counterPost.set(user_index, (x - 1));//meiwnw to stoixrio ths lista kata -1
                        sum++;
                    }

                    if (kind == "photo") {
                        User myfriend = userList.get(friendList.get(user_index));

                        String key = String.valueOf(counterPhoto.get(user_index));
                        //String key1 = String.valueOf(user_index);//counterPhoto
                        String key1 = String.valueOf(friendList.get(user_index));
                        String key2 = "_";
                        String key3 = key1 + key2 + key;

                        lastViewPhoto.add(key3);
                        lastViewPhotoSize.add(myfriend.photoList.get(counterPhoto.get(user_index)).Sizephotos);

                        int x = counterPhoto.get(user_index);
                        counterPhoto.set(user_index, (x - 1));//meiwnw to stoixrio ths lista kata -1
                        sum++;
                    }

                    for (int u = 0; u < counterPost.size(); u++) {
                        if (counterPost.get(u) == -1) {//otan adeiasei h lista kane to end_list true
                            end_list = true;
                        }
                    }

                    for (int u1 = 0; u1 < counterPhoto.size(); u1++) {
                        if (counterPhoto.get(u1) == -1) {//otan adeiasei h lista kane to end_list true
                            end_list = true;
                        }
                    }

                }//end while

               // System.out.println("lastViewPost id: " + lastViewPost);
                // System.out.println("lastViewPostSize: " + lastViewPostSize);
                // System.out.println("lastViewPhoto id: " + lastViewPhoto);
                // System.out.println("lastViewPhotoSize: " + lastViewPhotoSize);
                storage.StoreViewFriendUser(lastViewPost, lastViewPostSize, lastViewPhoto, lastViewPhotoSize, last_edit);
                //kalese th methodo StoreViewFriendUser ths classis Storage gia thn storage
            }

        }

    }

}
