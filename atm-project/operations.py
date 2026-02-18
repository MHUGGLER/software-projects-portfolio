# operations.py
# Contains functions to perform ATM operations: deposit, withdraw, check balance.

from storage import save_account

def deposit(account):
    """Deposit money into the account."""
    amount = float(input("Enter deposit amount: "))
    account.balance += amount
    account.transactions.append(f"Deposit: ${amount}")
    save_account(account)
    print("Deposit successful.")

def withdraw(account):
    """Withdraw money from the account."""
    amount = float(input("Enter withdrawal amount: "))
    if amount > account.balance:
        print("Insufficient funds.")
        return
    account.balance -= amount
    account.transactions.append(f"Withdraw: ${amount}")
    save_account(account)
    print("Withdrawal successful.")

def check_balance(account):
    """Display the current account balance."""
    print(f"Current balance: ${account.balance}")

def print_transactions(account):
    """Print all past transactions."""
    print("Transaction History:")
    for t in account.transactions:
        print("-", t)
