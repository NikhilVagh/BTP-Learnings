/*~~~~~~~~~~~~~~~ TOGGLE BUTTON ~~~~~~~~~~~~~~~*/
const hamburger = document.getElementById("hamburger");
const navMenu = document.getElementById("nav-menu");
const closeIcon = document.getElementById("close");
const navLink = document.querySelectorAll(".nav__link");

navLink.forEach((link) =>
  link.addEventListener("click", () => {
    navMenu.classList.add("hidden");
  })
);

closeIcon.addEventListener("click", () => {
  navMenu.classList.add("hidden");
});

hamburger.addEventListener("click", () => {
  navMenu.classList.remove("hidden");
});

/*~~~~~~~~~~~~~~~ TABS ~~~~~~~~~~~~~~~*/
const tabs = document.querySelectorAll(".tabs_wrap ul li");
const all = document.querySelectorAll(".item_wrap");
const foods = document.querySelectorAll(".food");
const beverages = document.querySelectorAll(".beverage");
const snacks = document.querySelectorAll(".snack");



tabs.forEach((tab) => {
  tab.addEventListener("click", () => {
    tabs.forEach((tab) => {
      tab.classList.remove("active");
    });

    tab.classList.add("active");

    const tabval = tab.getAttribute("data-tabs");
    // console.log(tabval);

    all.forEach((item) => {
      item.style.display = 'none';
    })

    if (tabval == 'food') {
      foods.forEach((item) => {
        item.style.display = 'block';
      })
    }
    else if (tabval == 'snack') {
      snacks.forEach((item) => {
        item.style.display = 'block';
      })
    }
    else if (tabval == 'beverage') {
      beverages.forEach((item) => {
        item.style.display = 'block';
      })
    }
    else {
      all.forEach((item) => {
        item.style.display = 'block';
      })
    }




  });
});

/*~~~~~~~~~~~~~~~ DARK LIGHT THEME ~~~~~~~~~~~~~~~*/
const html = document.querySelector('html');
const themeBtn = document.getElementById('theme-toggle');

const darkMode = () => {
  html.classList.add('dark');
  themeBtn.classList.replace('ri-moon-line', 'ri-sun-line');
  localStorage.setItem("mode", "dark");
}

const lightMode = () => {
  html.classList.remove('dark');
  themeBtn.classList.replace('ri-sun-line', 'ri-moon-line');
  localStorage.setItem("mode", "light");
}
if (localStorage.getItem("mode") == "dark") {
  darkMode();
}

themeBtn.addEventListener('click', (e) => {
  if (localStorage.getItem('mode') == "light") {
    darkMode();
  }
  else {
    lightMode();
  }
})

/*~~~~~~~~~~~~~~~ SHOW SCROLL UP ~~~~~~~~~~~~~~~*/
const scrollUp = () => {
  const scrollUpBtn = document.getElementById("scroll-up");
  if (this.scrollY >= 250) {
    scrollUpBtn.classList.remove("-bottom-1/2");
    scrollUpBtn.classList.add("bottom-4");
  } else {
    scrollUpBtn.classList.add("-bottom-1/2");
    scrollUpBtn.classList.remove("bottom-4");
  }
}
window.addEventListener('scroll', scrollUp);

/*~~~~~~~~~~~~~~~ CHANGE BACKGROUND HEADER ~~~~~~~~~~~~~~~*/
const scrollHeader = () => {
  const header = document.getElementById("header");
  if (this.scrollY >= 50) {
    header.classList.add("border-b", "border-secondaryColor");
  } else {
    header.classList.remove("border-b", "border-secondaryColor");
  }
}
window.addEventListener('scroll', scrollHeader);

/*~~~~~~~~~~~~~~~ SCROLL SECTIONS ACTIVE LINK ~~~~~~~~~~~~~~~*/

const activeLink = () => {
  const sections = document.querySelectorAll('section');
  const navLinks = document.querySelectorAll('.nav__link');

  let currunt = 'home';

  sections.forEach((section) => {
    const sectionTop = section.offsetTop;

    if (this.scrollY >= sectionTop - 60) {
      currunt = section.getAttribute('id');
    }
  })

  navLinks.forEach((item) => {
    item.classList.remove('text-secondaryColor');
    if (item.href.includes(currunt)) {
      item.classList.add('text-secondaryColor');

    }
  });
};

window.addEventListener('scroll',activeLink);

/*~~~~~~~~~~~~~~~ SCROLL REVEAL ANIMATION ~~~~~~~~~~~~~~~*/
