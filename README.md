This code is for the LPA web app. It will take all the inputs used for ages 
0, 5, 15, 16, 18, 40, 45, 46, 50, 51, 61, 66, 71, 76, 81, 86 and 91 years old.

With each age the code will pull in the results for every State, Illustration Type, Plan Type and Product.

The results will be formatted as such:        
State,  Illustration Type, Plan Type, Product 1  
State,  Illustration Type, Plan Type, Product 2  
State,  Illustration Type, Plan Type 2, Product 1  
State,  Illustration Type, Plan Type 2, Product 2  

The ageInput.csv file will contain the ages to test and then two additional values per line.

The format for each line is as follows:     
Age 1,  0,  1   
Age 2,  2,  3 

The first value is the age. The next two values on each line are a count that is used for the 
pop up windows that appear when the script is running. If you have to run a script starting at a 
different age, make sure the values next to the first age start with 0 and 1.
