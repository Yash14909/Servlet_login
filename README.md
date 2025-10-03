

# 📘 Servlet Dispatcher Example

This project demonstrates the use of **`RequestDispatcher`** in **Jakarta Servlets** to handle **forwarding** and **including** resources.

It contains two servlets:

1. **CallServlet** → Handles login validation and dispatches requests (forward/include).
2. **FwdDemo** → Displays a welcome message when login is successful.

---

## 🚀 Project Structure

```
dispatcher/
│
├── CallServlet.java     # Handles login authentication
├── FwdDemo.java         # Displays welcome message after successful login
└── webapp/
    ├── 1.html           # Login form
    └── WEB-INF/
        └── web.xml      # (optional if not using annotations)
```

---

## 📂 Code Overview

### 1. **CallServlet.java**

* Mapped to a URL (example: `/CallServlet`).
* Accepts **username (`login`)** and **password (`pwd`)** from a login form.
* If login = `"java"` and password = `"servlet"` → forwards request to `FwdDemo`.
* Else → shows an error message and includes `1.html` back into the response.

Key logic:

```java
if("java".equals(login) && "servlet".equals(pwd)) {
    rd = request.getRequestDispatcher("FwdDemo");
    rd.forward(request, response);
} else {
    out.println("<h1>Incorrect Login ID / Password</h1>");
    rd = request.getRequestDispatcher("/1.html");
    rd.include(request, response);
}
```

---

### 2. **FwdDemo.java**

* Receives the forwarded request from `CallServlet`.
* Extracts the `login` parameter and displays a personalized welcome message.

Example:

```java
String username = request.getParameter("login");
out.println("<h1>Welcome to servlets : " + username + "</h1>");
```

---

### 3. **1.html** (Login Form)

A simple form that collects **login ID** and **password** and posts them to `CallServlet`.

```html
<!DOCTYPE html>
<html>
<head>
  <title>Login Form</title>
</head>
<body>
  <form action="CallServlet" method="post">
    <label>Login ID:</label>
    <input type="text" name="login"><br><br>
    <label>Password:</label>
    <input type="password" name="pwd"><br><br>
    <input type="submit" value="Login">
  </form>
</body>
</html>
```

---

## 🛠️ How to Run

1. **Setup Environment**

   * Install **Java 11+** and **Apache Tomcat (Jakarta EE compatible)**.
   * Set up your IDE (Eclipse, IntelliJ, or VS Code).

2. **Deploy the Servlets**

   * Place `.java` files under `src/main/java/dispatcher/`.
   * Place `1.html` in `src/main/webapp/`.
   * Add servlet annotations:

     ```java
     @WebServlet("/CallServlet")
     @WebServlet("/FwdDemo")
     ```
   * (Optional) Define mappings in `web.xml` if not using annotations.

3. **Start Tomcat**

   * Deploy the project to Tomcat.
   * Access in browser:

     ```
     http://localhost:8080/<your-project-name>/1.html
     ```

4. **Test**

   * Login with:

     * **Username:** `java`
     * **Password:** `servlet`
   * On success → You’ll be forwarded to `FwdDemo`.
   * On failure → You’ll see an error message and the login page again.

---

## 📖 Concepts Demonstrated

* **RequestDispatcher**

  * `forward(request, response)` → transfers control to another resource (servlet/JSP/HTML).
  * `include(request, response)` → includes content of another resource in the response.

* **Servlet Chaining** (CallServlet → FwdDemo).

* **Form Handling** (via POST request).

---

## ✅ Expected Output

* Successful login → `Welcome to servlets : java`
* Failed login → `Incorrect Login ID / Password` + reloads login form.

---...
