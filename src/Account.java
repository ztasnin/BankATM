public class Account {
    private double money;

    public Account(){
        money = 30;
    }

    public void addCash(double toAdd){
        money+=toAdd;
    }

    public void withdrawCash(double toRemove){
        money-=toRemove;
    }

    public double getBalance(){
        return money;
    }
}
