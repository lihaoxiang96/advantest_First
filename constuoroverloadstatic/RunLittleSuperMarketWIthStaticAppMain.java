package constuoroverloadstatic;

import constuoroverloadstatic.supermarket.LittleSuperMarket;
import constuoroverloadstatic.supermarket.MerchandiseV2WithStaticVariable;


public class RunLittleSuperMarketWIthStaticAppMain {
    public static void main(String[] args) {
        //创建一个小超市类
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket("一家小超市", "宝山区上大路99号",
                100, 200, 200);
        littleSuperMarket.merchandises=new MerchandiseV2WithStaticVariable[littleSuperMarket.merchandiseCount];
        MerchandiseV2WithStaticVariable[] all = littleSuperMarket.merchandises;

        //遍历并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            MerchandiseV2WithStaticVariable m = new MerchandiseV2WithStaticVariable("商品" + i, "00" + i, 200, Math.random() * 200, (1 + Math.random()) * 200);
            all[i] = m;
        }

        MerchandiseV2WithStaticVariable bigProfit = littleSuperMarket.getBigeerProfitMerchandise();
        bigProfit.describe();
        double cost1 = bigProfit.buy(10, true);
        System.out.println("VIP 购买10个" + bigProfit.getname() + "的花费为" + cost1);

        //>> TODO 使用别的类的静态变量的时候，需要使用完整的形态：类名.静态变量名字
        MerchandiseV2WithStaticVariable.DISCOUNT_FOR_VIP = 0.5;
        bigProfit.describe();
        double cost2 = bigProfit.buy(10, true);
        System.out.println("VIP 购买10个" + bigProfit.getname() + "的花费为" + cost2);

        //>> TODO 静态变量在整个Java程序中只有一个（对比实例变量，是每个实例有一份）
        //   TODO 所有静态变量一旦变化，所有使用这个静态变量的地方的值都会变
        MerchandiseV2WithStaticVariable m0 = littleSuperMarket.getMerchandideOf(0);
        m0.describe();
        double cost3 = m0.buy(10, true);
        System.out.println("VIP 购买10个" + bigProfit.getname() + "的花费为" + cost3);
    }
}
