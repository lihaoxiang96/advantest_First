package homework.lihaoxiang;

import java.util.Scanner;

import homework.lihaoxiang.supermarket.LittleSuperMarket;
import homework.lihaoxiang.supermarket.Merchandise;
import homework.lihaoxiang.person.Customer;

public class RunLittleSuperMarketAppMain {
    public static void main(String[] args) {
        //创建一个小超市类
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        //依次给超市的名字，地址，停车位赋值
        littleSuperMarket.superMarketName = "教育超市";
        littleSuperMarket.address = "宝山区上大路99号";
        littleSuperMarket.parkingCount = 100;

        //给超市200种商品
        littleSuperMarket.merchandises = new Merchandise[200];
        //统计用到的数组
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        //为了使用方便，创建商品数组引用，和littleSuperMarket.merchandise指向同一个数组对象
        Merchandise[] all = littleSuperMarket.merchandises;

        //遍历并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice + (1 + Math.random());
            m.id = "ID" + i;
            //用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            all[i] = m;
        }
        System.out.println("超市开门啦！");

        boolean open = true;
        while (open) {
            littleSuperMarket.describe(littleSuperMarket);

            Customer customer = new Customer();
            customer.name = ("顾客编号为" + (int) (Math.random() * 10000));
            customer.money = (1 + Math.random()) * 1000;
            customer.isDringCar = Math.random() > 0.5;
            if (customer.isDringCar) {
                if (littleSuperMarket.parkingCount > 0) {
                    System.out.println("欢迎" + customer.name + "驾车而来，本店已经为您安排了车位，停车免费。车位编号为" + littleSuperMarket.parkingCount);
                    littleSuperMarket.parkingCount--;
                } else {
                    System.out.println("不好意思，本店车位已满，欢迎下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }

            Scanner scanner = new Scanner(System.in);
            double totalCost = 0;
            while (true) {
                System.out.println("本店提供" + all.length + "种商品，欢迎选购，请输入商品编号");
                int index = scanner.nextInt();

                if (index < 0) {
                    System.out.println("欢迎再次光临！");
                    break;
                }

                if (index >= all.length) {
                    System.out.println("本店没有这种商品，请输入编号在0到" + (all.length - 1) + "之内的商品编号。");
                    continue;
                }

                all[index].describe();

                Merchandise m = all[index];
                System.out.println("请输入需要购买的该商品数量：");
                int numTobuy = scanner.nextInt();
                if (numTobuy <= 0) {
                    System.out.println("不买看看也好，欢迎继续挑选。");
                    continue;
                }

                if (numTobuy > m.count) {
                    System.out.println("本店此商品库存没有这么多。欢迎继续选购。");
                    continue;
                }
                if (numTobuy * m.soldPrice > customer.money) {
                    System.out.println("您带的钱不够，欢迎继续挑选");
                    continue;
                }

                totalCost += m.buyCount(numTobuy);
                littleSuperMarket.merchandiseSold[index] += numTobuy;

            }

            customer.money -= totalCost;
            if (customer.isDringCar) {
                littleSuperMarket.parkingCount++;
            }

            System.out.println("顾客" + customer.name + "共消费了" + totalCost);
            littleSuperMarket.incomingSum += totalCost;
            System.out.println("还继续营业吗？");
            open = scanner.nextBoolean();
        }

        System.out.println("教超关门了！");
        System.out.println("今天的营业总额为" + littleSuperMarket.incomingSum + "营业情况如下");

        for (int i = 0; i < littleSuperMarket.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = littleSuperMarket.merchandiseSold[i];
            if (numSold > 0) {
                double incoming = m.soldPrice * numSold;
                double netIncoming = m.calculateProfit() * numSold;
                System.out.println(m.name + "售出了" + numSold + "个。销售额为" + incoming + "。净利润为" + netIncoming);
            }
        }
    }
}
