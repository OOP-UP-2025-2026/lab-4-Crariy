package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.util.ArrayList;
import java.util.List;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;
    private final List<Item> receipt;

    @Override
    public void add(Item i) {
        super.add(i);
        receipt.add(i);
    }

    @Override
    public double getTotal() {
        return (regularCustomer) ? super.getTotal() - getDiscountAmount() : super.getTotal();
    }

    public int getDiscountCount(){
        int count = 0;
        for (int i = 0; i < receipt.size(); i++) {
            if(receipt.get(i).getDiscount() > 0.0 && regularCustomer) {
                count++;
            }
        }
        return count;
    }

    public double getDiscountAmount(){
        double amount = 0;
        for (int i = 0; i < receipt.size(); i++) {
            if(receipt.get(i).getDiscount() > 0.0 && regularCustomer) {
                amount += receipt.get(i).getDiscount();
            }
        }
        return amount;
    }

    public double getDiscountPercent(){
        return 100 - ((super.getTotal() - this.getDiscountAmount()) * 100) / super.getTotal();
    }


    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.receipt = new ArrayList<>();
    }
}
