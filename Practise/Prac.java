import java.util.*;
class PurchaseOrder{
    int id;
    String name;
    double amount;
    public PurchaseOrder(int id, String name,double amount){
        this.id=id;
        this.name=name;
        this.amount=amount;
    }  
    @Override
    public String toString(){
        return "PurchaseOrder{" +
                "id=" + id +
                ", productName='" + name + '\'' +
                ", quantity=" + amount +
                '}';
    }
}
public class Prac {
    /*Show all Placed orders */
    public static void showOrders(List<PurchaseOrder> orders){
      
        for(PurchaseOrder item:orders){
            System.out.println(item);
        }
    }
    /*add order */
    public static void addOrders(List<PurchaseOrder> orders, PurchaseOrder order){
        orders.add(order);
    }
    /*Removes a order by mentioned id */
    public static void cancelOrderById(List<PurchaseOrder> orders , int id){
        Iterator<PurchaseOrder> it=orders.iterator();
        while(it.hasNext()){
            if(it.next().id==id){
                it.remove();
            }
        }
    }
    /*Finds and return order by id */
    public static PurchaseOrder findOrderById(List<PurchaseOrder> orders,int id){
        for(PurchaseOrder order:orders){
            if(order.id==id){
                return order;
            }
        }
        return null;
    }
    /*Calculate total amount */
    public static double CalculateTotalAmount(List<PurchaseOrder> orders){
        double total=0;
        for(PurchaseOrder order:orders){
            total+=order.amount;
        }
        return total;
    }
    /*Update Order price by findind it by id */
    public static boolean updateOrderAmount(List<PurchaseOrder> orders, int id, double newAmount) {
        PurchaseOrder o = findOrderById(orders, id);
        if (o != null) {
            o.amount = newAmount;
            return true;
        }
        return false;
    }
   public static void main (String[] args){
        List<PurchaseOrder> orders=new ArrayList<>();
        orders.add(new PurchaseOrder(1,"Pen",3));
        orders.add(new PurchaseOrder(2,"Pencil",5));
        orders.add(new PurchaseOrder(3,"Book",50));
        orders.add(new PurchaseOrder(4,"Pencil",5));
        showOrders(orders);
        System.out.println("After remove: ");
        orders.remove(3);
        showOrders(orders);
   } 
}
