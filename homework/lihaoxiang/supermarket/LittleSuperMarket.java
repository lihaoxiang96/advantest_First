package homework.lihaoxiang.supermarket;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;

    public void describe(LittleSuperMarket LittleSuperMarket) {
        System.out.println("本店叫作" + this.superMarketName+"。\t本店的地址为" + this.address+
                "。\t共有停车位" + this.parkingCount + "个。\t今天的营业额为" +this.incomingSum+
                "。\t共有商品" + this.merchandises.length + "种。");
    }
}
