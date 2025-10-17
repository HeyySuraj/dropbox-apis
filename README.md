# Java API Authentication and Data Fetch Example

This project demonstrates how to authenticate using a Bearer token and fetch data from an external API using modern Java (`HttpClient`).
It’s a clean, modular, and beginner-friendly example — suitable for technical assessments and interview demonstrations.

---

## 🚀 Features

* ✅ **Authentication Method** – Simulates token retrieval (can be extended for real APIs).
* 🌐 **HTTP Client** – Uses Java 11+ `HttpClient` for making secure requests.
* 🧩 **Modular Code** – Separate methods for authentication, fetching data, and displaying results.
* ⚙️ **Error Handling** – Gracefully handles IO and network exceptions.
* 💡 **Readable Output** – Uses emojis and clear console messages for better visibility.

---

## 🗂 Project Structure

```
api-auth-example/
├── src/
│   └── ApiClient.java
├── README.md
└── .gitignore
```

---

## 🧠 How It Works

1. **Authenticate** – Simulates an authentication process and returns a dummy token.
2. **Fetch Data** – Sends an HTTP GET request to a sample public API (`https://jsonplaceholder.typicode.com/posts/1`).
3. **Print Response** – Displays the JSON result in the console.

---

## 🧩 Code Overview

```java
String token = authenticate();           // Step 1
String response = fetchData(API_URL, token); // Step 2
printResponse(response);                 // Step 3
```

---

## ⚡ Requirements

* Java 11 or higher
* Internet connection (for API call)

---

## ▶️ How to Run

```bash
# Compile
javac src/ApiClient.java

# Run
java -cp src ApiClient
```

---

## 🧾 Sample Output

```
✅ Authentication successful. Token acquired.

📡 API Response Code: 200

🧾 API Response:
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit suscipit recusandae consequuntur expedita..."
}
```

---

## 🧱 Extend This Project

You can easily enhance this project by:

* Connecting to a real authentication API (e.g., JWT login endpoint).
* Parsing the JSON response using `org.json` or `Gson`.
* Implementing POST/PUT requests.
* Adding unit tests for `authenticate()` and `fetchData()`.

---

## 👨‍💻 Author

**Suraj Bhanarkar**
Full-Stack Developer | MERN & Java Enthusiast
GitHub: [HeyySuraj](https://github.com/HeyySuraj)
