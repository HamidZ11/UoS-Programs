This is homework 3, it is to create a program that simulates how a shop works, with classes for the store itself, members of the store, and items that the store sells

I got 16.5 on this homework

Feedback as follows :

FOUND: both `storeName` and `total` fields exist in the store class, incrementing by 1.0
FOUND: initialising total to 0, incrementing by 0.5
FOUND: initialising storeName, incrementing by 0.5
FEEDBACK: you were expected to write two accessor methods such as getStoreName() and getTotal() inside store class.
CHECKING: memberRegister1 method
FOUND: memberRegister1() method
FOUND: reasonable welcome message in memberRegister1(), incrementing by 1.0
FOUND: correctly calls setStore(this) in memberRegister1(), incrementing by 1.0
CHECKING: memberRegister2 method
FOUND: memberRegister2() method
FOUND: creating member object from 3 parameters in memberRegister2(), incrementing by 1.0
FOUND: reasonable welcome message in memberRegister2(), incrementing by 1.0
FOUND: setStore(this) in memberRegister2(), incrementing by 0.5
CHECKING: checkout method
FOUND: checkout() method
FOUND: checkout() method with correct parameters, incrementing by 1.0
FEEDBACK: some key elements are missing in checkout()
FEEDBACK: change calculation not found or incorrect in checkout()
FEEDBACK: sale not added to store total in checkout()
FEEDBACK: member's money not deducted correctly in checkout()
FEEDBACK: basket not emptied in checkout()
store score: 7.5

FOUND: initialised name, id, and pinNumber correctly in the constructor, incrementing by 1.0
FOUND: initialised store and item to null in the constructor, incrementing by 1.0
FOUND: initialised money to 500 in the constructor, incrementing by 0.5
FOUND: 3 or more accessors, incrementing by 1.0
FOUND: three basic mutators, incrementing by 1.0
FOUND: one of setStore() or setItem() mutators, incrementing by 0.5
CHECKING: selectItem method
FOUND: selectItem() method
FOUND: updating item field in selectItem(), incrementing by 1.0
FEEDBACK: output message not found or is incorrect in selectItem().
CHECKING: goToCheckout() method
FOUND: goToCheckout() method
FEEDBACK: the condition item == null is missing in goToCheckout().
FEEDBACK: the condition item.getPrice() > payment (or equivalent) is missing in goToCheckout().
FEEDBACK: the condition payment > money (or equivalent) is missing in goToCheckout().
FOUND: reasonable error messages included, incrementing by 1.0
FEEDBACK: setting item to null after purchase is missing in goToCheckout().
FOUND: checking store != null, incrementing by 1.0
FOUND: calling store.checkout(payment, this) in goToCheckout(), incrementing by 0.5
member score: 8.5

FOUND: both `name` and `price` fields exist in the item class, incrementing by 2.0  (you dont get this mark as it was not correctly named)
FOUND: getName() accessor found
FOUND: getPrice() accessor found
FOUND: both accessors found, total increment is 0.5
FEEDBACK: getPriceString() method is missing in item class.
FEEDBACK: the setName() mutator is missing in the item class.
feedback: the setPrice() mutator is missing in the item class.
FEEDBACK: you were expected to write two mutator methods such as setName() and setPrice() inside the item class.
item TOTAL: 2.5

OVERALL: 16.5
