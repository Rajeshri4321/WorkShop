class book{
    constructor(name,publisher,price)
    {
        this.name=name;
        this.publisher=publisher;
        this.price=price;
    }
}
var arrayofBook=[];
// const book1=new book('EMMA','Nimmati',500);arrayofBook.push(book1);

function addBook()
{
  let name=document.getElementById("bnm").value;
  let publisher=document.getElementById("pb").value;
  let price=document.getElementById("bp").value;
  const book1=new book(name,publisher,price);
  arrayofBook.push(book1);
  console.log("book"+name+" price"+price+" publisher "+publisher);

}