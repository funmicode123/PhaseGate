const semiColonStore = {
    "rice": 550.00,
    "parfait": 2100,
    "ovatin": 9500.00,
    "peakMilk": 5200.00,
    "bread(b/s)": 3000.00,
    "bread(m/s)": 2200.00,
    "bread(s/s)": 1000.00,
    "indomine": 9500.00,
    "dangoteSpaghetti": 18000.00,
    "biscuit": 350.00
};

const VAT = 17.50;
const readline = require('readline');

const now = new Date();
const dateString = now.toLocaleDateString();
const timeString = now.toLocaleTimeString();

const read_line = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function isValidNumber(value) {
    return !isNaN(value) && value > 0;
}

function askForItems(name) {
    let totalCost = 0;
    const itemsList = [];

    function addItem() {
        read_line.question('What did the user buy? ', (item) => {
            if (!semiColonStore.hasOwnProperty(item)) {
                console.log(`Sorry, ${item} is not available in the store.`);
                return addItem();
            }

            read_line.question('How many pieces? ', (quantity) => {
                quantity = parseInt(quantity);
                if (!isValidNumber(quantity)) {
                    console.log("Invalid quantity. Please enter a positive number.");
                    return addItem();
                }

                const unitCost = semiColonStore[item];
                const itemTotal = unitCost * quantity;
                totalCost += itemTotal;
                itemsList.push({ item, quantity, itemTotal });
                console.log(`Added ${quantity} of ${item} to the cart.`);

                read_line.question('Add more items? (yes/no): ', (addMore) => {
                    if (addMore.toLowerCase() === 'yes') {
                        addItem();
                    } else {
                        finalizeBill(name, totalCost, itemsList);
                    }
                });
            });
        });
    }

    addItem();
}

function finalizeBill(name, totalCost, itemsList) {
    read_line.question('The cashier name: ', (cashierName) => {
        read_line.question('How much discount will be applied? ', (discountInput) => {
            let discount = parseFloat(discountInput) || 0;
            if (discount < 0 || discount > totalCost) {
                console.log("Invalid discount. Please enter a value between 0 and the subtotal.");
                return finalizeBill(name, totalCost, itemsList);
            }

            const vat = (VAT * totalCost) / 100;
            const totalBill = totalCost + vat - discount;

            printInterimReceipt(name, cashierName, dateString, timeString, itemsList, totalCost, discount, vat, totalBill);

            read_line.question('How much did the customer give to you?: ', (amountPaidInput) => {
                let amountPaid = parseFloat(amountPaidInput) || 0;
                if (amountPaid < totalBill) {
                    console.log("Insufficient payment. Please pay the full amount.");
                    return finalizeBill(name, totalCost, itemsList);
                }

                const balance = amountPaid - totalBill;
                printFinalReceipt(name, cashierName, dateString, timeString, itemsList, totalCost, discount, vat, totalBill, amountPaid, balance);
                read_line.close();
            });
        });
    });
}

function printInterimReceipt(name, cashierName, dateString, timeString, itemsList, totalCost, discount, vat, totalBill) {
    console.log("\n\nSEMICOLON STORES");
    console.log("MAIN BRANCH");
    console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
    console.log("TEL: 03293828343");
    console.log(`Date: ${dateString} ${timeString}`);
    console.log(`Cashier: ${cashierName}`);
    console.log(`Customer's Name: ${name}`);
    console.log("=".repeat(70));
    console.log(`\tITEM\t\tQTY\tTOTAL (NGN)`);
    console.log("-".repeat(70));

    itemsList.forEach(({ item, quantity, itemTotal }) => {
        console.log(`\t${item}\t\t${quantity}\t\t${itemTotal.toFixed(2)}`);
    });

    console.log("-".repeat(70));
    console.log(`\t\t\tSub Total:\t ${totalCost.toFixed(2)}`);
    console.log(`\t\t\tDiscount:\t ${discount.toFixed(2)}`);
    console.log(`\t\t\tVAT @ ${VAT}%:\t ${vat.toFixed(2)}`);
    console.log("=".repeat(70));
    console.log(`\t\t\tBill Total:\t ${totalBill.toFixed(2)}`);
    console.log("=".repeat(70));
    console.log(`THIS IS NOT A RECEIPT, PLEASE PAY ${totalBill.toFixed(2)} AT THE FRONT DESK`);
    console.log("=".repeat(70));
}

function printFinalReceipt(name, cashierName, dateString, timeString, itemsList, totalCost, discount, vat, totalBill, amountPaid, balance) {
    console.log("\n\nSEMICOLON STORES");
    console.log("MAIN BRANCH");
    console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
    console.log("TEL: 03293828343");
    console.log(`Date: ${dateString} ${timeString}`);
    console.log(`Cashier: ${cashierName}`);
    console.log(`Customer's Name: ${name}`);
    console.log("=".repeat(70));
    console.log(`\tITEM\t\tQTY\tTOTAL (NGN)`);
    console.log("-".repeat(70));

    itemsList.forEach(({ item, quantity, itemTotal }) => {
        console.log(`\t${item}\t\t${quantity}\t\t${itemTotal.toFixed(2)}`);
    });

    console.log("-".repeat(70));
    console.log(`\t\t\tSub Total:\t ${totalCost.toFixed(2)}`);
    console.log(`\t\t\tDiscount:\t ${discount.toFixed(2)}`);
    console.log(`\t\t\tVAT @ ${VAT}%:\t ${vat.toFixed(2)}`);
    console.log("=".repeat(70));
    console.log(`\t\t\tBill Total:\t ${totalBill.toFixed(2)}`);
    console.log(`\t\t\tAmount Paid:\t ${amountPaid.toFixed(2)}`);
    console.log(`\t\t\tBalance:\t ${balance.toFixed(2)}`);
    console.log("=".repeat(70));
    console.log("\tTHANK YOU FOR YOUR PATRONAGE");
    console.log("=".repeat(70));
}

read_line.question("What is the customer's name? ", (name) => {
    askForItems(name);
});
