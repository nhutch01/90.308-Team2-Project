90.308-Team2-Project
====================

Subway Sandwich Ordering System Project

Project to create a Subway Sandwich Kiosk ordering system for sandwich shop such as Subway.  Several ordering kiosks would be at the front of the store as customers so they can create the order for their sandwich to expedite the ordering process which is currently done on the sandwich assembly line.   When the customer has finished selecting the ingredients for the sandwich, the order is summarized and displayed at the sandwich-making station.
Components:
GUI which displays the available ingredients grouped by type for creating a sandwich:
Bread – radio button group of bread from which to select
Meats – checkboxes – allowing a specific number of choices of meat or none
Cheeses – radio button group of cheese selections
Vegetables – checkboxes allowing selection of any combination of all the vegetables or none
Sauces/dressings – checkboxes allowing selection of any combination of sauces/dressings or none
Salt, Pepper, Oregano – checkboxes allowing selection of any combination of dressings or none
Price for each item
Display a selection menu of pre-defined sandwiches, such as BLT, Buffalo Chicken, etc., with associated ingredients, and allows the customer to customize.
 
Actions:
Initial functions:
Ability to view a running total cost as the sandwich is created
Ability to order as a guest for a one-time order and ability to save that order as a favorite as a new user if desired
Summarize and display the customer’s order and total cost of each sandwich as it would be seen on the sandwich-making station screen

Functions to add as time permits:
Ability to create the new account to save favorites
Ability to save a completed sandwich as a ‘favorite’ under the user’s ID and password
Ability to log in as the customer and select from saved favorites
Ability to order and save more than one sandwich as a favorite 
 

Persistent Storage – Database such as MySQL or XML files which store:
The ingredients that will be displayed on the GUI so they can be dynamically changed in the database when new ingredients are added by Subway corporate marketing
Prices for ingredients

Future storage:
The pre-defined sandwich selections and their association to the ingredients for each
Customer data
Sandwich favorites associated with the customer
