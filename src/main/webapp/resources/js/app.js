// BUDGET CONTROLLER
var budgetController = (function() {
    
    
    
    
    var item = function(id, name, quantity, price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = this.price * this.quantity
    };
    
   var itemLists = []; 

   var sum=0;
    var allItems = {
            items: [],
            total: 0
        };
    
    
    return {
        addItem: function(id, name, quantity, price) {
            console.log('now appending to cart khathesi');
            newItem = new item(id, name, quantity, price);
            var notThere =true;
            
            // Push it into our data structure
            console.log(notThere);
            console.log('does new element id exist');
            //console.log(allItems.items.includes(newItem));
            allItems.items.push(newItem);

            //then its the first itmes
            if(allItems.items.length==1){
                console.log('length is one so pushed');

            }
            else{

                //pop it
                allItems.items.pop();

                //check if already exists
                for(var d=0; d<allItems.items.length; d++){
                    if(allItems.items[d].itemID==newItem.itemID){
                        console.log('now replacing'+d)
                        notThere=false;
                        allItems.items[d]=newItem;
                        // replace adjacent
                    }
                    //console.log(allItems.items[d].itemID+'no equal to'+newItem.itemID);
                }

            }


       /*     if(allItems.itemID.length>0){
            console.log('does new element exist');
            console.log(allItems.items.includes(newItem));
            for(var d=0; d<allItems.items.length; d++){
                if(allItems.items[d].itemID==newItem.itemID){
                    notThere=false;
                }
                console.log(allItems.items[d].itemID+'no equal to'+newItem.itemID);
            }
        }*/
      //  sum = sum+newItem.itemPrice;
        console.log('sum now is'+sum)
        console.log('new item'+newItem.itemPrice)

          allItems.total=0;
                  //allItems.total+newItem.itemPrice;
         // console.log(newItem).itemPrice;
         //   console.log(allItems.items);
            // Return the new element
            return allItems;
        },
        
        
        deleteItem: function(type, id) {
            var ids, index; 
            ids = data.allItems[type].map(function(current) {
                return current.id;
            });

            index = ids.indexOf(id);

            if (index !== -1) {
                data.allItems[type].splice(index, 1);
            }
            
        },
        
        
        calculateBudget: function() {
            
            // calculate total income and expenses
            calculateTotal('exp');
            calculateTotal('inc');
            
            // Calculate the budget: income - expenses
            data.budget = data.totals.inc - data.totals.exp;
            
            // calculate the percentage of income that we spent
            if (data.totals.inc > 0) {
                data.percentage = Math.round((data.totals.exp / data.totals.inc) * 100);
            } else {
                data.percentage = -1;
            }            
            
            // Expense = 100 and income 300, spent 33.333% = 100/300 = 0.3333 * 100
        },
        
        calculatePercentages: function() {
            
            data.allItems.exp.forEach(function(cur) {
               cur.calcPercentage(data.totals.inc);
            });
        },
        
        
        getPercentages: function() {
            var allPerc = data.allItems.exp.map(function(cur) {
                return cur.getPercentage();
            });
            return allPerc;
        },
        
        
        getBudget: function() {
            return {
                budget: data.budget,
                totalInc: data.totals.inc,
                totalExp: data.totals.exp,
                percentage: data.percentage
            };
        },
        
        testing: function() {
            console.log('data');
        },
        
        addlist: function(newCartItem){
            
            console.log('newer'+newCartItem);
            itemLists.push(newCartItem)
            
        }
    };
    
})();




// UI CONTROLLER
var UIController = (function() {
    
    var DOMstrings = {
        itemID: '.itemID',
        itemName: '.itemName',
        itemQuantity: '.itemQuantiy',
        itemPrice: '.itemPrice',
        inputBtn: '.add__btn',
        floatContainer: '#floater',
        catSize: '.catalogueSize'
    };
    
    
    var formatNumber = function(num, type) {
        var numSplit, int, dec, type;

        num = Math.abs(num);
        num = num.toFixed(2);

        numSplit = num.split('.');

        int = numSplit[0];
        if (int.length > 3) {
            int = int.substr(0, int.length - 3) + ',' + int.substr(int.length - 3, 3); //input 23510, output 23,510
        }

        dec = numSplit[1];

        return (type === 'exp' ? '-' : '+') + ' ' + int + '.' + dec;

    };
    
    
    var nodeListForEach = function(list, callback) {
        for (var i = 0; i < list.length; i++) {
            callback(list[i], i);
        }
    };
    
    
    return {
        getInput: function(x) {
            console.log('get input'+x)
            return {
                
                itemID: document.querySelector(DOMstrings.itemID+x).value,
                inputName: document.querySelector(DOMstrings.itemName+x).value,
                inputQuantity: document.querySelector(DOMstrings.itemQuantity+x).value,
                inputPrice: document.querySelector(DOMstrings.itemPrice+x).value
            };
        },
        
        
        addListItem: function(obj) {
            var html, newHtml, element;
            // Create HTML string with placeholder text
            
        console.log('updating UI'+DOMstrings.floatContainer);
                element = DOMstrings.floatContainer;
     
            console.log(obj.items[0].quantity);
            console.log('items length :'+obj.items.length);
            
            
            console.log("sekutshintshile");    
            var itemHtml = '<tr> <td><input type="hidden" name="itemId" value="%id%">%id%</td><input type="hidden" name="itemName" value="%name%"> <td>%name%</td> <td><input type="hidden" name="itemQuantity" value="%quantity%">%quantity%</td> <td><input type="hidden" name="itemPrice" value="%price%">%price%</td> <td>%total%</td> </tr>';                
                
            // Replace the placeholder text with some actual data
            itemHtml = itemHtml.replace('%id%', obj.items[obj.items.length-1].id);
            itemHtml = itemHtml.replace('%name%', obj.items[obj.items.length-1].name);
            itemHtml = itemHtml.replace('%quantity%', obj.items[obj.items.length-1].quantity);
            itemHtml = itemHtml.replace('%price%', obj.items[obj.items.length-1].price);
            itemHtml = itemHtml.replace('%total%', obj.items[obj.items.length-1].total);            
            console.log('item html '+itemHtml);
            
            
        //create a row
        
            

            console.log('Done replacind fields');
            
            // Insert the HTML into the DOM            
            document.querySelector(element).insertAdjacentHTML('beforeend', itemHtml);
        },
        
        
        
        
        
        
    addListChild: function(obj)     { 

var html, newHtml, element;
            // Create HTML string with placeholder text
            
    console.log('Starting to update UI'+DOMstrings.floatContainer);
    element = DOMstrings.floatContainer;
     
    console.log(obj.items[0].quantity);
    console.log('items length :'+obj.items.length);



    //get the table
    var table = document.getElementById("tee");
 
  for(var i=0; i<obj.items.length; i++){
    //create a row
    var tr = document.createElement('tr');
    
    // add td to row
    var td = tr.appendChild(document.createElement('td'));
    
    td.innerHTML = obj.items[i].id;
    
     var td = tr.appendChild(document.createElement('td'));
    
    td.innerHTML = obj.items[i].name;
    
     var td = tr.appendChild(document.createElement('td'));
    
    td.innerHTML = obj.items[i].quantity;

     var td = tr.appendChild(document.createElement('td'));
    
    td.innerHTML = obj.items[i].price;
    
    var td = obj.items[i].total;
    
    td.innerHTML = 'eta2';
        
    console.log('sho');
    
    table.appendChild(tr);
    };
    
    },
        
        
        getDOMstrings: function() {
            return DOMstrings;
        }
    };
    
})();




// GLOBAL APP CONTROLLER
var controller = (function(budgetCtrl, UICtrl) {

    
    var setupEventListeners = function() {
        console.log('1setup ivent listeners has started.');
        var DOM = UICtrl.getDOMstrings();
        console.log('eta');
        console.log('cat size is.'+document.querySelector(DOM.catSize).value);
        
        
        for(var j=0; j<document.querySelector(DOM.catSize).value; j++){
            var rr= DOM.inputBtn+j;
            console.log('rr is'+rr);
          switch(j){
            case 0:
                    document.querySelector(rr).addEventListener('click', ctrlAddItem0);
                    break;
            case 1:
                    document.querySelector(rr).addEventListener('click', ctrlAddItem1);
                    break;
            case 2:
                    document.querySelector(rr).addEventListener('click', ctrlAddItem2);
                    break;
                                  
          }


           //document.querySelector(rr).addEventListener('click', ctrlAddItem);
        
    }
        document.addEventListener('keypress', function(event) {
            if (event.keyCode === 13 || event.which === 13) {
                ctrlAddItem0();
            }
        });
                
    };
    
    
    var updateBudget = function() {
        
        // 1. Calculate the budget
        budgetCtrl.calculateBudget();
        
        // 2. Return the budget
        var budget = budgetCtrl.getBudget();
        
        // 3. Display the budget on the UI
        UICtrl.displayBudget(budget);
    };
    
    
    var updatePercentages = function() {
        
        // 1. Calculate percentages
        budgetCtrl.calculatePercentages();
        
        // 2. Read percentages from the budget controller
        var percentages = budgetCtrl.getPercentages();
        
        // 3. Update the UI with the new percentages
        UICtrl.displayPercentages(percentages);
    };
    
    
    var ctrlAddItem0 = function() {
        console.log('now in add item 0');
        var input, newItem;
                console.log('now in add item');


        // 1. Get the field input data
        input = UICtrl.getInput(0);        
        
        console.log('inputID '+input.itemID);
        
                console.log('input name'+input.inputName);
        console.log('inputquantity '+input.inputQuantity);

        // 2. if item is not already on the list add it
        
        updatedCart = budgetCtrl.addItem(input.itemID, input.inputName, input.inputQuantity, input.inputPrice);
        
        
        //3. Update UI
        //UICtrl.addListItem(updatedCart);
        UICtrl.addListChild(updatedCart);
        
        if (input.description !== "" && !isNaN(input.value) && input.value > 0) {
        }
    };
    

    var ctrlAddItem1 = function() {
        console.log('now in add item 1');
        var input, newItem;
                console.log('now in add item');


        // 1. Get the field input data
        input = UICtrl.getInput(1);        
        
        console.log('inputID '+input.itemID);
        
                console.log('input name'+input.inputName);
        console.log('inputquantity '+input.inputQuantity);

        // 2. if item is not already on the list add it
        
        updatedCart = budgetCtrl.addItem(input.itemID, input.inputName, input.inputQuantity, input.inputPrice);
        
        
        //3. Update UI
        //UICtrl.addListItem(updatedCart);
        UICtrl.addListChild(updatedCart);
        
        if (input.description !== "" && !isNaN(input.value) && input.value > 0) {
        }
    };


    var ctrlAddItem2 = function() {
        console.log('now in add item 2');
        var input, newItem;
                console.log('now in add item');


        // 1. Get the field input data
        input = UICtrl.getInput(2);        
        
        console.log('inputID '+input.itemID);
        
                console.log('input name'+input.inputName);       //  var rr= DOM.inputBtn+j;
                //  console.log('rr is'+rr);put.inputName);
        console.log('inputquantity '+input.inputQuantity);

        // 2. if item is not already on the list add it
        
        updatedCart = budgetCtrl.addItem(input.itemID, input.inputName, input.inputQuantity, input.inputPrice);
        
        
        //3. Update UI
        //UICtrl.addListItem(updatedCart);
        UICtrl.addListChild(updatedCart);
        
        if (input.description !== "" && !isNaN(input.value) && input.value > 0) {
        }
    };


    var ctrlAddItem3 = function() {
        console.log('now in add item 3');
        var input, newItem;
                console.log('now in add item');


        // 1. Get the field input data
        input = UICtrl.getInput(3);        
        
        console.log('inputID '+input.itemID);
        
                console.log('input name'+input.inputName);
        console.log('inputquantity '+input.inputQuantity);

        // 2. if item is not already on the list add it
        
        updatedCart = budgetCtrl.addItem(input.itemID, input.inputName, input.inputQuantity, input.inputPrice);
        
        
        //3. Update UI
        //UICtrl.addListItem(updatedCart);
        UICtrl.addListChild(updatedCart);
        
        if (input.description !== "" && !isNaN(input.value) && input.value > 0) {
        }
    };



    
    var ctrlDeleteItem = function(event) {
        var itemID, splitID, type, ID;
        
        itemID = event.target.parentNode.parentNode.parentNode.parentNode.id;
        
        if (itemID) {
            
            //inc-1
            splitID = itemID.split('-');
            type = splitID[0];
            ID = parseInt(splitID[1]);
            
            // 1. delete the item from the data structure
            budgetCtrl.deleteItem(type, ID);
            
            // 2. Delete the item from the UI
            UICtrl.deleteListItem(itemID);
            
            // 3. Update and show the new budget
            updateBudget();
            
            // 4. Calculate and update percentages
            updatePercentages();
        }
    };
    
    
    return {
        init: function() {
            console.log('Application has started.');
            var cart = [];
            console.log('0 setup ivent lusteners has started.');

            setupEventListeners();
            console.log('0.1 setup ivent lusteners has started.');

        }
    };
    
})(budgetController, UIController);


controller.init();