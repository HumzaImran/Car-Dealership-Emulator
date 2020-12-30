
# Car Dealership Emulator
 
## About
Car Dealership Emulator is programmed in Java. The program was created to perform a handful of functions which corelate with a car dealership.
The program allows you to see a list of cars and purchase them. It also allows returns. Cars are purchased and returned using their VINs. The user has 
an unlimited amount of money. When the program is initially ran an ADD command must be run, this adds all the cars to a viewable list. The cars list can be 
viewed using the 'L' command. Other sorting functions can also be applied to the list. A sales team is also present. Every time a transaction occurs a random
sales team member is assigned.

## Functions
The letters below correspond with the commands that are associated with them.  <br /> 
“FAW”- This function filters to only show cars that have all wheel drive.  <br />
“FCL”- This function clears all sorting filters that have been applied.<br />
“FEL”- This function filters to only show electric cars. <br />
“FPR”- This function filters by price range. Range has to be entered after the FPR command. See example below.  <br />
‘L’ – This function lists all cars available for sale. <br />
“SS”- This function display sales stats.  <br />
“ST”- This function display sales team. <br />
“SPR”- This function sorts the car list by price.  <br />
“SMR”- This function sorts the car list in descending order by fuel range.  <br />
“SSR”-  This function sorts the car list by safety rating.  <br />
 
***Example code***
FPR 1000 30000
 
“BUY”- This function is used to buy cars, only one car can be bought at a time. Buying has to be done with the car’s vin number.  
***Example code***
BUY 458 

RET- This function is used to return cars. Only one car can be returned at a time. This function also requires the cars vin number.   
***Example code***
RET 458 



