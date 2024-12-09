function sayHello(){
    const currentUser = JSON.parse(localStorage.getItem("currentUser"));
    alert(`Hello ${currentUser.name}`);
}
