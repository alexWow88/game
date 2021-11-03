![alt text](./assets/images/bubble-tea.PNG) 
# Bubble Tea Adventure Game
A whacky text-based battle game where you play as a crazed Bubble Tea junky who constantly gets into fights at the Bubble Tea shop. You just can't handle your Bubble Tea!

## General Info 
I made this during week 7 of my software development course at _nology. 
This project was used to showcase knowledge of Classes and extending off a Class as well as accessing/changing properties via Getters and Setters. This game is purely text-based and played from the Terminal.

## Technologies used
* Java

## Steps of the game:
* Pick your name
* Pick how lucky you feel that day (luckier will make the game easier as you are more likely to do a Critical Hit on attack)
* Pick your favorite Bubble Tea (will be mentioned in game at various times)
* Clear displays
* 2 Displays: Display the result of the current operations pressed and a list of all buttons pressed
* Negative/Positive button to change the result to the inverse
* Percentage value of the result in the display

## Under the Hood
The layout is the least complex bit of remaking the iPhone calculator. A div for the displays and a div for all the buttons. A grid was used to arrange the buttons in 4 columns as they are on the iPhone. A media query handles when the display screen is larger than a cell phone to ensure the calculator will only reach a maximum size and not get stretched by the display.
````javascript
<div class="calculator">
    <div id="display" class="display">
      <div id="display-list" class="display-list" data-cy="display-list"></div>
      <div id="displayResult" class="display-result" data-cy="display-result"></div>
    </div>
    <section class="keypad">
      <button id="button-clear" class="keypad__button keypad__clear" data-cy="clear">AC</button>
      <button id="button-negPos" class="keypad__button keypad__negPos" data-cy="negPos">+/-</button>
      <button id="button-percent" class="keypad__button keypad__percent" data-cy="percent">%</button>
      <button id="button-divide" class="keypad__button keypad__divide" data-cy="divide">/</button>
````
On the Javascript side of things, at the top of the Javascript file, the buttons and displays are selected with the use of document.querySelector and document.getElementById.
At the bottom, Event Listeners are added to each of these elements to trigger the necessary functions to run.

````javascript
const displayList = document.querySelector(".display-list");
const displayResult = document.querySelector(".display-result");
const buttonOne = document.getElementById("button-1");
...

...
buttonNine.addEventListener("click", () => attachNum("9"));
buttonZero.addEventListener("click", () => attachNum("0"));
buttonTimes.addEventListener("click", () => attachSymb("*"));
buttonMinus.addEventListener("click", () => attachSymb("-"));
...
````

Now that the buttons can now be pressed and are triggering functions to run, it is just a matter of making sure the function can handle all possible valid inputs (adding and then subtracting, handling negative values, etc.) and array manipulation.

To enable numbers being able to print into both displays, empty array variables are created and functions are triggered to push the new pressed number into the array.
````javascript
let resultOfArr = [];
let listOfArr = [];
let newNum = [];
let newSymb = [];

const attachNum = (newNum) => {
  resultOfArr.push(...newNum);
  listOfArr.push(...newNum);
  displayList.innerHTML = listOfArr.join("");
};
````

For the operator functions, let's look at just one. Let's look at adding a subtraction, addition, multiplication, or division operation. 

What I wanted to have happen when a new operator was typed, was that if 2 numbers and an operation had already been clicked previously, the calculator would go ahead and complete this operation before adding the new operation. So if 2+2 was already clicked and you then clicked "-" the result display would display 4 because 2+2 was added. This is typical of a basic calculator.

We start with confirming whether a "-" is already in the array holding the 2 numbers and operator already clicked. As we intend to .split("-") the .join("") of the array, we need to be mindful that a negative first number in the array will cause a split to have 3 indeces (the 0 index will have an empty string).
To handle this possiblility, an if and else if are used. If the first value is negative, then the inverse of index 1 is subtracted by index 2. As these values are currently a string, you have to use a parseFloat() to convert them to numbers and complete the mathematical equation. If the first value in the array was not a "-" than the split will only split the array into 2 indeces and the index 0 will be subtracted by index 1.
The addition, multipliation, and division is more straight forward. These operators would not appear more than once within the array like the "-" in a negative number. Depending on which operator is included, I .split() by that operator and then complete the mathematical operation of index 0 and 1.
Now that I have a single result, I run my function to display the result in the display, turn it back to a string, and then split it. At this point, I push the new operator into the arrays for this single result as well as a the array holding all the clicked buttons. 
Now I am ready to click another button and then another operator and this function will run again.

````javascript
const attachSymb = (newSymb) => {
  if (resultOfArr.join("").includes("-")) {
    let splitResultArr = resultOfArr.join("").split("-");
    if (resultOfArr[0] == "-" && splitResultArr.length === 3) {
        resultOfArr = ((-1)*parseFloat(splitResultArr[1])) - parseFloat(splitResultArr[2]);
        displayResultAndSplitResultsArr();
    } else if (resultOfArr[0] !== "-" && splitResultArr.length == 2) {
        resultOfArr = parseFloat(splitResultArr[0]) - parseFloat(splitResultArr[1]);
        displayResultAndSplitResultsArr();
      };
  };
  if (resultOfArr.join("").includes("+")) {
    let splitResultArr = resultOfArr.join("").split("+");
    resultOfArr = parseFloat(splitResultArr[0]) + parseFloat(splitResultArr[1]);
    displayResultAndSplitResultsArr();
  } else if (resultOfArr.join("").includes("*")) {
      let splitResultArr = resultOfArr.join("").split("*");
      resultOfArr = parseFloat(splitResultArr[0]) * parseFloat(splitResultArr[1]);
      displayResultAndSplitResultsArr();
    } else if (resultOfArr.join("").includes("/")) {
      let splitResultArr = resultOfArr.join("").split("/");
      resultOfArr = parseFloat(splitResultArr[0]) / parseFloat(splitResultArr[1]);
      displayResultAndSplitResultsArr();
    }
  resultOfArr.push(...newSymb);
  listOfArr.push(...newSymb);
  displayList.innerHTML = listOfArr.join("");
};


const displayResultAndSplitResultsArr = () => {
  displayResult.innerHTML = resultOfArr;
  resultOfArr = String(resultOfArr);
  resultOfArr = resultOfArr.split("");
}
````

Now that I can handle multiple operations, I want to test it End-to-End to be sure that I do not cause a bug later down the road when I make any changes. For this testing, I used Cypress.
See the below test case. Test cases are written in 3 steps: Arrange, Act, Assert. I ARRANGE by accessing the calculator at the below address, then I use the data-cy values I gave all the clickable buttons to ACT and select the operations and numbers I want, and lastly I ASSERT that I should get back a certain value in the results display. 

All oparations have been thoroughly tested including Percent, Negative/Positive, and Clear.

````
describe('Long operations', () => {
  it('9 + 3 - 10 * 60 / 5 equals 24', () => {
    //ARRANGE
    cy.visit('http://127.0.0.1:5502/index.html');
    //ACT
    cy.get('[data-cy=nine]').click();
    cy.get('[data-cy=plus]').click();
    cy.get('[data-cy=three]').click();
    cy.get('[data-cy=minus]').click();
    cy.get('[data-cy=one]').click();
    cy.get('[data-cy=zero]').click();
    cy.get('[data-cy=times]').click();
    cy.get('[data-cy=six]').click();
    cy.get('[data-cy=zero]').click();
    cy.get('[data-cy=divide]').click();
    cy.get('[data-cy=five]').click();
    cy.get('[data-cy=equals]').click();
    //ASSERT
    cy.get('[data-cy=display-result]').should('have.text', '24')
  })
})
````


## To handle the negative/positive button and equals, much of the same logical thinking just needs to be done. If you are working on creating your own calculator project, go ahead and clone downthe code and take a look at how the rest was done including the testing!
