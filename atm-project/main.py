# main.py
# Main program to run the ATM interface in the terminal.

from storage import load_account, save_account
import operations as ops
from account import BankAccount

def main():
    print("=== Welcome to the ATM Simulator ===")

    account = load_account()
    if account is None:
        print("No account found. Creating a new account.")
        owner = input("Enter account owner's name: ")
        pin = input("Set a 4-digit PIN: ")
        account = BankAccount(owner, pin)
        save_account(account)

    # Authenticate user
    for _ in range(3):
        input_pin = input("Enter your PIN to access the account: ")
        if account.authenticate(input_pin):
            break
        print("Incorrect PIN.")
    else:
        print("Too many failed attempts. Exiting.")
        return

    while True:
        print("\nSelect an option:")
        print("1. Deposit")
        print("2. Withdraw")
        print("3. Check Balance")
        print("4. Transaction History")
        print("5. Exit")

        choice = input("Your choice: ")

        if choice == "1":
            ops.deposit(account)
        elif choice == "2":
            ops.withdraw(account)
        elif choice == "3":
            ops.check_balance(account)
        elif choice == "4":
            ops.print_transactions(account)
        elif choice == "5":
            print("Thank you for using the ATM Simulator!")
            break
        else:
            print("Invalid option. Try again.")

if __name__ == "__main__":
    main()