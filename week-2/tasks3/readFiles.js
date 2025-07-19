const fs = require('fs').promises;
const path = require('path');

async function displayTransactions() {
  try {
    const filePath = path.join(__dirname, 'data', 'transactions.json');
    const fileContent = await fs.readFile(filePath, 'utf8');
    
    const transactions = JSON.parse(fileContent);
    
    console.log('Transactions data:');
    console.log(JSON.stringify(transactions, null, 2));
    
    console.log('\n--- Individual Transactions ---');
    transactions.forEach((transaction, index) => {
      console.log(`\nTransaction ${index + 1}:`);
      console.log(`  ID: ${transaction.tid}`);
      console.log(`  From: ${transaction.name}`);
      console.log(`  To: ${transaction.to}`);
      console.log(`  Amount: $${transaction.amount}`);
      console.log(`  Reason: ${transaction.reason}`);
    });
    
  } catch (error) {
    console.error('Error reading or parsing transactions file:', error.message);
    
    if (error.code === 'ENOENT') {
      console.error('The transactions.json file was not found.');
    } else if (error instanceof SyntaxError) {
      console.error('Invalid JSON format in the transactions file.');
    }
  }
}

displayTransactions();
