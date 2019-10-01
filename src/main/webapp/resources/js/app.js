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

   var sum=parseInt(0);
  // var num=parseInt(0);
    var allItems = {
            items: [],
            total: 0,
           // itemNum: 0
        };
    
    
    return {
        addItem: function(id, name, quantity, price) {
            console.log('now appending to cart khathesi');
            newItem = new item(id, name, parseInt(quantity), parseInt(price));
            var notThere =true;
            
            //if not empty
            if(itemLists.length>0){
                console.log('itemLists is not emptyyyyyyyyy'+itemLists.length);
                for(var f=0; f<itemLists.length; f++){
                    console.log('items in list');
                    console.log(itemLists[f].name);
                    console.log(itemLists[f].id);
     
                    
                }
                
                for(var f=0; f<itemLists.length; f++){
                    
                    if(itemLists[f].id==newItem.id){
                       console.log(itemLists[f].id+' is equal to '+newItem.id);
                       itemLists[f].quantity= itemLists[f].quantity+newItem.quantity;
                       notThere=false;
                    }
                    }
                }
                
          
            if(notThere){
                console.log('itemLists is not empty');

                // store in tank
            itemLists.push(newItem);
            
            // Push it into our data structure
            console.log(notThere);
            console.log('new itemList is'+itemLists);
        }
        
       allItems.items = itemLists;
    

        console.log('trial');

        console.log('sum now contains :'+sum);
        console.log('new item is: '+newItem.price)
    //    num=num+1;
    //    console.log('item num is'+num);
                  //allItems.total+newItem.itemPrice;
         // console.log(newItem).itemPrice;
         console.log('your cart ffgfg');
            console.log(allItems.items);
            sum = budgetController.calculateTotal(allItems.items);
            //sum+newItem.price*newItem.quantity;
            allItems.total=sum;
            budgetController
            //allItems.itemNum=num;
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

        removeAllData: function() {
            sum=parseInt(0);
            itemLists = [];
            console.log('empty itemLists'+itemLists);
        },
        
        calculateTotal: function(its){
            var tot=0;
            console.log('ivaar yikuthi');
            console.log('calcualting total for: '+its.length+'items')
            for(q=0; q<its.length; q++){
               tot = tot+ (its[q].price*its[q].quantity);
            }
            return tot;
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


        //Fetch the current item list
        getItemList: function(){
            return itemLists;
        },


        //Delete item selected
        deleteFromList: function(lists, i){
            console.log('passed size: '+lists.length);
            lists.splice(i, 1); 
            console.log('final array size: '+lists.length);
            itemLists.items = lists;
            return lists;
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
        catSize: '.catalogueSize',
        totalField: '#totalField',
        mother: '.cartTableArea',
        clearCart: '.clearCart',
        inputQuant:'.inputQuantitities'
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
     
            console.log('items length :'+obj.items.length);
  //          console.log('item name'+obj.items[0].name);
            
            console.log("clear inner html");

          /*  var para = document.createElement('p');
            para.id = 'tttt'; */
            
            console.log('inner HTMLs');

// to remove all child nodes
document.querySelector(element).innerHTML='';
console.log('fgfgfg now replacing fields');

            
            for(var w=0; w<obj.items.length; w++){
            var itemHtml = '<tr id="'+w+'"> <input type="hidden" name="itemId" value="%id%"> <td><input type="hidden" name="itemName" value="%nameVal%">%name%</td> <td><input type="hidden" name="itemQuantity" value="%quantityVal%">%quantity%</td> <td><input type="hidden" name="itemPrice" value="%priceVal%">%price%</td> <td><button><i class="fa fa-times" aria-hidden="true"></i></button></td></tr>';                
            //td><input type="hidden" name="itemId" value="%id%">%id%</td>    
            // Replace the placeholder text with some actual data
            itemHtml = itemHtml.replace('%id%', obj.items[w].id);
            itemHtml = itemHtml.replace('%nameVal%', obj.items[w].name);
            itemHtml = itemHtml.replace('%quantityVal%', obj.items[w].quantity);
            itemHtml = itemHtml.replace('%priceVal%', obj.items[w].price);
            itemHtml = itemHtml.replace('%totalVal%', obj.items[w].total);            
            itemHtml = itemHtml.replace('%name%', obj.items[w].name);
            itemHtml = itemHtml.replace('%quantity%', obj.items[w].quantity);
            itemHtml = itemHtml.replace('%price%', obj.items[w].price);
            itemHtml = itemHtml.replace('%total%', obj.items[w].total);   
            console.log('item html '+itemHtml);
            document.querySelector(element).insertAdjacentHTML('beforeend', itemHtml);
            }
            
            
        //write total
        
            document.querySelector(DOMstrings.totalField).textContent = obj.total;


            console.log('Done replacind fields');
            
            // Insert the HTML into the DOM            
        },

        removeAllChildren: function(){
            console.log('clearing GUI');
            var nodeElement = DOMstrings.floatContainer;
            // to remove all child nodes
            document.querySelector(nodeElement).innerHTML='';
            document.querySelector(DOMstrings.totalField).textContent ='0';

        },  
        
        
    addListChild: function(obj)     { 
//total = parseInt(document.querySelector(DOMstrings.totalField).value,);
//obj.total
console.log('total is'+obj.total);
var html, newHtml, element;
            // Create HTML string with placeholder text
            
    console.log('Starting to update UI'+DOMstrings.floatContainer);
    element = DOMstrings.floatContainer;
     
    console.log(obj.items[0].quantity);
    console.log('items length :'+obj.items.length);
console.log('8ta');

    //get the table
    var table = document.getElementById("tee");
    
    //get the total field
    var total = document.getElementById("totalField");

    //get itemnum
    var num=obj.itemNum;
 
  for(var i=0; i<obj.items.length; i++){
    //create a row
    var tr = document.createElement('tr');
    
    // add td to row
    var td = tr.appendChild(document.createElement('td'));
  

 //   td.innerHTML = '<input type="hidden" name="itemId" value="'+obj.items[i].id+'">'+obj.items[i].id;
    
//     var td = tr.appendChild(document.createElement('td'));
    
   td.innerHTML = '<input type="hidden" name="itemName" value="'+obj.items[i].name+'">'+obj.items[i].name;
    
     var td = tr.appendChild(document.createElement('td'));
    
    td.innerHTML = '<input type="hidden" name="itemQuantity" value="'+obj.items[i].quantity+'">'+obj.items[i].quantity;

     var td = tr.appendChild(document.createElement('td'));
    
    td.innerHTML ='<input type="hidden" name="itemPrice" value="'+obj.items[i].price+'">'+ obj.items[i].price;
//    var td = obj.items[i].total;
    
//    td.innerHTML = 'eta2';

document.querySelector(DOMstrings.totalField).textContent = obj.total;
        
    console.log('sho');
    
    table.appendChild(tr);  
    };
        
            

},

cleatInput: function(){
    var fields = document.querySelectorAll(DOMstrings.inputQuant);
    var fieldsArray = Array.prototype.slice.call(fields);
    fieldsArray.forEach(function(current, index, array){
        current.value = "";
    }); 
},

 getDOMstrings: function() {
            return DOMstrings;
        }   
    }
    }
            )();




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

        //Setup event listeners for delete buttons
        document.querySelector(DOM.mother).addEventListener('click', myCtrlDeleteItem);
       
        //Setup event listener for clear button
        document.querySelector(DOM.clearCart).addEventListener('click', clearShoppingCart);

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
        UICtrl.addListItem(updatedCart);
        //UICtrl.addListChild(updatedCart);

        //4. Clear input fields
        UICtrl.cleatInput();
        
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
     UICtrl.addListItem(updatedCart);
       //UICtrl.addListChild(updatedCart);

        //4. Clear input fields
        UICtrl.cleatInput();
        
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
        UICtrl.addListItem(updatedCart);
        //UICtrl.addListChild(updatedCart);

        //4. Clear input fields
        UICtrl.cleatInput();
        
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
        UICtrl.addListItem(updatedCart);
        //UICtrl.addListChild(updatedCart);

        //4. Clear input fields
        UICtrl.cleatInput();
        
        if (input.description !== "" && !isNaN(input.value) && input.value > 0) {
        }
    };


    var myCtrlDeleteItem = function(event){

        console.log('remove event parent node id id id: '+event.target.parentNode.parentNode.parentNode.id);
        var itemID = event.target.parentNode.parentNode.parentNode.id;

        //if item id is not empty
        if(itemID){

            console.log('3 times got id rrrrrrffffffff');

            // Delete item from data structure
            var it= budgetCtrl.getItemList();
            console.log('cart size: '+it.length);
            var updatedCartItems = budgetCtrl.deleteFromList(it, itemID);
            console.log('adjective: '+updatedCartItems.length);
            updatedCartItems.total = budgetCtrl.calculateTotal(updatedCartItems);
            
            //Delete item from GUI
            UICtrl.addListItem(updatedCartItems);
        }
    };

    var clearShoppingCart = function(){
        console.log('now clearing cart');

        // Clear Data Structure
        budgetCtrl.removeAllData();

        //Clear GUI
        UICtrl.removeAllChildren();
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