public class Counter {
    //class variables:name & count
    private String name;

    private int count = 0;

    //constructor
    Counter(String id){
        this.name=id;
    }
    //method of counter
    void inc(){
        count++;
    }
    //count times
    int tally(){
        return count;
    }
    //print
    public String toString(){
        return name + count;
    }
    //check if is Even
    public void incrementEven(int result) {
        if (result % 2 == 0) {
            count++;
        }
    }
    //check if is odd
    public void incrementOdd(int result) {
        if (result % 2 != 0) {
            count++;
        }
    }
}
