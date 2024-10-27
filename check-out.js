const semiColonStore = {
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

read_line.question('What is the customer\'s name? ', (name) => {
    
        let totalCost = 0;
        const itemsList = []; 

        function askForItems() {
            read_line.question('What did the user buy? ', (item) => {
                read_line.question('How many pieces? ', (quantity) => {
                    quantity = parseInt(quantity);

                    let unitCost = semiColonStore[item] || 0;
                    if (unitCost === 0) {
                        console.log(`Sorry, ${item} is not available in the store.`);
                    } else {
                        let itemTotal = unitCost * quantity;
                        totalCost += itemTotal;
                        itemsList.push({ item, quantity, itemTotal });
                        console.log(`Added ${quantity} of ${item} to the cart. Cost so far: #${totalCost.toFixed(2)}`);
                    }

                    read_line.question('Add more items? (yes/no): ', (addMore) => {
                        if (addMore.toLowerCase() === 'yes') {
                            askForItems();
                        } else {
			    read_line.question('The cashier name: ', (cashierName) => {
                            read_line.question('How much discount will be applied? ', (discount) => {
                                discount = parseFloat(discount) || 0;
                                let vat = (VAT * totalCost) / 100;
                                let totalBill = totalCost + vat - discount;

                                console.log("\n\nSEMICOLON STORES\n");
                                console.log("MAIN BRANCH\n");
                                console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.\n");
                                console.log("TEL: 03293828343\n");
                                console.log(`Date: ${dateString} ${timeString}\n`);
                                console.log(`Cashier: ${cashierName}`);
                                console.log(`Customer's Name: ${name}`);
                                console.log("=====================================================================");
                                console.log(`\tITEM\t\tQTY\tTOTAL (#)`);
                                console.log("-----------------------------------------------------------------------");

                                itemsList.forEach(({ item, quantity, itemTotal }) => {
                                    console.log(`\t${item}\t\t${quantity}\t\t#${itemTotal.toFixed(2)}`);
                                });

                                console.log("-----------------------------------------------------------------------");
                                console.log(`\t\t\tSub Total:\t #${totalCost.toFixed(2)}`);
                                console.log(`\t\t\tDiscount:\t #${discount.toFixed(2)}`);
                                console.log(`\t\t\tVAT @ 17.50%:\t #${vat.toFixed(2)}`);
                                console.log("=====================================================================");
                                console.log(`\t\t\tBill Total:\t #${totalBill.toFixed(2)}`);
                                console.log("=====================================================================");
                                console.log(`THIS IS NOT A RECEIPT, PLEASE PAY #${totalBill.toFixed(2)} AT THE FRONT DESK`);
                                console.log("=====================================================================");

                                read_line.question('How much did the customer give to you?: ', (amountPaid) => {
                                    amountPaid = parseFloat(amountPaid) || 0;
                                    let balance = amountPaid - totalBill;

                                    console.log("\n\nSEMICOLON STORES\n");
                                    console.log("MAIN BRANCH\n");
                                    console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.\n");
                                    console.log("TEL: 03293828343\n");
                                    console.log(`Date: ${dateString} ${timeString}\n`);
                                    console.log(`Cashier: ${cashierName}`);
                                    console.log(`Customer's Name: ${name}`);
                                    console.log("=====================================================================");
                                    console.log(`\tITEM\t\tQTY\tTOTAL (#)`);
                                    console.log("-----------------------------------------------------------------------");

                                    itemsList.forEach(({ item, quantity, itemTotal }) => {
                                        console.log(`\t${item}\t\t${quantity}\t\t#${itemTotal.toFixed(2)}`);
                                    });

                                    console.log("-----------------------------------------------------------------------");
                                    console.log(`\t\t\tSub Total:\t #${totalCost.toFixed(2)}`);
                                    console.log(`\t\t\tDiscount:\t #${discount.toFixed(2)}`);
                                    console.log(`\t\t\tVAT @ 17.50%:\t #${vat.toFixed(2)}`);
                                    
console.log("=====================================================================");                                    console.log(`\t\t\tBill Total:\t #${totalBill.toFixed(2)}`);
                                    console.log(`\t\t\tAmount Paid:\t #${amountPaid.toFixed(2)}`);
                                    console.log(`\t\t\tBalance:\t #${balance.toFixed(2)}`);
                                    console.log("=====================================================================");
                                    console.log("\tTHANK YOU FOR YOUR PATRONAGE");
                                    console.log("=====================================================================");

                                    read_line.close();
                                });
                            });
                        });
                    }
                });
            });
        });

     }
        askForItems();

});
