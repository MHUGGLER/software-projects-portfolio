# test_account.py
# Simple tests to check BankAccount functionality.

from account import BankAccount

def test():
    acc = BankAccount("Murilo", "1234", 100)
    assert acc.authenticate("1234") == True
    assert acc.authenticate("0000") == False
    print("All tests passed!")

if __name__ == "__main__":
    test()
