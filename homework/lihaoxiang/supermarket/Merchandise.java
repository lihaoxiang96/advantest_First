package homework.lihaoxiang.supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;
    String madeIn;

    //>> TODO 访问修饰符
    //>> TODO 返回值类型：无需返回值则用void表示，void是Java中的关键字
    //>> TODO 方法任意合法的标识符都可以
    //>> TODO 参数列表：后续讲解
    //>> TODO 方法体：方法的代码
    //>> TODO 方法体内部定义的变量叫作局部变量
    public void describe() {
        double netIncome = soldPrice - purchasePrice;
        System.out.println("商品名为" + name + "，商品编号为" + id + "。售价为" + soldPrice
                + "。");
    }

    //计算商品的净利润
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        //>> TODO  这个return是代码块里的return，是return所在代码快的最后一个语句
        return profit;
        //>> TODO 一个方法可以有多个返回值
    }

    //购买成功，计算消费总额
    public double buyCount(int numToBuy) {
        double totalCost = 0;
        this.count -= numToBuy;
        return totalCost = numToBuy * this.soldPrice;
    }

}
