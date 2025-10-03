package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {

    private int min;
    private int max;

    @Override
    public void debit(Debit d) {
        super.debit(d);
        if (max < super.getBalance()) max = super.getBalance();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        if (min > super.getBalance()) min = super.getBalance();
    }

    public MinMaxAccount(Startup s) {
        super(s);
        max = s.getBalance();
        min = s.getBalance();
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
