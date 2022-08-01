
### Minesweeper Java game using javax.swing GUI toolkit
  
Please note that this project is not complete and it all depends if I have the time and the willingness to continue building it from scratch.  
  
Stuff that don't work yet or are working improperly:  
1. When you click on an unsafe button (bomb behind it) game is not over and does not show the other bombs left.  
2. Right clicking a button does not flag it disabling and stopping it from being accidently clicked.  
3. The first button clicked could be a bomb or a number instead of opening a mesh of clear buttons.  
4. If a button is clear (the button itself and its surrounding buttons don't have bombs meaning that square will be empty (no bomnb or number)) surrounding will slowly open one by one due to huge if statements.  
5. Too many if statements and switch case structures which slows down the whole process.   
  
Points 3 and 4 can be fixed by instead of creating the board of buttons and then adding the bombs, to first add the bombs randomly to the buttons and create the empty meshes so that when a clear button is clicked, the whole mesh will open instantly since it was loaded earlier when loading the board.  
  
**Button** inner class will create the button and whether it is safe (not a bomb) or not.   
Then in the main **Board** class we will add these buttons in a **buttonArray\[]** array  
From there on out its all about the action listener (what a button will do when it is clicked) and a bunch of *clear* if statements and switch cases (LMAO I am really sorry)  
  
MAKE SURE THAT THE IMAGES ARE IN THE SAME LOCATION AS THE JAVA FILES OR ELSE YOU WILL HAVE TO SPECIFY THEIR DIRECTORY!  
  
Refer to the [javax.swing Oracle documentation](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html) for any additional info.  
  
Date of creation: *04/06/2022*  
Project done by **CSwaiby** using Eclipse IDE.  
  
