# atm_gui.py
import tkinter as tk
from tkinter import simpledialog, messagebox
from account import BankAccount
from storage import save_account, load_account

# -----------------------------
# LOAD ACCOUNT OR CREATE NEW
# -----------------------------
account = load_account()
if not account:
    # Create a default account if none exists
    account = BankAccount("User", "1234", 0)
    save_account(account)

# -----------------------------
# GUI FUNCTIONS
# -----------------------------
def authenticate_gui():
    pin = simpledialog.askstring("ATM Login", "Enter your PIN:", show="*")
    if pin and account.authenticate(pin):
        messagebox.showinfo("ATM", "Authentication successful!")
        main_menu()
    else:
        messagebox.showerror("ATM", "Incorrect PIN.")

def deposit_gui():
    try:
        amount = float(simpledialog.askstring("Deposit", "Enter deposit amount:"))
        account.deposit(amount)
        save_account(account)
        messagebox.showinfo("ATM", f"Deposit successful! New balance: ${account.get_balance()}")
    except:
        messagebox.showerror("ATM", "Invalid amount!")

def withdraw_gui():
    try:
        amount = float(simpledialog.askstring("Withdraw", "Enter withdrawal amount:"))
        if account.withdraw(amount):
            save_account(account)
            messagebox.showinfo("ATM", f"Withdrawal successful! New balance: ${account.get_balance()}")
        else:
            messagebox.showerror("ATM", "Insufficient funds!")
    except:
        messagebox.showerror("ATM", "Invalid amount!")

def balance_gui():
    messagebox.showinfo("ATM", f"Current balance: ${account.get_balance()}")

def history_gui():
    transactions = "\n".join(account.get_transactions())
    messagebox.showinfo("ATM", f"Transaction History:\n{transactions if transactions else 'No transactions yet.'}")

def exit_gui():
    root.destroy()

# -----------------------------
# MAIN MENU
# -----------------------------
def main_menu():
    for widget in root.winfo_children():
        widget.destroy()

    tk.Label(
        root,
        text="ATM MAIN MENU",
        font=("Courier", 18, "bold"),
        fg="#00FF00",
        bg="black"
    ).pack(pady=20)

    button_style = {
        "width": 25,
        "font": ("Courier", 12, "bold"),
        "bg": "black",
        "fg": "#00FF00",
        "activebackground": "black",
        "activeforeground": "#00FF00",
        "highlightbackground": "#00FF00",
        "highlightcolor": "#00FF00",
        "highlightthickness": 2,
        "bd": 0,
        "relief": "flat",
    }

    tk.Button(root, text="Deposit", command=deposit_gui, **button_style).pack(pady=8)
    tk.Button(root, text="Withdraw", command=withdraw_gui, **button_style).pack(pady=8)
    tk.Button(root, text="Balance", command=balance_gui, **button_style).pack(pady=8)
    tk.Button(root, text="Transaction History", command=history_gui, **button_style).pack(pady=8)
    tk.Button(root, text="Exit", command=exit_gui, **button_style).pack(pady=8)

# -----------------------------
# GUI WINDOW SETUP
# -----------------------------
root = tk.Tk()
root.title("Retro ATM")
root.configure(bg="black")
root.geometry("400x400")

# Start with authentication
authenticate_gui()

root.mainloop()