import java.util.ArrayList;
public class ArrayUtils{
    public static int findCustomerByRoomId(int roomId){
        int count = 0;
        ArrayList<Customer> customers = new ArrayList<Customer>();
        for(int i=1;i<customers.size();i++){
            if(customers.get(i).getRoomNumber() == roomId){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}