# account.py
import hashlib

class BankAccount:
    def __init__(self, owner, pin, balance=0, transactions=None):
        self.owner = owner
        self._pin_hash = self.hash_pin(pin)
        self.balance = balance
        self.transactions = transactions if transactions else []

    def hash_pin(self, pin):
        """Convert PIN to SHA-256 hash"""
        return hashlib.sha256(pin.encode()).hexdigest()

    def authenticate(self, input_pin):
        """Check if input PIN matches stored hash"""
        return self.hash_pin(input_pin) == self._pin_hash

    # -----------------------------
    # ATM OPERATIONS
    # -----------------------------
    def deposit(self, amount):
        self.balance += amount
        self.transactions.append(f"Deposit: ${amount}")

    def withdraw(self, amount):
        if amount > self.balance:
            return False
        self.balance -= amount
        self.transactions.append(f"Withdraw: ${amount}")
        return True

    def get_balance(self):
        return self.balance

    def get_transactions(self):
        return self.transactions
