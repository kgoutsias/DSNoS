package dsons;

/**
 * @author kostas
 */
import dsons.User;

//import static dsons.User.printPost;
//import static dsons.User.action;
//import static dsons.User.post;
import java.util.Random; //ths klashs math 0.0<=x<=1.0
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.jfree.ui.RefineryUtilities;
//import org.jfree.ui.RefineryUtilities;

public class DSoNs {

    public static void main(String[] args) {

        ArrayList<User> userList = new ArrayList<User>();//orizei mia arraylist userList

        //HashMap<String, Integer> twn post,photo,request,accept,newfriend,likepost,likephoto,user_num 
        HashMap<String, Integer> posts = new HashMap<String, Integer>();
        posts.put("A", 0);
        posts.put("B", 0);
        posts.put("C", 0);
        posts.put("D", 0);
        posts.put("E", 0);

        HashMap<String, Integer> num_users = new HashMap<String, Integer>();
        num_users.put("A", 0);
        num_users.put("B", 0);
        num_users.put("C", 0);
        num_users.put("D", 0);
        num_users.put("E", 0);

        HashMap<String, Integer> photos = new HashMap<String, Integer>();
        photos.put("A", 0);
        photos.put("B", 0);
        photos.put("C", 0);
        photos.put("D", 0);
        photos.put("E", 0);

        HashMap<String, Integer> request = new HashMap<String, Integer>();
        request.put("A", 0);
        request.put("B", 0);
        request.put("C", 0);
        request.put("D", 0);
        request.put("E", 0);

        HashMap<String, Integer> accept = new HashMap<String, Integer>();
        accept.put("A", 0);
        accept.put("B", 0);
        accept.put("C", 0);
        accept.put("D", 0);
        accept.put("E", 0);

        HashMap<String, Integer> newfriend = new HashMap<String, Integer>();
        newfriend.put("A", 0);
        newfriend.put("B", 0);
        newfriend.put("C", 0);
        newfriend.put("D", 0);
        newfriend.put("E", 0);

        HashMap<String, Integer> likeposts = new HashMap<String, Integer>();
        likeposts.put("A", 0);
        likeposts.put("B", 0);
        likeposts.put("C", 0);
        likeposts.put("D", 0);
        likeposts.put("E", 0);

        HashMap<String, Integer> likephotos = new HashMap<String, Integer>();
        likephotos.put("A", 0);
        likephotos.put("B", 0);
        likephotos.put("C", 0);
        likephotos.put("D", 0);
        likephotos.put("E", 0);

        final int Days, num_node, space_node, req_sec, Download_kb_sec,Upload_kb_sec;
        final float lf;
        float users_max, rd3, rd, time;
        int stop_simul = 0;
        int sec, j = 0, rd1 = 0, rd2 = 0, z = 0, mm = 1, mm1=1;
        int userA = 0, userB = 0, userC = 0, userD = 0, userE = 0;
        int Max_Delay =0;
        
        
        
        // =============read var me thn methodo Scaner===============
   /*     Scanner input = new Scanner(System.in);//diabazei thn timh pou dinei o xrhsths
        System.out.println("Dwse ena pragmatiko aritmo metaxi tou [0 - 1] pou deixnei thn kinhsh tou diktuo: ");
        lf = input.nextFloat();//eisagei enan float lf(opou lf h kinhsh tou diktuou)
        if ((lf >= 0.0) && (lf <= 1.0)) { //min kai max oriou kinhshs diktuou
            System.out.printf("H klimaka kinhshs tou diktuou einai lf= %f\n", lf);
        } else {
            System.out.println("lathos timh xana prospathhse!\n");
            return;
        }
        System.out.println("Poses meres epithumeis na kaneis prosomoiwsh ? ");
        Days = input.nextInt();//eisagei ton aritmo ton hmerwn pou tha ginei prosomoiwsh
        System.out.printf("Meres prosomoiwshs: %d\n", Days);

        System.out.println("Posa Node epithumeis na dhmiourghseis ? ");
        num_node = input.nextInt();//eisagei ton aritmo ton node
        System.out.printf("Node pou dhmiourghthikan: %d\n", num_node);

        System.out.println("dwse to spacenode tou node ?");
        space_node = input.nextInt();//eisagei ton xwro tou Node
        System.out.printf("to spacenode tou node einai : %d\n", space_node);

        System.out.println("Posa request/sec exupureth to node ?");
        req_sec = input.nextInt();//eisagei ton aritmo ton request/sec
        System.out.printf("Req/sec einai: %d\n", req_sec);

        System.out.println("Posa Download_kb_sec diaxeirizetai to node ?");
        Download_kb_sec = input.nextInt();//eisagei ton aritmo ton KB/sec
        System.out.printf("KB/Sec einai : %d\n", Download_kb_sec);
        System.out.println("Posa Upload_kb_sec diaxeirizetai to node ?");
        Upload_kb_sec = input.nextInt();//eisagei ton aritmo ton KB/sec
        System.out.printf("KB/Sec einai : %d\n", Upload_kb_sec);
*/
        
        
         if (args.length == 0) {
            System.out.println("No Command Line arguments");
        }
        else if (args.length != 8){
            System.out.println("Error sto plhthos twn metablhtwn! Xana prospathise...");
        }
        else {
            System.out.println("You provided " + args.length + " arguments");

            for (int i = 0; i < args.length; i++) {
                //System.out.println("args[" + i + "]: "+ args[i]);
            }
        }

         lf = Float.valueOf(args[0]);
         Days = Integer.valueOf(args[1]);
         num_node = Integer.valueOf(args[2]);
         space_node = Integer.valueOf(args[3]);
         req_sec = Integer.valueOf(args[4]);
         Download_kb_sec = Integer.valueOf(args[5]);
         Upload_kb_sec = Integer.valueOf(args[6]);
         Max_Delay = Integer.valueOf(args[7]);
        System.out.println("Rate_Traffic_Net: lf= " + lf + "    Days= " + Days
                + "    Num_node= " + num_node + "    Space_node= " + space_node + "    req/sec= " + req_sec
                + "    Download_kb/sec= " + Download_kb_sec
                + "    Upload_kb/sec= " + Upload_kb_sec
                + "    Max_Delay= " + Max_Delay);
        
        
        
        users_max = lf * 1000 * Days;//epithumhtoi_users
        sec = Days * 1440 *60;//lepta pou trexei h prosomoiwsh
       // System.out.printf("epithumhtoi_users: %f\n", users_max);

        Random randNums = new Random();//paragwgh tuxaiou arithmou

        //dhmiourgei mia nea storage sths Storage 
        Storage storage = new Storage(num_node, space_node, req_sec,Download_kb_sec,Upload_kb_sec,Max_Delay);
        PowerLaw chance = new PowerLaw(new Random(System.currentTimeMillis()));
        Node nodeclass = new Node(space_node, req_sec,Download_kb_sec,Upload_kb_sec,Max_Delay);
        
        
        while ((j < sec) && (stop_simul == 0)) {//oso j < apo lepta prosomoiwshs pou edwse o xrhsths
           // Long t1= System.nanoTime();
            //System.out.print(j+"\n");
            time = hourtraffic(j); //kalese th methodo hourtraffic 

            storage.NewTimeSlot(j);//kalei th methodo NewTimeSlot ths Storage gia th storage

            //System.out.println(q) ;
            rd = randNums.nextFloat(); //parhgage tuxaia ena n akeraio
            if (rd >= 1 - ((lf * time * 1000) / (1440 *60 ) )) { //an rd >= tote paragei neo xrhsth ana day
                rd1++; //auxhse tous uparxontes xrhstes kata 1

                rd3 = randNums.nextFloat();//parhgage tuxaio float
                if (rd3 >= 0.0 && rd3 < 0.16) { //an anhkei o float sto pedio orismou rd3 tote anhkei sthn cat:A  
                    userA++; //auxhse tous uparxontes xrhstes ths Cat:A kata 1
                    User user = new User(rd1 - 1, "A", storage,chance); //pernoume kai to id=0
                    userList.add(user);//prothhkh sth userList ton userA   

                    storage.StoreUser(rd1 - 1,j);//kalei th methodo StoreUser ths class Storage gia thn storage

                } else if (rd3 >= 0.16 && rd3 < 0.49) {//an anhkei o float sto pedio orismou rd3 tote anhkei sthn cat:B
                    userB++;//auxhse tous uparxontes xrhstes ths Cat:B kata 1
                    User user = new User(rd1 - 1, "B", storage,chance);
                    userList.add(user);//prothhkh sth userList ton userB  

                    storage.StoreUser(rd1 - 1,j);//kalei th methodo StoreUser ths class Storage gia thn storage

                } else if (rd3 >= 0.49 && rd3 < 0.75) {//an anhkei o float sto pedio orismou rd3 tote anhkei sthn cat:C
                    userC++;//auxhse tous uparxontes xrhstes ths Cat:C kata 1
                    User user = new User(rd1 - 1, "C", storage,chance);
                    userList.add(user);//prothhkh sth userList ton userC  

                    storage.StoreUser(rd1 - 1,j);//kalei th methodo StoreUser ths class Storage gia thn storage

                } else if (rd3 >= 0.75 && rd3 < 0.93) {//an anhkei o float sto pedio orismou rd3 tote anhkei sthn cat:D
                    userD++;//auxhse tous uparxontes xrhstes ths Cat:D kata 1
                    User user = new User(rd1 - 1, "D", storage,chance);
                    userList.add(user);//prothhkh sth userList ton userD

                    storage.StoreUser(rd1 - 1,j);//kalei th methodo StoreUser ths class Storage gia thn storage

                } else {//(rd3 >= 0.93 && rd3 <= 1)
                    userE++;//auxhse tous uparxontes xrhstes ths Cat:E kata 1
                    User user = new User(rd1 - 1, "E", storage,chance);
                    //user.setIDnum(rd1);
                    //user.setCATEGORY("E");
                    userList.add(user);//prothhkh sth userList ton userD
                    // action(Days,lf);

                    storage.StoreUser(rd1 - 1,j);//kalei th methodo StoreUser ths class Storage gia thn storage

                }
            } else {//den dhmiourgei neo xrhsth to susthma
                rd2++;//metra tous apotuxhmenous xrhstes
            }
           // Long t2 =  System.nanoTime();
            int listSize = userList.size();// bale to megethos ths userList se mia metablhth
            for (int k = 0; k < listSize; k++) {//gia kathe sthxeio ths userList
                User user = (User) userList.get(k);//pare to xrhsth k ths userList kai balton sto user
                user.action(lf * time, userList, j);//kalese th methodo action ths class User

                // System.out.println("id_user: "+k +"time slot: "+j);
            }
           // Long t3 =  System.nanoTime();
          //  System.out.println("Timeslot : "+j);
          //  System.out.println("Users : "+userList.size());
          //  System.out.println("User creation : "+(new Integer((int) (t2-t1))));
          //  int a=new Integer((int) (t3-t2));
          //  double b = (double)a/userList.size();
          //  System.out.println("Users actions : "+a+"("+b+")");
// 
//            for (int m=0;m<listSize; m++){
//                User user = (User) userList.get(m);
//                int PostSizeSu = user.postList.size();
//                System.out.println("id_user: "+user.id + " timeSlot: "+j);
//                for (int g=0;g<PostSizeSu;g++){
//                    //System.out.println("id_user: "+user.id + " timeSlot: "+j);
//                    Post post = (Post) user.postList.get(g);
//                    int PostSizeLike = post.postLike.size();
//                    System.out.println("post last_edit: "+post.last_edit + " Size postLike: "+PostSizeLike);
//                }
//              
//            }
//            for (int m=0;m<listSize; m++){
//                User user = (User) userList.get(m);
//                int PhotoSizeSu = user.photoList.size();
//                System.out.println("id_user: "+user.id + " timeSlot: "+j);
//                for (int g=0;g<PhotoSizeSu;g++){
//                    //System.out.println("id_user: "+user.id + " timeSlot: "+j);
//                    Photo photo = (Photo) user.photoList.get(g);
//                    int PhotoSizeLike = photo.photoLike.size();
//                    System.out.println("photo last_edit: "+photo.last_edit + " Size photoLike: "+PhotoSizeLike);
//                }
//              
//            }
            storage.MAXListMin();//kalei th methodo MAXListMin sths class Storage
            
            if (j % (3600/60) == 0){//kathe  min 60sec
                
               // System.out.println("======>>> 1 min epanalhpshs: " + mm1);
                if (storage.cutRequest() == true){
                    stop_simul = 1;
                }
                mm1++;
        }
            
            
            if (j % 86400  == 0) { //an mesanuxta ana second ana 24 hours

                //System.out.println("======>Mera epanalhpshs: " + mm);//metra tis meres epanalhpshs
                storage.MaxListNight();//kalei th methodo MAXListNight sths class Storage
                
                storage.display_night();
                
                if (storage.cutRequest() == true){
                    stop_simul = 1;
                }
                

                System.out.println("Day: "+ mm +"    Users: " + storage.userNode.size() + "    Posts: " + storage.postNode.size() +
                        "    Photos: " + storage.photoNode.size() +
                        "    Average Used Space: "+storage.average_space_used+"%" +
                        "    Max Used Space: "+(storage.max_space_used / space_node)+"%"+
                        "    Average Delay: "+(storage.average_delay / num_node)+
                        "    Max Delay: "+(storage.max_delay_node ));
                //ektupwse to size ths userNode
               // System.out.println("post: " + storage.postNode.size());//ektupwse to size ths postNode
               // System.out.println("photo: " + storage.photoNode.size());//ektupwse to size ths photoNode

                
                //System.out.println("Max Delay: "+nodeclass.max_delay);
                //System.out.println("used space sum: "+storage.sum);
                //System.out.println("used space max: "+storage.max_space_used);
                
               
                //System.out.println("Average Space Used: "+storage.average_space_used);
                
                
                //HashMap <Integer, Integer> dixnei to node sto opoio einai kai to id tou
                //gia to userfor,postfor,photofor,requestfor,acceptfor,likepostfor,likephotofor
                HashMap<Integer, Integer> userfor = new HashMap<Integer, Integer>();
                for (int node = 0; node < storage.nodeList.size(); node++) {
                    userfor.put(node, 0);
                }

                HashMap<Integer, Integer> postfor = new HashMap<Integer, Integer>();
                for (int node = 0; node < storage.nodeList.size(); node++) {
                    postfor.put(node, 0);
                }

                HashMap<Integer, Integer> photofor = new HashMap<Integer, Integer>();
                for (int node = 0; node < storage.nodeList.size(); node++) {
                    photofor.put(node, 0);
                }

                HashMap<Integer, Integer> requestfor = new HashMap<Integer, Integer>();
                for (int node = 0; node < storage.nodeList.size(); node++) {
                    requestfor.put(node, 0);
                }

                HashMap<Integer, Integer> acceptfor = new HashMap<Integer, Integer>();
                for (int node = 0; node < storage.nodeList.size(); node++) {
                    acceptfor.put(node, 0);
                }

                HashMap<Integer, Integer> likepostfor = new HashMap<Integer, Integer>();
                for (int node = 0; node < storage.nodeList.size(); node++) {
                    likepostfor.put(node, 0);
                }

                HashMap<Integer, Integer> likephotofor = new HashMap<Integer, Integer>();
                for (int node = 0; node < storage.nodeList.size(); node++) {
                    likephotofor.put(node, 0);
                }

                for (int k = 0; k < listSize; k++) {//for mexri to userListSize
                    User user = (User) userList.get(k);
                    Integer nodeID = storage.userNode.get(k);//bale ston nodeID th thesh tou userNode tou antistoixou k
                    userfor.put(nodeID, userfor.get(nodeID) + 1);//bale sto userfor to node sto opoio brisketai kai to id tou

                    //postfor.put(nodeID, postfor.get(nodeID) + storage.post_cou);
                    //bale sto postfor to node sto opoio brisketai kai to sunolo ton post tou
                    postfor.put(nodeID, postfor.get(nodeID) + user.post_counter);
                    //bale sto postfor to node sto opoio brisketai kai to sunolo ton photo tou
                    photofor.put(nodeID, photofor.get(nodeID) + user.photo_counter);
                    //bale sto postfor to node sto opoio brisketai kai to sunolo ton req_friend tou
                    requestfor.put(nodeID, requestfor.get(nodeID) + user.req_friend_cn);
                    //bale sto postfor to node sto opoio brisketai kai to sunolo ton acc_friend tou
                    acceptfor.put(nodeID, acceptfor.get(nodeID) + user.acc_friend_cn);
                    //bale sto postfor to node sto opoio brisketai kai to sunolo ton likepost tou
                    likepostfor.put(nodeID, likepostfor.get(nodeID) + user.likepost);
                    //bale sto postfor to node sto opoio brisketai kai to sunolo ton likephoto tou
                    likephotofor.put(nodeID, likephotofor.get(nodeID) + user.likephoto);
                    // System.out.println("kokok"+nodeID);
                }

                
                
           /*     for (int node = 0; node < storage.nodeList.size(); node++) {
                    System.out.println("The node: " + node + " request_node: " + storage.nodeList.get(node).total_request
                            + " Total users request: " + storage.nodeList.get(node).total_users
                            + " Total posts request: " + storage.nodeList.get(node).total_posts
                            + " Total photos request: " + storage.nodeList.get(node).total_photos
                            + " Total post like request: " + storage.nodeList.get(node).total_post_like
                            + " Total photos like request: " + storage.nodeList.get(node).total_photo_like
                            + " Total Request_friendship request: " + storage.nodeList.get(node).total_request_fri
                            + " Total Accept_friendship request: " + storage.nodeList.get(node).total_accept_fri);
                }
                
               */ 

                /*     for (int node = 0; node < storage.nodeList.size(); node++) {
                 System.out.println("Users the node " + node + ": " + userfor.get(node));

                 System.out.println("Posts the node " + node + ": " + postfor.get(node));
                 float x = ((float) postfor.get(node) / (userfor.get(node)));
                 System.out.println("M.O post ana user: " + x);

                 System.out.println("Photos the node " + node + ": " + photofor.get(node));
                 float x1 = ((float) photofor.get(node) / (userfor.get(node)));
                 System.out.println("M.O photo ana user: " + x1);

                 System.out.println("Request the node " + node + ": " + requestfor.get(node));
                 float x2 = ((float) requestfor.get(node) / (userfor.get(node)));
                 System.out.println("M.O request ana user: " + x2);

                 System.out.println("Accept the node " + node + ": " + acceptfor.get(node));
                 float x3 = ((float) acceptfor.get(node) / (userfor.get(node)));
                 System.out.println("M.O accept ana user: " + x3);
                    
                 System.out.println("Like Post the node " + node + ": " + likepostfor.get(node));
                 float x4 = ((float) likepostfor.get(node) / (userfor.get(node)));
                 System.out.println("M.O like post ana user: " + x4);
                    
                 System.out.println("Like Photo the node " + node + ": " + likephotofor.get(node));
                 float x5 = ((float) likephotofor.get(node) / (userfor.get(node)));
                 System.out.println("M.O like photo ana user: " + x5);
                 }
                 */
                mm++;//auxhse thn mera kata 1

            }

            j++;//auxanei ta lepta kata ena 
            //System.out.println("sec: "+j);
        }

        //System.out.println("Mera:" + mm / storage.nodeList.size() + " MaxArrayList: " + max);
       // System.out.println("*******************************************************");
       // System.out.printf("new users: %d\n", rd1);
       // System.out.printf("fail users: %d\n", rd2);
        System.out.println("*******************************************************");

        int listSize = userList.size();//bale to megethos ths userList se mia metablhth
  /*      System.out.println("ArrayList Size is :" + listSize);
        System.out.println("*******************************************************");

        System.out.println("Categories Users: ");
        System.out.printf("Openness to experience Users : %d\n", userA);
        System.out.printf("Extraversion Users: %d\n", userB);
        System.out.printf("Neuroticism Users: %d\n", userC);
        System.out.printf("Conscientiousness Users: %d\n", userD);
        System.out.printf("Agreeableness Users: %d\n", userE);
        System.out.println("*******************************************************");
*/
//        for (int k = 0; k < listSize; k++) {
//            System.out.println(userList.get(k).getID() + " " + userList.get(k).getCATEGORY());
//        }
       // System.out.println("*******************************************************");
        // int post=0,postA=0,postB=0,postC=0,postD=0,postE=0;

        
        
/*        for (int k = 0; k < listSize; k++) {// gia kathe sthxeio ths userList
            User user = (User) userList.get(k);//pare to xrhsth k ths userList kai balton sto user
            user.printPost();//kalese th methodo printPost ths class User

        }
        
        
*/

        for (int k = 0; k < listSize; k++) {// gia kathe sthxeio ths userList
            User user = (User) userList.get(k);//pare to xrhsth k ths userList kai balton sto user
            String cat = user.category;//bale sth metablhrh cat thn category tou user
            num_users.put(cat, num_users.get(cat) + 1);//num_user apoteleite apo thn [cat,id]

            posts.put(cat, posts.get(cat) + user.post_counter);//dwse ton sunoliko aritmo post apo kathe cat 
            photos.put(cat, photos.get(cat) + user.photo_counter);//dwse ton sunoliko aritmo photo apo kathe cat
            request.put(cat, request.get(cat) + user.req_friend_cn);//dwse ton sunoliko aritmo request friendship apo kathe cat
            accept.put(cat, accept.get(cat) + user.acc_friend_cn);//dwse ton sunoliko aritmo accept friendship apo kathe cat
            newfriend.put(cat, newfriend.get(cat) + user.addfriend);//dwse ton sunoliko aritmo new friend apo kathe cat
            likeposts.put(cat, likeposts.get(cat) + user.likepost);//dwse ton sunoliko aritmo likepost apo kathe cat
            likephotos.put(cat, likephotos.get(cat) + user.likephoto);//dwse ton sunoliko aritmo likephoto apo kathe cat

        }

        /*
        
//        System.out.println("");
//        System.out.println("******************** POST ****************************");

        float x = ((float) posts.get("A") / (num_users.get("A") * Days));//meso oro post gia thn cat:A ana hmera
        // float xa=((float) x) / Days;

//        System.out.println("Openness to experience Users [sunolikos arithmos post ths cat:]=" + posts.get("A"));
//        System.out.println("Openness to experience Users [sunolikos arithmos users ths cat:]=" + num_users.get("A"));
//        System.out.println("Openness to experience Users [mesos oros post gia thn cat:]=" + x);
//        System.out.println("");
        float x1 = ((float) posts.get("B") / (num_users.get("B") * Days));//meso oro post gia thn cat:B ana hmera
//        System.out.println("Extraversion Users [sunolikos arithmos post ths cat:]=" + posts.get("B"));
//        System.out.println("Extraversion Users [sunolikos arithmos users ths cat:]=" + num_users.get("B"));
//        System.out.println("Extraversion Users [mesos oros post gia thn cat:]=" + x1);
//        System.out.println("");
        float x2 = ((float) posts.get("C") / (num_users.get("C") * Days));//meso oro post gia thn cat:C ana hmera
        System.out.println("Neuroticism Users [sunolikos arithmos post ths cat:]=" + posts.get("C"));
        System.out.println("Neuroticism Users [sunolikos arithmos users ths cat:]=" + num_users.get("C"));
        System.out.println("Neuroticism Users [mesos oros post gia thn cat:]=" + x2);
        System.out.println("");
        float x3 = ((float) posts.get("D") / (num_users.get("D") * Days));//meso oro post gia thn cat:D ana hmera
        System.out.println("Conscientiousness Users [sunolikos arithmos post ths cat:]=" + posts.get("D"));
        System.out.println("Conscientiousness Users [sunolikos arithmos users ths cat:]=" + num_users.get("D"));
        System.out.println("Conscientiousness Users [mesos oros post gia thn cat:]=" + x3);
        System.out.println("");
        float x4 = ((float) posts.get("E") / (num_users.get("E") * Days));//meso oro post gia thn cat:E ana hmera
        System.out.println("Agreeableness Users [sunolikos arithmos post ths cat:]=" + posts.get("E"));
        System.out.println("Agreeableness Users [sunolikos arithmos users ths cat:]=" + num_users.get("E"));
        System.out.println("Agreeableness Users [mesos oros post gia thn cat:]=" + x4);

        System.out.println("");
        System.out.println("******************** PHOTO ****************************");

        float y = ((float) photos.get("A") / (num_users.get("A") * Days));//meso oro photo gia thn cat:A ana hmera
        System.out.println("Openness to experience Users [sunolikos arithmos photo ths cat:]=" + photos.get("A"));
        System.out.println("Openness to experience Users [sunolikos arithmos users ths cat:]=" + num_users.get("A"));
        System.out.println("Openness to experience Users [mesos oros photo gia thn cat:]=" + y);
        System.out.println("");
        float y1 = ((float) photos.get("B") / (num_users.get("B") * Days));//meso oro photo gia thn cat:B ana hmera
        System.out.println("Extraversion Users [sunolikos arithmos photo ths cat:]=" + photos.get("B"));
        System.out.println("Extraversion Users [sunolikos arithmos users ths cat:]=" + num_users.get("B"));
        System.out.println("Extraversion Users [mesos oros photo gia thn cat:]=" + y1);
        System.out.println("");
        float y2 = ((float) photos.get("C") / (num_users.get("C") * Days));//meso oro photo gia thn cat:C ana hmera
        System.out.println("Neuroticism Users [sunolikos arithmos photo ths cat:]=" + photos.get("C"));
        System.out.println("Neuroticism Users [sunolikos arithmos users ths cat:]=" + num_users.get("C"));
        System.out.println("Neuroticism Users [mesos oros photo gia thn cat:]=" + y2);
        System.out.println("");
        float y3 = ((float) photos.get("D") / (num_users.get("D") * Days));//meso oro photo gia thn cat:D ana hmera
        System.out.println("Conscientiousness Users [sunolikos arithmos photo ths cat:]=" + photos.get("D"));
        System.out.println("Conscientiousness Users [sunolikos arithmos users ths cat:]=" + num_users.get("D"));
        System.out.println("Conscientiousness Users [mesos oros photo gia thn cat:]=" + y3);
        System.out.println("");
        float y4 = ((float) photos.get("E") / (num_users.get("E") * Days));//meso oro photo gia thn cat:E ana hmera
        System.out.println("Agreeableness Users [sunolikos arithmos photo ths cat:]=" + photos.get("E"));
        System.out.println("Agreeableness Users [sunolikos arithmos users ths cat:]=" + num_users.get("E"));
        System.out.println("Agreeableness Users [mesos oros photo gia thn cat:]=" + y4);

        System.out.println("");
        System.out.println("******************** REQUEST ****************************");

        float m = ((float) request.get("A") / (num_users.get("A") * Days));//meso oro request gia thn cat:A ana hmera
        System.out.println("Openness to experience Users [sunolikos arithmos request ths cat:]=" + request.get("A"));
        System.out.println("Openness to experience Users [sunolikos arithmos users ths cat:]=" + num_users.get("A"));
        System.out.println("Openness to experience Users [mesos oros request gia thn cat:]=" + m);
        System.out.println("");
        float m1 = ((float) request.get("B") / (num_users.get("B") * Days));//meso oro request gia thn cat:B ana hmera
        System.out.println("Extraversion Users [sunolikos arithmos request ths cat:]=" + request.get("B"));
        System.out.println("Extraversion Users [sunolikos arithmos users ths cat:]=" + num_users.get("B"));
        System.out.println("Extraversion Users [mesos oros request gia thn cat:]=" + m1);
        System.out.println("");
        float m2 = ((float) request.get("C") / (num_users.get("C") * Days));//meso oro request gia thn cat:C ana hmera
        System.out.println("Neuroticism Users [sunolikos arithmos request ths cat:]=" + request.get("C"));
        System.out.println("Neuroticism Users [sunolikos arithmos users ths cat:]=" + num_users.get("C"));
        System.out.println("Neuroticism Users [mesos oros request gia thn cat:]=" + m2);
        System.out.println("");
        float m3 = ((float) request.get("D") / (num_users.get("D") * Days));//meso oro request gia thn cat:D ana hmera
        System.out.println("Conscientiousness Users [sunolikos arithmos request ths cat:]=" + request.get("D"));
        System.out.println("Conscientiousness Users [sunolikos arithmos users ths cat:]=" + num_users.get("D"));
        System.out.println("Conscientiousness Users [mesos oros request gia thn cat:]=" + m3);
        System.out.println("");
        float m4 = ((float) request.get("E") / (num_users.get("E") * Days));//meso oro request gia thn cat:E ana hmera
        System.out.println("Agreeableness Users [sunolikos arithmos request ths cat:]=" + request.get("E"));
        System.out.println("Agreeableness Users [sunolikos arithmos users ths cat:]=" + num_users.get("E"));
        System.out.println("Agreeableness Users [mesos oros request gia thn cat:]=" + m4);

        System.out.println("");
        System.out.println("******************** ACCEPT ****************************");

        float v = ((float) accept.get("A") / (num_users.get("A") * Days));//meso oro accept gia thn cat:A ana hmera
        System.out.println("Openness to experience Users [sunolikos arithmos accept ths cat:]=" + accept.get("A"));
        System.out.println("Openness to experience Users [sunolikos arithmos users ths cat:]=" + num_users.get("A"));
        System.out.println("Openness to experience Users [mesos oros accept gia thn cat:]=" + v);
        System.out.println("");
        float v1 = ((float) accept.get("B") / (num_users.get("B") * Days));//meso oro accept gia thn cat:B ana hmera
        System.out.println("Extraversion Users [sunolikos arithmos accept ths cat:]=" + accept.get("B"));
        System.out.println("Extraversion Users [sunolikos arithmos users ths cat:]=" + num_users.get("B"));
        System.out.println("Extraversion Users [mesos oros accept gia thn cat:]=" + v1);
        System.out.println("");
        float v2 = ((float) accept.get("C") / (num_users.get("C") * Days));//meso oro accept gia thn cat:C ana hmera
        System.out.println("Neuroticism Users [sunolikos arithmos accept ths cat:]=" + accept.get("C"));
        System.out.println("Neuroticism Users [sunolikos arithmos users ths cat:]=" + num_users.get("C"));
        System.out.println("Neuroticism Users [mesos oros accept gia thn cat:]=" + v2);
        System.out.println("");
        float v3 = ((float) accept.get("D") / (num_users.get("D") * Days));//meso oro accept gia thn cat:D ana hmera
        System.out.println("Conscientiousness Users [sunolikos arithmos request ths cat:]=" + accept.get("D"));
        System.out.println("Conscientiousness Users [sunolikos arithmos users ths cat:]=" + num_users.get("D"));
        System.out.println("Conscientiousness Users [mesos oros request gia thn cat:]=" + v3);
        System.out.println("");
        float v4 = ((float) accept.get("E") / (num_users.get("E") * Days));//meso oro accept gia thn cat:E ana hmera
        System.out.println("Agreeableness Users [sunolikos arithmos accept ths cat:]=" + accept.get("E"));
        System.out.println("Agreeableness Users [sunolikos arithmos users ths cat:]=" + num_users.get("E"));
        System.out.println("Agreeableness Users [mesos oros accept gia thn cat:]=" + v4);

        System.out.println("");
        System.out.println("******************** RATIO ACCEPT-REQUEST ****************************");

        float rat = ((float) v / m);
        System.out.println("Openness to experience Users [o mesos logos accept-request:]=" + rat);
        System.out.println("");
        float rat1 = ((float) v1 / m1);
        System.out.println("Extraversion Users  [o mesos logos accept-request:]=" + rat1);
        System.out.println("");
        float rat2 = ((float) v2 / m2);
        System.out.println("Neuroticism Users [o mesos logos accept-request:]=" + rat2);
        System.out.println("");
        float rat3 = ((float) v3 / m3);
        System.out.println("Conscientiousness Users [o mesos logos accept-request:]=" + rat3);
        System.out.println("");
        float rat4 = ((float) v4 / m4);
        System.out.println("Agreeableness Users [o mesos logos accept-request:]=" + rat4);

        System.out.println("");
        System.out.println("******************** NEW FRIEND ****************************");

        float w = ((float) newfriend.get("A") / (num_users.get("A") * Days));
        System.out.println("Openness to experience Users [sunolikos arithmos newfriend ths cat:]=" + newfriend.get("A"));
        System.out.println("Openness to experience Users [sunolikos arithmos users ths cat:]=" + num_users.get("A"));
        System.out.println("Openness to experience Users [mesos oros newfriend gia thn cat:]=" + w);
        System.out.println("");
        float w1 = ((float) newfriend.get("B") / (num_users.get("B") * Days));
        System.out.println("Extraversion Users [sunolikos arithmos newfriend ths cat:]=" + newfriend.get("B"));
        System.out.println("Extraversion Users [sunolikos arithmos users ths cat:]=" + num_users.get("B"));
        System.out.println("Extraversion Users [mesos oros newfriend gia thn cat:]=" + w1);
        System.out.println("");
        float w2 = ((float) newfriend.get("C") / (num_users.get("C") * Days));
        System.out.println("Neuroticism Users [sunolikos arithmos newfriend ths cat:]=" + newfriend.get("C"));
        System.out.println("Neuroticism Users [sunolikos arithmos users ths cat:]=" + num_users.get("C"));
        System.out.println("Neuroticism Users [mesos oros newfriend gia thn cat:]=" + w2);
        System.out.println("");
        float w3 = ((float) newfriend.get("D") / (num_users.get("D") * Days));
        System.out.println("Conscientiousness Users [sunolikos arithmos newfriend ths cat:]=" + newfriend.get("D"));
        System.out.println("Conscientiousness Users [sunolikos arithmos users ths cat:]=" + num_users.get("D"));
        System.out.println("Conscientiousness Users [mesos oros newfriend gia thn cat:]=" + w3);
        System.out.println("");
        float w4 = ((float) newfriend.get("E") / (num_users.get("E") * Days));
        System.out.println("Agreeableness Users [sunolikos arithmos newfriend ths cat:]=" + newfriend.get("E"));
        System.out.println("Agreeableness Users [sunolikos arithmos users ths cat:]=" + num_users.get("E"));
        System.out.println("Agreeableness Users [mesos oros newfriend gia thn cat:]=" + w4);

        System.out.println("");
        System.out.println("******************** LIKE POST ****************************");

        float s = ((float) likeposts.get("A") / (posts.get("A") * Days));
        System.out.println("Openness to experience Users [sunolikos arithmos likeposts ths cat:]=" + likeposts.get("A"));
        System.out.println("Openness to experience Users [sunolikos arithmos post ths cat:]=" + posts.get("A"));
        System.out.println("Openness to experience Users [mesos oros likeposts gia thn cat:]=" + s);
        System.out.println("");
        float s1 = ((float) likeposts.get("B") / (posts.get("B") * Days));
        System.out.println("Extraversion Users [sunolikos arithmos likeposts ths cat:]=" + likeposts.get("B"));
        System.out.println("Extraversion Users [sunolikos arithmos post ths cat:]=" + posts.get("B"));
        System.out.println("Extraversion Users [mesos oros likeposts gia thn cat:]=" + s1);
        System.out.println("");
        float s2 = ((float) likeposts.get("C") / (posts.get("C") * Days));
        System.out.println("Neuroticism Users [sunolikos arithmos likeposts ths cat:]=" + likeposts.get("C"));
        System.out.println("Neuroticism Users [sunolikos arithmos post ths cat:]=" + posts.get("C"));
        System.out.println("Neuroticism Users [mesos oros likeposts gia thn cat:]=" + s2);
        System.out.println("");
        float s3 = ((float) likeposts.get("D") / (posts.get("D") * Days));
        System.out.println("Conscientiousness Users [sunolikos arithmos likeposts ths cat:]=" + likeposts.get("D"));
        System.out.println("Conscientiousness Users [sunolikos arithmos post ths cat:]=" + posts.get("D"));
        System.out.println("Conscientiousness Users [mesos oros likeposts gia thn cat:]=" + s3);
        System.out.println("");
        float s4 = ((float) likeposts.get("E") / (posts.get("E") * Days));
        System.out.println("Agreeableness Users [sunolikos arithmos likeposts ths cat:]=" + likeposts.get("E"));
        System.out.println("Agreeableness Users [sunolikos arithmos post ths cat:]=" + posts.get("E"));
        System.out.println("Agreeableness Users [mesos oros likeposts gia thn cat:]=" + s4);

        System.out.println("");
        System.out.println("******************** LIKE PHOTO ****************************");

        float t = ((float) likephotos.get("A") / (photos.get("A") * Days));
        System.out.println("Openness to experience Users [sunolikos arithmos likephotos ths cat:]=" + likephotos.get("A"));
        System.out.println("Openness to experience Users [sunolikos arithmos photo ths cat:]=" + photos.get("A"));
        System.out.println("Openness to experience Users [mesos oros likephotos gia thn cat:]=" + t);
        System.out.println("");
        float t1 = ((float) likephotos.get("B") / (photos.get("B") * Days));
        System.out.println("Extraversion Users [sunolikos arithmos likephotos ths cat:]=" + likephotos.get("B"));
        System.out.println("Extraversion Users [sunolikos arithmos photo ths cat:]=" + photos.get("B"));
        System.out.println("Extraversion Users [mesos oros likephotos gia thn cat:]=" + t1);
        System.out.println("");
        float t2 = ((float) likephotos.get("C") / (photos.get("C") * Days));
        System.out.println("Neuroticism Users [sunolikos arithmos likephotos ths cat:]=" + likephotos.get("C"));
        System.out.println("Neuroticism Users [sunolikos arithmos photo ths cat:]=" + photos.get("C"));
        System.out.println("Neuroticism Users [mesos oros likephotos gia thn cat:]=" + t2);
        System.out.println("");
        float t3 = ((float) likephotos.get("D") / (photos.get("D") * Days));
        System.out.println("Conscientiousness Users [sunolikos arithmos likephotos ths cat:]=" + likephotos.get("D"));
        System.out.println("Conscientiousness Users [sunolikos arithmos photo ths cat:]=" + photos.get("D"));
        System.out.println("Conscientiousness Users [mesos oros likephotos gia thn cat:]=" + t3);
        System.out.println("");
        float t4 = ((float) likephotos.get("E") / (photos.get("E") * Days));
        System.out.println("Agreeableness Users [sunolikos arithmos likephotos ths cat:]=" + likephotos.get("E"));
        System.out.println("Agreeableness Users [sunolikos arithmos photo ths cat:]=" + photos.get("E"));
        System.out.println("Agreeableness Users [mesos oros likephotos gia thn cat:]=" + t4);

        System.out.println("");
        System.out.println("******************** ============ ****************************");

/*        //DIAGRAMMATA
        final BarChartPost MOpost = new BarChartPost("Average Post Per Day ", x, x1, x2, x3, x4);
        MOpost.pack();
        RefineryUtilities.centerFrameOnScreen(MOpost);
        MOpost.setVisible(true);

        final BarChartPhoto MOphoto = new BarChartPhoto("Average Photo Per Day ", y, y1, y2, y3, y4);
        MOphoto.pack();
        RefineryUtilities.centerFrameOnScreen(MOphoto);
        MOphoto.setVisible(true);

        final BarChartRequestFriendship MOrequest = new BarChartRequestFriendship("Average Request Per Day ", m, m1, m2, m3, m4);
        MOrequest.pack();
        RefineryUtilities.centerFrameOnScreen(MOrequest);
        MOrequest.setVisible(true);

        final BarChartAcceptFriendship MOaccept = new BarChartAcceptFriendship("Average Accept Per Day ", v, v1, v2, v3, v4);
        MOaccept.pack();
        RefineryUtilities.centerFrameOnScreen(MOaccept);
        MOaccept.setVisible(true);

        final RatioAcceptRequestFriendship MOratio = new RatioAcceptRequestFriendship("Average Ratio Accept/Request Per Day ", rat, rat1, rat2, rat3, rat4);
        MOratio.pack();
        RefineryUtilities.centerFrameOnScreen(MOratio);
        MOratio.setVisible(true);

        final BarChartNewFriend MOnewFriend = new BarChartNewFriend("Average New Friends  Per Day ", w, w1, w2, w3, w4);
        MOnewFriend.pack();
        RefineryUtilities.centerFrameOnScreen(MOnewFriend);
        MOnewFriend.setVisible(true);

        final BarChartLikePost MOLikePost = new BarChartLikePost("Average Like Post  Per Day ", s, s1, s2, s3, s4);
        MOLikePost.pack();
        RefineryUtilities.centerFrameOnScreen(MOLikePost);
        MOLikePost.setVisible(true);

        final BarChartLikePhoto MOLikePhoto = new BarChartLikePhoto("Average Like Photo  Per Day ", t, t1, t2, t3, t4);
        MOLikePhoto.pack();
        RefineryUtilities.centerFrameOnScreen(MOLikePhoto);
        MOLikePhoto.setVisible(true);
*/
    
    }

    //*************************************************************  
    static float hourtraffic(int j) {//kinhsh duktiou ana wra to 24 wro hmeras
        int hour;
        float time = 0, time1 = 0;
        hour = (j / 3600) % 24;//to time slot einai se deuterolepta

        if (hour >= 0 && hour < 8) {//apo 0-8 suntelesths =0.2
            time = (float) 0.2;

        } else if (hour >= 16 && hour < 22) {
            time = (float) 1; //apo 16-22 suntelesths = 1
        } else if (hour >= 8 && hour < 16) {
            for (int i = 8; i < 16; i++) {
                time1 = (float) (time1 + 0.1);//apo 8-16 o suntelesths auxanete apo 0.2 sun 0.1 kathe wra pou perna
                time = time1 + (float) 0.2;
            }

        } else if (hour >= 22 && hour <= 24) {
            for (int i = 22; i < 24; i++) {
                time1 = (float) (time1 - 0.3);//apo 22-24 o suntelesths meiwnetai apo 1 meion 0.3 kathe wra pou perna
                time = time1 + (float) 1;
            }
        }
        return time; //epistrefei ton suntelesth
    }

    static void sel(Storage storage) {
        for (int node = 0; node < storage.nodeList.size(); node++) {
            int x = storage.nodeList.get(node).Req_anam.size();
            System.out.println("Gia to node: " + node + " To Size ths ArrayList is******++++: " + x);
            int max = Integer.MIN_VALUE;
            for (int pp = 0; pp < storage.nodeList.get(node).Req_anam.size(); pp++) {
                if ((storage.nodeList.get(node).Req_anam.get(pp) > max)) {
                    max = storage.nodeList.get(node).Req_anam.get(pp);
                    // System.out.println(" MaxArrayList?????????????????%%%%: " + max);  
                }

            }
        }
    }

}
