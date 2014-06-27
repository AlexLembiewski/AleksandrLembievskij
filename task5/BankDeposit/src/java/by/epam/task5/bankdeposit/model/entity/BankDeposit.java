
package by.epam.task5.bankdeposit.model.entity;

import java.util.Objects;

/**
 *
 * @author Администратор
 */
public class BankDeposit {
    private String name;
    private String country;
    private Enum type;
    private String depositor;
    private String accountId;
    private int amount;
    private int profitability;
    private int timeConstraints;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

   

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProfitability() {
        return profitability;
    }

    public void setProfitability(int profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(int timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getName())
                .append("name=").append(name)
                .append(", country=").append(country)
                .append(", type=").append(type)
                .append(", depositor=").append(depositor)
                .append(", accoutnId=").append(accountId)
                .append(", amount=").append(amount)
                .append(", profitability=").append(profitability)
                .append(", timeConstraints=").append(timeConstraints).append('}')
                .toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.depositor);
        hash = 23 * hash + Objects.hashCode(this.accountId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankDeposit other = (BankDeposit) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.depositor, other.depositor)) {
            return false;
        }
        if (!Objects.equals(this.accountId, other.accountId)) {
            return false;
        }
        return true;
    }

   

   
    
    
}
