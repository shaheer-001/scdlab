

let loginForm = document.querySelector('.login-form');

document.querySelector('#login-btn').onclick = () =>{
    loginForm.classList.toggle('active');
}

let registrationForm = document.querySelector('.registration-form');

document.querySelector('#register').onclick = () =>{
    registrationForm.classList.toggle('active');
}

document.querySelector('#cross').onclick = () =>{
    registrationForm.classList.toggle('active');
}


