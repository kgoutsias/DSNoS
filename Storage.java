package dsons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * @author kostas
 */
public class Storage {

    public int space_node, req_sec, Download_kb_sec,Upload_kb_sec,Max_Delay;

    public int post_cou, sum, gino;
    public float max_space_used, max_delay_node;
    public double average_space_used, average_delay, sum_delay;

    public ArrayList<Node> nodeList = new ArrayList<Node>(); //lista twn node
    public ArrayList<Integer> ListFortou = new ArrayList<Integer>(); //lista fortou request
    public ArrayList<Integer> ListMAX = new ArrayList<Integer>();

    HashMap<Integer, Integer> userNode = new HashMap<>();
    HashMap<String, Integer> postNode = new HashMap<>();
    HashMap<String, Integer> photoNode = new HashMap<>();

    public Storage(final int num_node, final int space_node, final int req_sec, final int Download_kb_sec, final int Upload_kb_sec,final int Max_Delay) {

        this.space_node = space_node;
        this.req_sec = req_sec;
        this.Download_kb_sec = Download_kb_sec;
        this.Upload_kb_sec = Upload_kb_sec;
        this.Max_Delay = Max_Delay;

        this.post_cou = 0;
        this.sum = 0;
        this.sum_delay = 0;
        this.gino = 0;
        this.max_space_used = 0;
        this.max_delay_node = 0;
        this.average_space_used = 0;
        this.average_delay = 0;

        for (int i = 0; i < num_node; i++) {
            Node node = new Node(space_node, req_sec, Download_kb_sec,Upload_kb_sec,Max_Delay);
            nodeList.add(node);//bazoume twn aritmo twn node sth lista
        }

       //--->gia thn SelectNodeFortou gemizei me mhden thn arraylist
        for (int i = 0; i < num_node; i++) {
            //gemizoume thn listFortou me theseis osa einai ta node kai tis arxikopioume ths theseis me mhden
            ListFortou.add(0);
        }

        for (int i = 0; i < num_node; i++) {
            //gemizoume thn listFortou me theseis osa einai ta node kai tis arxikopioume ths theseis me mhden
            ListMAX.add(0);
        }

    }

    public void StoreUser(int id,int time_slot) {
        int z;
//gia thn SelectNode thn prwth methodo tuxaia tous xrhstes
       // z = SelectNode(); //se poio kombo tha apothhkeutei //gia thn SelectNode

        
        
//-->gia thn SelectNodeFortou thn deuterh methodo bazei to xrhsth sto min(space) node
        z = SelectNodeFortou(); //gia thn SelectNodeFortou epistrefei ton kombo sto z
        int x = ListFortou.get(z); //to megethos ths listfortou sth thesh z
        ListFortou.set(z, x + 1); //auxanei to megethos +1 ths listfortou sth thesh auth

        userNode.put(id, z);//bazw sto userNode id tou user kai to node sto opoio apothukeutike
        
        
        Node cnode = nodeList.get(z);//dhmiourgei to antikeimeno cnode ths klashs node
        cnode.NodestoreUser(time_slot);//kalei th methodo nodestoreUser ths klashs node

        //System.out.println("id user:"+ id +" the node Save:"+z);
    }

    public void StorePost(int id, int post_id, int Sizeposts,int time_slot) {
        int z;

        this.post_cou++;
       
        
         z =  SelectNode(); //bazei tuxaia to post sta node
        
        
        //-->gia thn SelectNodeFortou thn deuterh methodo bazei to post sto min(space) node
  //      z = SelectNodeFortou(); //gia thn SelectNodeFortou epistrefei ton kombo sto z
  //      int x = ListFortou.get(z); //to megethos ths listfortou sth thesh z
  //      ListFortou.set(z, x + 1); //auxanei to megethos +1 ths listfortou sth thesh auth
        
        
        //z = userNode.get(id); //get user's node dinei to node pou brisketai to id \1 ulopoihsh

        String key = String.valueOf(id);
        String key1 = String.valueOf(post_id);
        String key2 = "_";
        String key3 = key + key2 + key1;
        //System.out.println("kostas####: "+key3);
        postNode.put(key3, z);//bazw sto postNode id tou user kai to node sto opoio apothukeutike
        
       // int x = ListFortou.get(z);
        //System.out.println("%%%%%%%%%% H PROHGOYMENH TIMH TOY PINAKA: "+(x));
       // ListFortou.set(z, x + 1);  // inserting elment x+1 at Xrd position the ListFortou

        Node cnode = nodeList.get(z);
        cnode.NodestorePost(Sizeposts,time_slot);

        //System.out.println("id user:"+ id +" the node Save:"+z);
    }

    public void StoreLikePost(String id,int time_slot) {
        
        int c = postNode.get(id);
        //System.out.println("&&&&post: "+c);
        
        //int c = userNode.get(id); //get user's post node

        Node cnode = nodeList.get(c);
        cnode.NodestoreLikePost(time_slot);

        //System.out.println("id user:"+ id +" the node Save:"+z);
    }

    public void StorePhoto(int id, int photo_id, int Sizephotos,int time_slot) {
        int z;
        
         z =  SelectNode(); //bazei tuxaia to post sta node
      
        
       //-->gia thn SelectNodeFortou thn deuterh methodo bazei th photo sto min(space) node
   //     z = SelectNodeFortou(); //gia thn SelectNodeFortou epistrefei ton kombo sto z
    //    int x = ListFortou.get(z); //to megethos ths listfortou sth thesh z
    //    ListFortou.set(z, x + 1); //auxanei to megethos +1 ths listfortou sth thesh auth
        
        
        //int z = userNode.get(id); //get user's node 1 ulopoihsh

        String key = String.valueOf(id);
        String key1 = String.valueOf(photo_id);
        String key2 = "_";
        String key3 = key + key2 + key1;
        photoNode.put(key3, z);

        //gia thn SelectNodeFortou 
        // System.out.println("%%%%%%%%%%% KOMBOS: "+z);
       // int x = ListFortou.get(z);
        //System.out.println("%%%%%%%%%% H PROHGOYMENH TIMH TOY PINAKA: "+(x));
       // ListFortou.set(z, x + 1);  // inserting elment x+1 at Xrd position the ListFortou

        //this.post_cou++;
        Node cnode = nodeList.get(z);
        cnode.NodestorePhoto(Sizephotos,time_slot);

        //System.out.println("id user:"+ id +" the node Save:"+z);
    }

    public void StoreLikePhoto(String id,int time_slot) {//id pou kanei to post

         int c = photoNode.get(id);
         //System.out.println("@@@@photo: "+c);
        //int c = userNode.get(id); //get user's photo node
        
        
        Node cnode = nodeList.get(c);
        cnode.NodestoreLikePhoto(time_slot);

        //System.out.println("id user:"+ id +" the node Save:"+z);
    }

    public void StoreRequestFriendship(int id,int time_slot) {
        int z;
        z = userNode.get(id);//get user's request node 
        Node cnode = nodeList.get(z);
        cnode.NodestoreRequestFriendship(time_slot);

        //System.out.println("id user:"+ id +" the node Save:"+z);
    }

    public void StoreAcceptFriendship(int id, int num,int time_slot) {
        int z, b;
        z = userNode.get(id);//get user's accept node 
        Node cnode = nodeList.get(z);
        cnode.NodestoreAcceptFriendship(time_slot);

        b = userNode.get(num);//get user's accept node 
        cnode = nodeList.get(b);
        cnode.NodestoreAcceptFriendship(time_slot);

        //System.out.println("id user:"+ id +" the node Save:"+z);
    }

    private int SelectNode() {
        Random rnd1 = new Random();
        int num = 0;
        int nodeListSize = nodeList.size();
        num = rnd1.nextInt(nodeListSize);
        return num;
    }

    private int SelectNodeFortou() {
        //int x =ListFortou.indexOf(Collections.min(ListFortou));

        //System.out.println("##############"+x);
        return ListFortou.indexOf(Collections.min(ListFortou));

//B' tropos eureshs min
    }

    public void NewTimeSlot(int time_slot) {
        int nodeListSize = nodeList.size();
        long t1 = System.nanoTime();
        for (int i = 0; i < nodeListSize; i++) {
            Node cnode1 = nodeList.get(i);
            if (cnode1.req_queue > 0) {
                System.out.println("Gia to node " + i + " exw " + cnode1.req_queue + " Req_Queue");
            }

            long t2 = System.nanoTime();
            //System.out.println("@@@_User creation new time slot by storage : "+(new Integer((int) (t2-t1))));
            long t3 = System.nanoTime();
            cnode1.NewTimes(i,time_slot);
            long t4 = System.nanoTime();
            int SizeSelectReq = nodeList.get(i).Req_anam.size();
            //System.out.println("Gia to node: "+i+ " To Size ths ArrayList is: "+SizeSelectReq);
            long t5 = System.nanoTime();
            //System.out.println("@@@_User creation new time by NOde##### : "+(new Integer((int) (t4-t3))));
           // System.out.println("@@@_User creation new time slot by storage : "+(new Integer((int) (t5-t1))));
        }
        
    }

    public void MAXListMin() { //maximum list kathe lepto

        int nodeListSize = nodeList.size();
        for (int i = 0; i < nodeListSize; i++) {
            int SizeSelectReq = nodeList.get(i).Req_anam.size();
            //if (SizeSelectReq > 1){

            if (ListMAX.get(i) < SizeSelectReq) {
                ListMAX.set(i, SizeSelectReq);
                //System.out.println(" MaxArrayList?????????????????%%%%: " + ListMAX);  
            }

        }

    }

    public void MaxListNight() { // h maximum list ti nixta se sugkrish me ola ths hmeras
        int nodeListSize = nodeList.size();
      //  System.out.println(" MaxArrayList?????????????????%%%%: " + ListMAX);
        for (int i = 0; i < nodeListSize; i++) {
            ListMAX.set(i, 0);

        }
    }

    public void StoreViewOneUser(ArrayList<String> lastViewPost, ArrayList<Integer> lastViewPostSize, ArrayList<String> lastViewPhoto, ArrayList<Integer> lastViewPhotoSize,int time_slot) {

        ArrayList<Integer> ListNodeRequest = new ArrayList<Integer>();

        for (int t = 0; t < nodeList.size(); t++) {
            ListNodeRequest.add(0);
            //System.out.println("koko####"+ListNodeRequest);
        }

        for (int i = 0; i < lastViewPost.size(); i++) {
            int z = postNode.get(lastViewPost.get(i)); //to node sto opoio einai to post
            //System.out.println("prpprprpr$$$$: " + z);
            int x = ListNodeRequest.get(z); //to megethos pou eixe prin

            ListNodeRequest.set(z, (x + lastViewPostSize.get(i)));
            //ListNodeRequest.set(z, (x + postNode.get(lastViewPostSize.get(i) )));
        }

        for (int j = 0; j < lastViewPhoto.size(); j++) {
            int z = photoNode.get(lastViewPhoto.get(j)); //to node sto opoio einai to post

            int x = ListNodeRequest.get(z); //to megethos pou eixe prin

            ListNodeRequest.set(z, (x + lastViewPhotoSize.get(j)));
            //ListNodeRequest.set(z, (x + photoNode.get(lastViewPostSize.get(i) )));
        }

        for (int k = 0; k < ListNodeRequest.size(); k++) {
            if (ListNodeRequest.get(k) > 0) {
                nodeList.get(k).NodeStoreViewOneUser(ListNodeRequest.get(k),time_slot);
               //****// System.out.println("The Node: " + k + " The Size: " + ListNodeRequest.get(k));
            }
        }
      //****//  System.out.println("One_User: ");

    }

    public void StoreViewFriendUser(ArrayList<String> lastViewPost, ArrayList<Integer> lastViewPostSize, ArrayList<String> lastViewPhoto, ArrayList<Integer> lastViewPhotoSize,int time_slot) {

        ArrayList<Integer> ListNodeRequest = new ArrayList<Integer>();

        for (int t = 0; t < nodeList.size(); t++) {
            ListNodeRequest.add(0);
            //System.out.println("koko####"+ListNodeRequest);
        }

        for (int i = 0; i < lastViewPost.size(); i++) {
            int z = postNode.get(lastViewPost.get(i)); //to node sto opoio einai to post
           // System.out.println("prpprprpr$$$$: " + z);
            int x = ListNodeRequest.get(z); //to megethos pou eixe prin

            ListNodeRequest.set(z, (x + lastViewPostSize.get(i)));
            //ListNodeRequest.set(z, (x + postNode.get(lastViewPostSize.get(i) )));
        }

        for (int j = 0; j < lastViewPhoto.size(); j++) {

            int z = photoNode.get(lastViewPhoto.get(j)); //to node sto opoio einai to post

            int x = ListNodeRequest.get(z); //to megethos pou eixe prin

            ListNodeRequest.set(z, (x + lastViewPhotoSize.get(j)));
            //ListNodeRequest.set(z, (x + photoNode.get(lastViewPostSize.get(i) )));
        }

        for (int k = 0; k < ListNodeRequest.size(); k++) {
            if (ListNodeRequest.get(k) > 0) {
                nodeList.get(k).NodeStoreViewFriendUser(ListNodeRequest.get(k),time_slot);
               // System.out.println("The Node: " + k + " The Size: " + ListNodeRequest.get(k));
            }
        }
       // System.out.println("Friend_User: ");
    }
    
    public void display_night() {
        
        for (int i = 0; i < nodeList.size(); i++) {
            // System.out.println("Data on the Node: "+i);
            Node cnode = nodeList.get(i);
            cnode.node_display_night();

            //System.out.println("???: "+cnode.total_space);
            sum = sum + cnode.total_space;

            sum_delay = (double) sum_delay + cnode.AVR;

            if (max_space_used < cnode.total_space) {
                max_space_used = cnode.total_space;
            }

            if (max_delay_node < cnode.max_delay) {
                max_delay_node = cnode.max_delay;
            }

        }

        //System.out.println("used space sum: "+sum);
        gino = nodeList.size() * space_node;
        average_space_used = (double) sum / gino;
        average_delay = (double) sum_delay;

    }
    
    //tha kanw mia methodo pou tha kalw thn nea methodo apo to node
    //kai auth apo dw thn methodo thn kaloume apo thn basikh klassh 
    public boolean cutRequest(){
        for (int i=0;i<nodeList.size();i++){
           //System.out.println("Data on the Node: "+i);
           Node cnode = nodeList.get(i);
           if (cnode.CutMaxDelay() == true){
               System.out.println("@@@@@@@@#######STOP_SIMULEITON######@@@@@@@@");
               return true;
           }
           
        }
        return false;
    }

}
