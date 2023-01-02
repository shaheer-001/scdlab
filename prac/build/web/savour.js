/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const product = [
    {
        id: 0,
        image: 'https://order.savourfoods.com.pk/_next/image?url=https%3A%2F%2Fem-cdn.eatmubarak.pk%2F55324%2Fdish_image%2F1664201755.jpg&w=1920&q=90',
        title: 'Shami Kabab',
        price: 35,
    },
    {
        id: 1,
        image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVXZnmzDvhEDL_YKq9I-SsZDpSDglIfpbWeQ&usqp=CAU',
        title: 'Single Platter',
        price: 375,
    },
    {
        id: 2,
        image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRnrTzvtziWdqfGewqMPEcxem5Zn5mWaG1vI6NDczoWtiKcKhFpdfQHUnd4rEOlcomg6g&usqp=CAU',
        title: 'Special ',
        price: 480,
    },
    {
        id: 3,
        image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVXZnmzDvhEDL_YKq9I-SsZDpSDglIfpbWeQ&usqp=CAU',
        title: 'Single Choice Platter',
        price: 380,
    },
    {
        id: 4,
        image: 'https://em-cdn.eatmubarak.pk/55324/dish_image/1663844557.jpg',
        title: 'Pulao Kabab',
        price: 310,
    },
    {
        id: 5,
        image: 'https://order.savourfoods.com.pk/_next/image?url=https%3A%2F%2Fem-cdn.eatmubarak.pk%2F55324%2Fdish_image%2F1663843451.jpg&w=1920&q=90',
        title: 'Pulao',
        price: 205,
    },
    {
        id: 6,
        image: 'https://order.savourfoods.com.pk/_next/image?url=https%3A%2F%2Fem-cdn.eatmubarak.pk%2F55324%2Fdish_image%2F1663841553.jpg&w=1920&q=90',
        title: 'Single Picnic Pack',
        price: 400,
    },
    {
        id: 7,
        image: 'https://order.savourfoods.com.pk/_next/image?url=https%3A%2F%2Fem-cdn.eatmubarak.pk%2F55324%2Fdish_image%2F1663843358.jpg&w=1920&q=90',
        title: 'Special Picnic Pack',
        price: 500,
    },
    {
        id: 8,
        image: 'https://order.savourfoods.com.pk/_next/image?url=https%3A%2F%2Fem-cdn.eatmubarak.pk%2F55324%2Fdish_image%2F1663842876.jpg&w=1920&q=90',
        title: 'Special choice',
        price: 1500,
    }
];
const categories = [...new Set(product.map((item)=>
    {return item}))]
    let i=0;
document.getElementById('root').innerHTML = categories.map((item)=>
{
    var {image, title, price} = item;
    return(
        `<div class='box'>
            <div class='img-box'>
                <img class='images' src=${image}></img>
            </div>
        <div class='bottom'>
        <p>${title}</p>
        <h2>Rs. ${price}.00</h2>`+
        "<btn onclick='addtocart("+(i++)+")'>Add to cart</btn>"+
        `</div>
        </div>`
    )
}).join('')

var cart =[];

function addtocart(a){
    cart.push({...categories[a]});
    displaycart();
}
function delElement(a){
    cart.splice(a, 1);
    displaycart();
}

function displaycart(){
    let j = 0, total=0;
    document.getElementById("count").innerHTML=cart.length;
    if(cart.length==0){
        document.getElementById('cartItem').innerHTML = "Your cart is empty";
        document.getElementById("total").innerHTML = "Rs. "+0+".00";
    }
    else{
        document.getElementById("cartItem").innerHTML = cart.map((items)=>
        {
            var {image, title, price} = items;
            total=total+price;
            document.getElementById("total").innerHTML = "Rs. "+total+".00";
            return(
                `<div class='cart-item'>
                <div class='row-img'>
                    <img class='rowimg' src=${image}>
                </div>
                <p style='font-size:12px;'>${title}</p>
                <h2 style='font-size: 15px;'>Rs. ${price}.00</h2>`+
                "<i class='fa-solid fa-trash' onclick='delElement("+ (j++) +")'></i></div>"
            );
        }).join('');
    }

    
}

