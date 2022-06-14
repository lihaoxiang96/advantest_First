package constuoroverloadstatic.supermarket;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public int merchandiseCount;
    double activityDiscount=0.7;
    public int Count;
    public MerchandiseV2WithStaticVariable[] merchandises;


    public LittleSuperMarket(String superMarketName, String address, int parkingCount, int merchandiseCount, int Count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
        this.merchandiseCount = merchandiseCount;
        this.Count = Count;
    }


    //返回值类型可以是类名，这时候实际返回的值就是这个类的引用
    public MerchandiseV2WithStaticVariable getBigeerProfitMerchandise() {
        MerchandiseV2WithStaticVariable curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV2WithStaticVariable m = merchandises[i];
            if (curr == null || curr.calculateProfit() < m.calculateProfit()) {
                curr = m;
            }
        }
        return curr;
    }

    public MerchandiseV2WithStaticVariable getMerchandideOf(int merchandiseIndex) {
        if (merchandiseIndex < 0 || merchandiseIndex >= merchandises.length) {
            return null;
        }
        return merchandises[merchandiseIndex];
    }
}
