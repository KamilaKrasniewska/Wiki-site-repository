const signinApiEndpoint = 'http://localhost:8765/users/signin';
const signupApiEndpoint = 'http://localhost:8765/users/signup';

// Function to sign in a user
function signinUser(event) {
    event.preventDefault();

    var username = document.getElementById("signin-username").value;
    var password = document.getElementById("signin-password").value;



    var requestBody = {
        username: username,
        password: password
    };

    fetch(signinApiEndpoint, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestBody)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Sign in failed');
            }
        })
        .then(user => {
            alert("Sign in successful!");
            // Save the user's email in the local storage
            localStorage.setItem("userEmail", user.email);
            window.location.href = `/userprofile.html?id=${user.id}`;
        })

        .catch(error => {
            console.error('Error:', error);
            alert(error.message);
        });
}

// Function to sign up a new user
function signupUser(event) {
    event.preventDefault();

    var username = document.getElementById("signup-username").value;
    var email = document.getElementById("signup-email").value;
   /* var password = document.getElementById("signup-password").value;*/

    var requestBody = {
        username: username,
        password: password,
       /* email: email*/
    };

    fetch(signupApiEndpoint, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestBody)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Sign up failed');
            }
        })
        .then(user => {
            alert("Sign up successful!");
            window.location.href = `/userprofile.html?id=${user.id}`;
        })
        .catch(error => {
            console.error('Error:', error);
            alert(error.message);
        });
}


document.querySelector("#signin-form").addEventListener("submit", signinUser);
document.querySelector("#signup-form").addEventListener("submit", signupUser);


