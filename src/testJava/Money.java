package testJava;

public class Money implements Expression {
	int amount;
	String currency;
	
	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	public Expression times(int multiplier)
	{
		return new Money(amount * multiplier, currency);
	}
	
	static Money franc(int amount)
	{
		return new Franc(amount, "CHF");
	}
	
	static Money dollar(int amount)
	{
		return new Dollar(amount, "USD");
	}
	
	public boolean equal(Object object)
	{
		Money money = (Money)object;
		
		return this.amount == money.amount &&
				getClass().equals(money.getClass());
	}
	
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
}
