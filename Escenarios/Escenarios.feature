Feature: Login and process purchase products

  Scenario: Login verification
    Given The page is accessed and the credentials are known
     When the access data is entered and the enter button is pressed
     Then the main menu of the shopping page appears
  
  Scenario: Credentials Incorrect
    Given Login required
     When Wrong username and password were entered
     Then An invalid username and password message is displayed.
  
  Scenario: Verification of product loading
    Given It is required to purchase the products
     When the desired products are selected that are added to the shopping cart
     Then Inside the shopping cart are the previously selected products
  
  Scenario: Purchase process
    Given You want to continue with the purchase
     When Personal data is entered and payment is made
     Then the invoice is generated
  
  Scenario: Verification of invoicing and shipping process
    Given The invoice is obtained
     When the shipping process continues
     Then It is evidenced that the order was dispatched
  
  
