document.addEventListener("DOMContentLoaded", function(){
    window.addEventListener('scroll', function() {
      var navbar_black = document.getElementById('navbar_black');
      var header__content = document.getElementById('header__content');
      var windownHeight = window.screen.height - 100;
        if (window.scrollY < windownHeight) {
          navbar_black.classList.remove('fixed-top');
          header__content.style.marginTop = "0";
        } else {
          navbar_black.classList.add('fixed-top');
          header__content.style.marginTop = "80px";
        } 
    });
  }); 
