
---

# 📦 Dropbox Console API - Java Example

This project demonstrates how to **authenticate with Dropbox using OAuth2** and fetch team information from the Dropbox API using **plain Java (`HttpURLConnection`)**.
It’s a clean, modular, and beginner-friendly example — suitable for technical assessments and interview demonstrations.

---

## 🚀 Features

* ✅ **OAuth2 Authentication** – Generates an access token using a refresh token.
* 🌐 **HTTP Requests** – Uses Java `HttpURLConnection` for secure API calls.
* 🧩 **Modular Code** – Separate services for authentication and fetching team info.
* ⚙️ **Error Handling** – Handles network and API errors gracefully.
* 💡 **Readable Output** – Prints access token and team info clearly in the console.

---

## 🗂 Project Structure

```
dropboxapiconsole/
├── src/main/java/dropbox/api/dropboxapiconsole/
│   ├── DropboxapiconsoleApplication.java
│   └── service/
│       ├── OAuthService.java      # Generates OAuth2 access token
│       └── ApiService.java        # Fetches /2/team/get_info
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md
```

---

## 🧠 How It Works

1. **Authenticate** – `OAuthService` calls Dropbox OAuth2 endpoint using your refresh token and returns an access token.
2. **Fetch Team Info** – `ApiService` calls `/2/team/get_info` with the `Authorization: Bearer <token>` header and **no request body**.
3. **Print Response** – Displays the JSON team info in the console.

---

## 🧩 Code Overview

```java
OAuthService oauthService = context.getBean(OAuthService.class);
ApiService apiService = context.getBean(ApiService.class);

String accessToken = oauthService.generateAccessToken(); // Step 1
System.out.println("Access Token: " + accessToken);

String teamInfo = apiService.getTeamInfo(accessToken);   // Step 2
System.out.println("Team Info:\n" + teamInfo);          // Step 3
```

---

## ⚡ Requirements

* Java 11 or higher
* Spring Boot 3+
* Internet connection (for Dropbox API calls)
* Dropbox App with a valid **Client ID, Client Secret, and Refresh Token**

---

## ▶️ How to Run

1. **Update `application.properties`**

```properties
# OAuth2 Configuration
oauth.authUrl=https://api.dropboxapi.com/oauth2/token
oauth.clientId=YOUR_CLIENT_ID
oauth.clientSecret=YOUR_CLIENT_SECRET
oauth.refreshToken=YOUR_REFRESH_TOKEN

# Dropbox API Base URL
oauth.apiUrl=https://api.dropboxapi.com
```

2. **Build the project**

```bash
mvn clean package
```

3. **Run the application**

```bash
java -jar target/dropboxapiconsole-0.0.1-SNAPSHOT.jar
```

---

## 🧾 Sample Output

```
✅ Access Token Acquired: sl.ABCDEFGHIJKLMNOP

📡 Fetching /2/team/get_info...

🧾 Team Info:
{
  "team": {
    "id": "dbtid:AA...",
    "name": "Example Team",
    "email": "admin@example.com"
  }
}
```

---

## 🧱 Extend This Project

You can easily enhance this project by:

* Connecting to other Dropbox API endpoints (e.g., `/2/team/members/list_v2`).
* Parsing the JSON response using **Gson** or **Jackson**.
* Implementing more OAuth2 workflows (e.g., full token exchange).
* Adding unit tests for `OAuthService` and `ApiService`.

---

## 👨‍💻 Author

**Suraj Bhanarkar**
Full-Stack Developer | Java & MERN Enthusiast
GitHub: [HeyySuraj](https://github.com/HeyySuraj)


