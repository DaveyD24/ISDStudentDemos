class Header extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `    <div class="header">
        <div class="logo">
            <img src="image/polaroid.jpg"/>
            <p>DAVEYS RECORD STORE</p>
        </div>
        <ul class="items">
            <a href="index.jsp"><li>HOME</li></a>
            <a href="register.jsp"><li>REGISTER</li></a>
            <li>ABOUT</li>
            <li>CONTACT</li>
            <li><img src="image/search.svg"/></li>
        </ul>
    </div>
    <div id="twice"></div>`;
    }
}

class Footer extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `<div class="footer">STYLESHEET NOT TO BE USED IN ASSESSED SUBMISSIONS</div>`;
    }
}

customElements.define("pref-header", Header);
customElements.define("pref-footer", Footer);