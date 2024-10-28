import datetime

semiColonStore = {
    "rice": 550.00,
    "parfait": 2100.00,
    "ovatin": 9500.00,
    "peakMilk": 5200.00,
    "bread(b/s)": 3000.00,
    "bread(m/s)": 2200.00,
    "bread(s/s)": 1000.00,
    "indomine": 9500.00,
    "dangoteSpaghetti": 18000.00,
    "biscuit": 350.00
}
VAT = 17.50

now = datetime.datetime.now()
date_string = now.strftime("%Y-%m-%d")
time_string = now.strftime("%H:%M:%S")

def ask_for_items():
    total_cost = 0
    items_list = []

    name = input("What is the customer's name? ")

    while True:
        item = input("What did the user buy? ")
        try:
            quantity = int(input("How many pieces? "))
            if quantity <= 0:
                print("Kindly enter a valid quantity value")
                continue
        except ValueError:
            print("Invalid input. Please enter a numeric value for quantity.")
            continue

        unit_cost = semiColonStore.get(item, 0)
        if unit_cost == 0:
            print(f"Sorry, {item} is not available in the store.")
        else:
            item_total = unit_cost * quantity
            total_cost += item_total
            items_list.append((item, quantity, unit_cost, item_total))
            print(f"Added {quantity} of {item} to the cart.")

        add_more = input("Add more items? (yes/no): ").strip().lower()
        if add_more != 'yes':
            break

    cashier_name = input("The cashier name: ")

    while True:
        try:
            discount = float(input("How much discount will be applied? ") or 0)
            if discount > total_cost:
                print("Discount cannot be greater than the subtotal.")
                continue
            break
        except ValueError:
            print("Invalid input, please enter a numeric value for the discount.")

    vat = (VAT * total_cost) / 100
    total_bill = total_cost + vat - discount

    print("\nSEMICOLON STORES")
    print("MAIN BRANCH")
    print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
    print("TEL: 03293828343")
    print(f"Date: {date_string} {time_string}")
    print(f"Cashier: {cashier_name}")
    print(f"Customer's Name: {name}")
    print("=" * 70)
    print(f"\tITEM\t\tQTY\tPRICE\t\tTOTAL (NGN)")
    print("-" * 70)

    for item, quantity, unit_cost, item_total in items_list:
        print(f"\t{item}\t\t{quantity}\t{unit_cost:.2f}\t\t{item_total:.2f}")

    print("-" * 70)
    print(f"\t\t\tSub Total:\t {total_cost:.2f}")
    print(f"\t\t\tDiscount:\t {discount:.2f}")
    print(f"\t\t\tVAT @ {VAT}%:\t {vat:.2f}")
    print("=" * 70)
    print(f"\t\t\tBill Total:\t {total_bill:.2f}")
    print("=" * 70)
    print(f"THIS IS NOT A RECEIPT, PLEASE PAY {total_bill:.2f} AT THE FRONT DESK")
    print("=" * 70)

    while True:
        try:
            amount_paid = float(input("How much did the customer give to you?: ") or 0)
            if amount_paid < total_bill:
                print("Insufficient payment. Please pay the full amount.")
                continue
            break
        except ValueError:
            print("Invalid input, please enter a numeric value for the amount paid.")

    balance = amount_paid - total_bill

    print("\nSEMICOLON STORES")
    print("MAIN BRANCH")
    print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
    print("TEL: 03293828343")
    print(f"Date: {date_string} {time_string}")
    print(f"Cashier: {cashier_name}")
    print(f"Customer's Name: {name}")
    print("=" * 70)
    print(f"\tITEM\t\tQTY\tPRICE\t\tTOTAL(NGN)")
    print("-" * 70)

    for item, quantity, unit_cost, item_total in items_list:
        print(f"\t{item}\t\t{quantity}\t{unit_cost:.2f}\t\t{item_total:.2f}")

    print("-" * 70)
    print(f"\t\t\tSub Total:\t {total_cost:.2f}")
    print(f"\t\t\tDiscount:\t {discount:.2f}")
    print(f"\t\t\tVAT @ {VAT}%:\t {vat:.2f}")
    print("=" * 70)
    print(f"\t\t\tBill Total:\t {total_bill:.2f}")
    print(f"\t\t\tAmount Paid:\t {amount_paid:.2f}")
    print(f"\t\t\tBalance:\t {balance:.2f}")
    print("=" * 70)
    print("\tTHANK YOU FOR YOUR PATRONAGE")
    print("=" * 70)

ask_for_items()
