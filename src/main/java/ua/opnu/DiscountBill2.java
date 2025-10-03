package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.util.ArrayList;
import java.util.List;

public class DiscountBill2 {
    private final GroceryBill groceryBill;
    private final boolean regularCustomer;
    private final List<Item> receipt;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.groceryBill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.receipt = new ArrayList<>();
    }

    public void add(Item i) {
        groceryBill.add(i);
        receipt.add(i);
    }

    public double getTotal() {
        return (regularCustomer)
                ? groceryBill.getTotal() - getDiscountAmount()
                : groceryBill.getTotal();
    }

    public int getDiscountCount() {
        int count = 0;
        for (Item item : receipt) {
            if (item.getDiscount() > 0.0 && regularCustomer) {
                count++;
            }
        }
        return count;
    }

    public double getDiscountAmount() {
        double amount = 0;
        for (Item item : receipt) {
            if (item.getDiscount() > 0.0 && regularCustomer) {
                amount += item.getDiscount();
            }
        }
        return amount;
    }

    public double getDiscountPercent() {
        double totalBefore = groceryBill.getTotal();
        if (totalBefore == 0) return 0.0;
        return 100 - ((totalBefore - this.getDiscountAmount()) * 100) / totalBefore;
    }

    public Employee getClerk() {
        return groceryBill.getClerk();
    }
}
