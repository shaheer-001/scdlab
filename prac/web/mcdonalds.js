const product = [
    {
        id: 0,
        image: 'https://www.mcdelivery.com.pk/pk//static/1671482114479/assets/92/products/8438.png?',
        title: 'Spicy McCrispy',
        price: 125,
    },
    {
        id: 1,
        image: 'https://www.mcdelivery.com.pk/pk//static/1671482114479/assets/92/products/8358.png?',
        title: 'Hot n Crispy Burger',
        price: 300,
    },
    {
        id: 2,
        image: 'https://www.mcdelivery.com.pk/pk//static/1671482114479/assets/92/products/1009.png?',
        title: 'Chicken Mac',
        price: 400,
    },
    {
        id: 3,
        image: 'https://www.mcdelivery.com.pk/pk//static/1671482114479/assets/92/products/8229.png?',
        title: 'BBQ Wrap',
        price: 550,
    },
    {
        id: 4,
        image: 'https://www.mcdelivery.com.pk/pk//static/1671482114479/assets/92/products/2219.png?',
        title: '9pcs Spicy Chicken Bucket Meal',
        price: 1000,
    },
    {
        id: 5,
        image: 'https://www.mcdelivery.com.pk/pk//static/1671482114479/assets/92/products/1038.png?',
        title: 'Grand Chicken Spicy',
        price: 600,
    },
    {
        id: 6,
        image: 'https://sp-ao.shortpixel.ai/client/to_webp,q_glossy,ret_img/https://mcdonalds.com.pk/wp-content/uploads/2022/08/04-Double-McChicken-178x178.png',
        title: 'Double McChicken Meal',
        price: 1200,
    },
    {
        id: 7,
        image: 'https://sp-ao.shortpixel.ai/client/to_webp,q_glossy,ret_img/https://mcdonalds.com.pk/wp-content/uploads/2022/08/13-McRoyale-178x178.png',
        title: 'McRoyal Meal',
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