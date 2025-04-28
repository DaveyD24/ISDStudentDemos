<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" href="style.css">
  <script src="js/CustomElements.js"></script>
</head>
<body>
<pref-header></pref-header>

<div class="content">
  <div class="main-header">
    <h1>REGISTER HERE</h1>
    <p>SIGN UP FOR EXCLUSIVE DEALS</p>
  </div>
  <div class="main-content">
    <form action="/RegisterServlet" method="post">
      <label for="email">EMAIL</label>
      <input id="email" name="email" type="text" placeholder="example@example.com"/>
      <label for="password">PASSWORD</label>
      <input id="password" name="password" type="password" placeholder="Use a strong password"/>
      <label for="genre">FAVOURITE GENRE</label>
      <select name="genre" id="genre">
        <option value="Kpop">Kpop</option>
        <option value="Hardstyle">Hardstyle</option>
        <option value="Trash">Trash</option>
      </select>
      <br>
      <label for="tos">Agree to our <span style="color: dodgerblue; cursor: pointer">Terms of Service</span></label>
      <input type="checkbox" id="tos" name="tos">
      <br>
      <input id="reg" type="submit" value="Register">
    </form>
  </div>
</div>
<pref-footer></pref-footer>
</body>
</html>
