public class up {
    int mpsUp;
    int price;
    int owned;
    int tempInt;

    public int getMpsUp() {
        return mpsUp;
    }

    public void setMpsUp(int mpsUp) {
        this.mpsUp = mpsUp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned += owned;
    }
    public void bought(){
        tempInt =(int) Math.round(getPrice()*1.25);
        setPrice(tempInt);
        tempInt = 0;
        owned++;
    }

}
