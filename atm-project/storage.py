# storage.py
import json
from account import BankAccount

def save_account(account):
    data = {
        "owner": account.owner,
        "pin_hash": account._pin_hash,
        "balance": account.balance,
        "transactions": account.transactions
    }
    with open("data.json", "w") as file:
        json.dump(data, file)

def load_account():
    try:
        with open("data.json", "r") as file:
            data = json.load(file)
            account = BankAccount(
                data["owner"],
                "0000"  # dummy PIN, GUI vai autenticar pelo hash
            )
            # restaurar saldo e histórico
            account.balance = data["balance"]
            account.transactions = data["transactions"]
            account._pin_hash = data["pin_hash"]
            return account
    except (FileNotFoundError, json.JSONDecodeError):
        return None