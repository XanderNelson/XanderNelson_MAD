var database = firebase.firestore();
var docRef = database.collection("wishList");
var firstSearch;
var secondSearch;
var lowFirst;
var lowLast;

$(document).ready(function(){
  var list = $("#list");

  function showList(){
    firstSearch = $("#firstName").val().toLowerCase();
    secondSearch = $("#lastName").val().toLowerCase();

    database.collection("wishList").onSnapshot(function(querySnapshot){
      list.text("");
      querySnapshot.forEach(function(doc){
        var firstname = doc.data().FIRSTNAME;
        var lastname = doc.data().LASTNAME;
        var item = doc.data().ITEM;
        var link = doc.data().LINK;
        var price = doc.data().PRICE;
        var desire = doc.data().DESIRE;

        lowFirst = firstname.toLowerCase();
        lowLast = lastname.toLowerCase();
        // console.log(firstSearch);
        // console.log(secondSearch);
        // console.log(lowFirst);
        // console.log(lowLast);

        // var comp = lowFirst.localeCompare(firstSearch);
        // console.log(comp);
        if(lowFirst.trim() === firstSearch.trim() && lowLast.trim() === secondSearch.trim())
        {
          console.log("hit");
          list.append("<span class='nameList'><p><b>NAME:</b> " + firstname + " " + lastname + "<br><b>ITEM: </b>" + item + "<br><b>ITEM LINK: </b>" + link + "<br><b>PRICE: </b>" + price + "<br><b>DESIRE(1-5): </b>" + desire + "</p><br>");
        }
        // nameSort(lowFirst, lowLast, item, link, price, desire);
      });

    });
  }

  function nameSort(a, b, c, d, e, f){
    // a.toString();
    // firstSearch.toString();
    // console.log(a);
    // console.log(firstSearch);

    // var comp = a.localeCompare(firstSearch);
    // console.log(comp);
    var list = $("#list");
    if(a.trim() === firstSearch.trim() && b.trim() === secondSearch){
      console.log("hit");
      list.append("<span class='nameList'><p><b>NAME:</b> " + firstname + lastname + link + price + desire + " -- <b>ITEM: </b>" + item + "</p><br>");
    }
  }

  $("#seeList").click(function(event){
    console.log("clicked");
    showList();
    event.preventDefault();
  });
});
