const display = document.getElementById('display');
const buttons = document.querySelectorAll('.buttons button');

let currentInput = '';
let operator = '';
let firstOperand = '';
let secondOperand = '';

buttons.forEach(button => {
  button.addEventListener('click', () => {
    const value = button.textContent;

    // if one want to clear everything on display
    if (value === 'C') {
      currentInput = '';
      operator = '';
      firstOperand = '';
      secondOperand = '';
      display.value = '';
    } else if (value === '=') {
      //calculation
      if (firstOperand && operator && currentInput) {
        secondOperand = currentInput;
        const result = calculate(firstOperand, secondOperand, operator);
        display.value = result;
        currentInput = result;
        operator = '';
        firstOperand = '';
        secondOperand = '';
      }
    }
     else if (['+', '-', '*', '/'].includes(value)) {
      // input
      if (currentInput) {
        firstOperand = currentInput;
        operator = value;
        currentInput = '';
      }
    } 
    else {
      // Handle number and decimal input
      currentInput =currentInput + value;
      display.value = currentInput;
    }
  });
});

function calculate(num1, num2, operator) {
  num1 = parseFloat(num1);
  num2 = parseFloat(num2);

  switch (operator) {
    case '+':
      return num1 + num2;
    case '-':
      return num1 - num2;
    case '*':
      return num1 * num2;
    case '/':
      return num1 / num2;
    default:
      return 0;
  }
}