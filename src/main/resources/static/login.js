/*
// API endpoint where login requests are sent
const loginApiEndpoint = 'http://localhost:8765/login';

// Function to log in a user
async function loginUser(event) {
    try {
        // Prevent the form from being submitted normally
        event.preventDefault();

        // Get the username and password from the form
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        // Create the request body
        var requestBody = {
            username: username,
            password: password
        };

        // Send a POST request to the login API endpoint
        const response = await fetch(loginApiEndpoint, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(requestBody)
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();

        if (data.status === 'success') {
            alert(data.message);
            window.location.href = '/home'; // Or wherever you want to redirect the user to
        } else {
            throw new Error(data.message);
        }
    } catch (error) {
        console.error('Error:', error);
        alert(error.message);
    }
}

// Attach the loginUser function to the form's submit event
document.getElementById("loginForm").addEventListener("submit", loginUser);

*/
