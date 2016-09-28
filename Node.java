package dsons;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

/**
 * @author kostas
 */
public class Node {

    public int total_request;
    public int total_users, total_posts, total_photos, total_post_like, total_photo_like;
    public int total_request_fri, total_accept_fri;

    public int min_delay, max_delay, num_of_delay, sum_of_delay, AVR;

    public int space_node, req_sec, Download_kb_sec, Upload_kb_sec, Max_Delay;
    static int UserSize = 4;
    //static int PostSize = 2;
    //static int PhotoSize = 400;

    //private Queue<Integer> Req_anam = new LinkedList<Integer>();
    public ArrayList<Integer> Req_anam = new ArrayList<Integer>();
    public ArrayList<Integer> Time_Req_anam = new ArrayList<Integer>();
    public ArrayList<Integer> Item_Req = new ArrayList<Integer>();

    public int total_space;
    public int req_queue, space_queue;
    public int req_remaining, space_remaining_Down, space_remaining_Up;

    public Node(final int space_node, final int req_sec, final int Download_kb_sec, final int Upload_kb_sec, final int Max_Delay) {

        this.total_request = 0;
        this.total_users = 0;
        this.total_posts = 0;
        this.total_photos = 0;
        this.total_post_like = 0;
        this.total_photo_like = 0;

        this.min_delay = 999999;
        this.max_delay = 0;
        this.num_of_delay = 0;
        this.sum_of_delay = 0;
        this.AVR = 0;

        this.space_node = space_node;
        this.req_sec = req_sec;
        this.Download_kb_sec = Download_kb_sec;
        this.Upload_kb_sec = Upload_kb_sec;
        this.Max_Delay = Max_Delay;
        
        this.total_space = 0;
        this.req_remaining = 0; //posa mporw na exhpurethsw se auto to timeslot ana pasa sthgmh
        this.req_queue = 0; //osa req exoun meinei sth seira
        this.space_remaining_Down = 0;//posa kb mporw na exhpurethsw se auto to timeslot ana pasa sthgmh
        this.space_remaining_Up = 0;//posa kb mporw na exhpurethsw se auto to timeslot ana pasa sthgmh
        this.space_queue = 0;//osa kb exoun meinei sth seira

    }

    public void NodestoreUser(int time_slot) {
        total_space = total_space + UserSize;

        //System.out.println("Used Space Node: " + total_space);
        ManageReq(UserSize, time_slot, 0);

        this.total_users++;
    }

    public void NodestorePost(int Sizeposts, int time_slot) {
        total_space = total_space + Sizeposts;

        // System.out.println("Used Space Node: " + total_space);
        ManageReq(Sizeposts, time_slot, 0);

        this.total_posts++;
    }

    public void NodestoreLikePost(int time_slot) {
        //total_space = total_space + PostSize;

        //System.out.println("Used Space Node: " + total_space);
        ManageReq(0, time_slot, 0);

        this.total_post_like++;
    }

    public void NodestorePhoto(int Sizephotos, int time_slot) {
        total_space = total_space + Sizephotos;

        // System.out.println("Used Space Node: " + total_space);
        ManageReq(Sizephotos, time_slot, 0);

        this.total_photos++;
    }

    public void NodestoreLikePhoto(int time_slot) {

        ManageReq(0, time_slot, 0);

        this.total_photo_like++;
    }

    public void NodestoreRequestFriendship(int time_slot) {

        ManageReq(0, time_slot, 0);

        this.total_request_fri++;
    }

    public void NodestoreAcceptFriendship(int time_slot) {

        ManageReq(0, time_slot, 0);

        this.total_accept_fri++;
    }

    public void NodeStoreViewOneUser(int SizeNode, int time_slot) {
        ManageReq(SizeNode, time_slot, 1);
    }

    public void NodeStoreViewFriendUser(int SizeNode, int time_slot) {
        ManageReq(SizeNode, time_slot, 1);
    }

    public boolean ManageReq(int kb_req, int time_slot, int item) {

        this.total_request++;

        //System.out.println("&&&&&: "+this.total_request);
        if (item == 0) {
            if ((req_remaining > 0) && (space_remaining_Up > kb_req)) {
                req_remaining = req_remaining - 1;
                space_remaining_Up = space_remaining_Up - kb_req;

                int Delay = 0;

                if (Delay < this.min_delay) {
                    this.min_delay = Delay;
                }
                if (Delay > this.max_delay) {
                    this.max_delay = Delay;
                }
                this.num_of_delay = this.num_of_delay + 1;
                this.sum_of_delay = this.sum_of_delay + Delay;
                this.AVR = this.sum_of_delay / this.num_of_delay;

                return true;
            } else {
                //System.out.println("size Kb_req: "+kb_req);
                //System.out.println("size Kb_sec: "+kb_sec);
                int y = kb_req % Upload_kb_sec;
                int x = kb_req / Upload_kb_sec;
                for (int i = 0; i < x; i++) {
                    Req_anam.add(Upload_kb_sec);
                    Time_Req_anam.add(time_slot);
                    Item_Req.add(item);
                }
                Req_anam.add(y);
                Time_Req_anam.add(time_slot);
                Item_Req.add(item);
                //edw h lista
                //System.out.println("size array^^^: "+Req_anam);
                //Req_anam.add(kb_req); //gia thn arraylist
                return false;
            }
        } else {
            if ((req_remaining > 0) && (space_remaining_Down > kb_req)) {
                req_remaining = req_remaining - 1;
                space_remaining_Down = space_remaining_Down - kb_req;

                int Delay = 0;

                if (Delay < this.min_delay) {
                    this.min_delay = Delay;
                }
                if (Delay > this.max_delay) {
                    this.max_delay = Delay;
                }
                this.num_of_delay = this.num_of_delay + 1;
                this.sum_of_delay = this.sum_of_delay + Delay;
                this.AVR = this.sum_of_delay / this.num_of_delay;

                return true;
            } else {
                //System.out.println("size Kb_req: "+kb_req);
                //System.out.println("size Kb_sec: "+kb_sec);
                int y = kb_req % Download_kb_sec;
                int x = kb_req / Download_kb_sec;
                for (int i = 0; i < x; i++) {
                    Req_anam.add(Download_kb_sec);
                    Time_Req_anam.add(time_slot);
                    Item_Req.add(item);
                }
                Req_anam.add(y);
                Time_Req_anam.add(time_slot);
                Item_Req.add(item);
                //edw h lista
                //System.out.println("size array^^^: "+Req_anam);
                //Req_anam.add(kb_req); //gia thn arraylist
                return false;
            }
        }
    }

    //elegxei se kathe time slot ta req
    /*   public void NewTimes(int id) {

     //System.out.println("The number req_remaining is: " + req_remaining);
     //System.out.println("The number space_remaining is: " + space_remaining);

     // for (Integer ko : Req_anam) {
     System.out.println("Queue: " + Req_anam);
     //  System.out.println("@@@@@####$$$$$*****The elements[KB_req] of queue: " + ko);
     // }
     req_remaining = req_sec;
     space_remaining = kb_sec;

     int flag = 0;
     //int SizeReq_anam = Req_anam.size();

     while (((Req_anam.size()) > 0) && (flag == 0)) {

     Integer x = Req_anam.peek();

     if (x < space_remaining && req_remaining >0 )  {
     req_remaining = req_remaining - 1;
     space_remaining = space_remaining - x;

     Req_anam.remove();//???
     } else {
     flag = 1;
     }
     }

     }

     */
    //****** B tropos me ArrayList(den ton dokimasa) *****    
    public void NewTimes(int id, int time_slot) {

        //System.out.println("The number req_remaining is: " + req_remaining);
        //System.out.println("The number space_remaining is: " + space_remaining);
        int listSize = Req_anam.size();// bale to megethos ths userList se mia metablhth

       // System.out.println("Node: " +id+ " Array: " + Req_anam);  
        
        req_remaining = req_sec;
        space_remaining_Down = Download_kb_sec;
        space_remaining_Up = Upload_kb_sec;
        //int SizeReq_anam = Req_anam.size();
        int i = 0;
        while (((Req_anam.size()) > i)) { //thelei kai ena metrhth pou tha deixnei pou einai 

            int element = Req_anam.get(i); // get(0)

            if (Item_Req.get(i) == 1 ) {
                if (element < space_remaining_Down && req_remaining > 0) {
                    req_remaining = req_remaining - 1;
                    space_remaining_Down = space_remaining_Down - element;

                    Req_anam.remove(i);//??? OR first_ele  -> Req_anam.remove(element);

                    int x1 = Time_Req_anam.get(i);//o xronos pou exei mpei
                    int Delay = time_slot - x1;

                    if (Delay < this.min_delay) {
                        this.min_delay = Delay;
                    }
                    if (Delay > this.max_delay) {
                        this.max_delay = Delay;
                    }
                    this.num_of_delay = this.num_of_delay + 1;
                    this.sum_of_delay = this.sum_of_delay + Delay;
                    this.AVR = this.sum_of_delay / this.num_of_delay;

                    //  System.out.println("Delay is: "+Delay);
                    Time_Req_anam.remove(i);
                    Item_Req.remove(i);
                } else {

                    i++;
                }
            }
            else {
                if (element < space_remaining_Up && req_remaining > 0) {
                    req_remaining = req_remaining - 1;
                    space_remaining_Up = space_remaining_Up - element;

                    Req_anam.remove(i);//??? OR first_ele  -> Req_anam.remove(element);

                    int x1 = Time_Req_anam.get(i);//o xronos pou exei mpei
                    int Delay = time_slot - x1;

                    if (Delay < this.min_delay) {
                        this.min_delay = Delay;
                    }
                    if (Delay > this.max_delay) {
                        this.max_delay = Delay;
                    }
                    this.num_of_delay = this.num_of_delay + 1;
                    this.sum_of_delay = this.sum_of_delay + Delay;
                    this.AVR = this.sum_of_delay / this.num_of_delay;

                    //  System.out.println("Delay is: "+Delay);
                    Time_Req_anam.remove(i);
                    Item_Req.remove(i);
                } else {
                    i++;
                }
            }

        }

    }

    public void node_display_night() {

    /*    System.out.println("The min delay is: " + this.min_delay);
        System.out.println("The max delay is: " + this.max_delay);
        System.out.println("The numbers of delay is: " + this.num_of_delay);
        System.out.println("The Sum of delay is: " + this.sum_of_delay);
        System.out.println("The AVR of delay is: " + this.AVR);
*/
        
        this.min_delay = 999999;
        this.max_delay = 0;
        this.num_of_delay = 0;
        this.sum_of_delay = 0;
        this.AVR = 0;
    }

    //tha kanw mia methodo edw pou tha aporriptei to max display 
    public boolean CutMaxDelay() {
       // System.out.println("to max_delay : "+this.max_delay);
        if ( (this.max_delay >= Max_Delay) || (this.total_space > space_node)) {
            return true;
        } else {
            return false;
        }
    }

}
